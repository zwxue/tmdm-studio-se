// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections.handlers;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyComposite;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyTitle;

import com.amalto.workbench.detailtabs.sections.BasePropertySection;
import com.amalto.workbench.providers.datamodel.util.SchemaItemImageCreator;
import com.amalto.workbench.providers.datamodel.util.SchemaItemLabelCreator;

/**
 * created by liusongbo on 2012-11-28
 * 
 */
public class RefreshPropertySheetTitleHandler {

    public static void refreshPropertySheetTitle(BasePropertySection section, Object obj) {
        TabbedPropertyComposite control = (TabbedPropertyComposite) section.getTabbedPropertySheetPage().getControl();
        TabbedPropertyTitle title = control.getTitle();
        String label = SchemaItemLabelCreator.getInstance().getLabel(obj);
        Image image = SchemaItemImageCreator.getInstance().getImage(obj);
        title.setTitle(label, image);
    }

}
