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

/**
 * StudioTest is a superclass of all the SWTBot test classes on studio,except LoginTest and LogoutTest.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class TalendSWTBotForMDM {

    protected static SWTWorkbenchBot bot;

    private static SWTBotTree serverTree;

    private static Tree swtTree;

    protected static SWTBotTreeItem serverItem;

    private static boolean isLoggined = false;

    public static void login() {

        bot.viewByTitle("MDM Server").toolbarButton("Add MDM Server Location").click();
        SWTBotShell shell = bot.shell("Talend MDM Studio Login");
        shell.activate();
        sleep();
        bot.textWithLabel("Username").setText("admin");
        sleep();
        bot.textWithLabel("Password").setText("talend");
        sleep();
        if (bot.comboBoxWithLabel("Version").itemCount() > 0)
            bot.comboBoxWithLabel("Version").setSelection(0);
        sleep();
        bot.checkBox("Save this MDM Server Location").select();
        sleep();
        bot.button("OK").click();
        sleep(10);

    }

    private static void initServerView() {

        final SWTBotView view = bot.viewById("org.talend.mdm.workbench.views.ServerView");
        view.show();
        view.setFocus();
        // bot.perspectiveById("org.talend.mdm.perstective").activate();
        view.getWidget().getDisplay().syncExec(new Runnable() {

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
        // System.out.println("beforeClass");
        if (!isLoggined) {
            bot = new SWTWorkbenchBot();
            // SWTBotView welcomeView = bot.viewByTitle("Welcome");
            // if (welcomeView != null)
            // welcomeView.close();
            bot.menu("Window").menu("Open Perspective").menu("Other...").click();
            final SWTBotShell shellShowView = bot.shell("Open Perspective");
            shellShowView.widget.getDisplay().syncExec(new Runnable() {

                public void run() {
                    shellShowView.widget.setSize(new Point(300, 600));
                }
            });
            shellShowView.activate();
            bot.table().select("MDM");
            bot.button("OK").click();
            bot.perspectiveByLabel("MDM").activate();
            bot.viewByTitle("MDM Server").show();
            login();
            initServerView();
            isLoggined = true;
        }
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("AfterClass");
        // logout();
        bot.sleep(2000);
    }

    public static void logout() {
        serverItem.contextMenu("Logout").click();
    }

    protected static void sleep() {
        bot.sleep(1000);
    }

    protected static void sleep(int count) {
        bot.sleep(1000 * count);
    }
}
