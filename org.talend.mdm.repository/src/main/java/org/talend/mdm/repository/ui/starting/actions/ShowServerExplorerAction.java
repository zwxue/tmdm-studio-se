package org.talend.mdm.repository.ui.starting.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

public class ShowServerExplorerAction extends AbstractShowViewAction implements IIntroAction {

    private static Logger log = Logger.getLogger(ShowServerExplorerAction.class);
    public void run(IIntroSite iintrosite, Properties properties) {
        try {
            showServerExplorer();
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }

    }

}
