package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetDoublePropertySource;
import com.amalto.workbench.detailtabs.sections.model.simpletype.propsource.SimpleTypeFacetIntegerPropertySource;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public class SimpleTypeMaxExclusiveFacetPropSourceBuilder extends SimpleTypeFacetPropSourceBuilder {

    @Override
    protected IPropertySource<?> doCreatePropSource(XSDSimpleTypeDefinition simpleType, Composite cellEditorParent,
            Object sourceFacetValue) {

        if (Util.isDouble(simpleType) || Util.isDecimal(simpleType) || Util.isFloat(simpleType)) {
            return new SimpleTypeFacetDoublePropertySource(cellEditorParent, IConstants.SIMPLETYPE_FACETNAME_MAXEXCLUSIVE,
                    (Double) sourceFacetValue);
        }

        return new SimpleTypeFacetIntegerPropertySource(cellEditorParent, IConstants.SIMPLETYPE_FACETNAME_MAXEXCLUSIVE,
                (Integer) sourceFacetValue);
    }

    @Override
    protected Object getSourceFacetValue(XSDSimpleTypeDefinition simpleType) {

        if (Util.isDouble(simpleType) || Util.isDecimal(simpleType) || Util.isFloat(simpleType)) {
            return SimpleTypeFacetValueExtractor.getDoubleFacetValue(simpleType.getMaxExclusiveFacet());
        }

        return SimpleTypeFacetValueExtractor.getIntFacetValue(simpleType.getMaxExclusiveFacet());
    }

}
