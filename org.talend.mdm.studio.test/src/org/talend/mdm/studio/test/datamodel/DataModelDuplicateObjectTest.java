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

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DataModelDuplicateObjectTest is a SWTBot test case for testing the duplicate function of Data Model.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataModelDuplicateObjectTest extends DataModelTest {

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void runTest() {
        // Because the system data model can not be duplicated,so create a new data model first.
        dataModelItem.contextMenu("New").click();
        SWTBotShell newDataModelShell = bot.shell("New Data Model");
        newDataModelShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        text.setText("TestDataModel");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        bot.activeEditor().close();
        sleep(2);

        SWTBotTreeItem node = dataModelItem.getNode("TestDataModel");
        SWTBotMenu duplicateMenu = node.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell pasteDataModelShell = bot.shell("Pasting instance TestDataModel");
        pasteDataModelShell.activate();
        bot.text("CopyOfTestDataModel").setText("DuplicateDataModel");
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
