package org.talend.rcp.branding.tombundle;

import org.talend.core.branding.DefaultBrandingConfiguration;

public class TOMBrandingConfiguration extends DefaultBrandingConfiguration {

    @Override
    public String getInitialWindowPerspectiveId() {
        return "org.talend.mdm.perspective"; //$NON-NLS-1$
    }
}
