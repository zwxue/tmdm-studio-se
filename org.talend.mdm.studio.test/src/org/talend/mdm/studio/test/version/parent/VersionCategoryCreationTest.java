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
package org.talend.mdm.studio.test.version.parent;

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
public class VersionCategoryCreationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem sversionParentItem;

    @Before
    public void runBeforeEveryTest() {
        sversionParentItem = serverItem.getNode("Version");
        sversionParentItem.expand();
    }

    @Test
    public void versionCategoryCreationTest() {
        sversionParentItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestVersionCategory");
        bot.button("OK").click();
        Assert.assertNotNull(sversionParentItem.getNode("TestVersionCategory"));
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        sversionParentItem.getNode("TestVersionCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
