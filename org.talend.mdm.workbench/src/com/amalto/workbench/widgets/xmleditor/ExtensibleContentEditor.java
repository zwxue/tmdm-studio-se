package com.amalto.workbench.widgets.xmleditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class ExtensibleContentEditor extends Composite {

    public static final String EXTENSIONID = "extensibleXMLEditorPage";

    protected TabFolder tabFolderEditors;

    private int lastSelectedTabIndex;

    private String id = "";

    public ExtensibleContentEditor(Composite parent, int style, String id) {
        super(parent, style);

        if (id != null)
            this.id = id;

        setLayout(new FillLayout());
        tabFolderEditors = new TabFolder(this, SWT.BOTTOM);

        tabFolderEditors.addSelectionListener(new ExtensibleXMLEditorSelectionListener());

    }

    public String getId() {
        return id;
    }

    public void setPageGroup(String group) {

        clearTabFolder();

        if (group == null)
            return;

        List<ExtensibleContentEditorPageDescription> creatorDescriptions = sortCreatorDescriptions(getPageCeatorDescriptions(group));

        createPages(creatorDescriptions);

        lastSelectedTabIndex = getDefaultPageIndex(creatorDescriptions);
        tabFolderEditors.setSelection(lastSelectedTabIndex);

    }

    public void setContent(String content) {
        setContent(new ExtensibleEditorContent(content));
    }

    public void setContent(ExtensibleEditorContent content) {

        if (content == null)
            return;

        for (TabItem eachItem : tabFolderEditors.getItems()) {

            if (!(eachItem.getControl() instanceof ExtensibleContentEditorPage))
                continue;

            ((ExtensibleContentEditorPage) eachItem.getControl()).setContent(content);
        }

    }

    protected void createPages(List<ExtensibleContentEditorPageDescription> creatorDescriptions) {

        for (ExtensibleContentEditorPageDescription eachCreatorDes : creatorDescriptions) {

            TabItem item = new TabItem(tabFolderEditors, SWT.NONE);
            item.setText(eachCreatorDes.getLabel());
            item.setControl(eachCreatorDes.getCreator().createXMLEditorPage(tabFolderEditors, SWT.NONE));

            item.getControl().setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
        }
    }

    protected int getDefaultPageIndex(List<ExtensibleContentEditorPageDescription> creatorDescriptions) {

        for (int i = 0; i < creatorDescriptions.size(); i++) {

            if (creatorDescriptions.get(i).isDefault())
                return i;
        }

        return 0;
    }

    protected List<ExtensibleContentEditorPageDescription> sortCreatorDescriptions(
            Map<Integer, List<ExtensibleContentEditorPageDescription>> index2CreatorDes) {

        List<Integer> indexes = Arrays.asList(index2CreatorDes.keySet().toArray(new Integer[0]));
        Collections.sort(indexes);

        List<ExtensibleContentEditorPageDescription> results = new ArrayList<ExtensibleContentEditorPageDescription>();

        for (Integer eachSortedIndex : indexes)
            results.addAll(index2CreatorDes.get(eachSortedIndex));

        return results;
    }

    protected Map<Integer, List<ExtensibleContentEditorPageDescription>> getPageCeatorDescriptions(String group) {
        Map<Integer, List<ExtensibleContentEditorPageDescription>> index2CreatorDes = new HashMap<Integer, List<ExtensibleContentEditorPageDescription>>();

        for (IConfigurationElement eachElement : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSIONID)) {

            if (!id.equals(eachElement.getAttribute("editorId")) || !group.equals(eachElement.getAttribute("group")))
                continue;

            ExtensibleContentEditorPageCreator creator = getPageCreator(eachElement);

            if (creator == null)
                continue;

            int index = getPageIndex(eachElement);

            List<ExtensibleContentEditorPageDescription> creatorDeses = index2CreatorDes.get(index);
            if (creatorDeses == null) {
                creatorDeses = new ArrayList<ExtensibleContentEditorPageDescription>();
                index2CreatorDes.put(index, creatorDeses);
            }

            creatorDeses.add(new ExtensibleContentEditorPageDescription(getPageLabel(eachElement), index, creator,
                    isDefaultPage(eachElement)));

        }

        return index2CreatorDes;
    }

    protected ExtensibleContentEditorPageCreator getPageCreator(IConfigurationElement eachElement) {

        try {
            Object creatorObj = eachElement.createExecutableExtension("class");

            if (creatorObj instanceof ExtensibleContentEditorPageCreator)
                return (ExtensibleContentEditorPageCreator) creatorObj;

        } catch (CoreException e) {
            return null;
        }

        return null;
    }

    protected int getPageIndex(IConfigurationElement eachElement) {

        try {
            return Integer.parseInt(eachElement.getAttribute("index"));
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    protected String getPageLabel(IConfigurationElement eachElement) {
        return eachElement.getAttribute("label");
    }

    protected boolean isDefaultPage(IConfigurationElement eachElement) {
        try {
            return Boolean.parseBoolean(eachElement.getAttribute("isDefault"));
        } catch (Exception e) {
            return false;
        }
    }

    protected void clearTabFolder() {

        for (TabItem eachTabItem : tabFolderEditors.getItems()) {

            eachTabItem.dispose();

            eachTabItem.getControl().dispose();
        }

    }

    protected ExtensibleContentEditorPage getXMLEditorPage(int index) {

        try {
            TabItem item = tabFolderEditors.getItem(index);

            if (!(item.getControl() instanceof ExtensibleContentEditorPage))
                return null;

            return (ExtensibleContentEditorPage) item.getControl();

        } catch (Exception e) {
            return null;
        }

    }

    public void addExtensibleXMLEditorPageListener(ExtensibleContentEditorPageListener listener) {

        for (TabItem eachTabItem : tabFolderEditors.getItems()) {

            if (!(eachTabItem.getControl() instanceof ExtensibleContentEditorPage))
                continue;

            ((ExtensibleContentEditorPage) eachTabItem.getControl()).addExtensibleXMLEditorPageListener(listener);
        }
    }

    public void removeExtensibleXMLEditorPageListener(ExtensibleContentEditorPageListener listener) {

        for (TabItem eachTabItem : tabFolderEditors.getItems()) {

            if (!(eachTabItem.getControl() instanceof ExtensibleContentEditorPage))
                continue;

            ((ExtensibleContentEditorPage) eachTabItem.getControl()).removeExtensibleXMLEditorPageListener(listener);
        }

    }

    public void clearExternalResources() {

        for (TabItem eachTabItem : tabFolderEditors.getItems()) {

            if (!(eachTabItem.getControl() instanceof ExtensibleContentEditorPage))
                continue;

            ((ExtensibleContentEditorPage) eachTabItem.getControl()).clearExternalResources();
        }

    }

    public class ExtensibleXMLEditorSelectionListener extends SelectionAdapter {

        @Override
        public void widgetSelected(SelectionEvent e) {

            if (tabFolderEditors.getSelectionIndex() == -1 || tabFolderEditors.getSelectionIndex() == lastSelectedTabIndex)
                return;

            ExtensibleContentEditorPage oldPage = getXMLEditorPage(lastSelectedTabIndex);
            ExtensibleContentEditorPage newPage = getXMLEditorPage(tabFolderEditors.getSelectionIndex());

            if (oldPage != null) {

                try {
                    oldPage.saveContentFromUI();
                } catch (ExtensibleContentEditorPageSaveException e1) {
                    e.doit = false;
                    MessageDialog.openError(getShell(), "error",
                            "The contents in the current UI isn't valid to save to a xml document");
                    return;
                }
            }

            if (newPage != null)
                newPage.refresh();

            lastSelectedTabIndex = tabFolderEditors.getSelectionIndex();
        }
    }

}
