package com.amalto.workbench.providers.datamodel;

import com.amalto.workbench.providers.datamodel.util.SchemaTopElementNameSelectorFactory;
import com.amalto.workbench.providers.datamodel.util.TypeItemLabelCreator;
import com.amalto.workbench.utils.SchemaElementNameFilterDes;

public class TypeNameFilter extends SchemaNameFilter {

	public TypeNameFilter(){
		super();
	}
	
	public TypeNameFilter(SchemaElementNameFilterDes nameFilterDes) {
		super(nameFilterDes);
	}

	@Override
	public void setNameFilterDes(SchemaElementNameFilterDes nameFilterDes) {
		
		selector = SchemaTopElementNameSelectorFactory.getInstance()
					.createSchemaTopElementNameSelectorOnPattern(
						TypeItemLabelCreator.getInstance(), nameFilterDes);
		
	}
}
