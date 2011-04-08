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
package org.talend.mdm.studio.test.datamodel;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;

/**
 * 
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaOperationTest extends TalendSWTBotForMDM {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();

		SWTBotTreeItem node = dataModelItem.expandNode("System").expand().getNode(
				"Reporting");
		node.doubleClick();

		final SWTBotEditor editor = bot.editorByTitle("Reporting");
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				XSDEditor ep = (XSDEditor) editor.getReference().getPart(true);
				mainpage = (DataModelMainPage) ep.getSelectedPage();
			}
		});
		Tree conceptTree = mainpage.getTreeViewer().getTree();
		conceptBotTree = new SWTBotTree(conceptTree);
	}

	@After
	public void runAfterEveryTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
			}
		});
		bot.activeEditor().close();
	}

	// @Test
	public void filterTest() {
		bot.toolbarRadioButtonWithTooltip("Filter...").click();
		SWTBotShell filterShell = bot.shell("Data Model Filter");
		filterShell.activate();
		bot.ccomboBox().setSelection(1);
		sleep();
		bot.radio(3).click();
		sleep();
		bot.button("OK").click();
		sleep();
		bot.toolbarButtonWithTooltip("Filter...").click();
		filterShell = bot.shell("Data Model Filter");
		filterShell.activate();
		bot.ccomboBox().setSelection(0);
		sleep();
		bot.radio(0).click();
		sleep();
		bot.button("OK").click();
	}

	@Test
	public void expandTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand...").click();
		sleep(2);
		// conceptNode.expand();
		// conceptNode.getNode(0).expand();
		// SWTBotTreeItem userNode =
		// conceptNode.getNode(0).getNode("ReportingName");
		// userNode.setFocus();
		// sleep(3);
	}

	// @Test
	public void collapseTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Collapse...").click();
		sleep(2);
	}

	// @Test
	public void expandModelGroupTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand ModelGroup...").click();
		sleep(2);
	}

	// @Test
	public void elementUpTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.getNode("ReportingType").getNode("Cluster").select();
		bot.toolbarButtonWithTooltip("UP...").click();
		sleep();
		bot.toolbarButtonWithTooltip("UP...").click();
		sleep(2);
	}

	// @Test
	public void elementDownTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.getNode("ReportingType").getNode("Cluster").select();
		bot.toolbarButtonWithTooltip("DOWN...").click();
		sleep();
		bot.toolbarButtonWithTooltip("DOWN...").click();
		sleep(2);
	}

	// @Test
	public void labelOperationTest() {
		SWTBotTreeItem conceptNode = conceptBotTree.getTreeItem("Reporting");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand...").click();
		sleep();
		bot.comboBoxWithLabel("Language:").setSelection(1);
		bot.buttonWithTooltip("Add...").click();
		sleep(2);
		bot.buttonWithTooltip("Remove...").click();
		sleep(2);
	}
}
