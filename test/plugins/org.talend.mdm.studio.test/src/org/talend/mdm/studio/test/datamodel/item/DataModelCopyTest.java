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
package org.talend.mdm.studio.test.datamodel.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelCopyTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem dataModelItem;

    @Before
    public void runBeforeEveryTest() {
        dataModelItem = serverItem.getNode("Data Model [HEAD]");
        dataModelItem.expand();

        dataModelItem.contextMenu("New").click();
        SWTBotShell newdataModelShell = bot.shell("New Data Model");
        newdataModelShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        text.setText("TestDataModel");
        sleep();
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
        sleep(2);
        SWTBotTreeItem newNode = dataModelItem.getNode("TestDataModel");
        Assert.assertNotNull(newNode);
        sleep(2);
    }

    @Test
    public void dataModelCopyTest() {
        SWTBotTreeItem newNode = dataModelItem.getNode("TestDataModel");
        SWTBotMenu editMenu = newNode.contextMenu("Copy");
        editMenu.click();
        sleep();
        newNode.contextMenu("Paste").click();
        SWTBotShell pastedataModelShell = bot.shell("Pasting instance TestDataModel");
        pastedataModelShell.activate();
        bot.text("CopyOfTestDataModel").setText("PasteDataModel");
        bot.button("OK").click();
        SWTBotTreeItem pasteNode = dataModelItem.getNode("PasteDataModel");
        Assert.assertNotNull(pasteNode);
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
    	bot.activeEditor().save();
    	bot.activeEditor().close();
        dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        dataModelItem.getNode("PasteDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

    }
}
