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
package org.talend.mdm.studio.test.view.parent;

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
public class ViewCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem viewParentItem;

    private String PREFIX = "Browse_items_";

    @Before
    public void runBeforeEveryTest() {
        viewParentItem = serverItem.getNode("View [HEAD]");
        viewParentItem.expand();
    }

    @Test
    public void viewCreationTest() {
        // Create a new view to test the filter of the xpath.
        viewParentItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell newViewShell = bot.shell("New View");
        newViewShell.activate();
        // bot.buttonWithLabel("...").click();
        bot.buttonWithTooltip("Select one Entity").click();
        bot.shell("Select one Entity").activate();

        // Test filter of the system data model "PROVISIONING"
        bot.comboBoxWithLabel("Data Models:").setSelection("PROVISIONING");
        bot.textWithLabel("Filter:").setText("R");
        sleep();
        bot.textWithLabel("Filter:").setText("U");
        sleep();
        bot.textWithLabel("Filter:").setText("");
        sleep();

        // Test filter of the system data model "CONF"
        bot.comboBoxWithLabel("Data Models:").setSelection("CONF");
        bot.textWithLabel("Filter:").setText("Au");
        sleep();
        bot.textWithLabel("Filter:").setText("Con");
        sleep();
        bot.textWithLabel("Filter:").setText("");
        sleep();

        bot.tree().select("Conf");
        bot.button("Add").click();
        sleep();
        bot.button("OK").click();
        setDescription();
        setElements();
        sleep();
        bot.activeEditor().save();
        sleep();
        bot.activeEditor().close();
        Assert.assertNotNull(viewParentItem.getNode(PREFIX + "Conf"));
        sleep(2);
    }

    private void setElements() {
        bot.buttonWithTooltip("Add", 0).click();
        bot.buttonWithTooltip("Add", 1).click();

    }

    private void setDescription() {
        bot.buttonWithTooltip("Set the Descriptions").click();
        bot.shell("Set the Descriptions").activate();
        bot.comboBox().setSelection("English");
        String des = "Conf";
        bot.text().setText(des);
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
    }

    @After
    public void runAfterEveryTest() {
        viewParentItem.getNode(PREFIX + "Conf").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
