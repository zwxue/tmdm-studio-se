package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.BusinessElementInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDNewParticleFromTypeAction extends UndoAction implements SelectionListener {

    private BusinessElementInputDialog dialog = null;

    private XSDModelGroup group = null;

    private String elementName;

    private int minOccurs;

    private int maxOccurs;

    private XSDComplexTypeDefinition ctd;

    public XSDNewParticleFromTypeAction(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
        setText("Add Element");
        setToolTipText("Add a new Business Element at the top of the Business Elements");
    }

    public IStatus doAction() {
        try {

            IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
            if (selection.getFirstElement() instanceof XSDComplexTypeDefinition) {
                ctd = (XSDComplexTypeDefinition) selection.getFirstElement();
                if (!(ctd.getContent() instanceof XSDParticle))
                    return Status.CANCEL_STATUS;
                if (!(((XSDParticle) ctd.getContent()).getTerm() instanceof XSDModelGroup))
                    return Status.CANCEL_STATUS;
                ;
                group = (XSDModelGroup) ((XSDParticle) ctd.getContent()).getTerm();
            } else if (selection.getFirstElement() instanceof XSDParticle) {
                group = (XSDModelGroup) ((XSDParticle) selection.getFirstElement()).getTerm();
            } else if (selection.getFirstElement() instanceof XSDModelGroup) {
                group = (XSDModelGroup) selection.getFirstElement();
            } else {
                System.out.println("UNKNOWN SELECTION: " + selection.getFirstElement().getClass().getName() + "  --  "
                        + selection.getFirstElement());
                return Status.CANCEL_STATUS;
            }

            dialog = new BusinessElementInputDialog(this, page.getSite().getShell(), "Add a new Business Element", true);
            dialog.setBlockOnOpen(true);
            int ret = dialog.open();
            if (ret == Dialog.CANCEL) {
                return Status.CANCEL_STATUS;
            }

            XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();

            XSDElementDeclaration decl = factory.createXSDElementDeclaration();
            decl.setName(this.elementName);
            decl.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));

            XSDParticle particle = factory.createXSDParticle();
            particle.setContent(decl);
            particle.setMinOccurs(this.minOccurs);
            particle.setMaxOccurs(this.maxOccurs);

            group.getContents().add(group.getContents().size(), particle);
            group.updateElement();

            // fix 0010248. add annotion from parent

            if (dialog.isInherit()) {
                XSDTerm totm = particle.getTerm();
                XSDElementDeclaration concept = null;
                concept = (XSDElementDeclaration) Util.getParent(particle);
                XSDAnnotation fromannotation = null;
                if (concept != null)
                    fromannotation = concept.getAnnotation();
                if (fromannotation != null) {
                    XSDAnnotationsStructure struc = new XSDAnnotationsStructure(totm);
                    if (((XSDElementDeclaration) totm).getType() != null)
                        addAnnotion(struc, fromannotation);
                }

            }

            page.refresh();
            page.getTreeViewer().setSelection(new StructuredSelection(particle), true);
            page.markDirty();

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openError(page.getSite().getShell(), "Error",
                    "An error occured trying to create a new Business Element: " + e.getLocalizedMessage());
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

    public void addAnnotion(XSDAnnotationsStructure struc, XSDAnnotation xsdannotationparent) {
        Map infor = new HashMap<String, ArrayList<String>>();
        infor = cloneXSDAnnotation(xsdannotationparent);
        Set keys = infor.keySet();
        for (int i = 0; i < infor.size(); i++) {
            ArrayList<String> lists = (ArrayList<String>) infor.get(keys.toArray()[i]);
            try {
                struc.setAccessRole(lists, false, (IStructuredContentProvider) page.getTreeViewer().getContentProvider(),
                        (String) keys.toArray()[i]);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Map cloneXSDAnnotation(XSDAnnotation oldAnn) {
        XSDAnnotation xsdannotation = XSDFactory.eINSTANCE.createXSDAnnotation();
        Map infor = new HashMap<String, List>();
        try {
            if (oldAnn != null) {
                for (int i = 0; i < oldAnn.getApplicationInformation().size(); i++) {
                    Element oldElem = oldAnn.getApplicationInformation().get(i);
                    String type = oldElem.getAttributes().getNamedItem("source").getNodeValue();
                    // X_Write,X_Hide,X_Workflow
                    if (type.equals("X_Write") || type.equals("X_Hide") || type.equals("X_Workflow")) {
                        if (!infor.containsKey(type)) {
                            List typeList = new ArrayList<String>();
                            typeList.add(oldElem.getFirstChild().getNodeValue());
                            infor.put(type, typeList);
                        } else {
                            ((List) infor.get(type)).add(oldElem.getFirstChild().getNodeValue());
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openError(this.page.getSite().getShell(), "Error", "An error occured trying to paste Entities: "
                    + e.getLocalizedMessage());
        }
        return infor;
    }

    /********************************
     * Listener to input dialog
     */
    public void widgetDefaultSelected(SelectionEvent e) {
    }

    public void widgetSelected(SelectionEvent e) {
        if (dialog.getReturnCode() == -1)
            return; // there was a validation error
        elementName = dialog.getElementName();
        minOccurs = dialog.getMinOccurs();
        maxOccurs = dialog.getMaxOccurs();

        // check that this element does not already exist
        // get position of the selected particle in the container
        for (Iterator iter = group.getContents().iterator(); iter.hasNext();) {
            XSDParticle p = (XSDParticle) iter.next();
            if (p.getTerm() instanceof XSDElementDeclaration) {
                XSDElementDeclaration thisDecl = (XSDElementDeclaration) p.getTerm();
                if (thisDecl.getName().equals(elementName)) {
                    MessageDialog.openError(page.getSite().getShell(), "Error", "The Business Element " + elementName
                            + " already exists.");
                    return;
                }
            }
        }// for

        dialog.close();
    }

}
