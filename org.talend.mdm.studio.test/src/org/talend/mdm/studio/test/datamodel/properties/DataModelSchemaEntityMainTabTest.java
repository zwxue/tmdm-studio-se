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
package org.talend.mdm.studio.test.datamodel.properties;

import junit.framework.Assert;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IPageLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;
import org.talend.mdm.studio.test.util.Util;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;

/**
 * 
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaEntityMainTabTest extends TalendSWTBotForMDM {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem conceptNode;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();

		SWTBotTreeItem node = dataModelItem.expandNode("System").getNode(
				"Reporting");
		node.doubleClick();

		dataModelItem.contextMenu("New").click();
		SWTBotShell newDataContainerShell = bot.shell("New Data Model");
		newDataContainerShell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a name for the New Instance");
		text.setText("TestDataModel");
		sleep();
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(dataModelItem.getNode("TestDataModel"));
		sleep(2);

		final SWTBotEditor editor = bot.editorByTitle("TestDataModel");
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				XSDEditor ep = (XSDEditor) editor.getReference().getPart(true);
				mainpage = (DataModelMainPage) ep.getSelectedPage();
			}
		});
		Tree conceptTree = mainpage.getTreeViewer().getTree();
		conceptBotTree = new SWTBotTree(conceptTree);

		newEntity();
		bot.viewById(IPageLayout.ID_PROP_SHEET).setFocus();
		Util.selecteTalendTabbedPropertyListAtIndex(bot, 0);
	}

	@After
	public void runAfterEveryTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
				bot.activeEditor().close();
			}
		});
		dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
		bot.button("OK").click();
	}

	public void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		conceptNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 0).click();
	}

	@Test
	public void editEntityTest() {
		bot.textWithLabel("Name").setText("RenameEntity");
		bot.button("Apply").click();
		Assert.assertEquals("RenameEntity", conceptNode.getText());
	}

	@Test
	public void addKeyTest() {
		bot.buttonWithTooltip("Add key...").click();
		SWTBotShell shell = bot.shell("Add a new Key");
		shell.activate();
		bot.ccomboBox(0).setSelection(1);
		bot.text().setText("Test");
		bot.button("OK").click();

		bot.button("Apply").click();
		Assert.assertNotNull(conceptNode.getNode("Test"));
	}

	@Test
	public void deleteKeyTest() {
		bot.tree(0).select("Test");
		bot.buttonWithTooltip("Delete keys").click();

		bot.button("Apply").click();
		Assert.assertTrue(conceptNode.getNode("Test") == null);
	}

	@Test
	public void addFieldTest() {
		bot.buttonWithTooltip("Add field...").click();
		SWTBotShell shell = bot.shell("Select one field");
		shell.activate();
		bot.ccomboBox().setText("Test");
		bot.button("OK").click();

		bot.button("Apply").click();
		Assert.assertNotNull(conceptNode.getNode("Test").getNode("Test"));
	}

	@Test
	public void editFieldTest() {
		bot.tree(0).select("Test");
		bot.buttonWithTooltip("Edit Field...").click();
		SWTBotShell shell = bot.shell("Select one field");
		shell.activate();
		bot.ccomboBox().setText("Test1");
		bot.button("OK").click();

		bot.button("Apply").click();
		Assert.assertNotNull(conceptNode.getNode("Test1").getNode("Test"));
	}

	@Test
	public void deleteFieldTest() {
		bot.tree(0).select("Test1");
		bot.buttonWithTooltip("Delete Fields").click();

		bot.button("Apply").click();
		Assert.assertTrue(conceptNode.getNode("Test").getNode("Test1") == null);
	}

}
