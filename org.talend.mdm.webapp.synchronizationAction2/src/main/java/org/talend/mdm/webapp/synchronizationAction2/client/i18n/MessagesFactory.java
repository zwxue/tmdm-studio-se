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
package org.talend.mdm.webapp.synchronizationAction2.client.i18n;

public class MessagesFactory {

    private static SynchronizationActionMessages MESSAGES;                   

    private MessagesFactory() {
    }

    public static synchronized void setMessages(SynchronizationActionMessages messages) {
        if (MESSAGES != null) {
            throw new IllegalStateException();
        }
        MESSAGES = messages;
    }

    public static synchronized SynchronizationActionMessages getMessages() {
        if (MESSAGES == null) {
            throw new IllegalStateException();
        }
        return MESSAGES;
    }
}
