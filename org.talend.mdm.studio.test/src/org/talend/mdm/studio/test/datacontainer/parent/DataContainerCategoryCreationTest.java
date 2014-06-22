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
package org.talend.mdm.studio.test.datacontainer.parent;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
public class DataContainerCategoryCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem dataContainerItem;

    @Before
    public void runBeforeEveryTest() {
        dataContainerItem = serverItem.getNode("Data Container");
        dataContainerItem.expand();
    }

    @Test
    public void dataContainerCategoryCreationTest() {
        dataContainerItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestDataContainerCategory");
        bot.button("OK").click();
        sleep();
        SWTBotTreeItem cateNode = dataContainerItem.getNode("TestDataContainerCategory");
        Assert.assertNotNull(cateNode);
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {

        dataContainerItem.getNode("TestDataContainerCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
