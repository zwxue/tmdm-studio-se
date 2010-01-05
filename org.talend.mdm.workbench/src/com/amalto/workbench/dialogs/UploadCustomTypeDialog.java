package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.ResourcesUtil;
import com.amalto.workbench.widgets.FileSelectWidget;

public class UploadCustomTypeDialog extends Dialog{
	
    /**
     * The title of the dialog.
     */
    private String title;

    /**
     * The message to display, or <code>null</code> if none.
     */
    private String message;


    private Button okButton;

    
    /**
     * Error message label widget.
     */
    private Text errorMessageText;
    
    /**
     * Error message string.
     */
    private String errorMessage="Custom type name and file path can not be empty";
    
    private  Label label;
    boolean isBtnShow=true;

	private FileSelectWidget fileSelect;

	private String uripre="http://localhost:8080";

	private Text nameText;

	private TreeParent root;

    
    public UploadCustomTypeDialog(TreeParent root, Shell shell,
			String endpointIpAddress) {
        super(shell);
        this.uripre=uripre;
        this.root=root;
	}


	public void setBtnShow(boolean isBtnShow) {
		this.isBtnShow = isBtnShow;
	}


	protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
           try {
			ResourcesUtil.postResourcesFromFile(nameText.getText(), fileSelect.getText().getText(),uripre+TreeObject.CUSTOM_TYPES_URI);
			root.fireEvent(IXObjectModelListener.NEED_REFRESH, null, root);
		} catch (Exception e) {
			e.printStackTrace();
		}
        }
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
        okButton = createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, false);
        //do this here because setting the text will set enablement on the ok
        // button
        okButton.setEnabled(false);
    }
    
    
    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected Control createDialogArea(final Composite parent) {
		parent.getShell().setText("Upload Custom Type");
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2,false));
		Label nameLabel=new Label(composite,SWT.NONE);
		nameLabel.setText("Custom Type Name");
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
				false, 1, 1));
		
		nameText=new Text(composite,SWT.SINGLE|SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		Label pathLabel=new Label(composite,SWT.NONE);
		pathLabel.setText("File Path");
		pathLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
				false, 1, 1));
		fileSelect=new FileSelectWidget(composite,"",new String[]{"*.xsd"}, "",true);
		fileSelect.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 1, 1));
		
		nameText.addModifyListener(new ModifyListener(){
			
			public void modifyText(ModifyEvent e) {
				validateInput();
			}});
		fileSelect.getText().addModifyListener(new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				validateInput();
			}});
		
        // create message
        if (message != null) {
        	label = new Label(composite, SWT.NONE);
            label.setText(message);
            label.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false,2,1));
            label.setFont(parent.getFont());
        }
        
        
        errorMessageText = new Text(composite, SWT.READ_ONLY | SWT.WRAP);
        errorMessageText.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,2,1));
        errorMessageText.setBackground(errorMessageText.getDisplay()
                .getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
        // Set the error message text
        setErrorMessage(errorMessage);
        return composite;
        }
    
    protected Label getErrorMessageLabel() {
        return null;
    }
    protected Button getOkButton() {
        return okButton;
    }
 

    protected void validateInput() {
    if(nameText.getText().equalsIgnoreCase("")|| fileSelect.getText().getText().equalsIgnoreCase(""))
        setErrorMessage("Custom type name and file path can not be empty");
    else
    	setErrorMessage("");
	Control button = getButton(IDialogConstants.OK_ID);
	if (button != null) {
		button.setEnabled(errorMessage == "");
	}	
    }
    public void setErrorMessage(String errorMessage) {
    	this.errorMessage = errorMessage;
    	if (errorMessageText != null && !errorMessageText.isDisposed()) {
    		errorMessageText.setText(errorMessage == null ? " \n " : errorMessage); 
    		boolean hasError = errorMessage != null && (StringConverter.removeWhiteSpaces(errorMessage)).length() > 0;
    		errorMessageText.setEnabled(hasError);
    		errorMessageText.setVisible(hasError);
    		errorMessageText.getParent().update();
    
    	}
    }
    
	
	protected int getInputTextStyle() {
		return SWT.SINGLE | SWT.BORDER;
	}



 
public static void main(String[] args) {
	Display display=Display.getDefault();
	Shell shell =new Shell(display);
	UploadCustomTypeDialog upDia=new UploadCustomTypeDialog(null,shell,"http://localhost:8080");
	upDia.setBlockOnOpen(true);
	upDia.open();
}
    
 

}
