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
package org.talend.mdm.studio.test.eventmanagement.trigger;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;


/**
 * DOC rhou  class global comment. Detailled comment
 */
public class GUIExtensionForTriggerTest extends TalendSWTBotForMDM {
    private SWTBotTreeItem triggerParentNode;

    private SWTBotTreeItem eventManagementItem;

    @Before
    public void runBeforeEveryTest() {
        eventManagementItem = serverItem.getNode("Event Management");
        eventManagementItem.expand();

    }

    @After
    public void runAfterEveryTest() {
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                bot.activeEditor().save();
            }
        });
    }
    //new feature in 4.2,see bug 0017974:
    @Test
    public void extensionForTriggerTest() {
        triggerParentNode = eventManagementItem.getNode("Trigger [HEAD]");
        triggerParentNode.contextMenu("New").click();
        bot.text().setText("TriggerDemo");
        bot.button("OK").click();
        bot.comboBoxWithLabel("Service JNDI Name").setSelection(0);
        String process= bot.tree().select(1).getText();
        bot.tabItem(1).activate();
        Assert.assertEquals("process="+process,bot.styledText().getText());
        bot.activeEditor().save();
        triggerParentNode.expand();
        sleep();
    }


}
