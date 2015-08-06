// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * DOC hbhong class global comment. Detailled comment
 */
class EMFClassUtil {

    private List<EClass> definedClass = new LinkedList<EClass>();

    public List<EClass> getAllEClass() {
        if (definedClass.isEmpty()) {
            Class cls = MdmserverobjectPackage.Literals.class;
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == EClass.class) {
                    try {
                        Object object = field.get(cls);
                        // System.out.println(object);
                        definedClass.add((EClass) object);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return definedClass;
    }
}
