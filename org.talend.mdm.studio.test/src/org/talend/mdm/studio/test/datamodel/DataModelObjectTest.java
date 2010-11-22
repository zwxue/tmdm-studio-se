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

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

/**
 * DataContainerTest is a SWTBot test case for testing the new and delete functions of Data Model.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 */
public class DataModelObjectTest extends StudioTest {

    private SWTBotTreeItem dataModelItem;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();
    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        initServerView();
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void runTest() {
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
        sleep(2);
        dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
