package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class JobProcesssOptionsDialog extends Dialog {
	private String title;
	private boolean isExchange = true;
	private Button btnExchange;
	private Button btnItem;

	public JobProcesssOptionsDialog(Shell parentShell, String dialogTitle) {
		super(parentShell);
		this.title = dialogTitle;
	}

	protected Control createDialogArea(Composite parent) {
		// Should not really be here but well,....
		parent.getShell().setText(this.title);

		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = (GridLayout) composite.getLayout();
		layout.numColumns = 1;

		btnExchange = new Button(composite, SWT.RADIO);
		btnExchange.setSelection(true);
		btnExchange.setText("Send a complete \"exchange\" document");

		btnItem = new Button(composite, SWT.RADIO);
		btnItem
				.setText("Only send an \"item\" document (backward compatibility)");

		return composite;
	}

	protected void buttonPressed(int buttonId) {

		isExchange = btnExchange.getSelection();

		super.buttonPressed(buttonId);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (title != null) {
			shell.setText(title);
		}
	}

	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);

	}

	public boolean isExchange() {
		return isExchange;
	}

	public void setExchange(boolean isExchange) {
		this.isExchange = isExchange;
	}

}
