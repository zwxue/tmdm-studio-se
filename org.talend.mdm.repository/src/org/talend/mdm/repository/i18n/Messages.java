package org.talend.mdm.repository.i18n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.talend.mdm.repository.i18n.messages"; //$NON-NLS-1$


    public static String Common_inputName;

    public static String Common_nameCanNotBeEmpty;

    public static String Common_nameInvalid;

    public static String Common_nameIsUsed;

    public static String CopyAction_copy;

    public static String CreateFolderAction_createCategory;

    public static String CreateFolderAction_inputCategoryName;

    public static String CreateFolderAction_nameIsUsed;

    public static String CreateFolderAction_newCategory;


    public static String DuplicateAction_duplicate;

    public static String NewDataModelAction_newDataModel;

    public static String NewMenuAction_newMenu;

    public static String JobProcesssOptionsDialogTitle_title;

    public static String JobProcesssDialogTiggerTitle_title;

    public static String NewTriggerAction_newTrigger;

    public static String NewDataContainerAction_newDataContainer;


    public static String NewProcessAction_newProcess;

    public static String NewViewAction_newView;

    public static String NewStoredProcedureAction_newStoredProcedure;

    public static String NewSynchronizationPlanAction_newSynchronizationPlan;

    public static String NewVersionAction_newVersion;

    public static String OpenObjectAction_open;

    public static String PasteAction_paste;

    public static String RefreshAction_Refresh;

    public static String RemoveFromRepositoryAction_removeFromRepository;

    public static String RenameObjectAction_rename;

    public static String RepositoryDropAssistant_pasteObject;


    public static String RepositoryViewFilterDialog_enableAllServerObject;

    public static String RepositoryViewFilterDialog_enableNameFilter;

    public static String RepositoryViewFilterDialog_enableServerObjFilter;

    public static String RepositoryViewFilterDialog_title;


    public static String RepositoryWebServiceAdapter_InvalidEndpointAddress;


    public static String Common_Error;


    public static String StoredProcedureMainPage2_noDataContainer;

    public static String XObjectEditor2_saving;


    public static String XObjectEditor2_unableOpenEditor;

    public static String XSDEditor2_schemaDesign;

    public static String XSDEditor2_schemaSource;

    public static String ImportServerObject;
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
