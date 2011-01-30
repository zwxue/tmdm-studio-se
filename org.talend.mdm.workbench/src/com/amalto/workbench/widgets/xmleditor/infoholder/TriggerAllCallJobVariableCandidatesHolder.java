package com.amalto.workbench.widgets.xmleditor.infoholder;

public class TriggerAllCallJobVariableCandidatesHolder extends AllCallJobVariableCandidatesHolder {

    private String[] candidates = new String[] { "{exchange_data}" };

    @Override
    public String[] getExternalInfo() {
        return candidates;
    }

}
