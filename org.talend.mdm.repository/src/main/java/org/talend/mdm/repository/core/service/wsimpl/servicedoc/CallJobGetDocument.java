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
 * DOC hbhong  class global comment. Detailled comment
 */
public class CallJobGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public CallJobGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "callJob"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        return "The service call job"; //$NON-NLS-1$
    }

    @Override
    public String getDocument() {
        return "CallJob Service\n"
                + "\n"
                + "Parameters\n"
                + "   url [mandatory]: the webservice port URL to the TIS Server"
                + "\n"
                + "       or the local talend job URL: ltj://<jobName>/<jobVersion>/[jobMainClass]"
                + "\n"
                + "   contextParam   : the contextParam of the tis job"
                + "\n"
                + "       name: the name of the context param"
                + "\n"
                + "       value: the value of context param, the value will be viewed as a priple"
                + "\n"
                + "              variable if the value is embraced with a brace, its content will be like: "
                + "\n"
                + "              <exchange><report>{update report here}</report><item>{item pointed to by Update/Key}</item></exchange>\n"
                + "   username [optional]: the username to use for the call" + "\n"
                + "   password [optional]: the password to  use for the call" + "\n"
                + "   contentType [optional]: the contentType of the returned data. Defaults to 'text/xml'" + "\n"
                + "   conceptMapping [optional]: Directly map the result of a TIS call to a MDM entity" + "\n"
                + "       concept: the name of the concept" + "\n" + "       fields: mapping rule with json format" + "\n" + "\n"
                + "Example1" + "\n" + "   <configuration>" + "\n" + "       <url>http://server:port/TISService/TISPort</url>"
                + "\n" + "       <contextParam>" + "\n" + "           <name>firstname</name>" + "\n"
                + "           <value>jack</value>" + "\n" + "       </contextParam>" + "\n" + "       <contextParam>" + "\n"
                + "           <name>lastname</name>" + "\n" + "           <value>jones</value>" + "\n" + "       </contextParam>"
                + "\n" + "       <contextParam>" + "\n" + "           <name>xmlInput</name>" + "\n"
                + "           <value>{}</value>" + "\n" + "       </contextParam>" + "\n" + "       <username>john</username>"
                + "\n" + "       <password>doe</password>" + "\n" + "       <conceptMapping>" + "\n"
                + "           <concept>User</concept>" + "\n" + "           <fields>" + "\n" + "             {" + "\n"
                + "             p1:firstname," + "\n" + "             p2:lastname" + "\n" + "             }" + "\n"
                + "           </fields>" + "\n" + "       </conceptMapping>" + "\n" + "   </configuration>" + "\n" + "Example2"
                + "\n" + "   <configuration>" + "\n" + "       <url>ltj://tiscall_multi_return/0.1</url>" + "\n"
                + "       <contextParam>" + "\n" + "           <name>nb_line</name>" + "\n" + "           <value>5</value>"
                + "\n" + "       </contextParam>" + "\n" + "   </configuration>" + "\n" + "\n";
    }

}
