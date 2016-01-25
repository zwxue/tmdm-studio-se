// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.views;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.PopupMenuExtender;
import org.eclipse.ui.internal.views.markers.ExtendedMarkersView;
import org.eclipse.ui.internal.views.markers.MarkerContentGenerator;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.views.markers.MarkerSupportView;
import org.eclipse.ui.views.markers.internal.ContentGeneratorDescriptor;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.marker.IValidationMarker;
import org.talend.mdm.repository.core.validate.datamodel.model.IDataModelMarkerConst;
import org.talend.mdm.repository.core.validate.datamodel.validator.impl.DataModelChecker;
import org.talend.mdm.repository.ui.actions.OpenObjectAction;
import org.talend.mdm.repository.ui.markers.datamodel.ModelNameMarkerGroup;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * created by HHB on 2013-1-5 Detailled comment
 * 
 */
public class MDMProblemView extends MarkerSupportView implements IValidationMarker {

    static Logger log = Logger.getLogger(MDMProblemView.class);

    private static final String GENERATOR_ID = "org.talend.mdm.problemsGenerator"; //$NON-NLS-1$

    public static final String VIEW_ID = "org.talend.mdm.repository.ui.views.MDMProblemView"; //$NON-NLS-1$

    /**
     * DOC HHB MDMProblemView constructor comment.
     * 
     * @param contentGeneratorId
     */
    public MDMProblemView() {
        super(GENERATOR_ID);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.internal.views.markers.ExtendedMarkersView#init(org.eclipse.ui.IViewSite,
     * org.eclipse.ui.IMemento)
     */
    @Override
    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);
        IMenuService menuService = (IMenuService) site.getService(IMenuService.class);

        hookModelGroup();
    }

    /**
     * DOC HHB Comment method "hookModelGroup".
     */
    private void hookModelGroup() {

        try {
            Field generatorField = ExtendedMarkersView.class.getDeclaredField("generator"); //$NON-NLS-1$
            Field descField = MarkerContentGenerator.class.getDeclaredField("generatorDescriptor"); //$NON-NLS-1$
            if (generatorField != null && descField != null) {
                generatorField.setAccessible(true);
                descField.setAccessible(true);
                Object object = generatorField.get(this);
                if (object != null) {
                    Object descObj = descField.get(object);
                    if (descObj != null) {
                        ((ContentGeneratorDescriptor) descObj).getMarkerGroups().add(new ModelNameMarkerGroup());
                    }
                }
            }

        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }

    }

    private TreeViewer getTreeViewer() {
        try {
            Field viewerField = ExtendedMarkersView.class.getDeclaredField("viewer"); //$NON-NLS-1$
            if (viewerField != null) {
                viewerField.setAccessible(true);
                return (TreeViewer) viewerField.get(this);
            }
        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private void uninstallViewListener(TreeViewer treeViewer) {

        if (treeViewer != null) {
            Object listener = findListener(treeViewer);
            if (listener != null) {
                treeViewer.removePostSelectionChangedListener((ISelectionChangedListener) listener);
                treeViewer.removeDoubleClickListener((IDoubleClickListener) listener);
                treeViewer.removeOpenListener((IOpenListener) listener);
            }
            //

        }

    }

    private void removeGotoCmd() {
        PopupMenuExtender popupMenuExtender = getPopupMenuExtender();
        if (popupMenuExtender != null) {
            final MenuManager manager = popupMenuExtender.getManager();
            manager.addMenuListener(new IMenuListener() {

                @Override
                public void menuAboutToShow(IMenuManager manager) {
                    for (IContributionItem item : manager.getItems()) {
                        if (item.getId().equals("org.eclipse.ui.navigate.goToResource")) {
                            manager.remove(item);
                            break;
                        }
                    }

                }
            });

        }
    }

    private PopupMenuExtender getPopupMenuExtender() {
        try {
            Field menuListField = PartSite.class.getDeclaredField("menuExtenders"); //$NON-NLS-1$
            if (menuListField != null) {
                menuListField.setAccessible(true);
                List list = (List) menuListField.get(getSite());
                for (Object obj : list) {
                    if (obj instanceof PopupMenuExtender) {
                        return (PopupMenuExtender) obj;
                    }

                }
            }
        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return null;

    }

    private void addLinkWithEditorSupport(TreeViewer viewer) {
        new OpenAndLinkWithEditorHelper(viewer) {

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.ui.OpenAndLinkWithEditorHelper#activate(org.eclipse .jface.viewers.ISelection )
             */
            @Override
            protected void activate(ISelection selection) {
                final int currentMode = OpenStrategy.getOpenMethod();
                try {
                    OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK);
                    openSelectedMarkers(false);
                } finally {
                    OpenStrategy.setOpenMethod(currentMode);
                }
            }

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.ui.OpenAndLinkWithEditorHelper#linkToEditor(org.eclipse .jface.viewers .ISelection)
             */
            @Override
            protected void linkToEditor(ISelection selection) {
                // Not supported by this part
            }

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.ui.OpenAndLinkWithEditorHelper#open(org.eclipse.jface .viewers.ISelection, boolean)
             */
            @Override
            protected void open(ISelection selection, boolean activate) {
                openSelectedMarkers(false);
            }
        };
    }

    public void openSelectedMarkers(boolean openInSrc) {
        IMarker[] markers = getSelectedMarkers();
        for (IMarker marker : markers) {
            IWorkbenchPage page = getSite().getPage();
            try {
                IResource resource = marker.getResource();
                String type = marker.getType();
                if (type.equals(MARKER_XSD_ERR)) {
                    if (resource != null) {
                        String dataModelName = DataModelChecker.getDataModelName(resource.getName());
                        openDataModel(dataModelName, marker);
                    }
                } else if (type.equals(MARKER_DATA_MODEL)) {

                    String modelName = (String) marker.getAttribute(IDataModelMarkerConst.DATA_MODEL);
                    if (modelName != null && resource != null) {
                        if (openInSrc) {
                            marker.setAttribute(IDataModelMarkerConst.OPEN_IN_SOURCE, true);
                        }
                        openDataModel(modelName, marker);
                    }
                } else {
                    openMarkerInEditor(marker, page);
                }

            } catch (CoreException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void openDataModel(String modelName, IMarker marker) {
        IRepositoryViewObject viewObj = RepositoryResourceUtil.findViewObjectByName(IServerObjectRepositoryType.TYPE_DATAMODEL,
                modelName);
        OpenObjectAction openAction = new OpenObjectAction();

        openAction.openMarker(viewObj, marker);

    }

    private Object findListener(TreeViewer treeViewer) {
        try {
            Field doubleListenersField = StructuredViewer.class.getDeclaredField("doubleClickListeners"); //$NON-NLS-1$
            if (doubleListenersField != null) {
                doubleListenersField.setAccessible(true);
                ListenerList list = (ListenerList) doubleListenersField.get(treeViewer);
                for (Object listenerObj : list.getListeners()) {
                    if (listenerObj.getClass().getEnclosingClass() == OpenAndLinkWithEditorHelper.class) {
                        return listenerObj;
                    }
                }
            }
        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.internal.views.markers.ExtendedMarkersView#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        TreeViewer treeViewer = getTreeViewer();
        uninstallViewListener(treeViewer);
        removeGotoCmd();
        addLinkWithEditorSupport(treeViewer);
    }

}
