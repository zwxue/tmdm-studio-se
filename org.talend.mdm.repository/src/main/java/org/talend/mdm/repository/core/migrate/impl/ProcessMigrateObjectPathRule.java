// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.migrate.impl;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;
import org.talend.mdm.repository.core.migrate.AbstractMigrateObjectPathRule;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;

public class ProcessMigrateObjectPathRule extends AbstractMigrateObjectPathRule {

    public ERepositoryObjectType getRepositoryObjectType() {

        return IServerObjectRepositoryType.TYPE_TRANSFORMERV2;
    }

    String[] folderNames = new String[] { ITransformerV2NodeConsDef.PATH_BEFORESAVE, ITransformerV2NodeConsDef.PATH_BEFOREDEL,
            ITransformerV2NodeConsDef.PATH_ENTITYACTION, ITransformerV2NodeConsDef.PATH_WELCOMEACTION,
            ITransformerV2NodeConsDef.PATH_SMARTVIEW, ITransformerV2NodeConsDef.PATH_OTHER };

    public String[] getAllNewFolderNames() {

        return folderNames;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.migrate.IMigrateObjectPathRule#routeObject(org.talend.core.model.properties.Item)
     */
    public String routeObject(Item item) {
        if (item instanceof MDMServerObjectItem) {
            String lowerCaseName = ((MDMServerObjectItem) item).getMDMServerObject().getName().toLowerCase();
            if (lowerCaseName != null) {
                if (lowerCaseName.startsWith(ITransformerV2NodeConsDef.Prefix_BEFORESAVE)) {
                    return ITransformerV2NodeConsDef.PATH_BEFORESAVE;
                } 
                else if(lowerCaseName.startsWith(ITransformerV2NodeConsDef.Prefix_BEFOREDEL)){
                    return ITransformerV2NodeConsDef.PATH_BEFOREDEL;
                }
                else if(lowerCaseName.startsWith(ITransformerV2NodeConsDef.Prefix_RUNNABLE)){
                    return ITransformerV2NodeConsDef.PATH_ENTITYACTION;
                }
                else if(lowerCaseName.startsWith(ITransformerV2NodeConsDef.Prefix_STANDLONE)){
                    return ITransformerV2NodeConsDef.PATH_WELCOMEACTION;
                }
                else if(lowerCaseName.startsWith(ITransformerV2NodeConsDef.Prefix_SMARTVIEW)){
                    return ITransformerV2NodeConsDef.PATH_SMARTVIEW;
                }
                else {
                    return ITransformerV2NodeConsDef.PATH_OTHER;
                }
            }
        }
        
        return null;
    }
}
