package com.amalto.workbench.detailtabs.sections;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.DefaultValueAnnoInfo;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.VisibleRuleAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class VisibleRuleSection extends AbstractValidateRuleExpressionSection {

	VisibleRuleAnnoInfo annoInfo;

	@Override
	protected ISubmittable getSubmittedObj() {
		annoInfo = new VisibleRuleAnnoInfo(curXSDComponent,
				getDefaultValueFromUI());
		return annoInfo;
	}

	@Override
	protected String getSectionTitle() {
		return "Visible Rule";
	}

	@Override
	protected String getInitRule() {
			XSDAnnotationsStructure struc = new XSDAnnotationsStructure(getEditedObj());
			return struc.getVisibleRule();
	}

  

}
