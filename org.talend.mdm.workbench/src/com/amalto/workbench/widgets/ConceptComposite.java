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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.impl.XSDModelGroupImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;

import com.amalto.workbench.i18n.Messages;

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
            final boolean newComplex) {

        GridLayout layout = (GridLayout) parent.getLayout();
        layout.numColumns = 2;
        // layout.verticalSpacing = 10;
        typeNameLabel = new Label(parent, SWT.NONE);
        typeNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        typeNameLabel.setText(newComplex == false ? Messages.ConceptComposite_TypeName1 : Messages.ConceptComposite_TypeName2);

        int readOnlyStyle = newComplex ? SWT.NONE : SWT.READ_ONLY;
        typeNameText = new CCombo(parent, SWT.SINGLE | SWT.BORDER | readOnlyStyle);
        typeNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        for (XSDComplexTypeDefinition type : types) {
            String typeName = type.getName() + (type.getTargetNamespace() != null ? " : " + type.getTargetNamespace() : "");//$NON-NLS-1$//$NON-NLS-2$;
            typeNameText.add(typeName);
            typeNameText.setData(typeName, type);
        }
        typeNameText.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Object data = typeNameText.getData(typeNameText.getText());
                if (data != null) {
                    XSDComplexTypeDefinition type = (XSDComplexTypeDefinition) data;
                    setAbstract(type.isAbstract());
                    XSDParticleImpl partCnt = (XSDParticleImpl) type.getContent();
                    if (partCnt != null) {
                        XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                        XSDCompositor typeComposite = mdlGrp.getCompositor();
                        if (typeComposite.equals(XSDCompositor.SEQUENCE_LITERAL)) {
                            setSequence();
                        } else if (typeComposite.equals(XSDCompositor.ALL_LITERAL)) {
                            setAll();
                        } else if (typeComposite.equals(XSDCompositor.CHOICE_LITERAL)) {
                            setChoice();
                        }
                    }
                    if (newComplex) {
                        fillSuperTypeNameText();
                    } else {
                        setSuperName(getSuperTypeName(type));
                    }
                }
            };
        });

        typeNameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                String text = typeNameText.getText();
                if (text.isEmpty()) {
                    setAll();
                }
            }
        });

        Group radioGroup = new Group(parent, SWT.SHADOW_NONE);
        radioGroup.setText(encloseTextField ? "" : "Sub-Elements Group");//$NON-NLS-1$//$NON-NLS-2$

        radioGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        radioGroup.setLayout(new GridLayout(1, false));

        allButton = new Button(radioGroup, SWT.RADIO);
        allButton.setText("All");//$NON-NLS-1$
        allButton.setEnabled(newComplex);
        allButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        sequenceButton = new Button(radioGroup, SWT.RADIO);
        sequenceButton.setText("Sequence");//$NON-NLS-1$
        sequenceButton.setEnabled(newComplex);
        sequenceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        choiceButton = new Button(radioGroup, SWT.RADIO);
        choiceButton.setText("Choice");//$NON-NLS-1$
        choiceButton.setEnabled(newComplex);
        choiceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        allButton.setSelection(true);

        messageLabel = new Label(parent, SWT.NONE);
        messageLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        messageLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        Label label = new Label(parent, 0);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        label.setText(Messages.ConceptComposite_Label);

        superTypeNameText = new CCombo(parent, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
        superTypeNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        superTypeNameText.setEnabled(newComplex);
        fillSuperTypeNameText();

        superTypeNameText.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Object data = typeNameText.getData(superTypeNameText.getText());
                if (data != null) {
                    XSDComplexTypeDefinition type = (XSDComplexTypeDefinition) data;
                    XSDParticleImpl partCnt = (XSDParticleImpl) type.getContent();
                    if (partCnt != null) {
                        XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                        XSDCompositor typeComposite = mdlGrp.getCompositor();
                        if (typeComposite.equals(XSDCompositor.SEQUENCE_LITERAL)) {
                            setSequence();
                        } else if (typeComposite.equals(XSDCompositor.ALL_LITERAL)) {
                            setAll();
                        } else if (typeComposite.equals(XSDCompositor.CHOICE_LITERAL)) {
                            setChoice();
                        }
                    }
                }
                boolean flag = superTypeNameText.getText().trim().length() == 0;
                choiceButton.setEnabled(flag);
                allButton.setEnabled(flag);
                sequenceButton.setEnabled(flag);

            };
        });
        btnAbstract = new Button(parent, SWT.CHECK);
        btnAbstract.setEnabled(newComplex);
        btnAbstract.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        btnAbstract.setText(Messages.ConceptComposite_Abstract);
        container = parent;
        if (encloseTextField) {
            typeNameLabel.setParent(radioGroup);
            typeNameText.setParent(radioGroup);
            label.setParent(radioGroup);
            superTypeNameText.setParent(radioGroup);
            btnAbstract.setParent(radioGroup);
        }
    }

    private void fillSuperTypeNameText() {
        superTypeNameText.removeAll();

        String[] items = typeNameText.getItems();
        List<String> itemList = new ArrayList<String>();
        for (String item : items) {
            if (typeNameText.getText().trim().equals(item)) {
                continue;
            }
            itemList.add(item);
        }
        if (!itemList.contains("")) {//$NON-NLS-1$
            itemList.add(0, "");//$NON-NLS-1$
        }
        superTypeNameText.setItems(itemList.toArray(new String[0]));
    }

    private String getSuperTypeName(XSDComplexTypeDefinition type) {
        XSDTypeDefinition baseType = type.getBaseTypeDefinition();
        if (baseType == null) {
            return ""; //$NON-NLS-1$
        }
        String superTypeName = baseType.getName();
        if (superTypeName == null || "anyType".equalsIgnoreCase(superTypeName)) { //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
        return superTypeName;
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
