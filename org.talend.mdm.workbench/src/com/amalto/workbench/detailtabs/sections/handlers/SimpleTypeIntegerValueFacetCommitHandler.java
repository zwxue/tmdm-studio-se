package com.amalto.workbench.detailtabs.sections.handlers;

import org.eclipse.xsd.XSDConstrainingFacet;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;
import com.amalto.workbench.utils.IConstants;

public abstract class SimpleTypeIntegerValueFacetCommitHandler extends CommitHandler<SimpleTypeWrapper> {

    private String facetName;

    public SimpleTypeIntegerValueFacetCommitHandler(SimpleTypeWrapper submittedObj, String facetName) {
        super(submittedObj);

        this.facetName = facetName;
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (!(getCommitedObj().getFacetValue(facetName) instanceof Integer)
                || ((Integer) getCommitedObj().getFacetValue(facetName)) < 0)
            throw new CommitValidationException("The value type of the facet " + facetName + " should be a positive integer or 0");

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        int newValue = ((Integer) getCommitedObj().getFacetValue(facetName)).intValue();
        int oldValue = getOldFacetValue();

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

    protected int getOldFacetValue() {

        XSDFacet facet = getOldFacet();

        if (facet == null || facet.getLexicalValue() == null)
            return 0;

        return Integer.parseInt(facet.getLexicalValue());
    }

    protected abstract XSDFacet getOldFacet();

    protected abstract XSDConstrainingFacet creatNewFacet();

}

class SimpleTypeFacetCommitHandler_FractionDigits extends SimpleTypeIntegerValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_FractionDigits(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_FRACTIONDIGITS);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getFractionDigitsFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDFractionDigitsFacet();
    }

}

class SimpleTypeFacetCommitHandler_TotalDigits extends SimpleTypeIntegerValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_TotalDigits(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_TOTALDIGITS);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getTotalDigitsFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDTotalDigitsFacet();
    }

}

class SimpleTypeFacetCommitHandler_MaxLength extends SimpleTypeIntegerValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MaxLength(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MAXLENGTH);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMaxLengthFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMaxLengthFacet();
    }

}

class SimpleTypeFacetCommitHandler_MinLength extends SimpleTypeIntegerValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_MinLength(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_MINLENGTH);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getMinLengthFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDMinLengthFacet();
    }

}

class SimpleTypeFacetCommitHandler_Length extends SimpleTypeIntegerValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_Length(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_LENGTH);
    }

    @Override
    protected XSDFacet getOldFacet() {
        return getCommitedObj().getXSDSimpleType().getLengthFacet();
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDLengthFacet();
    }

}
