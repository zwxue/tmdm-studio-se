package com.amalto.workbench.widgets.xmleditor;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.widgets.xmleditor.pagecontent.ExtensibleXMLEditorPageContent;

public abstract class ExtensibleXMLContentEditorPage<T extends ExtensibleXMLEditorPageContent> extends
        ExtensibleContentEditorPage {

    protected T pageContentObject;

    public ExtensibleXMLContentEditorPage(Composite parent, int style) {
        super(parent, style);

        pageContentObject = initPageContentObject();
    }

    public T getPageContentObject() {
        return pageContentObject;
    }

    @Override
    public void refresh() {

        if (pageContentObject.toXMLExpression().equals(getContent().getContent()))
            return;

        pageContentObject.init(getContent().getContent());

        doRefreshByPageContentObject();
    }

    @Override
    public void saveContentFromUI() throws ExtensibleContentEditorPageSaveException {
        getContent().setContent(pageContentObject.toXMLExpression());
    }

    protected abstract T initPageContentObject();

    protected abstract void doRefreshByPageContentObject();
}
