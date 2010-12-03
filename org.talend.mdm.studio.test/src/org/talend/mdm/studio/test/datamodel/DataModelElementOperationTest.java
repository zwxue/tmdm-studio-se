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

public class DataModelElementOperationTest extends DataModelTest {

    private static SWTBotTree conceptBotTree;

    private static SWTBotTree typesBotTree;

    private static DataModelMainPage mainpage;

    private static SWTBotTreeItem conceptNode;

    private static SWTBotTreeItem eleItem;

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
        conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select().expand();
        SWTBotTreeItem groupItem = conceptNode.getNode("ReportingType");
        groupItem.expand();
        eleItem = groupItem.getNode("Concept");
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
    public void editElementTest() {
        eleItem.contextMenu("Edit Element").click();
        SWTBotShell newEntityShell = bot.shell("Edit Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("ConceptTest");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);

        eleItem.contextMenu("Edit Element").click();
        newEntityShell = bot.shell("Edit Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("Concept");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void addElementTest() {
        // SWTBotTreeItem groupItem = conceptNode.getNode("ReportingType");
        eleItem.contextMenu("Add Element (after)").click();
        SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("testElement");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void copyElementTest() {
        eleItem.contextMenu("Copy Element").click();
        sleep();
        eleItem.contextMenu("Paste Element").click();
        sleep();
        SWTBotShell saveShell = bot.shell("Copy Element");
        saveShell.activate();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void changeToComplexTypeTest() {
        eleItem.contextMenu("Change to a Complex Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Change To Complex Type");
        changeTypeShell.activate();
        bot.radio("Sequence").click();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void changeToSimpleTypeTest() {
        eleItem.contextMenu("Change to a Simple Type").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Make Simple Type");
        changeTypeShell.activate();
        bot.radio("Custom").click();
        sleep();
        bot.ccomboBoxWithLabel("Type").setSelection(0);
        sleep();
        bot.button("OK").click();
        sleep(2);
    }

    @Test
    public void setLabelsTest() {
        eleItem.contextMenu("Set the Labels").click();
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
        eleItem.contextMenu("Set the Descriptions").click();
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
    public void setWriteAccessTest() {
        eleItem.contextMenu("Set the Roles with Write Access").click();
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
        eleItem.contextMenu("Set the Roles with No Access").click();
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
        eleItem.contextMenu("Set the Workflow Access").click();
        SWTBotShell shell = bot.shell("Set the Workflow Access");
        shell.activate();
    }

    @Test
    public void setForeignKeyTest() {
        Display.getDefault().syncExec(new Runnable() {

            @Override
            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
        eleItem.contextMenu("Set the Foreign Key").click();
        SWTBotShell shell = bot.shell("Set the Foreign Key");
        shell.activate();
        bot.buttonWithTooltip("Select xpath").click();
        // test the filter of the composite by meanwhile.
        bot.textWithLabel("Filter:").setText("R");
        sleep();
        bot.textWithLabel("Filter:").setText("U");
        sleep();
        bot.textWithLabel("Filter:").setText("");
        sleep();
        bot.tree().select("Reporting");
        sleep();
        bot.button("Add").click();
        sleep();
        shell = bot.shell("Set the Foreign Key");
        shell.activate();
        bot.button("OK").click();
    }

    @Test
    public void newEntityTest() {
        eleItem.contextMenu("New Entity").click();
        SWTBotShell newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Name:").setText("ComplexTypeEntity");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }
}
