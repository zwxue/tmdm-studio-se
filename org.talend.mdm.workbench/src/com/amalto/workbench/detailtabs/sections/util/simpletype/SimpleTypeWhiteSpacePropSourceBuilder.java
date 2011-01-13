package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetArrayStrPropertySource;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public class SimpleTypeWhiteSpacePropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    private String[] candidates = new String[] { "preserve", "replace", "collapse" };

    @Override
    protected IPropertySource<?> doCreatePropSource(XSDSimpleTypeDefinition simpleType, Composite cellEditorParent,
            Object sourceFacetValue) {
        return new SimpleTypeFacetArrayStrPropertySource(cellEditorParent, IConstants.SIMPLETYPE_FACETNAME_WHITESPACE,
                (String) sourceFacetValue, candidates);
    }

    @Override
    protected Object getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {
        return SimpleTypeFacetValueExtractor.getStringFacetValue(simpleType.getWhiteSpaceFacet());
    }

}
