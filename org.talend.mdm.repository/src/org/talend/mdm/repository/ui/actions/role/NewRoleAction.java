// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.role;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.eclipse.jface.wizard.WizardDialog;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationE;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleSpecificationInstanceE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOC jsxie class global comment. Detailled comment <br/>
 * 
 */
public class NewRoleAction extends AbstractSimpleAddAction {

    boolean isAdmin;
    static Logger log = Logger.getLogger(NewRoleAction.class);

    public NewRoleAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        return ""; //$NON-NLS-1$
    }

    private WSRoleE newRole(String key) {
        WSRoleE role = MdmserverobjectFactory.eINSTANCE.createWSRoleE();
        role.setName(key);
        if (isAdmin) {
            xmlParseSpecification(role, true);
            role.setDescription("[EN:Administrator]");
        } else {
            xmlParseSpecification(role, false);
            role.setDescription("[EN:Normal User]");
        }



        return role;

    }

    @Override
    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }

        NewUserWizard wizard = new NewUserWizard();
        wizard.setWindowTitle("New Role");
        WizardDialog dialog = new WizardDialog(getShell(), wizard);
        dialog.open();
        String key = wizard.getUserName();
        isAdmin = wizard.isAdmin();

        createServerObject(key);
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);
        

    }

    protected boolean createServerObject(String key) {

        WSRoleItem item = MdmpropertiesFactory.eINSTANCE.createWSRoleItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);

        WSRoleE role = newRole(key);
        item.setWsRole(role);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return true;
    }

    /**
     * Read the initial value from admin.xml or user.xml
     */
    public void xmlParseSpecification(WSRoleE role, boolean isAdmin) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;

            if (isAdmin) {
                InputStream in = NewUserWizard.class.getResourceAsStream("admin.xml");//$NON-NLS-1$
                document = builder.parse(in);
            } else {
                InputStream in = NewUserWizard.class.getResourceAsStream("user.xml");//$NON-NLS-1$
                document = builder.parse(in);
            }
            NodeList nodelist = document.getElementsByTagName("typeName");//$NON-NLS-1$

            int size = nodelist.getLength();

            ArrayList<WSRoleSpecificationE> wsSpecifications = new ArrayList<WSRoleSpecificationE>();

            for (int i = 0; i < size; i++) {
                Node node = nodelist.item(i);// get the number i node
                NamedNodeMap map = node.getAttributes();

                Node isadminNode = map.getNamedItem("isAdmin");//$NON-NLS-1$
                String isadminValue = isadminNode.getTextContent();
                Node typenameNode = map.getNamedItem("name");//$NON-NLS-1$
                String typevalue = typenameNode.getTextContent();


                WSRoleSpecificationE wsSpecification = MdmserverobjectFactory.eINSTANCE.createWSRoleSpecificationE();

                if (isadminValue.equals("true"))//$NON-NLS-1$
                    wsSpecification.setAdmin(true);
                else
                    wsSpecification.setAdmin(false);
                wsSpecification.setObjectType(typevalue);

                NodeList instances = node.getChildNodes();

                ArrayList<WSRoleSpecificationInstanceE> wsInstances = new ArrayList<WSRoleSpecificationInstanceE>();
                for (int j = 0; j < instances.getLength(); j++) {

                    Node instance = instances.item(j);
                    NamedNodeMap inMap = instance.getAttributes();
                    if (inMap != null && inMap.getLength() > 0) {
                        Node isWr = inMap.getNamedItem("isWritable");//$NON-NLS-1$
                        String isWritable = isWr.getTextContent();
                        String isWrValue = instance.getTextContent();

                        WSRoleSpecificationInstanceE wsInstance = MdmserverobjectFactory.eINSTANCE
                                .createWSRoleSpecificationInstanceE();

                        String[] parameters = new String[] { "" };//$NON-NLS-1$

                        if (typevalue.equals("Menu")) {//$NON-NLS-1$
                            parameters[0] = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<role-menu-parameters position=\"1\"><parent-iD></parent-iD></role-menu-parameters>";//$NON-NLS-1$
                        }

                        wsInstance.getParameter().addAll(Arrays.asList(parameters));

                        if (isWritable.equals("true"))//$NON-NLS-1$
                            wsInstance.setWritable(true);
                        else
                            wsInstance.setWritable(false);
                        wsInstance.setInstanceName(isWrValue);
                        wsInstances.add(wsInstance);
                    }
                }
                wsSpecification.getInstance().addAll(wsInstances);
                wsSpecifications.add(wsSpecification);

            }
            role.getSpecification().addAll(wsSpecifications);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


}
