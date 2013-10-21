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
package org.talend.mdm.repository.ui.dialogs;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.dialogs.SelectImportedModulesDialog;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC Administrator  class global comment. Detailled comment
 */
public class SelectImportedModulesDialog2 extends SelectImportedModulesDialog {

	MDMServerDef serverDef;

	public SelectImportedModulesDialog2(Shell parentShell, TreeObject treeObj,
			String title) {
		super(parentShell, treeObj, title);

	}

    @Override
    protected XtentisPort getPort() throws XtentisException {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();
                this.serverDef = serverDef;
                return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
            }
        return null;
    }

    @Override
    protected boolean resolveSchemaList(List<String> schemaList) throws XtentisException, RemoteException {
        List<String> newList = RepositoryQueryService.findAllDataModelNames();
        for (String string : newList) {
            schemaList.add(string);
        }

        return true;
    }
    
    
    @Override
	protected URL getSourceURL(String path) {
    	if(null == path){
    		return null;
    	}
    	if(path.startsWith("type:")){
    		String modelName = path.substring(5);
    		IRepositoryViewObject rvobject = getViewObjForDataModel(modelName);
    		if(null == rvobject){
    			return null;
    		}
    		String prjLabel = rvobject.getProjectLabel();

            String parentPath = buildParentPath(rvobject);
            String sep = "" + IPath.SEPARATOR; //$NON-NLS-1$

            String fileName ="file:///"+ ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + sep + prjLabel.toUpperCase() + sep
                    + "MDM" + sep + "datamodel" + parentPath + rvobject.getLabel() + "_" + rvobject.getVersion() + ".xsd"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$
            return super.getSourceURL(fileName);
    	}else{
    		return super.getSourceURL(path);
    	}
	}

    private String buildParentPath(IRepositoryViewObject viewObj) {
        String path = "" + IPath.SEPARATOR; //$NON-NLS-1$

        ItemState state = viewObj.getProperty().getItem().getState();
        String itemPath = state.getPath();
        if (!itemPath.isEmpty())
            path = itemPath + path;

        return path;
    }
    private IRepositoryViewObject getViewObjForDataModel(String name) {
        List<IRepositoryViewObject> vObjs = RepositoryResourceUtil.findAllViewObjects(IServerObjectRepositoryType.TYPE_DATAMODEL);
        IRepositoryViewObject theViewObj = null;
        for (IRepositoryViewObject obj : vObjs) {
            if (obj.getLabel().equals(name)) {
                theViewObj = obj;
            }
        }
        return theViewObj;
    }
}
