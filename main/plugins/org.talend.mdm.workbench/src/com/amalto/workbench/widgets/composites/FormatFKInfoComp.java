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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.i18n.Messages;


/**
 * created by liusongbo on Sep 1, 2015
 *
 */
public class FormatFKInfoComp extends Composite {
    private static final String delimiter = "$$"; //$NON-NLS-1$
    
    private Text formatText;

    private List fkInfosList;
    
    public FormatFKInfoComp(Composite parent, int style) {
        super(parent, style);
        GridLayout layout = new GridLayout();
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        setLayout(layout);
        createControl(this);
    }

    private void createControl(Composite parent) {
        Group formatGroup = new Group(this, SWT.NONE);
        GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
        formatGroup.setLayoutData(layoutData);
        formatGroup.setLayout(new GridLayout(3, true));
        formatGroup.setText(Messages.FormatFKInfoComp_format);

        formatText = new Text(formatGroup, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
        formatText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 6));

        Label xpaths = new Label(formatGroup, SWT.NONE);
        xpaths.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 2));
        xpaths.setText(Messages.FormatFKInfoComp_availablexpath);

        fkInfosList = new List(formatGroup, SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE);
        fkInfosList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
        fkInfosList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                formatText.insert(delimiter + fkInfosList.getSelection()[0] + delimiter);
            }
        });
    }

    public void setFkinfos(java.util.List<String> fkinfos) {
        fkInfosList.setItems(fkinfos.toArray(new String[0]));
    }

    public void setFormatFKInfo(String formatFKInfo) {
        formatText.setText(formatFKInfo);
    }

    public String getFormatFKInfo() {
        return formatText.getText();
    }

    public Text getFormatText() {
        return formatText;
    }
}
