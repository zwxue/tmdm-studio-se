 /*
 * Generated by XDoclet - Do not edit!
 * this class was prodiuced by xdoclet automagically...
 */
package com.amalto.core.objects.transformers.v2.ejb.remote;

import java.util.*;

/**
 * This class is remote adapter to TransformerV2Ctrl. It provides convenient way to access
 * facade session bean. Inverit from this class to provide reasonable caching and event handling capabilities.
 *
 * Remote facade for TransformerV2Ctrl.
 * @xdoclet-generated at 13-08-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */

public class TransformerV2CtrlRemote extends Observable
{
    static TransformerV2CtrlRemote _instance = null;
    public static TransformerV2CtrlRemote getInstance() {
        if(_instance == null) {
	   _instance = new TransformerV2CtrlRemote();
	}
	return _instance;
    }

  /**
   * cached remote session interface
   */
  com.amalto.core.objects.transformers.v2.ejb.remote.TransformerV2Ctrl _session = null;
  /**
   * return session bean remote interface
   */
   protected com.amalto.core.objects.transformers.v2.ejb.remote.TransformerV2Ctrl getSession() {
      try {
   	if(_session == null) {
	   _session = com.amalto.core.objects.transformers.v2.ejb.local.TransformerV2CtrlUtil.getHome().create();
	}
	return _session;
      } catch(Exception ex) {
        // just catch it here and return null.
        // somebody can provide better solution
	ex.printStackTrace();
	return null;
      }
   }

   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK putTransformer ( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO transformer )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK retval;
       retval =  getSession().putTransformer( transformer );

      return retval;

   }

   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO getTransformer ( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO retval;
       retval =  getSession().getTransformer( pk );

      return retval;

   }

   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO existsTransformer ( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO retval;
       retval =  getSession().existsTransformer( pk );

      return retval;

   }

   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK removeTransformer ( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK retval;
       retval =  getSession().removeTransformer( pk );

      return retval;

   }

   public java.util.Collection getTransformerPKs ( java.lang.String regex )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        java.util.Collection retval;
       retval =  getSession().getTransformerPKs( regex );

      return retval;

   }

   public com.amalto.core.objects.transformers.v2.util.TransformerContext extractThroughTransformer ( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK transformerV2POJOPK,com.amalto.core.ejb.ItemPOJOPK itemPOJOPK )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.util.TransformerContext retval;
       retval =  getSession().extractThroughTransformer( transformerV2POJOPK,itemPOJOPK );

      return retval;

   }

   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK executeAsJob ( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK retval;
       retval =  getSession().executeAsJob( context,callBack );

      return retval;

   }

   public void execute ( com.amalto.core.objects.universe.ejb.UniversePOJO universe,com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
      getSession().execute( universe,context,callBack );

   }

   public void execute ( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
      getSession().execute( context,callBack );

   }

   public void execute ( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TypedContent content,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
      getSession().execute( context,content,callBack );

   }

   public com.amalto.core.objects.transformers.v2.util.TransformerContext executeUntilDone ( com.amalto.core.objects.transformers.v2.util.TransformerContext context )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.util.TransformerContext retval;
       retval =  getSession().executeUntilDone( context );

      return retval;

   }

   public com.amalto.core.objects.transformers.v2.util.TransformerContext executeUntilDone ( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TypedContent content )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.transformers.v2.util.TransformerContext retval;
       retval =  getSession().executeUntilDone( context,content );

      return retval;

   }

  /**
   * override this method to provide feedback to interested objects
   * in case collections were changed.
   */
  public void invalidate() {

  	setChanged();
	notifyObservers();
  }
}
