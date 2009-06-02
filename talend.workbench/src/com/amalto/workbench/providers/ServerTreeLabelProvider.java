package com.amalto.workbench.providers;


import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.ESystemDefaultObjects;
import com.amalto.workbench.utils.ImageCache;

public class ServerTreeLabelProvider extends LabelProvider implements IColorProvider,IFontProvider{
	
	ResourceManager resourceManager =  new LocalResourceManager(JFaceResources.getResources());
	FontData font = new FontData();
	RGB color = new RGB(150,150,150);
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
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	private IColorProvider colorProvider;
	
		public Color getForeground(Object element) {
			TreeObject tb = (TreeObject)element;
			if(ESystemDefaultObjects.isExist(tb.getType(),tb.getDisplayName())){
		        return resourceManager.createColor(ColorDescriptor.createFrom(color));
			}
			else
				return null;
	        
	}

	public Font getFont(Object element) {
		// TODO Auto-generated method stub

		TreeObject tb = (TreeObject)element;
		if(ESystemDefaultObjects.isExist(tb.getType(),tb.getDisplayName())){
			
			font.setStyle(SWT.BOLD);
	        return resourceManager.createFont(FontDescriptor.createFrom(font));
		}
		else
			return null;
        
	}
	
}
