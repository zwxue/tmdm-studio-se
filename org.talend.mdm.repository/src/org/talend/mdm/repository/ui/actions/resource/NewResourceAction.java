// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
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
package org.talend.mdm.repository.ui.actions.resource;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.dialogs.FileInputDialog;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewResourceAction extends AbstractSimpleAddAction {

    static Logger log = Logger.getLogger(NewResourceAction.class);

    String[] fileExtensions = new String[] { "*.png", "*.gif", "*.jpg" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    public NewResourceAction() {
        super();
    }

    @Override
    protected String getDialogTitle() {
        return "New Resource";
    }

    private WSResourceE newResource(IFile file) {
        WSResourceE resource = MdmserverobjectFactory.eINSTANCE.createWSResourceE();
        String fileName = file.getName();
        int index = fileName.lastIndexOf("_"); //$NON-NLS-1$
        if (index > 0) {
            fileName = fileName.substring(0, index);
        }

        resource.setName(fileName);
        resource.setFileExtension(file.getFileExtension());
        resource.setDescription(""); //$NON-NLS-1$

        return resource;
    }

    @Override
    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }
        FileInputDialog dialog = new FileInputDialog(getShell(), getDialogTitle(), "Please select a picture file.",
                fileExtensions, new IInputValidator() {

                    public String isValid(String newText) {
                        if (newText == null || newText.trim().length() == 0)
                            return Messages.Common_nameCanNotBeEmpty;

                        // if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), file.getName())) {
                        // return Messages.Common_nameIsUsed;
                        // }
                        return null;
                    };
                });
        dialog.setBlockOnOpen(true);
        if (dialog.open() == IDialogConstants.OK_ID) {

            String filePath = dialog.getFilePath();
            File sourceFile = new File(filePath);
            String fileName = RepositoryResourceUtil.getVersionFileName(sourceFile, null);
            IFolder folder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_RESOURCE, parentItem);
            IFile findFile = folder.getFile(fileName);
            if (findFile.exists()) {
                copyFile(parentItem, filePath);
                // TODO update changed prop
                return;
            } else {
                IFile file = copyFile(parentItem, filePath);
                if (file != null) {
                    createServerObject(file);
                }
            }

        }
    }

    private IFile copyFile(Item item, String filePath) {
        IFolder desFolder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_RESOURCE, item);
        try {
            IFile file = RepositoryResourceUtil.copyOSFileTOProject(null, filePath, desFolder, null, true,
                    new NullProgressMonitor());
            return file;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected boolean createServerObject(String key) {
        return false;
    }

    protected boolean createServerObject(IFile file) {

        WSResourceItem item = MdmpropertiesFactory.eINSTANCE.createWSResourceItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSResourceE resource = newResource(file);
        item.setResource(resource);
        item.getState().setPath(parentItem != null ? parentItem.getState().getPath() : ""); //$NON-NLS-1$

        boolean result = RepositoryResourceUtil.createItem(item, resource.getName(), VersionUtils.DEFAULT_VERSION);
        if (result) {
            refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_RESOURCE);
        }
        return result;
    }
}
