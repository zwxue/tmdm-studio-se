package org.talend.mdm.repository.ui.starting.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.ui.actions.datamodel.NewDataModelAction;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;


public class AddDataModelLinkAction extends AbstractShowViewAction implements IIntroAction {

    private static Logger log = Logger.getLogger(AddDataModelLinkAction.class);
    
    public void run(IIntroSite arg0, Properties arg1) {
        try {
            MDMRepositoryView findView = showRepositoryView();
            
            CommonViewer commonViewer = findView.getCommonViewer();
            
            IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects(IServerObjectRepositoryType.TYPE_DATAMODEL);
            if(categoryViewObjects.length > 0) 
            {
                NewDataModelAction addAction = new NewDataModelAction();
                addAction.initCommonViewer(commonViewer);
                addAction.setParentItem((ContainerItem) categoryViewObjects[0].getProperty().getItem());
                addAction.run();
            }
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }
        

    }

}
