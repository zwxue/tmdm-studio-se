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
public class JdbcGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CopyOfCallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public JdbcGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "jdbc"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        if ("fr".matches(twoLettersLanguageCode.toLowerCase()))
            return "This service handle the basic functionality of jdbc";
        return "This service handle the basic functionality of jdbc";
    }

    @Override
    public String getDocument() {
        return "There are two type parameters\n\n"
                + "One(Example) :\n"
                + "driverClassName=com.mysql.jdbc.Driver&url=jdbc:mysql://localhost:3306/brick&username=root&password=null&transformer=item2actionform"
                + "\n\n\n"
                + "Two(Example) :\n"
                + "<parameters>\n"
                + "   <driverClassName>com.mysql.jdbc.Driver</driverClassName>\n"
                + "   <url>jdbc:mysql://localhost:3306/brick</url>\n"
                + "   <username>root</username>\n"
                + "   <password>null</password>\n"
                + "   <transformer>item2actionform</transformer>\n"
                + "</parameters>\n\n\n"
                + "Notice :\n"
                + "The transformer should expect to receive the content of the Item sent to the transformer in the DEFAULT variable \n"
                + "with a content-type of text/xml.\nThe transformer convert Item to an ActionContent Xml Form of JDBC Adpter.\n";

    }

}
