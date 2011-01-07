package com.amalto.workbench.detailtabs.sections.util.simpletype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDPatternFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetPatternPropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

class SimpleTypePatternFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(Composite cellEditorParent, Object sourceFacetValue) {
        return new SimpleTypeFacetPatternPropertySource(cellEditorParent, (String[]) sourceFacetValue);
    }

    @Override
    protected String[] getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        List<String> patterns = new ArrayList<String>();
        for (XSDPatternFacet eachFacetValue : simpleType.getPatternFacets())
            patterns.add(eachFacetValue.getLexicalValue());

        return patterns.toArray(new String[0]);
    }
}
