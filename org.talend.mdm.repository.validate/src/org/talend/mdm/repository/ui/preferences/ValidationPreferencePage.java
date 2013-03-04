package org.talend.mdm.repository.ui.preferences;

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
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.talend.mdm.repository.core.validate.i18n.Messages;

public class ValidationPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private Button needShowDialogAfterImmediateButton;

    private Button needShowDialogAfterSavedButton;

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


    protected void doCreateContent(Composite parent) {
        Composite immediateComposite = createExpandComposite(parent, Messages.ValidationPrefPage_RightClick_Title, true);
        needShowDialogAfterImmediateButton = new Button(immediateComposite, SWT.CHECK);
        needShowDialogAfterImmediateButton.setText(Messages.ValidationPrefPage_Button_Text);

        Composite savedComposite = createExpandComposite(parent, Messages.ValidationPreferencePage_SavingDialog_Title, true);
        needShowDialogAfterSavedButton = new Button(savedComposite, SWT.CHECK);
        needShowDialogAfterSavedButton.setText(Messages.ValidationPreferencePage_SavingButton_Text);
    }

    private Composite createExpandComposite(final Composite parent, String title, boolean needExpanded) {
        ExpandableComposite expComposite = new ExpandableComposite(parent, ExpandableComposite.TREE_NODE
                | ExpandableComposite.EXPANDED);
        expComposite.setLayout(new GridLayout());
        expComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Composite composite = new Composite(expComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginLeft = 10;
        layout.marginRight = 10;
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        expComposite.setClient(composite);
        expComposite.setText(title);
        expComposite.setExpanded(needExpanded);
        expComposite.addExpansionListener(new ExpansionAdapter() {

            @Override
            public void expansionStateChanged(ExpansionEvent e) {
                parent.layout();
            }
        });
        return composite;
    }

    private void initControls() {
        needShowDialogAfterImmediateButton.setSelection(needShowDialog());
        needShowDialogAfterSavedButton.setSelection(needShowDialogAfterSaved());
    }

    @Override
    public boolean performOk() {
        getPreferenceStore().setValue(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_IMMEDIATE,
                needShowDialogAfterImmediateButton.getSelection());
        getPreferenceStore().setValue(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_SAVING,
                needShowDialogAfterSavedButton.getSelection());
        return super.performOk();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    @Override
    protected void performDefaults() {
        getPreferenceStore().setValue(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_IMMEDIATE, true);
        getPreferenceStore().setValue(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_SAVING, true);
        initControls();
    }

    private boolean needShowDialog() {
        return getPreferenceStore().getBoolean(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_IMMEDIATE);
    }

    private boolean needShowDialogAfterSaved() {
        return getPreferenceStore().getBoolean(IValidationPerferenceConstant.SHOW_RESULT_DIALOG_AFTER_SAVING);
    }
}
