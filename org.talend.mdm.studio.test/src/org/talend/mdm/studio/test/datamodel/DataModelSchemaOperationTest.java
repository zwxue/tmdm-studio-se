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
package org.talend.mdm.studio.test.datamodel;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.XObjectEditor;

/**
 * DataModelOperationTest2 is a SWTBot test class to test the operation associated with the filter,expand,collapse,up
 * and down.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataModelSchemaOperationTest extends DataModelTest {

    private static SWTBotTree conceptBotTree;

    private static DataModelMainPage mainpage;

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        SWTBotTreeItem node = dataModelItem.expandNode("System").getNode("Reporting");
        node.doubleClick();

        final SWTBotEditor editor = bot.editorByTitle("Reporting");
        XObjectEditor ep = (XObjectEditor) editor.getReference().getPart(true);
        mainpage = (DataModelMainPage) ep.getPage(0);
        Tree conceptTree = mainpage.getTreeViewer().getTree();
        conceptBotTree = new SWTBotTree(conceptTree);
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
        Display.getDefault().syncExec(new Runnable() {

            @Override
            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
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
        bot.toolbarToggleButtonWithTooltip("Expand...").click();
        sleep(2);
        // conceptNode.expand();
        // conceptNode.getNode(0).expand();
        // SWTBotTreeItem userNode = conceptNode.getNode(0).getNode("ReportingName");
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
