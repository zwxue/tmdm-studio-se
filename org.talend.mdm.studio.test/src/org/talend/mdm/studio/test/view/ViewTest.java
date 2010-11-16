package org.talend.mdm.studio.test.view;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

public class ViewTest extends StudioTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        initServerView();
    }

    @Test
    public void canCreateView() throws Exception {
        // Create a new view to test the filter of the xpath.
        SWTBotTreeItem viewNode = serverTree.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin").getNode(
                "View [HEAD]");
        viewNode.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell newViewShell = bot.shell("New View");
        newViewShell.activate();
        // bot.buttonWithLabel("...").click();
        bot.buttonWithTooltip("Select one Entity").click();
        bot.shell("Select one Entity").activate();

        // Test filter of the system data model "PROVISIONING"
        bot.comboBoxWithLabel("Data Models:").setSelection("PROVISIONING");
        bot.textWithLabel("Filter:").setText("R");
        sleep();
        bot.textWithLabel("Filter:").setText("U");
        sleep();
        bot.textWithLabel("Filter:").setText("");
        sleep();

        // Test filter of the system data model "CONF"
        bot.comboBoxWithLabel("Data Models:").setSelection("CONF");
        bot.textWithLabel("Filter:").setText("Au");
        sleep();
        bot.textWithLabel("Filter:").setText("Con");
        sleep();
        bot.textWithLabel("Filter:").setText("");
        sleep();

        bot.button("Cancel").click();
        sleep();
        bot.button("Cancel").click();

    }
}
