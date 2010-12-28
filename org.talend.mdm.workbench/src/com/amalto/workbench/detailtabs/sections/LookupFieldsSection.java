package com.amalto.workbench.detailtabs.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.LookupFieldsAnnoInfo;
import com.amalto.workbench.models.infoextractor.XSDComponentChildElementsHolder;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.composites.SelectElementsOfEntityComposite;

public class LookupFieldsSection extends XSDComponentSection {

    private SelectElementsOfEntityComposite compElements;

    private List<String> lookupFields = new ArrayList<String>();

    @Override
    public void refresh() {
        compElements.setAnnotaionInfos(lookupFields.toArray(new String[0]));
    }

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        super.initUIContents(editedObj);

        lookupFields.clear();

        XSDAnnotationsStructure annoStruct = new XSDAnnotationsStructure(curXSDComponent);

        for (String eachLookUpFields : annoStruct.getLookupFields().values())
            lookupFields.add(eachLookUpFields);

        compElements.setElementsHolder(new XSDComponentChildElementsHolder(curXSDComponent));

    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return new LookupFieldsAnnoInfo(curXSDComponent, compElements.getAnnotaionInfos());
    }

    @Override
    protected String getSectionTitle() {
        return "Lookup Fields";
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        compElements = new SelectElementsOfEntityComposite(compSectionClient, SWT.NONE, "Lookup Fields", null);
    }

}
