package org.talend.mdm.webapp.synchronizationAction2.client.common;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SynchronizationActionException extends Exception implements IsSerializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6768217552371158260L;

    public SynchronizationActionException() {  
        super();  
    }
    
    public SynchronizationActionException(String message) {  
        super(message);  
    }
    
    public Throwable getCause() {
        return super.getCause();
    }      

    public String getMessage() {
        return super.getMessage();
    }     

    public Throwable initCause(Throwable cause) {
         return super.initCause(cause); 
    } 
}
