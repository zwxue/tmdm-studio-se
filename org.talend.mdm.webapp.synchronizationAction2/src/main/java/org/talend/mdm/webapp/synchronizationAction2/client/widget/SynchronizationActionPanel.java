package org.talend.mdm.webapp.synchronizationAction2.client.widget;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionService;
import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionServiceAsync;
import org.talend.mdm.webapp.synchronizationAction2.shared.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.ListRange;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SynchronizationActionPanel extends ContentPanel {

    // private final SynchronizationActionServiceAsync service = (SynchronizationActionServiceAsync)
    // Registry.get(SynchronizationAction2.SYNCHRONIZTIONACTION_SERVICE);
    private final SynchronizationActionServiceAsync service = (SynchronizationActionServiceAsync) GWT
            .create(SynchronizationActionService.class);

    private FormData formData = new FormData("-20");

    private VerticalPanel verticalPanel = new VerticalPanel();

    private ComboBox<ItemBaseModel> serverUrl_CB = null;

    private TextField<String> userName_TF = null;

    private TextField<String> password_TF = null;

    private ComboBox<ItemBaseModel> synchronizationName_CB = null;
    
    private Label message_LB = null;
    
    private Button startFull_BT = null;
    
    private Button startDifferent_BT = null;
    
    private Button stop_BT = null;
    
    private Button reset_BT = null;
    
    private SyncStatus syncStatus;
    
    public SynchronizationActionPanel() {
        super();
        this.setBodyBorder(false);
        this.setHeaderVisible(false);
        this.setLayout(new FitLayout());
        this.setWidth(800);
        this.setHeight(500);
        this.initComponent();

    }

    public SyncInfo getSyncInfo() {
        if (serverUrl_CB != null) {
            if ("".equals(serverUrl_CB.getValue())) {
                serverUrl_CB.focus();
                return null;
            }
        }
        
        if (userName_TF != null) {
            if ("".equals(userName_TF.getValue())) {
                userName_TF.focus();
                return null;
            }
        }
        
        if (password_TF != null) {
            if ("".equals(password_TF.getValue())) {
                password_TF.focus();
                return null;
            }
        }

        SyncInfo syncInfo = new SyncInfo();
        syncInfo.setUsername(userName_TF.getValue());
        syncInfo.setPassword(password_TF.getValue());
        syncInfo.setServerURL(serverUrl_CB.getRawValue());
        syncInfo.setSyncName(synchronizationName_CB.getRawValue());
        return syncInfo;
    }
    
    public void saveURLs(){
        StringBuffer urlString = new StringBuffer();
        ListStore<ItemBaseModel> urlStore = serverUrl_CB.getStore();
        for (int i=0;i<urlStore.getCount();i++)
        {
            ItemBaseModel itemBaseModel = urlStore.getAt(i);
            urlString.append(itemBaseModel.get("id") + ";");            
        }
        
        if (urlString.indexOf(serverUrl_CB.getRawValue()) == -1)
        {
            urlString.append(serverUrl_CB.getRawValue() + ";");
        }
        System.out.println("aa " + urlString.substring(0, urlString.lastIndexOf(";")-1).toString());
        service.saveURLs(urlString.substring(0, urlString.lastIndexOf(";")-1).toString(), new AsyncCallback<Void>() {
            
            public void onSuccess(Void arg0) {

            }
            
            public void onFailure(Throwable caught) {
                caught.printStackTrace();               
            }
        });
    }

    public void updateStatus(SyncStatus syncStatusAsync){
        
        syncStatus = syncStatusAsync;
        
        message_LB.setText(syncStatus.getMessage());
        if("RUNNING" == syncStatus.getValue() || "SCHEDULED" == syncStatus.getValue()){            
            startFull_BT.disable();
            startDifferent_BT.disable();
            stop_BT.disable();
            reset_BT.disable();         
        }
        else if ("STOPPING" == syncStatus.getValue()) {
            startFull_BT.disable();
            startDifferent_BT.disable();
            stop_BT.disable();
            reset_BT.enable();           
        } else {
            startFull_BT.enable();
            startDifferent_BT.enable();
            stop_BT.disable();
            reset_BT.disable();         
        }
    }
    
    public void refreshStatus(final SyncInfo syncInfo){
        SyncStatus syncStatus2 = new SyncStatus();
        
        Timer refreshTimer = new Timer(){
            public void run() {
                service.getStatus(syncInfo, new AsyncCallback<SyncStatus>() {
                    public void onFailure(Throwable caught) {
                        caught.printStackTrace();
                    }

                    public void onSuccess(SyncStatus syncStatusAsync) {               
                        updateStatus(syncStatusAsync);               
                    }                   
               });
               if(syncStatus != null){
                    if(!("RUNNING" == syncStatus.getValue() || "SCHEDULED" == syncStatus.getValue())){
                        this.cancel();
                        updateStatus(syncStatus);
                    }
                } 
            }       
        };
        refreshTimer.schedule(1000);
    }
    

   

    public void initComponent() {

        // SynchronizationActionMessages messages = GWT.create(SynchronizationActionMessages.class);
        // MessagesFactory.setMessages(messages);

        FormPanel synchronizationForm_FP = new FormPanel();
        synchronizationForm_FP.setFrame(true);
        synchronizationForm_FP.setHeading("Simple Form with FieldSets");
        // synchronizationForm_FP.setWidth(350);
        synchronizationForm_FP.setLayout(new FlowLayout());
        synchronizationForm_FP.setBorders(false);
        synchronizationForm_FP.setBodyStyle("padding: 8px; background-color: transparent;");
        synchronizationForm_FP.setLabelAlign(LabelAlign.LEFT);
        synchronizationForm_FP.setLabelWidth(150);

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeading("Remote system information");
        fieldSet.setAutoHeight(true);

        FormLayout layout = new FormLayout();
        layout.setLabelWidth(75);
        fieldSet.setLayout(layout);
        
        synchronizationName_CB = new ComboBox<ItemBaseModel>();      
        synchronizationName_CB.setFieldLabel("Synchronization Name");        
        synchronizationName_CB.setStore(new ListStore());
//        synchronizationName_CB.setReadOnly(true);
        synchronizationName_CB.setDisplayField("name");
        synchronizationName_CB.setValueField("id");
        synchronizationName_CB.setTypeAhead(true);
        synchronizationName_CB.setTriggerAction(TriggerAction.ALL);

        serverUrl_CB = new ComboBox<ItemBaseModel>();
        serverUrl_CB.setFieldLabel("Server URL");
        //serverUrl_CB.setAllowBlank(false);
        serverUrl_CB.setWidth(400);
        serverUrl_CB.setStore(new ListStore());
        serverUrl_CB.setDisplayField("name"); //$NON-NLS-1$
        serverUrl_CB.setValueField("id"); //$NON-NLS-1$        

        service.getSavedURLs(new AsyncCallback<ListRange>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            public void onSuccess(ListRange result) {
                serverUrl_CB.getStore().removeAll();
                serverUrl_CB.getStore().add(result.getData());
            }            
        });

        fieldSet.add(serverUrl_CB, formData);

        userName_TF = new TextField<String>();
        userName_TF.setFieldLabel("UserName");
        userName_TF.setWidth(400);
        fieldSet.add(userName_TF, formData);

        password_TF = new TextField<String>();
        password_TF.setFieldLabel("Password");
        password_TF.setWidth(400);
        password_TF.addListener(Events.Blur, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {

                SyncInfo syncInfo = getSyncInfo();
                if (syncInfo != null) {
                    System.out.println(syncInfo.getServerURL());
               
                    service.getSyncNames(syncInfo, new AsyncCallback<List<ItemBaseModel>>() {

                        public void onFailure(Throwable caught) {
                            caught.printStackTrace();
                        }

                        public void onSuccess(List<ItemBaseModel> result) {            
                            synchronizationName_CB.setWidth(400);
                            synchronizationName_CB.setEmptyText("Select a Synchronization Name");   //$NON-NLS-1$
                            synchronizationName_CB.getStore().removeAll();
                            synchronizationName_CB.getStore().add(result);                           
                        }
                    });                   
                }
            }
        });
        
        fieldSet.add(password_TF, formData);  
        
        message_LB = new Label();
        
        startFull_BT = new Button("startFull");
        startDifferent_BT = new Button("startDifferent");
        stop_BT = new Button("stop_BT");
        stop_BT.setEnabled(false);
        reset_BT = new Button("reset_BT");
        reset_BT.setEnabled(false);

        startFull_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SyncInfo syncInfo = getSyncInfo();
                if (syncInfo != null)
                {
                    saveURLs();
                    System.out.println(syncInfo.getUsername());
                    System.out.println(syncInfo.getServerURL());
                    System.out.println(syncInfo.getSyncName());
                    service.startFull(syncInfo, new AsyncCallback<Void>() {
                        
                        public void onSuccess(Void arg0) {
                            MessageBox.alert("AAA", "BBB", null);
                        }
                        
                        public void onFailure(Throwable caught) {
                            caught.printStackTrace(); 
                        }
                    });
                }                
            }
        });

        startDifferent_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SyncInfo syncInfo = getSyncInfo();
                if (syncInfo != null)
                {
                    saveURLs();
                    service.startDifferent(syncInfo, new AsyncCallback<Void>() {
                        
                        public void onSuccess(Void arg0) {
                            MessageBox.alert("AAA", "BBB", null);
                        }
                        
                        public void onFailure(Throwable caught) {
                            caught.printStackTrace(); 
                        }
                    });
                }
             }
        });

        stop_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SyncInfo syncInfo = getSyncInfo();
                service.stop(syncInfo, new AsyncCallback<Void>() {
                    
                    public void onSuccess(Void arg0) {
                        MessageBox.alert("AAA", "BBB", null);
                    }
                    
                    public void onFailure(Throwable caught) {
                        caught.printStackTrace(); 
                    }
                });
            }
        });

        reset_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SyncInfo syncInfo = getSyncInfo();

                service.reset(syncInfo, new AsyncCallback<Void>() {
                    
                    public void onSuccess(Void arg0) {
                        MessageBox.alert("AAA", "BBB", null);
                    }
                    
                    public void onFailure(Throwable caught) {
                        caught.printStackTrace(); 
                    }
                });
            }
        });

        synchronizationForm_FP.add(fieldSet);
        synchronizationForm_FP.add(synchronizationName_CB);
        synchronizationForm_FP.add(message_LB);
        synchronizationForm_FP.addButton(startFull_BT);
        synchronizationForm_FP.addButton(startDifferent_BT);
        synchronizationForm_FP.addButton(stop_BT);
        synchronizationForm_FP.addButton(reset_BT);

        verticalPanel.add(synchronizationForm_FP);
        // RootPanel.get().add(verticalPanel);
        this.add(verticalPanel);
    }

}