package com.amalto.workbench.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.models.TreeObject;

public class ServerTreeLabelProvider extends LabelProvider {

	public String getText(Object obj) {
        if (obj instanceof TreeObject)
            if (((TreeObject)obj).getType() == TreeObject._ACTION_) {
                Class actionClass = (Class)((TreeObject)obj).getWsKey();
                try {
                    AServerViewAction action = (AServerViewAction)actionClass.newInstance();
                    return action.getText();
                } catch (Exception ex) {
                    return "ERROR...";
                }
            }
                
		return obj.toString();
	}
	
	public Image getImage(Object obj) {
		//if (obj instanceof TreeParent) {
			TreeObject  object = (TreeObject)obj;
			if (object.getType() == TreeObject._SERVER_)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/xtentis_server.gif").createImage();
			else if (object.getType() == TreeObject.DATA_CLUSTER)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/data_cluster.gif").createImage();
			else if (object.getType() == TreeObject.DATA_MODEL)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/data_model.gif").createImage();
			else if (object.getType() == TreeObject.MENU)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/menu.gif").createImage();
			else if (object.getType() == TreeObject.TRANSFORMER)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/transformer.gif").createImage();
			else if (object.getType() == TreeObject.ROLE)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/role.gif").createImage();
			else if (object.getType() == TreeObject.STORED_PROCEDURE)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/stored_procedure.gif").createImage();
			else if (object.getType() == TreeObject.ROUTING_RULE)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/routing_rule.gif").createImage();
			else if (object.getType() == TreeObject.VIEW)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/view.gif").createImage();
			else if (object.getType() == TreeObject.DOCUMENT)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/documents.gif").createImage();			
			else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
				return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/routing_rule.gif").createImage();
			//return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);

			
			return AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/phased_out.gif").createImage();
		//}
			
		/*
		if (((TreeObject)obj).getType() == TreeObject._ACTION_) {
            Class actionClass = (Class)((TreeObject)obj).getWsKey();
            try {
                AServerViewAction action = (AServerViewAction)actionClass.newInstance();
                return action.getImageDescriptor().createImage();
            } catch (Exception ex) {
                return null;
            }
        }
	
        return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
        */       
		
	}
	
}
