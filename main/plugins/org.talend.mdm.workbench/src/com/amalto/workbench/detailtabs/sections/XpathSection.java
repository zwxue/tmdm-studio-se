package com.amalto.workbench.detailtabs.sections;

import java.util.Set;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;

public abstract class XpathSection extends XSDComponentSection {

	public String getDataModelName(){
		return super.getDataModelName();
	}
	
	public abstract Set<String> getEntities();
	
	public abstract IAllDataModelHolder getDataHolder();
	
	protected abstract ISubmittable getSubmittedObj();

	@Override
	protected void createControlsInSection(Composite compSectionClient) {
		// TODO Auto-generated method stub

	}

}
