// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CreateFolderAction extends AbstractRepositoryAction {

    /**
     * DOC hbhong CreateFolderAction constructor comment.
     * 
     * @param text
     */
    public CreateFolderAction() {
        super("Create Cagegory");
        setImageDescriptor(ImageCache.getImage(EImage.COMPRESSED_FOLDER_OBJ.getPath()));
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    public void run() {
        Object object = getSelectedObject().get(0);
        if (object != null && object instanceof ContainerRepositoryObject) {
            final ContainerRepositoryObject containerViewObject = (ContainerRepositoryObject) object;
            InputDialog dlg = new InputDialog(getShell(), "New Category",
                    "Enter a name for the New Category", null, new IInputValidator() {

                        public String isValid(String newText) {
                            if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                                return "The Name cannot be empty";
                            Pattern p = Pattern.compile("([\\s*|\\W*]+)");//$NON-NLS-1$ 
                            Matcher m = p.matcher(newText);
                            if (m.find()) {
                                m.group(1);
                                return "The name cannot contains invalid character!";
                            }
                            for (IRepositoryViewObject viewObj : containerViewObject.getChildren()) {
                                Item item = viewObj.getProperty().getItem();
                                if (item instanceof ContainerItem) {
                                    if (((ContainerItem) item).getLabel().equals(newText))
                                        return "The name is being used !";
                                }
                            }
                            return null;
                        };
                    });
            dlg.setBlockOnOpen(true);
            if (dlg.open() == Window.CANCEL)
                return;
            String categoryName = dlg.getValue();
            //

            IRepositoryViewObject folderViewObject = RepositoryResourceUtil.createFolderViewObject(
                    containerViewObject.getRepositoryObjectType(), categoryName, containerViewObject.getProperty().getItem(),
                    false);
            containerViewObject.getChildren().add(folderViewObject);
            commonViewer.expandToLevel(containerViewObject, 1);
            // commonViewer.refresh(folderViewObject);
        }
    }
}
