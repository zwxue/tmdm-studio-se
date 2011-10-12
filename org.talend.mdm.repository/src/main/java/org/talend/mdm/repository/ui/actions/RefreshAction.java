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
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryViewGlobalActionHandler;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RefreshAction extends AbstractRepositoryAction {

    /**
     * DOC hbhong RefreshAction constructor comment.
     * 
     * @param text
     */
    public RefreshAction() {
        super(Messages.RefreshAction_Refresh);
        setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        this.setId(IRepositoryViewGlobalActionHandler.REFRESH);
        this.setActionDefinitionId(IRepositoryViewGlobalActionHandler.REFRESH);
    }

    @Override
    public void run() {
        // ProgressDialog progressDialog = new ProgressDialog(getShell(), 1000) {
        //
        // private IProgressMonitor monitorWrap;
        //
        // @Override
        // public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        //                Timer timer = Timer.getTimer("repositoryView"); //$NON-NLS-1$
        // timer.start();
        // monitorWrap = new EventLoopProgressMonitor(monitor);
        // try {
        // final ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
        // factory.initialize();
        // } catch (Exception e) {
        // throw new InvocationTargetException(e);
        // }
        // timer.stop();
        // timer.print();
        // }
        // };
        //
        // try {
        // progressDialog.executeProcess();
        // } catch (InvocationTargetException e) {
        // ExceptionHandler.process(e);
        // return;
        // } catch (Exception e) {
        // MessageBoxExceptionHandler.process(e);
        // return;
        // }
        RepositoryResourceUtil.initialize();

        List<Object> selectedObject = getSelectedObject();
        if (!selectedObject.isEmpty()) {
            Object obj = selectedObject.get(0);
            commonViewer.refresh(obj);

            Item item = ((IRepositoryViewObject) obj).getProperty().getItem();
            if (item instanceof ContainerItem) {
                commonViewer.expandToLevel(obj, 1);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        return GROUP_COMMON;
    }

}
