// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.2_01, construire R40)
// Generated source version: 1.1.2

package com.amalto.core.webservice;


public class WSRunQuery {
    protected java.lang.String revisionID;
    protected com.amalto.core.webservice.WSDataClusterPK wsDataClusterPK;
    protected java.lang.String query;
    protected java.lang.String[] parameters;
    
    public WSRunQuery() {
    }
    
    public WSRunQuery(java.lang.String revisionID, com.amalto.core.webservice.WSDataClusterPK wsDataClusterPK, java.lang.String query, java.lang.String[] parameters) {
        this.revisionID = revisionID;
        this.wsDataClusterPK = wsDataClusterPK;
        this.query = query;
        this.parameters = parameters;
    }
    
    public java.lang.String getRevisionID() {
        return revisionID;
    }
    
    public void setRevisionID(java.lang.String revisionID) {
        this.revisionID = revisionID;
    }
    
    public com.amalto.core.webservice.WSDataClusterPK getWsDataClusterPK() {
        return wsDataClusterPK;
    }
    
    public void setWsDataClusterPK(com.amalto.core.webservice.WSDataClusterPK wsDataClusterPK) {
        this.wsDataClusterPK = wsDataClusterPK;
    }
    
    public java.lang.String getQuery() {
        return query;
    }
    
    public void setQuery(java.lang.String query) {
        this.query = query;
    }
    
    public java.lang.String[] getParameters() {
        return parameters;
    }
    
    public void setParameters(java.lang.String[] parameters) {
        this.parameters = parameters;
    }
}
