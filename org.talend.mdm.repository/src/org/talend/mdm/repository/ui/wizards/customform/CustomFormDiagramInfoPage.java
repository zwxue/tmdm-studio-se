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
package org.talend.mdm.repository.ui.wizards.customform;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.talend.mdm.repository.models.CustomFormElement;
import org.talend.mdm.repository.ui.widgets.XSDSchemaComposite;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormDiagramInfoPage extends WizardPage {

    public static final String PAGE_ID = "org.talend.mdm.repository.ui.wizards.customform.CustomFormDiagramInfoPage"; //$NON-NLS-1$

    private XSDSchemaComposite schemaComposite;

    /**
     * Create the wizard.
     */
    public CustomFormDiagramInfoPage() {
        super(PAGE_ID);
        setTitle("Wizard Page title");
        setDescription("Wizard Page description");
    }

    /**
     * Create contents of the wizard.
     * 
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(1, false));

        Group group = new Group(container, SWT.NONE);
        group.setLayout(new FillLayout(SWT.HORIZONTAL));
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        schemaComposite = new XSDSchemaComposite(group);

        Group columnGroup = new Group(container, SWT.NONE);
        columnGroup.setText("Column Count");
        RowLayout rl_columnGroup = new RowLayout(SWT.HORIZONTAL);
        rl_columnGroup.spacing = 10;
        columnGroup.setLayout(rl_columnGroup);
        columnGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        Button OnecolBun = new Button(columnGroup, SWT.RADIO);
        OnecolBun.setSelection(true);
        OnecolBun.setText("1 Column");

        Button twoColsBun = new Button(columnGroup, SWT.RADIO);
        twoColsBun.setText("2 Columns");

        Button threeColsBun = new Button(columnGroup, SWT.RADIO);
        threeColsBun.setText("3 Columns");
    }

    public void updateDataModel(String dataModel, String entityName) {
        schemaComposite.updateModel(dataModel, entityName);
        List<CustomFormElement> allElements = schemaComposite.getAllElements();

    }
}
