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

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.XObjectEditor;

/**
 * DataModelReportingTest is a SWTBot test class for testing the function of Data Model reporting.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataModelReportingTest extends DataModelTest {

    private static SWTBotTree conceptBotTree;

    private static SWTBotTree typesBotTree;

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        SWTBotTreeItem node = dataModelItem.expandNode("System").getNode("Reporting");
        node.doubleClick();

        final SWTBotEditor editor = bot.editorByTitle("Reporting");
        XObjectEditor ep = (XObjectEditor) editor.getReference().getPart(true);
        DataModelMainPage mainpage = (DataModelMainPage) ep.getPage(0);
        Tree conceptTree = mainpage.getTreeViewer().getTree();
        conceptBotTree = new SWTBotTree(conceptTree);
        mainpage.setSchemaSelected(false);
        Tree typesTree = mainpage.getTreeViewer().getTree();
        typesBotTree = new SWTBotTree(typesTree);
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void newEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        // TODO:The context menu can not be accessed.
        /*
         * conceptNode.contextMenu("Edit Entity").click(); SWTBotShell newEntityShell = bot.shell("New Entity");
         * newEntityShell.activate(); // create a entity with a complex type
         * bot.textWithLabel("Name:").setText("ComplexTypeEntity"); bot.button("OK").click(); // create a entity with a
         * simple type bot.textWithLabel("Name:").setText("SimpleTypeEntity"); bot.radio("Simple Type").click();
         * bot.button("OK").click();
         */
    }

    @Test
    public void editEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Edit Entity").click();
        SWTBotShell editEntityShell = bot.shell("Edit Entity");
        editEntityShell.activate();
        bot.textWithLabel("Enter a new Name for the Entity").setText("TestEdit");
        sleep();
        bot.button("OK").click();
        sleep(2);
        // Revert the changes
        conceptNode.doubleClick();
        editEntityShell = bot.shell("Edit Entity");
        editEntityShell.activate();
        bot.textWithLabel("Enter a new Name for the Entity").setText("Reporting");
        sleep();
        bot.button("OK").click();
    }

    @Test
    public void generateDefaultViewTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Generate default Browse Items Views").click();
        SWTBotShell saveShell = bot.shell("Save Resource");
        saveShell.activate();
        bot.button("OK").click();
        sleep();
        SWTBotShell generateViewShell = bot.shell("Generate default Browse Items Views");
        generateViewShell.activate();
        bot.button("Finish").click();
    }

    // @Test
    public void copyEntityTest() {
        // SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        // conceptNode.select();
        // conceptNode.contextMenu("Copy Entity").click();
        // sleep();
        // conceptNode.select();
        // conceptNode.contextMenu("Paste Entity").click();
        // // SWTBotShell editEntityShell = bot.shell("Edit Entity");
        // // editEntityShell.activate();
        // // bot.textWithLabel("Enter a new Name for the Entity").setText("TestEdit");
        // sleep();
    }
}
