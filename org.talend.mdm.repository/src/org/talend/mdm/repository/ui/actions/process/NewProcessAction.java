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
package org.talend.mdm.repository.ui.actions.process;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerProcessStepE;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerV2E;
import org.talend.mdm.repository.model.mdmserverobject.WSTransformerVariablesMappingE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.dialogs.ViewInputDialog2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewProcessAction extends AbstractSimpleAddAction {

    /**
     * DOC AddProcess constructor comment.
     * 
     * @param text
     */
    public NewProcessAction() {
        super();
    }

    protected String getDialogTitle() {
        return Messages.NewProcessAction_newProcess;
    }

    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }
        IWorkbenchPartSite site = commonViewer.getCommonNavigator().getSite();
        ViewInputDialog2 vid = new ViewInputDialog2(site, getShell(), getDialogTitle(),

        Messages.Common_inputName, "Smart_view_", new IInputValidator() {//$NON-NLS-1$

                    public String isValid(String newText) {
                        if (newText == null || newText.trim().length() == 0)
                            return Messages.Common_nameCanNotBeEmpty;
                        if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                            return Messages.Common_nameInvalid;
                        }
                        if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), newText.trim())) {
                            return Messages.Common_nameIsUsed;
                        }
                        return null;
                    };
                }, true);
        vid.setBtnShow(false);
        vid.create();
        vid.setBlockOnOpen(true);
        if (vid.open() == Window.CANCEL)
            return;
        String key = vid.getValue();

        createServerObject(key);
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);

    }

    private WSTransformerV2E newProcess(String key) {

        WSTransformerV2E transformer = MdmserverobjectFactory.eINSTANCE.createWSTransformerV2E();
        transformer.setName(key);
        transformer.setDescription(""); //$NON-NLS-1$

        if (key.toString().startsWith("Smart_view_")) {//$NON-NLS-1$
            final String parameters = "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'>\n"//$NON-NLS-1$
                    + "   <xsl:output method='html' indent='yes' omit-xml-declaration='yes'/>\n"//$NON-NLS-1$
                    + "   <xsl:template match='/'>\n" + "       <html>\n"//$NON-NLS-1$//$NON-NLS-2$
                    + "          <head><title>Smart View</title></head>\n" + "          <body>\n"//$NON-NLS-1$//$NON-NLS-2$ 
                    + "            <h1>This is the default Smart View for: <xsl:value-of select='./text()'/></h1>\n"//$NON-NLS-1$
                    + "            <xsl:copy-of select='.'/>\n" + "            <!-- Customize the stylesheet -->\n"//$NON-NLS-1$//$NON-NLS-2$
                    + "          </body>\n" + "       </html>\n" + "    </xsl:template>" + "</xsl:stylesheet>";//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$

            final String TRANSFORMER_PLUGIN = "amalto/local/transformer/plugin/xslt";//$NON-NLS-1$

            List<WSTransformerVariablesMappingE> inItems = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE inputLine = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            inputLine.setPipelineVariable("_DEFAULT_");//$NON-NLS-1$
            inputLine.setPluginVariable("xml");//$NON-NLS-1$
            inItems.add(inputLine);

            List<WSTransformerVariablesMappingE> outItems = new ArrayList<WSTransformerVariablesMappingE>();
            WSTransformerVariablesMappingE outputLine = MdmserverobjectFactory.eINSTANCE.createWSTransformerVariablesMappingE();
            outputLine.setPipelineVariable("html");//$NON-NLS-1$
            outputLine.setPluginVariable("text");//$NON-NLS-1$
            outItems.add(outputLine);

            ArrayList<WSTransformerProcessStepE> list = new ArrayList<WSTransformerProcessStepE>();
            WSTransformerProcessStepE step = MdmserverobjectFactory.eINSTANCE.createWSTransformerProcessStepE();
            step.setPluginJNDI(TRANSFORMER_PLUGIN);
            step.setDescription("Stylesheet"); //$NON-NLS-1$
            step.setParameters(parameters);
            step.getInputMappings().addAll(inItems);
            step.getOutputMappings().addAll(outItems);
            step.setDisabled(false);

            list.add(step);
            transformer.getProcessSteps().addAll(list);

        }

        return transformer;
    }

    protected boolean createServerObject(String key) {

        WSTransformerV2Item item = MdmpropertiesFactory.eINSTANCE.createWSTransformerV2Item();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSTransformerV2E process = newProcess(key);
        item.setWsTransformerV2(process);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return false;
    }

}
