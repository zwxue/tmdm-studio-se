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
package org.talend.mdm.studio.test.synchronization.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
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
public class SynchronizationPlanCopyTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem spParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Synchronization Plan [HEAD]");
        spParentItem.expand();

        spParentItem.contextMenu("New").click();
        SWTBotShell newSynchronizationPlanShell = bot.shell("New Synchronization Plan");
        newSynchronizationPlanShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestSynchronizationPlan");
        bot.button("OK").click();
        sleep(2);
        bot.activeEditor().save();
        sleep();
        spItem = spParentItem.getNode("TestSynchronizationPlan");
        Assert.assertNotNull(spItem);
        sleep(2);
    }

    @Test
    public void synchronizationPlanCopyTest() {
        SWTBotMenu editMenu = spItem.contextMenu("Copy");
        editMenu.click();
        sleep();
        spItem.contextMenu("Paste").click();
        SWTBotShell pasteSynchronizationPlanShell = bot.shell("Pasting instance TestSynchronizationPlan");
        pasteSynchronizationPlanShell.activate();
        bot.text("CopyOfTestSynchronizationPlan").setText("PasteSynchronizationPlan");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = spParentItem.getNode("PasteSynchronizationPlan");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        spParentItem.getNode("TestSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        spParentItem.getNode("PasteSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
