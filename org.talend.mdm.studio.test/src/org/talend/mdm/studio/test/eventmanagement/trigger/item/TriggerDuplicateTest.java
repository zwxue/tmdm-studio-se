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
public class TriggerDuplicateTest extends TalendSWTBotForMDM {

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
        triggerNode = triggerParentNode.getNode("TriggerDemo");
        SWTBotMenu deleteMenu = triggerNode.contextMenu("Delete");
        deleteMenu.click();
        sleep();
        bot.button("OK").click();

        triggerNode = triggerParentNode.getNode("DuplicateTriggerDemo");
        deleteMenu = triggerNode.contextMenu("Delete");
        deleteMenu.click();
        sleep();
        bot.button("OK").click();
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

}
