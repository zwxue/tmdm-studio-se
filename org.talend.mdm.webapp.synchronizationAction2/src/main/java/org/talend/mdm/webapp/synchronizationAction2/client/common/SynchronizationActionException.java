// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.webapp.synchronizationAction2.client.common;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SynchronizationActionException extends Exception implements IsSerializable {

    private static final long serialVersionUID = 6768217552371158260L;

    public SynchronizationActionException() {
        super();
    }

    public SynchronizationActionException(String message) {
        super(message);
    }
    
    public SynchronizationActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
