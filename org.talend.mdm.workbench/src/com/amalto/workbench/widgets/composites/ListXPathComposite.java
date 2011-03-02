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
package com.amalto.workbench.widgets.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;

public class ListXPathComposite extends ListStringContentsComposite {

    private Button chkResolveAutoInWeb;

    private SimpleXPathComposite compSimpleXPath;

    private IAllDataModelHolder allDataModelHolder;

    private String xpathAreaTitle;

    public ListXPathComposite(Composite parent, int style, IAllDataModelHolder allDataModelHolder, String xpathAreaTitle) {
        super(parent, style, new Object[] { allDataModelHolder, xpathAreaTitle });
    }

    @Override
    protected String getInfoColTitle() {
        return "XPath";
    }

    @Override
    protected void createExtentUIArea(Composite parent) {

        chkResolveAutoInWeb = new Button(this, SWT.CHECK);
        chkResolveAutoInWeb.setText("Resolve automatically in the Web");
        chkResolveAutoInWeb.setSelection(true);
        chkResolveAutoInWeb.setLayoutData(new GridData());

    }

    @Override
    protected void createCandidateInfoUIArea(Composite parent) {

        compSimpleXPath = new SimpleXPathComposite(this, SWT.NONE, xpathAreaTitle, allDataModelHolder, "");//$NON-NLS-1$
        compSimpleXPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    }

    @Override
    protected boolean hasCandidateInfo() {
        return !("".equals(compSimpleXPath.getXPath()));//$NON-NLS-1$
    }

    @Override
    protected String getCandidateInfo() {
        return compSimpleXPath.getXPath();
    }

    @Override
    protected void initCandidateInfoUIArea() {
        compSimpleXPath.setXPath("");//$NON-NLS-1$
    }

    public boolean isResolveAutoInWeb() {
        return chkResolveAutoInWeb.getSelection();
    }

    public void setIsResolveAutoInWeb(boolean isResolveAutoInWeb) {
        chkResolveAutoInWeb.setSelection(isResolveAutoInWeb);
    }

    @Override
    protected void initParas(Object[] paras) {

        for (Object eachPara : paras) {

            if (eachPara instanceof IAllDataModelHolder)
                allDataModelHolder = (IAllDataModelHolder) eachPara;

            if (eachPara instanceof String)
                xpathAreaTitle = (String) eachPara;
        }

    }
}
