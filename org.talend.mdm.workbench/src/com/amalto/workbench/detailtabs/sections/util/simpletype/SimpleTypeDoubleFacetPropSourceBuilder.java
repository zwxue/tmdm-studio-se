package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetDoublePropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public abstract class SimpleTypeDoubleFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(Composite cellEditorParent, Object sourceFacetValue) {
        return new SimpleTypeFacetDoublePropertySource(cellEditorParent, getPropName(), (Double) sourceFacetValue);
    }

    @Override
    protected Double getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        if (getSourceSimpleTypeFacet(simpleType) == null)
            return 0d;

        Double result = 0d;

        try {
            result = Double.parseDouble(getSourceSimpleTypeFacet(simpleType).getLexicalValue());
        } catch (Exception e) {
            return 0d;
        }

        return result;
    }

    protected abstract XSDFacet getSourceSimpleTypeFacet(XSDSimpleTypeDefinition simpleType);

    protected abstract String getPropName();

}
