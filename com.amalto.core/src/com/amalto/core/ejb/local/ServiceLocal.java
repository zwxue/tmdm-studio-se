/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.ejb.local;

/**
 * Local interface for Service.
 * @xdoclet-generated at 13-08-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface ServiceLocal
   extends javax.ejb.EJBLocalObject
{

   public java.lang.String getServiceName(  ) ;

   public java.lang.String getConfiguration(  ) ;

   public void setConfiguration( java.lang.String configuration ) ;

   /**
    * Any Data hat is not configuration
    */
   public java.lang.String getServiceData(  ) ;

   public void setServiceData( java.lang.String serviceData ) ;

   public com.amalto.core.ejb.remote.ServiceValue getServiceValue(  ) ;

}