package com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.DefaultValueCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.SingleContentAnnotationInfo;

public class DefaultValueAnnoInfo extends SingleContentAnnotationInfo {

	public DefaultValueAnnoInfo(XSDComponent sourceComponent, String defaultValue) {
		super(sourceComponent, defaultValue);
	}

	public CommitHandler<DefaultValueAnnoInfo> createCommitHandler() {
 
		return new DefaultValueCommitHandler( this);
	}

}
