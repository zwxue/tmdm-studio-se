package com.amalto.workbench.detailtabs.sections.util.simpletype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDEnumerationFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetEnumPropertySource;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public class SimpleTypeEnumFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(Composite cellEditorParent, Object sourceFacetValue) {

        return new SimpleTypeFacetEnumPropertySource(cellEditorParent, (String[]) sourceFacetValue);

    }

    @Override
    protected String[] getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        List<String> enums = new ArrayList<String>();
        for (XSDEnumerationFacet eachFacetValue : simpleType.getEnumerationFacets())
            enums.add(eachFacetValue.getLexicalValue());

        return enums.toArray(new String[0]);
    }

}
