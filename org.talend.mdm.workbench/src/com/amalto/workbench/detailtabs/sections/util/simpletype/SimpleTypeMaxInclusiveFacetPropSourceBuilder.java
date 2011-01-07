package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.utils.IConstants;

public class SimpleTypeMaxInclusiveFacetPropSourceBuilder extends SimpleTypeDoubleFacetPropSourceBuilder {

    @Override
    protected XSDFacet getSourceSimpleTypeFacet(XSDSimpleTypeDefinition simpleType) {
        return simpleType.getMaxInclusiveFacet();
    }

    @Override
    protected String getPropName() {
        return IConstants.SIMPLETYPE_FACETNAME_MAXINCLUSIVE;
    }

}
