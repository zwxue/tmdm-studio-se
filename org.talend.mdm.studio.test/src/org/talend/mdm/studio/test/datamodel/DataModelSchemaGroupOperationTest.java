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

@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaGroupOperationTest extends TalendSWTBotForMDM {

    private SWTBotTree conceptBotTree;

    private DataModelMainPage mainpage;

    private SWTBotTreeItem conceptNode;

    private SWTBotTreeItem groupItem;

    private SWTBotTreeItem dataModelItem;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();

        SWTBotTreeItem node = dataModelItem.expandNode("System").expand().getNode("Reporting");
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
        conceptNode = conceptBotTree.getTreeItem("Reporting");
        conceptNode.select().expand();
        groupItem = conceptNode.getNode("ReportingType");
    }

    @After
    public void runAfterEveryTest() {
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                mainpage.doSave(new NullProgressMonitor());
            }
        });
    }

    //new feature in 4.2,See bug 0012073
    @Test
    public void addElementTest() {
        groupItem.contextMenu("Add Element").click();
        SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Business Element Name").setText("testElement");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

    @Test
    public void changeSubElementGroupTest() {
        groupItem.contextMenu("Change Sub-Element Group").click();
        sleep();
        SWTBotShell changeTypeShell = bot.shell("Change Sub-Element Group");
        changeTypeShell.activate();
        bot.radio("Choice").click();
        bot.button("OK").click();
        sleep(2);

    }

    @Test
    public void newEntityTest() {
        groupItem.contextMenu("New Entity").click();
        SWTBotShell newEntityShell = bot.shell("New Entity");
        newEntityShell.activate();
        // create a entity with a complex type
        bot.textWithLabel("Name:").setText("ComplexTypeEntity");
        sleep();
        bot.button("OK").click(); // create a entity with a simple type
        sleep(2);
    }

}
