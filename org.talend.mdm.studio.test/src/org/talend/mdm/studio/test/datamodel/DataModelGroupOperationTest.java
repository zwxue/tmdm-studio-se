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

public class DataModelGroupOperationTest extends DataModelTest {

    private static SWTBotTree conceptBotTree;

    private static SWTBotTree typesBotTree;

    private static DataModelMainPage mainpage;

    private static SWTBotTreeItem conceptNode;

    private static SWTBotTreeItem groupItem;

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
        groupItem = conceptNode.getNode("ReportingType");

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
    public void addElementTest() {
        // SWTBotTreeItem groupItem = conceptNode.getNode("ReportingType");
        groupItem.contextMenu("Add Element").click();
        SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("testElement");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void changeSubElementGroupTest() {
        groupItem.contextMenu("Change Sub-Element Group").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Change Sub-Element Group");
        changeTypeShell.activate();
        bot.radio("Choice").click();
        bot.button("OK").click();
        sleep(2);

    }

    @Test
    public void newEntityTest() {
        groupItem.contextMenu("New Entity").click();
        SWTBotShell newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Name:").setText("ComplexTypeEntity");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

}
