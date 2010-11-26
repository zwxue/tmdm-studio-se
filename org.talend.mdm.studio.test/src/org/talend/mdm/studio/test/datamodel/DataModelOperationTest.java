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
package org.talend.mdm.studio.test.datamodel;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.Activator;

import com.amalto.workbench.utils.Util;

/**
 * DataModelOperationTest is a SWTBot test class to test the operation associated with the import,export.filter and so
 * on.
 * 
 * DOC rhou class global comment. Detailled comment
 */
public class DataModelOperationTest extends DataModelTest {

    @Before
    public void runBeforeEveryTest() {

    }

    @After
    public void runAfterEveryTest() {

    }

    @BeforeClass
    public static void runBeforeClass() {
        // run for one time before all test cases
        dataModelItem.contextMenu("New").click();
        SWTBotShell newDataModelShell = bot.shell("New Data Model");
        newDataModelShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Instance");
        text.setText("TestDataModel");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @AfterClass
    public static void runAfterClass() {
        // run for one time after all test cases
        dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    public void runTest() {
    }

    @Test
    public void importXSDTest() {
        File sourceFile = null;
        try {
            sourceFile = new File(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry("testDocuments"))
                    .getPath().substring(1)
                    + "testImport.xsd");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        File targetFile = new File(Platform.getInstanceLocation().getURL().getPath().substring(1) + "testImport.xsd");

        try {
            if (sourceFile != null)
                Util.copyFile(sourceFile, targetFile);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        bot.buttonWithTooltip("Import...").click();
        // TODO: now SWTBot doesn't support native SWT dialogs,so this needs more investigation.
        /*
         * SWTBotShell importDataModelShell = bot.shell("Select the XML definition for XML Schema");
         * importDataModelShell.activate(); bot.comboBox(1).setText("testxsd");
         * System.out.println(bot.comboBox(1).getText() + "test"); bot.button("Open(O)").click();
         */

    }

    @Test
    public void importXSDSchemaFromLocalTest() {
        File sourceFile = null;
        try {
            sourceFile = new File(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry("testDocuments"))
                    .getPath().substring(1)
                    + "testImport.xsd");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        File targetFile = new File(Platform.getInstanceLocation().getURL().getPath().substring(1) + "testImport.xsd");

        try {
            if (sourceFile != null)
                Util.copyFile(sourceFile, targetFile);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        bot.buttonWithTooltip("import/include specific Schema Namespace ...").click();
        SWTBotShell importXSDSchemaShell = bot.shell("Import xsd schema modules");
        importXSDSchemaShell.activate();
        bot.button("Add xsd from local").click();
        /*
         * bot.comboBox(0).setText("testxsd"); System.out.println(bot.comboBox(1).getText() + "test");
         * bot.button("Open(O)").click();
         */
    }
}
