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
package org.talend.mdm.studio.test.common;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImportObjectsTest extends TalendSWTBotForMDM {

    @Before
    public void runBeforeEveryTest() {
    }

    @After
    public void runAfterEveryTest() {
    }

    @Test
    public void importObjectsTest() {
        serverItem.contextMenu("Import").click();
        bot.shell("Import Objects").activate();
        bot.radio("Select archive file:").click();
        bot.button("Import from Talend Exchange").click();
        bot.shell("Import from Talend Exchange options").activate();
        bot.table().select(1);
        bot.button("OK").click();
        sleep(3);
        bot.button("Finish").click();
        bot.shell("Confirm Overwrite").activate();
        bot.button("Yes To All").click();
    }
}
