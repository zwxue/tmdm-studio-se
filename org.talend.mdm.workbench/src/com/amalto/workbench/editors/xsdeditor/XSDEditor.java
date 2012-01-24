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
package com.amalto.workbench.editors.xsdeditor;

import java.io.ByteArrayInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.wst.xsd.ui.internal.editor.XSDTabbedPropertySheetPage;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.IServerObjectEditorState;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.MDMPerspective;
import com.amalto.workbench.webservices.WSDataModel;

@SuppressWarnings("restriction")
public class XSDEditor extends InternalXSDMultiPageEditor implements IServerObjectEditorState {

    private static Log log = LogFactory.getLog(XSDEditor.class);

    public static final String CONTRUIBUTIONID_DATAMODELPAGE = "org.talend.mdm.workbench.propertyContributor.datamodel";//$NON-NLS-1$

    public static final String CONTRUIBUTIONID_XSDEDITOR = "org.eclipse.wst.xsd.ui.internal.editor";//$NON-NLS-1$

    protected String curContributionID = CONTRUIBUTIONID_DATAMODELPAGE;

    IEditorInput xsdInput;

    protected TreeObject xobject;

    public void setXSDInput(IEditorInput input) {
        this.xsdInput = input;
    }

    public void setXObject(TreeObject xobject) {
        this.xobject = xobject;
    }

    @Override
    public String getPartName() {
        
        String part = super.getPartName();
        if (part.endsWith(".xsd")) {//$NON-NLS-1$
            return part.substring(0, part.length() - 4);
        } else {
            int start = part.lastIndexOf('_');
            int end = part.lastIndexOf(' ');
            if (start != -1 && end != -1) {
                return part.substring(0, start) + part.substring(end);
            }
        }
        return part;
    }

    protected void superDoSave(IProgressMonitor monitor) {
        super.doSave(monitor);
    }
    @Override
    public void doSave(IProgressMonitor monitor) {
        
        super.doSave(monitor);
        try {
            if (getSelectedPage() instanceof DataModelMainPage) {// save DataModelMainPage's contents to file
                DataModelMainPage mainPage = (DataModelMainPage) getSelectedPage();
                String xsd = mainPage.getXSDSchemaString();
                WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();
                wsDataModel.setXsdSchema(xsd);
                IFile file = getXSDFile(xobject);
                file.setCharset("utf-8", null);//$NON-NLS-1$
                file.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);//$NON-NLS-1$
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
            log.error(e.getMessage(), e);
        } finally {
            monitor.done();
        }
    }

    protected IFile getXSDFile(TreeObject xobject) throws Exception {
        return XSDEditorUtil.createFile(xobject);
    }
    public void pageChang(){
        if (xobject != null) {
            try {
                if (getSelectedPage() instanceof DataModelMainPage) {// save the file's contents to
                    // DataModelMainPage
                    // InputStream in = XSDEditorUtil.createFile(xobject).getContents(true);
                    // String xsd = IOUtils.toString(in);

                    curContributionID = CONTRUIBUTIONID_DATAMODELPAGE;

                    String xsd = getTextEditor().getTextViewer().getDocument().get();
                    IEditorPart[] editors = findEditors(xsdInput);
                    if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {

                        DataModelMainPage mainPage = (DataModelMainPage) editors[0];

                        getEditorSite().setSelectionProvider(mainPage.getSelectionProvider());

                        XSDSchema schema = Util.createXsdSchema(xsd, xobject);
                        mainPage.setXsdSchema(schema);
                        mainPage.getTypeContentProvider().setXsdSchema(schema);
                        mainPage.getSchemaContentProvider().setXsdSchema(schema);
                        mainPage.refresh();
                    }
                } else {
                    // save DataModelMainPage's contents to file
                    curContributionID = CONTRUIBUTIONID_XSDEDITOR;
                    getEditorSite().setSelectionProvider(getSelectionManager());

                    IEditorPart[] editors = findEditors(xsdInput);
                    if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
                        DataModelMainPage mainPage = (DataModelMainPage) editors[0];
                        if (mainPage.isDirty()) {
                            String xsd = mainPage.getXSDSchemaString();
                            xsd = Util.formatXsdSource(xsd);
                            WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();
                            wsDataModel.setXsdSchema(xsd);
                            IFile file = getXSDFile(xobject);
                            file.setCharset("utf-8", null);//$NON-NLS-1$
                            file.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);//$NON-NLS-1$
                        }

                    }

                }
                updatePageReadOnly(getSelectedPage());
                refreshPropertyView();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void updatePageReadOnly(Object pageObj) {
        if (isReadOnly()) {
            if (pageObj instanceof DataModelMainPage) {
                DataModelMainPage page = (DataModelMainPage) getSelectedPage();
                page.getMainControl().setEnabled(false);
                Control[] children = ((Composite) page.getMainControl()).getChildren();
                for (Control control : children) {
                    control.setEnabled(false);
                }
            } else if (pageObj instanceof StructuredTextEditor) {
                StructuredTextEditor textEditor = (StructuredTextEditor) pageObj;
                textEditor.getTextViewer().getTextWidget().setEnabled(false);
            } else if (pageObj instanceof Composite) {
                ((Composite) pageObj).setEnabled(false);
            }
        }
    }
    @Override
    protected void createPages() {
        
        super.createPages();
        addPageChangedListener(new IPageChangedListener() {

            public void pageChanged(PageChangedEvent event) {
                pageChang();
            }
        });
    }

    @Override
    public String getContributorId() {
        return curContributionID;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class type) {

        if (type == IPropertySheetPage.class) {
            if (CONTRUIBUTIONID_XSDEDITOR.equals(curContributionID)) {
                return new XSDTabbedPropertySheetPage(this);
            }
            return new TabbedPropertySheetPage(this);
        }

        if (type == DataModelMainPage.class) {

            for (int i = 0; i < getPageCount(); i++) {
                if (getEditor(i) instanceof DataModelMainPage) {
                    return (DataModelMainPage) getEditor(i);
                }
            }
        }

        return super.getAdapter(type);

    }

    private void refreshPropertyView() throws PartInitException {

        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

        IViewPart propView = page.findView(MDMPerspective.VIEWID_PROPERTYVIEW);

        if (propView != null) {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(propView);
        }

        page.showView(MDMPerspective.VIEWID_PROPERTYVIEW);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.amalto.workbench.editors.IServerObjectEditorState#isLocalInput()
     */
    public boolean isLocalInput() {
        return false;
    }

    public void setName(String name) {
        setPartName(name);
    }
}
