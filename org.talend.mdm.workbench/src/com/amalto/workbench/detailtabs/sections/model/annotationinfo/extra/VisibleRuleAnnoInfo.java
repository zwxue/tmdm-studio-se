package com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.VisibleRuleCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.SingleContentAnnotationInfo;

public class VisibleRuleAnnoInfo extends SingleContentAnnotationInfo {

	public VisibleRuleAnnoInfo(XSDComponent sourceComponent, String defaultValue) {
		super(sourceComponent, defaultValue);
	}

	@Override
	public CommitHandler<VisibleRuleAnnoInfo> createCommitHandler() {
 
		return new VisibleRuleCommitHandler( this);
	}

}
