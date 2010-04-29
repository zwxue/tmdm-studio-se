package com.amalto.workbench.views;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.amalto.workbench.availablemodel.AvailableModelUtil;

public class MDMPerspective implements IPerspectiveFactory {
	public static final String PERPECTIVE_ID="org.talend.mdm.perspective";

	public void createInitialLayout(IPageLayout layout) {
		//scan availabelmodel extention point
    	AvailableModelUtil.getAvailableModels();		
        // leftTopLayout
        IFolderLayout leftTopLayout = layout.createFolder("navigatorLayout", IPageLayout.LEFT, new Float(0.32), IPageLayout.ID_EDITOR_AREA);
        leftTopLayout.addView(ServerView.VIEW_ID);
        
		layout.setEditorAreaVisible(true);
		
	}
	
}
