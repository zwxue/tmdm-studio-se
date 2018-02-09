// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
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
package org.talend.mdm.repository.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;

/**
 * DOC hbhong :for save/create/delete the repository resource <br/>
 * 
 */
public interface IRepositoryNodeResourceProvider {

    ERepositoryObjectType getRepositoryObjectType(Item item);

    Resource create(IProject project, Item item, int classifierID, IPath path) throws PersistenceException;

    Resource save(Item item) throws PersistenceException;

    Item createNewItem(ERepositoryObjectType type);

    boolean canHandleRepObjType(ERepositoryObjectType type);

    boolean canHandleItem(Item item);

    boolean needSaveReferenceFile();

    void handleReferenceFile(Item item);

    void postDelete(String name, String version);

}
