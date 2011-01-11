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
package org.talend.mdm.studio.test.serviceconfiguration;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ServiceConfigurationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem scItem;

    @Before
    public void runBeforeEveryTest() {
        scItem = serverItem.getNode("Service Configuration");
        scItem.expand();

    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void serviceConfigurationContentTest() {
        scItem.doubleClick();
        bot.comboBox().setSelection("smtp");
        bot.button("Check").click();
        Assert.assertEquals("Connection sucessfully!", bot.text(1).getText());
        sleep();

        scItem.doubleClick();
        bot.comboBox().setSelection("smtp");
        bot.button("Check").click();
        Assert.assertEquals("Connection sucessfully!", bot.text(1).getText());
        sleep();

        scItem.doubleClick();
        sleep();
        bot.comboBox().setSelection("smtp");
        bot.button("Check").click();
        Assert.assertEquals("Connection sucessfully!", bot.text(1).getText());
        sleep();
    }
}
