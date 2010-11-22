package org.talend.mdm.studio.test;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@SuppressWarnings("deprecation")
public class StudioTest {

    protected static SWTWorkbenchBot bot;

    protected static SWTBotTree serverTree;

    protected static Tree swtTree;

    protected static SWTBotTreeItem serverItem;
    static {
        bot = new SWTWorkbenchBot();
        bot.viewByTitle("Welcome").close();
        login();
    }

    private static void login() {
        bot.menu("Window").menu("Open Perspective").menu("Other...").click();
        final SWTBotShell shellShowView = bot.shell("Open Perspective");
        shellShowView.widget.getDisplay().syncExec(new Runnable() {

            public void run() {
                shellShowView.widget.setSize(new Point(300, 600));
            }
        });
        shellShowView.activate();
        bot.table().select("MDM");
        // bot.tree().select("MDM Server");
        bot.button("OK").click();
        bot.perspectiveByLabel("MDM").activate();
        bot.viewByTitle("MDM Server").show();
        bot.viewByTitle("MDM Server").toolbarButton("Add MDM Server Location").click();
        SWTBotShell shell = bot.shell("Talend MDM Studio Login");
        shell.activate();
        bot.textWithLabel("Username").setText("admin");
        bot.textWithLabel("Password").setText("talend");
        bot.button("OK").click();
        bot.sleep(20 * 1000);

    }

    protected static void initServerView() {

        final SWTBotView view = bot.viewById("org.talend.mdm.workbench.views.ServerView");
        view.show();
        view.setFocus();
        // bot.perspectiveById("org.talend.mdm.perstective").activate();
        view.getWidget().getDisplay().syncExec(new Runnable() {

            @Override
            public void run() {
                // SWTBotTree tree=bot.treeWithLabel("http://localhost:8080/talend/TalendPort[HEAD] admin");
                Composite comp = (Composite) view.getWidget();
                comp = (Composite) comp.getChildren()[0];

                swtTree = (Tree) comp.getChildren()[0];
            }
        });
        serverTree = new SWTBotTree(swtTree);
        serverItem = serverTree.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin");
        serverItem.expand();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("AfterClass");
        bot.sleep(2000);
    }

    protected static void sleep() {
        bot.sleep(1000);
    }

    protected static void sleep(int count) {
        bot.sleep(1000 * count);
    }
}
