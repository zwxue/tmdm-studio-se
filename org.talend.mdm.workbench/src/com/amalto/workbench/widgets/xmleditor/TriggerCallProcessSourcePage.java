package com.amalto.workbench.widgets.xmleditor;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.proposal.ContentProposalAdapterExtended;
import com.amalto.workbench.utils.WidgetUtils;
import com.amalto.workbench.widgets.xmleditor.ExtensibleTextContentEditorPage;
import com.amalto.workbench.widgets.xmleditor.infoholder.ExternalInfoHolder;

public class TriggerCallProcessSourcePage extends ExtensibleTextContentEditorPage {

    protected ExternalInfoHolder<?> allProcessNamesHolder;

    public TriggerCallProcessSourcePage(Composite parent, int style) {
        super(parent, style);
    }

    @Override
    public void setExternalInfoHolder(ExternalInfoHolder<?> externalInfoHolder) {

        if (externalInfoHolder == null || !ExternalInfoHolder.INFOID_ALLPROCESSNAMES.equals(externalInfoHolder.getId()))
            return;

        allProcessNamesHolder = externalInfoHolder;

        refreshProposal();

    }

    @Override
    public void reloadExternalInfo() {
        refreshProposal();
    }

    private void refreshProposal() {

        ContentProposalAdapterExtended adapter = WidgetUtils.addContentProposal(textViewer.getTextWidget(),
                (String[]) allProcessNamesHolder.getExternalInfo(), new char[] { ' ', '=' });

        adapter.setPopupSize(new Point(300, 250));

    }

}
