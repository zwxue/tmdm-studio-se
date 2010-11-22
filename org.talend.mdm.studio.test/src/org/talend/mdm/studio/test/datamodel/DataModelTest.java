package org.talend.mdm.studio.test.datamodel;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.XObjectEditor;

public class DataModelTest extends StudioTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        initServerView();
    }

    @Test
    public void canSetRoleMenu() throws Exception {

        SWTBotTreeItem dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();

        SWTBotTreeItem node = dataModelItem.expandNode("System").getNode("Reporting");
        node.doubleClick();
        final SWTBotEditor editor = bot.editorByTitle("Reporting");
        // bot.getDisplay().syncExec(new Runnable() {
        //
        // public void run() {
        // Matcher<Label> matcher=anything("Data-model:PROVISIONING");
        XObjectEditor ep = (XObjectEditor) editor.getReference().getPart(true);
        DataModelMainPage mainpage = (DataModelMainPage) ep.getPage(0);
        Tree conceptTree = mainpage.getTreeViewer().getTree();
        SWTBotTree conceptBotTree = new SWTBotTree(conceptTree);
        mainpage.setSchemaSelected(false);
        Tree typesTree = mainpage.getTreeViewer().getTree();
        SWTBotTree typesBotTree = new SWTBotTree(typesTree);

        //				

        SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.expand();
        conceptNode.getNode(0).expand();
        SWTBotTreeItem userNode = conceptNode.getNode(0).getNode("ReportingName");
        userNode.setFocus();
        checkAccessTest(userNode);

        SWTBotTreeItem typeNode = conceptNode.getNode("ReportingType");
        typeNode.setFocus();
        addElementTest(typeNode, "conceptTest");

        SWTBotTreeItem conceptTypesNode = typesBotTree.getTreeItem("ReportingType");
        conceptTypesNode.expand();
        addElementTest(conceptTypesNode, "typeTest");
        // }
        // });

    }

    private void checkAccessTest(SWTBotTreeItem userNode) {
        SWTBotMenu ctxMenu = userNode.select().contextMenu("Set the Roles with Write Access").click();
        SWTBotShell newViewShell = bot.shell("Set The Roles That Have Write Access");
        newViewShell.activate();
        sleep();
        bot.button("Cancel").click();
        sleep();
        ctxMenu = userNode.select().contextMenu("Set the Roles with No Access").click();
        sleep();
        bot.button("Cancel").click();
        sleep();
        // ctxMenu = userNode.select().contextMenu("Set the Workflow Access").click();
        // sleep();
        // bot.button("Cancel").click();
        // sleep();
        sleep();

    }

    private void addElementTest(SWTBotTreeItem userNode, String name) {
        SWTBotMenu ctxMenu = userNode.select().contextMenu("Add Element").click();
        SWTBotShell newViewShell = bot.shell("Add a new Business Element");
        newViewShell.activate();
        sleep();
        bot.textWithLabel("Business Element Name").setText(name);
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
