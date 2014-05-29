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
package com.amalto.workbench.editors.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDXPathDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.utils.Util;


/**
 * created by liusongbo on 2014-5-14
 */
public class EditRecordDialog extends Dialog {

    private Text textViewer;

    private String records;

    private Map<String, String> id2Records = new HashMap<String, String>();

    private String modelSchema;

    private String entity;

    private List<String> pkNames;

    public EditRecordDialog(Shell parentShell, String modelSchema, String entity) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.modelSchema = modelSchema;
        this.entity = entity;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(600, 550);
        newShell.setText(Messages.EditRecordDialog_editRecords);
    }

    @Override
    protected void initializeBounds() {
        super.initializeBounds();
        Point location = getInitialLocation(getShell().getSize());
        getShell().setLocation(location.x, location.y);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite mainpart = (Composite) super.createDialogArea(parent);
        createEditablePart(mainpart);
        init();
        return mainpart;
    }

    private void createEditablePart(Composite parent) {
        textViewer = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
        textViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    private void init() {
        textViewer.setText(records);
    }

    @Override
    protected void okPressed() {
        String errorMsg = prepairDatas();
        if (errorMsg != null) {
            MessageDialog.openError(getShell(), Messages._Error, errorMsg);
            return;
        }

        super.okPressed();
    }

    private String prepairDatas() {
        String errorMsg = null;
        id2Records.clear();

        records = textViewer.getText();
        if (records.trim().isEmpty()) {
            errorMsg = Messages.EditRecordDialog_requiredAtLeastTwoRecords;
        } else {
            try {
                String regex = "<" + entity; //$NON-NLS-1$
                String[] split = records.split(regex);

                List<String> records_check = new ArrayList<String>();
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].trim().isEmpty()) {
                        records_check.add(regex + split[i].trim());
                    }
                }

                if (records_check.size() < 2) {
                    errorMsg = Messages.EditRecordDialog_requiredAtLeastTwoRecords;
                } else {
                    for (String record : records_check) {
                        Document doc = Util.parse(record);// if throw an exception, imply it is not a valid record

                        // check if pk fields exist
                        NodeList childNodes = doc.getDocumentElement().getChildNodes();
                        if (childNodes.getLength() == 0) {
                            errorMsg = Messages.EditRecordDialog_atLeastOneRecordNotValid;
                            break;
                        }

                        List<String> elementTags = new ArrayList<String>();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            elementTags.add(childNodes.item(j).getNodeName());
                        }

                        List<String> pkNames = getPkNames();

                        List<String> tmps = new ArrayList<String>(pkNames);
                        tmps.removeAll(elementTags);
                        if (!tmps.isEmpty()) {
                            errorMsg = Messages.EditRecordDialog_atLeastOneRecordNotValid;
                            break;
                        }

                        int count = 0;
                        boolean idValid = true;
                        String[] ids = new String[pkNames.size()];
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            if (pkNames.contains(childNodes.item(j).getNodeName())) {
                                String textContent = childNodes.item(j).getTextContent();
                                if (textContent.trim().isEmpty()) {
                                    errorMsg = Messages.EditRecordDialog_atLeastOneRecordNotValid;
                                    idValid = false;
                                    break;
                                }
                                ids[count++] = textContent;
                            }
                        }
                        if (idValid) {
                            String joinIds = Util.joinStrings(ids, "."); //$NON-NLS-1$
                            id2Records.put(joinIds, record);
                        }
                    }
                }
            } catch (Exception e) {
                errorMsg = Messages.EditRecordDialog_atLeastOneRecordNotValid;
            }
        }


        return errorMsg;
    }

    private List<String> getPkNames() throws Exception {
        if (pkNames == null) {
            pkNames = new ArrayList<String>();
            XSDSchema xsdSchema = Util.getXSDSchema(modelSchema);
            XSDElementDeclaration elementDeclaration = xsdSchema.resolveElementDeclaration(entity);
            EList<XSDIdentityConstraintDefinition> identityConstraints = elementDeclaration.getIdentityConstraintDefinitions();
            for (int i = 0; i < identityConstraints.size(); i++) {
                EList<XSDXPathDefinition> fields = identityConstraints.get(i).getFields();
                for (int j = 0; j < fields.size(); j++) {
                    String value = fields.get(j).getValue();
                    pkNames.add(value);
                }
            }
        }

        return pkNames;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public Map<String, String> getId2Records() {
        return id2Records;
    }
}
