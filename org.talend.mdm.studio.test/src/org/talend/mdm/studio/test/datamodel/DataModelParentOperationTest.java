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
package org.talend.mdm.studio.test.datamodel;

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
 * dataModelTest is a superclass of the test classes for testing the functions of Data Container.
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelParentOperationTest extends TalendSWTBotForMDM {

    protected static SWTBotTreeItem dataModelItem;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();
    }

    @Test
    public void dataModelCreationTest() {
        dataModelItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell newDataContainerShell = bot.shell("New Data Model");
        newDataContainerShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        text.setText("TestDataModel");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button("OK").click();
        bot.textWithLabel("Description").setText("This is a test for data model");
        bot.activeEditor().save();
        sleep();
        bot.activeEditor().close();
        Assert.assertNotNull(dataModelItem.getNode("TestDataModel"));
        sleep(2);
    }

    @Test
    public void dataModelCategoryCreationTest() {
        dataModelItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestDataModelCategory");
        bot.button("OK").click();
        Assert.assertNotNull(dataModelItem.getNode("TestDataModelCategory"));
        sleep(2);
    }

    @Test
    public void dataModelBroseRevisionTest() {
        dataModelItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestDataModelCategory");
        bot.button("OK").click();
        Assert.assertNotNull(dataModelItem.getNode("TestDataModelCategory"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        dataModelItem.getNode("TestDataModelCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
