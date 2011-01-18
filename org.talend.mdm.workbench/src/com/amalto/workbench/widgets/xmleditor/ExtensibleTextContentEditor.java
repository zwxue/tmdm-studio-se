package com.amalto.workbench.widgets.xmleditor;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabItem;

public class ExtensibleTextContentEditor extends ExtensibleContentEditor {

    public ExtensibleTextContentEditor(Composite parent, int style, String id) {
        super(parent, style, id);
    }

    @Override
    protected void createPages(List<ExtensibleContentEditorPageDescription> creatorDescriptions) {
        super.createPages(creatorDescriptions);

        TabItem item = new TabItem(tabFolderEditors, SWT.NONE);
        item.setText("Source");
        item.setControl(new ExtensibleTextContentEditorPageCreator().createXMLEditorPage(tabFolderEditors, SWT.NONE));
        item.getControl().setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
    }
}
