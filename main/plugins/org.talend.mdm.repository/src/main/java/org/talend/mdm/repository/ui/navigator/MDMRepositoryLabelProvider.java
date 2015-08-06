// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2015 Talend �C www.talend.com
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

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MDMRepositoryLabelProvider implements ILabelProvider, IDescriptionProvider, IColorProvider, IFontProvider {

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {

    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

    public String getDescription(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if (provider != null) {
            return provider.getDescription(element);
        }
        return null;
    }

    public Image getImage(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if (provider != null) {
            return provider.getImage(element);
        }
        return null;
    }

    public String getText(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if (provider != null) {
            return provider.getText(element);
        }
        return element.toString();
    }

    protected IRepositoryNodeLabelProvider getLabelProvider(Object element) {
        if (element instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObject = (IRepositoryViewObject) element;
            viewObject = RepositoryResourceUtil.assertViewObject(viewObject);
            Item item = viewObject.getProperty().getItem();
            IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (conf != null) {
                return conf.getLabelProvider();
            }
        }
        return null;
    }

    public Color getForeground(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if (provider != null) {
            return provider.getForeground(element);
        }
        return null;
    }

    public Font getFont(Object element) {
        IRepositoryNodeLabelProvider provider = getLabelProvider(element);
        if (provider != null) {
            return provider.getFont(element);
        }
        return null;
    }

    public Color getBackground(Object element) {
        return null;
    }

}
