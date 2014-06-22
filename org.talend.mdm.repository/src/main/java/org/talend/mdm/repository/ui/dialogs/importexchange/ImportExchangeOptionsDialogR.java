package org.talend.mdm.repository.ui.dialogs.importexchange;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.ImportExchangeOptionsDialog;


public class ImportExchangeOptionsDialogR extends ImportExchangeOptionsDialog {

    public ImportExchangeOptionsDialogR(Shell parentShell, FormToolkit toolkit, boolean importOption,
            StringBuffer zipFileRepository) {
        super(parentShell, toolkit, importOption, zipFileRepository);
    }
    
    @Override
    public void fillInTable() {
        clearTable();
    }
}
