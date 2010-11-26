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
package org.talend.mdm.studio.test.datacontainer;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amalto.workbench.editors.DataClusterBrowserMainPage;
import com.amalto.workbench.editors.XObjectBrowser;

/**
 * DataContainerRecordOperationTest is SWTBot test class to test the operation on the records.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataContainerRecordOperationTest extends DataContainerTest {

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void recordEditTest() {
        SWTBotTreeItem node = dataContainerItem.expandNode("System").getNode("PROVISIONING");
        node.doubleClick();
        bot.buttonWithTooltip("Search").click();
        sleep(2);
        XObjectBrowser ep = (XObjectBrowser) bot.activeEditor().getReference().getPart(true);
        DataClusterBrowserMainPage mainpage = (DataClusterBrowserMainPage) ep.getPage(0);
        Table conceptTree = mainpage.getResultsViewer().getTable();

        SWTBotTable conceptBotTree = new SWTBotTable(conceptTree);
        conceptBotTree.select(1, 1);
        conceptBotTree.contextMenu("New Record").click();
        SWTBotShell newDataContainerShell = bot.shell("XML Editor/Viewer");
        newDataContainerShell.activate();
    }
}
