package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetArrayStrPropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public abstract class SimpleTypeArrayStrFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(Composite cellEditorParent, Object sourceFacetValue) {
        return new SimpleTypeFacetArrayStrPropertySource(cellEditorParent, getPropName(), (String) sourceFacetValue,
                getCandidates());
    }

    @Override
    protected String getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        if (getSourceSimpleTypeFacet(simpleType) == null)
            return "";

        String result = "";

        try {
            result = getSourceSimpleTypeFacet(simpleType).getLexicalValue();
        } catch (Exception e) {
            return "";
        }

        return (result == null ? "" : result);
    }

    protected abstract XSDFacet getSourceSimpleTypeFacet(XSDSimpleTypeDefinition simpleType);

    protected abstract String getPropName();

    protected abstract String[] getCandidates();
}
