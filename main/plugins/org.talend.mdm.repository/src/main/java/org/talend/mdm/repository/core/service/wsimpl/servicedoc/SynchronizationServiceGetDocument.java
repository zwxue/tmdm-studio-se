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
package org.talend.mdm.repository.core.service.wsimpl.servicedoc;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class SynchronizationServiceGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CopyOfCallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public SynchronizationServiceGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "synchronization"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        if ("fr".matches(twoLettersLanguageCode.toLowerCase()))
            return "This service execute specific synchronization plan";
        return "This service execute specific synchronization plan";
    }

    @Override
    public String getDocument() {
        return "Here are the example of parameters:\n\n" + "<synchronization-configuration>\n" + "   <planName>?</planName>\n"
                + "   <action>START_DIFFERENTIAL</action>\n" + "</synchronization-configuration>\n";
    }

}
