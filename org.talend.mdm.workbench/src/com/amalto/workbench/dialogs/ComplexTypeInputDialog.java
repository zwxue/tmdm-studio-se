package com.amalto.workbench.dialogs;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.impl.XSDModelGroupImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;

import com.amalto.workbench.actions.XSDChangeToComplexTypeAction;
import com.amalto.workbench.actions.XSDNewComplexTypeDefinition;
import com.amalto.workbench.widgets.ConceptComposite;

public class ComplexTypeInputDialog extends Dialog implements ModifyListener {

    private SelectionListener caller = null;

    private String typeName = "";

    private String superTypeName = "";

    private boolean isAbstract;

    private ConceptComposite conceptPanel = null;

    List<XSDComplexTypeDefinition> types;

    private XSDSchema xsdSchema;

    private boolean isXSDModelGroup = false;

    private XSDCompositor typeComposite;

    private XSDCompositor superTypeComposite;

    /**
     * @param parentShell
     * @param isXSDModelGroup
     */
    public ComplexTypeInputDialog(SelectionListener caller, Shell parentShell, XSDSchema schema,
            XSDTypeDefinition typeDefinition, List<XSDComplexTypeDefinition> types, boolean isXSDModelGroup) {
        super(parentShell);
        this.caller = caller;
        this.types = types;
        this.isXSDModelGroup = isXSDModelGroup;
        xsdSchema = schema;
        if (typeDefinition != null) {
            if (typeDefinition instanceof XSDComplexTypeDefinition) {
                if (typeDefinition.getName() != null)
                    this.typeName = typeDefinition.getName();
                superTypeName = typeDefinition.getBaseType().getName();
                XSDComplexTypeDefinition complexType = (XSDComplexTypeDefinition) typeDefinition;
                XSDParticleImpl partCnt = (XSDParticleImpl) complexType.getContent();
                XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                typeComposite = mdlGrp.getCompositor();

                XSDComplexTypeDefinition superComplexType = (XSDComplexTypeDefinition) (typeDefinition.getBaseType());
                partCnt = (XSDParticleImpl) superComplexType.getContent();
                mdlGrp = (XSDModelGroupImpl) partCnt.getTerm();
                superTypeComposite = mdlGrp.getCompositor();

                isAbstract = ((XSDComplexTypeDefinition) typeDefinition).isAbstract();
            }
        }
    }

    protected Control createDialogArea(Composite parent) {
        // Should not really be here but well,....
        final Composite composite = (Composite) super.createDialogArea(parent);

        // encapsulate all widgets into the ConceptComposite which can be applied to several cases
        if (caller instanceof XSDNewComplexTypeDefinition) {
            parent.getShell().setText("Complex Type Properties");
            conceptPanel = new ConceptComposite(composite, false, types, true);
        } else {
            if (isXSDModelGroup)
                parent.getShell().setText("Complex Type Properties");
            else
                parent.getShell().setText("Complex Type Properties");
            conceptPanel = new ConceptComposite(composite, false, types, false);
            conceptPanel.setText(typeName);
            if (superTypeName != null && !"anyType".equalsIgnoreCase(superTypeName))
                conceptPanel.setSuperName(superTypeName);
            if (typeComposite != null) {
                if (typeComposite.equals(XSDCompositor.ALL_LITERAL))
                    conceptPanel.setAll();
                else if (typeComposite.equals(XSDCompositor.CHOICE_LITERAL))
                    conceptPanel.setChoice();
                if (typeComposite.equals(XSDCompositor.SEQUENCE_LITERAL))
                    conceptPanel.setSequence();
            }
            conceptPanel.setAbstract(isAbstract);
        }
        conceptPanel.getTypeCombo().addModifyListener(this);
        return conceptPanel.getComposite();
    }

    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        getButton(IDialogConstants.OK_ID).addSelectionListener(this.caller);
    }

    protected void okPressed() {
        typeName = conceptPanel.getText();
        superTypeName = conceptPanel.getSuperName();
        isAbstract = conceptPanel.isAbstract();
        setReturnCode(OK);
        // no close let Action Handler handle it
    }

    public void modifyText(ModifyEvent e) {
        getButton(IDialogConstants.OK_ID).setEnabled(true);
        conceptPanel.setMessage("");

        String type = conceptPanel.getText();

        if (Pattern.compile("^\\s+\\w+\\s*").matcher(type).matches()
                || type.trim().replaceAll("\\s", "").length() != type.trim().length()) {
            conceptPanel.setMessage("The name cannot contain the empty characters");
            getButton(IDialogConstants.OK_ID).setEnabled(false);
            return;
        }

        type = type.trim();

        for (XSDTypeDefinition specType : xsdSchema.getTypeDefinitions()) {
            String typeToCompare = specType.getName();
            int delimiter = type.indexOf(" : ");
            if (delimiter != -1) {
                type = type.substring(0, delimiter);
            }
            if (typeToCompare.equals(type)) {
                if (caller instanceof XSDNewComplexTypeDefinition) {
                    conceptPanel.setMessage("The same Type name already exists");
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                } else if (caller instanceof XSDChangeToComplexTypeAction && specType instanceof XSDSimpleTypeDefinition) {
                    conceptPanel.setMessage("The same Type name already exists");
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
                break;
            }
        }
    }

    public boolean isSequence() {
        return conceptPanel.isSequence();
    }

    public boolean isChoice() {
        return conceptPanel.isChoice();
    }

    public boolean isAll() {
        return conceptPanel.isAll();
    }

    public boolean isAbstract() {
        return conceptPanel.isAbstract();
    }

    public String getSuperName() {
        return conceptPanel.getSuperName();
    }

    public String getTypeName() {
        return typeName;
    }

}
