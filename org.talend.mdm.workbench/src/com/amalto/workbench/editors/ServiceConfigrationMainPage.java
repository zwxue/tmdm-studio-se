/**
 * 
 */
package com.amalto.workbench.editors;

import java.rmi.RemoteException;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.w3c.dom.Node;

import com.amalto.workbench.dialogs.PluginDetailsDialog;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSBoolean;
import com.amalto.workbench.webservices.WSCheckServiceConfigRequest;
import com.amalto.workbench.webservices.WSCheckServiceConfigResponse;
import com.amalto.workbench.webservices.WSGetServicesList;
import com.amalto.workbench.webservices.WSPutVersioningSystemConfiguration;
import com.amalto.workbench.webservices.WSServiceGetDocument;
import com.amalto.workbench.webservices.WSServicePutConfiguration;
import com.amalto.workbench.webservices.WSServicesList;
import com.amalto.workbench.webservices.WSServicesListItem;
import com.amalto.workbench.webservices.WSString;
import com.amalto.workbench.webservices.WSVersioningSystemConfiguration;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * @author Administrator
 *
 */
public class ServiceConfigrationMainPage extends AMainPageV2 {

	private Combo serviceNameCombo;
	protected Text serviceConfigurationsText;
	private Button defultParameterBtn;
	private Button checkButton;
	private XtentisPort port;
	protected WSServiceGetDocument document;
	private boolean refreshing=false;
	private WSServicePutConfiguration ws=new WSServicePutConfiguration();
	private Text errorLabel;

	public ServiceConfigrationMainPage(FormEditor editor) {
        super(
        		editor,
        		ServiceConfigrationMainPage.class.getName(),
        		((XObjectEditorInput)editor.getEditorInput()).getName());    
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charSection) {
		
			
        //Routing Expressions            
        Composite serviceGroup = this.getNewSectionComposite("");
        serviceGroup.setLayout(new GridLayout(2,false));            
        //Service Name
        Label serviceNameLabel = toolkit.createLabel(serviceGroup,  "Service", SWT.NULL);
        serviceNameLabel.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        
        Composite subPanel = toolkit.createComposite(serviceGroup);
        subPanel.setLayoutData( new GridData(SWT.LEFT,SWT.CENTER,false,true,1,1));
        subPanel.setLayout(new GridLayout(2,false));
        serviceNameCombo = new Combo(subPanel, SWT.DROP_DOWN|SWT.SINGLE|SWT.READ_ONLY);
        serviceNameCombo.setLayoutData(
                new GridData(SWT.LEFT,SWT.CENTER,false,true,1,1)
        );
        ((GridData)serviceNameCombo.getLayoutData()).widthHint = 300;
        serviceNameCombo.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		String serviceName = serviceNameCombo.getText();
        		try {
        			if (serviceName != null && !"".equals(serviceName)) {
							document = port.getServiceDocument(new WSString(
									serviceName.trim()));
							serviceConfigurationsText.setText(document
									.getConfigure());
							errorLabel.setText("");
						}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
        		markDirty();
        	}
        }); 
		try {
			port=Util.getPort(getXObject());
			WSServicesList list = port.getServicesList(new WSGetServicesList(""));
			WSServicesListItem[] items = list.getItem();
			if (items!=null) {
				String[] sortedList = new String[items.length];
				for (int i = 0; i < items.length; i++) {
					sortedList[i]=items[i].getJndiName();
				}
				Arrays.sort(sortedList);
				for (int i = 0; i < sortedList.length; i++) {
					WSServiceGetDocument document= port.getServiceDocument(new WSString(sortedList[i].trim()));
					if(document.getConfigureSchema()==null || document.getConfigureSchema().length()==0)continue;
					serviceNameCombo.add(sortedList[i]);
				}
				//serviceNameCombo.add("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

        //default parameters button 
        defultParameterBtn = toolkit.createButton(subPanel, "", SWT.PUSH);
        defultParameterBtn.setImage(ImageCache.getCreatedImage(EImage.HELP_CONTENTS.getPath()));
        defultParameterBtn.setToolTipText("Help...");
        defultParameterBtn.setLayoutData( new GridData(SWT.FILL,SWT.FILL,false,true,1,1));
        defultParameterBtn.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		if(serviceNameCombo.getText().trim().length()==0) return;
        		String doc = "";
        		String desc="";
        		//WSRoutingRule wsObject = (WSRoutingRule) (getXObject().getWsObject());
        		try {
//					XtentisPort port=Util.getPort(getXObject());
					WSServiceGetDocument document= port.getServiceDocument(new WSString(serviceNameCombo.getText().trim()));
		
        			desc=document.getDescription();
					doc=document.getDefaultConfig();
				} catch (Exception e1) {
					doc = "N/A";
				}
				finally
				{
					showUpDialog(desc,doc);
				}
        	};
        	
        	private void showUpDialog(String desc,String doc)
        	{
    			final PluginDetailsDialog dialog = new PluginDetailsDialog(
    					getSite().getShell(),
    					desc,
    					doc,
    					null,
    					"Default Service Configuration"
    			);
    			dialog.addListener(new Listener() {
    				public void handleEvent(Event event) {dialog.close();}
    			});
    			dialog.create();
    			dialog.getShell().setText(serviceNameCombo.getText()+" Service Configuration Details");
    			dialog.setBlockOnOpen(true);
    			dialog.open();
        	}
        });
        
        //Service Parameters
        Label serviceConfigurationsLabel = toolkit.createLabel(serviceGroup,  "Service Configuration", SWT.NULL);
        serviceConfigurationsLabel.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,2,1)
        );
        serviceConfigurationsText = toolkit.createText(serviceGroup, "",SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.WRAP);
        
        serviceConfigurationsText.setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,false,2,1)
        );
        ((GridData)serviceConfigurationsText.getLayoutData()).widthHint = 200;
        ((GridData)serviceConfigurationsText.getLayoutData()).heightHint = 120;
      	
        serviceConfigurationsText.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		markDirty();
        	}
        }); 
        checkButton=toolkit.createButton(serviceGroup, "Check", SWT.NONE);
        checkButton.addSelectionListener(new SelectionAdapter(){

			public void widgetSelected(SelectionEvent e) {
				if(serviceNameCombo.getText().trim().length()==0)return;
				String msg="";
				boolean isok=false;
				try {
					WSCheckServiceConfigResponse result= port.checkServiceConfiguration(new WSCheckServiceConfigRequest(serviceNameCombo.getText().trim(),serviceConfigurationsText.getText()));
					isok=result.getCheckResult();
					if(isok){
						msg="Connection sucessfully!";
					}else{
						msg="Connection failed, please check your url, username and password";
					}
				} catch (RemoteException e1) {					
					e1.printStackTrace();
					msg=e1.getLocalizedMessage();
				}
				errorLabel.setForeground(isok?errorLabel.getDisplay().getSystemColor(SWT.COLOR_BLUE):errorLabel.getDisplay().getSystemColor(SWT.COLOR_RED));
				errorLabel.setText(msg);
			}});        
        errorLabel=new Text(serviceGroup,SWT.WRAP);
        GridData gd=new GridData(SWT.FILL,SWT.FILL,true,true,1,2);
        //gd.heightHint=200;
        errorLabel.setLayoutData(  gd );
//        errorLabel.setImage(ImageCache.getImage( EImage.WARNING_CO.getPath()).createImage());
//        errorLabel.setVisible(false);
	}

	protected void saveChanges() {
		ws.setJndiName(serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"+serviceNameCombo.getText());
		ws.setConfiguration(serviceConfigurationsText.getText());
		try {
			if(!"".equalsIgnoreCase(ws.getJndiName())&&!"".equalsIgnoreCase(ws.getConfiguration())){				
				port.putServiceConfiguration(ws);
				//there maybe several svn settings, so we need to put it on VersionSystem
				if(serviceNameCombo.getText().equalsIgnoreCase("svn")){					
					port.putVersioningSystemConfiguration(getDefaultSvn(serviceConfigurationsText.getText()));
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
	}
	
	private WSPutVersioningSystemConfiguration getDefaultSvn(String svnConfig)throws Exception{
		Node e=Util.parse(svnConfig).getDocumentElement();
		String url=Util.getFirstTextNode(e, "./url");
		String username=Util.getFirstTextNode(e, "./username");
		String password=Util.getFirstTextNode(e, "./password");
		WSPutVersioningSystemConfiguration conf=new WSPutVersioningSystemConfiguration(new WSVersioningSystemConfiguration(
		ICoreConstants.DEFAULT_SVN,ICoreConstants.DEFAULT_SVN,
		url,username,password
		));
		return conf;
	}
	
	@Override
	protected void commit() {
		if(refreshing) return;
		this.comitting = true;
		saveChanges();
		this.comitting = false;		
	}

	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void refreshData() {
//		if (this.comitting) return;
//		this.refreshing = true;
//		this.refreshing = false;

	}


}
