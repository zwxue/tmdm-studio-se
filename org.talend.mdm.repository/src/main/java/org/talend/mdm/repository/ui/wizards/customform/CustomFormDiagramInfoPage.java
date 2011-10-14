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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.models.CustomFormElement;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.widgets.XSDSchemaComposite;
import org.talend.mdm.repository.utils.EclipseResourceManager;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormDiagramInfoPage extends WizardPage {

    public static final String PAGE_ID = "org.talend.mdm.repository.ui.wizards.customform.CustomFormDiagramInfoPage"; //$NON-NLS-1$

    private XSDSchemaComposite schemaComposite;

    Image IMG_1COL = EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, "/icons/1column.gif"); //$NON-NLS-1$

    Image IMG_2COLS = EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, "/icons/2columns.gif"); //$NON-NLS-1$

    Image IMG_3COLS = EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, "/icons/3columns.gif"); //$NON-NLS-1$

    int columnCount = 1;

    private List<CustomFormElement> allElements;

    private CustomFormElement ancestor;

    public List<CustomFormElement> getAllElements() {
        return this.allElements;
    }

    public CustomFormElement getAncestor() {
        return ancestor;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    /**
     * Create the wizard.
     */
    public CustomFormDiagramInfoPage() {
        super(PAGE_ID);
        setTitle(Messages.CustomFormDiagramInfoPage_title);
        setDescription(Messages.CustomFormDiagramInfoPage_selectLayout);
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
        group.setText(Messages.CustomFormDiagramInfoPage_elementStructure);
        group.setLayout(new FillLayout(SWT.HORIZONTAL));
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        schemaComposite = new XSDSchemaComposite(group);

        Group columnGroup = new Group(container, SWT.NONE);
        columnGroup.setText(Messages.CustomFormDiagramInfoPage_layout);
        columnGroup.setLayout(new GridLayout(3, false));
        columnGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

        Button OneColBun = new Button(columnGroup, SWT.RADIO);
        OneColBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                columnCount = 1;
            }
        });
        GridData gd_OnecolBun = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_OnecolBun.horizontalIndent = 10;
        OneColBun.setLayoutData(gd_OnecolBun);
        OneColBun.setSelection(true);
        OneColBun.setText(Messages.CustomFormDiagramInfoPage_1column);

        Button twoColsBun = new Button(columnGroup, SWT.RADIO);
        GridData gd_twoColsBun = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_twoColsBun.horizontalIndent = 20;
        twoColsBun.setLayoutData(gd_twoColsBun);
        twoColsBun.setText(Messages.CustomFormDiagramInfoPage_2columns);
        twoColsBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                columnCount = 2;
            }
        });

        Button threeColsBun = new Button(columnGroup, SWT.RADIO);
        GridData gd_threeColsBun = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_threeColsBun.horizontalIndent = 20;
        threeColsBun.setLayoutData(gd_threeColsBun);
        threeColsBun.setText(Messages.CustomFormDiagramInfoPage_3columns);
        threeColsBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                columnCount = 3;
            }
        });
        CLabel col1 = new CLabel(columnGroup, SWT.NONE);
        GridData gd_col1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_col1.horizontalIndent = 20;
        col1.setLayoutData(gd_col1);
        col1.setImage(IMG_1COL);

        CLabel col2 = new CLabel(columnGroup, SWT.NONE);
        GridData gd_col2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_col2.horizontalIndent = 30;
        col2.setLayoutData(gd_col2);
        col2.setImage(IMG_2COLS);

        CLabel col3 = new CLabel(columnGroup, SWT.NONE);
        GridData gd_col3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_col3.horizontalIndent = 30;
        col3.setLayoutData(gd_col3);
        col3.setImage(IMG_3COLS);

    }

    public void updateDataModel(String dataModel, String entityName) {
        if (schemaComposite != null) {
            schemaComposite.updateModel(dataModel, entityName);
            allElements = schemaComposite.getAllElements();
            ancestor = schemaComposite.getAncestor();
        }
    }
}
