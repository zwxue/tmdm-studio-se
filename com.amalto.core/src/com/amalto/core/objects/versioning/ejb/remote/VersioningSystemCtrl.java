/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.versioning.ejb.remote;

/**
 * Remote interface for VersioningSystemCtrl.
 * @xdoclet-generated at 13-08-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface VersioningSystemCtrl
   extends javax.ejb.EJBObject
{
   /**
    * Creates or updates a VersioningSystem
    * @throws XtentisException
    */
   public com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK putVersioningSystem( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJO versioningSystem )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get item
    * @throws XtentisException
    */
   public com.amalto.core.objects.versioning.ejb.VersioningSystemPOJO getVersioningSystem( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get a VersioningSystem - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.versioning.ejb.VersioningSystemPOJO existsVersioningSystem( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Remove an item
    * @throws XtentisException
    */
   public com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK removeVersioningSystem( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all VersioningSystem PKS
    * @throws XtentisException
    */
   public java.util.ArrayList getVersioningSystemPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Sets the default versioning system
    * @throws XtentisException
    */
   public com.amalto.core.objects.versioning.util.VersioningServiceCtrlLocalBI setDefaultVersioningSystem( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Returns a string starting with OK if the service is available else returns the reason why it is not Pass null for the pk, if you want to test the availability of the default system
    * @throws XtentisException
    */
   public java.lang.String getVersioningSystemAvailability( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Tag Objects
    * @throws XtentisException
    */
   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK tagObjectsAsJob( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK versioningSystemPOJOPK,java.lang.String tag,java.lang.String comment,java.lang.String type,java.lang.String[] instances )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Tag Items
    * @throws XtentisException
    */
   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK tagItemsAsJob( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK versioningSystemPOJOPK,java.lang.String tag,java.lang.String comment,com.amalto.core.ejb.ItemPOJOPK[] itemPKs )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Restore Objects
    * @throws XtentisException
    */
   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK restoreObjectsAsJob( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK versioningSystemPOJOPK,java.lang.String tag,java.lang.String type,java.lang.String[] instances )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Restore Items
    * @throws XtentisException
    */
   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK restoreItemsAsJob( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK versioningSystemPOJOPK,java.lang.String tag,com.amalto.core.ejb.ItemPOJOPK[] itemPKs )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Restore Items
    * @throws XtentisException
    */
   public com.amalto.core.webservice.WSVersioningObjectsHistory getObjectsHistory( com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK versioningSystemPOJOPK,java.lang.String type,java.lang.String[] instances )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

}
