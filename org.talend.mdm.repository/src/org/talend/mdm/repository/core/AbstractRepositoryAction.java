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
package org.talend.mdm.repository.core;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public abstract class AbstractRepositoryAction extends BaseSelectionListenerAction {

    public static final String GROUP_EDIT = "group.edit";

    public static final String GROUP_EXPORT = "group.export";

    public static final String GROUP_SERVER = "group.server";

    protected CommonViewer commonViewer;

    /**
     * DOC hbhong AbstractRepositoryAction constructor comment.
     * 
     * @param text
     */
    protected AbstractRepositoryAction(String text) {
        super(text);
    }

    public abstract String getGroupName();

    public void initCommonViewer(CommonViewer commonViewer) {
        this.commonViewer = commonViewer;

    }

    protected List<Object> getSelectedObject() {

        IStructuredSelection structuredSelection = getStructuredSelection();
        if (structuredSelection.isEmpty())
            return Collections.EMPTY_LIST;
        List<Object> result = new LinkedList<Object>();
        for (Iterator<Object> il = structuredSelection.iterator(); il.hasNext();) {
            result.add(il.next());
        }
        return result;
    }

    protected Shell getShell() {
        return commonViewer.getControl().getShell();
    }
}
