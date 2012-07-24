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

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDElementDeclaration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDUtil {

    private static final String X_FOREIGN_KEY = "X_ForeignKey"; //$NON-NLS-1$

    public static String getAnnotationValue(XSDElementDeclaration elementDesc, String key) {
        XSDAnnotation annotation = elementDesc.getAnnotation();
        if (annotation != null) {
            EList<Element> applicationInformation = annotation.getApplicationInformation();
            if (applicationInformation != null) {
                for (Element element : applicationInformation) {
                    if (element.getLocalName().equalsIgnoreCase("appinfo")) { //$NON-NLS-1$
                        String source = element.getAttribute("source"); //$NON-NLS-1$
                        if (key.equalsIgnoreCase(source)) {
                            NodeList childNodes = element.getChildNodes();
                            String nodeValue = null;
                            if (childNodes.getLength() > 0) {
                                Node node = childNodes.item(0);
                                nodeValue = node.getNodeValue();
                            }
                            return nodeValue;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean hasFKInfo(XSDElementDeclaration elementDeclaration) {
        String value = XSDUtil.getAnnotationValue(elementDeclaration, X_FOREIGN_KEY);
        return value != null;
    }
}
