// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.views.ServerView;

public class DuplicateXObjectAction extends Action {

    private ServerView view;

    public DuplicateXObjectAction(ServerView view) {
        super();
        this.view = view;
        setDetails();
    }

    @Override
    public void run() {
        super.run();
        new CopyXObjectAction(view).run();
        new PasteXObjectAction(view).run();
    }

    private void setDetails() {
        setImageDescriptor(ImageCache.getImage(EImage.DUPLICATE.getPath()));
        setText(Messages.DuplicateXObjectAction_Duplicate);
        setToolTipText(Messages.bind(Messages.DuplicateXObjectAction_DuplicateTip, IConstants.TALEND));
    }
}
