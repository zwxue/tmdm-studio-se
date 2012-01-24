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
package org.talend.mdm.repository.core.service.wsimpl.transformplugin;


/**
 * DOC hbhong class global comment. Detailled comment
 */
public class TISCallJobPluginDetail extends AbstractPluginDetail {

    /**
     * DOC hbhong ProjectPluginDetail constructor comment.
     * 
     * @param twoLetterLanguageCode
     */
    public TISCallJobPluginDetail(String twoLetterLanguageCode) {
        super(twoLetterLanguageCode);
    }

    private static final String INPUT_TEXT = "text"; //$NON-NLS-1$

    private static final String OUTPUT_TEXT = "result"; //$NON-NLS-1$

    protected String[] getInputVarNames() {
        return new String[] { INPUT_TEXT };
    }

    protected String[] getOutputVarNames() {
        return new String[] { OUTPUT_TEXT };
    }

    public String getDescription() {
        if ("fr".matches(twoLettersLanguageCode.toLowerCase())) //$NON-NLS-1$
            return "Execute un call de TIS un texte et retourne le résultat"; //$NON-NLS-1$
        return "Executes a TIS Job on a text and returns the result"; //$NON-NLS-1$
    }

    public String getDocumentation() {
        return "The TIS Call plugin executes a Web Service call to TIS on a text\n" + "\n" + "\n" + "Parameters\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                + "   url [mandatory]: the webservice port URL to the TIS Server" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "       or the local talend job URL: ltj://<jobName>/<jobVersion>/[jobMainClass]" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "   contextParam   : the contextParam of the tis job" + "\n" + "       name: the name of the context param" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                + "\n" + "       value: the value of context param, the value will be viewed as a priple" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                + "                   variable if the value is embraced with a brace, " + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "       isPipleVariableName [optional]: true to set contextParam value as one " + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "                                            piplevariableName , this parameter will be " + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "                                            ignored if value is embraced with brace" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "   username [optional]: the username to use for the call" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "   password [optional]: the password to  use for the call" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "   contentType [optional]: the contentType of the returned data. Defaults to 'text/xml'" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "   conceptMapping [optional]: Directly map the result of a TIS call to a MDM Entity" + "\n" //$NON-NLS-1$ //$NON-NLS-2$
                + "       concept: the name of the concept" + "\n" + "       fields: mapping rule with json format" + "\n" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "\n" + "Example1" + "\n" + "   <configuration>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "       <url>http://server:port/TISService/TISPort</url>" + "\n" + "       <contextParam>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                + "           <name>firstname</name>" + "\n" + "           <value>jack</value>" + "\n" + "       </contextParam>" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "\n" + "       <contextParam>" + "\n" + "           <name>lastname</name>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "           <value>jones</value>" + "\n" + "       </contextParam>" + "\n" + "       <contextParam>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                + "           <name>company</name>" + "\n" + "           <value>{pipleVariableName}</value>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                + "       </contextParam>" + "\n" + "       <username>john</username>" + "\n" + "       <password>doe</password>" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "\n" + "       <conceptMapping>" + "\n" + "           <concept>User</concept>" + "\n" + "           <fields>" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                + "\n" + "             {" + "\n" + "             p1:firstname," + "\n" + "             p2:lastname" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                + "             }" + "\n" + "           </fields>" + "\n" + "       </conceptMapping>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                + "   </configuration>" + "\n" + "\n" + "Example2" + "\n" + "   <configuration>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                + "       <url>ltj://tiscall_multi_return/0.1</url>" + "\n" + "       <contextParam>" + "\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                + "           <name>nb_line</name>" + "\n" + "           <value>5</value>" + "\n" + "       </contextParam>" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                + "\n" + "   </configuration>" + "\n" + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }

    public String getParametersSchema() {
        return null;
    }

    public String getJNDIName() {
        return "callJob"; //$NON-NLS-1$
    }
}
