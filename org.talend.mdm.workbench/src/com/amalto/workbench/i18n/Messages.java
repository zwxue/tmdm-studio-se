package com.amalto.workbench.i18n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "com.amalto.workbench.i18n.messages"; //$NON-NLS-1$

    public static String deactivateLabel;

    public static String descriptionLabel;

    public static String documentionLabel;

    public static String entityLabel;

    public static String entitySelectLabel;

    public static String errorCommitLabel;

    public static String errorMsgLabel;

    public static String errorSaveMsgLabel;

    public static String errorSaveTitleLabel;

    public static String executesynLabel;

    public static String helpLabel;

    public static String selectEntityLabel;

    public static String serviceDetailLabel;

    public static String serviceJndiLabel;

    public static String serviceLabel;

    public static String serviceParamLabel;

    public static String triggerExpressionLabel;

    public static String triggerLabel;
    
    
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
