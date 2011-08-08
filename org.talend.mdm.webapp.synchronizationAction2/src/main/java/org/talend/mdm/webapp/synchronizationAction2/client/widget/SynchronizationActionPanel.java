package org.talend.mdm.webapp.synchronizationAction2.client.widget;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationAction2;
import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionService;
import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionServiceAsync;
import org.talend.mdm.webapp.synchronizationAction2.shared.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class SynchronizationActionPanel extends ContentPanel {
    
    //private final SynchronizationActionServiceAsync service = (SynchronizationActionServiceAsync) Registry.get(SynchronizationAction2.SYNCHRONIZTIONACTION_SERVICE);
    private final SynchronizationActionServiceAsync service = GWT.create(SynchronizationActionService.class);
    private FormData formData = new FormData("-20"); 
    private VerticalPanel verticalPanel = new VerticalPanel();
    private TextField<String> serverUrl_TF = null;   
    private TextField<String> userName_TF = null;    
    private TextField<String> password_TF = null;
    private ComboBox<ItemBaseModel> synchronizationName_CB = null;
    
    public SynchronizationActionPanel() {
        super();
        this.setBodyBorder(false);
        this.setHeaderVisible(false);
        this.setLayout(new FitLayout());
        this.setWidth(800);
        this.setHeight(500);
        this.initComponent();
        
    }

    
    public SyncInfo getSyncInfo()
    {
        
        
        if (serverUrl_TF != null)
        {
            if ("".equals(serverUrl_TF.getValue()))
            {
                serverUrl_TF.focus();
                return null;
            }
     
        }
        if (userName_TF != null)
        {
            if ("".equals(userName_TF.getValue()))
            {
                userName_TF.focus();
                return null;
            }

        }
        if (password_TF != null)
        {
            if ("".equals(password_TF.getValue()))
            {
                password_TF.focus();
                return null;
            }  
        }
        
        SyncInfo syncInfo = new SyncInfo();
        syncInfo.setUsername(userName_TF.getValue());
        syncInfo.setPassword(password_TF.getValue());
        syncInfo.setServerURL(serverUrl_TF.getValue());
        return syncInfo;        
    }
    
    public void initSyncNames()
    {

    }
    
    public void initComponent() {       
        
        
        
//        SynchronizationActionMessages messages = GWT.create(SynchronizationActionMessages.class); 
//        MessagesFactory.setMessages(messages);       
        
        FormPanel synchronizationForm_FP = new FormPanel();  
        synchronizationForm_FP.setFrame(true);  
        synchronizationForm_FP.setHeading("Simple Form with FieldSets");  
        synchronizationForm_FP.setWidth(350);  
        synchronizationForm_FP.setLayout(new FlowLayout());  
      
        FieldSet fieldSet = new FieldSet();  
        fieldSet.setHeading("Remote system information");  
        fieldSet.setCheckboxToggle(false);        
      
        FormLayout layout = new FormLayout();  
        layout.setLabelWidth(75);  
        fieldSet.setLayout(layout);  
      
        serverUrl_TF = new TextField<String>();  
        serverUrl_TF.setFieldLabel("Server URL");  
        serverUrl_TF.setAllowBlank(false);  
        fieldSet.add(serverUrl_TF, formData);  
      
        userName_TF = new TextField<String>();  
        userName_TF.setFieldLabel("UserName");  
        fieldSet.add(userName_TF, formData);  
      
        password_TF = new TextField<String>();  
        password_TF.setFieldLabel("Password");  
        password_TF.addListener(Events.Blur,  new Listener<FieldEvent>(){

            public void handleEvent(FieldEvent be) {
                
                SyncInfo syncInfo = getSyncInfo();         
                if (syncInfo != null)
                {              
                    try {
                        service.getSyncNames(syncInfo,new AsyncCallback<List<ItemBaseModel>>() {

                            public void onFailure(Throwable caught) {
                                System.out.println(caught.getStackTrace());
                                System.out.println(caught.getMessage());
                                System.out.println(caught.getCause());
                                System.out.println("aaaaaaaaaaaa");
                            }

                            public void onSuccess(List<ItemBaseModel> result) {
                                
                                synchronizationName_CB = new ComboBox<ItemBaseModel>();  
                                synchronizationName_CB.setEmptyText("");  
                                synchronizationName_CB.setDisplayField("name");  
                                synchronizationName_CB.setWidth(150);  
                                System.out.println(result.size());
                                synchronizationName_CB.getStore().removeAll();  
                                synchronizationName_CB.getStore().add(result);
                                synchronizationName_CB.setTypeAhead(true);  
                                synchronizationName_CB.setTriggerAction(TriggerAction.ALL);  
                                
                            }
                        });
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
  
                }
            }
     
        });
        fieldSet.add(password_TF, formData);  
        

        
        Button startFull_BT = new Button("startFull");
        Button startDifferent_BT = new Button("startDifferent");
        Button stop_BT = new Button("stop_BT");
        Button reset_BT = new Button("reset_BT");
        
        startFull_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                System.out.println("vvvvvvvvv");
            }
        });
        
        startDifferent_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                //service.getSyncNames(info, callback)
                System.out.println("aaaaaaa");
            }
        });
        
        stop_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                //service.getSyncNames(info, callback)
                System.out.println("aaaaaaa");
            }
        });
        
        reset_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                //service.getSyncNames(info, callback)
                System.out.println("aaaaaaa");
            }
        });
        
        synchronizationForm_FP.add(fieldSet);
//        synchronizationForm_FP.add(synchronizationName_CB);
        synchronizationForm_FP.addButton(startFull_BT);
        synchronizationForm_FP.addButton(startDifferent_BT);
        synchronizationForm_FP.addButton(stop_BT);
        synchronizationForm_FP.addButton(reset_BT);
       
        verticalPanel.add(synchronizationForm_FP);       
        //RootPanel.get().add(verticalPanel);
        this.add(verticalPanel);    
    }

}
