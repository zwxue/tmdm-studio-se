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
 * DOC hbhong class global comment. Detailled comment
 */
public class SmtpGetDocument extends AbstractGetDocument {

    /**
     * DOC hbhong CopyOfCallJobGetDocument constructor comment.
     * 
     * @param twoLettersLanguageCode
     */
    public SmtpGetDocument(String twoLettersLanguageCode) {
        super(twoLettersLanguageCode);
    }

    @Override
    public String getJNDIName() {
        return "smtp"; //$NON-NLS-1$
    }

    @Override
    public String getDescription() {
        return "This service sends an email through the SMTP connector.\n"
                + "It cantains the following configurations:\n"
                + "  host:         mandatory; the smtp server host name.\n"
                + "  port:         mandatory; the smtp server port.\n"
                + "  username:     mandatory; the smtp server username.\n"
                + "  password:     mandatory; the smtp server password.\n"
                + "  from:         mandatory; the email address of the sender.\n"
                + "  to:           mandatory; the email addresses of the recipients,separated by commas.\n"
                + "  permanentbcc: optional;  the permanent blind copied recipients.\n"
                + "  subjectprefix:optional;  a sentence inserted at the beginning of the subject line.\n"
                + "  logfilename:  optional;  the full path of a log file that records the mails sent.\n"
                + "  process:      optional;  an optional process.When no process is supplied,the item xml will be used as the body "
                + "of the mail.When a process is supplied,the following variables,including \'recipients\',\'subject\',\'body\'and \'contenttype\',will be extracted from the pipeline after the "
                + "process is run.";
    }

    @Override
    public String getDocument() {
        return "There are two type parameters,\n\n" + "One(Example) :\n"
                + "from=***@***.com&to=###@###.com&subjectprefix=MDM Logging Event" + "\n\n\n" + "Two(Example) :\n"
                + "<parameters>\n" + "  <from>***@***.com</from>\n" + " <to>###@###.com</to>\n" + " <cc></cc>\n"
                + " <bcc></bcc>\n" + "  <subjectprefix></subjectprefix>\n" + "  <logfilename></logfilename>\n"
                + " <process></process>\n" + "</parameters>\n";
    }

}
