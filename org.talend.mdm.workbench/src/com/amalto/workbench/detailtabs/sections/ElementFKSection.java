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
package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyAnnoInfo;
import com.amalto.workbench.detailtabs.sections.util.FixDMNameBasePropertySectionDataModelExtractor;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.composites.SimpleXPathComposite;

public class ElementFKSection extends XSDComponentSection {

    private FixDMNameBasePropertySectionDataModelExtractor dataModelHolder;

    private SimpleXPathComposite compSimpleXPath;

    private String xpath = "";

    @Override
    public void refresh() {
        compSimpleXPath.setXPath(xpath);
    }

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        super.initUIContents(editedObj);

        xpath = new XSDAnnotationsStructure(curXSDComponent).getForeignKey();
        if (xpath == null)
            xpath = "";

        dataModelHolder.setDefaultDataModel(getDataModelName());
        compSimpleXPath.setDefaultDataModelForSelect(getDataModelName());

    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return new ForeignKeyAnnoInfo(curXSDComponent, compSimpleXPath.getXPath());
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        dataModelHolder = new FixDMNameBasePropertySectionDataModelExtractor(this);
        compSimpleXPath = new SimpleXPathComposite(compSectionClient, SWT.NONE, SimpleXPathComposite.DEFAULTTITLE,
                dataModelHolder, "");
    }

    @Override
    protected String getSectionTitle() {
        return "Foreign Key";
    }
}
