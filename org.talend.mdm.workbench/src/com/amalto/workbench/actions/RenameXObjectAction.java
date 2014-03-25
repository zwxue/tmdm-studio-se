// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import com.amalto.workbench.editors.xsdeditor.XSDEditorInput;
import com.amalto.workbench.editors.xsdeditor.XSDEditorUtil;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.views.ServerView;

public class RenameXObjectAction extends Action {

    private static Log log = LogFactory.getLog(RenameXObjectAction.class);

    private ServerView view = null;

    private IWorkbenchPage page;

    public RenameXObjectAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.RENAME.getPath()));

        setText(Messages.RenameXObjectAction_Rename);
        setToolTipText(Messages.RenameXObjectAction_RenameTheObject);
    }

    @Override
    public void run() {
        ISelection selection = view.getViewer().getSelection();
        TreeObject xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
        this.page = view.getSite().getWorkbenchWindow().getActivePage();
        try {
	        IEditorInput input= new XObjectEditorInput(xobject, xobject.getDisplayName());
	        IEditorPart part=null;
	        if(xobject.getType()==TreeObject.DATA_MODEL){
	            IFile pathToTempFile = XSDEditorUtil.createFile(xobject);
	            if(pathToTempFile!=null) 
	            input = new XSDEditorInput(pathToTempFile);
	        }
	        part= page.findEditor(input);
	        page.closeEditor(part, true);
	            if (TreeObjectUtil.renameTreeOjects(xobject, view))
	                TreeObjectUtil.deleteTreeObject(xobject, view);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
