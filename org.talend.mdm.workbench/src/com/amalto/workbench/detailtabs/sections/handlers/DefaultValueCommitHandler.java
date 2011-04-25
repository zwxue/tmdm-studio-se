package com.amalto.workbench.detailtabs.sections.handlers;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra.DefaultValueAnnoInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class DefaultValueCommitHandler extends
		CommitHandler<DefaultValueAnnoInfo> {

	public DefaultValueCommitHandler(DefaultValueAnnoInfo submittedObj) {
		super(submittedObj);
	}

	@Override
	protected void validateCommit() throws CommitValidationException {
	}

	@Override
	protected boolean doSubmit() throws CommitException {
		DefaultValueAnnoInfo commitedObj = getCommitedObj();
		XSDAnnotationsStructure struc = new XSDAnnotationsStructure(
				commitedObj.getSourceXSDComponent());
		struc.setDefaultValueRule(commitedObj.getValue());
		return true;
	}

}
