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
package org.talend.mdm.repository.ui.actions;

import org.talend.mdm.repository.core.AbstractRepositoryAction;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ExportObjectAction extends AbstractRepositoryAction {

    /**
     * DOC hbhong AddMenu constructor comment.
     * 
     * @param text
     */
    public ExportObjectAction() {
        super("Export"); //$NON-NLS-1$
        setImageDescriptor(ImageCache.getImage(EImage.EXPORT.getPath()));
    }

    @Override
    public void run() {
        System.out.println("Test Add");
    }

    public String getGroupName() {
        return GROUP_EXPORT;
    }

}
