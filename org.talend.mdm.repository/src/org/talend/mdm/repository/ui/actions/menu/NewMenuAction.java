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
package org.talend.mdm.repository.ui.actions.menu;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSMenuItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewMenuAction extends AbstractRepositoryAction {

    /**
     * DOC hbhong AddMenu constructor comment.
     * 
     * @param text
     */
    public NewMenuAction() {
        super("New");
        setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
    }

    @Override
    public void run() {
        InputDialog dlg = new InputDialog(commonViewer.getControl().getShell(), "New Menu",// "New "+IConstants.TALEND+" Object Instance",
                "Enter a Name for the New Instance", null, new IInputValidator() {

                    public String isValid(String newText) {
                        if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                            return "The Name cannot be empty";
                        if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                            return "The name cannot contain invalid character!";
                        }
                        return null;
                    };
                });
        dlg.setBlockOnOpen(true);
        if (dlg.open() == Window.CANCEL)
            return;
        String key = dlg.getValue();
        createMenu(key);
        commonViewer.refresh();
        // TODO open editor

    }

    private WSMenuE newBlankMenu(String key) {

        WSMenuMenuEntriesDescriptionsE descriptions = MdmserverobjectFactory.eINSTANCE.createWSMenuMenuEntriesDescriptionsE();
        descriptions.setLabel(key);
        descriptions.setLanguage("en"); //$NON-NLS-1$
        //

        WSMenuEntryE entry = MdmserverobjectFactory.eINSTANCE.createWSMenuEntryE();
        entry.getDescriptions().add(descriptions);
        entry.setId(key);
        //
        WSMenuE menu = MdmserverobjectFactory.eINSTANCE.createWSMenuE();
        menu.setName(key);
        menu.getMenuEntries().add(entry);
        //
        return menu;
    }

    private boolean createMenu(String key) {
        WSMenuItem item = MdmpropertiesFactory.eINSTANCE.createWSMenuItem();
        WSMenuE menu = newBlankMenu(key);
        item.setWsMenu(menu);
        
        return RepositoryResourceUtil.createItem(item,key);
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

}
