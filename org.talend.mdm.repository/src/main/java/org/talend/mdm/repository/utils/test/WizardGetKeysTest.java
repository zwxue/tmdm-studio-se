// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils.test;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.talend.mdm.repository.ui.wizards.view.AddBrowseItemsWizardR;

import com.amalto.workbench.utils.Util;


@SuppressWarnings("nls")
public class WizardGetKeysTest extends TestCase {


    public WizardGetKeysTest(String name) {
        super(name);
    }

    XSDElementDeclaration decl = null;
    @Override
    protected void setUp() throws Exception {
        String xsd = null;
        XSDSchema schema = null;
        try {
            // xsd = Util.getXML("D:\\testkeys.xsd");
            xsd = Util.getXML("testkeys.xsd");
            schema = Util.getXSDSchema(xsd);
            schema.getElementDeclarations();
        } catch (Exception e) {
            e.printStackTrace();
        }

        xsd = "";
        decl = schema.getElementDeclarations().get(0);
    }

    public void testGetKeysForViewElements() {
        AddBrowseItemsWizardR wizard = new AddBrowseItemsWizardR(null);
        List<String> keys = wizard.getKeysForViewElements(decl);
        assertNotNull(keys);
        assertEquals(keys.size(), 4);
        for (int i = 0; i < keys.size(); i++) {
            switch (i) {
            case 0:
                assertEquals(keys.get(i), "eee/subelement");
                continue;
            case 1:
                assertEquals(keys.get(i), "eee/fff");
                continue;
            case 2:
                assertEquals(keys.get(i), "eee/eee");
                continue;
            case 3:
                assertEquals(keys.get(i), "eee/ddd");
                continue;

            }
        }
    }

}
