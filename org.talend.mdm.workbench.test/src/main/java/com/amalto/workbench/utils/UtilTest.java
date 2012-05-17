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
package com.amalto.workbench.utils;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.junit.Test;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class UtilTest {


    /**
     * Test method for
     * {@link com.amalto.workbench.utils.Util#getComplexTypeDefinitionChildren(org.eclipse.xsd.XSDComplexTypeDefinition, boolean)}
     * .
     */
    @Test
    public void testGetComplexTypeDefinitionChildren() {
        

        // read test file
        String fileName = "resource/com/amalto/workbench/utils/TestGetComplexTypeDefinitionChildren_0.1.xsd";
        // get test model
        XSDSchema xsdSchema = getXSDSchema(fileName);

        EList<XSDElementDeclaration> elementDeclarations = xsdSchema.getElementDeclarations();
        // test
        assertEquals(1, elementDeclarations.size());
        XSDTypeDefinition typeDefinition = elementDeclarations.get(0).getTypeDefinition();
        ArrayList<Object> children = Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) typeDefinition, true);
        assertEquals(3, children.size());
        children = Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) typeDefinition, false);
        assertEquals(1, children.size());
    }

    private XSDSchema getXSDSchema(String fileName) {
        String xsdString = readTestResource(fileName);
        if (xsdString != null) {
            try {
                XSDSchema xsdSchema = Util.getXSDSchema(xsdString);
                return xsdSchema;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private String readTestResource(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            StringBuffer buffer = new StringBuffer();
            String tmpStr;
            while ((tmpStr = br.readLine()) != null) {
                buffer.append(tmpStr);
            }
            return buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                }
            }
        }
        return null;

    }
}
