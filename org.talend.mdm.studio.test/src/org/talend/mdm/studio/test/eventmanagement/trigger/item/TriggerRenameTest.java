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
package org.talend.mdm.studio.test.eventmanagement.trigger.item;

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
public class TriggerRenameTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem triggerParentNode;

    private SWTBotTreeItem triggerNode;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();
        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
        triggerParentNode.contextMenu("New").click();
        bot.text().setText("TriggerDemo");
        bot.button("OK").click();
        bot.comboBoxWithLabel("Service JNDI Name").setSelection(0);
        bot.activeEditor().save();
        triggerParentNode.expand();
        sleep();
        Assert.assertNotNull(triggerParentNode.getNode("TriggerDemo"));

    }

    @After
    public void runAfterEveryTest() {
        triggerNode = triggerParentNode.getNode("RenameTrigger");
        SWTBotMenu deleteMenu = triggerNode.contextMenu("Delete");
        deleteMenu.click();
        bot.button("OK").click();
        sleep();
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
    }

}
