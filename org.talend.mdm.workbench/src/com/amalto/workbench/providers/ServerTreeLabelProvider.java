package com.amalto.workbench.providers;


import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;

import com.amalto.workbench.actions.AServerViewAction;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.image.OverlayImageProvider;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.EXObjectStatus;
import com.amalto.workbench.utils.FontUtils;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSGetRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;

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
				return ImageCache.getCreatedImage( EImage.DEFAULT.getPath());
			else if (object.getType() == TreeObject.DATA_CLUSTER)
				return ImageCache.getCreatedImage( EImage.DATA_CLUSTER.getPath());
			else if (object.getType() == TreeObject.DATA_MODEL)
				return ImageCache.getCreatedImage( EImage.DATA_MODEL.getPath());
			else if (object.getType() == TreeObject.RESOURCES
				|| object.getType() == TreeObject.DATA_MODEL_RESOURCE
				|| object.getType() == TreeObject.DATA_MODEL_TYPES_RESOURCE
				|| object.getType() == TreeObject.CUSTOM_TYPES_RESOURCE
				|| object.getType() == TreeObject.PICTURES_RESOURCE)
				return ImageCache.getCreatedImage(EImage.RESOURCES.getPath());
			else if (object.getType() == TreeObject.MENU)
				return ImageCache.getCreatedImage( EImage.MENU.getPath());
			else if (object.getType() == TreeObject.TRANSFORMER)
				return ImageCache.getCreatedImage( EImage.TRANSFORMER.getPath());
			else if (object.getType() == TreeObject.ROLE)
				return ImageCache.getCreatedImage( EImage.ROLE.getPath());
			else if (object.getType() == TreeObject.STORED_PROCEDURE)
				return ImageCache.getCreatedImage( EImage.STORED_PROCEDURE.getPath());
			else if (object.getType() == TreeObject.ROUTING_RULE)
			{
				Image img= ImageCache.getCreatedImage( EImage.ROUTING_RULE.getPath());
				if(object.isXObject()){
					WSRoutingRule ws = (WSRoutingRule) (object.getWsObject());
					try {
						if(ws==null)
						ws=Util.getPort(object).getRoutingRule(new WSGetRoutingRule(new WSRoutingRulePK(object.getDisplayName())));
					} catch(Exception e) {}
					
					if(ws!=null && ws.getDeactive()!=null && ws.getDeactive().booleanValue()){
						img=OverlayImageProvider.getImageWithStatus(img, EXObjectStatus.DEACTIVE);
					}				
				}
				return img;
			}
			else if (object.getType() == TreeObject.VIEW)
				return ImageCache.getCreatedImage( EImage.VIEW.getPath());
			else if (object.getType() == TreeObject.DOCUMENT)
				return ImageCache.getCreatedImage( EImage.DOCUMENTS.getPath());			
			else if (object.getType() == TreeObject.SUBSCRIPTION_ENGINE)
				return ImageCache.getCreatedImage( EImage.SUBSCRIPTION_ENGINE.getPath());
			else if (object.getType() == TreeObject.EVENT_MANAGEMENT)
				return ImageCache.getCreatedImage( EImage.EVENTM_ANAGEMENT.getPath());			
			else if (object.getType() == TreeObject.WORKFLOW || object.getType() == TreeObject.WORKFLOW_PROCESS)
				return ImageCache.getCreatedImage( EImage.WORKFLOW_PROCESS.getPath());
			else if (object.getType() == TreeObject.JOB_REGISTRY || object.getType() == TreeObject.JOB)
				return ImageCache.getCreatedImage( EImage.JOB.getPath());			
			else if (object.getType() == TreeObject.SERVICE_CONFIGURATION)
				return ImageCache.getCreatedImage( EImage.SERVICE_CONFIGURATION.getPath());
			else if (object.getType() == TreeObject.UNIVERSE)
				return ImageCache.getCreatedImage( EImage.UNIVERSE.getPath());		
			else if (object.getType() == TreeObject.SYNCHRONIZATIONPLAN)
				return ImageCache.getCreatedImage( EImage.SYNCHRONIZATIONPLAN.getPath());	
			else if (object.getType() == TreeObject.CATEGORY_FOLDER)
				return ImageCache.getCreatedImage( "icons/folder.gif");
								
			return ImageCache.getCreatedImage( "icons/phased_out.gif");   
		
   }
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	private IColorProvider colorProvider;
	
		public Color getForeground(Object element) {
			TreeObject tb = (TreeObject)element;
			if(XSystemObjects.isExist(tb.getType(),tb.getDisplayName())){
		        return color;
			}
			else
				return null;
	        
	}

	public Font getFont(Object element) {
		// TODO Auto-generated method stub

		TreeObject tb = (TreeObject)element;
		if(XSystemObjects.isExist(tb.getType(),tb.getDisplayName())){			
	        return font;
		}
		else
			return null;
        
	}
	
}
