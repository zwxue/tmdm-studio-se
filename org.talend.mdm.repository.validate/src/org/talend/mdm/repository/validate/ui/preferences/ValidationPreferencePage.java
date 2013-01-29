package org.talend.mdm.repository.validate.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.talend.mdm.repository.core.validate.i18n.Messages;

public class ValidationPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private Button needShowDialogButton;

    public ValidationPreferencePage() {
    }

    public ValidationPreferencePage(String title) {
        super(title);
    }

    public ValidationPreferencePage(String title, ImageDescriptor image) {
        super(title, image);
    }

    @Override
    public void init(IWorkbench workbench) {
        IPreferenceStore prefStore = PlatformUI.getPreferenceStore();
        setPreferenceStore(prefStore);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        doCreateContent(composite);
        initControls();
        return composite;
    }

    /**
     * DOC talend-mdm Comment method "doCreateContent".
     * 
     * @param composite
     */
    protected void doCreateContent(Composite parent) {
        ExpandableComposite expComposite = new ExpandableComposite(parent, ExpandableComposite.TREE_NODE
                | ExpandableComposite.EXPANDED);
        expComposite.setLayout(new GridLayout());
        expComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
        Composite composite = new Composite(expComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginLeft = 10;
        layout.marginRight = 10;
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        needShowDialogButton = new Button(composite, SWT.CHECK);
        needShowDialogButton.setText(Messages.ValidationPrefPage_Button_Text);
        expComposite.setClient(composite);
        expComposite.setText(Messages.ValidationPrefPage_RightClick_Title);
        expComposite.setExpanded(true);
    }

    private void initControls() {
        needShowDialogButton.setSelection(needShowDialog());
    }

    @Override
    public boolean performOk() {
        getPreferenceStore().setValue(ValidationPerferenceConstant.SHOW_DIALOG_RIGHT_CLICK, needShowDialogButton.getSelection());
        return super.performOk();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    @Override
    protected void performDefaults() {
        getPreferenceStore().setValue(ValidationPerferenceConstant.SHOW_DIALOG_RIGHT_CLICK, true);
    }

    private boolean needShowDialog() {
        return getPreferenceStore().getBoolean(ValidationPerferenceConstant.SHOW_DIALOG_RIGHT_CLICK);
    }
}
