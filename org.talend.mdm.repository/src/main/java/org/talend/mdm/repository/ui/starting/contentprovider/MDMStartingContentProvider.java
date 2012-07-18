package org.talend.mdm.repository.ui.starting.contentprovider;

import java.io.PrintWriter;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.intro.config.IIntroContentProviderSite;
import org.eclipse.ui.intro.config.IIntroXHTMLContentProvider;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.mdm.repository.ui.starting.MDMStartingConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class MDMStartingContentProvider implements IIntroXHTMLContentProvider {

    public void createContent(String s, PrintWriter printwriter) {
    }

    public void createContent(String s, Composite composite, FormToolkit formtoolkit) {
    }

    public void dispose() {
    }

    public void init(IIntroContentProviderSite iintrocontentprovidersite) {
    }

    public void createContent(String id, Element parent) {
        IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
        if (service != null) {
            Document dom = parent.getOwnerDocument();
            if (MDMStartingConstants.PRODUCT_NAME.equals(id)) {
                parent.appendChild(dom.createTextNode(service.getProductName()));
            } else if (MDMStartingConstants.OPTION_NAME.equals(id)) {
                parent.appendChild(dom.createTextNode(service.getOptionName()));
            }
        }
    }
}
