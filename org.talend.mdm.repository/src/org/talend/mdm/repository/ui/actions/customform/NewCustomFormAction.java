// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend �C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.customform;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSCustomFormE;
import org.talend.mdm.repository.models.CustomFormElement;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.wizards.customform.NewCustomformWizard;
import org.talend.mdm.repository.utils.CustomFormUtil;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewCustomFormAction extends AbstractSimpleAddAction {

    Logger log = Logger.getLogger(NewCustomFormAction.class);

    /**
     * DOC AddProcess constructor comment.
     * 
     * @param text
     */
    public NewCustomFormAction() {
        super();
    }

    protected String getDialogTitle() {
        return Messages.NewCustomFormAction_title;
    }

    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }
        IWorkbenchPartSite site = commonViewer.getCommonNavigator().getSite();
        NewCustomformWizard wizard = new NewCustomformWizard(site, getDialogTitle(),

        new IInputValidator() {

            public String isValid(String newText) {
                if (newText == null || newText.trim().length() == 0)
                    return Messages.Common_nameCanNotBeEmpty;
                if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                    return Messages.Common_nameInvalid;
                }
                if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), newText.trim())) {
                    return Messages.Common_nameIsUsed;
                }
                return null;
            };
        });
        WizardDialog dlg = new WizardDialog(getShell(), wizard);
        if (dlg.open() == Window.CANCEL)
            return;
        String formName = wizard.getFormName();
        String dataModelName = wizard.getDataModelName();
        String entityName = wizard.getEntityName();
        String role = wizard.getRole();
        int columnCount = wizard.getColumnCount();
        List<CustomFormElement> allElements = wizard.getAllElements();
        CustomFormElement ancestor = wizard.getAncestor();

        IFolder folder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_CUSTOM_FORM, parentItem);
        try {
            IFile formFile = createFormFile(folder,
                    formName + "_" + VersionUtils.DEFAULT_VERSION + ".form", dataModelName + "." + entityName, columnCount, allElements, ancestor); //$NON-NLS-1$ //$NON-NLS-2$
            createServerObject(formName, dataModelName, entityName, role, formFile);
            commonViewer.refresh(selectObj);
            commonViewer.expandToLevel(selectObj, 1);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }

    }

    CustomFormUtil customFormUtil = new CustomFormUtil();
    private IFile createFormFile(IFolder folder, String formName, String title, int columnCount,
            List<CustomFormElement> allElements, CustomFormElement ancestor) throws UnsupportedEncodingException, CoreException {
        IFile file = folder.getFile(formName);
        // create blank diagram
        // String content = tmp1 + title + tmp2;
        // if (!file.exists())
        //            file.create(new ByteArrayInputStream(content.getBytes("utf-8")), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
        // else
        //            file.setContents(new ByteArrayInputStream(content.getBytes("utf-8")), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
        // create diagram via init data
        customFormUtil.createDomainModel(file, title, allElements, ancestor, columnCount);
        return file;
    }

    private WSCustomFormE newCustomForm(String formName, String dataModelName, String entityName, String role, String fileName) {
        WSCustomFormE form = MdmserverobjectFactory.eINSTANCE.createWSCustomFormE();
        form.setName(formName);
        form.setFilename(fileName);
        form.setDatamodel(dataModelName);
        form.setEntity(entityName);
        form.setRole(role);
        return form;
    }

    protected boolean createServerObject(String formName, String dataModelName, String entityName, String role, IFile file) {

        WSCustomFormItem item = MdmpropertiesFactory.eINSTANCE.createWSCustomFormItem();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSCustomFormE form = newCustomForm(formName, dataModelName, entityName, role, file.getName());
        item.setCustomForm(form);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, formName);
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction#createServerObject(java.lang.String)
     */
    @Override
    protected boolean createServerObject(String key) {
        return false;
    }

    // String tmp1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
    // +
    // "<pi:Diagram xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:al=\"http://eclipse.org/graphiti/mm/algorithms\" xmlns:pi=\"http://eclipse.org/graphiti/mm/pictograms\" visible=\"true\" gridUnit=\"10\" diagramTypeId=\"mdmform\" name=\"";
    //
    // String tmp2 = "\" snapToGrid=\"true\" showGuides=\"true\">"
    // +
    // "<graphicsAlgorithm xsi:type=\"al:Rectangle\" background=\"//@colors.1\" foreground=\"//@colors.0\" lineWidth=\"1\" transparency=\"0.0\" width=\"1000\" height=\"1000\"/><colors red=\"227\" green=\"238\" blue=\"249\"/><colors red=\"255\" green=\"255\" blue=\"255\"/></pi:Diagram>";

}
