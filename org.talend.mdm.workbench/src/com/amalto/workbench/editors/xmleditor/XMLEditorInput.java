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
package com.amalto.workbench.editors.xmleditor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class XMLEditorInput implements IEditorInput {

    Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public XMLEditorInput(Document document) {
        this.document = document;
    }

    public boolean exists() {
        // TODO Auto-generated method stub
        return true;
    }

    public ImageDescriptor getImageDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return "document";
    }

    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getToolTipText() {
        // TODO Auto-generated method stub
        return "tooltip";
    }

    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }

}
