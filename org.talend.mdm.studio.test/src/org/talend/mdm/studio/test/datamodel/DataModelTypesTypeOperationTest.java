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

public class DataModelTypesTypeOperationTest extends DataModelTest {

    private static SWTBotTree typesBotTree;

    private static DataModelMainPage mainpage;

    private static SWTBotTreeItem typeNode;

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
        mainpage.setSchemaSelected(false);
        Tree typesTree = mainpage.getTreeViewer().getTree();
        typesBotTree = new SWTBotTree(typesTree);
        typeNode = typesBotTree.getTreeItem("ReportingType");
        typeNode.select().expand();
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
    }

    @Test
    public void addComplexTypeTest() {
        // SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        // conceptNode.select();
        typeNode.contextMenu("Create a Complex Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Create a Complex Type");
        changeTypeShell.activate();
        bot.ccomboBox().setText("TestComplexType");
        bot.radio("Sequence").click();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void addSimpleTypeTest() {
        // SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        // conceptNode.select();
        /*
         * typeNode.contextMenu("Create a Simple Type").click(); sleep(); SWTBotShell changeTypeShell =
         * bot.shell("New Simple Type"); changeTypeShell.activate(); bot.text().setText("TestSimpleType");
         * bot.radio("Custom").click(); sleep(); bot.ccomboBoxWithLabel("Type").setSelection(1); sleep();
         * bot.button("OK").click(); sleep(2);
         */

        typeNode.contextMenu("Create a Simple Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("New Simple Type");
        changeTypeShell.activate();
        bot.radio("Custom").click();
        sleep();
        bot.ccomboBoxWithLabel("Type").setSelection(0);
        sleep();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void addElementTest() {
        typeNode.contextMenu("Add Element").click();
        SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("testElement");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void editComplexTypeTest() {
        // SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        // conceptNode.expand();
        typeNode.contextMenu("Edit a Complex Type").click();
        sleep();
        SWTBotShell editTypeShell = bot.shell("Edit Complex Type");
        editTypeShell.activate();
        bot.text().setText("TextEditComplexType");
        bot.button("OK").click();
    }

    @Test
    public void deleteComplexTypeTest() {
        // SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        // conceptNode.expand();
        typeNode.contextMenu("Delete type definition").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
