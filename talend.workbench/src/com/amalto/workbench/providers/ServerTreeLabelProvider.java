package com.amalto.workbench.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.amalto.workbench.AmaltoWorbenchPlugin;
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
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/talend-picto-small.gif").createImage();
			else if (object.getType() == TreeObject.DATA_CLUSTER)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/data_cluster.gif").createImage();
			else if (object.getType() == TreeObject.DATA_MODEL)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/data_model.gif").createImage();
			else if (object.getType() == TreeObject.MENU)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/menu.gif").createImage();
			else if (object.getType() == TreeObject.TRANSFORMER)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/transformer.gif").createImage();
			else if (object.getType() == TreeObject.ROLE)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/role.gif").createImage();
			else if (object.getType() == TreeObject.STORED_PROCEDURE)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/stored_procedure.gif").createImage();
			else if (object.getType() == TreeObject.ROUTING_RULE)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/routing_rule.gif").createImage();
			else if (object.getType() == TreeObject.VIEW)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/view.gif").createImage();
			else if (object.getType() == TreeObject.DOCUMENT)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/documents.gif").createImage();			
			else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/routing_rule.gif").createImage();
			else if (object.getType() == TreeObject.UNIVERSE)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/unique.gif").createImage();		
			else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
				return AmaltoWorbenchPlugin.getImageDescriptor( "icons/catchuprelease_rls.gif").createImage();	
			
			//return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);

			
			return AmaltoWorbenchPlugin.getImageDescriptor( "icons/phased_out.gif").createImage();
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
