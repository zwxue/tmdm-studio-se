package org.talend.mdm.repository.i18n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.talend.mdm.repository.i18n.messages"; //$NON-NLS-1$


    public static String AbstractDeployAction_deployMessage;


    public static String Common_inputName;

    public static String Common_nameCanNotBeEmpty;

    public static String Common_nameInvalid;

    public static String Common_nameIsUsed;

    public static String CopyAction_copy;

    public static String CreateFolderAction_createCategory;

    public static String CreateFolderAction_inputCategoryName;

    public static String CreateFolderAction_nameIsUsed;

    public static String CreateFolderAction_newCategory;


    public static String DataContainerInteractiveHandler_title;


    public static String DataModelInteractiveHandler_label;


    public static String DeployAllAction_label;


    public static String DeployAllDialog_deselectAll;


    public static String DeployAllDialog_label;

    public static String DeployAllDialog_label_selectserver;

    public static String DeployAllDialog_selectAll;


    public static String DeployToAction_deployTo;


    public static String DeployToLastServerAction_deployToLastServer;


    public static String DuplicateAction_duplicate;

    public static String NewCustomFormAction_title;


    public static String NewCustomFormDialog_selectEntity;


    public static String NewCustomFormDialog_selectEntityFromDataModel;


    public static String NewCustomFormDialog_selectOneEntity;


    public static String NewDataModelAction_newDataModel;

    public static String NewMenuAction_newMenu;

    public static String NewServiceConfigurationAction_newServiceConfiguration;

    public static String JobInteractiveHandler_label;


    public static String JobInteractiveHandler_skipToDeploy;


    public static String JobInteractiveHandler_sucessToDeploy;


    public static String JobInteractiveHandler_wizardTitle;


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


    public static String RoleInteractiveHandler_label;


    public static String RoutingRuleInteractiveHandler_label;


    public static String RoutingRuleMainPage2_selectEntity;


    public static String Common_Error;


    public static String StoredProcedureInteractiveHandler_label;


    public static String StoredProcedureMainPage2_noDataContainer;

    public static String XObjectEditor2_saving;


    public static String XObjectEditor2_unableOpenEditor;

    public static String XSDCreateAccessActionR_title;


    public static String XSDEditor2_schemaDesign;

    public static String XSDEditor2_schemaSource;

    public static String XSDSetAnnotationNoActionR_title;


    public static String XSDSetAnnotationRoles;


    public static String XSDSetAnnotationWriteActionR_title;


    public static String ImportServerObject;


    public static String ImportServerObjectAction_importServerObject;

    public static String Import_Objects;

    public static String ImportObjectAction_error;


    public static String ImportObjectAction_hasError;


    public static String ImportObjectAction_importRepositoryItem;


    public static String ImportObjectAction_label;


    public static String Confirm_Overwrite;

    public static String Confirm_Overwrite_Info;

    public static String CustomFormBaseInfoPage_inputName;


    public static String CustomFormBaseInfoPage_title;


    public static String CustomFormDiagramInfoPage_1column;


    public static String CustomFormDiagramInfoPage_2columns;


    public static String CustomFormDiagramInfoPage_3columns;


    public static String CustomFormDiagramInfoPage_elementStructure;


    public static String CustomFormDiagramInfoPage_layout;


    public static String CustomFormDiagramInfoPage_selectLayout;


    public static String CustomFormDiagramInfoPage_title;


    public static String ExportObjectAction_error;


    public static String ExportObjectAction_exportRepositoryItems;


    public static String ExportObjectAction_hasError;


    public static String ExportObjectAction_label;


    public static String MenuInteractiveHandler_label;


    public static String SelectItemsPage_Title;

    public static String Select_Server;

    public static String Version;


    public static String VersionInteractiveHandler_label;


    public static String ViewInteractiveHandler_label;

    public static String Select_Items_To_Imports;


    public static String ServiceConfigurationInteractiveHandler_label;


    public static String SynchronizationPlanInteractiveHandler_label;

    public static String Overwrite_Exists_Items;


    public static String TransformerInteractiveHandler_label;

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
