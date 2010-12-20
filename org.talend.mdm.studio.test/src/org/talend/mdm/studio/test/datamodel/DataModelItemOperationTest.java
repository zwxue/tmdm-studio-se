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
package org.talend.mdm.studio.test.datamodel;

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
 * dataModelTest is a superclass of the test classes for testing the functions of Data Container.
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelItemOperationTest extends TalendSWTBotForMDM {

    protected static SWTBotTreeItem dataModelItem;

    private SWTBotTreeItem newNode;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();

        dataModelItem.contextMenu("New").click();
        SWTBotShell newdataModelShell = bot.shell("New Data Model");
        newdataModelShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        text.setText("TestdataModel");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button("OK").click();
        bot.textWithLabel("Description").setText("This is a test for data container");
        bot.activeEditor().save();
        sleep();
        bot.activeEditor().close();
        newNode = dataModelItem.getNode("TestdataModel");
        Assert.assertNotNull(newNode);
        sleep(2);
    }

    @Test
    public void dataModelEditTest() {
        SWTBotMenu editMenu = newNode.contextMenu("Edit");
        sleep();
        editMenu.click();
        bot.textWithLabel("Description").setText("This is a test for edit function of data model");
        bot.activeEditor().save();
    }

    @Test
    public void dataModelCopyTest() {
        SWTBotMenu editMenu = newNode.contextMenu("Copy");
        editMenu.click();
        sleep();
        newNode.contextMenu("Paste").click();
        SWTBotShell pastedataModelShell = bot.shell("Pasting instance TestdataModel");
        pastedataModelShell.activate();
        bot.text("CopyOfTestdataModel").setText("PastedataModel");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = dataModelItem.getNode("PastedataModel");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @Test
    public void dataModelDuplicateTest() {
        SWTBotMenu duplicateMenu = newNode.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance TestdataModel");
        shell.activate();
        bot.text("CopyOfTestdataModel").setText("DuplicatedataModel");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = dataModelItem.getNode("DuplicatedataModel");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @Test
    public void dataModelRenameTest() {
        SWTBotMenu renameMenu = newNode.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameDataModel");
        bot.button("OK").click();
        sleep();
        Assert.assertNull(dataModelItem.getNode("TestDataModel"));
        Assert.assertNotNull(dataModelItem.getNode("RenameDataModel"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        dataModelItem.getNode("RenameDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        dataModelItem.getNode("PastedataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        dataModelItem.getNode("DuplicatedataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
