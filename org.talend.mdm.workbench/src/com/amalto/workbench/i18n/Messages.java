// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.i18n;

import org.eclipse.osgi.util.NLS;

/**
 * Default implementation of MessageCore from org.talend.commons plug-in.<br/>
 * 
 * Developpers can copy this class in their plug-in and change :
 * <ul>
 * <li>the BUNDLE_NAME constant</li>
 * </ul>
 * 
 * $Id: Messages.java 23594 2009-04-13 10:33:00Z nrousseau $
 * 
 */
public class Messages extends NLS {

    private static final String BUNDLE_NAME = "com.amalto.workbench.i18n.messages"; //$NON-NLS-1$
    
    public static String DeployOnMDMAction_DeployToMDM;

    public static String _AddCType;

    public static String _Error;

    public static String _UnkownSection;

    public static String _CreateCTypeError;

    public static String _PasteError;

    public static String SetDefaultValueRule;

    public static String DeleteDefaultValueRule;

    public static String modifiedChanges;

    public static String SaveResource;

    public static String UnableEditType;

    public static String ErrorDefaultValueRule;

    public static String XSDDefaultValueRuleAction_buildDefaultValue;

    public static String _CreateAComplexType;

    public static String _CreateAComplexTypeCanBeRefered;

    public static String _ChangeToSequenceType;

    public static String _ComplexTypeToSequence;

    public static String _ThisTypeHead;

    public static String _PleaseEnterCTypeName;

    public static String _AddStringElement;

    public static String _AddBusinessElementTip;

    public static String _AddTypeElement;

    public static String _AddANewBusinessElement;

    public static String _ErrorCreatBusinessElement;

    public static String _ErrorPasteEntity;

    public static String _TheBusinessElement;

    public static String _AddABusinessElementTop;

    public static String _AddFromTypeFirstPos;

    public static String SetForeignKeyFilter;

    public static String UnableEditAnnotationType;

    public static String ErrorFKFilter;

    public static String SetForeignKey;

    public static String ErrorForeignKey;

    public static String EnterXpathForeignKey;

    public static String SetForeignKeyInfos;

    public static String XSDSkipToFKAction_actionTitle;

    public static String XSDSkipToFKAction_NotFoundFkInfo;

    public static String SetVisibleRule;

    public static String DeleteVisibleRule;

    public static String ErrorSetVisibleRule;

    public static String XSDVisibleRuleAction_buildValidationRule;

    public static String EntityPKInfosSection_pkInfoTitle;

    public static String EntityPKInfosSection_pkInfoTooltips;

    public static String GenerateBrowseViews;

    public static String AddBrowseItemsWizard_Warning;

    public static String AddBrowseItemsWizard_DuplicatedView;

    public static String ErrorOccuredSaveView;

    public static String ConfigureBrowseViews;

    public static String ConfigureTheBrowseViews;

    public static String WarnningText;

    public static String NotContainEmpty;

    public static String NameStartWith;

    public static String BrowseNameExists;

    public static String RoleAccessDefinition;

    public static String ReadOnly;

    public static String ReadAndWrite;

    public static String FKInfos_resolve;

    public static String _ComplexTypeProp;

    public static String typeCannotExtendsItsself;

    public static String _NameWithEmptyCharacters;

    public static String _SameTypeNameExists;

    public static String ViewerWithModules;

    public static String _BasicInfo;

    public static String _BusinessName;

    public static String _MinOccur;

    public static String _MaxOccur;

    public static String _InheritStr;

    public static String _BusinessNameCannotEmpty;

    public static String _BusinessNameCannotContainEmpty;

    public static String _MinNoLessThanZero;

    public static String _MaxOccBeNum;

    public static String _BusinessEle;

    public static String _ThisType;

    public static String AddXsdFromlocal;

    public static String AddXsdSchemaFromlocal;

    public static String ImportXSDSchema;

    public static String AddTypesDataModels;

    public static String AddFromModelTypes;

    public static String SelectXSDSchemaWebSite;

    public static String ServerNotNull;

    public static String ImportFromExchangeServer;

    public static String ImportSchemaFromServer;

    public static String AddXsdFromOther;

    public static String AddFromOtherSite;

    public static String EnterTextUrl;

    public static String NameNotEmpty;

    public static String DeleteXsdModule;

    public static String DeleteText;

    public static String SchematronExpressBuilder_selectXPath;

    public static String SimpleXpathInputDialog_sepFkTabPanel;

    public static String DataClusterBrowser_dataContainerError;

    public static String DataClusterBrowser_connectionError;

    public static String DataClusterBrowser_error;

    public static String DescriptionText;

    public static String ImportXSDSche;

    public static String ImportingXSDSchemaCompleted;

    public static String Dueto;

    public static String ImportingXSDSchemaFailed;

    public static String XsdOmit2;

    public static String XsdOmit1;

    public static String XsdOmit3;

    public static String XsdOmit4;

    public static String XsdOmit5;

    public static String XsdRefresh;

    public static String DataModelEntities;

    public static String SelectDeletableTry;

    public static String DataModelTypes;

    public static String ErrorCommittingPage;

    public static String DataModelText;

    public static String PasteEntityText;

    public static String PasteEntitiesText;

    public static String PasteElementsText;

    public static String PasteElement;

    public static String CopyEntityText;

    public static String _AddElement;

    public static String _AddElementAfter;

    public static String CopyElementText;

    public static String CopyEntitiesText;

    public static String CopyElements;

    public static String ConfirmText;

    public static String DoIncludeImportSchema;

    public static String XSDDuplicateName;

    public static String ComplexText;

    public static String SimpleText;

    public static String FilterText;

    public static String ExpandText;

    public static String CollapseText;

    public static String ExpandModelGroup;

    public static String UPText;

    public static String DownText;

    public static String SortDescText;

    public static String HideElementsText;

    public static String SortAscText;

    public static String ShowElementsText;

    public static String SavingText;

    public static String ImportText;

    public static String ExportText;

    public static String ImportIncludeSchema;

    public static String XsdSchemaInferred;

    public static String NoElementNode;

    public static String SelectXMLDefinition;

    public static String ExportXSD;

    public static String OperationExportingXsd;

    public static String FailedExportXSD;

    public static String SaveDataModuleXSDSchema;

    public static String triggerLabel;

    public static String descriptionLabel;

    public static String entityLabel;

    public static String entitySelectLabel;

    public static String executesynLabel;

    public static String deactivateLabel;

    public static String helpLabel;

    public static String serviceJndiLabel;

    public static String serviceLabel;

    public static String serviceDetailLabel;

    public static String serviceParamLabel;

    public static String documentionLabel;

    public static String errorSaveTitleLabel;

    public static String errorSaveMsgLabel;

    public static String errorCommitLabel;

    public static String triggerExpressionLabel;

    public static String selectEntityLabel;

    public static String errorMsgLabel;

    public static String errorMsgLabelX;

    public static String errorCommitLabelX;

    public static String TransformerMainPage_warning;

    public static String TransformerMainPage_message;

    public static String ExportItemsWizard_overridefile;

    public static String ExportItemsWizard_overridefolder;

    public static String RegisterWizard_windowTitle;

    public static String RegisterWizardDialog_ok_button;

    public static String RegisterWizardPage_description;

    public static String RegisterWizardPage_title;

    public static String RegisterWizardPage_WizardPage;

    public static String RegisterWizardPage_email;

    public static String RegisterWizardPage_country;

    public static String RegisterWizardPage_emailEmpty;

    public static String RegisterWizardPage_emailNotValid;

    public static String RegisterWizardPage_legalinfos;

    public static String RegisterWizardPage_proxyGroup;

    public static String RegisterWizardPage_enableHttpProxy;

    public static String RegisterWizardPage_httpProxyHost;

    public static String RegisterWizardPage_httpProxyPort;

    public static String RegisterWizardPage_invalidPort;

    public static String GlobalServiceRegister_ServiceNotRegistered;

    public static String AddText;

    public static String AddMultiple;

    public static String DeleteSelectedItem;

    public static String DeleteAllItems;

    public static String MoveUpSelectedItem;

    public static String MovedownSelectedItem;

    public static String CopySelectedItems;

    public static String PasteSelectedItem;

    public static String SelectMultipleXPaths;

    public static String BuildValidationRuleExpression;

    // //////////////////////////////////////////////////////////////////////////
    //
    // Constructor
    //
    // //////////////////////////////////////////////////////////////////////////
    private Messages() {
        // do not instantiate
    }

    public static String bind(String message, String... bindings) {
        return NLS.bind(message, bindings);
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
