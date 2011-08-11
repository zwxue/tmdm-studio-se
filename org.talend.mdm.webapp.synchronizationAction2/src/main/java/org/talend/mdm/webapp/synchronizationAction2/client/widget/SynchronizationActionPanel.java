package org.talend.mdm.webapp.synchronizationAction2.client.widget;

import java.util.List;

import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationAction2;
import org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationActionServiceAsync;
import org.talend.mdm.webapp.synchronizationAction2.client.i18n.MessagesFactory;
import org.talend.mdm.webapp.synchronizationAction2.client.model.ItemBaseModel;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncInfo;
import org.talend.mdm.webapp.synchronizationAction2.shared.SyncStatus;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SynchronizationActionPanel extends ContentPanel {

     private final SynchronizationActionServiceAsync service = (SynchronizationActionServiceAsync)
     Registry.get(SynchronizationAction2.SYNCHRONIZTIONACTION_SERVICE);

    private ComboBox<ItemBaseModel> serverUrl_CB;

    private TextField<String> userName_TF;

    private TextField<String> password_TF;

    private ComboBox<ItemBaseModel> synchronizationName_CB;

    private Label message_LB;

    private Button startFull_BT;

    private Button startDifferent_BT;

    private Button stop_BT;

    private Button reset_BT;

    private SyncStatus syncStatus;

    private StringBuffer urlString;

    public SynchronizationActionPanel() {
        super();
        this.setBodyBorder(false);
        this.setHeaderVisible(false);
        this.setLayout(new FitLayout());
        this.setWidth(800);
        this.setHeight(500);
        this.initPanel();

    }

    public SyncInfo getSyncInfo() {
        if (serverUrl_CB != null) {            
            if ("".equals(serverUrl_CB.getRawValue()) || serverUrl_CB.getRawValue() == null) { //$NON-NLS-1$
                serverUrl_CB.focus();
                return null;
            }
        }

        if (userName_TF != null) {
            if ("".equals(userName_TF.getValue()) || userName_TF.getValue() == null) { //$NON-NLS-1$
                userName_TF.focus();
                return null;
            }
        }

        if (password_TF != null) {
            if ("".equals(password_TF.getValue()) || password_TF.getValue() == null) { //$NON-NLS-1$
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

    public void saveURLs() {
        if (urlString.indexOf(serverUrl_CB.getRawValue()) == -1) {
            urlString.append(serverUrl_CB.getRawValue() + ";"); //$NON-NLS-1$
        }
        service.saveURLs(urlString.substring(0, urlString.lastIndexOf(";")).toString(), new AsyncCallback<Void>() { //$NON-NLS-1$

            public void onSuccess(Void arg0) {

            }

            public void onFailure(Throwable caught) {
                MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
            }
        });
    }

    public void updateStatus(SyncStatus syncStatusAsync) {
        syncStatus = syncStatusAsync;
        message_LB.setText(syncStatus.getMessage());
        if ("RUNNING".equals(syncStatus.getValue()) || "SCHEDULED".equals(syncStatus.getValue())) { //$NON-NLS-1$//$NON-NLS-2$
            startFull_BT.disable();
            startDifferent_BT.disable();
            stop_BT.enable();
            reset_BT.disable();
        } else if ("STOPPING".equals(syncStatus.getValue())) { //$NON-NLS-1$
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

    public void refreshStatus(final SyncInfo syncInfo) {

        Timer refreshTimer = new Timer() {

            public void run() {
                service.getStatus(syncInfo, new AsyncCallback<SyncStatus>() {

                    public void onFailure(Throwable caught) {
                        MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                    }

                    public void onSuccess(SyncStatus syncStatusAsync) {
                        updateStatus(syncStatusAsync);
                    }
                });
                if (syncStatus != null) {
                    if (!("RUNNING" == syncStatus.getValue() || "SCHEDULED" == syncStatus.getValue())) {  //$NON-NLS-1$//$NON-NLS-2$
                        this.cancel();
                        updateStatus(syncStatus);
                    }
                }
            }
        };
        refreshTimer.scheduleRepeating(1000);
    }   
    
    public void initServerUrl(){
        serverUrl_CB = new ComboBox<ItemBaseModel>();
        serverUrl_CB.setFieldLabel(MessagesFactory.getMessages().label_server_url());
        serverUrl_CB.setWidth(400);
        serverUrl_CB.setStore(new ListStore<ItemBaseModel>());
        serverUrl_CB.setDisplayField("name"); //$NON-NLS-1$
        serverUrl_CB.setValueField("id"); //$NON-NLS-1$
        serverUrl_CB.setTypeAhead(true);
        serverUrl_CB.setTriggerAction(TriggerAction.ALL);
        service.getSavedURLs(new AsyncCallback<List<ItemBaseModel>>() {                   
      
          public void onFailure(Throwable caught) {
              MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
          }
    
          public void onSuccess(List<ItemBaseModel> result) {
              urlString = new StringBuffer();
              serverUrl_CB.getStore().removeAll();
              serverUrl_CB.getStore().add(result);
              for (int i = 0; i < result.size(); i++) {
                  urlString.append(result.get(i).get("id") + ";");  //$NON-NLS-1$//$NON-NLS-2$
              }
           }
        });
    }
    
    public void initUserName(){
        userName_TF = new TextField<String>();
        userName_TF.setFieldLabel(MessagesFactory.getMessages().label_user_name());
        userName_TF.setWidth(400);
    }
    
    public void initPassword(){
        password_TF = new TextField<String>();
        password_TF.setFieldLabel(MessagesFactory.getMessages().label_password());
        password_TF.setWidth(400);
        password_TF.addListener(Events.Blur, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent fieldEvent) {

                SyncInfo syncInfo = getSyncInfo();
                
                if (syncInfo != null) {

                    service.getSyncNames(syncInfo, new AsyncCallback<List<ItemBaseModel>>() {

                        public void onFailure(Throwable caught) {
                            MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                        }

                        public void onSuccess(List<ItemBaseModel> result) {
                            synchronizationName_CB.setEmptyText(MessagesFactory.getMessages().label_select_synchronization_name());    //$NON-NLS-1$
                            synchronizationName_CB.getStore().removeAll();
                            synchronizationName_CB.getStore().add(result);
                        }
                    });
                }
            }
        });        
    }    
    
    public void initSynchronizationName(){
        synchronizationName_CB = new ComboBox<ItemBaseModel>();
        synchronizationName_CB.setFieldLabel(MessagesFactory.getMessages().label_synchronization_name()); 
        synchronizationName_CB.setStore(new ListStore<ItemBaseModel>());
        synchronizationName_CB.setDisplayField("name"); //$NON-NLS-1$
        synchronizationName_CB.setValueField("id"); //$NON-NLS-1$
        synchronizationName_CB.setTypeAhead(true);
        synchronizationName_CB.setTriggerAction(TriggerAction.ALL);
    }
    
    public void initStartFull(){
        startFull_BT = new Button(MessagesFactory.getMessages().button_start_full());
        startDifferent_BT = new Button(MessagesFactory.getMessages().button_start_different());
        stop_BT = new Button(MessagesFactory.getMessages().button_stop());
        stop_BT.setEnabled(false);
        reset_BT = new Button(MessagesFactory.getMessages().button_reset());
        reset_BT.setEnabled(false);

        startFull_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final SyncInfo syncInfo = getSyncInfo();
                if (syncInfo != null) {
                    saveURLs();
                    service.startFull(syncInfo, new AsyncCallback<Void>() {

                        public void onSuccess(Void arg0) {
                            refreshStatus(syncInfo);
                        }

                        public void onFailure(Throwable caught) {
                            MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                        }
                    });
                }
            }
        });
    }
    
    public void initStartDifferent(){
        startDifferent_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final SyncInfo syncInfo = getSyncInfo();
                if (syncInfo != null) {
                    saveURLs();
                    service.startDifferent(syncInfo, new AsyncCallback<Void>() {

                        public void onSuccess(Void arg0) {
                            refreshStatus(syncInfo);
                        }

                        public void onFailure(Throwable caught) {
                            MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                        }
                    });
                }
            }
        });
    }
    
    public void initStop(){
        stop_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final SyncInfo syncInfo = getSyncInfo();
                service.stop(syncInfo, new AsyncCallback<Void>() {

                    public void onSuccess(Void arg0) {
                        refreshStatus(syncInfo);
                    }

                    public void onFailure(Throwable caught) {
                        MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                    }
                });
            }
        });
    }
    
    public void initReset(){
        reset_BT.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final SyncInfo syncInfo = getSyncInfo();

                service.reset(syncInfo, new AsyncCallback<Void>() {

                    public void onSuccess(Void arg0) {
                        refreshStatus(syncInfo);
                    }

                    public void onFailure(Throwable caught) {
                        MessageBox.alert("Error", caught.getMessage(), null); //$NON-NLS-1$
                    }
                });
            }
        });  
    }

    public void initPanel() {
        
        message_LB = new Label();
        initSynchronizationName();
        initServerUrl();
        initUserName();
        initPassword();
        initStartFull();
        initStartDifferent();
        initStop();
        initReset();
        
        FormData formData = new FormData("-20"); //$NON-NLS-1$

        VerticalPanel verticalPanel = new VerticalPanel();

        FormPanel synchronizationForm_FP = new FormPanel();
        synchronizationForm_FP.setFrame(true);
        synchronizationForm_FP.setHeaderVisible(false);
        synchronizationForm_FP.setLayout(new FlowLayout());
        synchronizationForm_FP.setBorders(false);
        synchronizationForm_FP.setBodyStyle("padding: 8px; background-color: transparent;"); //$NON-NLS-1$
        synchronizationForm_FP.setLabelAlign(LabelAlign.LEFT);
        synchronizationForm_FP.setLabelWidth(150);

        FieldSet synchronizationInfo_FS = new FieldSet();
        synchronizationInfo_FS.setHeading(MessagesFactory.getMessages().label_remote_system());
        synchronizationInfo_FS.setAutoHeight(true);

        FormLayout synchronizationInfo_FL = new FormLayout();
        synchronizationInfo_FL.setLabelWidth(75);
        synchronizationInfo_FS.setLayout(synchronizationInfo_FL);

        synchronizationInfo_FS.add(serverUrl_CB, formData);
        synchronizationInfo_FS.add(userName_TF, formData);
        synchronizationInfo_FS.add(password_TF, formData);       
        
        FieldSet synchronizationName_FS = new FieldSet();
        FormLayout synchronizationName_FL = new FormLayout();
        synchronizationName_FL.setLabelWidth(150);
        synchronizationName_FS.setLayout(synchronizationName_FL);    
        synchronizationName_FS.add(synchronizationName_CB);
        synchronizationName_FS.setBorders(false);
        synchronizationForm_FP.add(synchronizationInfo_FS);
        synchronizationForm_FP.add(synchronizationName_FS);        
        synchronizationForm_FP.add(message_LB);
        synchronizationForm_FP.addButton(startFull_BT);
        synchronizationForm_FP.addButton(startDifferent_BT);
        synchronizationForm_FP.addButton(stop_BT);
        synchronizationForm_FP.addButton(reset_BT);

        verticalPanel.add(synchronizationForm_FP);
        this.add(verticalPanel);
    }

}
