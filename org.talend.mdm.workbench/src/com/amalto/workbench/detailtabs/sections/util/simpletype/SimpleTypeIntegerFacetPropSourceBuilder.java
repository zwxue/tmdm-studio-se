package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetIntegerPropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public abstract class SimpleTypeIntegerFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(Composite cellEditorParent, Object sourceFacetValue) {
        return new SimpleTypeFacetIntegerPropertySource(cellEditorParent, getPropName(), (Integer) sourceFacetValue);
    }

    @Override
    protected Integer getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        if (getSourceSimpleTypeFacet(simpleType) == null)
            return 0;

        Integer result = 0;

        try {
            result = Integer.parseInt(getSourceSimpleTypeFacet(simpleType).getLexicalValue());
        } catch (Exception e) {
            return 0;
        }

        return result;
    }

    protected abstract XSDFacet getSourceSimpleTypeFacet(XSDSimpleTypeDefinition simpleType);

    protected abstract String getPropName();
}
