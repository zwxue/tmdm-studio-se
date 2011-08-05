package org.talend.mdm.webapp.synchronization2.client;

import org.talend.mdm.webapp.synchronization2.client.widget.Synchronization2Panel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;


public class Synchronization2 implements EntryPoint  {

    public static final String SYNCHRONIZATION2_SERVICE = "Synchronization2Service"; //$NON-NLS-1$
    
    public void onModuleLoad() {
        
        Registry.register(SYNCHRONIZATION2_SERVICE, GWT.create(Synchronization2Service.class));
        
        ContentPanel container = new Synchronization2Panel();       
        RootPanel.get().add(container);
    }

}
