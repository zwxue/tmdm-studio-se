package com.amalto.workbench.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PartInitException;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.CheckboxRepositoryTreeViewer;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;


/**
 * @author achen
 * DOC achen class global comment. Detailled comment
 */
public class UniverseVersionTreeViewer {

    private FilteredCheckboxTree filteredCheckboxTree;

    private CheckboxRepositoryView exportItemsTreeViewer;

    private ServerView repositoryView = ServerView.show();

    Collection<TreeObject> repositoryNodes = new ArrayList<TreeObject>();

    private IStructuredSelection selection;

    private SashForm sash;

    private Button moveButton;

	private TreeParent serverRoot;

    public UniverseVersionTreeViewer(IStructuredSelection selection) {
        this.selection = selection;
        serverRoot=  (TreeParent)selection.getFirstElement();
    }

    public SashForm createContents(Composite parent) {
        // Splitter
        final GridData data = new GridData();
        data.heightHint = 400;
        data.widthHint = 680;
        sash = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
        sash.setLayoutData(data);

        GridLayout layout = new GridLayout();
        layout.marginLeft=0;
        layout.marginRight=0;        
        sash.setLayout(layout);
        // create tree
        createItemList(sash);
        // create button
        Composite buttonComposite = new Composite(sash, SWT.ERROR);
        layout = new GridLayout();
        layout.marginLeft=0;
        layout.marginRight=0;         
        buttonComposite.setLayout(layout);

        moveButton = new Button(buttonComposite, SWT.PUSH);
        moveButton.setText(">>"); //$NON-NLS-1$
        moveButton.setToolTipText("Show server tree"); //$NON-NLS-1$

        final GridData layoutData = new GridData();
        layoutData.verticalAlignment = GridData.CENTER;
        layoutData.horizontalAlignment = GridData.CENTER;
        layoutData.grabExcessHorizontalSpace = true;
        layoutData.grabExcessVerticalSpace = true;
        layoutData.widthHint = 30;        
        moveButton.setLayoutData(layoutData);
        
        //create version composite
        Composite versionComposite = new Composite(sash, SWT.NONE);
        layout=new GridLayout();
        layout.marginLeft=0;
        layout.marginRight=0;
        versionComposite.setLayout(layout);
        VersionTagWidget vwidget=new VersionTagWidget(versionComposite,"");
        
        
        sash.setWeights(new int[] { 0, 1, 23 });
        // add listner
        moveButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                if (moveButton.getText().equals("<<")) { //$NON-NLS-1$
                    sash.setWeights(new int[] { 0, 2, 23 });
                    moveButton.setText(">>"); //$NON-NLS-1$
                   
                } else if (moveButton.getText().equals(">>")) { //$NON-NLS-1$
                    sash.setWeights(new int[] { 20, 2, 21 });
                    moveButton.setText("<<"); //$NON-NLS-1$                    
                }
            }
        });

        return sash;
    }
    
    /**
     * 
     * @param workArea
     */
    public Composite createItemList(Composite workArea) {
        Group itemComposite = new Group(workArea, 0);
        GridLayoutFactory.swtDefaults().numColumns(2).applyTo(itemComposite);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(400, 200).applyTo(itemComposite);

        Label label = new Label(itemComposite, SWT.NONE);
        label.setText("Select Items");
        GridDataFactory.swtDefaults().span(2, 1).applyTo(label);

        createTreeViewer(itemComposite);

        createSelectionButton(itemComposite);

        // force loading all nodes
        TreeViewer viewer = exportItemsTreeViewer.getViewer();


        // if user has select some items in repository view, mark them as checked
        if (!selection.isEmpty()) {        	       	
            repositoryNodes.addAll(Util.getChildrenObj(serverRoot));
            ((CheckboxTreeViewer) viewer).setCheckedElements(repositoryNodes.toArray());         
        }
        return itemComposite;
    }

    
    private void expandParent(TreeViewer viewer, TreeObject node) {
        TreeParent parent = node.getParent();
        if (parent != null) {
            expandParent(viewer, parent);
            viewer.setExpandedState(parent, true);
        }
    }

    public TreeObject[] getCheckNodes() {
        CheckboxTreeViewer viewer = (CheckboxTreeViewer) exportItemsTreeViewer.getViewer();
        List<TreeObject> ret = new ArrayList<TreeObject>();
        for (int i = 0; i < viewer.getCheckedElements().length; i++) {
        	TreeObject node = (TreeObject) viewer.getCheckedElements()[i];
            if (node.isXObject()) {
                ret.add(node);
            }
        }
        return (TreeObject[]) ret.toArray(new TreeObject[0]);
    }

    private void createTreeViewer(Composite itemComposite) {
        filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI) {

            @Override
            protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                exportItemsTreeViewer = new CheckboxRepositoryView();
                try {
                    exportItemsTreeViewer.init(repositoryView.getViewSite());
                } catch (PartInitException e) {
                     e.printStackTrace();
                }
                exportItemsTreeViewer.createPartControl(parent);
                ServerTreeContentProvider contentProvider=new ServerTreeContentProvider(repositoryView.getSite(),
                		serverRoot);
                exportItemsTreeViewer.getViewer().setContentProvider(contentProvider);
                exportItemsTreeViewer.getViewer().setLabelProvider(new ServerTreeLabelProvider());
                exportItemsTreeViewer.getViewer().setInput(repositoryView.getSite());
                return (CheckboxTreeViewer) exportItemsTreeViewer.getViewer();
            }

            @Override
            protected void refreshCompleted() {
                getViewer().expandToLevel(3);
                restoreCheckedElements();
            }

            @Override
            protected boolean isNodeCollectable(TreeItem item) {
//                Object obj = item.getData();
//                if (obj instanceof RepositoryNode) {
//                    RepositoryNode node = (RepositoryNode) obj;
//                    if (node.getObjectType() == ERepositoryObjectType.METADATA_CONNECTIONS) {
//                        return true;
//                    }
//                }
                return false;
            }
        };
        exportItemsTreeViewer.getViewer().addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
            	TreeObject node = (TreeObject) element;
                return filterRepositoryNode(node);
            }
        });
    }

    public void addCheckStateListener(ICheckStateListener listener) {
        ((CheckboxTreeViewer) exportItemsTreeViewer.getViewer()).addCheckStateListener(listener);
    }

    public void removeCheckStateListener(ICheckStateListener listener) {
        ((CheckboxTreeViewer) exportItemsTreeViewer.getViewer()).removeCheckStateListener(listener);
    }

    private boolean filterRepositoryNode(TreeObject node) {
        if (node == null) {
            return false;
        }
        if(node.getType() == TreeObject.SUBSCRIPTION_ENGINE || node.getType() == TreeObject.SERVICE_CONFIGURATION){
        	return false;
        }

        return true;
    }

    /**
     * DOC hcw Comment method "createSelectionButton".
     * 
     * @param itemComposite
     */
    private void createSelectionButton(Composite itemComposite) {
        Composite buttonComposite = new Composite(itemComposite, SWT.NONE);
        GridLayoutFactory.swtDefaults().margins(0, 25).applyTo(buttonComposite);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(buttonComposite);
        buttonComposite.setLayout(new RowLayout(SWT.VERTICAL));

        Button hide = new Button(buttonComposite, SWT.PUSH);
        hide.setVisible(false);
        Button selectAll = new Button(buttonComposite, SWT.PUSH);
        selectAll.setText("Select All");
        selectAll.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ((CheckboxTreeViewer) exportItemsTreeViewer.getViewer()).setAllChecked(true);
            }
        });

        Button deselectAll = new Button(buttonComposite, SWT.PUSH);
        deselectAll.setText("Deselect all");
        deselectAll.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ((CheckboxTreeViewer) exportItemsTreeViewer.getViewer()).setAllChecked(false);
            }
        });

        // setButtonLayoutData(deselectAll);

        Button expandBtn = new Button(buttonComposite, SWT.PUSH);
        expandBtn.setText("Expand All"); //$NON-NLS-1$
        expandBtn.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                exportItemsTreeViewer.getViewer().expandAll();
            }
        });
        // setButtonLayoutData(expandBtn);

        Button collapseBtn = new Button(buttonComposite, SWT.PUSH);
        collapseBtn.setText("Collapse All"); //$NON-NLS-1$
        collapseBtn.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                exportItemsTreeViewer.getViewer().collapseAll();
            }
        });
        // setButtonLayoutData(collapseBtn);
    }

    /**
     * 
     * A repository view with checkbox on the left.
     */
    class CheckboxRepositoryView extends ServerView {

      
        protected TreeViewer createTreeViewer(Composite parent) {
            return new CheckboxRepositoryTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.talend.repository.ui.views.RepositoryView#createPartControl(org.eclipse.swt.widgets.Composite)
         */
        @Override
        public void createPartControl(Composite parent) {
            super.createPartControl(parent);
            
        }

    }
}
