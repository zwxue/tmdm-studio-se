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
package org.talend.mdm.studio.test.synchronization;

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
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SynchronizationPlanParentOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem spParentItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Synchronization Plan [HEAD]");
        spParentItem.expand();
    }

    @Test
    public void synchronizationPlanCreationTest() {
        spParentItem.contextMenu("New").click();
        SWTBotShell shell = bot.shell("New Synchronization Plan");
        shell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the new instance");
        text.setText("TestSynchronizationPlan");
        bot.buttonWithTooltip("OK").click();
        Assert.assertNotNull(spParentItem.getNode("TestSynchronizationPlan"));
        sleep(2);
    }

    @Test
    public void synchronizationPlanCategoryCreationTest() {
        spParentItem.contextMenu("New Category").click();
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestSynchronizationPlanCategory");
        bot.button("OK").click();
        Assert.assertNotNull(spParentItem.getNode("TestSynchronizationPlanCategory"));
        sleep(2);
    }

    @Test
    public void synchronizationPlanBrowseRevisionTest() {
        spParentItem.contextMenu("Browse Revision").click();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        spParentItem.getNode("TestSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        spParentItem.getNode("TestSynchronizationPlanCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
