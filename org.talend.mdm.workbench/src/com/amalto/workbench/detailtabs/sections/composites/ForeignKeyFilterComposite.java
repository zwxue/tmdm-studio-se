// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections.composites;

import java.util.ArrayList;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyFilterAnnoInfo;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyFilterAnnoInfoDefUnit;
import com.amalto.workbench.detailtabs.sections.providers.ForeignKeyFilterCellModifier;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.providers.ColumnTextExtractor;
import com.amalto.workbench.providers.CommonTableLabelProvider;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.widgets.celleditor.XPathCellEditor;
import com.amalto.workbench.widgets.composites.ComplexAnnotaionInfoComposite;

public class ForeignKeyFilterComposite extends ComplexAnnotaionInfoComposite<ForeignKeyFilterAnnoInfoDefUnit> {

    private Text txtCustomFilter;

    private IAllDataModelHolder dataModelHolder;

    public ForeignKeyFilterComposite(Composite parent, int style, IAllDataModelHolder dataModelHolder) {
        super(parent, style, new Object[] { dataModelHolder });
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ITableLabelProvider getLabelProviderForViewer() {
        return new CommonTableLabelProvider<ForeignKeyFilterAnnoInfoDefUnit>(new ColumnTextExtractor[] {
                new ColumnTextExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getXpath"),
                new ColumnTextExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getOperator"),
                new ColumnTextExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getValue"),
                new ColumnTextExtractor<ForeignKeyFilterAnnoInfoDefUnit>("getPredicate") });
    }

    @Override
    protected void createExtentArea() {

        Group gpCustomFilter = new Group(this, SWT.NORMAL);
        gpCustomFilter.setText("Custom filters");
        gpCustomFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        gpCustomFilter.setLayout(new GridLayout());

        txtCustomFilter = new Text(gpCustomFilter, SWT.MULTI | SWT.V_SCROLL);
        GridData gdTxtCustomFilter = new GridData(SWT.FILL, SWT.FILL, true, true);
        gdTxtCustomFilter.heightHint = 35;
        txtCustomFilter.setLayoutData(gdTxtCustomFilter);
    }

    @Override
    protected void fillColumnsInTree(Tree tree) {

        final TreeColumn colXPath = new TreeColumn(tree, SWT.NONE);
        colXPath.setWidth(200);
        colXPath.setText("XPath");
        colXPath.setImage(nillableColImage);

        final TreeColumn colOperator = new TreeColumn(tree, SWT.NONE);
        colOperator.setWidth(100);
        colOperator.setText("Operator");
        colOperator.setImage(nillableColImage);

        final TreeColumn colValue = new TreeColumn(tree, SWT.NONE);
        colValue.setWidth(200);
        colValue.setText("Value");
        colValue.setImage(nillableColImage);

        final TreeColumn colPredicate = new TreeColumn(tree, SWT.NONE);
        colPredicate.setWidth(100);
        colPredicate.setText("Predicate");

    }

    @Override
    protected ForeignKeyFilterAnnoInfoDefUnit createDefaultInfoObj() {
        return new ForeignKeyFilterAnnoInfoDefUnit("newXPath", IConstants.VIEW_CONDITION_OPERATORS[0], "",//$NON-NLS-1$
                IConstants.PREDICATES[0]);
    }

    @Override
    protected boolean validateBeforePaste(ForeignKeyFilterAnnoInfoDefUnit copyedObj) {
        return true;
    }

    @Override
    protected ForeignKeyFilterAnnoInfoDefUnit cloneCopyedObj(ForeignKeyFilterAnnoInfoDefUnit copyedObj) {
        return new ForeignKeyFilterAnnoInfoDefUnit(copyedObj.getXpath(), copyedObj.getOperator(), copyedObj.getValue(),
                copyedObj.getPredicate());
    }

    @Override
    protected String[] getColumnProperties() {
        return ForeignKeyFilterCellModifier.COLPROPS;
    }

    @Override
    protected CellEditor[] getCellEditors() {
        return new CellEditor[] { new XPathCellEditor(tvInfos.getTree(), dataModelHolder),
                new ComboBoxCellEditor(tvInfos.getTree(), IConstants.VIEW_CONDITION_OPERATORS, SWT.READ_ONLY),
                new XPathCellEditor(tvInfos.getTree(), dataModelHolder),
                new ComboBoxCellEditor(tvInfos.getTree(), IConstants.PREDICATES, SWT.READ_ONLY) };
    }

    @Override
    protected ICellModifier getCellModifier() {
        return new ForeignKeyFilterCellModifier(tvInfos);
    }

    @Override
    protected void initParameters(Object[] parameters) {
        infos = new ArrayList<ForeignKeyFilterAnnoInfoDefUnit>();

        for (Object eachPara : parameters) {

            if (eachPara instanceof IAllDataModelHolder)
                dataModelHolder = (IAllDataModelHolder) eachPara;
        }
    }

    private String getCustomFilter() {
        return txtCustomFilter.getText().trim();
    }

    private boolean hasCustomFilter() {
        return !"".equals(getCustomFilter().trim());
    }

    public String getFilterExpression() {

        if (hasCustomFilter())
            return ForeignKeyFilterAnnoInfo.getFKFilterByRawCustomFilterStr(getCustomFilter());

        return ForeignKeyFilterAnnoInfo.getFKFilterByFKFilterCfgInfos(infos.toArray(new ForeignKeyFilterAnnoInfoDefUnit[0]));
    }

    public void setFilter(String filterExpression) {

        txtCustomFilter.setText(ForeignKeyFilterAnnoInfo.getCustomFilterInfo(filterExpression));
        setInfos(ForeignKeyFilterAnnoInfo.getFKFilterCfgInfos(filterExpression));

    }

    @Override
    protected void createTopExtentArea() {
    }
}
