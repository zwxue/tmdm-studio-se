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
package org.talend.mdm.studio.test.menu;

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
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class MenuParentOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem menuParentItem;

    @Before
    public void runBeforeEveryTest() {
        menuParentItem = serverItem.getNode("Menu [HEAD]");
        menuParentItem.expand();
    }

    @Test
    public void MenuCreationTest() {
        menuParentItem.contextMenu("New").click();
        SWTBotShell shell = bot.shell("New Menu");
        shell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the Menu:");
        text.setText("TestMenu");
        sleep();
        bot.button("OK").click();
        sleep();
        bot.activeEditor().save();
        Assert.assertNotNull(menuParentItem.getNode("TestMenu"));
        sleep(2);
    }

    @Test
    public void MenuCategoryCreationTest() {
        menuParentItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestMenuCategory");
        bot.button("OK").click();
        Assert.assertNotNull(menuParentItem.getNode("TestMenuCategory"));
        sleep(2);
    }

    @Test
    public void MenuBrowseRevisionTest() {
        menuParentItem.contextMenu("Browse Revision").click();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        menuParentItem.getNode("TestMenu").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        menuParentItem.getNode("TestMenuCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
