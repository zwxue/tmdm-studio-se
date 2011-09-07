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

public class SynchronizationItemRemoteInstance {

    private String remoteSystemName;

    private String revisionID;

    private String xml;

    private long lastLocalSynchronizationTime;

    public SynchronizationItemRemoteInstance() {
    }

    public SynchronizationItemRemoteInstance(String remoteSystemName, String revisionID, String xml,
            long lastLocalSynchronizationTime) {
        super();
        this.remoteSystemName = remoteSystemName;
        this.revisionID = revisionID == null ? "" : revisionID; //$NON-NLS-1$
        this.xml = xml;
        this.lastLocalSynchronizationTime = lastLocalSynchronizationTime;
    }

    public String getKey() {
        return getRemoteSystemName() + '/' + getRevisionID();
    }

    public String getRevisionID() {
        return revisionID == null ? "" : revisionID; //$NON-NLS-1$
    }

    public void setRevisionID(String revisionID) {
        this.revisionID = revisionID == null ? "" : revisionID; //$NON-NLS-1$
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public long getLastLocalSynchronizationTime() {
        return lastLocalSynchronizationTime;
    }

    public void setLastLocalSynchronizationTime(long lastLocalSynchronizationTime) {
        this.lastLocalSynchronizationTime = lastLocalSynchronizationTime;
    }

    public String getRemoteSystemName() {
        return remoteSystemName;
    }

    public void setRemoteSystemName(String remoteSystemName) {
        this.remoteSystemName = remoteSystemName;

    }
}
