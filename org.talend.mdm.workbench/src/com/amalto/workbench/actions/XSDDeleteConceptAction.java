package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

public class XSDDeleteConceptAction extends UndoAction {

    // private DataModelMainPage page = null;
    private XSDElementDeclaration xsdElem = null;

    public XSDDeleteConceptAction(DataModelMainPage page) {
        super(page);
        // this.page = page;
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText("Delete Entity");
        setToolTipText("Delete an Entity");
    }

    public void run(Object toDel) {
        if (!(toDel instanceof XSDElementDeclaration)) {
            return;
        }
        xsdElem = (XSDElementDeclaration) toDel;
        super.run();
    }

    public IStatus doAction() {
        try {
            // xsdElem is to support the multiple delete action on key press,
            // which each delete action on concept must be explicit passed a xsdElem to
            // delete
            XSDElementDeclaration decl = xsdElem;
            if (decl == null) {
                ISelection selection = page.getTreeViewer().getSelection();
                decl = (XSDElementDeclaration) ((IStructuredSelection) selection).getFirstElement();
            }
            XtentisPort port = null;
            try {
                port = Util.getPort(page.getXObject());
            } catch (XtentisException e) {
                e.printStackTrace();
            }
            // add by ymli. fix buy 0010029
            Set<String> list = Util.getForeignKeys();
            if (list == null) {
                list = new HashSet<String>();
                Util.getForeingKeyInDataModel(list, page.getXObject().getParent(), port);
                Util.setForeignKeys(list);
            }
            if (list.contains(decl.getName())) {
                boolean confirmed = MessageDialog.openConfirm(page.getSite().getShell(), "Confirm Delete", "The \""
                        + decl.getName()
                        + "\" Entity is referred to by at least one foreign key. Are you sure you want to proceed?\n"
                        + "\nIf you click OK, this will leave one reference or more to a non-existing Entity.");
                if (!confirmed) {
                    return Status.CANCEL_STATUS;
                }
            }
            ArrayList<Object> objList = new ArrayList<Object>();
            IStructuredContentProvider provider = (IStructuredContentProvider) page.getTreeViewer().getContentProvider();
            Object[] objs = Util.getAllObject(page.getSite(), objList, provider);
            Util.deleteReference(decl, objs);
            if (schema == null)
                schema = ((ISchemaContentProvider) page.getTreeViewer().getContentProvider()).getXsdSchema();
            schema.getContents().remove(decl);

            schema.update();
            xsdElem = null;
            page.refresh();
            page.markDirtyWithoutCommit();

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openError(page.getSite().getShell(), "Error", "An error occured trying to remove Entity: "
                    + e.getLocalizedMessage());

            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    public void setXSDTODel(XSDElementDeclaration elem) {
        xsdElem = elem;
    }
}
