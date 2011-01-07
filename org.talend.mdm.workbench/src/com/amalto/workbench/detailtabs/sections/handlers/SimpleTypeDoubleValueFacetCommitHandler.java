package com.amalto.workbench.detailtabs.sections.handlers;

import org.eclipse.xsd.XSDConstrainingFacet;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;
import com.amalto.workbench.utils.IConstants;

public abstract class SimpleTypeDoubleValueFacetCommitHandler extends CommitHandler<SimpleTypeWrapper> {

    private String facetName;

    public SimpleTypeDoubleValueFacetCommitHandler(SimpleTypeWrapper submittedObj, String facetName) {
        super(submittedObj);

        this.facetName = facetName;
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (!(getCommitedObj().getFacetValue(facetName) instanceof Double)
                || ((Double) getCommitedObj().getFacetValue(facetName)) < 0)
            throw new CommitValidationException("The value type of the facet " + facetName + " should be a positive double or 0");

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        double newValue = ((Double) getCommitedObj().getFacetValue(facetName)).doubleValue();
        double oldValue = getOldFacetValue();

        if (oldValue == newValue)
            return false;

        if (oldValue != 0)
            getCommitedObj().getXSDSimpleType().getFacetContents().remove(getOldFacet());

        if (newValue > 0) {
            XSDConstrainingFacet f = creatNewFacet();
            f.setLexicalValue("" + newValue);
            getCommitedObj().getXSDSimpleType().getFacetContents().add(f);
        }

        return true;
    }

    protected double getOldFacetValue() {

        XSDFacet facet = getOldFacet();

        if (facet == null || facet.getLexicalValue() == null)
            return 0;

        return Double.parseDouble(facet.getLexicalValue());
    }

    protected abstract XSDFacet getOldFacet();

    protected abstract XSDConstrainingFacet creatNewFacet();

}

class SimpleTypeFacetCommitHandler_MinExclusive extends SimpleTypeDoubleValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MinExclusive(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MINEXCLUSIVE);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMinExclusiveFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMinExclusiveFacet();
    }

}

class SimpleTypeFacetCommitHandler_MinInclusive extends SimpleTypeDoubleValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MinInclusive(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MININCLUSIVE);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMinInclusiveFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMinInclusiveFacet();
    }

}

class SimpleTypeFacetCommitHandler_MaxExclusive extends SimpleTypeDoubleValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MaxExclusive(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MAXEXCLUSIVE);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMaxExclusiveFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMaxExclusiveFacet();
    }

}

class SimpleTypeFacetCommitHandler_MaxInclusive extends SimpleTypeDoubleValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MaxInclusive(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MAXINCLUSIVE);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMaxInclusiveFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMaxInclusiveFacet();
    }

}
