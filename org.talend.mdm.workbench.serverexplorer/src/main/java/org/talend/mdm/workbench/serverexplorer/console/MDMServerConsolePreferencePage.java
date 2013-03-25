package org.talend.mdm.workbench.serverexplorer.console;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;


public class MDMServerConsolePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private Spinner freqSpinner = null;

    private Text numberText = null;

    public void init(IWorkbench workbench) {
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return PlatformUI.getPreferenceStore();
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

    private void doCreateContent(Composite parent) {
        Composite composite1 = new Composite(parent, SWT.NONE);
        composite1.setLayout(new GridLayout(3, false));
        composite1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        new Label(composite1, SWT.NONE).setText("Refr esh Frequency of the display");
        freqSpinner = new Spinner(composite1, SWT.BORDER | SWT.READ_ONLY);
        freqSpinner.setMaximum(5);
        freqSpinner.setMinimum(1);
        GridDataFactory.fillDefaults().hint(10, SWT.DEFAULT).applyTo(freqSpinner);
        new Label(composite1, SWT.NONE).setText("s");

        Composite composite2 = new Composite(parent, SWT.NONE);
        composite2.setLayout(new GridLayout(2, false));
        composite2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        new Label(composite2, SWT.NONE).setText("Max number of lines displayed");
        numberText = new Text(composite2, SWT.BORDER);
        GridDataFactory.fillDefaults().hint(100, SWT.DEFAULT).applyTo(numberText);
        numberText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                String text = numberText.getText().trim();
                try {
                    Integer.parseInt(text);
                    setErrorMessage(null);
                    setValid(true);
                } catch (NumberFormatException ex) {
                    setErrorMessage("Value must be an Integer!");
                    setValid(false);
                }
            }
        });
    }

    private void initControls() {
        int frequency = doGetPreferenceStore().getInt(MDMServerPreferenceInitializer.REFRESH_FREQ);
        freqSpinner.setSelection(frequency);

        int number = doGetPreferenceStore().getInt(MDMServerPreferenceInitializer.DISPLAY_MAX_NUMBER);
        numberText.setText(String.valueOf(number));
    }

    @Override
    public boolean performOk() {
        doGetPreferenceStore().setValue(MDMServerPreferenceInitializer.REFRESH_FREQ, freqSpinner.getSelection());
        String value = numberText.getText().trim();
        doGetPreferenceStore().setValue(MDMServerPreferenceInitializer.DISPLAY_MAX_NUMBER, Integer.parseInt(value));
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
        initControls();
        super.performDefaults();
    }
}
