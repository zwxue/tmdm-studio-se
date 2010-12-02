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

public class DataModelKeyOperationTest extends DataModelTest {

    private static DataModelMainPage mainpage;

    private static SWTBotTree conceptBotTree;

    private static SWTBotTree typesBotTree;

    private static SWTBotTreeItem keyItem;

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

            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
    }

    @Test
    public void newEntityTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        keyItem = conceptNode.getNode("Reporting");
        keyItem.contextMenu("New Entity").click();
        SWTBotShell newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Name:").setText("ComplexTypeEntity");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void addKeyTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        keyItem = conceptNode.getNode("Reporting");
        keyItem.contextMenu("Add Key").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Add a new Key");
        changeTypeShell.activate();
        bot.text().setText("addKeyTest");
        bot.ccomboBox(0).setSelection(1);
        bot.button("OK").click();
    }

    @Test
    public void deleteKeyTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        keyItem = conceptNode.getNode("addKeyTest");
        keyItem.contextMenu("Delete Key").click();
        sleep();
    }

    @Test
    public void addFieldTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        keyItem = conceptNode.getNode("Reporting");
        keyItem.contextMenu("New Field").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Select one field");
        changeTypeShell.activate();
        bot.ccomboBox().setSelection(2);
        bot.button("OK").click();
    }

    @Test
    public void editKeyTest() {
        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        keyItem = conceptNode.getNode("Reporting");
        keyItem.contextMenu("Edit Key").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Edit Key");
        changeTypeShell.activate();
        bot.text().setText("TestEditKey");
        bot.button("OK").click();
    }
}
