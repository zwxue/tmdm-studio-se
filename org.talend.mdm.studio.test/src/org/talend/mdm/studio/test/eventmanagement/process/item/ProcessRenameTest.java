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
package org.talend.mdm.studio.test.eventmanagement.process.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
public class ProcessRenameTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem processParentNode;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        processParentNode = eventManagementItem.getNode("Process [HEAD]");
        // for normal process
        processParentNode.contextMenu("New").click();
        bot.text().setText("Normal_Process");
        bot.radio("Create a Normal Process").click();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        bot.activeEditor().close();
        processParentNode.expand();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        processParentNode.getNode("Normal_Process").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
    }

    @Test
    public void renameProcessTest() {
        SWTBotTreeItem processNode = processParentNode.getNode("Normal_Process");
        SWTBotMenu renameMenu = processNode.contextMenu("Rename");
        sleep();
        renameMenu.click();
        SWTBotShell renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("RenameProcess");
        bot.button("OK").click();
        Assert.assertNotNull(processParentNode.expand().getNode("RenameProcess"));
        // revert the rename operation
        processNode = processParentNode.getNode("RenameProcess");
        processNode.contextMenu("Rename").click();
        renameShell = bot.shell("Rename");
        renameShell.activate();
        bot.textWithLabel("Please enter a new name").setText("Normal_Process");
        bot.button("OK").click();
    }

}
