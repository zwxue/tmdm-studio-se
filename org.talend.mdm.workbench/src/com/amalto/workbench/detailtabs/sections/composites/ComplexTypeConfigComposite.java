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
package com.amalto.workbench.detailtabs.sections.composites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.detailtabs.sections.providers.XSDNamedComponentLabelProvider;
import com.amalto.workbench.providers.ListContentProvider;
import com.amalto.workbench.providers.datamodel.SchemaElementSorter;
import com.amalto.workbench.utils.Util;

public class ComplexTypeConfigComposite extends Composite {

    private Text txtName;

    private ComboViewer comboExtends;

    private Button radGroupAll;

    private Button radGroupSequence;

    private Button radGroupChoice;

    private XSDComplexTypeDefinition complextType;

    public ComplexTypeConfigComposite(Composite parent, int style) {
        super(parent, style);
        final GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        setLayout(gridLayout);

        final Label lblName = new Label(this, SWT.NONE);
        lblName.setText("Name");

        txtName = new Text(this, SWT.BORDER);
        final GridData gd_txtName = new GridData(SWT.FILL, SWT.CENTER, true, false);
        txtName.setLayoutData(gd_txtName);

        final Label extensionLabel = new Label(this, SWT.NONE);
        extensionLabel.setText("Extends");

        comboExtends = new ComboViewer(this, SWT.READ_ONLY);
        comboExtends.setContentProvider(new ListContentProvider());
        comboExtends.setLabelProvider(new XSDNamedComponentLabelProvider());
        comboExtends.setSorter(new SchemaElementSorter());
        Combo combo = comboExtends.getCombo();
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        final Group gpGroup = new Group(this, SWT.NONE);
        gpGroup.setText("Sub-Elements Group");
        final GridData gd_gpGroup = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        gpGroup.setLayoutData(gd_gpGroup);
        gpGroup.setLayout(new GridLayout());

        radGroupAll = new Button(gpGroup, SWT.RADIO);
        radGroupAll.setSelection(true);
        radGroupAll.setText("All");//$NON-NLS-1$

        radGroupSequence = new Button(gpGroup, SWT.RADIO);
        radGroupSequence.setText("Sequence");//$NON-NLS-1$

        radGroupChoice = new Button(gpGroup, SWT.RADIO);
        radGroupChoice.setText("Choice");//$NON-NLS-1$

        initUIListener();
    }

    public void setComplexType(XSDComplexTypeDefinition complextType) {

        this.complextType = complextType;

        initUIContents();
    }

    private void initUIContents() {

        fillUIContentsInTxtName();

        initUIContentsInComboExtends();

        initUIContentsInGroup();

        refresh();
    }

    private void initUIContentsInGroup() {
        XSDParticle groupParticle = (XSDParticle) complextType.getContent();
        XSDModelGroup group = (XSDModelGroup) groupParticle.getContent();
        radGroupAll.setSelection(XSDCompositor.ALL_LITERAL.equals(group.getCompositor()));
        radGroupSequence.setSelection(XSDCompositor.SEQUENCE_LITERAL.equals(group.getCompositor()));
        radGroupChoice.setSelection(XSDCompositor.CHOICE_LITERAL.equals(group.getCompositor()));
    }

    private void fillUIContentsInTxtName() {
        txtName.setText(complextType.getName());
    }

    private void initUIContentsInComboExtends() {
        fillCandidatsInComboExtends();

        comboExtends.setSelection(new StructuredSelection(""));
        if (complextType.getBaseType() != null)
            comboExtends.setSelection(new StructuredSelection(complextType.getBaseType()));
    }

    private void fillCandidatsInComboExtends() {

        ISelection oldSection = comboExtends.getSelection();

        List<Object> allExtends = new ArrayList<Object>();
        for (XSDComplexTypeDefinition eachComplexType : Util.getComplexTypes(complextType.getSchema())) {

            if (eachComplexType.equals(complextType) || Util.isAllComplexType(eachComplexType))
                continue;

            if (Util.getParentTypes(eachComplexType).contains(complextType))
                continue;

            if (Util.isSequenceComplexType(eachComplexType) && !radGroupSequence.getSelection())
                continue;

            if (Util.isChoiceComplexType(eachComplexType) && !radGroupChoice.getSelection())
                continue;

            allExtends.add(eachComplexType);
        }
        allExtends.add(0, "");
        comboExtends.setInput(allExtends);
        comboExtends.setSelection(oldSection);
    }

    private void initUIListener() {

        initUIListenerForComboExtends();

        initUIListenerForRadGroupTypes();
    }

    private void initUIListenerForComboExtends() {

        comboExtends.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });

    }

    private void initUIListenerForRadGroupTypes() {

        SelectionAdapter radGroupTypeChangeListener = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                XSDComplexTypeDefinition curSelectedExtends = getExtends();

                if (isGroupAll())
                    comboExtends.setSelection(new StructuredSelection(""));

                if (isGroupSequence() && !Util.isSequenceComplexType(curSelectedExtends))
                    comboExtends.setSelection(new StructuredSelection(""));

                if (isGroupChoice() && !Util.isChoiceComplexType(curSelectedExtends))
                    comboExtends.setSelection(new StructuredSelection(""));

                fillCandidatsInComboExtends();

                refresh();
            }

        };

        radGroupAll.addSelectionListener(radGroupTypeChangeListener);
        radGroupSequence.addSelectionListener(radGroupTypeChangeListener);
        radGroupChoice.addSelectionListener(radGroupTypeChangeListener);
    }

    public String getTypeName() {
        return txtName.getText().trim();
    }

    public XSDComplexTypeDefinition getExtends() {

        if (!(comboExtends.getSelection() instanceof IStructuredSelection) || comboExtends.getSelection().isEmpty())
            return getDefaultExtends();

        Object selectedObj = ((IStructuredSelection) comboExtends.getSelection()).getFirstElement();

        if (!(selectedObj instanceof XSDComplexTypeDefinition))
            return getDefaultExtends();

        return (XSDComplexTypeDefinition) selectedObj;
    }

    public boolean isGroupAll() {
        return radGroupAll.getSelection();
    }

    public boolean isGroupSequence() {
        return radGroupSequence.getSelection();
    }

    public boolean isGroupChoice() {
        return radGroupChoice.getSelection();
    }

    public XSDCompositor getGroupTypeCompositor() {

        if (isGroupAll())
            return XSDCompositor.ALL_LITERAL;

        if (isGroupSequence())
            return XSDCompositor.SEQUENCE_LITERAL;

        if (isGroupChoice())
            return XSDCompositor.CHOICE_LITERAL;

        return XSDCompositor.ALL_LITERAL;
    }

    private void refresh() {

        XSDTypeDefinition selectedExtends = getExtends();

        radGroupAll.setEnabled(!isExtendsSelected());
        radGroupSequence.setEnabled(!isExtendsSelected());
        radGroupChoice.setEnabled(!isExtendsSelected());

        if (!getDefaultExtends().equals(selectedExtends) && selectedExtends instanceof XSDComplexTypeDefinition
                && !Util.isAllComplexType((XSDComplexTypeDefinition) selectedExtends)) {
            radGroupAll.setSelection(false);
            radGroupSequence.setSelection(Util.isSequenceComplexType((XSDComplexTypeDefinition) selectedExtends));
            radGroupChoice.setSelection(Util.isChoiceComplexType((XSDComplexTypeDefinition) selectedExtends));
        }

        comboExtends.getCombo().setEnabled(!isGroupAll());
    }

    public boolean isExtendsSelected() {
        return !(comboExtends.getSelection() == null || comboExtends.getSelection().isEmpty() || !(((IStructuredSelection) comboExtends
                .getSelection()).getFirstElement() instanceof XSDComplexTypeDefinition));
    }

    private XSDComplexTypeDefinition getDefaultExtends() {
        return complextType.getSchema().resolveComplexTypeDefinition(complextType.getSchema().getSchemaForSchemaNamespace(),
                "anyType");//$NON-NLS-1$
    }
}
