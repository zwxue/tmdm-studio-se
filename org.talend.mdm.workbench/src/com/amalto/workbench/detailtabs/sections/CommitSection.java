// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabSelectionListener;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite;
import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite.CommitBarListener;
import com.amalto.workbench.detailtabs.sections.util.CommitBarListenerRegistry;

public class CommitSection extends BasePropertySection {

    private CommitBarComposite commitBar;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        initUIListeners();

        registListenersFromGlobalRegistry();
    }

    @Override
    public boolean shouldUseExtraSpace() {
        return true;
    }

    private void addCommbarListeners() {

        for (ISection eachSelection : getCurrentTabSections()) {

            if (!(eachSelection instanceof BasePropertySection))
                continue;

            if (!(eachSelection instanceof CommitBarListener))
                continue;

            if (!((BasePropertySection) eachSelection).getParentTabID().equals(getParentTabID()))
                continue;

            commitBar.addCommitListener((CommitBarListener) eachSelection);
        }

    }

    private void initUIListeners() {

        tabbedPropertySheetPage.addTabSelectionListener(new ITabSelectionListener() {

            public void tabSelected(ITabDescriptor tabDescriptor) {

                if (tabDescriptor.getId().equals(getParentTabID()))
                    addCommbarListeners();
            }
        });
    }

    private void registListenersFromGlobalRegistry() {

        for (CommitBarListener eachListener : CommitBarListenerRegistry.getInstance().moveOutRegistedListeners(getParentTabID())) {
            commitBar.addCommitListener(eachListener);
        }
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        commitBar = new CommitBarComposite(compSectionClient, SWT.NONE);
    }

    @Override
    protected String getSectionTitle() {
        return "Commit";
    }

    @Override
    protected int getSectionStyle() {
        return Section.TITLE_BAR | Section.EXPANDED;
    }
}
