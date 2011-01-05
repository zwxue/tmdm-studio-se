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
package org.talend.mdm.studio.test.eventmanagement.process.item;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class ProcessDuplicateTest extends TalendSWTBotForMDM {

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

        processParentNode.getNode("DuplicateNormal_Process").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();

    }

    @Test
    public void duplicateProcessTest() {
        processParentNode.getNode("Normal_Process").contextMenu("Duplicate").click();
        SWTBotShell shell = bot.shell("Pasting instance Normal_Process");
        shell.activate();
        bot.text("CopyOfNormal_Process").setText("DuplicateNormal_Process");
        sleep();
        bot.button("OK").click();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("DuplicateNormal_Process"));
    }

}
