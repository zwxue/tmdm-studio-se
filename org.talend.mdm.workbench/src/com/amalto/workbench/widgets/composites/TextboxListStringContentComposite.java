package com.amalto.workbench.widgets.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextboxListStringContentComposite extends ListStringContentsComposite {

    protected Text txtInput;

    protected String colTitle;

    public TextboxListStringContentComposite(Composite parent, int style, String colTitle) {
        super(parent, style, new Object[] { colTitle });
    }

    protected TextboxListStringContentComposite(Composite parent, int style, Object[] initParas) {
        super(parent, style, initParas);
    }

    @Override
    protected String getInfoColTitle() {
        return colTitle;
    }

    @Override
    protected void createExtentUIArea(Composite parent) {
    }

    @Override
    protected void createCandidateInfoUIArea(Composite parent) {
        txtInput = new Text(this, SWT.BORDER);
        txtInput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    }

    @Override
    protected boolean hasCandidateInfo() {
        return !"".equals(txtInput.getText().trim());
    }

    @Override
    protected String getCandidateInfo() {
        return txtInput.getText().trim();
    }

    @Override
    protected void initCandidateInfoUIArea() {
        txtInput.setText("");
    }

    @Override
    protected void initParas(Object[] paras) {

        for (Object eachPara : paras) {

            if (eachPara instanceof String)
                this.colTitle = (String) eachPara;
        }

    }

}
