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
package org.talend.mdm.studio.test.transformer.item;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class TransformerGenerateTriggerTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem jobItem;

    private SWTBotTreeItem processParentNode;

    private String PRIFIX = "CallJob_";

    private String name;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem jobParentItem = serverItem.getNode("Job Repository");
        jobParentItem.expand();

        SWTBotTreeItem eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        processParentNode = eventManagementItem.getNode("Process [HEAD]");
        processParentNode.expand();

        SWTBotTreeItem jobCategoryItem = jobParentItem.getNode("Deployed Jobs");
        if (jobCategoryItem.getItems().length > 0) {
            jobItem = jobCategoryItem.getNode(0);
        }
    }

    @After
    public void runAfterEveryTest() {
        processParentNode.getNode(PRIFIX + name).contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void generateTriggerTest() {
        if (jobItem != null) {
            name = jobItem.getText();
            jobItem.contextMenu("Generate Talend Job Caller Trigger").click();
            Assert.assertNotNull(processParentNode.getNode(PRIFIX + name));
            sleep();
        }
    }

}
