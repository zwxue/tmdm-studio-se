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
package org.talend.mdm.studio.test.transformer;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
public class TransformerItemOperationtest extends TalendSWTBotForMDM {

    private static SWTBotTreeItem jobParentItem;

    private SWTBotTreeItem jobCategoryItem;

    private SWTBotTreeItem jobItem;

    private SWTBotTreeItem eventManagementItem;

    private SWTBotTreeItem processParentNode;

    private SWTBotTreeItem triggerParentNode;

    private String PRIFIX = "CallJob_";

    @Before
    public void runBeforeEveryTest() {
        jobParentItem = serverItem.getNode("Job Repository");
        jobParentItem.expand();

        eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        processParentNode = eventManagementItem.getNode("Process [HEAD]");
        processParentNode.expand();
        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
        triggerParentNode.expand();

        jobCategoryItem = jobParentItem.getNode("Deployed Jobs");
        if (jobCategoryItem.getItems().length > 0) {
            jobItem = jobCategoryItem.getNode(0);
        }
    }

    @After
    public void runAfterEveryTest() {
    }

    @Test
    public void generateProcessTest() {
        if (jobItem != null) {
            String name = jobItem.getText();
            jobItem.contextMenu("Generate Talend Job Caller Process").click();
            final SWTBotShell shell = bot.shell("Which schema do you want?");
            shell.activate();
            bot.button("OK").click();
            Assert.assertNotNull(triggerParentNode.getNode(PRIFIX + name));
            sleep();
        }
    }

    @Test
    public void generateTriggerTest() {
        if (jobItem != null) {
            String name = jobItem.getText();
            jobItem.contextMenu("Generate Talend Job Caller Trigger").click();
            Assert.assertNotNull(processParentNode.getNode(PRIFIX + name));
            sleep();
        }
    }

    @Test
    public void deleteTest() {
        if (jobItem != null) {
            jobItem.contextMenu("Delete").click();
            sleep();
            Assert.assertNull(jobItem);
        }
    }
}
