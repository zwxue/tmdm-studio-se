// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * ProcessContentTest is a test class to imitate the process to create the steps
 * of a process.This class will imitate the way to create a process like
 * UpdateOperationalSystems in DStar.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ProcessContentTest extends TalendSWTBotForMDM {

	private SWTBotTreeItem processParentNode;

	private String GETITEM_PARAMETERS = "";

	private String DECODE_PARAMETERS = "<parameters>                  <method>DECODE</method> <algorithm>XMLESCAPE</algorithm> </parameters>";

	private String firStep = "getItem";

	private String secStep = "Decode XML";

	private String thiStep = "call job";

	private SWTBotTreeItem eventManagementItem;

	@Before
	public void runBeforeEveryTest() {
		eventManagementItem = serverItem.getNode("Event Management");
		eventManagementItem.expand();

	}

	@After
	public void runAfterEveryTest() {
	}

	private void init() {
		processParentNode = eventManagementItem.getNode("Process [HEAD]");
		// for normal process
		processParentNode.contextMenu("New").click();
		bot.text().setText("ProcessDemoTest");
		bot.radio("Create a Normal Process").click();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void setDescriptionTest() {
		init();
		bot.buttonWithTooltip("Set the Descriptions").click();
		bot.shell("Set the Descriptions").activate();
		bot.comboBox().setSelection("English");
		String des = "Call a job to update the operation systems with the new agent information";
		bot.text().setText(des);
		bot.buttonWithTooltip("Add").click();
		bot.button("OK").click();
		Assert.assertEquals("[EN:" + des + "]", bot.text(0).getText());
	}

	@Test
	public void setFirstStepTest() {

		bot.textWithLabel("Step Description").setText(firStep);
		bot.buttonWithTooltip("Add").click();
		bot.list().select(firStep);
		Assert.assertNotNull(bot.list().selection());
		bot.ccomboBoxWithLabel("Plugin name").setSelection("xslt");
		// add the input variables.
		bot.ccomboBoxWithLabel("Input Parameters").setSelection("xml");
		bot.buttonWithTooltip(
				"Add a link for Input Variables and Process Plugin's Input Parameters")
				.click();
		// add the output variables.
		bot.ccomboBoxWithLabel("Output Parameters").setSelection("text");
		bot.buttonWithTooltip(
				"Add a link for output Variables and output Parameters")
				.click();
		bot.styledText().setText(GETITEM_PARAMETERS);
	}

	@Test
	public void setSecondStepTest() {

		bot.textWithLabel("Step Description").setText(secStep);
		bot.buttonWithTooltip("Add").click();
		bot.list().select(secStep);
		Assert.assertNotNull(bot.list().selection());
		bot.ccomboBoxWithLabel("Plugin name").setSelection("codec");
		// add the input variables.
		bot.ccomboBoxWithLabel("Input Parameters").setSelection("law_text");
		bot.buttonWithTooltip(
				"Add a link for Input Variables and Process Plugin's Input Parameters")
				.click();
		// add the output variables.
		bot.ccomboBoxWithLabel("Output Parameters").setSelection("codec_text");
		bot.buttonWithTooltip(
				"Add a link for output Variables and output Parameters")
				.click();
		bot.styledText().setText(DECODE_PARAMETERS);
		// new feature in 4.2,see bug 0017999
		bot.checkBox("Auto-indent").select();
		bot.activeEditor().save();
	}

	@Test
	public void setThirdStepTest() {
		bot.textWithLabel("Step Description").setText(thiStep);
		bot.buttonWithTooltip("Add").click();
		bot.list().select(thiStep);
		Assert.assertNotNull(bot.list().selection());
		bot.ccomboBoxWithLabel("Plugin name").setSelection("callJob");
		// add the input variables.
		bot.ccomboBoxWithLabel("Input Parameters").setSelection("text");
		bot.buttonWithTooltip(
				"Add a link for Input Variables and Process Plugin's Input Parameters")
				.click();
		// add the output variables.
		bot.ccomboBoxWithLabel("Output Parameters").setSelection("result");
		bot.buttonWithTooltip(
				"Add a link for output Variables and output Parameters")
				.click();
		// bot.tabItem("Source").Text(CALLJOB_PARAMETERS);
		bot.activeEditor().close();
	}
}
