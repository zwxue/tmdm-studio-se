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
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.workbench.enterprice.editors.UniverseMainPage;

import com.amalto.workbench.models.KeyValue;

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

        List<String> list = RepositoryWebServiceAdapter.getListForUniverseMap();

        for (String name : list) {
            List<String> lst = new ArrayList<String>();
            lst.add("");//$NON-NLS-1$
            universeMap.put(name, lst);
        }

        return universeMap;
    }

    protected String[] getTheObjects() {

        String[] objects = RepositoryWebServiceAdapter.getTheObjectsForUniverse();
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

            List<KeyValue> list = RepositoryWebServiceAdapter.getListForUniverseXtentisObjects();
            getXtentisObjectsList().addAll(list);

        }

    }

}
