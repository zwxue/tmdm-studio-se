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
package org.talend.mdm.studio.test.eventmanagement.trigger;

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
public class TriggerItemOperationtest extends TalendSWTBotForMDM {

    private SWTBotTreeItem triggerParentNode;

    private SWTBotTreeItem triggerNode;

    private SWTBotTreeItem eventManagementItem;

    @Before
    public void runBeforeEveryTest() {
        eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
        triggerParentNode.contextMenu("New").click();
        bot.text().setText("TriggerDemo");
        bot.button("OK").click();
        sleep();
        // set a service JNDI name before saving the editor.
        bot.comboBox().setSelection("callprocess");
        bot.activeEditor().save();
        bot.activeEditor().close();
        triggerParentNode.expand();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void renameTriggerTest() {
        triggerNode = triggerParentNode.getNode("TriggerDemo");
        SWTBotMenu renameMenu = triggerNode.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameTrigger");
        bot.button("OK").click();
        // Assert.assertNull(triggerParentNode.getNode("TriggerDemo"));
        // revert the rename operation
        triggerNode = triggerParentNode.getNode("RenameTrigger");
        Assert.assertNotNull(triggerParentNode.getNode("RenameTrigger"));
        triggerNode.contextMenu("Rename").click();
        renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("TriggerDemo");
        bot.button("OK").click();
    }

    @Test
    public void copyTriggerTest() {
        triggerNode = triggerParentNode.getNode("TriggerDemo");
        triggerNode.contextMenu("Copy").click();
        sleep();
        triggerNode.contextMenu("Paste").click();
        SWTBotShell pasteTriggerShell = bot.shell("Pasting instance TriggerDemo");
        pasteTriggerShell.activate();
        bot.text("CopyOfTriggerDemo").setText("PasteTrigger");
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(triggerParentNode.getNode("PasteTrigger"));
    }

    @Test
    public void duplicateTriggerTest() {
        triggerNode = triggerParentNode.getNode("TriggerDemo");
        triggerNode.contextMenu("Duplicate").click();
        SWTBotShell shell = bot.shell("Pasting instance TriggerDemo");
        shell.activate();
        bot.text("CopyOfTriggerDemo").setText("DuplicateTriggerDemo");
        sleep();
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(triggerParentNode.getNode("DuplicateTriggerDemo"));
    }

    @Test
    public void editTriggerTest() {
        triggerNode = triggerParentNode.getNode("TriggerDemo");
        triggerNode.contextMenu("Edit").click();
        sleep(2);
        // The further Test for the content of Trigger is in the TriggerContentTest.java.
    }

    @Test
    public void deleteTest() {
        triggerNode = triggerParentNode.getNode("DuplicateTriggerDemo");
        SWTBotMenu deleteMenu = triggerNode.contextMenu("Delete");
        sleep();
        deleteMenu.click();
        sleep();
        bot.button("OK").click();
        Assert.assertNull(triggerParentNode.getNode("DuplicateTriggerDemo"));
    }
}
