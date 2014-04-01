// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
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
import org.eclipse.ui.views.markers.internal.MarkerGroup;
import org.eclipse.ui.views.markers.internal.TypeMarkerGroup;
import org.talend.mdm.repository.core.marker.IValidationMarker;
import org.talend.mdm.repository.ui.markers.IOpenMarkerHandler;
import org.talend.mdm.repository.ui.markers.OpenMarkerHandlerRegister;
import org.talend.mdm.repository.ui.markers.datamodel.ModelNameMarkerGroup;

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
                        Collection groups = ((ContentGeneratorDescriptor) descObj).getMarkerGroups();
                        if (!hasMarkerGroup(groups, ModelNameMarkerGroup.ID)) {
                            groups.add(new ModelNameMarkerGroup());
                        }
                        if (!hasMarkerGroup(groups, "org.eclipse.ui.ide.type")) { //$NON-NLS-1$
                            groups.add(new TypeMarkerGroup("Type")); //$NON-NLS-1$
                        }
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

    private boolean hasMarkerGroup(Collection groups, String id) {
        for (Object groupObj : groups) {
            if (((MarkerGroup) groupObj).getId().equals(id)) {
                return true;
            }
        }
        return false;
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
                        if (item.getId().equals("org.eclipse.ui.navigate.goToResource")) { //$NON-NLS-1$
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

            @Override
            protected void activate(ISelection selection) {
                final int currentMode = OpenStrategy.getOpenMethod();
                try {
                    OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK);
                    openSelectedMarkers(null);
                } finally {
                    OpenStrategy.setOpenMethod(currentMode);
                }
            }

            @Override
            protected void linkToEditor(ISelection selection) {
                // Not supported by this part
            }

            @Override
            protected void open(ISelection selection, boolean activate) {
                openSelectedMarkers(null);
            }
        };
    }

    public void openSelectedMarkers(Object param) {
        IMarker[] markers = getSelectedMarkers();
        IWorkbenchPage page = getSite().getPage();
        List<IOpenMarkerHandler> handlers = OpenMarkerHandlerRegister.getHandlers();

        for (IMarker marker : markers) {
            boolean canOpen = false;
            if (handlers != null) {
                for (IOpenMarkerHandler handler : handlers) {
                    canOpen = handler.canOpen(marker);
                    if (canOpen) {
                        handler.open(page, marker, param);
                        break;
                    }
                }
            }
            if (!canOpen) {
                openMarkerInEditor(marker, page);
            }
        }
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
