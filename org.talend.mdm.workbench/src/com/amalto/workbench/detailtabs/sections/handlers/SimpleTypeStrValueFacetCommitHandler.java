package com.amalto.workbench.detailtabs.sections.handlers;

import org.eclipse.xsd.XSDConstrainingFacet;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;
import com.amalto.workbench.utils.IConstants;

public abstract class SimpleTypeStrValueFacetCommitHandler extends CommitHandler<SimpleTypeWrapper> {

    private String facetName;

    public SimpleTypeStrValueFacetCommitHandler(SimpleTypeWrapper submittedObj, String facetName) {
        super(submittedObj);

        this.facetName = facetName;
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (!(getCommitedObj().getFacetValue(facetName) instanceof String))
            throw new CommitValidationException("The value type of the facet " + facetName + " should be a string");

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        String newValue = (String) getCommitedObj().getFacetValue(facetName);
        String oldValue = getOldFacetValue();

        if (oldValue.equals(newValue))
            return false;

        if (!"".equals(oldValue))
            getCommitedObj().getXSDSimpleType().getFacetContents().remove(getOldFacet());

        if (!"".equals(newValue)) {
            XSDConstrainingFacet f = creatNewFacet();
            f.setLexicalValue("" + newValue);
            getCommitedObj().getXSDSimpleType().getFacetContents().add(f);
        }

        return true;
    }

    protected String getOldFacetValue() {

        XSDFacet facet = getOldFacet();

        if (facet == null || facet.getLexicalValue() == null)
            return "";

        return facet.getLexicalValue();
    }

    protected abstract XSDFacet getOldFacet();

    protected abstract XSDConstrainingFacet creatNewFacet();

}

class SimpleTypeFacetCommitHandler_WhiteSpace extends SimpleTypeStrValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_WhiteSpace(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_WHITESPACE);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getWhiteSpaceFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDWhiteSpaceFacet();
    }

}
