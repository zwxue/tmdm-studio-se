package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetPatternPropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

class SimpleTypePatternFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(XSDSimpleTypeDefinition simpleType, Composite cellEditorParent,
            Object sourceFacetValue) {
        return new SimpleTypeFacetPatternPropertySource(cellEditorParent, (String[]) sourceFacetValue);
    }

    @Override
    protected String[] getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {
        return SimpleTypeFacetValueExtractor.getStringArrayFacetValue(simpleType.getPatternFacets());
    }
}
