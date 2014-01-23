// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.dialogs.datacontainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.i18n.Messages;

public class UpdateAutoIncrementDialog extends Dialog {

    private Map<String, String> results = new HashMap<String, String>();

    private Map<String, String> entityValues;

    private ModifyListener modifyListener;

    private VerifyListener verifyListeneer;

    public UpdateAutoIncrementDialog(Shell parentShell, Map<String, String> entityValues) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.entityValues = entityValues;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.UpdateAutoIncrementDialog_ManageAutoIncrement);
    }

    @Override
    protected void initializeBounds() {
        super.initializeBounds();
        getShell().setSize(350, getInitialSize().y);
        Point location = getInitialLocation(getShell().getSize());
        getShell().setLocation(location.x, location.y);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite mainComp = (Composite) super.createDialogArea(parent);
        mainComp.setLayout(new GridLayout(2, false));
        Label entityLabel = new Label(mainComp, SWT.NONE);
        entityLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        entityLabel.setText(Messages.UpdateAutoIncrementDialog_entity);

        Label valueLabel = new Label(mainComp, SWT.NONE);
        valueLabel.setText(Messages.UpdateAutoIncrementDialog_AutoIncrement);
        valueLabel.setLayoutData(new GridData());

        createMainPart(mainComp);

        return mainComp;
    }

    private void createMainPart(Composite mainComp) {
        Iterator<String> iterator = entityValues.keySet().iterator();

        Label entityLabel = null;
        Text valueText = null;
        while (iterator.hasNext()) {
            String entity = iterator.next();
            entityLabel = new Label(mainComp, SWT.NONE);
            entityLabel.setText(entity);

            valueText = new Text(mainComp, SWT.BORDER);
            valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            valueText.setData(entity);
            valueText.setText(entityValues.get(entity));
            valueText.addModifyListener(getModifyListener());
            valueText.addVerifyListener(getVerifyListener());
            valueText.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseUp(MouseEvent e) {
                    Text text = (Text) e.getSource();
                    if (text.getSelectionCount() > 0) {
                        Point selection = text.getSelection();
                        text.setSelection(selection.x);
                    }
                    super.mouseUp(e);
                }
            });
        }
    }

    private ModifyListener getModifyListener() {
        if (modifyListener == null) {
            modifyListener = new ModifyListener() {

                public void modifyText(ModifyEvent e) {
                    Text text = (Text) e.getSource();
                    String entity = (String) text.getData();
                    results.put(entity, text.getText().trim());
                }
            };
        }
        return modifyListener;
    }

    private VerifyListener getVerifyListener() {
        if (verifyListeneer == null) {
            verifyListeneer = new VerifyListener() {

                private String defaultValue = "0"; //$NON-NLS-1$
                public void verifyText(VerifyEvent e) {
                    String inputStr = e.text;

                    boolean matches = true;
                    int start = e.start;
                    Text source = (Text) e.getSource();
                    String text = source.getText();

                    String msg = null;
                    if (start == 0) {
                        if (inputStr.startsWith(defaultValue)) {
                            matches = false;
                            msg = Messages.UpdateAutoIncrementDialog_zeroAtBeginning;
                        } else {
                            String digitRegex = "[0-9]*"; //$NON-NLS-1$
                            matches = Pattern.matches(digitRegex, inputStr);
                            if (!matches) {
                                msg = Messages.UpdateAutoIncrementDialog_inputInvalid;
                            }
                        }
                    } else {
                        if (text.startsWith(defaultValue)) {
                            matches = false;
                            msg = Messages.UpdateAutoIncrementDialog_zeroAtBeginning;
                        } else {
                            String digitRegex = "[0-9]*"; //$NON-NLS-1$
                            matches = Pattern.matches(digitRegex, inputStr);
                            if (!matches) {
                                msg = Messages.UpdateAutoIncrementDialog_inputInvalid;
                            }
                        }
                    }

                    if (!matches) {
                        MessageDialog.openError(getShell(), Messages._Error, msg);
                        e.doit = false;
                        return;
                    }

                }
            };
        }
        return verifyListeneer;
    }

    @Override
    protected void okPressed() {
        removeNotChanged();
        super.okPressed();
    }

    private void removeNotChanged() {
        Iterator<String> iterator = entityValues.keySet().iterator();
        while (iterator.hasNext()) {
            String entity = iterator.next();
            if (entityValues.get(entity).equals(results.get(entity))) {
                results.remove(entity);
            }
        }
    }

    /**
     * entity to AutoIncrement value map
     */
    public Map<String, String> getResults() {
        return results;
    }
}
