package com.amalto.workbench.detailtabs.sections.model.simpletype.propsource;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.utils.IConstants;

public class SimpleTypeFacetPatternPropertySource extends SimpleTypeFacetListStrPropertySource {

    public static final String DELIMITER = " ; ";

    public SimpleTypeFacetPatternPropertySource(Composite cellEditorParent, String[] values) {
        super(cellEditorParent, IConstants.SIMPLETYPE_FACETNAME_PATTERN, values, DELIMITER);
    }

    @Override
    protected String getCellEditorDialogInputAreaLabel() {
        return "Pattern";
    }

    @Override
    protected String getCellEditorDialogTitle() {
        return "SimpleType Pattern";
    }

}
