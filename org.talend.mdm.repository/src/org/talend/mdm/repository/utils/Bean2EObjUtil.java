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
package org.talend.mdm.repository.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class Bean2EObjUtil {

    static Logger log = Logger.getLogger(Bean2EObjUtil.class);

    BidiMap classMap = new DualHashBidiMap();

    BidiMap fieldMap = new DualHashBidiMap();

    BeanClassUtil beanClassUtil = new BeanClassUtil(this);

    EMFClassUtil emfClassUtil = new EMFClassUtil();

    public void registerClassMap(Class cls) {
        EClass eCls;
        eCls = guessEClassByClassName(cls);
        if (eCls != null) {
            classMap.put(cls, eCls);
            beanClassUtil.refactorClassStructure(cls);
            guessField(cls, eCls);
        }

    }

    private void guessField(Class cls, EClass eCls) {
        Map<Field, Method[]> map = beanClassUtil.findFieldMap(cls);

        if (map != null) {
            EList<EStructuralFeature> features = eCls.getEAllStructuralFeatures();
            for (Field field : map.keySet()) {
                String fieldName = field.getName();
                boolean found = false;
                for (EStructuralFeature feature : features) {
                    String featureName = feature.getName();
                    if (fieldName.equals(featureName)) {
                        fieldMap.put(field, feature);
                        found = true;
                        //                        System.out.println("\t Found Field Map:" + fieldName); //$NON-NLS-1$
                        break;
                    }
                }
                if (!found) {
                    log.debug("\t Failed to Found Field Map:" + fieldName); //$NON-NLS-1$
                }
            }
        }
    }

    private EClass guessEClassByClassName(Class cls) {
        String eClassName = cls.getSimpleName() + "E"; //$NON-NLS-1$
        for (EClass eCls : emfClassUtil.getAllEClass()) {
            if (eCls.getName().equals(eClassName)) {
                //                System.out.println(">>For class:" + cls.getName() + " (Found:)=> " + eCls.getName()); //$NON-NLS-1$ //$NON-NLS-2$
                return eCls;
            }
        }
        log.debug(">>For class:" + cls.getName() + " Not Found corresponding EClass "); //$NON-NLS-1$//$NON-NLS-2$
        return null;
    }

    public EObject convertFromBean2EObj(Object bean) {
        Class beanCls = bean.getClass();
        EClass eCls = (EClass) classMap.get(beanCls);
        EObject eObj = MdmserverobjectFactory.eINSTANCE.create(eCls);
        if (eCls != null) {
            Map<Field, Method[]> beanFieldMap = beanClassUtil.findFieldMap(beanCls);
            if (beanFieldMap == null)
                return null;
            for (Field field : beanFieldMap.keySet()) {
                try {
                    EStructuralFeature feature = (EStructuralFeature) fieldMap.get(field);
                    if (feature != null) {
                        Method getMethod = beanFieldMap.get(field)[0];
                        Object value = getMethod.invoke(bean);
                        if (beanClassUtil.isColletionField(field)) {
                            if (value != null) {
                                for (Object childObj : (Object[]) value) {
                                    EObject eChildObj = convertFromBean2EObj(childObj);
                                    ((EList) eObj.eGet(feature)).add(eChildObj);
                                }
                            }
                        } else {
                            Object eValue = null;
                            if (beanClassUtil.isJavaField(field)) {
                                eValue = value;
                            } else {
                                // a object reference
                                eValue = convertFromBean2EObj(value);
                            }
                            eObj.eSet(feature, eValue);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    log.error(e.getMessage(), e);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage(), e);
                } catch (InvocationTargetException e) {
                    log.error(e.getMessage(), e);
                }
            }
            return eObj;
        }
        return null;
    }

    public Object convertFromEObj2Bean(EObject eObj) {
        EClass eCls = eObj.eClass();
        Class beanCls = (Class) classMap.getKey(eCls);

        if (beanCls != null) {
            try {
                Object bean = beanCls.newInstance();
                Map<Field, Method[]> beanFieldMap = beanClassUtil.findFieldMap(beanCls);
                if (beanFieldMap == null)
                    return null;
                for (Field field : beanFieldMap.keySet()) {
                    try {
                        EStructuralFeature feature = (EStructuralFeature) fieldMap.get(field);
                        if (feature != null) {
                            Method setMethod = beanFieldMap.get(field)[1];

                            Object value = eObj.eGet(feature);
                            if (feature.isMany()) {
                                if (value != null) {
                                    EList list = (EList) value;
                                    Object newInstance = Array.newInstance(field.getType().getComponentType(), list.size());
                                    Object[] children = (Object[]) newInstance;
                                    int i = 0;
                                    for (Object echildObj : list) {
                                        Object childObj = convertFromEObj2Bean((EObject) echildObj);
                                        children[i] = childObj;
                                        i++;
                                    }
                                    setMethod.invoke(bean, newInstance);
                                }
                            } else {
                                Object eValue = null;
                                if (beanClassUtil.isJavaField(field)) {
                                    eValue = value;
                                } else {
                                    // a object reference
                                    eValue = convertFromEObj2Bean((EObject) value);
                                }
                                setMethod.invoke(bean, eValue);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        log.error(e.getMessage(), e);
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(), e);
                    }
                }
                return bean;
            } catch (InstantiationException e) {
                log.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }

    public void dumpMap() {
        System.out.println("ClassMap : "); //$NON-NLS-1$
        for (Object obj : classMap.keySet()) {
            System.out.println(obj + "\n\t=> " + classMap.get(obj)); //$NON-NLS-1$
        }
        System.out.println("FieldMap : "); //$NON-NLS-1$
        for (Object obj : fieldMap.keySet()) {
            System.out.println(obj + "\n\t=> " + fieldMap.get(obj)); //$NON-NLS-1$
        }
    }

}
