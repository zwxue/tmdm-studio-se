package org.talend.mdm.studio.test.view;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ViewTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem viewItem;

    @Before
    public void runBeforeEveryTest() {
        viewItem = serverItem.getNode("View [HEAD]");
        viewItem.expand();
    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void canCreateView() throws Exception {
        // Create a new view to test the filter of the xpath.
        viewItem.contextMenu("New").click();
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
