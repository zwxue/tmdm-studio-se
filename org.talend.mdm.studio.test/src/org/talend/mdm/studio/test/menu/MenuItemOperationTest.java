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
package org.talend.mdm.studio.test.menu;

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
public class MenuItemOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem menuParentItem;

    private SWTBotTreeItem menuItem;

    @Before
    public void runBeforeEveryTest() {
        menuParentItem = serverItem.getNode("Menu [HEAD]");
        menuParentItem.expand();

        menuParentItem.contextMenu("New").click();
        SWTBotShell shell = bot.shell("New Menu");
        shell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the Menu:");
        text.setText("TestMenu");
        sleep();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        menuItem = menuParentItem.getNode("TestMenu");
        Assert.assertNotNull(menuItem);
        sleep(2);
    }

    @Test
    public void menuEditTest() {
        SWTBotMenu editMenu = menuItem.contextMenu("Edit");
        sleep();
        editMenu.click();
    }

    @Test
    public void menuCopyTest() {
        SWTBotMenu editMenu = menuItem.contextMenu("Copy");
        editMenu.click();
        sleep();
        menuItem.contextMenu("Paste").click();
        SWTBotShell pastemenuShell = bot.shell("Pasting instance TestMenu");
        pastemenuShell.activate();
        bot.text("CopyOfTestMenu").setText("PasteMenu");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = menuParentItem.getNode("PasteMenu");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @Test
    public void menuDuplicateTest() {
        SWTBotMenu duplicateMenu = menuItem.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance Testmenu");
        shell.activate();
        bot.text("CopyOfTestMenu").setText("DuplicateMenu");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = menuParentItem.getNode("DuplicateMenu");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @Test
    public void menuRenameTest() {
        SWTBotMenu renameMenu = menuItem.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameMenu");
        bot.button("OK").click();
        sleep();
        Assert.assertNull(menuParentItem.getNode("TestMenu"));
        Assert.assertNotNull(menuParentItem.getNode("RenameMenu"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        menuParentItem.getNode("RenameMenu").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        menuParentItem.getNode("PasteMenu").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        menuParentItem.getNode("DuplicateMenu").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
