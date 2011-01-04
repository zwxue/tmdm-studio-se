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
package org.talend.mdm.studio.test.view.parent;

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
public class ViewCategoryCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem viewParentItem;

    private String PREFIX = "Browse_items_";

    @Before
    public void runBeforeEveryTest() {
        viewParentItem = serverItem.getNode("View [HEAD]");
        viewParentItem.expand();
    }

    @Test
    public void viewCategoryCreationTest() {
        viewParentItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestViewCategory");
        bot.button("OK").click();
        Assert.assertNotNull(viewParentItem.getNode("TestViewCategory"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {

        viewParentItem.getNode("TestViewCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
