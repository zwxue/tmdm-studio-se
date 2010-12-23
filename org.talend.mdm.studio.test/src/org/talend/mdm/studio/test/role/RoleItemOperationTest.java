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
public class RoleItemOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem roleParentItem;

    private SWTBotTreeItem roleItem;

    @Before
    public void runBeforeEveryTest() {
        roleParentItem = serverItem.getNode("Role [HEAD]");
        roleParentItem.expand();

        roleParentItem.contextMenu("New").click();
        SWTBotShell newroleShell = bot.shell("New Role");
        newroleShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the Role:");
        text.setText("TestRole");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button(IDialogConstants.NEXT_LABEL).click();
        sleep();

        bot.comboBoxWithLabel("Administrator").selection();
        bot.button(IDialogConstants.FINISH_LABEL).click();
        bot.activeEditor().save();
        bot.activeEditor().close();
        roleItem = roleParentItem.getNode("TestRole");
        Assert.assertNotNull(roleItem);
        sleep(2);
    }

    @Test
    public void roleEditTest() {
        SWTBotMenu editMenu = roleItem.contextMenu("Edit");
        sleep();
        editMenu.click();
    }

    @Test
    public void roleCopyTest() {
        SWTBotMenu editMenu = roleItem.contextMenu("Copy");
        editMenu.click();
        sleep();
        roleItem.contextMenu("Paste").click();
        SWTBotShell pasteroleShell = bot.shell("Pasting instance TestRole");
        pasteroleShell.activate();
        bot.text("CopyOfTestRole").setText("PasteRole");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = roleParentItem.getNode("PasteRole");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @Test
    public void roleDuplicateTest() {
        SWTBotMenu duplicateMenu = roleItem.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance Testrole");
        shell.activate();
        bot.text("CopyOfTestRole").setText("DuplicateRole");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = roleParentItem.getNode("DuplicateRole");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @Test
    public void roleRenameTest() {
        SWTBotMenu renameMenu = roleItem.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameRole");
        bot.button("OK").click();
        sleep();
        Assert.assertNull(roleParentItem.getNode("TestRole"));
        Assert.assertNotNull(roleParentItem.getNode("RenameRole"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        roleParentItem.getNode("RenameRole").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        roleParentItem.getNode("PasteRole").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        roleParentItem.getNode("DuplicateRole").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
