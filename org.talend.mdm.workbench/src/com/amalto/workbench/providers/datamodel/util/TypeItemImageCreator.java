package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Element;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class TypeItemImageCreator extends SchemaItemImageCreator {

	private static TypeItemImageCreator INSTANCE;

	protected TypeItemImageCreator() {}

	public static synchronized SchemaItemImageCreator getInstance() {

		if (INSTANCE == null)
			INSTANCE = new TypeItemImageCreator();

		return INSTANCE;
	}
	
	@Override
	protected Image getImageForUnknown() {
		return ImageCache.getCreatedImage( EImage.TREE_OBJECT.getPath());
	}
	
	@Override
	protected Image getImageForElement(Element element) {
		
		try {
			if ("documentation".equals(element.getLocalName())) 
				return ImageCache.getCreatedImage( EImage.DOCUMENTATION.getPath());
			
			if ("appinfo".equals(element.getLocalName())) {
				String source = element.getAttribute("source");
				if (source!=null) {
					if (source.startsWith("X_Label_"))
						return ImageCache.getCreatedImage( EImage.LABEL.getPath());
					
					if (source.equals("X_ForeignKey"))
						return ImageCache.getCreatedImage( EImage.PRIMARYKEY.getPath());
					
					if (source.equals("X_ForeignKeyInfo"))
						return ImageCache.getCreatedImage( EImage.KEYINFO.getPath());
					
					if (source.equals("X_SourceSystem"))
						return ImageCache.getCreatedImage( EImage.SOURCESYSTEM.getPath());
					
					if (source.equals("X_TargetSystem"))
						return ImageCache.getCreatedImage( EImage.TARGETSYSTEM.getPath());
					
					if (source.startsWith("X_Description_"))
						return ImageCache.getCreatedImage( EImage.DOCUMENTATION.getPath());
					
					if (source.equals("X_Write"))
						return ImageCache.getCreatedImage( EImage.SECURITYANNOTATION.getPath());
					
					if (source.equals("X_Hide"))
						return ImageCache.getCreatedImage( EImage.SECURITYANNOTATION.getPath());
				}
			}
			
			return ImageCache.getCreatedImage( EImage.DOCUMENTATION.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getImageForUnknown();
	}
}
