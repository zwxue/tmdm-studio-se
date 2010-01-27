package com.amalto.workbench.availablemodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;


public class AvailableModelUtil {
	
	public static List<IAvailableModel> getAvailableModels(){
		try{
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IConfigurationElement[] configurationElements = registry
                .getConfigurationElementsFor("org.talend.mdm.workbench.AvailableModel"); //$NON-NLS-1$
        List<IAvailableModel> models=new ArrayList<IAvailableModel>();
        for (int i = 0; i < configurationElements.length; i++) {
            IConfigurationElement element = configurationElements[i];

            IAvailableModel modelcalss=(IAvailableModel)element.createExecutableExtension("class");

            models.add(modelcalss);
        }
        
        return models;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList<IAvailableModel>();
	}
}
