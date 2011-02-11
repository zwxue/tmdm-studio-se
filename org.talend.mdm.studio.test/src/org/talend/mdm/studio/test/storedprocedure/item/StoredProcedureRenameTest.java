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
package org.talend.mdm.studio.test.storedprocedure.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
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
public class StoredProcedureRenameTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem spParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Stored Procedure [HEAD]");
        spParentItem.expand();

        spParentItem.contextMenu("New").click();
        SWTBotShell newstoredProcedureShell = bot.shell("New Stored Procedure");
        newstoredProcedureShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestStoredProcedure");
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        spItem = spParentItem.getNode("TestStoredProcedure");
        Assert.assertNotNull(spItem);
        sleep(2);
    }

    @Test
    public void storedProcedureRenameTest() {
        SWTBotMenu renameMenu = spItem.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameStoredProcedure");
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(spParentItem.getNode("RenameStoredProcedure"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        spParentItem.getNode("RenameStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

    }

}
