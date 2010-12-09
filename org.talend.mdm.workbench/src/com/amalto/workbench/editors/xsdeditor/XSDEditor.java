package com.amalto.workbench.editors.xsdeditor;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModel;

@SuppressWarnings("restriction")
public class XSDEditor extends InternalXSDMultiPageEditor {

    IEditorInput xsdInput;

    TreeObject xobject;

    public void setXSDInput(IEditorInput input) {
        this.xsdInput = input;
    }

    public void setXObject(TreeObject xobject) {
        this.xobject = xobject;
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        // TODO Auto-generated method stub
        super.doSave(monitor);
        try {
            if (getSelectedPage() instanceof DataModelMainPage) {// save DataModelMainPage's contents to file
                DataModelMainPage mainPage = (DataModelMainPage) getSelectedPage();
                String xsd = mainPage.getXSDSchemaString();
                WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();
                wsDataModel.setXsdSchema(xsd);
                IFile file = XSDEditorUtil.createFile(xobject);
                file.setContents(new ByteArrayInputStream(xsd.getBytes()), IFile.FORCE, null);
            } // save the file's contents to DataModelMainPage

            // InputStream in = XSDEditorUtil.createFile(xobject).getContents(true);
            
            IDocument doc = getTextEditor().getTextViewer().getDocument();
            String xsd = doc.get();
            // DataModelMainPage
            IEditorPart[] editors = findEditors(xsdInput);
            if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
                DataModelMainPage mainPage = (DataModelMainPage) editors[0];
                mainPage.save(xsd);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void createPages() {
        // TODO Auto-generated method stub
        super.createPages();
        addPageChangedListener(new IPageChangedListener() {

            public void pageChanged(PageChangedEvent event) {
                if (xobject != null) {
                    try {
                        if (getSelectedPage() instanceof DataModelMainPage) {// save the file's contents to
                            // DataModelMainPage
                            // InputStream in = XSDEditorUtil.createFile(xobject).getContents(true);
                            // String xsd = IOUtils.toString(in);
                            String xsd = getTextEditor().getTextViewer().getDocument().get();
                            IEditorPart[] editors = findEditors(xsdInput);
                            if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
                                DataModelMainPage mainPage = (DataModelMainPage) editors[0];
                                XSDSchema schema = Util.createXsdSchema(xsd, xobject);
                                mainPage.setXsdSchema(schema);
                                mainPage.getTypeContentProvider().setXsdSchema(schema);
                                mainPage.getSchemaContentProvider().setXsdSchema(schema);
                                mainPage.refresh();
                            }
                        } else {
                            // save DataModelMainPage's contents to file
                            IEditorPart[] editors = findEditors(xsdInput);
                            if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
                                DataModelMainPage mainPage = (DataModelMainPage) editors[0];
                                if (mainPage.isDirty()) {
                                    String xsd = mainPage.getXSDSchemaString();
                                    xsd = Util.formatXsdSource(xsd);
                                    WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();
                                    wsDataModel.setXsdSchema(xsd);
                                    IFile file = XSDEditorUtil.createFile(xobject);
                                    file.setContents(new ByteArrayInputStream(xsd.getBytes()), IFile.FORCE, null);
                                }
                            }
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
