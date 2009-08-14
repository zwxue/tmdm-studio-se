// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation ��1.1.2_01������� R40��
// Generated source version: 1.1.2

package com.amalto.core.webservice;


public class WSGetItemsPivotIndex {
    protected java.lang.String clusterName;
    protected java.lang.String mainPivotName;
    protected com.amalto.core.webservice.WSLinkedHashMap pivotWithKeys;
    protected com.amalto.core.webservice.WSStringArray indexPaths;
    protected com.amalto.core.webservice.WSWhereItem whereItem;
    protected com.amalto.core.webservice.WSStringArray pivotDirections;
    protected com.amalto.core.webservice.WSStringArray indexDirections;
    protected int start;
    protected int limit;
    
    public WSGetItemsPivotIndex() {
    }
    
    public WSGetItemsPivotIndex(java.lang.String clusterName, java.lang.String mainPivotName, com.amalto.core.webservice.WSLinkedHashMap pivotWithKeys, com.amalto.core.webservice.WSStringArray indexPaths, com.amalto.core.webservice.WSWhereItem whereItem, com.amalto.core.webservice.WSStringArray pivotDirections, com.amalto.core.webservice.WSStringArray indexDirections, int start, int limit) {
        this.clusterName = clusterName;
        this.mainPivotName = mainPivotName;
        this.pivotWithKeys = pivotWithKeys;
        this.indexPaths = indexPaths;
        this.whereItem = whereItem;
        this.pivotDirections = pivotDirections;
        this.indexDirections = indexDirections;
        this.start = start;
        this.limit = limit;
    }
    
    public java.lang.String getClusterName() {
        return clusterName;
    }
    
    public void setClusterName(java.lang.String clusterName) {
        this.clusterName = clusterName;
    }
    
    public java.lang.String getMainPivotName() {
        return mainPivotName;
    }
    
    public void setMainPivotName(java.lang.String mainPivotName) {
        this.mainPivotName = mainPivotName;
    }
    
    public com.amalto.core.webservice.WSLinkedHashMap getPivotWithKeys() {
        return pivotWithKeys;
    }
    
    public void setPivotWithKeys(com.amalto.core.webservice.WSLinkedHashMap pivotWithKeys) {
        this.pivotWithKeys = pivotWithKeys;
    }
    
    public com.amalto.core.webservice.WSStringArray getIndexPaths() {
        return indexPaths;
    }
    
    public void setIndexPaths(com.amalto.core.webservice.WSStringArray indexPaths) {
        this.indexPaths = indexPaths;
    }
    
    public com.amalto.core.webservice.WSWhereItem getWhereItem() {
        return whereItem;
    }
    
    public void setWhereItem(com.amalto.core.webservice.WSWhereItem whereItem) {
        this.whereItem = whereItem;
    }
    
    public com.amalto.core.webservice.WSStringArray getPivotDirections() {
        return pivotDirections;
    }
    
    public void setPivotDirections(com.amalto.core.webservice.WSStringArray pivotDirections) {
        this.pivotDirections = pivotDirections;
    }
    
    public com.amalto.core.webservice.WSStringArray getIndexDirections() {
        return indexDirections;
    }
    
    public void setIndexDirections(com.amalto.core.webservice.WSStringArray indexDirections) {
        this.indexDirections = indexDirections;
    }
    
    public int getStart() {
        return start;
    }
    
    public void setStart(int start) {
        this.start = start;
    }
    
    public int getLimit() {
        return limit;
    }
    
    public void setLimit(int limit) {
        this.limit = limit;
    }
}