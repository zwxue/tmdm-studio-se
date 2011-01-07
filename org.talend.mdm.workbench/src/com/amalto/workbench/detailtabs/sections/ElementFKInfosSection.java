package com.amalto.workbench.detailtabs.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyInfosAnnoInfo;
import com.amalto.workbench.detailtabs.sections.util.FixDMNameBasePropertySectionDataModelExtractor;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.composites.ListXPathComposite;

public class ElementFKInfosSection extends XSDComponentSection {

    private ListXPathComposite compXPath;

    private FixDMNameBasePropertySectionDataModelExtractor dataModelHolder;

    private List<String> fkInfos = new ArrayList<String>();

    private boolean isResolveAutoInWeb;

    @Override
    public void refresh() {
        compXPath.setInfos(fkInfos.toArray(new String[0]));
        compXPath.setIsResolveAutoInWeb(isResolveAutoInWeb);
    }

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        super.initUIContents(editedObj);

        fkInfos.clear();

        XSDAnnotationsStructure annoStruct = new XSDAnnotationsStructure(curXSDComponent);

        for (String eachFKInfo : annoStruct.getForeignKeyInfos().values())
            fkInfos.add(eachFKInfo);

        isResolveAutoInWeb = annoStruct.getRetrieveFKinfos();
        dataModelHolder.setDefaultDataModel(getDataModelName());
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return new ForeignKeyInfosAnnoInfo(curXSDComponent, compXPath.getInfos(), compXPath.isResolveAutoInWeb());
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        dataModelHolder = new FixDMNameBasePropertySectionDataModelExtractor(this);
        compXPath = new ListXPathComposite(compSectionClient, SWT.NONE, dataModelHolder, "");
    }

    @Override
    protected String getSectionTitle() {
        return "Foreign Key Infos";
    }
}
