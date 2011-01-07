package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.composites.SimpleTypeConfigComposite;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;

public class SimpleTypeMainSection extends CommitBarListenerSection<XSDSimpleTypeDefinition> {

    private SimpleTypeConfigComposite compSimpleTypeConfig;

    private XSDSimpleTypeDefinition xsdSimpleType;

    @Override
    protected ISubmittable getSubmittedObj() {

        return new SimpleTypeWrapper(xsdSimpleType, compSimpleTypeConfig.getSimpleTypeName(),
                compSimpleTypeConfig.getSelectedBaseType(), compSimpleTypeConfig.getSelectedBaseTypeName(),
                compSimpleTypeConfig.getPropertyName2Values());
    }

    @Override
    protected XSDSimpleTypeDefinition getEditedObj() {
        return xsdSimpleType;
    }

    @Override
    protected void initUIContents(XSDSimpleTypeDefinition editedObj) {

        xsdSimpleType = editedObj;

        compSimpleTypeConfig.setSimpleType(xsdSimpleType);

    }

    @Override
    protected String getSectionTitle() {
        return "Main";
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        compSimpleTypeConfig = new SimpleTypeConfigComposite(compSectionClient, SWT.NONE);
    }
}
