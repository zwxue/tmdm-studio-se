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
package org.talend.mdm.repository.ui.actions.view;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.TreePath;
import org.talend.commons.exception.BusinessException;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;
import org.talend.mdm.repository.core.impl.view.IViewNodeConstDef;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.ui.actions.MDMEditPropertyAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.RepositoryTransformUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

public class MDMEditViewProcessPropertyAction extends MDMEditPropertyAction {

    private static Logger log = Logger.getLogger(MDMEditViewProcessPropertyAction.class);

    private String oldProcessName;

    private IRepositoryViewObject parent;

    @Override
    protected void doRun() {
        Object object = getSelectedObject().get(0);
        if (object instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) object;
            parent = ContainerCacheService.getParent(viewObj);
            oldProcessName = viewObj.getProperty().getLabel();
        }

        super.doRun();

        if (viewObject != null) {
            moveViewOrProcess();
        }
    }

    private void moveViewOrProcess() {
        String path = getNewPath();

        if (path != null) {
            moveToOtherTypeNode(viewObject, path);
        }
    }

    private String getNewPath() {
        String path = null;

        Item item = viewObject.getProperty().getItem();
        String label = item.getProperty().getLabel();

        ERepositoryObjectType type = viewObject.getRepositoryObjectType();

        if (type == IServerObjectRepositoryType.TYPE_VIEW) {
            int labelType = RepositoryTransformUtil.getInstance().getViewType(label);
            int oldProcessType = RepositoryTransformUtil.getInstance().getViewType(oldProcessName);
            if (labelType == IViewNodeConstDef.TYPE_WEBFILTER && oldProcessType != IViewNodeConstDef.TYPE_WEBFILTER) {
                path = IPath.SEPARATOR + IViewNodeConstDef.PATH_WEBFILTER;
            } else if (labelType != IViewNodeConstDef.TYPE_WEBFILTER && oldProcessType == IViewNodeConstDef.TYPE_WEBFILTER) {
                path = IPath.SEPARATOR + IViewNodeConstDef.PATH_SEARCHFILTER;
            }
        } else if (type == IServerObjectRepositoryType.TYPE_TRANSFORMERV2) {
            int labelType = RepositoryTransformUtil.getInstance().getProcessType(label);
            int oldProcessType = RepositoryTransformUtil.getInstance().getProcessType(oldProcessName);
            if (labelType == ITransformerV2NodeConsDef.TYPE_BEFORESAVE) {
                if (oldProcessType != ITransformerV2NodeConsDef.TYPE_BEFORESAVE) {
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFORESAVE;
                }
            } else if (labelType == ITransformerV2NodeConsDef.TYPE_BEFOREDEL) {
                if (oldProcessType != ITransformerV2NodeConsDef.TYPE_BEFOREDEL) {
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFOREDEL;
                }
            } else if (labelType == ITransformerV2NodeConsDef.TYPE_ENTITYACTION) {
                if (oldProcessType != ITransformerV2NodeConsDef.TYPE_ENTITYACTION) {
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_ENTITYACTION;
                }
            } else if (labelType == ITransformerV2NodeConsDef.TYPE_WELCOMEACTION) {
                if (oldProcessType != ITransformerV2NodeConsDef.TYPE_WELCOMEACTION) {
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_WELCOMEACTION;
                }
            } else if (labelType == ITransformerV2NodeConsDef.TYPE_SMARTVIEW) {
                if (oldProcessType != ITransformerV2NodeConsDef.TYPE_SMARTVIEW) {
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW;
                }
            } else {
                switch (oldProcessType) {
                case ITransformerV2NodeConsDef.TYPE_BEFORESAVE:
                case ITransformerV2NodeConsDef.TYPE_BEFOREDEL:
                case ITransformerV2NodeConsDef.TYPE_ENTITYACTION:
                case ITransformerV2NodeConsDef.TYPE_WELCOMEACTION:
                case ITransformerV2NodeConsDef.TYPE_SMARTVIEW:
                    path = IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_OTHER;
                }
            }
        }

        return path;
    }

    private void moveToOtherTypeNode(IRepositoryViewObject viewObj, String path) {
        MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();
        item.getState().setPath(path);

        waitSomeTime(viewObj);

        IProxyRepositoryFactory factory = getFactory();
        try {
            if (factory.isEditableAndLockIfPossible(item)) {
                IPath ipath = new Path(path);
                factory.moveObject(viewObj, ipath);

                TreePath[] expandedTreePaths = commonViewer.getExpandedTreePaths();

                IRepositoryViewObject iRepositoryViewObject = ContainerCacheService.get(viewObj.getRepositoryObjectType(), item
                        .getState().getPath());
                commonViewer.refresh(iRepositoryViewObject);

                String parentPath = parent.getPath();
                int index = parentPath.indexOf("/"); //$NON-NLS-1$
                if (index != -1) {
                    parentPath = parentPath.substring(0, index);
                }

                IRepositoryViewObject iRepositoryViewObject2 = ContainerCacheService.get(viewObj.getRepositoryObjectType(),
                        parentPath);
                commonViewer.refresh(iRepositoryViewObject2);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        } catch (BusinessException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                factory.unlock(item);
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            } catch (LoginException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void waitSomeTime(IRepositoryViewObject viewObj) {
        boolean lockedViewObject = RepositoryResourceUtil.isLockedViewObject(viewObj);
        System.out.println(lockedViewObject);

        if (lockedViewObject) {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private IProxyRepositoryFactory getFactory() {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        return factory;
    }

}
