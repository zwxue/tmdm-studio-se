// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.wizards.view;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorReference;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.ui.actions.view.NewViewAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.dialogs.AddBrowseItemsWizard;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class AddBrowseItemsWizardR extends AddBrowseItemsWizard {

    static Logger log = Logger.getLogger(AddBrowseItemsWizardR.class);

    /**
     * DOC hbhong AddBrowseItemsWizardR constructor comment.
     * 
     * @param launchPage
     * @param list
     */
    public AddBrowseItemsWizardR(DataModelMainPage launchPage) {
        super(launchPage);
    }

    @Override
    protected List<String> getAllRoleNames() {
        return RepositoryQueryService.findAllRoleNames();
    }

    @Override
    protected void modifyRolesWithAttachedBrowseItem(String browseItem, List<Line> roles) throws RemoteException {
        for (Line line : roles) {
            List<KeyValue> keyValues = line.keyValues;
            String roleName = keyValues.get(0).value;
            MDMServerObjectItem roleItem = RepositoryQueryService.findServerObjectItemByName(
                    IServerObjectRepositoryType.TYPE_ROLE, roleName);
            CommandManager.getInstance().pushCommand(ICommand.CMD_MODIFY, roleItem.getProperty().getId(),
                    roleItem.getMDMServerObject().getName());

            if (roleItem != null) {
                IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
                if (factory.isEditableAndLockIfPossible(roleItem)) {
                    WSRoleE role = ((WSRoleItem) roleItem).getWsRole();
                    for (WSRoleSpecificationE spec : role.getSpecification()) {
                        if (spec.getObjectType().equals("View")) {//$NON-NLS-1$
                            EList<WSRoleSpecificationInstanceE> specInstance = spec.getInstance();
                            //
                            WSRoleSpecificationInstanceE newInstance = MdmserverobjectFactory.eINSTANCE
                                    .createWSRoleSpecificationInstanceE();
                            newInstance.setInstanceName(browseItem);
                            newInstance.setWritable(keyValues.get(1).value.equals("Read Only") ? false : true);//$NON-NLS-1$
                            //
                            specInstance.add(newInstance);
                            //
                            break;
                        }
                    }
                    RepositoryResourceUtil.saveItem(roleItem);

                }
                try {
                    factory.unlock(roleItem);
                } catch (PersistenceException e) {
                    log.error(e.getMessage(), e);
                } catch (LoginException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    NewViewAction newViewAction = new NewViewAction() {

        @Override
        protected WSViewE newView(String viewName) {
            WSBooleanE wsBool = MdmserverobjectFactory.eINSTANCE.createWSBooleanE();
            wsBool.set_true(false);

            WSViewE view = MdmserverobjectFactory.eINSTANCE.createWSViewE();
            view.setName(viewName);
            // description
            StringBuffer desc = new StringBuffer();
            LinkedHashMap<String, String> labels = new LinkedHashMap<String, String>();
            XSDElementDeclaration decl = getXSDElementDeclaration();
            if (decl.getAnnotation() != null)
                labels = new XSDAnnotationsStructure(decl.getAnnotation()).getLabels();
            if (labels.size() == 0)
                labels.put("EN", decl.getName());//$NON-NLS-1$
            for (String lan : labels.keySet()) {
                desc.append("[" + lan.toUpperCase() + ":" + labels.get(lan) + "]");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            }
            view.setDescription(desc.toString());

            //
            view.setTransformerPK(""); //$NON-NLS-1$
            view.setIsTransformerActive(wsBool);
            // SearchableBusinessElements & ViewableBusinessElements
            List<String> keys = new ArrayList<String>();
            for (XSDIdentityConstraintDefinition idty : decl.getIdentityConstraintDefinitions()) {
                EList<XSDXPathDefinition> xpathList = idty.getFields();
                for (XSDXPathDefinition path : xpathList) {
                    String key = decl.getName();
                    // remove
                    key = key.replaceFirst("#.*", "");//$NON-NLS-1$//$NON-NLS-2$
                    key += "/" + path.getValue();//$NON-NLS-1$
                    keys.add(key);
                }

            }
            view.getSearchableBusinessElements().addAll(keys);
            view.getViewableBusinessElements().addAll(keys);
            //
            return view;
        }

    };

    @Override
    protected void newBrowseItemView(String browseItem) throws RemoteException {
        IRepositoryViewObject viewObject = RepositoryResourceUtil.findViewObjectByName(IServerObjectRepositoryType.TYPE_VIEW,
                browseItem);
        if (viewObject != null) {
            
            IEditorReference ref = RepositoryResourceUtil.isOpenedInEditor((IRepositoryViewObject) viewObject);
            if(ref != null) 
            {
                boolean ok = MessageDialog.openConfirm(this.getShell(), Messages.AddBrowseItemsWizardR_warning,
                        Messages.AddBrowseItemsWizardR_duplicatedView);
                if (!ok)
                    return;
                
                // delete the existed browse view
                RepositoryResourceUtil.closeEditor(ref, false);
            }
            
            try {
                ProxyRepositoryFactory.getInstance().deleteObjectPhysical(viewObject);
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
                RemoteException rx = new RemoteException(e.getMessage());
                throw rx;
            }
        }

        for (XSDElementDeclaration decl : declList) {
            String fullName = BROWSE_ITEMS + decl.getName();
            if (fullName.equals(browseItem)) {
                newViewAction.setXSDElementDeclaration(decl);
                newViewAction.createNewView(fullName);
            }
        }
    }

}
