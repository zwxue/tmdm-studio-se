// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.editors;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.workbench.enterprice.editors.UniverseMainPage;

import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.utils.EXtentisObjects;

/**
 * DOC jsxie class global comment. Detailled comment
 */
public class UniverseVersionMainPage extends UniverseMainPage {

    /**
     * DOC jsxie UniverseVersionMainPage constructor comment.
     * 
     * @param editor
     */
    public UniverseVersionMainPage(FormEditor editor) {
        super(editor);
    }

    protected Map<String, List<String>> getTheUniverseMap() {

        Map<String, List<String>> universeMap = new HashMap<String, List<String>>();

        List<String> list = new ArrayList<String>();
        list.add("Transformer V2"); //$NON-NLS-1$ 
        list.add("View");//$NON-NLS-1$
        list.add("Data Model");//$NON-NLS-1$
        list.add("Role");//$NON-NLS-1$
        list.add("Routing Rule");//$NON-NLS-1$
        list.add("Stored Procedure");//$NON-NLS-1$
        list.add("Menu");//$NON-NLS-1$
        list.add("Synchronization Plan");//$NON-NLS-1$

        for (String name : list) {
            List<String> lst = new ArrayList<String>();
            lst.add("");//$NON-NLS-1$
            universeMap.put(name, lst);
        }

        return universeMap;
    }

    protected String[] getTheObjects() {
        String[] objects = new String[] { "Routing Engine V2", "Synchronization Plan", "Service", "Universe", "Routing Rule", //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                "Background Job", "Menu", "Transformer V2", "Stored Procedure", "View", "Routing Order V2 Active",//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                "Routing Order V2 Failed", "Item", "Data Model", "Routing Order V2 Completed", "Synchronization Conflict", //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                "Transformer Plugin V2", "Role", "Data Cluster", "Configuration Info" };//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$
        return objects;

    }

    protected Universe getTheUniverse() {
        if (universe == null) {
            try {
                universe = new Universe(""); //$NON-NLS-1$
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return (Universe) universe;
    }



    public class Universe extends UniverseMainPage.Universe {

        /**
         * DOC jsxie Universe constructor comment.
         * 
         * @param defaultReversionID
         * @throws RemoteException
         */
        public Universe(String defaultReversionID) throws RemoteException {
            super(defaultReversionID);
        }

        protected void initXtentisObjectsList() {

            getXtentisObjectsList().add(new KeyValue("Data Model", ""));//$NON-NLS-1$ //$NON-NLS-2$ 
            getXtentisObjectsList().add(new KeyValue("Menu", ""));//$NON-NLS-1$ //$NON-NLS-2$
            getXtentisObjectsList().add(new KeyValue("Role", ""));//$NON-NLS-1$ //$NON-NLS-2$  
            getXtentisObjectsList().add(new KeyValue(EXtentisObjects.RoutingRule.getDisplayName(), ""));//$NON-NLS-1$   
            getXtentisObjectsList().add(new KeyValue("Stored Procedure", ""));//$NON-NLS-1$ //$NON-NLS-2$
            getXtentisObjectsList().add(new KeyValue("Synchronization Plan", ""));//$NON-NLS-1$ //$NON-NLS-2$ 
            getXtentisObjectsList().add(new KeyValue(EXtentisObjects.Transformer.getDisplayName(), ""));//$NON-NLS-1$ 
            getXtentisObjectsList().add(new KeyValue("View", ""));//$NON-NLS-1$ //$NON-NLS-2$
        }

    }

}
