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
package com.amalto.workbench.editors.xsdeditor;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.xsd.ui.internal.adapters.CategoryAdapter;
import org.eclipse.wst.xsd.ui.internal.adapters.RedefineCategoryAdapter;
import org.eclipse.wst.xsd.ui.internal.adapters.XSDBaseAdapter;
import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.wst.xsd.ui.internal.editor.XSDTabbedPropertySheetPage;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.w3c.dom.Node;

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

    private XSDSelectionManagerSelectionListener fXSDSelectionListener;

    public void setXSDInput(IEditorInput input) {
        this.xsdInput = input;
    }

    public void setXObject(TreeObject xobject) {
        this.xobject = xobject;

        try {// temporarily store the file data for restore
            IFile file = getXSDFile(xobject);
            fileContents = IOUtils.toByteArray(new InputStreamReader(file.getContents()), "utf-8");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
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

            IDocument doc = getTextEditor().getTextViewer().getDocument();
            String xsd = doc.get();
            // DataModelMainPage
            IEditorPart[] editors = findEditors(xsdInput);
            if (editors.length == 1 && editors[0] instanceof DataModelMainPage) {
                DataModelMainPage mainPage = (DataModelMainPage) editors[0];
                mainPage.save(xsd);
            }

            fileContents = xsd.getBytes("utf-8");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            monitor.done();
        }
    }

    protected IFile getXSDFile(TreeObject xobject) throws Exception {
        return XSDEditorUtil.createFile(xobject);
    }

    boolean doUpdateSourceLocation = false;

    protected void pageChange(int newPageIndex) {
        super.pageChange(newPageIndex);
        doUpdateSourceLocation = newPageIndex == SOURCE_PAGE_INDEX;

        if (doUpdateSourceLocation && fXSDSelectionListener != null)
            fXSDSelectionListener.doSetSelection();

    }

    public void pageChang() {
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

                            initializeGraphicalViewer();
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

    private class XSDSelectionManagerSelectionListener implements ISelectionChangedListener {

        /**
         * Determines DOM node based on object (xsd node)
         * 
         * @param object
         * @return
         */
        private Object getObjectForOtherModel(Object object) {
            Node node = null;
            if (object instanceof Node) {
                node = (Node) object;
            } else if (object instanceof XSDComponent) {
                if (object instanceof XSDElementDeclaration) {
                    String name = ((XSDElementDeclaration) object).getName();
                    for (XSDElementDeclaration elem : getXSDSchema().getElementDeclarations()) {
                        if (elem.getName().equals(name)) {
                            node = elem.getElement();
                        }
                    }
                } else {
                    node = ((XSDComponent) object).getElement();
                }
            } else if (object instanceof RedefineCategoryAdapter) {
                RedefineCategoryAdapter category = (RedefineCategoryAdapter) object;
                node = category.getXSDRedefine().getElement();
            } else if (object instanceof CategoryAdapter) {
                node = ((CategoryAdapter) object).getXSDSchema().getElement();
            } else if (object instanceof XSDBaseAdapter) {
                if (((XSDBaseAdapter) object).getTarget() instanceof XSDConcreteComponent) {
                    node = ((XSDConcreteComponent) ((XSDBaseAdapter) object).getTarget()).getElement();
                }
            } else if (object instanceof String) {
                // This case was added to make the F3/hyperlink navigation work when an
                // inline schema from a WSDL document is opened in the schema editor.
                // The string is expected to be a URI fragment used to identify an XSD
                // component in the context of the enclosing WSDL resource.

                String uriFragment = (String) object;
                Resource resource = getXSDSchema().eResource();
                EObject modelObject = resource.getEObject(uriFragment);

                if (modelObject != null && modelObject instanceof XSDComponent) {
                    XSDComponent component = (XSDComponent) modelObject;
                    node = component.getElement();
                }
            }

            // the text editor can only accept sed nodes!
            //
            if (!(node instanceof IDOMNode)) {
                node = null;
            }
            return node;
        }

        public void selectionChanged(SelectionChangedEvent event) {
            // do not fire selection in source editor if the current active page is the InternalXSDMultiPageEditor
            // (source)
            // We only want to make source selections if the active page is either the outline or properties (a modify
            // has been done via the outline or properties and not the source view). We don't want to be selecting
            // and unselecting things in the source when editing in the source!!
            boolean makeSelection = true;
            if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                if (page.getActivePart() instanceof InternalXSDMultiPageEditor) {
                    if (getActiveEditor() instanceof StructuredTextEditor) {
                        makeSelection = false;
                    }
                }
            }

            // do not fire selection in source editor if selection event came
            // from source editor
            if (event.getSource() != getTextEditor().getSelectionProvider() && makeSelection) {
                ISelection selection = event.getSelection();
                if (selection instanceof IStructuredSelection) {
                    List otherModelObjectList = new ArrayList();
                    for (Iterator i = ((IStructuredSelection) selection).iterator(); i.hasNext();) {
                        Object modelObject = i.next();
                        Object otherModelObject = getObjectForOtherModel(modelObject);
                        if (otherModelObject != null) {
                            otherModelObjectList.add(otherModelObject);
                        }
                    }
                    if (!otherModelObjectList.isEmpty()) {
                        if (getActivePage() == SOURCE_PAGE_INDEX) {
                            StructuredSelection nodeSelection = new StructuredSelection(otherModelObjectList);
                            getTextEditor().getSelectionProvider().setSelection(nodeSelection);
                        }
                    }
                }
            }
        }

        public void doSetSelection() {
            ISelection iSelection = getSelectionManager().getSelection();
            if (iSelection != null) {
                Object firstElement = ((StructuredSelection) iSelection).getFirstElement();
                Object otherModelObject = getObjectForOtherModel(firstElement);
                if (otherModelObject != null) {
                    StructuredSelection nodeSelection = new StructuredSelection(otherModelObject);
                    getTextEditor().getSelectionProvider().setSelection(nodeSelection);
                }
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
        fXSDSelectionListener = new XSDSelectionManagerSelectionListener();
        getSelectionManager().addSelectionChangedListener(fXSDSelectionListener);
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

    private byte[] fileContents = null;

    @Override
    public void dispose() {
        try {
            if (isDirty()) {
                IFile file = getXSDFile(xobject);
                file.setCharset("utf-8", null);//$NON-NLS-1$
                file.setContents(new ByteArrayInputStream(fileContents), IFile.FORCE, null);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            super.dispose();
        }
    }
    

    public DataModelMainPage getdMainPage() {
        return null;
    }
}
