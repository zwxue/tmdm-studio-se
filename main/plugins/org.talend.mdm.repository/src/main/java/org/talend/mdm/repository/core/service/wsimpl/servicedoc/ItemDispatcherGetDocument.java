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
public class ItemDispatcherGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CopyOfCallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public ItemDispatcherGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "itemdispatcher"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        return "This service dispatch an item to target systems automatically, according to the DataModel annotation.";
    }

    @Override
    public String getDocument() {
        return "There are two cases of using parameters,\n\n" + "One(Example) :\n" + "<parameters>\n" + "   <transformer>\n"
                + "     <!-- OPTIONAL DEFAULT 'true'-->\n" + "     <allInOne>true</allInOne>\n"
                + "     <assignTo>transformer1</assignTo>\n" + "   </transformer>\n" + "</parameters>\n" + "Two(Example) :\n"
                + "<parameters>\n" + "   <transformer>\n" + "     <allInOne>false</allInOne>\n" + "     <assignTo>\n"
                + "             {\n" + "             0:transformer1," + "\n" + "             1:transformer2" + "\n"
                + "             }\n" + "     </assignTo>\n" + "   </transformer>\n" + "</parameters>\n";
    }

}
