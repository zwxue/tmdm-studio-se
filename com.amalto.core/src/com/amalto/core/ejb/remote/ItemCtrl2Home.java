/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.ejb.remote;

/**
 * Home interface for ItemCtrl2.
 * @xdoclet-generated at 17-04-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface ItemCtrl2Home
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/ItemCtrl2";
   public static final String JNDI_NAME="amalto/remote/core/itemctrl2";

   public com.amalto.core.ejb.remote.ItemCtrl2 create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
