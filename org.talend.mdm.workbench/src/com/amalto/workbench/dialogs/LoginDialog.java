package com.amalto.workbench.dialogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import sun.security.util.Password;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.PasswordUtil;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSUniversePK;

public class LoginDialog extends Dialog {
	
//	private static String f = System.getProperty("user.dir")+"/.mdmworkbench.conf";
//	private static String f = System.getProperty("user.dir")+"/mdm_workbench_config.xml";
	private static String f = Platform.getInstanceLocation().getURL().getPath()+"/mdm_workbench_config.xml"; 

	private Collection<String> endpoints;

//	private Collection<String> universes;

	private Combo endpointsCombo=null;
	private Text userText=null;
	private Text passwordText=null;
	private Button savePasswordButton;
	private SelectionListener caller = null;
	private String title = "";

	private Combo universeCombo;
	private Group authenticationGroup;

	private Document logininfoDocument;
	private List<WSUniversePK> universes;


	/**
	 * @param parentShell
	 */
	public LoginDialog(SelectionListener caller, Shell parentShell, String title,List<WSUniversePK> universes) {
		super(parentShell);
		this.caller = caller;
		this.title = title;
		this.universes=universes;
		setDefaultImage(ImageCache.getCreatedImage(EImage.TALEND_PICTO.getPath()));
	}


	protected Control createDialogArea(Composite parent) {
		//this dialog is just used to crate a new server,so there is no need to initiate any information.
/*		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;

				try {
					builder = factory.newDocumentBuilder();
						logininfoDocument = builder.parse(new File(f));
					} catch (SAXException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ParserConfigurationException e) {
					e.printStackTrace();
				}*/
//					if(logininfoDocument!=null)
//					for (int i = 0; i < logininfoDocument.getChildNodes().getLength(); i++) {
//						logininfoDocument.getChildNodes().item(i)
//					}	
					
		endpoints = Arrays.asList(new String[]{Util.default_endpoint_address});
/*		try {
			properties.loadFromXML(new FileInputStream(f));
			if (properties.getProperty("url")!=null)	 
				endpoints=Arrays.asList(properties.getProperty("url").split(","));
		} catch (Exception e) {}

		universes = Arrays.asList(new String[]{""});
		try {
			properties.load(new FileInputStream(f));
			if (properties.getProperty("universes")!=null)	 
				universes=Arrays.asList(properties.getProperty("universes").split(","));
		} catch (Exception e) {}
		*/
		//Should not really be here but well,....
		parent.getShell().setText(this.title);
		
		Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		//layout.verticalSpacing = 10;
		
		Label endpointsLabel = new Label(composite, SWT.NONE);
		endpointsLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
		);
		endpointsLabel.setText("Server");

		endpointsCombo = new Combo(composite, SWT.NONE);
		endpointsCombo.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
		);
		((GridData)endpointsCombo.getLayoutData()).widthHint = 400;
		for (Iterator<String> iter = endpoints.iterator(); iter.hasNext(); ) {
			String host = iter.next();
			endpointsCombo.add(host);	
		}
		endpointsCombo.select(0);
		
		authenticationGroup=new Group(composite, SWT.NONE);
		authenticationGroup.setVisible(true);
		authenticationGroup.setText("Authentication");
		authenticationGroup.setLayoutData(
				new GridData(SWT.FILL,SWT.CENTER,true,false,2,1)
			);
		authenticationGroup.setLayout(new GridLayout(2,false));
		
		Label usernameLabel = new Label(authenticationGroup, SWT.NONE);
		usernameLabel.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,false,false,1,1)
		);
		usernameLabel.setText("Username");

		userText = new Text(authenticationGroup, SWT.BORDER);
		userText.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
		);
		userText.setDoubleClickEnabled(false);

		Label passwordLabel = new Label(authenticationGroup, SWT.NONE);
		passwordLabel.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,false,false,1,1)
		);
		passwordLabel.setText("Password");

		passwordText = new Text(authenticationGroup, SWT.PASSWORD|SWT.BORDER);
		passwordText.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
		);
		
		savePasswordButton = new Button(authenticationGroup, SWT.CHECK);
		savePasswordButton.setText("Save password");
		savePasswordButton.setLayoutData(
				new GridData(SWT.FILL,SWT.CENTER,true,false,2,1)
		);
//		Label warnLabel = new Label(authenticationGroup, SWT.CHECK);
//		warnLabel.setText("Save password");
//		warnLabel.setLayoutData(
//				new GridData(SWT.FILL,SWT.CENTER,true,false,2,1)
//		);
		
		//check Enterprise
		if(Util.IsEnterPrise()){
		//universe
		Label universeLabel = new Label(composite, SWT.NONE);
		universeLabel.setLayoutData(
			new GridData(SWT.FILL,SWT.CENTER,false,false,1,1)
		);
		universeLabel.setText("Version");
			universeCombo = new Combo(composite, SWT.NONE);
			universeCombo.setLayoutData(
				new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
			);
			((GridData)universeCombo.getLayoutData()).widthHint = 300;
			if(universes!=null){
	    		java.util.List<String> hostList=new ArrayList<String>();
			for (int i = 0; i < universes.size(); i++) {
				String host = universes.get(i).getPk();
				if (!hostList.contains(host)) {
					universeCombo.add(host);	
					hostList.add(host);
				}
				}
			}
//			universeCombo.select(0);
		}
	   return composite;
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).addSelectionListener(this.caller);
		/*
	       createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
	                true);
	        createButton(parent, IDialogConstants.CANCEL_ID,
	                IDialogConstants.CANCEL_LABEL, false);
	  */
	}
	
	protected void okPressed() {
		boolean isExist=false;
		//save hosts
/*			String currentHost = endpointsCombo.getText();
			String endpointsString = currentHost;
			int i =0;
			for (Iterator<String> iter = endpoints.iterator(); iter.hasNext(); ) {
				String endpoint = iter.next();
				if (! endpoint.equals(currentHost)) endpointsString+=","+endpoint;
				if (++i == 10) break;
			}*/
		
	    SAXReader reader = new SAXReader();
	    Element root =null;
	    if(new File(f).exists()){
	    	try {
				logininfoDocument = reader.read(new File(f));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    	root=logininfoDocument.getRootElement();
	    	isExist=checkServer(root);
	    }
	    else{
	    	logininfoDocument = DocumentHelper.createDocument();
	    	root=logininfoDocument.addElement("MDMServer");
	    }
	    
	    	if(!isExist)
	    		addServer(root);

	    	
	    	XMLWriter writer;
			try {
				writer = new XMLWriter(new FileWriter(f));
				writer.write(logininfoDocument);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
			
			
/*			properties.setProperty("endpoints", endpointsString);
			//save universe
			String currentUniverse = universeCombo.getText();
			String universeString = currentUniverse;
			i =0;
			for (Iterator<String> iter = universes.iterator(); iter.hasNext(); ) {
				String universe = iter.next();
				if (! universe.equals(currentUniverse)) universeString+=","+universe;
				if (++i == 5) break;
			}
			properties.setProperty("universes", universeString);
			if(savePasswordButton.getSelection()==true){
				properties.setProperty("user", usernameText.getText());
				properties.setProperty("password", passwordText.getText());
			}
		   FileOutputStream fos =
		        new FileOutputStream(f);
			properties.storeToXML(fos, null);
			fos.close();*/
		
		setReturnCode(OK);
		//no close let Action Handler handle it
	}
	
private boolean checkServer(Element root) {
	List properties = root.elements("properties");
	for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
		Element ele = (Element) iterator.next();
		if (ele.element("url").getText().equals(endpointsCombo.getText())
				&& ele.element("user").getText().equals(userText.getText())
				&& ele.element("password").getText().equals(passwordText.getText())
				&& ele.element("universe").getText().equals(
						universeCombo.getText()))
				return true;
	}
	return false;
	}


private void addServer(Element root) {
	Element prop = root.addElement("properties");
	
	Element url = prop.addElement("url");
	Element user = prop.addElement("user");
	Element password = prop.addElement("password");
	Element universe = prop.addElement("universe");

	url.setText(endpointsCombo.getText());
	user.setText(userText.getText());
	if(savePasswordButton.getSelection()==true)
		password.setText(PasswordUtil.encryptPassword(passwordText.getText()));
	else
		root.remove(prop);
	if(Util.IsEnterPrise())
		universe.setText(universeCombo.getText());		
	}


//	public Properties getProperties() {
//		return properties;
//	}


	public void saveUserTypes(){
		
	}
	

	public String getPasswordText() {
		return passwordText.getText().trim();
	}


	public String getUsernameText() {
		return userText.getText().trim();
	}
	
	public String getServer() {
		return endpointsCombo.getText().trim();
	}

	public String getUniverse() {
		if(Util.IsEnterPrise()){
			return universeCombo.getText().trim();
		}
		else{
			return "";
		}			
	}


}
