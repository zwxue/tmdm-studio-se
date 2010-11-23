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
package org.talend.mdm.studio.test;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * LoginTest is a SWTBot test case for testing the login on the studio.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class LoginTest {

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
    }

    @Test
    public void runTest() {
        SWTWorkbenchBot bot = new SWTWorkbenchBot();
        bot.viewByTitle("Welcome").close();
        bot.menu("Window").menu("Open Perspective").menu("Other...").click();
        bot.sleep(1000);
        final SWTBotShell shellShowView = bot.shell("Open Perspective");
        bot.sleep(1000);
        shellShowView.widget.getDisplay().syncExec(new Runnable() {

            public void run() {
                shellShowView.widget.setSize(new Point(300, 600));
            }
        });
        shellShowView.activate();
        bot.table().select("MDM");
        bot.button("OK").click();
        bot.perspectiveByLabel("MDM").activate();
        bot.viewByTitle("MDM Server").show();
        bot.viewByTitle("MDM Server").toolbarButton("Add MDM Server Location").click();
        SWTBotShell shell = bot.shell("Talend MDM Studio Login");
        shell.activate();
        bot.sleep(1000);
        bot.textWithLabel("Username").setText("admin");
        bot.sleep(1000);
        bot.textWithLabel("Password").setText("talend");
        bot.sleep(1000);
        if (bot.comboBoxWithLabel("Version").itemCount() > 0)
            bot.comboBoxWithLabel("Version").setSelection(0);
        bot.sleep(1000);
        bot.checkBox("Save this MDM Server Location").select();
        bot.sleep(1000);
        bot.button("OK").click();
        bot.sleep(10 * 1000);
    }
}
