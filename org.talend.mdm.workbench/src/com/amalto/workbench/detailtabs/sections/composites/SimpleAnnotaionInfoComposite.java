package com.amalto.workbench.detailtabs.sections.composites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import com.amalto.workbench.detailtabs.sections.providers.StringLabelProvider;
import com.amalto.workbench.detailtabs.sections.providers.StringViewerSorter;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.ListContentProvider;

public abstract class SimpleAnnotaionInfoComposite extends Composite {

    protected ComboViewer comboInfos;

    protected TreeViewer tvInfos;

    protected Button btnAdd;

    protected Button btnUp;

    protected Button btnDown;

    protected Button btnRemove;

    protected List<String> infos = new ArrayList<String>();

    public SimpleAnnotaionInfoComposite(Composite parent, int style) {
        super(parent, style);
        final GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        setLayout(gridLayout);

        comboInfos = new ComboViewer(this, SWT.READ_ONLY);
        comboInfos.getControl().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        comboInfos.setContentProvider(new ListContentProvider());
        comboInfos.setLabelProvider(new StringLabelProvider());
        comboInfos.setSorter(new StringViewerSorter());

        btnAdd = new Button(this, SWT.NONE);
        btnAdd.setImage(ImageCache.getCreatedImage(EImage.ADD_OBJ.getPath()));

        tvInfos = new TreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
        Tree tree = tvInfos.getTree();
        tree.setLinesVisible(true);
        tree.setHeaderVisible(true);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));

        tvInfos.setContentProvider(new ListContentProvider());
        tvInfos.setLabelProvider(new StringLabelProvider());
        tvInfos.setInput(infos);

        final TreeColumn colInfo = new TreeColumn(tree, SWT.NONE);
        colInfo.setWidth(350);
        colInfo.setText(getInfoColTitle());

        btnUp = new Button(this, SWT.NONE);
        btnUp.setImage(ImageCache.getCreatedImage(EImage.PREV_NAV.getPath()));
        btnUp.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));

        btnDown = new Button(this, SWT.NONE);
        btnDown.setImage(ImageCache.getCreatedImage(EImage.NEXT_NAV.getPath()));
        final GridData gd_btnDown = new GridData(SWT.CENTER, SWT.TOP, false, false);
        btnDown.setLayoutData(gd_btnDown);

        btnRemove = new Button(this, SWT.NONE);
        btnRemove.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
        btnRemove.setImage(ImageCache.getCreatedImage(EImage.DELETE_OBJ.getPath()));
        //

        extentUI(parent);

        initUIListeners();
    }

    protected void initUIListeners() {

        initListenerForInfosCombo();

        initListenerForAddBtn();

        initListenerForRemoveBtn();

        initListenerForUpBtn();

        initListenerForDownBtn();
    }

    protected void initListenerForInfosCombo() {

        comboInfos.getCombo().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {

                comboInfos.setInput(getAllInfosInCombo());
            }
        });
    }

    protected void initListenerForAddBtn() {

        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                onAdd();
            }
        });

    }

    protected void initListenerForRemoveBtn() {

        btnRemove.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                onRemove();
            }
        });

    }

    protected void initListenerForUpBtn() {

        btnUp.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                onMoveUp();
            }

        });

    }

    protected void initListenerForDownBtn() {

        btnDown.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                onMoveDown();
            }
        });

    }

    protected void onAdd() {

        if (!hasSelectionInInfoCombo() || infos.contains(getSelectionFromInfoCombo()))
            return;

        addInfoToInfoTree(getSelectionFromInfoCombo());
    }

    protected void onRemove() {

        if (!hasSelectionInInfoTree())
            return;

        removeInfoFromInfoTree(getSelectionFromInfoTree());
    }

    protected void onMoveUp() {

        if (!hasSelectionInInfoTree())
            return;

        moveInfoUp(getSelectionFromInfoTree());
    }

    protected void onMoveDown() {

        if (!hasSelectionInInfoTree())
            return;

        moveInfoDown(getSelectionFromInfoTree());
    }

    public String[] getAnnotaionInfos() {
        return infos.toArray(new String[0]);
    }

    private void addInfoToInfoTree(String info) {
        infos.add(info);

        tvInfos.refresh();
    }

    private void removeInfoFromInfoTree(String info) {
        infos.remove(info);

        tvInfos.refresh();
    }

    private boolean hasSelectionInInfoCombo() {
        return getSelectionFromInfoCombo() != null;
    }

    private boolean hasSelectionInInfoTree() {
        return getSelectionFromInfoTree() != null;
    }

    private String getSelectionFromInfoCombo() {
        return getSelectionFromInfoViewer(comboInfos);
    }

    private String getSelectionFromInfoTree() {
        return getSelectionFromInfoViewer(tvInfos);
    }

    private String getSelectionFromInfoViewer(Viewer targetViewer) {

        Object selectedObj = ((IStructuredSelection) targetViewer.getSelection()).getFirstElement();

        if (selectedObj == null)
            return null;

        return selectedObj.toString();
    }

    private void moveInfoUp(String info) {
        doMoveInfo(info, (infos.indexOf(info) - 1) < 0 ? 0 : (infos.indexOf(info) - 1));
    }

    private void moveInfoDown(String info) {
        doMoveInfo(info, (infos.indexOf(info) == infos.size() - 1) ? (infos.size() - 1) : (infos.indexOf(info) + 1));
    }

    private void doMoveInfo(String info, int newIndex) {
        infos.remove(info);
        infos.add(newIndex, info);
        tvInfos.refresh();
    }

    public void setAnnotaionInfos(String[] annotationInfos) {

        initInfoCombo();

        initInfoTrees(annotationInfos);
    }

    private void initInfoCombo() {
        comboInfos.setSelection(null);
    }

    private void initInfoTrees(String[] annotationInfos) {

        infos.clear();

        for (String eachInfo : annotationInfos) {
            infos.add(eachInfo);
        }

        tvInfos.refresh();
    }

    protected abstract String getInfoColTitle();

    protected abstract String[] getAllInfosInCombo();

    protected abstract void extentUI(Composite parent);
}
