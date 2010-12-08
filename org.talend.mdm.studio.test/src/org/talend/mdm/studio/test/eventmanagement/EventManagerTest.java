package org.talend.mdm.studio.test.eventmanagement;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventManagerTest extends EventManagementTest {

    private static SWTBotTreeItem eventManagerNode;

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        eventManagerNode = eventManagementItem.getNode("Event Manager");
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void browseTest() {
        eventManagerNode.contextMenu("Browse").click();
    }

    @Test
    public void statusTest() {
        bot.buttonWithTooltip("Start").click();
        sleep();
        bot.buttonWithTooltip("Suspend").click();
        sleep();
        bot.buttonWithTooltip("Stop").click();
        sleep();
    }

    @Test
    public void searchTest() {
        // bot.comboBoxWithLabel("Status").setSelection(0);
        // bot.buttonWithTooltip("Search").click();
        // sleep();
        bot.comboBoxWithLabel("Status").setSelection(1);
        bot.buttonWithTooltip("Search").click();
        sleep();
        // bot.comboBoxWithLabel("Status").setSelection(2);
        // bot.buttonWithTooltip("Search").click();
        // sleep();

    }
}
