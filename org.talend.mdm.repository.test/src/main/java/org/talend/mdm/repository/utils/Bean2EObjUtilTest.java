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
package org.talend.mdm.repository.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.PowerMockUtils;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WSMenuMenuEntriesDescriptionsE;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuEntry;
import com.amalto.workbench.webservices.WSMenuMenuEntriesDescriptions;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Bean2EObjUtil.class ,System.class, IOUtil.class})
public class Bean2EObjUtilTest {

    @Test
    public void testPrivateConstructor() throws ClassNotFoundException {
        Class<?>  utilClass = Class.forName(Bean2EObjUtil.class.getCanonicalName());
        Constructor<?>[] constructors = utilClass.getConstructors();
        assertNotNull(constructors);
        assertEquals(1, constructors.length);
        assertFalse(constructors[0].isAccessible());
    }
    
    @Test
    public void testGetInstance() {
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        util = Bean2EObjUtil.getInstance();
        assertNotNull(util);
    }
    
    /**
     * Test method for {@link Bean2EObjUtil#registerClassMap(java.lang.Class)}.
     * @throws Exception 
     */
    @Test
    public void testRegisterClassMap() throws Exception {
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        Bean2EObjUtil spyUtil = PowerMockito.spy(util);
        spyUtil.registerClassMap(WSMenu.class);
        
        PowerMockito.verifyPrivate(spyUtil, Mockito.times(1)).invoke("guessEClassByClassName", Mockito.any(Class.class));
    }
    
    @Test
    public void testGuessEClassByClassName() throws Exception {
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        Bean2EObjUtil spyUtil = PowerMockito.spy(util);
        
        Class<?> clazz = WSDataModel.class; 
        Object eClass = Whitebox.invokeMethod(spyUtil, "guessEClassByClassName", clazz);
        PowerMockito.verifyPrivate(spyUtil).invoke("guessEClassByClassName", clazz);
        assertNotNull(eClass);
    }
    
    @Test
    public void testGuessField() throws Exception {
        Map<Field, EStructuralFeature> fieldMap = new HashMap<Field, EStructuralFeature>();
        Map<Field, EStructuralFeature> spyMap = PowerMockito.spy(fieldMap);
        PowerMockito.whenNew(HashMap.class).withNoArguments().thenReturn((HashMap) spyMap);
        
        Class<?> clazz = WSDataModel.class; 
        
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        Bean2EObjUtil spyUtil = PowerMockito.spy(util);
        
        spyUtil.beanClassUtil.refactorClassStructure(clazz);
        Object eClass = Whitebox.invokeMethod(spyUtil, "guessEClassByClassName", clazz);
        if(eClass != null) {
            Whitebox.invokeMethod(spyUtil, "guessField", clazz, eClass);
            assertTrue(spyMap.size() > 0);
        }
    }

    /**
     * Test method for {@link Bean2EObjUtil#convertFromBean2EObj(java.lang.Object)}.
     */
    @Test
    public void testConvertFromBean2EObj() {
        WSMenu menu = new WSMenu();
        initBean(menu);
        
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        EObject eObject = util.convertFromBean2EObj(menu, null);
        assertNotNull(eObject);
        
        WSMenuE menuE = (WSMenuE) eObject;
        //
        assertEquals(menu.getName(), menuE.getName());
        assertEquals(menu.getDescription(), menuE.getDescription());
        //
        WSMenuEntry[] menuEntries = menu.getMenuEntries();
        EList<WSMenuEntryE> menuEntriesE = menuE.getMenuEntries();
        for (int i = 0; i < menuEntries.length; i++) {
            checkMenuEntry(menuEntries[i], menuEntriesE.get(i));
        }
    }

    private void initBean(WSMenu menu) {
        menu.setDescription("this is a description"); //$NON-NLS-1$
        menu.setName("menuA"); //$NON-NLS-1$
        //
        WSMenuEntry[] menuEntries = new WSMenuEntry[2];
        menuEntries[0] = new WSMenuEntry();
        menuEntries[0].setApplication("application A"); //$NON-NLS-1$
        menuEntries[0].setContext("contextA"); //$NON-NLS-1$
        menuEntries[0].setIcon("icon A"); //$NON-NLS-1$
        menuEntries[0].setId("id A"); //$NON-NLS-1$
        //
        menuEntries[1] = new WSMenuEntry();
        menuEntries[1].setApplication("application B"); //$NON-NLS-1$
        menuEntries[1].setContext("contextB"); //$NON-NLS-1$
        menuEntries[1].setIcon("icon B"); //$NON-NLS-1$
        menuEntries[1].setId("id B"); //$NON-NLS-1$
        //
        WSMenuMenuEntriesDescriptions[] ds = new WSMenuMenuEntriesDescriptions[1];
        ds[0] = new WSMenuMenuEntriesDescriptions();
        ds[0].setLabel("label A"); //$NON-NLS-1$
        ds[0].setLanguage("En"); //$NON-NLS-1$
        menuEntries[0].setDescriptions(ds);
        menu.setMenuEntries(menuEntries);
    }

    private void checkMenuEntry(WSMenuEntry entry, WSMenuEntryE entryE) {
        assertEquals(entry.getApplication(), entryE.getApplication());
        assertEquals(entry.getContext(), entryE.getContext());
        assertEquals(entry.getIcon(), entryE.getIcon());
        assertEquals(entry.getId(), entryE.getId());
        WSMenuMenuEntriesDescriptions[] ds = entry.getDescriptions();
        EList<WSMenuMenuEntriesDescriptionsE> des = entryE.getDescriptions();
        if (ds != null)
            for (int i = 0; i < ds.length; i++) {
                checkDesc(ds[i], des.get(i));
            }
    }

    private void checkDesc(WSMenuMenuEntriesDescriptions ds, WSMenuMenuEntriesDescriptionsE des) {
        assertEquals(ds.getLabel(), des.getLabel());
        assertEquals(ds.getLanguage(), des.getLanguage());
    }

    @Test
    public void testConvertFromEObj2Bean() {
        WSMenuE menuE = MdmserverobjectFactory.eINSTANCE.createWSMenuE();
        initEObject(menuE);
        //
        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        WSMenu menu = (WSMenu) util.convertFromEObj2Bean(null);
        assertNull(menu);
        
        menu = (WSMenu) util.convertFromEObj2Bean(menuE);
        assertNotNull(menu);
        //
        assertEquals(menu.getName(), menuE.getName());
        assertEquals(menu.getDescription(), menuE.getDescription());
        WSMenuEntry[] menuEntries = menu.getMenuEntries();
        EList<WSMenuEntryE> menuEntriesE = menuE.getMenuEntries();
        for (int i = 0; i < menuEntries.length; i++) {
            checkMenuEntry(menuEntries[i], menuEntriesE.get(i));
        }
    }
    

    private void initEObject(WSMenuE menuE) {
        menuE.setDescription("this is a description"); //$NON-NLS-1$
        menuE.setName("menuA"); //$NON-NLS-1$
        menuE.setSystem(false);
        menuE.getMenuEntries();
        //

        WSMenuEntryE wsMenuEntry = MdmserverobjectFactory.eINSTANCE.createWSMenuEntryE();
        wsMenuEntry.setApplication("application A"); //$NON-NLS-1$
        wsMenuEntry.setContext("contextA"); //$NON-NLS-1$
        wsMenuEntry.setIcon("icon A"); //$NON-NLS-1$
        wsMenuEntry.setId("id A"); //$NON-NLS-1$
        menuE.getMenuEntries().add(wsMenuEntry);
        //
        wsMenuEntry = MdmserverobjectFactory.eINSTANCE.createWSMenuEntryE();
        wsMenuEntry.setApplication("application B"); //$NON-NLS-1$
        wsMenuEntry.setContext("contextB"); //$NON-NLS-1$
        wsMenuEntry.setIcon("icon B"); //$NON-NLS-1$
        // wsMenuEntry.setId("id B");
        menuE.getMenuEntries().add(wsMenuEntry);
        //
        WSMenuMenuEntriesDescriptionsE ds = MdmserverobjectFactory.eINSTANCE.createWSMenuMenuEntriesDescriptionsE();
        ds.setLabel("Label C"); //$NON-NLS-1$
        ds.setLanguage("En"); //$NON-NLS-1$
        wsMenuEntry.getDescriptions().add(ds);
    }
    
    /**
     * test wrapEObjWithTreeObject with two input parameters
     */
    @Test
    public void testWrapEObjWithTreeObject2Args() {
        EObject eobj = null;
        Object wsObj = null;

        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        TreeObject treeObject = util.wrapEObjWithTreeObject(eobj, wsObj);
        assertNull(treeObject);
        
        MDMServerObject mdmServerObject = PowerMockito.mock(MDMServerObject.class);
        when(mdmServerObject.getName()).thenReturn("name");
        when(mdmServerObject.getType()).thenReturn(2);
        eobj = mdmServerObject;

        treeObject = util.wrapEObjWithTreeObject(eobj, wsObj);
        assertNotNull(treeObject);
        Mockito.verify(mdmServerObject, Mockito.atLeastOnce()).getName();
        Mockito.verify(mdmServerObject, Mockito.atLeastOnce()).getType();

        assertEquals("name", treeObject.getName());
        assertEquals(2, treeObject.getType());
    }
    
    /**
     * test wrapEObjWithTreeObject with one input parameter
     */
    @Test
    public void testWrapEObjWithTreeObject1Args() {
        EObject eobj = null;

        Bean2EObjUtil util = Bean2EObjUtil.getInstance();
        TreeObject treeObject = util.wrapEObjWithTreeObject(eobj);
        assertNull(treeObject);
        
        MDMServerObject mdmServerObject = PowerMockito.mock(MDMServerObject.class);
        when(mdmServerObject.getName()).thenReturn("name");
        when(mdmServerObject.getType()).thenReturn(2);
        eobj = mdmServerObject;

        treeObject = util.wrapEObjWithTreeObject(eobj);
        assertNotNull(treeObject);
        Mockito.verify(mdmServerObject, Mockito.atLeastOnce()).getName();
        Mockito.verify(mdmServerObject, Mockito.atLeastOnce()).getType();

        assertEquals("name", treeObject.getName());
        assertEquals(2, treeObject.getType());
    }
}
