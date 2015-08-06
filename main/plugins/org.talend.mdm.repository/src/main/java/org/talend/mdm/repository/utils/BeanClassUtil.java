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
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * DOC hbhong class global comment. Detailled comment
 */
class BeanClassUtil {

    static Logger log = Logger.getLogger(BeanClassUtil.class);

    Map<Class, Map<Field, Method[]>> map = new HashMap<Class, Map<Field, Method[]>>();

    private Bean2EObjUtil mapUtil;

    /**
     * DOC hbhong BeanClassUtil constructor comment.
     * 
     * @param mapUtil
     */
    public BeanClassUtil(Bean2EObjUtil mapUtil) {
        this.mapUtil = mapUtil;
    }

    public Map<Field, Method[]> findFieldMap(Class cls) {
        return map.get(cls);
    }

    private String calGetMethodName(Field field) {
        String name = field.getName();
        Class type = field.getType();
        // in normal the var name's length>1 ,there is a potential bug

        return ((type.isPrimitive() && type.getName().equals("boolean")) ? "is" : "get") + name.substring(0, 1).toUpperCase() + name.substring(1); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    private String calSetMethodName(Field field) {
        String name = field.getName();
        // in normal the var name's length>1 ,there is a potential bug
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1); //$NON-NLS-1$
    }

    private void fillMap(Class cls, Field field, Method[] methods) {
        Map<Field, Method[]> fieldMap = map.get(cls);
        if (fieldMap == null) {
            fieldMap = new HashMap<Field, Method[]>();
            map.put(cls, fieldMap);
        }
        //
        fieldMap.put(field, methods);
    }

    public void refactorClassStructure(Class cls) {
        if (map.containsKey(cls))
            return;
        for (Field field : cls.getDeclaredFields()) {
            try {
                String getMethodName = calGetMethodName(field);
                Method getMethod = cls.getMethod(getMethodName);
                Method[] methods = new Method[2];
                Class fieldType = field.getType();
                if (getMethod != null && getMethod.getReturnType() == fieldType) {
                    //                    System.out.println(field + "\n\t" + getMethod); //$NON-NLS-1$
                    methods[0] = getMethod;
                } else {
                    log.debug("can't find getMethod for " + field); //$NON-NLS-1$
                }
                //
                String setMethodName = calSetMethodName(field);
                Method setMethod = cls.getMethod(setMethodName, fieldType);
                if (setMethod != null) {
                    //                    System.out.println(field + "\n\t" + setMethod); //$NON-NLS-1$
                    methods[1] = setMethod;
                } else {
                    log.debug("can't find setMethod for " + field); //$NON-NLS-1$
                }
                if (methods[0] != null && methods[1] != null) {
                    fillMap(cls, field, methods);
                }
                //
                handleChildClass(fieldType);
            } catch (SecurityException e) {
                log.error(e.getMessage(), e);
            } catch (NoSuchMethodException e) {
                log.debug(e.getMessage() + "=>Skip it"); //$NON-NLS-1$
            }
        }
    }

    private Class getComponentType(Class cls) {
        if (cls.isArray()) {
            return cls.getComponentType();
        }
        return cls;
    }

    private void handleChildClass(Class cls) {
        Class childCls = getComponentType(cls);

        if (!isJavaClass(childCls)) {
            if (!map.containsKey(childCls)) {
                if (mapUtil != null) {
                    mapUtil.registerClassMap(childCls);
                }
            }
        }
    }

    public boolean isColletionField(Field field) {
        return field.getType().isArray();
    }

    public boolean isJavaField(Field field) {
        return isJavaClass(field.getType());
    }

    public boolean isJavaClass(Class cls) {
        if (cls.isPrimitive())
            return true;
        return getComponentType(cls).getName().startsWith("java"); //$NON-NLS-1$
    }

    public void dumpMap() {
        for (Class cls : map.keySet()) {
            System.out.println(cls.getName());
            Map<Field, Method[]> fieldMap = map.get(cls);
            for (Field field : fieldMap.keySet()) {
                System.out.println("\t|--- " + field.getName() + "\ttype:" + field.getType()); //$NON-NLS-1$ //$NON-NLS-2$
                Method[] methods = fieldMap.get(field);
                System.out.println("\t\t\t" + methods[0].getName()); //$NON-NLS-1$
                System.out.println("\t\t\t" + methods[1].getName()); //$NON-NLS-1$
            }
        }
    }
}
