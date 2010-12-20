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
public class TriggerParentOperationTest extends TalendSWTBotForMDM {

    private static SWTBotTreeItem triggerParentNode;

    private SWTBotTreeItem eventManagementItem;

    @Before
    public void runBeforeEveryTest() {
        eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void newTest() {
        // for normal process
        triggerParentNode.contextMenu("New").click();
        bot.text().setText("TriggerDemo");
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(triggerParentNode.getNode("TriggerDemo"));
    }

    @Test
    public void browseRevisionTest() {
        triggerParentNode.contextMenu("Browse Revision").click();
    }

    @Test
    public void newCategoryTest() {
        triggerParentNode.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();

        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestProcessCategory");
        bot.button("OK").click();
        Assert.assertNotNull(triggerParentNode.getNode("TestProcessCategory"));
        triggerParentNode.expand();
        sleep(2);
        triggerParentNode.getNode("TestProcessCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

    }

}
