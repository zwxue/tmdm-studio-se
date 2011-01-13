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
package org.talend.mdm.studio.test.eventmanagement.process.parent;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
public class ProcessCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem processParentNode;

    private String[] creation;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

        processParentNode = eventManagementItem.getNode("Process [HEAD]");
    }

    @After
    public void runAfterEveryTest() {
        processParentNode.select(creation).contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void newTest() {
        String selEle = "Reporting";
        // for normal process
        processParentNode.contextMenu("New").click();
        bot.text().setText("Normal_Process");
        bot.radio("Create a Normal Process").click();
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("Normal_Process"));

        // for smartview process
        processParentNode.contextMenu("New").click();
        bot.radio("Create a Smartview Process").click();
        selecteXpath(selEle);
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("Smart_view_" + selEle));

        // for normal process
        processParentNode.contextMenu("New").click();
        bot.radio("Create a Before-Saving Process").click();
        selecteXpath(selEle);
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("beforeSaving_" + selEle));

        // for normal process
        processParentNode.contextMenu("New").click();
        bot.radio("Create a Before-Deleting Process").click();
        selecteXpath(selEle);
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("beforeDeleting_" + selEle));

        // for normal process
        processParentNode.contextMenu("New").click();
        bot.radio("Create a Runable Process").click();
        selecteXpath(selEle);
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("Runnable_" + selEle));

        // for normal process
        processParentNode.contextMenu("New").click();
        bot.radio("Create a Standalone Process").click();
        selecteXpath(selEle);
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        Assert.assertNotNull(processParentNode.expand().getNode("Runnable#" + selEle));

        creation = new String[] { "Normal_Process", "Smart_view_" + selEle, "beforeSaving_" + selEle, "beforeDeleting_" + selEle,
                "Runnable_" + selEle };
    }

    private void selecteXpath(String selEle) {
        bot.buttonWithTooltip("Select one Entity").click();
        bot.comboBox().setSelection(selEle);
        sleep();
        bot.tree().select(selEle);
        sleep();
        bot.button("Add").click();
        sleep();
    }

}
