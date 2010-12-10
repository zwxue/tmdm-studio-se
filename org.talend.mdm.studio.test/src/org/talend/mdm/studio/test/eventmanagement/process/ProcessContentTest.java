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
package org.talend.mdm.studio.test.eventmanagement.process;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.eventmanagement.EventManagerTest;

/**
 * ProcessContentTest is a test class to imitate the process to create the steps of a process.This class will imitate
 * the way to create a process like UpdateOperationalSystems in DStar.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 */
public class ProcessContentTest extends EventManagerTest {

    private static SWTBotTreeItem processParentNode;

    private String GETITEM_PARAMETERS = "";

    private String DECODE_PARAMETERS = "<parameters> <method>DECODE</method> <algorithm>XMLESCAPE</algorithm> </parameters>";

    private String CALLJOB_PARAMETERS = "";

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        // run for one time before all test cases
        processParentNode = eventManagementItem.getNode("Process [HEAD]");
        // for normal process
        processParentNode.contextMenu("New").click();
        bot.text().setText("ProcessDemo");
        bot.radio("Create a Normal Process").click();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        bot.activeEditor().close();
        processParentNode.expand();
        sleep();
        processParentNode.getNode("ProcessDemo").doubleClick();
        sleep(2);
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void setDescriptionTest() {
        bot.buttonWithTooltip("Set the Descriptions").click();
        bot.shell("Set the Descriptions").activate();
        bot.ccomboBox().setSelection("English");
        bot.text().setText("Call a job to update the operation systems with the new agent information");
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
    }

    @Test
    public void setFirstStepTest() {
        bot.textWithLabel("Step Description").setText("getItem");
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBoxWithLabel("Plugin name").setSelection("xslt");
        // add the input variables.
        bot.ccomboBoxWithLabel("Input Parameters").setSelection("xml");
        bot.buttonWithTooltip("Add a link for Input Variables and Process Plugin's Input Parameters").click();
        // add the output variables.
        bot.ccomboBoxWithLabel("Output Parameters").setSelection("text");
        bot.buttonWithTooltip("Add a link for output Variables and output Parameters").click();

        bot.textWithLabel("Parameters").setText(GETITEM_PARAMETERS);
    }

    @Test
    public void setSecondStepTest() {
        bot.textWithLabel("Step Description").setText("Decode XML");
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBoxWithLabel("Plugin name").setSelection("codec");
        // add the input variables.
        bot.ccomboBoxWithLabel("Input Parameters").setSelection("law_text");
        bot.buttonWithTooltip("Add a link for Input Variables and Process Plugin's Input Parameters").click();
        // add the output variables.
        bot.ccomboBoxWithLabel("Output Parameters").setSelection("codec_text");
        bot.buttonWithTooltip("Add a link for output Variables and output Parameters").click();

        bot.textWithLabel("Parameters").setText(DECODE_PARAMETERS);
    }

    @Test
    public void setThirdStepTest() {
        bot.textWithLabel("Step Description").setText("call job");
        bot.buttonWithTooltip("Add").click();

        bot.ccomboBoxWithLabel("Plugin name").setSelection("calljob");
        // add the input variables.
        bot.ccomboBoxWithLabel("Input Parameters").setSelection("text");
        bot.buttonWithTooltip("Add a link for Input Variables and Process Plugin's Input Parameters").click();
        // add the output variables.
        bot.ccomboBoxWithLabel("Output Parameters").setSelection("result");
        bot.buttonWithTooltip("Add a link for output Variables and output Parameters").click();

        bot.textWithLabel("Parameters").setText(CALLJOB_PARAMETERS);
    }
}
