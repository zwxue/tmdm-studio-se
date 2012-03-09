package org.talend.mdm.workbench.serverexplorer.i18n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.talend.mdm.workbench.serverexplorer.i18n.messages"; //$NON-NLS-1$

    // //////////////////////////////////////////////////////////////////////////
    //
    // Constructor
    //
    // //////////////////////////////////////////////////////////////////////////
    private Messages() {
        // do not instantiate
    }

    // //////////////////////////////////////////////////////////////////////////
    //
    // Class initialization
    //
    // //////////////////////////////////////////////////////////////////////////
    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    public static String bind(String message, String... bindings) {
        return bind(message, bindings);
    }

    public static String SelectServerDefDialog_selectServerLocation;

    public static String ServerDefDialog_AddServer;

    public static String ServerDefDialog_Authentication;

    public static String ServerDefDialog_CheckConnection;

    public static String ServerDefDialog_ConnectFailed;

    public static String ServerDefDialog_ConnectSuccessful;

    public static String ServerDefDialog_Name;

    public static String ServerDefDialog_NameCanNotBeEmpty;

    public static String ServerDefDialog_Password;

    public static String ServerDefDialog_PasswordCanNotBeEmpty;

    public static String ServerDefDialog_SameName;

    public static String ServerDefDialog_Server;

    public static String ServerDefDialog_ServerCanNotBeEmpty;

    public static String ServerDefDialog_ServerInvalid;

    public static String ServerDefDialog_UpdateServer;

    public static String ServerDefDialog_UserName;

    public static String ServerDefDialog_UsernameCanNotBeEmpty;

    public static String ServerDefDialog_Version;

    public static String ServerExplorer_AddServer;

    public static String ServerExplorer_CheckConnection;

    public static String ServerExplorer_ConnectFailed;

    public static String ServerExplorer_ConnectSuccessful;

    public static String ServerExplorer_EditServer;

    public static String ServerExplorer_RemoveConfirm;

    public static String ServerExplorer_RemoveServer;

    public static String ServerExplorer_EventManager;

    public static String ServerExplorer_WarningText;

    public static String Reinput_Password;

    public static String SharePassword;

    public static String OnlyApplicableShared;

}
