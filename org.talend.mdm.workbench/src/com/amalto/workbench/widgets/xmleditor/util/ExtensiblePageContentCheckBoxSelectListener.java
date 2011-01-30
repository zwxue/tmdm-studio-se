package com.amalto.workbench.widgets.xmleditor.util;

import java.lang.reflect.Method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import com.amalto.workbench.widgets.xmleditor.ExtensibleContentEditorPage;
import com.amalto.workbench.widgets.xmleditor.pagecontent.ExtensibleXMLEditorPageContent;

public class ExtensiblePageContentCheckBoxSelectListener extends SelectionAdapter {

    private ExtensibleContentEditorPage parentPage;

    private Button checkBox;

    private ExtensibleXMLEditorPageContent modifiedObj;

    private String modifyMethodName;

    public ExtensiblePageContentCheckBoxSelectListener(ExtensibleContentEditorPage parentPage, Button checkBox,
            ExtensibleXMLEditorPageContent modifiedObj, String modifyMethodName) {

        this.parentPage = parentPage;
        this.checkBox = checkBox;
        this.modifiedObj = modifiedObj;
        this.modifyMethodName = modifyMethodName;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {

        if (modifiedObj == null || modifyMethodName == null)
            return;

        try {
            Method method = modifiedObj.getClass().getMethod(modifyMethodName, Boolean.class);
            method.invoke(modifiedObj, checkBox.getSelection());
            parentPage.getContent().setContent(modifiedObj.toXMLExpression());
            parentPage.notifyOnXMLDocumentChanged();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
