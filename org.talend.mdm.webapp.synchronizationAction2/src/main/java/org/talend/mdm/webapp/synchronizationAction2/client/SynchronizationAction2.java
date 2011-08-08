package org.talend.mdm.webapp.synchronizationAction2.client;

import org.talend.mdm.webapp.synchronizationAction2.client.widget.SynchronizationActionPanel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class SynchronizationAction2 implements EntryPoint  {       
    
    public static String SYNCHRONIZTIONACTION_SERVICE = "synchronizationActionService"; //$NON-NLS-1$
    
    public void onModuleLoad() {           
        
        Registry.register(SYNCHRONIZTIONACTION_SERVICE, GWT.create(SynchronizationActionService.class));
        ContentPanel container = new SynchronizationActionPanel(); 
        RootPanel.get().add(container);
    }
}
