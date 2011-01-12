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
package org.talend.mdm.studio.test.resources.customtype;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;
import org.talend.mdm.studio.test.util.Util;

/**
 * DOC rhou class global comment. Detailled comment
 */
public class CustomTypeUploadTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem customTypeParentNode;

    private static String SAMPLE_RELATIVE_FILEPATH = "customType.xsd";

    private String[] creation;

    @Before
    public void runBeforeEveryTest() {
        SWTBotTreeItem resourcesItem = serverItem.getNode("Resources");
        resourcesItem.expand();

        customTypeParentNode = resourcesItem.getNode("Custom Type");
    }

    @After
    public void runAfterEveryTest() {
        customTypeParentNode.select(creation).contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

    @Test
    public void customTypeUploadTest() throws IOException, URISyntaxException {
        customTypeParentNode.contextMenu("Upload").click();
        bot.shell("Upload Custom Type").activate();
        bot.textWithLabel("Custom Type Name").setText("CustomType");
        bot.textWithLabel("File Path").setText(
                Util.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
    }

}
