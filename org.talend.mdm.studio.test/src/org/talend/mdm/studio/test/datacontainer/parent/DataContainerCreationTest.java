// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.studio.test.datacontainer.parent;

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
public class DataContainerCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem dataContainerItem;

    @Before
    public void runBeforeEveryTest() {
        dataContainerItem = serverItem.getNode("Data Container");
        dataContainerItem.expand();
    }

    @Test
    public void dataContainerCreationTest() {
        dataContainerItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell newDataContainerShell = bot.shell("New Data Container");
        newDataContainerShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        // new feature in 4.2,see bug 0016141
        text.setText("Test DataContainer");
        Assert.assertFalse(bot.button("OK").isEnabled());
        sleep(2);
        text.setText("TestDataContainer");
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button("OK").click();
        bot.textWithLabel("Description").setText("This is a test for data container");
        bot.activeEditor().save();
        sleep();
        bot.activeEditor().close();
        SWTBotTreeItem newNode = dataContainerItem.getNode("TestDataContainer");
        Assert.assertNotNull(newNode);
        sleep(2);

    }

    @After
    public void runAfterEveryTest() {
        dataContainerItem.getNode("TestDataContainer").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

    }

}
