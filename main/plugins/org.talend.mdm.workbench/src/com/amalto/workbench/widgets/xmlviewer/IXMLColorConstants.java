/*****************************************************************************
 * This file is part of Rinzo
 * 
 * Author: Claudio Cancinos WWW: https://sourceforge.net/projects/editorxml Copyright (C): 2008, Claudio Cancinos
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this program; If not, see
 * <http://www.gnu.org/licenses/>
 ****************************************************************************/
package com.amalto.workbench.widgets.xmlviewer;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public interface IXMLColorConstants {

    Color XML_COMMENT = ColorManager.getInstance().getColor(new RGB(63, 95, 191));

    Color PROC_INSTR = ColorManager.getInstance().getColor(new RGB(128, 128, 128));

    Color DECLARATION = ColorManager.getInstance().getColor(new RGB(128, 128, 128));

    Color STRING = ColorManager.getInstance().getColor(new RGB(42, 0, 255));

    Color ATTRIBUTE = ColorManager.getInstance().getColor(new RGB(127, 0, 127));

    Color DEFAULT = ColorManager.getInstance().getColor(new RGB(0, 0, 0));

    Color TAG = ColorManager.getInstance().getColor(new RGB(63, 127, 127));

    Color CDATA = ColorManager.getInstance().getColor(new RGB(128, 128, 128));

// Color EDITOR_MATCHING_BRACKETS =ColorManager.getInstance().getColor(new RGB( ));
    //
    // Color EDITOR_MATCHING_BRACKETS_COLOR = ColorManager.getInstance().getColor(new RGB( ));
}
