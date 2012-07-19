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
package org.talend.mdm.repository.ui.starting.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;


public class ShowRepositoryViewAction extends AbstractShowViewAction implements IIntroAction {

    private static Logger log = Logger.getLogger(ShowRepositoryViewAction.class);
    @Override
    public void run(IIntroSite arg0, Properties arg1) {
        try {
            showRepositoryView();
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }

    }

}
