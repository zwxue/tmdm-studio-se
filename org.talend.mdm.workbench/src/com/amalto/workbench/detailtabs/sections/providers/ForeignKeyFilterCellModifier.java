package com.amalto.workbench.detailtabs.sections.providers;

import java.util.Arrays;

import org.eclipse.jface.viewers.Viewer;

import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyFilterAnnoInfoDefUnit;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyAnnoInfo;
import com.amalto.workbench.providers.ArrayComboCellEditorIndexExtractor;
import com.amalto.workbench.providers.CellEditorValueExtractor;
import com.amalto.workbench.providers.CommonTableCellModifier;
import com.amalto.workbench.utils.IConstants;

public class ForeignKeyFilterCellModifier extends CommonTableCellModifier<ForeignKeyFilterAnnoInfoDefUnit> {

    public static final String COL_PROP_XPATH = "xpath";

    public static final String COL_PROP_OPERATOR = "operator";

    public static final String COL_PROP_VALUE = "value";

    public static final String COL_PROP_PREDICATE = "predicate";

    public static final String[] COLPROPS = new String[] { COL_PROP_XPATH, COL_PROP_OPERATOR, COL_PROP_VALUE, COL_PROP_PREDICATE };

    private Viewer viewer;

    public ForeignKeyFilterCellModifier(Viewer viewer) {
        this.viewer = viewer;

        prop2ValueIndexExtractor.put(COL_PROP_XPATH, new CellEditorValueExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getXpath"));
        prop2ValueIndexExtractor.put(COL_PROP_OPERATOR, new ArrayComboCellEditorIndexExtractor<ForeignKeyFilterAnnoInfoDefUnit>(
                IConstants.VIEW_CONDITION_OPERATORS, "getOperator"));
        prop2ValueIndexExtractor.put(COL_PROP_VALUE, new CellEditorValueExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getValue"));
        prop2ValueIndexExtractor.put(COL_PROP_PREDICATE, new ArrayComboCellEditorIndexExtractor<ForeignKeyFilterAnnoInfoDefUnit>(
                IConstants.PREDICATES, "getPredicate"));
    }

    public boolean canModify(Object element, String property) {
        return (element instanceof ForeignKeyAnnoInfo) && Arrays.asList(COLPROPS).contains(property);
    }

    @Override
    protected Viewer getViewer() {
        return viewer;
    }
}
