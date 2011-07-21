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
package org.talend.mdm.repository.core;

import org.talend.core.model.repository.ERepositoryObjectType;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public interface IServerObjectRepositoryType {

    // public static ERepositoryObjectType TYPE_CATEGORY = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
    //            ERepositoryObjectType.class, "MDM.Category"); //$NON-NLS-1$
    //
    // public static ERepositoryObjectType TYPE_FOLDER = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
    //            ERepositoryObjectType.class, "MDM.Folder"); //$NON-NLS-1$

    // /

    public static ERepositoryObjectType TYPE_ROLE = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.Role"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_MENU = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.Menu"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_DATAMODEL = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.DataModel"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_DATACLUSTER = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.DataCluster"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_STOREPROCEDURE = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.StoredProcedure"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_UNIVERSE = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.Universe"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_SYNCHRONIZATIONPLAN = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.SynchronizationPlan"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_VIEW = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.View"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_WORKFLOW = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.Workflow"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_TRANSFORMERV2 = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.TransformerV2"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_ROUTINGRULE = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.RoutingRule"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_JOBMODEL = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.JobModel"); //$NON-NLS-1$

    public static ERepositoryObjectType TYPE_EVENTMANAGER = (ERepositoryObjectType) ERepositoryObjectType.valueOf(
            ERepositoryObjectType.class, "MDM.EventManager"); //$NON-NLS-1$

}
