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
package org.talend.mdm.studio.test.storedprocedure.parent;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class StoredProcedureCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem spParentItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Stored Procedure [HEAD]");
        spParentItem.expand();
    }

    @Test
    public void storedProcedureCreationTest() {
        spParentItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell shell = bot.shell("New Stored Procedure");
        shell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestStoredProcedure");
        bot.button("OK").click();
        sleep(2);
        bot.activeEditor().save();
        spParentItem.expand();
        Assert.assertNotNull(spParentItem.getNode("TestStoredProcedure"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        spParentItem.getNode("TestStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
