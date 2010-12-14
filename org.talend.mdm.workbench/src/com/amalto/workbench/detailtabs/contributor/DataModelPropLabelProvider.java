package com.amalto.workbench.detailtabs.contributor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.graphics.Image;

import com.amalto.workbench.providers.datamodel.util.SchemaItemImageCreator;
import com.amalto.workbench.providers.datamodel.util.SchemaItemLabelCreator;

public class DataModelPropLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		
		if(element instanceof TreeSelection)
			return SchemaItemImageCreator.getInstance().getImage(((TreeSelection)element).getFirstElement());
		
		return SchemaItemImageCreator.getInstance().getImage(element);
	}

	public String getText(Object element) {
		
		if(element instanceof TreeSelection)
			return SchemaItemLabelCreator.getInstance().getLabel(((TreeSelection)element).getFirstElement());
		
		return SchemaItemLabelCreator.getInstance().getLabel(element);
	}

	public void addListener(ILabelProviderListener listener) {}

	public void dispose() {}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {}

}
