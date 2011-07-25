package org.talend.mdm.repository.i18n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.talend.mdm.repository.i18n.messages"; //$NON-NLS-1$

    public static String Common_inputName;

    public static String Common_nameCanNotBeEmpty;

    public static String Common_nameInvalid;

    public static String Common_nameIsUsed;

    public static String CreateFolderAction_createCategory;

    public static String CreateFolderAction_inputCategoryName;

    public static String CreateFolderAction_nameIsUsed;

    public static String CreateFolderAction_newCategory;

    public static String NewDataModelAction_newDataModel;

    public static String NewMenuAction_newMenu;

    public static String NewTriggerAction_newTrigger;

    public static String RemoveFromRepositoryAction_removeFromRepository;

    public static String RenameObjectAction_rename;

    public static String RepositoryViewFilterDialog_enableAllServerObject;

    public static String RepositoryViewFilterDialog_enableNameFilter;

    public static String RepositoryViewFilterDialog_enableServerObjFilter;

    public static String RepositoryViewFilterDialog_title;

    public static String XObjectEditor2_saving;

    public static String XSDEditor2_schemaDesign;

    public static String XSDEditor2_schemaSource;

    // //////////////////////////////////////////////////////////////////////////
    //
    // Constructor
    //
    // //////////////////////////////////////////////////////////////////////////
    private Messages() {
        // do not instantiate
    }

    public static String bind(String message, String... bindings) {
        return bind(message, bindings);
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
}
