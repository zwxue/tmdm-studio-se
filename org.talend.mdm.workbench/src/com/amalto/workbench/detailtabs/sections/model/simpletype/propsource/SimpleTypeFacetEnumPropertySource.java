package com.amalto.workbench.detailtabs.sections.model.simpletype.propsource;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.utils.IConstants;

public class SimpleTypeFacetEnumPropertySource extends SimpleTypeFacetListStrPropertySource {

    public static final String DELIMITER = " ; ";

    public SimpleTypeFacetEnumPropertySource(Composite cellEditorParent, String[] values) {
        super(cellEditorParent, IConstants.SIMPLETYPE_FACETNAME_ENUM, values, DELIMITER);
    }

    @Override
    protected String getCellEditorDialogInputAreaLabel() {
        return "Enumeration";
    }

    @Override
    protected String getCellEditorDialogTitle() {
        return "SimpleType Enumeration";
    }
}
