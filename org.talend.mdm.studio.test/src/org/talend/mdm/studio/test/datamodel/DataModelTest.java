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

        SWTBotTreeItem node = serverTree.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin").getNode(
                "Data Model [HEAD]");
        node.expand();

        node = node.expandNode("System").getNode("PROVISIONING");
        node.doubleClick();
        final SWTBotEditor editor = bot.editorByTitle("PROVISIONING");
        // bot.getDisplay().syncExec(new Runnable() {
        //
        // public void run() {
        // Matcher<Label> matcher=anything("Data-model:PROVISIONING");
        XObjectEditor ep = (XObjectEditor) editor.getReference().getPart(true);
        DataModelMainPage mainpage = (DataModelMainPage) ep.getPage(0);
        Tree conceptTree = mainpage.getTreeViewer().getTree();

        //				
        SWTBotTree tree = new SWTBotTree(conceptTree);
        SWTBotTreeItem node1 = tree.getTreeItem("User");
        node1.expand();
        node1.getNode(0).expand();
        SWTBotTreeItem userNode = node1.getNode(0).getNode("password");
        userNode.setFocus();
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
        ctxMenu = userNode.select().contextMenu("Set the Workflow Access").click();
        sleep();
        bot.button("Cancel").click();
        sleep();
        // }
        // });

    }
}
