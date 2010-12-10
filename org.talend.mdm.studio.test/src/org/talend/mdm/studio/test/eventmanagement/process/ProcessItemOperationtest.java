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

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.eventmanagement.EventManagementTest;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class ProcessItemOperationtest extends EventManagementTest {

    private static SWTBotTreeItem processParentNode;

    private SWTBotTreeItem processNode;

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
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

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
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
        // revert the rename operation
        processNode.contextMenu("Rename").click();
        renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("Normal_Process");
        bot.button("OK").click();
    }

    @Test
    public void copyProcessTest() {
        processNode.contextMenu("Copy").click();
        sleep();
        processNode.contextMenu("Paste").click();
        SWTBotShell pasteProcessShell = bot.shell("Pasting instance Normal_Process");
        pasteProcessShell.activate();
        bot.text("CopyOfNormal_Process").setText("PasteProcess");
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void duplicateProcessTest() {
        processNode.contextMenu("Duplicate").click();
        SWTBotShell shell = bot.shell("Pasting instance Normal_Process");
        shell.activate();
        bot.text("CopyOfNormal_Process").setText("DuplicateNormal_Process");
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void editProcessTest() {
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
    }
}
