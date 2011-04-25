package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.DefaultValueAnnoInfo;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.VisibleRuleAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class VisibleRuleCommitHandler extends
		CommitHandler<VisibleRuleAnnoInfo> {

	public VisibleRuleCommitHandler(VisibleRuleAnnoInfo submittedObj) {
		super(submittedObj);
	}

	@Override
	protected void validateCommit() throws CommitValidationException {
	}

	@Override
	protected boolean doSubmit() throws CommitException {
		VisibleRuleAnnoInfo commitedObj = getCommitedObj();
		XSDAnnotationsStructure struc = new XSDAnnotationsStructure(
				commitedObj.getSourceXSDComponent());
		struc.setVisibleRule(commitedObj.getValue());
		return true;
	}

}
