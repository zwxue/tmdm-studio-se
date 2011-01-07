package com.amalto.workbench.detailtabs.sections.util.simpletype;

import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.utils.IConstants;

public class SimpleTypeArrayWhiteSpacePropSourceBuilder extends SimpleTypeArrayStrFacetPropSourceBuilder {

    private String[] candidates = new String[] { "preserve", "replace", "collapse" };

    @Override
    protected XSDFacet getSourceSimpleTypeFacet(XSDSimpleTypeDefinition simpleType) {
        return simpleType.getWhiteSpaceFacet();
    }

    @Override
    protected String getPropName() {
        return IConstants.SIMPLETYPE_FACETNAME_WHITESPACE;
    }

    @Override
    protected String[] getCandidates() {
        return candidates;
    }

}
