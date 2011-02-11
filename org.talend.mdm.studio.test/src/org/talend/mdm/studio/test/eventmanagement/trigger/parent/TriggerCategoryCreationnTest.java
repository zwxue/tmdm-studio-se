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
package org.talend.mdm.studio.test.eventmanagement.trigger.parent;

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
public class TriggerCategoryCreationnTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem triggerParentNode;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
    }

    @After
    public void runAfterEveryTest() {
        triggerParentNode.getNode("TestTriggerCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void newCategoryTest() {
        triggerParentNode.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();

        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestTriggerCategory");
        bot.button("OK").click();
        triggerParentNode.expand();
        Assert.assertNotNull(triggerParentNode.getNode("TestTriggerCategory"));
        sleep(2);

    }

}
