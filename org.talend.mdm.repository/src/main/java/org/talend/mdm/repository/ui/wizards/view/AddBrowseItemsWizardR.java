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

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.ui.actions.view.NewViewAction;

import com.amalto.workbench.dialogs.AddBrowseItemsWizard;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class AddBrowseItemsWizardR extends AddBrowseItemsWizard {

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
        for (XSDElementDeclaration decl : declList) {
            String fullName = BROWSE_ITEMS + decl.getName();
            if (fullName.equals(browseItem)) {
                newViewAction.setXSDElementDeclaration(decl);
                newViewAction.createNewView(fullName);
            }
        }
    }

}
