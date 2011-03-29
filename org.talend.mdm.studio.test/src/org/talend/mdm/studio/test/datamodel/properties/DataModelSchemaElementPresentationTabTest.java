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
public class DataModelSchemaElementPresentationTabTest extends
		TalendSWTBotForMDM {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem entityNode;

	private SWTBotTreeItem elementNode;

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
		newElement();
		bot.viewById(IPageLayout.ID_PROP_SHEET).setFocus();
		Util.selecteTalendTabbedPropertyListAtIndex(bot, 1);
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
		entityNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 0).click();
	}

	public void newElement() {
		conceptBotTree.getTreeItem("ComplexTypeEntityType")
				.contextMenu("Add Element").click();

		SWTBotShell newElementShell = bot.shell("Add a new Business Element");
		newElementShell.activate();
		bot.textWithLabel("Business Element Name").setText("Ele");
		sleep();
		bot.button("OK").click();
		sleep(2);
		elementNode = entityNode.getNode("Ele");
		elementNode.select().expand();
	}

	@Test
	public void setDisplayFormatTest() {
		bot.comboBox(0).setSelection(0);
		bot.text(0).setText("test error format in English");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox(0).setSelection(1);
		bot.text(0).setText("test error format in French");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.tree(0).select(1);
		bot.buttonWithTooltip("Del").click();
		bot.button("Apply").click();
	}

	@Test
	public void setLabelsTest() {
		bot.comboBox(1).setSelection(0);
		bot.text(1).setText("en");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox(1).setSelection(1);
		bot.text(1).setText("fr");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.tree(1).select(1);
		bot.buttonWithTooltip("Del").click();
		bot.button("Apply").click();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("English Label: en"));
	}

	@Test
	public void setDescriptionsTest() {
		bot.comboBox(2).setSelection(0);
		bot.text(2).setText("enlish description");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox(2).setSelection(1);
		bot.text(2).setText("french description");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.tree(2).select(1);
		bot.buttonWithTooltip("Del").click();
		bot.button("Apply").click();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("English Description: enlish description"));
	}

	@Test
	public void setFacetTest() {
		bot.comboBox(3).setSelection(0);
		bot.text(3).setText("test error facet in English");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox(3).setSelection(1);
		bot.text(3).setText("test error facet in French");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.tree(3).select(1);
		bot.buttonWithTooltip("Del").click();
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("Facet_Msg_EN: Reporting"));
	}

}
