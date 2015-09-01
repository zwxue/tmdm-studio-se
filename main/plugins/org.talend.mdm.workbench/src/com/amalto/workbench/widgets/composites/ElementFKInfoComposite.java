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
package com.amalto.workbench.widgets.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.detailtabs.sections.XpathSection;

/**
 * created by liusongbo on Aug 31, 2015
 */
public class ElementFKInfoComposite extends XpathComposite {

    private Text formatText;

    private int caretPosition = 0;

    private String formatFKInfo = ""; //$NON-NLS-1$

    private ModifyListener modifyListener;

    private FormatFKInfoComp formatFkInfoComp;

    public ElementFKInfoComposite(Composite parent) {
        super(parent);
    }

    public ElementFKInfoComposite(Composite parent, int style, XpathSection section) {
        super(parent, style, section);
        createFormatFkUIArea(this);
    }

    protected void createFormatFkUIArea(Composite parent) {
        formatFkInfoComp = new FormatFKInfoComp(parent, SWT.NONE);
        GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
        layoutData.heightHint = 130;
        formatFkInfoComp.setLayoutData(layoutData);

        formatFkInfoComp.setFkinfos(infos);
        formatFkInfoComp.setFormatFKInfo(formatFKInfo);

        formatText = formatFkInfoComp.getFormatText();

        modifyListener = new ModifyListener() {


            public void modifyText(ModifyEvent e) {
                formatFKInfo = formatText.getText();
                caretPosition = formatText.getCaretPosition();

                if (section != null) {
                    section.autoCommit();
                }

            }
        };
    }

    private void addModifyListener() {
        formatText.addModifyListener(modifyListener);
    }

    private void removeModifyListener() {
        formatText.removeModifyListener(modifyListener);
    }

    @Override
    public void setContentChanged(boolean changed) {
        super.setContentChanged(changed);
        fireXPathsChanges();
    }

    @Override
    public void setInfos(String[] infos) {
        super.setInfos(infos);
        fireXPathsChanges();
    }

    private void fireXPathsChanges() {
        formatFkInfoComp.setFkinfos(infos);
    }

    public String getFormatFKInfo() {
        formatFKInfo = formatFkInfoComp.getFormatFKInfo();
        return formatFKInfo;
    }

    public void setFormatFKInfo(String formatedFkInfo) {
        this.formatFKInfo = formatedFkInfo;

        removeModifyListener();

        formatText.setText(formatFKInfo);
        formatText.setSelection(caretPosition);

        addModifyListener();
    }
}
