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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
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
 * DataModelContentTest is a SWTBot test class for testing the function of Data Model content.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataModelEntityOperationTest extends DataModelTest {

    private static SWTBotTree conceptBotTree;

    private static SWTBotTree typesBotTree;

    private static DataModelMainPage mainpage;

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
        mainpage = (DataModelMainPage) ep.getPage(0);
        Tree conceptTree = mainpage.getTreeViewer().getTree();
        conceptBotTree = new SWTBotTree(conceptTree);
        mainpage.setSchemaSelected(false);
        Tree typesTree = mainpage.getTreeViewer().getTree();
        typesBotTree = new SWTBotTree(typesTree);
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
        Display.getDefault().syncExec(new Runnable() {

            @Override
            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
    }

    @Test
    public void newEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();

        conceptNode.contextMenu("New Entity").click();
        SWTBotShell newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Name:").setText("ComplexTypeEntity");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
        conceptNode.contextMenu("New Entity").click();
        newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        bot.textWithLabel("Name:").setText("SimpleTypeEntity");
        sleep();
        bot.radio("Simple Type").click();
        sleep();
        bot.button("OK").click();
    }

    @Test
    public void deleteEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
        conceptNode.select();
        conceptNode.contextMenu("Delete Entity").click();
        sleep();
        conceptNode = conceptBotTree.getTreeItem("SimpleTypeEntity");
        conceptNode.select();
        conceptNode.contextMenu("Delete Entity").click();
        sleep();
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

    @Test
    public void copyEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Copy Entity").click();
        sleep();
        conceptNode.select();
        conceptNode.contextMenu("Paste Entity").click();
        sleep();
        SWTBotShell saveShell = bot.shell("Copy Entity");
        saveShell.activate();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void changeToComplexTypeTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Change to a Complex Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Change To Complex Type");
        changeTypeShell.activate();
        bot.radio("Sequence").click();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void changeToSimpleTypeTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Change to a Simple Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Make Simple Type");
        changeTypeShell.activate();
        bot.radio("Custom").click();
        sleep();
        bot.ccomboBoxWithLabel("Type").setSelection(1);
        sleep();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void addKeyTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Add Key").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Add a new Key");
        changeTypeShell.activate();
        bot.text().setText("Test");
        bot.ccomboBox(0).setSelection(1);
        bot.button("OK").click();
    }

    @Test
    public void setLabelsTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Labels").click();
        sleep();
        SWTBotShell shell = bot.shell("Set the Labels");
        shell.activate();
        bot.comboBox().setSelection(0);
        bot.text().setText("en");
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.comboBox().setSelection(1);
        bot.text().setText("fr");
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.table().select(1);
        bot.buttonWithTooltip("Del").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void setDescriptionsTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Descriptions").click();
        sleep();
        SWTBotShell shell = bot.shell("Set the Descriptions of This Element");
        shell.activate();
        bot.comboBox().setSelection(0);
        bot.text().setText("enlish descriptions");
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.comboBox().setSelection(1);
        bot.text().setText("french descriptions");
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.table().select(1);
        bot.buttonWithTooltip("Del").click();
        sleep();
        bot.button("OK").click();
    }

    @Test
    public void setLookupFieldsTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set Lookup Fields").click();
        sleep();
        SWTBotShell shell = bot.shell("Set Lookup Fields");
        shell.activate();
        bot.ccomboBox().setSelection(0);
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBox().setSelection(1);
        bot.buttonWithTooltip("Add").click();

        bot.table().select(0);
        bot.buttonWithTooltip("Move down the selected item").click();
        sleep(2);
        bot.buttonWithTooltip("Move up the selected item").click();
        sleep(2);

        bot.table().select(1);
        bot.buttonWithTooltip("Delete the selected item").click();
        sleep();
        bot.button("OK").click();
    }

    @Test
    public void setWriteAccessTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Roles with Write Access").click();
        SWTBotShell newViewShell = bot.shell("Set The Roles That Have Write Access");
        newViewShell.activate();
        bot.ccomboBox().setSelection(0);
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBox().setSelection(1);
        bot.buttonWithTooltip("Add").click();

        bot.table().select(0);
        bot.buttonWithTooltip("Move down the selected item").click();
        sleep(2);
        bot.buttonWithTooltip("Move up the selected item").click();
        sleep(2);

        bot.table().select(0);
        bot.buttonWithTooltip("Delete the selected item").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void setNoAccessTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Roles with No Access").click();
        SWTBotShell newViewShell = bot.shell("Set The Roles That Cannot Access This Field");
        newViewShell.activate();
        bot.ccomboBox().setSelection(0);
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBox().setSelection(1);
        bot.buttonWithTooltip("Add").click();

        bot.table().select(0);
        bot.buttonWithTooltip("Move down the selected item").click();
        sleep(2);
        bot.buttonWithTooltip("Move up the selected item").click();
        sleep(2);

        bot.table().select(1);
        bot.buttonWithTooltip("Delete the selected item").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void setWorkflowAccessTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Workflow Access").click();
        SWTBotShell shell = bot.shell("Set the Workflow Access");
        shell.activate();
    }

    @Test
    public void addValidationRuleTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Set the Validation Rule").click();
        SWTBotShell shell = bot.shell("Add a Validation Rule");
        shell.activate();
        bot.text().setText("vadation rule");
    }

    @Test
    public void deleteValidationRuleTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select();
        conceptNode.contextMenu("Delete All Validation Rules").click();
        SWTBotShell shell = bot.shell("Confirm");
        shell.activate();
        bot.button("OK").click();
    }
}
