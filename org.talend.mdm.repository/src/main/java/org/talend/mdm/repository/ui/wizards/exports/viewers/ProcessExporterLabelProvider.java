package org.talend.mdm.repository.ui.wizards.exports.viewers;

import org.talend.mdm.repository.core.impl.transformerV2.TransformerV2LabelProvider;


public class ProcessExporterLabelProvider extends TransformerV2LabelProvider {

    @Override
    protected String transformItemText(String itemText) {
        return itemText;
    }
}
