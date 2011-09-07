// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.webapp.synchronization2.server.model;

public class ItemPK {

    private String dataClusterPK;

    private String conceptName;

    private String[] ids;

    /**
     * For mashalling/unmarshalling purposes only
     * 
     */
    public ItemPK() {
        super();
    }

    /**
     * @param name
     * @param clusterPK
     * @param ids
     */
    public ItemPK(String clusterPK, String name, String[] ids) {
        super();
        conceptName = name;
        dataClusterPK = clusterPK;
        this.ids = ids;
    }

    /**
     * @return Returns the conceptName.
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     * @param conceptName The conceptName to set.
     */
    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    /**
     * @return Returns the dataClusterPK.
     */
    public String getDataClusterPOJOPK() {
        return dataClusterPK;
    }

    /**
     * @param dataClusterPK The dataClusterPK to set.
     */
    public void setDataClusterPOJOPK(String dataClusterPK) {
        this.dataClusterPK = dataClusterPK;
    }

    /**
     * @return Returns the ids.
     */
    public String[] getIds() {
        return ids;
    }

    /**
     * @param ids The ids to set.
     */
    public void setIds(String[] ids) {
        this.ids = ids;
    }

    /**
     * Returns a unique String representing this item
     * 
     * @return the unique id String
     */
    public String getUniqueID() {
        String fname = this.getDataClusterPOJOPK() + '.' + getConceptName();
        for (int i = 0; i < getIds().length; i++) {
            fname += '.' + (getIds()[i] == null ? "" : getIds()[i].trim()); //$NON-NLS-1$ // trim added due to exist bu triming the
                                                                            // ids
        }
        return fname;
    }

    @Override
    public String toString() {
        return getUniqueID();
    }

}
