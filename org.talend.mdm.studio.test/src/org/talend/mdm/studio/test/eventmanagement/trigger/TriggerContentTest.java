// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.studio.test.eventmanagement.trigger;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.eventmanagement.EventManagementTest;

/**
 * TriggerContentTest is a test class to imitate the process to create the steps of a Trigger.This class will imitate
 * the way to create a Trigger like DStarAgentCommissionChangeModified in DStar.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 */
public class TriggerContentTest extends EventManagementTest {

    private static SWTBotTreeItem triggerParentNode;

    private String[] array = new String[] { "DataModel  [0...1]", "Concept", "OperationType" };

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
        triggerParentNode.contextMenu("New").click();
        bot.text().setText("TriggerDemo");
        bot.button("OK").click();
        sleep(2);
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                bot.activeEditor().save();
            }
        });
    }

    @Test
    public void setDescriptionTest() {
        bot.textWithLabel("Description").setText("Agent updated trigger");
    }

    @Test
    public void setEntityTest() {
        bot.buttonWithTooltip("Select an Entity").click();
        bot.comboBox().setSelection("UpdateReport");
        sleep();
        bot.tree().select("Update");
        sleep();
        bot.button("Add").click();
        sleep();
    }

    @Test
    public void setServiceTest() {
        bot.comboBoxWithLabel("Service JNDI Name").setSelection("callprocess");
        bot.textWithLabel("Service Parameters").setText("process=UpdateOperationalSystems");
    }

    @Test
    public void setXpathTest() {
        bot.buttonWithTooltip("Add Multiple").click();

        bot.shell("Select Multiple XPaths").activate();
        bot.comboBox().setSelection("UpdateReport");
        sleep();
        SWTBotTreeItem parent = bot.tree().getTreeItem("Update").expand().getNode("Update").expand();
        parent.select(array);
        sleep();
        bot.button("Add").click();
        sleep();

        bot.buttonWithTooltip("Add Multiple").click();
        bot.shell("Select Multiple XPaths").activate();
        bot.comboBox().setSelection("UpdateReport");
        sleep();
        parent = bot.tree().getTreeItem("Update").expand().getNode("Update").expand().getNode("Item  [0...many]").expand()
                .getNode(0).expand();
        parent.select(new String[] { "path  [0...1]" });
        sleep();
        bot.button("Add").click();
        sleep();
        for (int i = 0; i < array.length; i++) {
            bot.table().click(i, 1);
            bot.ccomboBox().setSelection("=");
        }
        bot.table().click(3, 1);
        bot.ccomboBox().setSelection("Contains");
        sleep();

        bot.table().click(0, 2);
        sleep();
        bot.text().setText("DStar");
        bot.table().click(1, 2);
        sleep();
        bot.text().setText("Agent");
        bot.table().click(2, 2);
        sleep();
        bot.text().setText("UPDATE");
        bot.table().click(3, 2);
        sleep();
        bot.text().setText("CommissionCode");
        sleep();

        bot.table().click(0, 3);
        sleep();
        bot.text().setText("C0");
        bot.table().click(1, 3);
        sleep();
        bot.text().setText("C1");
        bot.table().click(2, 3);
        sleep();
        bot.text().setText("C2");
        bot.table().click(3, 3);
        sleep();
        bot.text().setText("C3");
        sleep(2);
    }

    @Test
    public void testConditions() {
        // bot.textInGroup("Conditions:").typeText("C0");
        // bot.buttonInGroup("And", "Conditions").click();
        // bot.textInGroup("Conditions:").typeText("C1");
        // bot.buttonInGroup("And", "Conditions").click();
        // bot.textInGroup("Conditions:").typeText("C2");
        // bot.buttonInGroup("And", "Conditions").click();
        // bot.textInGroup("Conditions:").typeText("C3");
        // bot.buttonInGroup("And", "Conditions").click();
        bot.textInGroup("Conditions:").setText("C0 And C1 And C2");
    }
}
