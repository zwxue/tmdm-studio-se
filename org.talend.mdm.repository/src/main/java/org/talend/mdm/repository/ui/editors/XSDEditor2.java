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
package org.talend.mdm.repository.ui.editors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.editors.xsdeditor.XSDEditor;
import com.amalto.workbench.editors.xsdeditor.XSDSelectionListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDEditor2 extends XSDEditor {

    public static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XSDEditor2"; //$NON-NLS-1$

    static Logger log = Logger.getLogger(XObjectEditor2.class);

    private IEditorInput xobjectEditorinput;

    @Override
    protected void createPages() {

        super.createPages();
        XSDEditorInput2 editorInput = (XSDEditorInput2) getEditorInput();
        TreeObject treeObject = editorInput.getTreeObject();
        xobjectEditorinput = new XObjectEditorInput2(editorInput.getInputItem(), treeObject, treeObject.getDisplayName());
        DataModelMainPage2 dMainPage = new DataModelMainPage2(treeObject);
        try {
            addPage(dMainPage, xobjectEditorinput);
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }
        //
        getSite().setSelectionProvider(dMainPage.getSelectionProvider());

        // add XSDSelectionListener
        XSDSelectionListener xsdListener = new XSDSelectionListener(this, dMainPage.getXSDSchema());
        dMainPage.getTypesViewer().addSelectionChangedListener(xsdListener);
        dMainPage.getElementsViewer().addSelectionChangedListener(xsdListener);
        //

        setXSDInput(xobjectEditorinput);
        setXObject(treeObject);
        //
        CTabFolder folder = (CTabFolder) dMainPage.getMainControl().getParent();
        folder.getItem(2).setText(treeObject.getDisplayName() + " " + Util.getRevision(treeObject));//$NON-NLS-1$
        folder.getItem(0).setText(Messages.XSDEditor2_schemaDesign);
        folder.getItem(1).setText(Messages.XSDEditor2_schemaSource);
        //
        setActiveEditor(dMainPage);
    }

    @Override
    protected IFile getXSDFile(TreeObject xobject) throws Exception {
        return ((IFileEditorInput) getEditorInput()).getFile();
    }

    @Override
    public boolean isLocalInput() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        IRepositoryViewEditorInput editorInput = (IRepositoryViewEditorInput) this.getEditorInput();
        return editorInput.isReadOnly();
    }

    // public void doSave(IProgressMonitor monitor) {
    //
    // super.superDoSave(monitor);
    // try {
    // if (getSelectedPage() instanceof DataModelMainPage) {// save DataModelMainPage's contents to file
    // DataModelMainPage mainPage = (DataModelMainPage) getSelectedPage();
    // String xsd = mainPage.getXSDSchemaString();
    // WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();
    // wsDataModel.setXsdSchema(xsd);
    // IFile file = ((IFileEditorInput) getEditorInput()).getFile();
    //                file.setCharset("utf-8", null);//$NON-NLS-1$
    //                file.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);//$NON-NLS-1$
    // } // save the file's contents to DataModelMainPage
    //
    // IDocument doc = getTextEditor().getTextViewer().getDocument();
    // String xsd = doc.get();
    // // DataModelMainPage
    // IEditorPart[] editors = findEditors(xobjectEditorinput);
    // if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
    // DataModelMainPage mainPage = (DataModelMainPage) editors[0];
    // mainPage.save(xsd);
    // }
    //
    // } catch (Exception e) {
    // log.error(e.getMessage(), e);
    // }
    // }

}
