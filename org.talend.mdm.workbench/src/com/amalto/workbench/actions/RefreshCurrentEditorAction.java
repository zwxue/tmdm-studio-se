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
package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.amalto.workbench.editors.AFormPage;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class RefreshCurrentEditorAction extends Action {

    public RefreshCurrentEditorAction() {
        setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        setText("Refresh");
        setToolTipText("Refresh the current page");
        setId("RefreshCurrentEditorAction");
    }

    public void run() {
        IEditorPart editpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editpart instanceof XObjectEditor) {
            XObjectEditor editor = (XObjectEditor) editpart;
            if (editor.getActivePageInstance() instanceof AFormPage) {
                ((AFormPage) editor.getActivePageInstance()).refreshPage();
            }
        }
        if (editpart instanceof XObjectBrowser) {
            XObjectBrowser editor = (XObjectBrowser) editpart;
            if (editor.getActivePageInstance() instanceof AFormPage) {
                ((AFormPage) editor.getActivePageInstance()).refreshPage();
            }
        }
    }
}
