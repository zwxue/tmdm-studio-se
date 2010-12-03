package com.amalto.workbench.providers.datamodel.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.utils.SchemaElementNameFilterDes;

class SchemaTopElementNameSelectorOnPattern implements SchemaTopElementNameSelector {

	protected SchemaItemLabelCreator labelExtractor;
	protected SchemaElementNameFilterDes nameFitlerDes;
	protected List<Pattern> patterns = new ArrayList<Pattern>();
	
	protected SchemaTopElementNameSelectorOnPattern(SchemaItemLabelCreator labelExtractor,
			SchemaElementNameFilterDes nameFitlerDes){
		
		this.labelExtractor = labelExtractor;
		this.nameFitlerDes = nameFitlerDes;
		
		initPatterns(nameFitlerDes);
	}
	
	@Override
	public boolean isSatisfiedElement(Object parentElement, Object element) {
		
		if(nameFitlerDes == null || !nameFitlerDes.isEnable())
			return true;
		
		if(isTopElement(element))
			return checkElementLabel(element);
			
		return true;
	}

	private boolean checkElementLabel(Object element) {
		
		for(Pattern eachPattern : patterns) {
			Matcher matcher = eachPattern.matcher(labelExtractor.getLabel(element));
			if(matcher.matches())
				return false;
		}
		
		return true;
	}
	
	protected boolean isTopElement(Object element){
		return (element instanceof XSDElementDeclaration);
	}
	
	private void initPatterns(SchemaElementNameFilterDes nameFitlerDes) {
		for(String eachPattern : nameFitlerDes.getSeparatedFilterExpressions()){
			eachPattern = eachPattern.replaceAll("\\*", ".*");
			eachPattern = eachPattern.replaceAll("\\+", ".+");
			eachPattern = eachPattern.replaceAll("\\?", ".?");
			patterns.add(Pattern.compile(eachPattern));  
		}
	}
}
