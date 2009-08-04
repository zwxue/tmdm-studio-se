package com.amalto.workbench.providers;


import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.ESystemDefaultObjects;
import com.amalto.workbench.utils.FontUtils;
import com.amalto.workbench.utils.ImageCache;

public class ServerTreeLabelProvider extends LabelProvider implements IColorProvider,IFontProvider{
	
	//ResourceManager resourceManager =  new LocalResourceManager(JFaceResources.getResources());
	Font font=FontUtils.getBoldFont(Display.getCurrent().getSystemFont());
	Color color = new Color(null,150,150,150);
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
				return ImageCache.getCreatedImage( "icons/talend-picto-small.gif");
			else if (object.getType() == TreeObject.DATA_CLUSTER)
				return ImageCache.getCreatedImage( "icons/data_cluster.gif");
			else if (object.getType() == TreeObject.DATA_MODEL)
				return ImageCache.getCreatedImage( "icons/data_model.gif");
			else if (object.getType() == TreeObject.MENU)
				return ImageCache.getCreatedImage( "icons/menu.gif");
			else if (object.getType() == TreeObject.TRANSFORMER)
				return ImageCache.getCreatedImage( "icons/transformer.gif");
			else if (object.getType() == TreeObject.ROLE)
				return ImageCache.getCreatedImage( "icons/role.gif");
			else if (object.getType() == TreeObject.STORED_PROCEDURE)
				return ImageCache.getCreatedImage( "icons/stored_procedure.gif");
			else if (object.getType() == TreeObject.ROUTING_RULE)
				return ImageCache.getCreatedImage( "icons/routing_rule.gif");
			else if (object.getType() == TreeObject.VIEW)
				return ImageCache.getCreatedImage( "icons/view.gif");
			else if (object.getType() == TreeObject.DOCUMENT)
				return ImageCache.getCreatedImage( "icons/documents.gif");			
			else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
				return ImageCache.getCreatedImage( "icons/routing_rule.gif");
			else if (object.getType() == TreeObject.UNIVERSE)
				return ImageCache.getCreatedImage( "icons/unique.gif");		
			else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
				return ImageCache.getCreatedImage( "icons/catchuprelease_rls.gif");	
			else if (object.getType() == TreeObject.CATEGORY_FOLDER)
				return ImageCache.getCreatedImage( "icons/folder.gif");
			
				
			//return PlatformUI.getWorkbench().getSharedImages().getCreatedImage(ISharedImages.IMG_OBJ_ELEMENT);

			
			return ImageCache.getCreatedImage( "icons/phased_out.gif");
		//}
			
		/*
		if (((TreeObject)obj).getType() == TreeObject._ACTION_) {
            Class actionClass = (Class)((TreeObject)obj).getWsKey();
            try {
                AServerViewAction action = (AServerViewAction)actionClass.newInstance();
                return action.getCreatedImageDescriptor();
            } catch (Exception ex) {
                return null;
            }
        }
	
        return PlatformUI.getWorkbench().getSharedImages().getCreatedImage(ISharedImages.IMG_OBJ_ELEMENT);
        */       
		
   }
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	private IColorProvider colorProvider;
	
		public Color getForeground(Object element) {
			TreeObject tb = (TreeObject)element;
			if(ESystemDefaultObjects.isExist(tb.getType(),tb.getDisplayName())){
		        return color;
			}
			else
				return null;
	        
	}

	public Font getFont(Object element) {
		// TODO Auto-generated method stub

		TreeObject tb = (TreeObject)element;
		if(ESystemDefaultObjects.isExist(tb.getType(),tb.getDisplayName())){			
	        return font;
		}
		else
			return null;
        
	}
	
}
