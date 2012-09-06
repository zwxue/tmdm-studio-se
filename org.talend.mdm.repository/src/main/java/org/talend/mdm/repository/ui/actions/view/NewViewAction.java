// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend �C www.talend.com
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
package org.talend.mdm.repository.ui.actions.view;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xsd.XSDElementDeclaration;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.view.IViewNodeConstDef;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.dialogs.ViewInputDialog2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.ValidateUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewViewAction extends AbstractSimpleAddAction {

    private XSDElementDeclaration decl;

    public XSDElementDeclaration getXSDElementDeclaration() {
        return this.decl;
    }

    public NewViewAction() {
        super();
    }

    @Override
    protected String getDialogTitle() {
        return Messages.NewViewAction_newView;
    }

    protected void doRun() {
        getParentItem();

        int type = getType();

        IWorkbenchPartSite site = commonViewer.getCommonNavigator().getSite();
        ViewInputDialog2 vid = new ViewInputDialog2(site, getShell(), getDialogTitle(), Messages.Common_inputName,
                getInputValidator(), false, type);
        vid.setBtnShow(true);
        vid.create();
        vid.getShell().setSize(new Point(500, 280));
        vid.setBlockOnOpen(true);
        if (vid.open() == Window.CANCEL)
            return;
        String key = vid.getEntityName();
        String filterName = vid.getFilterName();

        Item item = null;
        if (filterName == null)
            item = createServerObject(key);
        else {
            String filterPart = ""; //$NON-NLS-1$
            if (!filterName.isEmpty())
                filterPart = "#" + filterName; //$NON-NLS-1$

            item = createServerObject(IViewNodeConstDef.ViewPrefix + key + filterPart);
        }
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);

        openEditor(item);
    }

    private int getType() {
        
        
        int type = 0;

        IRepositoryViewObject repositoryViewObject = (IRepositoryViewObject) selectObj;

        ContainerItem containerItem = (ContainerItem) repositoryViewObject.getProperty().getItem();
        String path = containerItem.getState().getPath();
        if (path.isEmpty()) {
            type = 0;
        } else if (path.startsWith(IPath.SEPARATOR+IViewNodeConstDef.PATH_WEBFILTER)) {
            type = 1;
        } else if (path.startsWith(IPath.SEPARATOR+IViewNodeConstDef.PATH_SEARCHFILTER)) {
            type = 2;
        }

        return type;
    }

    protected Item createServerObject(String key) {

        WSViewItem item = MdmpropertiesFactory.eINSTANCE.createWSViewItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSViewE view = newView(key);
        item.setWsView(view);

        if (parentItem != null) {
            String path = parentItem.getState().getPath();
            if(path.isEmpty()) {
                if(key.startsWith(IViewNodeConstDef.ViewPrefix))
                    path = IPath.SEPARATOR + IViewNodeConstDef.PATH_WEBFILTER;                
                else {
                    path = IPath.SEPARATOR + IViewNodeConstDef.PATH_SEARCHFILTER;                
                }
            }
            item.getState().setPath(path);
        } else {
            if(key.toLowerCase().startsWith(IViewNodeConstDef.ViewPrefix))
                item.getState().setPath(IViewNodeConstDef.PATH_WEBFILTER);
            else {
                item.getState().setPath(IViewNodeConstDef.PATH_SEARCHFILTER);
            }
        }
        RepositoryResourceUtil.createItem(item, key);
        return item;
    }

    protected WSViewE newView(String key) {

        WSBooleanE wsBool = MdmserverobjectFactory.eINSTANCE.createWSBooleanE();
        wsBool.set_true(false);

        WSViewE view = MdmserverobjectFactory.eINSTANCE.createWSViewE();
        view.setName(key);
        view.setDescription(""); //$NON-NLS-1$
        view.setTransformerPK(null);
        view.setIsTransformerActive(wsBool);

        return view;
    }

    public void setXSDElementDeclaration(XSDElementDeclaration decl) {
        this.decl = decl;

    }

    private IInputValidator getInputValidator() {
        return new IInputValidator() {

            public String isValid(String newText) {
                if (newText == null || newText.trim().length() == 0)
                    return Messages.Common_nameCanNotBeEmpty;
                if (!ValidateUtil.matchViewProcessRegex(newText)) {
                    return Messages.Common_nameInvalid;
                }
                if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), newText.trim())) {
                    return Messages.Common_nameIsUsed;
                }
                return null;
            };
        };
    }
    
    public void createNewView(String viewName) {
        RepositoryResourceUtil.removeViewObjectPhysically(IServerObjectRepositoryType.TYPE_VIEW, viewName, null, null);
        createServerObject(viewName);
        refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_VIEW);
        refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_ROLE);
    }
}
