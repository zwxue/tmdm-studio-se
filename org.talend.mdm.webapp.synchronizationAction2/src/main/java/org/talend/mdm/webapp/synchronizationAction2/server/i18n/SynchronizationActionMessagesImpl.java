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
package org.talend.mdm.webapp.synchronizationAction2.server.i18n;

import org.talend.mdm.webapp.synchronizationAction2.client.i18n.SynchronizationActionMessages;

import com.amalto.core.util.Messages;
import com.amalto.core.util.MessagesFactory;

@SuppressWarnings("nls")
public final class SynchronizationActionMessagesImpl implements SynchronizationActionMessages {

    private static final Messages MESSAGES = MessagesFactory.getMessages(
            "org.talend.mdm.webapp.synchronizationAction2.client.i18n.SynchronizationActionMessages",
            SynchronizationActionMessagesImpl.class.getClassLoader());
    
    public String label_system_info_group() {
        return MESSAGES.getMessage("LABEL_SYSTEM_INFO_GROUP");
    }

    public String label_server_url() {
        return MESSAGES.getMessage("LABEL_SERVER_URL");
    }

    public String label_user_name() {
        return MESSAGES.getMessage("LABEL_USER_NAME");
    }

    public String label_password() {
        return MESSAGES.getMessage("LABEL_PASSWORD");
    }

    public String label_synchronization_name() {
        return MESSAGES.getMessage("LABEL_SYNCHRONIZATION_NAME");
    }

    public String label_remote_system() {
        return MESSAGES.getMessage("label_remote_system");
    }

    public String button_start_full() {
        // TODO Auto-generated method stub
        return null;
    }

    public String button_start_different() {
        // TODO Auto-generated method stub
        return null;
    }

    public String button_stop() {
        // TODO Auto-generated method stub
        return null;
    }

    public String button_reset() {
        // TODO Auto-generated method stub
        return null;
    }
}
