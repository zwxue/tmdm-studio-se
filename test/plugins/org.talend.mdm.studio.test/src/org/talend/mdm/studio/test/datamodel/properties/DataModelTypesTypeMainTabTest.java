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
public class DataModelTypesTypeMainTabTest extends TalendSWTBotForMDM {

	private SWTBotTree typesBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem typeNode;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();

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
		Tree typesTree = mainpage.getTypesViewer().getTree();
		typesBotTree = new SWTBotTree(typesTree);

		addComplexType();
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

	private void addComplexType() {
		typesBotTree.contextMenu("Create a Complex Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Complex Type Properties");
		changeTypeShell.activate();
		bot.ccomboBox(0).setText("TestComplexType");
		bot.radio("Sequence").click();
		bot.button("OK").click();
		sleep(2);

		typeNode = typesBotTree.getTreeItem("TestComplexType");
		typeNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 1).click();
	}

	@Test
	public void editTypeNameTest() {
		bot.textWithLabel("Name").setText("ComplexType");
		// bot.button("Apply").click();
		Assert.assertEquals("ComplexType", typeNode.getText());
	}

	@Test
	public void changeGroupTest() {
		bot.radioInGroup("All", "Sub-Elements Group").click();
	}

}
