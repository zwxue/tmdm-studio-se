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
package org.talend.mdm.repository.ui.navigator;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MDMRepositoryLabelProvider implements ILabelProvider, IDescriptionProvider {

    @Override
    public void addListener(ILabelProviderListener listener) {
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    @Override
    public String getDescription(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if(provider!=null){
            return provider.getDescription(element) ;
        }
        return null;
    }

    @Override
    public Image getImage(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if(provider!=null){
            return provider.getImage(element) ;
        }
        return null;
    }

    @Override
    public String getText(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if(provider!=null){
            return provider.getText(element) ;
        }
        return element.toString();
    }

    private IRepositoryNodeLabelProvider getLabelProvider(Object element) {
        if (element instanceof IRepositoryViewObject) {
            Item item = ((IRepositoryViewObject) element).getProperty().getItem();
            IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (conf != null) {
                return conf.getLabelProvider();
            }
        }
        return null;
    }
}
