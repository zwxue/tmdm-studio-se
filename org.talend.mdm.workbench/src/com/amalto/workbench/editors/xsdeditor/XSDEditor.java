package com.amalto.workbench.editors.xsdeditor;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.wst.xsd.ui.internal.editor.XSDTabbedPropertySheetPage;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.MDMPerspective;
import com.amalto.workbench.webservices.WSDataModel;

@SuppressWarnings("restriction")
public class XSDEditor extends InternalXSDMultiPageEditor {

    public static final String CONTRUIBUTIONID_DATAMODELPAGE = "org.talend.mdm.workbench.propertyContributor.datamodel";

    public static final String CONTRUIBUTIONID_XSDEDITOR = "org.eclipse.wst.xsd.ui.internal.editor";

    private String curContributionID = CONTRUIBUTIONID_DATAMODELPAGE;

    IEditorInput xsdInput;

    TreeObject xobject;

    public void setXSDInput(IEditorInput input) {
        this.xsdInput = input;
    }

    public void setXObject(TreeObject xobject) {
        this.xobject = xobject;
    }

    @Override
    public String getPartName() {
    	// TODO Auto-generated method stub
    	String part= super.getPartName();
    	if(part.endsWith(".xsd")){
    		return part.substring(0,part.length()-4);
    	}
    	return part;
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
                file.setCharset("utf-8", null);
                file.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);
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
                                    IFile file = XSDEditorUtil.createFile(xobject);
                                    file.setCharset("utf-8", null);
                                    file.setContents(new ByteArrayInputStream(xsd.getBytes("utf-8")), IFile.FORCE, null);
                                }

                            }

                        }

                        refreshPropertyView();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
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

        if (type == IPropertySheetPage.class && CONTRUIBUTIONID_DATAMODELPAGE.equals(curContributionID)) {
            return new TabbedPropertySheetPage(this);
        }

        if (type == IPropertySheetPage.class && CONTRUIBUTIONID_XSDEDITOR.equals(curContributionID)) {
            return new XSDTabbedPropertySheetPage(this);
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
}
