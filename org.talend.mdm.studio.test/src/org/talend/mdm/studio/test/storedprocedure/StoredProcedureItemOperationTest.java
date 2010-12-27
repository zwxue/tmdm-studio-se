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
package org.talend.mdm.studio.test.storedprocedure;

import org.eclipse.jface.dialogs.IDialogConstants;
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
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class StoredProcedureItemOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem storedProcedureParentItem;

    private SWTBotTreeItem storedProcedureItem;

    @Before
    public void runBeforeEveryTest() {
        storedProcedureParentItem = serverItem.getNode("StoredProcedure [HEAD]");
        storedProcedureParentItem.expand();

        storedProcedureParentItem.contextMenu("New").click();
        SWTBotShell newstoredProcedureShell = bot.shell("New StoredProcedure");
        newstoredProcedureShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the StoredProcedure:");
        text.setText("TestStoredProcedure");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button(IDialogConstants.NEXT_LABEL).click();
        sleep();

        bot.comboBoxWithLabel("Administrator").selection();
        bot.button(IDialogConstants.FINISH_LABEL).click();
        bot.activeEditor().save();
        bot.activeEditor().close();
        storedProcedureItem = storedProcedureParentItem.getNode("TestStoredProcedure");
        Assert.assertNotNull(storedProcedureItem);
        sleep(2);
    }

    @Test
    public void storedProcedureEditTest() {
        SWTBotMenu editMenu = storedProcedureItem.contextMenu("Edit");
        sleep();
        editMenu.click();
    }

    @Test
    public void storedProcedureCopyTest() {
        SWTBotMenu editMenu = storedProcedureItem.contextMenu("Copy");
        editMenu.click();
        sleep();
        storedProcedureItem.contextMenu("Paste").click();
        SWTBotShell pastestoredProcedureShell = bot.shell("Pasting instance TestStoredProcedure");
        pastestoredProcedureShell.activate();
        bot.text("CopyOfTestStoredProcedure").setText("PasteStoredProcedure");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = storedProcedureParentItem.getNode("PasteStoredProcedure");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @Test
    public void storedProcedureDuplicateTest() {
        SWTBotMenu duplicateMenu = storedProcedureItem.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance TeststoredProcedure");
        shell.activate();
        bot.text("CopyOfTestStoredProcedure").setText("DuplicateStoredProcedure");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = storedProcedureParentItem.getNode("DuplicateStoredProcedure");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @Test
    public void storedProcedureRenameTest() {
        SWTBotMenu renameMenu = storedProcedureItem.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameStoredProcedure");
        bot.button("OK").click();
        sleep();
        Assert.assertNull(storedProcedureParentItem.getNode("TestStoredProcedure"));
        Assert.assertNotNull(storedProcedureParentItem.getNode("RenameStoredProcedure"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        storedProcedureParentItem.getNode("RenameStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        storedProcedureParentItem.getNode("PasteStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        storedProcedureParentItem.getNode("DuplicateStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
