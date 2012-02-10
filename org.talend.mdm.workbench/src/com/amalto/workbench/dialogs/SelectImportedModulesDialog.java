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
package com.amalto.workbench.dialogs;

import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.impl.XSDImportImpl;
import org.eclipse.xsd.impl.XSDIncludeImpl;

import com.amalto.workbench.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.XtentisPort;

public class SelectImportedModulesDialog extends Dialog {

    private static Log log = LogFactory.getLog(SelectImportedModulesDialog.class);

    private String title;

    private TableViewer tableViewer;

    private List<XSDDesc> xsdDescList = new ArrayList<XSDDesc>();

    private List<String> xsdImpList = new ArrayList<String>();

    private List<String> toDelList = new ArrayList<String>();

    private Shell shell;

    private TreeObject treeObject;

    private XSDSchema xsdSchema;

    private Button delLabelButton;

    private static final Image LOCAL = ImageCache.getCreatedImage(EImage.SERVER.getPath());

    private static final Image MDM_WEB = ImageCache.getCreatedImage(EImage.SERVERNOTRUNNING.getPath());

    private static final Image OTHER_WEB = ImageCache.getCreatedImage(EImage.SERVERNAVIGATOR.getPath());

    private static String EXCHANGE_DOWNLOAD_URL = "http://www.talendforge.org/exchange/mdm/api/get_last_extensions.php";//$NON-NLS-1$

    protected String url = null;

    public SelectImportedModulesDialog(Shell parentShell, XSDSchema schema, TreeObject treeObj, String title) {
        super(parentShell);
        this.shell = parentShell;
        this.treeObject = treeObj;
        this.title = title;
        this.xsdSchema = schema;

        String endpointIpAddress = treeObject.getEndpointIpAddress();
        if (endpointIpAddress != null && endpointIpAddress.length() > 0) {
            url = endpointIpAddress + "/pubcomponent/secure/dataModelsTypes/";//$NON-NLS-1$
        }
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(this.title);

        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout layout = (GridLayout) composite.getLayout();
        layout.numColumns = 2;

        Label label = new Label(composite, SWT.NONE);
        label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
        label.setText(Messages.getString("ViewerWithModules")); //$NON-NLS-1$

        tableViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData data = new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1);
        tableViewer.getControl().setLayoutData(data);
        ((GridData) tableViewer.getControl().getLayoutData()).heightHint = 250;
        ((GridData) tableViewer.getControl().getLayoutData()).widthHint = 300;

        XSDSchemaLabelProvider labelProvider = new XSDSchemaLabelProvider();
        XSDSchemaContentProvider contentProvider = new XSDSchemaContentProvider();
        tableViewer.setContentProvider(contentProvider);
        tableViewer.setLabelProvider(labelProvider);
        tableViewer.setInput(new Object());
        tableViewer.setSorter(new ViewerSorter() {

            @Override
            public int category(Object element) {
                if (element instanceof XSDDesc) {
                    return ((XSDDesc) element).getType();
                }
                return -1;
            }

            @Override
            public int compare(Viewer theViewer, Object e1, Object e2) {
                int cat1 = category(e1);
                int cat2 = category(e2);
                return cat1 - cat2;
            }
        });

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                delLabelButton.setEnabled(!selection.isEmpty());
            }
        });

        Composite compositeBtn = new Composite(composite, SWT.FILL);
        compositeBtn.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
        compositeBtn.setLayout(new GridLayout(1, false));

        Button addXSDFromLocal = new Button(compositeBtn, SWT.PUSH | SWT.FILL);
        addXSDFromLocal.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
        addXSDFromLocal.setText(Messages.getString("AddXsdFromlocal")); //$NON-NLS-1$
        addXSDFromLocal.setToolTipText(Messages.getString("AddXsdSchemaFromlocal")); //$NON-NLS-1$
        addXSDFromLocal.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                FileDialog fd = new FileDialog(shell.getShell(), SWT.SAVE);
                fd.setFilterExtensions(new String[] { "*.xsd" });//$NON-NLS-1$
                fd.setText(Messages.getString("ImportXSDSchema")); //$NON-NLS-1$
                String filename = fd.open();

                if (filename == null)
                    return;
                File file = new File(filename);
                try {
                    log.info(file.toURL());
                } catch (MalformedURLException e1) {
                    log.error(e1.getMessage(), e1);
                }
                XSDDesc xsdDesc = buildUp(filename, LOCAL, 0);
                include(xsdDesc);
                getButton(IDialogConstants.OK_ID).setEnabled(true);
                tableViewer.refresh();
            }
        });
        if (Util.IsEnterPrise()) {
            Button addXSDFromWebSite = new Button(compositeBtn, SWT.PUSH | SWT.FILL);
            addXSDFromWebSite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
            addXSDFromWebSite.setText(Messages.getString("AddTypesDataModels")); //$NON-NLS-1$
            addXSDFromWebSite.setToolTipText(Messages.getString("AddFromModelTypes")); //$NON-NLS-1$
            addXSDFromWebSite.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
                };

                public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                    MDMXSDSchemaEntryDialog dlg = new MDMXSDSchemaEntryDialog(shell.getShell(), Messages
                            .getString("SelectXSDSchemaWebSite")); //$NON-NLS-1$
                    try {
                        ArrayList<String> schemaList = new ArrayList<String>();
                        resolveSchemaList(schemaList, dlg);

                     
                    } catch (Exception es) {
                        log.error(es.getMessage(), es);
                        return;
                    }
                    dlg.setBlockOnOpen(true);
                    dlg.open();
                    if (dlg.getReturnCode() == Window.OK) {
                        if (getUrl() == null) {
                            MessageDialog.openError(getShell(), Messages.getString("Error.title"), Messages //$NON-NLS-1$
                                    .getString("ServerNotNull")); //$NON-NLS-1$
                            return;
                        }
                        List<String> urls = dlg.getMDMDataModelUrls();
                        for (String url : urls) {
                            XSDDesc xsdDesc = buildUp(getUrl() + url + "/types", MDM_WEB, 1);//$NON-NLS-1$
                            include(xsdDesc);
                        }
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                        tableViewer.refresh();
                    }
                }
            });
        }

        Button impXSDFromExchange = new Button(compositeBtn, SWT.PUSH | SWT.FILL);
        impXSDFromExchange.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
        impXSDFromExchange.setText(Messages.getString("ImportFromExchangeServer")); //$NON-NLS-1$
        impXSDFromExchange.setToolTipText(Messages.getString("ImportSchemaFromServer")); //$NON-NLS-1$
        impXSDFromExchange.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {
            }

            public void widgetSelected(SelectionEvent e) {
                HttpClient client = new HttpClient();
                String importFolder = System.getProperty("user.dir");//$NON-NLS-1$
                StringBuffer repository = new StringBuffer();
                ImportExchangeOptionsDialog dlg = new ImportExchangeOptionsDialog(shell.getShell(), null, false, repository);
                dlg.setBlockOnOpen(true);
                int ret = dlg.open();
                if (ret == Window.OK) {
                    File dir = new File(repository.toString());
                    for (File file : dir.listFiles()) {
                        if (file.getName().endsWith(".xsd")) {//$NON-NLS-1$
                            XSDDesc xsdDesc = buildUp(file.getAbsolutePath(), MDM_WEB, 1);
                            include(xsdDesc);
                        }
                    }

                    getButton(IDialogConstants.OK_ID).setEnabled(true);
                    tableViewer.refresh();
                }
            }

        });

        Button addXSDFromInputDlg = new Button(compositeBtn, SWT.PUSH | SWT.FILL);
        addXSDFromInputDlg.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
        addXSDFromInputDlg.setText(Messages.getString("AddXsdFromOther")); //$NON-NLS-1$
        addXSDFromInputDlg.setToolTipText(Messages.getString("AddFromOtherSite")); //$NON-NLS-1$
        addXSDFromInputDlg.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                InputDialog id = new InputDialog(shell.getShell(), Messages.getString("AddXsdFromOther"), //$NON-NLS-1$
                        Messages.getString("EnterTextUrl"), "", new IInputValidator() { //$NON-NLS-1$//$NON-NLS-2$

                            public String isValid(String newText) {
                                if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                                    return Messages.getString("NameNotEmpty"); //$NON-NLS-1$
                                return null;
                            };
                        });

                id.setBlockOnOpen(true);
                int ret = id.open();
                if (ret == Window.CANCEL) {
                    return;
                }
                XSDDesc xsdDesc = buildUp(id.getValue(), OTHER_WEB, 2);
                include(xsdDesc);
                getButton(IDialogConstants.OK_ID).setEnabled(true);
                tableViewer.refresh();
            }
        });

        delLabelButton = new Button(compositeBtn, SWT.PUSH);
        delLabelButton.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false, 1, 1));
        delLabelButton.setText(Messages.getString("DeleteXsdModule")); //$NON-NLS-1$
        delLabelButton.setToolTipText(Messages.getString("DeleteText")); //$NON-NLS-1$
        delLabelButton.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
                for (Iterator<XSDDesc> iter = selection.iterator(); iter.hasNext();) {
                    XSDDesc desc = (XSDDesc) iter.next();
                    xsdDescList.remove(desc);
                    toDelList.add(desc.getURL());
                }
                getButton(IDialogConstants.OK_ID).setEnabled(true);
                tableViewer.refresh();
            };
        });

        countImportListInSchema();

        tableViewer.setInput(xsdDescList);
        return composite;
    }

    private void countImportListInSchema() {
        xsdDescList.clear();
        try {
            for (XSDSchemaContent cnt : xsdSchema.getContents()) {
                String schemaLocation = "";//$NON-NLS-1$
                if (cnt instanceof XSDImportImpl) {
                    XSDImportImpl imp = (XSDImportImpl) cnt;
                    schemaLocation = imp.getSchemaLocation();
                } else if (cnt instanceof XSDIncludeImpl) {
                    XSDIncludeImpl incu = (XSDIncludeImpl) cnt;
                    schemaLocation = incu.getSchemaLocation();
                } else
                    continue;
                if (schemaLocation != null) {
                    Pattern httpUrl = Pattern.compile("(http|https|ftp):(\\//|\\\\)(.*):(.*)");//$NON-NLS-1$
                    Matcher match = httpUrl.matcher(schemaLocation);
                    if (match.matches()) {
                        InetAddress addr = InetAddress.getLocalHost();
                        String ip = match.group(3);
                        boolean local = ip.equals(addr.getHostAddress()) || ip.equals("localhost") || ip.equals("127.0.0.1");//$NON-NLS-1$//$NON-NLS-2$
                        Image img = local ? MDM_WEB : OTHER_WEB;
                        int type = local ? 1 : 2;
                        XSDDesc xsdDesc = buildUp(schemaLocation, img, type);
                        xsdDescList.add(xsdDesc);
                    } else if (!schemaLocation.equals("")) {//$NON-NLS-1$
                        XSDDesc xsdDesc = buildUp(schemaLocation, LOCAL, 0);
                        xsdDescList.add(xsdDesc);
                    }
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void include(XSDDesc xsdDesc) {
        for (XSDDesc xc : xsdDescList) {
            if (xc.getURL().equals(xsdDesc.getURL()))
                return;
        }

        xsdDescList.add(xsdDesc);
    }

    private XSDDesc buildUp(String url, Image image, int type) {
        return new XSDDesc(url, image, type);
    }

    @Override
    protected Control createButtonBar(Composite parent) {
        Control control = super.createButtonBar(parent);
        getButton(IDialogConstants.OK_ID).setEnabled(false);
        delLabelButton.setEnabled(false);
        return control;
    }

    public List<String> getImportedXSDList() {
        for (XSDDesc des : xsdDescList) {
            xsdImpList.add(des.getURL());
        }
        return xsdImpList;
    }

    public List<String> getToDelXSDList() {
        for (String xsd : xsdImpList) {
            if (toDelList.contains(xsd)) {
                toDelList.remove(xsd);
            }
        }
        return toDelList;
    }

    protected void resolveSchemaList(List<String> schemaList, MDMXSDSchemaEntryDialog dlg) throws Exception {

        XtentisPort port = getPort();
        if (port == null) {
            MessageDialog.openError(getShell(), Messages.getString("Error.title"), Messages.getString("ServerNotNull")); //$NON-NLS-1$//$NON-NLS-2$
            return;
        }
        WSDataModelPK[] xdmPKs = port.getDataModelPKs(new WSRegexDataModelPKs("")).getWsDataModelPKs();//$NON-NLS-1$
        if (xdmPKs != null) {
            for (int i = 0; i < xdmPKs.length; i++) {
                String name = xdmPKs[i].getPk();
                if (!name.startsWith("XMLSCHEMA")) {//$NON-NLS-1$
                    schemaList.add(name);
                }
            }
            dlg.create();
            dlg.retrieveDataModels((ArrayList<String>) schemaList, false);
        }

    }

    protected XtentisPort getPort() throws XtentisException {
            return Util.getPort(treeObject);
    }

    protected String getUrl() {
        return this.url;
    }

    private static class XSDSchemaLabelProvider extends StyledCellLabelProvider {

        public XSDSchemaLabelProvider() {
        }

        @Override
        public void update(ViewerCell cell) {
            Object element = cell.getElement();

            if (element instanceof XSDDesc) {
                XSDDesc xsdDesc = (XSDDesc) element;

                cell.setText(xsdDesc.getURL());
                cell.setImage(xsdDesc.getImage());

            } else {
                cell.setText("Unknown element"); //$NON-NLS-1$
            }

            super.update(cell);
        }

        @Override
        protected void measure(Event event, Object element) {
            super.measure(event, element);
        }
    }

    private class XSDSchemaContentProvider implements IStructuredContentProvider {

        public Object[] getElements(Object element) {

            return xsdDescList.toArray(new XSDDesc[] {});
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    }

    private class XSDDesc implements Serializable {

        private String _url;

        private Image _image;

        private int _type;

        public XSDDesc() {
        }

        public XSDDesc(String url, Image image, int type) {
            _url = url;
            _image = image;
            _type = type;
        }

        public String getURL() {
            return _url;
        }

        public Image getImage() {
            return _image;
        }

        public int getType() {
            return _type;
        }
    }
}
