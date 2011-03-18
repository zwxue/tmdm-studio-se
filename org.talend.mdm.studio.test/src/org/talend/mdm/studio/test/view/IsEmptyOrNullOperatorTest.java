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
package org.talend.mdm.studio.test.view;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;


public class IsEmptyOrNullOperatorTest extends TalendSWTBotForMDM {
    private SWTBotTreeItem viewParentItem;

    private SWTBotTreeItem viewItem;

    private String[] array = new String[] { "Id", "Firstname", "Lastname", "CommissionCode", "StartDate", "TermDate" };

    private String PREFIX = "Browse_items_";

    @Before
    public void runBeforeEveryTest() {
        viewParentItem = serverItem.getNode("View [HEAD]");
        viewParentItem.expand();

    }

    private void createView() {
        viewParentItem.contextMenu("New").click();
        SWTBotShell newViewShell = bot.shell("New View");
        newViewShell.activate();
        bot.buttonWithTooltip("Select one Entity").click();
        bot.shell("Select one Entity").activate();

        bot.comboBoxWithLabel("Data Models:").setSelection("CONF");
        bot.tree().select("Conf");
        bot.button("Add").click();
        sleep();
        bot.button("OK").click();
        sleep(2);
    }

    private void init() {
        createView();
    }
    //new feature in 4.2,see bug 0018359.
    @Test
    public void isEmptyOrNullOperatorTest() {
        init();
        bot.buttonWithTooltip("Add", 2).click();
        bot.table().click(0, 1);
        bot.comboBox().setSelection("IsEmptyOrNull");
        Assert.assertEquals("IsEmptyOrNull",bot.ccomboBox().getText());
    }
}
