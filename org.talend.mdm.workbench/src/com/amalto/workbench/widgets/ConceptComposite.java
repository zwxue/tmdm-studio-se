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
package com.amalto.workbench.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.impl.XSDModelGroupImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;

/**
 * this class is meant to encapsulate all widgets rendering concept it can output a composite to populate concept form
 * 
 * @author fliu
 * 
 */
public class ConceptComposite {

    private CCombo typeNameText = null;

    private Button sequenceButton = null;

    private Button choiceButton = null;

    private Button allButton = null;

    private Label typeNameLabel = null;

    private Label messageLabel = null;

    private Composite container = null;

    private Button btnAbstract;

    private CCombo superTypeNameText;

    public ConceptComposite(Composite parent, boolean encloseTextField, final List<XSDComplexTypeDefinition> types,
            boolean newComplex) {

        GridLayout layout = (GridLayout) parent.getLayout();
        layout.numColumns = 2;
        // layout.verticalSpacing = 10;
        final List<String> typeNames = new ArrayList<String>();
        for (XSDComplexTypeDefinition type : types) {
            typeNames.add(type.getName() + (type.getTargetNamespace() != null ? " : " + type.getTargetNamespace() : ""));//$NON-NLS-1$//$NON-NLS-2$
        }
        typeNameLabel = new Label(parent, SWT.NONE);
        typeNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        typeNameLabel.setText(newComplex == false ? "Please enter the name of the complex type. Leave blank for anonymous"
                : "Please enter the name of the complex type");

        typeNameText = new CCombo(parent, SWT.SINGLE | SWT.BORDER);
        typeNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        typeNameText.setItems(typeNames.toArray(new String[typeNames.size()]));
        typeNameText.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                for (int i = 0; i < types.size(); i++) {
                    XSDComplexTypeDefinition type = types.get(i);
                    XSDParticleImpl partCnt = null;
                    if (typeNameText.getText().equalsIgnoreCase(type.getName()))
                        partCnt = (XSDParticleImpl) type.getContent();
                    if (partCnt != null) {
                        XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                        XSDCompositor typeComposite = mdlGrp.getCompositor();
                        if (typeComposite.equals(XSDCompositor.SEQUENCE_LITERAL))
                            setSequence();
                        else if (typeComposite.equals(XSDCompositor.ALL_LITERAL))
                            setAll();
                        else if (typeComposite.equals(XSDCompositor.CHOICE_LITERAL))
                            setChoice();
                        break;
                    }
                }
                List<String> typeNames1 = new ArrayList<String>();
                typeNames1.addAll(typeNames);
                if (typeNameText.getText().trim().length() > 0) {
                    typeNames1.remove(typeNameText.getText());
                    if (!typeNames1.contains("")) {//$NON-NLS-1$
                        typeNames1.add(0, "");//$NON-NLS-1$
                    }
                    superTypeNameText.setItems(typeNames1.toArray(new String[typeNames1.size()]));
                }
            };
        });

        final Group radioGroup = new Group(parent, SWT.SHADOW_NONE);
        radioGroup.setText(encloseTextField ? "" : "Sub-Elements Group");//$NON-NLS-1$//$NON-NLS-2$

        radioGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        radioGroup.setLayout(new GridLayout(1, false));

        allButton = new Button(radioGroup, SWT.RADIO);
        allButton.setText("All");//$NON-NLS-1$

        allButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        sequenceButton = new Button(radioGroup, SWT.RADIO);
        sequenceButton.setText("Sequence");//$NON-NLS-1$

        sequenceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        choiceButton = new Button(radioGroup, SWT.RADIO);
        choiceButton.setText("Choice");//$NON-NLS-1$

        choiceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        allButton.setSelection(true);

        messageLabel = new Label(parent, SWT.NONE);
        messageLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        Label label = new Label(parent, 0);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        label.setText("This complex-type extends another complex-type:");

        superTypeNameText = new CCombo(parent, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
        superTypeNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));

        if (!typeNames.contains("")) {//$NON-NLS-1$
            typeNames.add(0, "");//$NON-NLS-1$
        }

        superTypeNameText.setItems(typeNames.toArray(new String[typeNames.size()]));
        superTypeNameText.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
            };

            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                for (int i = 0; i < types.size(); i++) {
                    XSDComplexTypeDefinition type = types.get(i);
                    XSDParticleImpl partCnt = null;
                    if (superTypeNameText.getText().equalsIgnoreCase(type.getName()))
                        partCnt = (XSDParticleImpl) type.getContent();
                    if (partCnt != null) {
                        XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                        XSDCompositor typeComposite = mdlGrp.getCompositor();
                        if (typeComposite.equals(XSDCompositor.SEQUENCE_LITERAL))
                            setSequence();
                        else if (typeComposite.equals(XSDCompositor.ALL_LITERAL))
                            setAll();
                        else if (typeComposite.equals(XSDCompositor.CHOICE_LITERAL))
                            setChoice();
                        break;
                    }
                }
                boolean flag = superTypeNameText.getText().trim().length() == 0;
                choiceButton.setEnabled(flag);
                allButton.setEnabled(flag);
                sequenceButton.setEnabled(flag);

            };
        });
        btnAbstract = new Button(parent, SWT.CHECK);
        btnAbstract.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        btnAbstract.setText("Abstract");
        container = parent;
        if (encloseTextField) {
            typeNameLabel.setParent(radioGroup);
            typeNameText.setParent(radioGroup);
            label.setParent(radioGroup);
            superTypeNameText.setParent(radioGroup);
            btnAbstract.setParent(radioGroup);
        }
    }

    public String getSuperName() {
        return superTypeNameText.getText();
    }

    public void setSuperName(String superName) {
        superTypeNameText.setText(superName);
    }

    public String getText() {
        return typeNameText.getText();
    }

    public void setText(String text) {
        typeNameText.setText(text);
    }

    public void setFocus() {
        typeNameText.setFocus();
    }

    public void setMessage(String msg) {
        messageLabel.setText(msg);
    }

    public boolean isSequence() {
        return sequenceButton.getSelection();
    }

    public void setSequence() {
        choiceButton.setSelection(false);
        allButton.setSelection(false);
        sequenceButton.setSelection(true);
    }

    public boolean isChoice() {
        return choiceButton.getSelection();
    }

    public boolean isAbstract() {
        return btnAbstract.getSelection();
    }

    public void setAbstract(boolean isAbstract) {
        btnAbstract.setSelection(isAbstract);
    }

    public void setChoice() {
        choiceButton.setSelection(true);
        allButton.setSelection(false);
        sequenceButton.setSelection(false);
    }

    public boolean isAll() {
        return allButton.getSelection();
    }

    public void setAll() {
        choiceButton.setSelection(false);
        allButton.setSelection(true);
        sequenceButton.setSelection(false);
    }

    public Composite getComposite() {
        return container;
    }

    public CCombo getTypeCombo() {
        return typeNameText;
    }

    public void setSelectAllWidgets(boolean selected) {
        typeNameText.setEnabled(selected);
        sequenceButton.setEnabled(selected);
        choiceButton.setEnabled(selected);
        allButton.setEnabled(selected);
        typeNameLabel.setEnabled(selected);
        btnAbstract.setEnabled(selected);
        superTypeNameText.setEnabled(selected);
    }
}
