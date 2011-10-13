package org.talend.mdm.repository.ui.contributor;

import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.ui.widgets.SvnHistoryComposite;


public class SvnHistoryPropertySection extends AbstractPropertySection {

    IRepositoryViewObject obj;

    private SvnHistoryComposite composite;

    public SvnHistoryPropertySection() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        // TODO Auto-generated method stub
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite compTop = getWidgetFactory().createComposite(parent);
        compTop.setLayout(new FillLayout());
        composite = new SvnHistoryComposite(compTop, SWT.NULL);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
     * org.eclipse.jface.viewers.ISelection)
     */
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection sel = (IStructuredSelection) selection;
            Iterator it = sel.iterator();
            while (it.hasNext()) {
                Object input = it.next();
                if (input instanceof IRepositoryViewObject) {
                    obj = (IRepositoryViewObject) input;
                    composite.setRepositoryObject(obj);
                    composite.refresh();
                }
            }
        }
    }
}
