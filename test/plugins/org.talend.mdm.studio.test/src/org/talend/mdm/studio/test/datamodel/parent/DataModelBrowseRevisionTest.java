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
package org.talend.mdm.studio.test.datamodel.parent;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelBrowseRevisionTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem dataModelItem;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();
    }

    @Test
    public void dataModelBroseRevisionTest() {
        dataModelItem.contextMenu("Browse Revision").click();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        bot.activeEditor().close();
    }

}
