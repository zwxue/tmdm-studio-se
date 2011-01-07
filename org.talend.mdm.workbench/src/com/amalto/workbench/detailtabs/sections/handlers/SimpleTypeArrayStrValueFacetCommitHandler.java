package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xsd.XSDConstrainingFacet;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeWrapper;
import com.amalto.workbench.utils.IConstants;

public abstract class SimpleTypeArrayStrValueFacetCommitHandler extends CommitHandler<SimpleTypeWrapper> {

    private String facetName;

    public SimpleTypeArrayStrValueFacetCommitHandler(SimpleTypeWrapper submittedObj, String facetName) {
        super(submittedObj);

        this.facetName = facetName;
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        if (!(getCommitedObj().getFacetValue(facetName) instanceof String[]))
            throw new CommitValidationException("The value type of the facet " + facetName + " should be a string array");

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        if (!hasChange())
            return false;

        getCommitedObj().getXSDSimpleType().getFacetContents().removeAll(Arrays.asList(getOldFacets()));
        for (String eachNewFacetValue : (String[]) getCommitedObj().getFacetValue(facetName)) {

            XSDConstrainingFacet f = creatNewFacet();
            f.setLexicalValue(eachNewFacetValue);
            getCommitedObj().getXSDSimpleType().getFacetContents().add(f);
        }

        return true;
    }

    private List<String> getOldFacetValues() {

        List<String> oldPatterns = new ArrayList<String>();
        for (XSDFacet eachOldFacet : getOldFacets()) {

            if (eachOldFacet.getLexicalValue() == null || "".equals(eachOldFacet.getLexicalValue().trim()))
                continue;

            oldPatterns.add(eachOldFacet.getLexicalValue());
        }

        return oldPatterns;

    }

    private boolean hasChange() {

        List<String> oldFacetValues = getOldFacetValues();

        List<String> newFacetValues = Arrays.asList((String[]) getCommitedObj().getFacetValue(facetName));

        if (oldFacetValues.size() != newFacetValues.size())
            return true;

        for (String eachNewValue : newFacetValues) {

            if (!oldFacetValues.contains(eachNewValue))
                return true;
        }

        for (String eachOldFacetValue : oldFacetValues) {

            if (!newFacetValues.contains(eachOldFacetValue))
                return true;
        }

        return false;
    }

    protected abstract XSDFacet[] getOldFacets();

    protected abstract XSDConstrainingFacet creatNewFacet();

}

class SimpleTypeFacetCommitHandler_Pattern extends SimpleTypeArrayStrValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_Pattern(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_PATTERN);
    }

    @Override
    protected XSDFacet[] getOldFacets() {
        return getCommitedObj().getXSDSimpleType().getPatternFacets().toArray(new XSDFacet[0]);
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDPatternFacet();
    }
}

class SimpleTypeFacetCommitHandler_Enum extends SimpleTypeArrayStrValueFacetCommitHandler {

    public SimpleTypeFacetCommitHandler_Enum(SimpleTypeWrapper submittedObj) {
        super(submittedObj, IConstants.SIMPLETYPE_FACETNAME_ENUM);
    }

    @Override
    protected XSDFacet[] getOldFacets() {
        return getCommitedObj().getXSDSimpleType().getEnumerationFacets().toArray(new XSDFacet[0]);
    }

    @Override
    protected XSDConstrainingFacet creatNewFacet() {
        return XSDSchemaBuildingTools.getXSDFactory().createXSDEnumerationFacet();
    }

}
