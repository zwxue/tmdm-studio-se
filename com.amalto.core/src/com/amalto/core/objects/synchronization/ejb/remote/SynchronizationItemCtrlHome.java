/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.synchronization.ejb.remote;

/**
 * Home interface for SynchronizationItemCtrl.
 * @xdoclet-generated at 15-04-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface SynchronizationItemCtrlHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/SynchronizationItemCtrl";
   public static final String JNDI_NAME="amalto/remote/core/synchronizationItemctrl";

   public com.amalto.core.objects.synchronization.ejb.remote.SynchronizationItemCtrl create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
