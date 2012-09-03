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
package org.talend.mdm.repository.ui.wizards.exports.viewers;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.core.impl.transformerV2.TransformerV2LabelProvider;
import org.talend.mdm.repository.core.impl.view.ViewLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryLabelProvider;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MDMExporterLabelProvider extends MDMRepositoryLabelProvider {

    private ViewLabelProvider viewLabelProvider;
    private TransformerV2LabelProvider v2LabelProvider;

    @Override
    protected IRepositoryNodeLabelProvider getLabelProvider(Object element) {
        if (element instanceof IRepositoryViewObject) {
            Item item = ((IRepositoryViewObject) element).getProperty().getItem();
            IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (conf != null) {
                IRepositoryNodeLabelProvider labelProvider = conf.getLabelProvider();
                labelProvider = getRealLabelProvider(labelProvider);
                
                return labelProvider;
            }
        }
        return null;
    }

    private IRepositoryNodeLabelProvider getRealLabelProvider(IRepositoryNodeLabelProvider labelProvider) {
        if(labelProvider instanceof ViewLabelProvider) {
            if(viewLabelProvider == null)
                viewLabelProvider = new ViewExporterLabelProvider();
            labelProvider = viewLabelProvider;
        } else if (labelProvider instanceof TransformerV2LabelProvider) {
            if( v2LabelProvider == null)
                v2LabelProvider = new ProcessExporterLabelProvider();
            labelProvider = v2LabelProvider;
            
        }
        
        return labelProvider;
    }
}
