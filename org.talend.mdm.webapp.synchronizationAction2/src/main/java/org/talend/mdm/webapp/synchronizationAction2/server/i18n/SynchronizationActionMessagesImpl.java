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

    public String label_system_info_group()
    {
        return MESSAGES.getMessage("LABEL_SYSTEM_INFO_GROUP");
    }
    
    public String label_server_url()
    {
        return MESSAGES.getMessage("LABEL_SERVER_URL");
    }

    public String label_user_name()
    {
        return MESSAGES.getMessage("LABEL_USER_NAME");
    }

    public String label_password()
    {
        return MESSAGES.getMessage("LABEL_PASSWORD");
    }

    public String label_synchronization_name()
    {
        return MESSAGES.getMessage("LABEL_SYNCHRONIZATION_NAME");
    }

    public String start_full_button()
    {
        return MESSAGES.getMessage("START_FULL_BUTTON");
    }

    public String start_different_button()
    {
        return MESSAGES.getMessage("START_DIFFERENT_BUTTON");
    }

    public String stop_button()
    {
        return MESSAGES.getMessage("STOP_BUTTON");
    }

    public String reset_button()
    {
        return MESSAGES.getMessage("RESET_BUTTON");
    }

    public String tooltip_start_synchronization()
    {
        return MESSAGES.getMessage("TOOLTIP_START_SYNCHRONIZATION");
    }
    
    public String tooltip_start_difference_synchronization()
    {
        return MESSAGES.getMessage("TOOLTIP_START_DIFFERENCE_SYNCHRONIZATION");
    }

    public String tooltip_stop_synchronization()
    {
        return MESSAGES.getMessage("TOOLTIP_STOP_SYNCHRONIZATION");
    }

    public String tooltip_reset_synchronization()
    {
        return MESSAGES.getMessage("TOOLTIP_RESET_SYNCHRONIZATION");
    }

    public String main_panel_title()
    {
        return MESSAGES.getMessage("MAIN_PANEL_TITLE");
    }    
}
