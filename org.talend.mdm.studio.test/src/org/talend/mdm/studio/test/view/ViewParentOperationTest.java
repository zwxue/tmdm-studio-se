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
package org.talend.mdm.studio.test.view;

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
 * viewTest is a superclass of the test classes for testing the functions of Data Container.
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ViewParentOperationTest extends TalendSWTBotForMDM {

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
        setDescription();
        setElements();
        bot.activeEditor().save();
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
        Assert.assertEquals(des, bot.text(0).getText());
    }

    @Test
    public void viewCategoryCreationTest() {
        viewParentItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestViewCategory");
        bot.button("OK").click();
        Assert.assertNotNull(viewParentItem.getNode("TestViewCategory"));
        sleep(2);
    }

    @Test
    public void viewBrowseRevisionTest() {
        viewParentItem.contextMenu("Browse Revision").click();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        viewParentItem.getNode("TestView").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        viewParentItem.getNode("TestViewCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
