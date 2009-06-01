package com.amalto.workbench.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.ImageCache;

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
				return ImageCache.getImage( "icons/talend-picto-small.gif").createImage();
			else if (object.getType() == TreeObject.DATA_CLUSTER)
				return ImageCache.getImage( "icons/data_cluster.gif").createImage();
			else if (object.getType() == TreeObject.DATA_MODEL)
				return ImageCache.getImage( "icons/data_model.gif").createImage();
			else if (object.getType() == TreeObject.MENU)
				return ImageCache.getImage( "icons/menu.gif").createImage();
			else if (object.getType() == TreeObject.TRANSFORMER)
				return ImageCache.getImage( "icons/transformer.gif").createImage();
			else if (object.getType() == TreeObject.ROLE)
				return ImageCache.getImage( "icons/role.gif").createImage();
			else if (object.getType() == TreeObject.STORED_PROCEDURE)
				return ImageCache.getImage( "icons/stored_procedure.gif").createImage();
			else if (object.getType() == TreeObject.ROUTING_RULE)
				return ImageCache.getImage( "icons/routing_rule.gif").createImage();
			else if (object.getType() == TreeObject.VIEW)
				return ImageCache.getImage( "icons/view.gif").createImage();
			else if (object.getType() == TreeObject.DOCUMENT)
				return ImageCache.getImage( "icons/documents.gif").createImage();			
			else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
				return ImageCache.getImage( "icons/routing_rule.gif").createImage();
			else if (object.getType() == TreeObject.UNIVERSE)
				return ImageCache.getImage( "icons/unique.gif").createImage();		
			else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
				return ImageCache.getImage( "icons/catchuprelease_rls.gif").createImage();	
			
			//return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);

			
			return ImageCache.getImage( "icons/phased_out.gif").createImage();
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
