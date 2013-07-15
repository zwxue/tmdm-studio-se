// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.preferences;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.axis.utils.StringUtils;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.preferences.JSSEConstans.KEYSTORE_TYPE;
import com.amalto.workbench.preferences.JSSEConstans.KeystoreSource;
import com.amalto.workbench.preferences.JSSEConstans.SSL_Algorithm;
import com.amalto.workbench.preferences.JSSEConstans.TruststoreSource;
import com.amalto.workbench.preferences.JSSEConstans.VERIFY_TYPE;
import com.amalto.workbench.utils.SSLContextProvider;

/**
 * created by changguopiao on 2013-7-10 Detailled comment
 * 
 */
public class SSLPreperences extends PreferencePage implements IWorkbenchPreferencePage {

    static final String[] SSL_ALGORITHMS;

    static final String[] KEYSTORE_TYPES;

    static final Map<String, String> VERIFY_MODES = new LinkedHashMap<String, String>();
    static {
        SSL_Algorithm[] algorithms = SSL_Algorithm.values();
        SSL_ALGORITHMS = new String[algorithms.length];
        for (int i = 0; i < algorithms.length; i++) {
            SSL_ALGORITHMS[i] = algorithms[i].name();
        }
        KEYSTORE_TYPE[] kt = KEYSTORE_TYPE.values();
        KEYSTORE_TYPES = new String[kt.length];
        for (int i = 0; i < kt.length; i++) {
            KEYSTORE_TYPES[i] = kt[i].name();
        }
        VERIFY_TYPE[] vs = VERIFY_TYPE.values();
        for (VERIFY_TYPE type : vs) {
            String param = "verify_" + type.name(); //$NON-NLS-1$
            String msg = getMessage(param);
            VERIFY_MODES.put(type.name(), msg);
        }
    }

    static String getMessage(String field) {
        try {
            return Messages.class.getField(field).get(null).toString();
        } catch (Exception e) {
            return field;
        }
    }

    public synchronized void init(IWorkbench workbench) {
        IPreferenceStore store = MDMWorbenchPlugin.getDefault().getPreferenceStore();
        super.setPreferenceStore(store);
    }

    Combo sslAlgorithmCombo;

    Combo verificationType;

    static CLabel createLabel(Composite parent, String text) {
        CLabel label = new CLabel(parent, SWT.LEFT);
        label.setText(text);
        GridDataFactory.fillDefaults().applyTo(label);
        return label;
    }

    static Text createText(Composite parent, String content, int hsize) {
        return createText(parent, content, hsize, false);
    }

    static Text createText(Composite parent, String content, int hsize, boolean pw) {
        Text text = null;
        if (pw) {
            text = new Text(parent, SWT.BORDER | SWT.PASSWORD);
        } else {
            text = new Text(parent, SWT.SINGLE | SWT.BORDER);
        }
        if (null != content) {
            text.setText(content);
        }
        if (hsize == 1) {
            GridDataFactory.swtDefaults().span(hsize, 1).minSize(100, -1).applyTo(text);
        } else {
            GridDataFactory.fillDefaults().span(hsize, 1).minSize(100, -1).applyTo(text);
        }
        return text;
    }

    static Combo createCombo(Composite parent, Collection<String> items, String dItem, int hsize) {
        int index = 0;
        String[] itemArray = new String[items.size()];
        int i = 0;
        for (String it : items) {
            itemArray[i] = it;
            if (it.equals(dItem)) {
                index = i;
            }
            i++;
        }
        return createCombo(parent, itemArray, index, hsize);
    }

    static Combo createCombo(Composite parent, String[] items, int index, int hsize) {
        Combo combo = new Combo(parent, SWT.READ_ONLY | SWT.BORDER);
        combo.setItems(items);
        combo.select(index);
        GridDataFactory.defaultsFor(combo).span(hsize, 1).indent(hsize, 1).minSize(100, SWT.DEFAULT).applyTo(combo);
        return combo;
    }

    static Combo createCombo(Composite parent, String[] items, String dItem, int hsize) {
        int index = 0;
        if (null != dItem) {
            for (int i = 0; i < items.length; i++) {
                if (dItem.equals(items[i])) {
                    index = i;
                }
            }
        }
        return createCombo(parent, items, index, hsize);
    }

    static void createFilePicker(Composite parent, final Text text, final Shell shell) {
        Button button = new Button(parent, SWT.PUSH);
        button.setText(Messages.fileBrowse);
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(shell);
                dialog.setText(Messages.keystoreFileTile);
                String str = dialog.open();
                if (null != str) {
                    text.setText(str);
                }
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createContents(Composite parent) {
        IPreferenceStore store = getPreferenceStore();
        Composite composite = new Composite(parent, SWT.NONE);
        GridDataFactory.fillDefaults().applyTo(composite);
        composite.setLayout(new GridLayout(1, false));
        {
            Group group = new Group(composite, SWT.NONE);
            group.setText(Messages.securityTitle);
            GridDataFactory.fillDefaults().applyTo(group);
            group.setLayout(new GridLayout(3, false));
            createLabel(group, Messages.sslAlgorithm);
            sslAlgorithmCombo = createCombo(group, SSL_ALGORITHMS, store.getString(PreferenceConstants.SSL_Algorithm), 2);
            createLabel(group, Messages.hostnameVerificationMode);
            verificationType = createCombo(group, VERIFY_MODES.values(),
                    VERIFY_MODES.get(store.getString(PreferenceConstants.VERIFY_TYPE)), 2);
        }
        createKeystoreTable(composite);
        return composite;
    }

    CheckboxTableViewer viewer;

    void createTableColumn(int width, String name, TableColumnLayout layout, boolean pixel) {
        TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer, SWT.LEFT);
        TableColumn tc = tableViewerColumn.getColumn();
        tc.setText(name);
        if (pixel) {
            layout.setColumnData(tc, new ColumnPixelData(width, false, true));
        } else {
            layout.setColumnData(tc, new ColumnWeightData(width, ColumnWeightData.MINIMUM_WIDTH, true));
        }
    }

    /**
     * DOC changguopiao Comment method "createKeystoreTable".
     * 
     * @param parent
     */
    private void createKeystoreTable(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
        TableColumnLayout layout = new TableColumnLayout();
        composite.setLayout(layout);

        viewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER | SWT.READ_ONLY | SWT.FULL_SELECTION);
        GridDataFactory.fillDefaults().hint(-1, 300).applyTo(viewer.getControl());
        Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        createTableColumn(50, "", layout, true); //$NON-NLS-1$
        createTableColumn(100, Messages.keystore_column_type, layout, true);
        createTableColumn(200, Messages.keystore_column_path, layout, false);
        final MenuManager mm = new MenuManager();
        mm.add(new AddKeystore(false));
        mm.add(new AddKeystore(true));
        mm.add(new RemoveKeystore());
        Menu m = mm.createContextMenu(viewer.getControl());
        table.setMenu(m);
        table.addListener(SWT.Selection, new Listener() {

            public void handleEvent(Event event) {
                if (event.detail != SWT.CHECK) {
                    return;
                }
                TableItem item = (TableItem) event.item;
                if (null == item) {
                    return;
                }
                Object obj = item.getData();
                if (null != obj && obj instanceof TruststoreSource) {
                    ((TruststoreSource) obj).setEnable(item.getChecked());
                    SSLContextProvider.getInstance().changeSource();
                }

            }
        });

        SSLProvider provider = new SSLProvider();
        viewer.setContentProvider(provider);
        viewer.setLabelProvider(provider);
        viewer.setCheckStateProvider(provider);
        viewer.setInput(SSLContextProvider.getInstance());
    }

    static void comboSelect(Combo combo, String str) {
        if (null == str) {
            return;
        }
        String[] items = combo.getItems();
        for (int i = 0; i < items.length; i++) {
            if (str.equals(items[i])) {
                combo.select(i);
                return;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    @Override
    protected void performDefaults() {
        IPreferenceStore store = getPreferenceStore();
        comboSelect(sslAlgorithmCombo, store.getDefaultString(PreferenceConstants.SSL_Algorithm));
        comboSelect(verificationType, VERIFY_MODES.get(store.getDefaultString(PreferenceConstants.VERIFY_TYPE)));
        super.performDefaults();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performOk()
     */
    @Override
    public boolean performOk() {
        IPreferenceStore store = getPreferenceStore();
        store.setDefault(PreferenceConstants.SSL_Algorithm, sslAlgorithmCombo.getText());
        String vType = verificationType.getText();
        for (String key : VERIFY_MODES.keySet()) {
            String value = VERIFY_MODES.get(key);
            if (vType.equals(value)) {
                store.setValue(PreferenceConstants.VERIFY_TYPE, key);
                break;
            }
        }
        SSLContextProvider.getInstance().saveKeystore();
        return super.performOk();
    }

    class RemoveKeystore extends Action {

        @Override
        public String getText() {
            return Messages.keystore_action_remove;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.action.Action#run()
         */
        @Override
        public void run() {
            StructuredSelection selection = (StructuredSelection) viewer.getSelection();
            Object selectObj = selection.getFirstElement();
            if (null == selectObj) {
                return;
            }
            if (selectObj instanceof TruststoreSource) {
                SSLContextProvider.getInstance().removeKeystore((TruststoreSource) selectObj);
            }
            viewer.refresh();
        }
    }

    class AddKeystore extends Action {

        boolean flag;

        public AddKeystore(boolean flag) {
            this.flag = flag;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.action.Action#getImageDescriptor()
         */
        @Override
        public ImageDescriptor getImageDescriptor() {
            if (flag) {
                return SSLProvider.lock;
            }
            return SSLProvider.unlock;
        }

        @Override
        public String getText() {
            if (flag) {
                return Messages.keystore_action_add_key;
            }
            return Messages.keystore_action_add_trust;
        }

        @Override
        public void run() {
            KeystoreDialog dialog = new KeystoreDialog(getShell(), flag);
            int ret = dialog.open();
            if (ret == Dialog.OK) {
                viewer.refresh();
            }
        }
    }
}

class SSLProvider implements IStructuredContentProvider, ITableLabelProvider, ICheckStateProvider {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
     * java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof SSLContextProvider) {
            return ((SSLContextProvider) inputElement).getKeystores();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    public void addListener(ILabelProviderListener listener) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
     */
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    public void removeListener(ILabelProviderListener listener) {

    }

    static ImageDescriptor lock = ImageDescriptor.createFromFile(SSLProvider.class, "lock.gif"); //$NON-NLS-1$

    static ImageDescriptor unlock = ImageDescriptor.createFromFile(SSLProvider.class, "unlock.gif"); //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage(Object element, int columnIndex) {
        if (columnIndex == 0) {
            if (element instanceof KeystoreSource) {
                return lock.createImage();
            } else {
                return unlock.createImage();
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    public String getColumnText(Object element, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return ""; //$NON-NLS-1$
        case 1:
            if (element instanceof KeystoreSource) {
                return "Keystore/" + ((KeystoreSource) element).getType(); //$NON-NLS-1$
            } else {
                return "Truststore/" + ((TruststoreSource) element).getType(); //$NON-NLS-1$
            }
        case 2:
            return ((TruststoreSource) element).getSource().toExternalForm();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ICheckStateProvider#isChecked(java.lang.Object)
     */
    public boolean isChecked(Object element) {
        if (element instanceof TruststoreSource) {
            return ((TruststoreSource) element).isEnable();
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ICheckStateProvider#isGrayed(java.lang.Object)
     */
    public boolean isGrayed(Object element) {
        return false;
    }

}

class KeystoreDialog extends Dialog {

    boolean isKeystore;

    /**
     * DOC changguopiao KeystoreDialog constructor comment.
     */
    protected KeystoreDialog(Shell parentShell, boolean isKeystore) {
        super(parentShell);
        this.isKeystore = isKeystore;
    }

    Text keyText;

    Text pwText;

    Text mpwText;

    Combo typeCombo;

    CLabel label;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        try {
            SSLContextProvider provide = SSLContextProvider.getInstance();
            if (StringUtils.isEmpty(keyText.getText())) {
                throw new Exception(Messages.keystore_error_emptypath);
            }
            File file = new File(keyText.getText());
            if (!file.exists()) {
                throw new Exception(Messages.keystore_error_nofile);
            }
            if (isKeystore) {
                KeystoreSource entity = new KeystoreSource(file, pwText.getText(), mpwText.getText(), typeCombo.getText());
                provide.addKeystore(entity);
            } else {
                TruststoreSource entity = new TruststoreSource(file, pwText.getText(), typeCombo.getText());
                provide.addKeystore(entity);
            }
            label.setText(""); //$NON-NLS-1$
            super.okPressed();
        } catch (Exception e) {
            label.setText(e.getMessage());
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite con = (Composite) super.createDialogArea(parent);
        String titleStr;
        if (isKeystore) {
            titleStr = Messages.keystoreConfiguration;
        } else {
            titleStr = Messages.truststoreConfiguration;
        }
        Group group = new Group(con, SWT.NONE);
        group.setText(titleStr);
        GridDataFactory.fillDefaults().applyTo(group);
        label = SSLPreperences.createLabel(con, ""); //$NON-NLS-1$
        label.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
        GridDataFactory.fillDefaults().hint(-1, 10).applyTo(label);

        group.setLayout(new GridLayout(3, false));

        SSLPreperences.createLabel(group, Messages.keystorePath);
        keyText = SSLPreperences.createText(group, "", 1); //$NON-NLS-1$
        SSLPreperences.createFilePicker(group, keyText, parent.getShell());

        SSLPreperences.createLabel(group, Messages.keystorePassword);
        pwText = SSLPreperences.createText(group, "", 2, true); //$NON-NLS-1$
        if (isKeystore) {
            SSLPreperences.createLabel(group, Messages.keystoreMainPassword);
            mpwText = SSLPreperences.createText(group, "", 1, true); //$NON-NLS-1$
            final Button button = new Button(group, SWT.CHECK);
            GridDataFactory.defaultsFor(button).align(SWT.LEFT, SWT.TOP).applyTo(button);
            button.setText(Messages.keystore_same_as_storepassword);
            mpwText.setEditable(false);
            button.setSelection(true);

            button.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    if (button.getSelection()) {
                        mpwText.setEditable(false);
                    } else {
                        mpwText.setEditable(true);
                    }
                }

            });
            pwText.addModifyListener(new ModifyListener() {

                public void modifyText(ModifyEvent e) {
                    if (button.getSelection()) {
                        mpwText.setText(pwText.getText());
                    }
                }
            });
        }
        SSLPreperences.createLabel(group, Messages.keyststoreType);
        typeCombo = SSLPreperences.createCombo(group, SSLPreperences.KEYSTORE_TYPES, PreferenceConstants.KEYSTORE_TYPE, 2);
        return con;
    }
}
