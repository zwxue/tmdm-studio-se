package com.amalto.workbench.widgets.celleditor;

import java.util.regex.Pattern;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class NumbericCellEditor extends TextCellEditor {

    public static final String REGX_POSITIVENUMBER = "^[\\d]+\\d*";

    public static final String REGX_POSITIVDOUBLE = "^[\\d]+\\d*.?\\d*";

    private String regx = "";

    protected NumbericCellEditor(Composite parent, int style, String regx) {
        super(parent, style);

        this.regx = regx;
    }

    @Override
    protected Control createControl(Composite parent) {

        Control control = super.createControl(parent);

        text.addVerifyListener(new VerifyListener() {

            public void verifyText(VerifyEvent e) {

                e.doit = Pattern.compile(regx).matcher(text.getText().trim() + e.text.trim()).matches();

            }
        });

        return control;
    }

    public static NumbericCellEditor createPositiveNumberCellEditor(Composite parent, int style) {
        return new NumbericCellEditor(parent, style, REGX_POSITIVENUMBER);
    }

    public static NumbericCellEditor createPositiveDoubleCellEditor(Composite parent, int style) {
        return new NumbericCellEditor(parent, style, REGX_POSITIVDOUBLE);
    }
}
