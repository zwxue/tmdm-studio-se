/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.routing.v2.ejb.remote;

/**
 * Home interface for RoutingEngineV2Ctrl.
 * @xdoclet-generated at 14-04-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface RoutingEngineV2CtrlHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/RoutingEngineV2Ctrl";
   public static final String JNDI_NAME="amalto/remote/core/routingenginev2ctrl";

   public com.amalto.core.objects.routing.v2.ejb.remote.RoutingEngineV2Ctrl create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
