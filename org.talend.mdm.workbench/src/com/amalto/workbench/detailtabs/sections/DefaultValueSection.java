package com.amalto.workbench.detailtabs.sections;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.DefaultValueAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class DefaultValueSection extends AbstractValidateRuleExpressionSection {

	DefaultValueAnnoInfo annoInfo;

	@Override
	protected ISubmittable getSubmittedObj() {
		annoInfo = new DefaultValueAnnoInfo(curXSDComponent,
				getDefaultValueFromUI());
		return annoInfo;
	}

	@Override
	protected String getSectionTitle() {
		return "Default Value";
	}
	protected String getInitRule(){
		XSDAnnotationsStructure struc = new XSDAnnotationsStructure(getEditedObj());
		return struc.getDefaultValueRule();
	}
  

}
