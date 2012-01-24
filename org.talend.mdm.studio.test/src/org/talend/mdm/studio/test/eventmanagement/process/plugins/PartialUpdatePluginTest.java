// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

package org.talend.mdm.studio.test.eventmanagement.process.plugins;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;
import org.talend.mdm.studio.test.util.Util;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PartialUpdatePluginTest extends TalendSWTBotForMDM {
	private SWTBotTreeItem processParentNode;

	private static final long ONE_MINUTE_IN_MILLISEC = 60000;

	private String testValue = "<Patent><id>3</id><firstname>ss</firstname><lastname>ff</lastname><children><child>[5]</child><child>[6]</child><child>[7]</child><child>[8]</child></children></Patent>";

	private SWTBotTreeItem eventManagementItem;

	private String expectedResult = "<Patent><id>3</id><firstname>ss</firstname><lastname>ff</lastname><children><child>[1]</child><child>[2]</child><child>[5]</child><child>[6]</child><child>[7]</child><child>[8]</child><child>[3]</child><child>[4]</child></children></Patent>";;

	@Before
	public void runBeforeEveryTest() {
		eventManagementItem = serverItem.getNode("Event Management");
		eventManagementItem.expand();
		init();
	}

	@After
	public void runAfterEveryTest() {
		bot.activeEditor().close();
	}

	private void init() {
		processParentNode = eventManagementItem.getNode("Process [HEAD]");
		// for normal process
		processParentNode.contextMenu("Import").click();
		bot.shell("Import Objects").activate();
		bot.radio("Select archive file:").click();
		try {
			bot.text(1).setText(
					Util.getFileFromCurrentPluginSampleFolder(
							"PartialUpdate.zip").getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		sleep(10);
		bot.button("Finish").click();
		bot.waitUntil(
				Conditions.shellCloses(bot.shell("Progress Information")),
				ONE_MINUTE_IN_MILLISEC * 10);
	}

	@Test
	public void partialUpdatePluginTest() {
		processParentNode.expand().getNode("PartialUpdateProcess")
				.doubleClick();
		sleep(2);
		// bot.tree().select(0);
		bot.buttonWithTooltip("Execute...").click();
		bot.textWithLabel("Value").setText(testValue);
		bot.buttonWithTooltip("Add").click();
		bot.button("OK").click();
		bot.button("Close").click();
		bot.activeEditor().close();
		// Check:
		serverItem.getNode("Data Container").expand().getNode("PartialUpdate")
				.doubleClick();
		bot.buttonWithTooltip("Search").click();
		bot.table().doubleClick(0, 0);

		// TODO:the tabitem doesn't show.
		// bot.tabItem(1).activate();
		// String result = bot.styledText().getText();
		// Assert.assertEquals(result, expectedResult);
	}

}
