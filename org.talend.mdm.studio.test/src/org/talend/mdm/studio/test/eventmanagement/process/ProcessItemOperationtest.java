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
package org.talend.mdm.studio.test.eventmanagement.process;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
public class ProcessItemOperationtest extends TalendSWTBotForMDM {

    private static SWTBotTreeItem processParentNode;

    private SWTBotTreeItem processNode;

    private SWTBotTreeItem eventManagementItem;

    @Before
    public void runBeforeEveryTest() {
        eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        processParentNode = eventManagementItem.getNode("Process [HEAD]");
        // for normal process
        processParentNode.contextMenu("New").click();
        bot.text().setText("Normal_Process");
        bot.radio("Create a Normal Process").click();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        bot.activeEditor().close();
        processParentNode.expand();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
    }

    @Test
    public void renameProcessTest() {
        processNode = processParentNode.getNode("Normal_Process");
        SWTBotMenu renameMenu = processNode.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameProcess");
        bot.button("OK").click();
        Assert.assertNull(processParentNode.expand().getNode("Normal_Process"));
        Assert.assertNotNull(processParentNode.expand().getNode("RenameProcess"));
        // revert the rename operation
        processNode = processParentNode.getNode("RenameProcess");
        processNode.contextMenu("Rename").click();
        renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("Normal_Process");
        bot.button("OK").click();
    }

    @Test
    public void copyProcessTest() {
        processNode = processParentNode.getNode("Normal_Process");
        processNode.contextMenu("Copy").click();
        sleep();
        processNode.contextMenu("Paste").click();
        SWTBotShell pasteProcessShell = bot.shell("Pasting instance Normal_Process");
        pasteProcessShell.activate();
        bot.text("CopyOfNormal_Process").setText("PasteProcess");
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("PasteProcess"));
    }

    @Test
    public void duplicateProcessTest() {
        processNode = processParentNode.getNode("Normal_Process");
        processNode.contextMenu("Duplicate").click();
        SWTBotShell shell = bot.shell("Pasting instance Normal_Process");
        shell.activate();
        bot.text("CopyOfNormal_Process").setText("DuplicateNormal_Process");
        sleep();
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("DuplicateNormal_Process"));
    }

    @Test
    public void editProcessTest() {
        processNode = processParentNode.getNode("Normal_Process");
        processNode.contextMenu("Edit").click();
        sleep(2);
        // The further Test for the content of Process is in the ProcessContentTest.java.
    }

    @Test
    public void deleteTest() {
        processNode = processParentNode.getNode("DuplicateNormal_Process");
        SWTBotMenu deleteMenu = processNode.contextMenu("Delete");
        sleep();
        deleteMenu.click();
        sleep();
        bot.button("OK").click();
        Assert.assertNull(processParentNode.expand().getNode("DuplicateNormal_Process"));
    }
}
