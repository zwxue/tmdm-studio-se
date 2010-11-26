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
package org.talend.mdm.studio.test.role;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.talend.mdm.studio.test.StudioTest;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class RoleTest extends StudioTest {

    protected static SWTBotTreeItem roleItem;
    static {
        initServerView();
        roleItem = serverItem.getNode("Role [HEAD]");
        roleItem.expand();
    }
}
