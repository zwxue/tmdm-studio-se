package com.amalto.workbench.widgets.composites;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.detailtabs.sections.providers.StringViewerSorter;
import com.amalto.workbench.providers.ListContentProvider;
import com.amalto.workbench.providers.ListStringLabelProvider;

public abstract class ComboListStringContentComposite extends ListStringContentsComposite {

    protected ComboViewer comboInfos;

    public ComboListStringContentComposite(Composite parent, int style, Object[] initParas) {
        super(parent, style, initParas);
    }

    @Override
    protected void createCandidateInfoUIArea(Composite parent) {

        comboInfos = new ComboViewer(this, SWT.READ_ONLY);
        comboInfos.getControl().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        comboInfos.setContentProvider(new ListContentProvider());
        comboInfos.setLabelProvider(new ListStringLabelProvider());
        comboInfos.setSorter(new StringViewerSorter());

    }

    @Override
    protected void initUIListeners() {
        initListenerForInfosCombo();
        super.initUIListeners();
    }

    protected void initListenerForInfosCombo() {

        comboInfos.getCombo().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {

                comboInfos.setInput(getAllInfosInCombo());
            }
        });
    }

    @Override
    protected boolean hasCandidateInfo() {
        return getSelectionFromInfoViewer(comboInfos) != null;
    }

    @Override
    protected String getCandidateInfo() {
        return getSelectionFromInfoViewer(comboInfos);
    }

    @Override
    protected void initCandidateInfoUIArea() {
        comboInfos.setSelection(null);
    }

    protected abstract String[] getAllInfosInCombo();
}
