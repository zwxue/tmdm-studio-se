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
package org.talend.mdm.studio.test.version.item;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class VersionEditTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem versionParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        versionParentItem = serverItem.getNode("Version");
        versionParentItem.expand();

        versionParentItem.contextMenu("New").click();
        SWTBotShell newversionShell = bot.shell("New Version");
        newversionShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestVersion");
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        spItem = versionParentItem.getNode("TestVersion");
        Assert.assertNotNull(spItem);
        sleep(2);
    }

    @Test
    public void versionEditTest() {
        SWTBotMenu editMenu = spItem.contextMenu("Edit");
        sleep();
        editMenu.click();
    }

    @After
    public void runAfterEveryTest() {
        bot.activeEditor().close();
        versionParentItem.getNode("TestVersion").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
