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
package org.talend.mdm.repository.core.service.wsimpl.servicedoc;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class CallTransformerGetDocument extends AbstractGetDocument {

    private static final String Param_Transformer_Name = "process";
    /**
     * DOC hbhong CallTransformerGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public CallTransformerGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getJNDIName() {
        return "callprocess"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        if ("fr".matches(twoLettersLanguageCode.toLowerCase()))
            return "Service qui appelle des processus";

        return "The service call process";
    }

    @Override
    public String getDocument() {
        return "This service takes a single parameter: \n" + "process: the name of the process. \n\n"
                + "The process should expect to receive the content of the Item sent to the process in the DEFAULT variable \n"
                + "with a content-type of text/xml. \n\n" + "Example: " + Param_Transformer_Name + "=tiscall_test";
    }

}
