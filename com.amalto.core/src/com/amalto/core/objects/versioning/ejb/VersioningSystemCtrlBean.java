package com.amalto.core.objects.versioning.ejb;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalHome;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.amalto.core.ejb.ItemPOJOPK;
import com.amalto.core.ejb.ObjectPOJO;
import com.amalto.core.ejb.ObjectPOJOPK;
import com.amalto.core.ejb.local.XmlServerSLWrapperLocal;
import com.amalto.core.ejb.local.XmlServerSLWrapperLocalHome;
import com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJO;
import com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK;
import com.amalto.core.objects.configurationinfo.util.XtentisConfiguration;
import com.amalto.core.objects.universe.ejb.UniversePOJO;
import com.amalto.core.objects.versioning.util.RestoreItemsInfo;
import com.amalto.core.objects.versioning.util.RestoreObjectsInfo;
import com.amalto.core.objects.versioning.util.TagItemsInfo;
import com.amalto.core.objects.versioning.util.TagObjectsInfo;
import com.amalto.core.objects.versioning.util.VersioningServiceCtrlLocalBI;
import com.amalto.core.util.JobActionInfo;
import com.amalto.core.util.LocalUser;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;
import com.amalto.core.webservice.WSVersioningObjectsHistory;
import com.amalto.core.webservice.WSVersioningObjectsHistoryObjects;



/**
 * @author Bruno Grieder
 * 
 * @ejb.bean 	name="VersioningSystemCtrl"
 *           	display-name="Name for VersioningSystemCtrl"
 *           	description="Description for VersioningSystemCtrl"
 *           	jndi-name="amalto/remote/core/versioningsystemctrl"
 * 		  		local-jndi-name = "amalto/local/core/versioningsystemctrl"
 *           	type="Stateless"
 *           	view-type="both"
 * 
 * @ejb.remote-facade
 * 
 * @ejb.permission
 * 	view-type = "remote"
 * 	role-name = "administration"
 * @ejb.permission
 * 	view-type = "local"
 * 	unchecked = "true"
 *  
 */
public class VersioningSystemCtrlBean implements SessionBean, TimedObject{
	
    public static String DEFAULT_JNDI = "amalto/local/service/svn";
    public static String DEFAULT_URL = "svn://localhost/opt/svn";
    public static String DEFAULT_USERNAME = "xtentis";
    public static String DEFAULT_PASSWORD = "xtentis";
    
	static {

		try {
			Properties properties = XtentisConfiguration.getConfiguration();
			if (properties.getProperty("versioning.service.jndi")!=null)
				DEFAULT_JNDI =  properties.getProperty("versioning.service.jndi");
			if(properties.getProperty("versioning.service.url")!=null)
				DEFAULT_URL = properties.getProperty("versioning.service.url");
			if (properties.getProperty("versioning.service.username")!=null)
				DEFAULT_USERNAME = properties.getProperty("versioning.service.username");
			if (properties.getProperty("versioning.service.password")!=null)
				DEFAULT_PASSWORD = properties.getProperty("versioning.service.password");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public static final long serialVersionUID = 1L;
		
	private SessionContext sessionContext;
	
	
	
    /**
     * VersioningSystemCtrlBean.java
     * Constructor
     * 
     */
    public VersioningSystemCtrlBean() {
        super();
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext ctx)
        throws EJBException,
        RemoteException {
    	sessionContext=ctx;
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() throws EJBException, RemoteException {
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() throws EJBException, RemoteException {
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() throws EJBException, RemoteException {
    }
    
    /**
     * Create method
     * @ejb.create-method  view-type = "local"
     */
    public void ejbCreate() throws javax.ejb.CreateException {}
    
    /**
     * Post Create method
     */
    public void ejbPostCreate() throws javax.ejb.CreateException {}
    
    
    
    /**
     * Creates or updates a VersioningSystem
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public VersioningSystemPOJOPK putVersioningSystem(VersioningSystemPOJO versioningSystem) throws XtentisException{  
    	
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("putVersioningSystem() ");
    	
        try {
            
        	VersioningSystemPOJOPK pk = new VersioningSystemPOJOPK(versioningSystem.store());
            if (pk == null) {
        	    String err = "Unable to create/update the VersioningSystem. "+versioningSystem.getLastError();
        	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
            	throw new XtentisException(versioningSystem.getLastError());
            }
            
            return pk;
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to create/update the VersioningSystem "+versioningSystem.getName()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
    	    throw new XtentisException(err);
	    }

    }
    
     
    /**
     * Get item
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public VersioningSystemPOJO getVersioningSystem(VersioningSystemPOJOPK pk) throws XtentisException{

        try {
        	VersioningSystemPOJO versioningSystem =  ObjectPOJO.load(VersioningSystemPOJO.class,pk);
        	if (versioningSystem == null) {
        		String err= "The VersioningSystem "+pk.getUniqueId()+" does not exist.";
        		org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
        		throw new XtentisException(err);
        	}
        		
        	return versioningSystem;
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to get the VersioningSystem "+pk.toString()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
    	    throw new XtentisException(err);
	    }
    }
    
    /**
     * Get a VersioningSystem - no exception is thrown: returns null if not found 
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public VersioningSystemPOJO existsVersioningSystem(VersioningSystemPOJOPK pk)    throws XtentisException{
    	
        try {
        	return ObjectPOJO.load(VersioningSystemPOJO.class,pk);
	    } catch (XtentisException e) {
	    	return null;
	    } catch (Exception e) {
    	    String info = "Could not check whether this VersioningSystem exists:  "+pk.toString()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).debug(info, e);
    	   return null;
	    }
    }
    

    /**
     * Remove an item
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public VersioningSystemPOJOPK removeVersioningSystem(VersioningSystemPOJOPK pk) 
    throws XtentisException{
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("Removing "+pk.getUniqueId());

        try {
        	return new VersioningSystemPOJOPK(ObjectPOJO.remove(VersioningSystemPOJO.class, pk));
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to remove the VersioningSystem "+pk.toString()
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
    	    throw new XtentisException(err);
	    }
    }    
    
    
    /**
	 * Retrieve all VersioningSystem PKS 
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */       
    public ArrayList<VersioningSystemPOJOPK> getVersioningSystemPKs(String regex) throws XtentisException {
    	ArrayList<ObjectPOJOPK> c = ObjectPOJO.findAllPKs(VersioningSystemPOJO.class,regex);
    	ArrayList<VersioningSystemPOJOPK> l = new ArrayList<VersioningSystemPOJOPK>();
    	for (Iterator<ObjectPOJOPK> iter = c.iterator(); iter.hasNext(); ) {
			l.add(new VersioningSystemPOJOPK(iter.next()));
		}
    	return l;
    }
    
    
    /**
	 * Sets the default versioning system 
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */       
    public VersioningServiceCtrlLocalBI setDefaultVersioningSystem(VersioningSystemPOJOPK pk) throws XtentisException {
    	try {
			//retrieve the configuration
			//Get the versioning service
    		VersioningSystemPOJO pojo = null;;
    		String jndi = DEFAULT_JNDI;
    		if (pk != null) {
    			pojo = getVersioningSystem(pk);
    			jndi = pojo.getJndi();
    		}
    		
    		/*
    		Object serv  = 
				Util.retrieveComponent(
						null, 
						jndi
				);
    		
    		System.out.println("service super Class "+serv.getClass().getSuperclass().getName());
    		Class[] clazzes = serv.getClass().getInterfaces();
    		if (clazzes!=null) {
    			for (int i = 0; i < clazzes.length; i++) {
    				System.out.println("Implementing Class "+clazzes[i].getName());
				}
    		}
    		*/
    		
    		
			VersioningServiceCtrlLocalBI service =	getVersioningService(jndi);
			
			if (service == null) {
				String err = "No versioning service is available at JNDI entry "+DEFAULT_JNDI;
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
			if (pk!=null) {
				service.setCurrentVersioningSystemConfiguration(
						pojo.getName(),
						pojo.getUrl(), 
						pojo.getUsername(), 
						pojo.getPassword()
				); 
			}else {
				service.setCurrentVersioningSystemConfiguration(
					"[DEFAULT]",
					DEFAULT_URL, 
					DEFAULT_USERNAME, 
					DEFAULT_PASSWORD
				);
			}
			
			return service;
    	} catch (XtentisException e) {
    		throw(e);
		} catch (Exception e) {
			String err = "Unable to set the default versioning system to "+(pk==null ? "[DEFAULT]" : pk.getUniqueId())+": "
								+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
		    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
		    throw new XtentisException(err);
		}
    }
    
    /**
	 * Returns a string starting with OK if the service is available else returns the reason why it is not
	 * Pass null for the pk, if you want to test the availability of the default system
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */       
    public String getVersioningSystemAvailability(VersioningSystemPOJOPK pk) throws XtentisException {
    	try {

    		//check if user has the right
    		if (!"admin".equals(LocalUser.getLocalUser().getUsername())) {
	    		if (!LocalUser.getLocalUser().getRoles().contains("versioning")) {
	    			return "User "+LocalUser.getLocalUser().getUsername()+" does not have the versioning role";
	    		}
    		}
    		
    		//if service not default try to retirve the conf
    		String jndi = DEFAULT_JNDI;
    		try {
	    		if (pk!=null) {
	    			VersioningSystemPOJO vs = getVersioningSystem(pk);
	    			jndi = vs.getJndi();
	    		}
        	}catch (Exception ex) {
        		return "Versioning system "+(pk.getUniqueId()==null ? "[DEFAULT]" : pk.getUniqueId())+" does not exist";
        	}
    		
        	//try to access the service itfself
        	try {
    				Util.retrieveComponent(
    					null, 
    					jndi
    				);
        	}catch (Exception ex) {
        		return "Versioning system "+(pk ==null ? "[DEFAULT]" : pk.getUniqueId())+" cannot be accessed at JNDI "+jndi;
        	}

        	return "OK - Service at "+jndi;
    	} catch (XtentisException e) {
    		throw(e);
		} catch (Exception e) {
			String err = "Unable to determine the availability of versioning system "+(pk ==null ? "[DEFAULT]" : pk.getUniqueId())+": "
								+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
		    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
		    throw new XtentisException(err);
		}
    }
    
    
    /**
	 * Tag Objects
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */   
    public BackgroundJobPOJOPK tagObjectsAsJob(
    		VersioningSystemPOJOPK versioningSystemPOJOPK,
    		String tag,
    		String comment,
    		String type,
    		String[] instances
		)throws XtentisException{
    	
		BackgroundJobPOJO bgPOJO = new BackgroundJobPOJO();
    	
    	try{
			//create a Background Job
			bgPOJO.setDescription("Execute Tagging of type '"+type+"' with tag '"+tag+"' as a Background Job");
			bgPOJO.setMessage("Scheduling the job");
			bgPOJO.setPercentage(-1);
			bgPOJO.setSerializedObject(null);
			bgPOJO.setStatus(BackgroundJobPOJO._SCHEDULED_);
			bgPOJO.setTimestamp(sdf.format(new Date(System.currentTimeMillis())));
			bgPOJO.store();
			//Instantiate processing info
			TagObjectsInfo tagObjectsInfo = new TagObjectsInfo(
					versioningSystemPOJOPK,
					tag,
					comment,
					LocalUser.getLocalUser().getUsername(),
					type,
					instances
			);
			//launch job in background
			JobActionInfo actionInfo = new JobActionInfo(
					bgPOJO.getId(),
					LocalUser.getLocalUser().getUniverse(),
					"Tagging of objects type '"+type+"' with tag '"+tag+"'",
					tagObjectsInfo
			); 
			createTimer(actionInfo);
        	
		} catch (Exception e) {
			try {
				String err = "Unable to Execute Tagging of type "+type+" --> tag "+tag+" as a Background Job"
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob((BackgroundJobPOJOPK)bgPOJO.getPK(), err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
		return new BackgroundJobPOJOPK(bgPOJO.getPK());
    }
    
    /**
     * The actual Method call by the timer
     * @param info
     */
    private void executeTagObjects(
    		BackgroundJobPOJOPK backgroundJobPK,
    		TagObjectsInfo info
    ) {
    	try {
    		updateBackGroundJob(backgroundJobPK, "Accessing versioning server");
    		
    		//Check that the Object exists by retrieving its Object Class
    		Class<?> theClass = ObjectPOJO.getObjectClass(info.getType());
    		if ( theClass == null) {
				String err = "Unable to tag Object Type "+info.getType()+": the type does not exist";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}
    		if (! ObjectPOJO.class.isAssignableFrom(theClass)) {
    			String err = "Unable to tag Object Type "+info.getType()+": the type is not supported";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}

    		//Get the cluster name associated with it
    		String clusterName = ObjectPOJO.getCluster((Class<? extends ObjectPOJO>)theClass);
    		
			//Get the versioning service
    		VersioningServiceCtrlLocalBI service = setDefaultVersioningSystem(info.getVersioningSystemPOJOPK());

   	    	//get the universe and revision ID for this Object
	    	UniversePOJO universe = LocalUser.getLocalUser().getUniverse();
	    	if (universe == null) {
	    		String err = "ERROR: no Universe set for user '"+LocalUser.getLocalUser().getUsername()+"'";
	    		org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
	    		throw new XtentisException(err);
	    	}
	    	String revisionID = universe.getXtentisObjectsRevisionIDs().get(ObjectPOJO.getObjectsClasses2NamesMap().get(
	    		theClass)
	    	);
	    	
            //get the xml server wrapper
    		
            //get the xml server wrapper
            XmlServerSLWrapperLocal server = null;
			try {
				server  =  ((XmlServerSLWrapperLocalHome)new InitialContext().lookup(XmlServerSLWrapperLocalHome.JNDI_NAME)).create();
			} catch (Exception e) {
				String err = "Unable to access the XML Server "+e.getClass().getName()+": "+e.getLocalizedMessage();
				org.apache.log4j.Logger.getLogger(ObjectPOJO.class).error(err);
				throw new XtentisException(err);
			}
    		    		
    		//Check if we need to tag all the instances
    		if (info.getInstances() == null) {
    			//1-First synchronize the head by running a clean
    			//retrieve the list of current instances
    			updateBackGroundJob(backgroundJobPK, "Cleanning up head of "+clusterName);
    			String[] instances = server.getAllDocumentsUniqueID(revisionID,clusterName);
    			/*
    	    	Collection<String> res =  server.directQuery(
    	    			clusterName, 
    	    			"for $doc in /ii return concat($doc/c,\".\",$doc/n,\".\",string-join($doc/i,\".\"))",
    	    			null
    	    	);
    	    	String[] instances = null;
    	    	if ((res!= null) && (res.size() > 0)) 
    	    		instances = res.toArray(new String[res.size()]);
				*/
    			if (instances == null) {
    				String err = "Unable to tag all the instances of "+clusterName+": the cluster is empty";
    				org.apache.log4j.Logger.getLogger(ObjectPOJO.class).error(err);
    				throw new XtentisException(err);    				
    			}
    			//run clean
    			service.clean(clusterName, instances);
    			//2-Commit to the head
    			updateBackGroundJob(backgroundJobPK, "Committing to the head of "+clusterName);
    			for (int i = 0; i < instances.length; i++) {
    				String xml = server.getDocumentAsString(revisionID, clusterName, instances[i]);
    				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(instances[i],"UTF-8");
		            service.commit(path, xml, info.getComment(), info.getUsername());
		            if (info.getType().equals("Data Cluster")) {
		            	//commit the whole items
		            	tagAllItems(
		            			backgroundJobPK, 
		            			server, 
		            			service, 
		            			revisionID,
		            			instances[i], 
		            			info.getTag(),
		            			info.getComment(), 
		            			info.getUsername()
		            	);
		            }
				}  
    			//3 - branch the whole cluster
    			updateBackGroundJob(backgroundJobPK, "Branching the head of "+clusterName+" to tag "+info.getTag());
    			service.branch(URLEncoder.encode(clusterName,"UTF-8"), info.getTag(), info.getComment(), info.getUsername());
    		} else {
	    		//tag separate instances - we only need to commit and branch
    			updateBackGroundJob(backgroundJobPK, "Tagging in "+clusterName+" with tag "+info.getTag());
	    		for (int i = 0; i < info.getInstances().length; i++) {	    			
	    			String xml = server.getDocumentAsString(revisionID, clusterName, info.getInstances()[i]);
	    			String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(info.getInstances()[i],"UTF-8");
	    			service.commit(path, xml,info.getComment(), info.getUsername());
	    			service.branch(path, info.getTag(),info.getComment(), info.getUsername());
		            if (info.getType().equals("Data Cluster")) {
		            	//commit the whole items
		            	tagAllItems(
		            			backgroundJobPK, 
		            			server, 
		            			service, 
		            			revisionID,
		            			info.getInstances()[i], 
		            			info.getTag(),
		            			info.getComment(), 
		            			info.getUsername()
		            	);
		            }
				}
    		}
    		
			try {
				String message = "Successfully completed Tagging of type "+info.getType()+" --> tag "+info.getTag();
				updateBackGroundJob(backgroundJobPK, message,BackgroundJobPOJO._COMPLETED_);
			} catch (Exception e) {
				String err = "Objects Tagging done but unable to store the result in the background object: "
									+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
	    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
	    	    throw new XtentisException(err);
			}
    		
		} catch (Exception e) {
			try {
	    	    String err = "Unable to Execute Tagging of type "+info.getType()+" --> tag "+info.getTag()+" as a Background Job"
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob(backgroundJobPK, err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
    	
    }

    /**
     * Tag all Items in a Data Cluster
     * @param pk
     * @param server
     * @param service
     * @param revisionID
     * @param clusterName
     * @param tag
     * @param comment
     * @param username
     * @throws NamingException
     * @throws CreateException
     * @throws XtentisException
     * @throws UnsupportedEncodingException
     */
    private void tagAllItems(
    		BackgroundJobPOJOPK pk, 
    		XmlServerSLWrapperLocal server, 
    		VersioningServiceCtrlLocalBI service, 
    		String revisionID,
    		String clusterName, 
    		String tag,
    		String comment,
    		String username
    ) throws NamingException, CreateException, XtentisException, UnsupportedEncodingException{
    	updateBackGroundJob(pk, "Tagging items "+clusterName+" to tag "+tag);
    	long counter = 0; 
    	Collection<String> res =  server.runQuery(
    			revisionID,
    			clusterName, 
    			"for $doc in /ii return concat($doc/c,\".\",$doc/n,\".\",string-join($doc/i,\".\"))",
    			null
    	);
    	String[] instances = null;
    	if ((res!= null) && (res.size() > 0)) 
    		instances = res.toArray(new String[res.size()]);
//    	String[] instances = server.getAllDocumentsUniqueID(clusterName);  ---  problem with long names at eXist level
    	if (instances == null) {
    		//the cluster is empty --> empty the head
    		service.clean(clusterName, new String[0]);
    	} else {
    		service.clean(clusterName, instances);
    		for (int i = 0; i < instances.length; i++) {
				counter++;
				if ((i+1)%10 == 0) 
					updateBackGroundJob(pk, "Tagging item "+(i+1)+" out of "+instances.length);
				String xml = server.getDocumentAsString(revisionID, clusterName, instances[i]);
				System.out.println("Tagging "+clusterName+"/"+instances[i]+" "+(xml!=null ? "\n"+xml.substring(0,500) : "NULL"));
				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(instances[i],"UTF-8");
    			service.commit(path, xml, comment, username);
    			service.branch(path, tag,comment, username);				
			}
    	}
    }
    
    /**
     * Restores all items in a Data Cluster
     * @param pk
     * @param server
     * @param service
     * @param revisionID
     * @param clusterName
     * @param tag
     * @param username
     * @throws NamingException
     * @throws CreateException
     * @throws XtentisException
     * @throws UnsupportedEncodingException
     */
    private void restoreAllItems(
    		BackgroundJobPOJOPK pk, 
    		XmlServerSLWrapperLocal server, 
    		VersioningServiceCtrlLocalBI service, 
    		String revisionID,
    		String clusterName, 
    		String tag,
    		String username
    ) throws NamingException, CreateException, XtentisException,UnsupportedEncodingException{
    	updateBackGroundJob(pk, "Restoring items "+clusterName+" to tag "+tag);

    	long counter = 0;
    	
    	//delete existing items
    	updateBackGroundJob(pk, "Cleaning up existing items");
    	server.deleteCluster(revisionID, clusterName);
    	server.createCluster(revisionID, clusterName);
    	
    	//put items inside
    	updateBackGroundJob(pk, "Starting items restoration from tag "+tag);
    	String[] instances = service.getInstances(clusterName, tag);
    	if (instances != null) {
    		for (int i = 0; i < instances.length; i++) {
    			String instance = URLDecoder.decode(instances[i],"UTF-8");
    			System.out.println("restoring item "+clusterName+"/"+instance);
				counter++;
				if ((i+1)%10 == 0) 
					updateBackGroundJob(pk, "Restoring item "+(i+1)+" out of "+instances.length);
				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(instance,"UTF-8");
				String[] xmls = service.checkOut(path, tag);
				String xml = xmls[0].replaceAll("<\\?.*?\\?>", "");
				server.putDocumentFromString(xml, instance, clusterName, revisionID);
			}
    	} else {
    		System.out.println("No items to restore");
    	}
    }
    
    /**
	 * Tag Items
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */   
    public BackgroundJobPOJOPK tagItemsAsJob(
    		VersioningSystemPOJOPK versioningSystemPOJOPK,
    		String tag,
    		String comment,
    		ItemPOJOPK[] itemPKs
		)throws XtentisException{
    	
		BackgroundJobPOJO bgPOJO = new BackgroundJobPOJO();
    	
    	try{
			//create a Background Job
			bgPOJO.setDescription("Execute Tagging of items with tag '"+tag+"' as a Background Job");
			bgPOJO.setMessage("Scheduling the job");
			bgPOJO.setPercentage(-1);
			bgPOJO.setSerializedObject(null);
			bgPOJO.setStatus(BackgroundJobPOJO._SCHEDULED_);
			bgPOJO.setTimestamp(sdf.format(new Date(System.currentTimeMillis())));
			bgPOJO.store();
			//Instantiate processing info
			TagItemsInfo tagObjectsInfo = new TagItemsInfo(
					versioningSystemPOJOPK,
					tag,
					comment,
					LocalUser.getLocalUser().getUsername(),
					itemPKs
			);
			//launch job in background
			JobActionInfo actionInfo = new JobActionInfo(
					bgPOJO.getId(),
					LocalUser.getLocalUser().getUniverse(),
					"Tagging of items with tag '"+tag+"'",
					tagObjectsInfo
			); 
			createTimer(actionInfo);
	
		} catch (Exception e) {
			try {
				String err = "Unable to Execute Tagging of items with tag "+tag+" as a Background Job"
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob((BackgroundJobPOJOPK)bgPOJO.getPK(), err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
		return new BackgroundJobPOJOPK(bgPOJO.getPK());
    }
    
    /**
     * The actual Method call by the timer
     * @param info
     */
    private void executeTagItems(
    		BackgroundJobPOJOPK backGroundJobPK,
    		TagItemsInfo info
    ) {
    	try {

    		updateBackGroundJob(backGroundJobPK, "Accessing versioning server");
    		
			//Get the versioning service
    		VersioningServiceCtrlLocalBI service = setDefaultVersioningSystem(info.getVersioningSystemPOJOPK());
    		
    		//get the universe and revision ID - this assumes the user is kept across the timeout call...
    		UniversePOJO universe = LocalUser.getLocalUser().getUniverse();
    		if (universe == null) {
    			String err = "ERROR: no Universe set for user '"+LocalUser.getLocalUser().getUsername()+"'";
    			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    			throw new XtentisException(err);
    		}
    		
            //get the xml server wrapper
            XmlServerSLWrapperLocal server = null;
			try {
				server  =  ((XmlServerSLWrapperLocalHome)new InitialContext().lookup(XmlServerSLWrapperLocalHome.JNDI_NAME)).create();
			} catch (Exception e) {
				String err = "Unable to access the XML Server "+e.getClass().getName()+": "+e.getLocalizedMessage();
				org.apache.log4j.Logger.getLogger(ObjectPOJO.class).error(err);
				throw new XtentisException(err);
			}
			
    		
    		updateBackGroundJob(backGroundJobPK, "Starting tagging of items with tag "+info.getTag());
    		for (int i = 0; i < info.getItemPKs().length; i++) {
    			ItemPOJOPK pk = info.getItemPKs()[i];
        		String revisionID = universe.getConceptRevisionID(pk.getConceptName());
				String clusterName = pk.getDataClusterPOJOPK().getUniqueId();
				String uniqueID = pk.getUniqueID();
				String xml = server.getDocumentAsString(revisionID, clusterName, uniqueID);
				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(uniqueID,"UTF-8");
				service.commit(path, xml, info.getComment(), info.getUsername());
				service.branch(path, info.getTag(),info.getComment(), info.getUsername());
			}
    		
			try {
				String message = "Susccessfully completed Tagging of "+info.getItemPKs().length+" item(s) with tag "+info.getTag();
				updateBackGroundJob(backGroundJobPK, message, BackgroundJobPOJO._COMPLETED_);
			} catch (Exception e) {
				String err = "Items Tagging done but unable to store the result in the background object: "
									+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
	    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
	    	    throw new XtentisException(err);
			}
    		
		} catch (Exception e) {
			try {
	    	    String err = "Unable to Execute the Tagging of "+info.getItemPKs().length+" item(s) with tag "+info.getTag()
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob(backGroundJobPK, err, BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
    	
    }

    
    /**
	 * Restore Objects
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */   
    public BackgroundJobPOJOPK restoreObjectsAsJob(
    		VersioningSystemPOJOPK versioningSystemPOJOPK,
    		String tag,
    		String type,
    		String[] instances
		)throws XtentisException{
    	
		BackgroundJobPOJO bgPOJO = new BackgroundJobPOJO();
    	
    	try{
			//create a Background Job
			bgPOJO.setDescription("Restoring type '"+type+"' with tag '"+tag+"' as a Background Job");
			bgPOJO.setMessage("Scheduling the job");
			bgPOJO.setPercentage(-1);
			bgPOJO.setSerializedObject(null);
			bgPOJO.setStatus(BackgroundJobPOJO._SCHEDULED_);
			bgPOJO.setTimestamp(sdf.format(new Date(System.currentTimeMillis())));
			bgPOJO.store();
			//Instantiate processing info
			RestoreObjectsInfo restoreObjectsInfo = new RestoreObjectsInfo(
					versioningSystemPOJOPK,
					tag,
					LocalUser.getLocalUser().getUsername(),
					type,
					instances
			);
			//launch job in background
			JobActionInfo actionInfo = new JobActionInfo(
					bgPOJO.getId(),
					LocalUser.getLocalUser().getUniverse(),
					"Restoring objects type '"+type+"' with tag '"+tag+"'",
					restoreObjectsInfo
			); 
			createTimer(actionInfo);
        	
		} catch (Exception e) {
			try {
				String err = "Unable to Restore type "+type+" --> tag "+tag+" as a Background Job"
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob((BackgroundJobPOJOPK)bgPOJO.getPK(), err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
		return new BackgroundJobPOJOPK(bgPOJO.getPK());
    }
    
    /**
     * The actual Method call by the timer
     * @param info
     */
    private void executeRestoreObjects(
    		BackgroundJobPOJOPK backGroundJobPK,
    		RestoreObjectsInfo info
    ) {
    	try {

    		updateBackGroundJob(backGroundJobPK, "Accessing versioning server");
    		
    		//Check that the Object exists by retrieving its Object Class
    		Class<?> theClass = ObjectPOJO.getObjectClass(info.getType());
    		if ( theClass == null) {
				String err = "Unable to restore Object Type "+info.getType()+": the type does not exist";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}
    		if (! ObjectPOJO.class.isAssignableFrom(theClass)) {
    			String err = "Unable to restore Object Type "+info.getType()+": the type is not supported";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}

    		//Get the cluster name associated with it
    		String clusterName = ObjectPOJO.getCluster((Class<? extends ObjectPOJO>)theClass);
    		
			//Get the versioning service
    		VersioningServiceCtrlLocalBI service = setDefaultVersioningSystem(info.getVersioningSystemPOJOPK());

   	    	//get the universe and revision ID for this Object
	    	UniversePOJO universe = LocalUser.getLocalUser().getUniverse();
	    	if (universe == null) {
	    		String err = "ERROR: no Universe set for user '"+LocalUser.getLocalUser().getUsername()+"'";
	    		org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
	    		throw new XtentisException(err);
	    	}
	    	String revisionID = universe.getXtentisObjectsRevisionIDs().get(ObjectPOJO.getObjectsClasses2NamesMap().get(
	    		theClass)
	    	);
    		
    		//check if we use a new configuration
    		if (info.getVersioningSystemPOJOPK() != null) {
    			VersioningSystemPOJO pojo = getVersioningSystem(info.getVersioningSystemPOJOPK());
    			service.setCurrentVersioningSystemConfiguration(
    					pojo.getName(),
    					pojo.getUrl(), 
    					pojo.getUsername(), 
    					pojo.getPassword()
    			);
    		}
    		
            //get the xml server wrapper
            XmlServerSLWrapperLocal server = null;
			try {
				server  =  ((XmlServerSLWrapperLocalHome)new InitialContext().lookup(XmlServerSLWrapperLocalHome.JNDI_NAME)).create();
			} catch (Exception e) {
				String err = "Unable to access the XML Server "+e.getClass().getName()+": "+e.getLocalizedMessage();
				org.apache.log4j.Logger.getLogger(ObjectPOJO.class).error(err);
				throw new XtentisException(err);
			}
    		
    		updateBackGroundJob(backGroundJobPK, "Starting restore of objects with tag "+info.getTag());
    		long counter=0;
    		
    		if (info.getInstances() == null) {
    			//restore the whole cluster
    			//1- grab all instances names
    			String[] encodedInstances = service.getInstances(clusterName, info.getTag());
				if (encodedInstances==null) {
					String err = "Unable to check out objects from cluster "+clusterName+" with tag "+info.getTag()+" - no instances found";
					org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
					throw new XtentisException(err);
				}
    			//2- delete the existing content
    			server.deleteCluster(revisionID, clusterName);
    			server.createCluster(revisionID, clusterName);
    			//3 - restore content
    			for (int i = 0; i < encodedInstances.length; i++) {
    				String instance = URLDecoder.decode(encodedInstances[i],"UTF-8");
    				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+encodedInstances[i];
    				String[] xmls = service.checkOut(path, info.getTag());
    				String xml = xmls[0].replaceAll("<\\?.*?\\?>", "");
					if (-1 == server.putDocumentFromString(xml, instance, clusterName, revisionID)) {
						String err = "Unable to re-insert object "+instance+" from cluster "+clusterName+" with tag "+info.getTag()+". An error occured on the XML server";
						org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
						throw new XtentisException(err);
					}
					 if (info.getType().equals("Data Cluster")) {
						 restoreAllItems(backGroundJobPK, server, service, revisionID, instance, info.getTag(), info.getUsername());
					 }
					 counter++;
				}
    		} else {
    			for (int i = 0; i < info.getInstances().length; i++) {
    				System.out.println(" Restoring "+clusterName+(info.getInstances()[i] == null ? "": "/"+info.getInstances()[i])+" <-- "+info.getTag());
    				String path = URLEncoder.encode(clusterName, "UTF-8")+"/"+URLEncoder.encode(info.getInstances()[i],"UTF-8");
    				String[] xmls = service.checkOut(path, info.getTag());
    				System.out.println("Content\n"+xmls[0]);
    				String xml = xmls[0].replaceAll("<\\?.*?\\?>", "");
					server.putDocumentFromString(xml, info.getInstances()[i], clusterName, revisionID);
					 if (info.getType().equals("Data Cluster")) {
						 restoreAllItems(backGroundJobPK, server, service, revisionID, info.getInstances()[i], info.getTag(), info.getUsername());
					 }		
					 counter++;
				}    			
    		}
    		
			try {
				String message = "Successfully restored "+counter+" item(s) with tag "+info.getTag();
				updateBackGroundJob(backGroundJobPK, message, BackgroundJobPOJO._COMPLETED_);
			} catch (Exception e) {
				String err = "Items restore done but unable to store the result in the background object: "
									+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
	    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
	    	    throw new XtentisException(err);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
			try {
	    	    String err = "Unable to Restore "+info.getInstances().length+" item(s) with tag "+info.getTag()
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob(backGroundJobPK, err, BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
    	
    }
    

    
    /**
	 * Restore Items
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */   
    public BackgroundJobPOJOPK restoreItemsAsJob(
    		VersioningSystemPOJOPK versioningSystemPOJOPK,
    		String tag,
    		ItemPOJOPK[] itemPKs
		)throws XtentisException{
    	
		BackgroundJobPOJO bgPOJO = new BackgroundJobPOJO();
    	
    	try{
			//create a Background Job
			bgPOJO.setDescription("Execute Restore of items with tag '"+tag+"' as a Background Job");
			bgPOJO.setMessage("Scheduling the job");
			bgPOJO.setPercentage(-1);
			bgPOJO.setSerializedObject(null);
			bgPOJO.setStatus(BackgroundJobPOJO._SCHEDULED_);
			bgPOJO.setTimestamp(sdf.format(new Date(System.currentTimeMillis())));
			bgPOJO.store();
			//Instantiate processing info
			RestoreItemsInfo tagObjectsInfo = new RestoreItemsInfo(
					versioningSystemPOJOPK,
					tag,
					LocalUser.getLocalUser().getUsername(),
					itemPKs
			);
			//launch job in background
			JobActionInfo actionInfo = new JobActionInfo(
					bgPOJO.getId(),
					LocalUser.getLocalUser().getUniverse(),
					"Restoring items with tag '"+tag+"'",
					tagObjectsInfo
			); 
			createTimer(actionInfo);
	
		} catch (Exception e) {
			try {
				String err = "Unable to Execute Restore items with tag "+tag+" as a Background Job"
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob((BackgroundJobPOJOPK)bgPOJO.getPK(), err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
		return new BackgroundJobPOJOPK(bgPOJO.getPK());
    }
    
    /**
     * The actual Method call by the timer
     * @param info
     */
    private void executeRestoreItems(
    		BackgroundJobPOJOPK backGroundJobPK,
    		RestoreItemsInfo info
    ) {
    	try {

    		updateBackGroundJob(backGroundJobPK, "Accessing versioning server");
    		
			//Get the versioning service
    		VersioningServiceCtrlLocalBI service = setDefaultVersioningSystem(info.getVersioningSystemPOJOPK());
    		
    		//get the universe and revision ID - this assumes the user is kept across the timeout call...
    		UniversePOJO universe = LocalUser.getLocalUser().getUniverse();
    		if (universe == null) {
    			String err = "ERROR: no Universe set for user '"+LocalUser.getLocalUser().getUsername()+"'";
    			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    			throw new XtentisException(err);
    		}

            //get the xml server wrapper
            XmlServerSLWrapperLocal server = null;
			try {
				server  =  ((XmlServerSLWrapperLocalHome)new InitialContext().lookup(XmlServerSLWrapperLocalHome.JNDI_NAME)).create();
			} catch (Exception e) {
				String err = "Unable to access the XML Server "+e.getClass().getName()+": "+e.getLocalizedMessage();
				org.apache.log4j.Logger.getLogger(ObjectPOJO.class).error(err);
				throw new XtentisException(err);
			}
    		
    		updateBackGroundJob(backGroundJobPK, "Stating restoring items with tag "+info.getTag());
    		long counter=0;
    		for (int i = 0; i < info.getItemPKs().length; i++) {
    			ItemPOJOPK pk = info.getItemPKs()[i];
    			String revisionID = universe.getConceptRevisionID(pk.getConceptName());
				String clusterName = pk.getDataClusterPOJOPK().getUniqueId();
				String uniqueID = pk.getUniqueID();
				String path = URLEncoder.encode(clusterName,"UTF-8")+"/"+URLEncoder.encode(uniqueID,"UTF-8");
				String xmls[] = service.checkOut(path, info.getTag());
				if (xmls==null) {
					String err = "Unable to check out item "+clusterName+"/"+uniqueID+" with tag "+info.getTag()+": skipping";
					org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				}
				counter++;
				String xml = xmls[0].replaceAll("<\\?.*?\\?>", "");
				server.putDocumentFromString(xml, uniqueID, clusterName, revisionID);
			}
    		
			try {
				String message = "Successfully restored "+counter+" item(s) with tag "+info.getTag();
				updateBackGroundJob(backGroundJobPK, message, BackgroundJobPOJO._COMPLETED_);
			} catch (Exception e) {
				String err = "Items restore done but unable to store the result in the background object: "
									+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
	    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
	    	    throw new XtentisException(err);
			}
    		
		} catch (Exception e) {
			try {
	    	    String err = "Unable to Restore "+info.getItemPKs().length+" item(s) with tag "+info.getTag()
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob(backGroundJobPK, err, BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
    	
    }
    
    
    
    /**
	 * Restore Items
	 * 
	 * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */   
    public WSVersioningObjectsHistory getObjectsHistory(
    		VersioningSystemPOJOPK versioningSystemPOJOPK,
    		String type,
    		String instances[]
		)throws XtentisException{
    	    	
    	try{
    		    		
    		//Check that the Object exists by retrieving its Object Class
    		Class<?> theClass = ObjectPOJO.getObjectClass(type);
    		if ( theClass == null) {
				String err = "Unable to restore Objects of type "+type+": the type does not exist";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}
    		if (! ObjectPOJO.class.isAssignableFrom(theClass)) {
    			String err = "Unable to restore Object Type "+type+": the type is not supported";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
    		}

    		//Get the cluster name associated with it
    		String clusterName = ObjectPOJO.getCluster((Class<? extends ObjectPOJO>)theClass);
    		
			//Get the versioning service
    		VersioningServiceCtrlLocalBI service = setDefaultVersioningSystem(versioningSystemPOJOPK);
    		
    		if (instances==null) {
    			//cluster level
    			return new WSVersioningObjectsHistory(
    					new WSVersioningObjectsHistoryObjects[] {
    							new WSVersioningObjectsHistoryObjects(
    									type,
    									null,
    									service.getHistory(clusterName)
    							)
    					}
    			);
    		}
    		
    		//mulitple instances
    		ArrayList<WSVersioningObjectsHistoryObjects> entries = new ArrayList<WSVersioningObjectsHistoryObjects>();
    		for (int i = 0; i < instances.length; i++) {
    			entries.add(
    				new WSVersioningObjectsHistoryObjects(
    						type,
    						instances[i],
    						service.getHistory(clusterName+"/"+instances[i])
    				)
    			);
			}
    		
    		return new WSVersioningObjectsHistory(entries.toArray(new WSVersioningObjectsHistoryObjects[entries.size()]));
    		
    	} catch (XtentisException e) {
    		throw(e);
		} catch (Exception e) {
			String err = "Unable to get objects history for type "+type+": "
    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
    	    throw new XtentisException(err);
		}
	}
    
        
    
    /*****************************************************************
     *  T I M E R
    *****************************************************************/
    
    /**
     * 
     * @param intervalDuration
     * @return a TimerHandle
     */
    private TimerHandle createTimer(JobActionInfo actionInfo) {
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("createTimer() ");
        TimerService timerService =  sessionContext.getTimerService();
        Timer timer = timerService.createTimer(150,actionInfo);  //0,15 second
        TimerHandle th = timer.getHandle();
        return th;
    }
    
    /*
    private void stopTimers() {
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("stopTimers() ");
    	Collection timers = context.getTimerService().getTimers();
    	for (Iterator iter = timers.iterator(); iter.hasNext();) {
			Timer timer = (Timer) iter.next();
			timer.cancel();
		}
    }
    */
    
    protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss-SSS z");
        
    /**
     * Run execute as a background job
     */
	public void ejbTimeout(Timer timer) {
		JobActionInfo actionInfo = (JobActionInfo) timer.getInfo();
		BackgroundJobPOJOPK pk = new BackgroundJobPOJOPK(actionInfo.getJobId());
		
		try {
			
			//set the universe on this user (anonymous)
			LocalUser.getLocalUser().setUniverse(actionInfo.getUniverse());
			
			//update Back Ground Job
			updateBackGroundJob(pk, "Starting processing of "+actionInfo.getAction());

			//determine what to run
			if (actionInfo.getInfo() instanceof TagObjectsInfo) {
				executeTagObjects(pk, (TagObjectsInfo)actionInfo.getInfo());
			}else if (actionInfo.getInfo() instanceof TagItemsInfo) {
				executeTagItems(pk, (TagItemsInfo)actionInfo.getInfo());
			}else if (actionInfo.getInfo() instanceof RestoreItemsInfo) {
				executeRestoreItems(pk, (RestoreItemsInfo)actionInfo.getInfo());
			}else if (actionInfo.getInfo() instanceof RestoreObjectsInfo) {
				executeRestoreObjects(pk, (RestoreObjectsInfo)actionInfo.getInfo());
			}

		} catch (Exception e) {
			try {
	    	    String err = "Error Processing of "+actionInfo.getAction()
	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
				if (! (e instanceof XtentisException)) {
		    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err, e);
				}
				//Update Background job and try to put pipeline
				updateBackGroundJob(pk, err,BackgroundJobPOJO._STOPPED_);
			} catch (Exception ex) {}
		}
	}
	

	private void updateBackGroundJob(BackgroundJobPOJOPK pk, String message)
	throws NamingException,CreateException,XtentisException
	{
		updateBackGroundJob(pk, message, BackgroundJobPOJO._RUNNING_);
	}
	
	private void updateBackGroundJob(BackgroundJobPOJOPK pk, String message, int status)
	throws NamingException,CreateException,XtentisException {
		BackgroundJobPOJO bgPOJO = Util.getBackgroundJobCtrlLocal().getBackgroundJob(pk);
		bgPOJO.setMessage(message);
		bgPOJO.setStatus(status);
		bgPOJO.setTimestamp(sdf.format(new Date(System.currentTimeMillis())));
		bgPOJO.setSerializedObject(null);
		bgPOJO.store();		
	}
	
	
    private VersioningServiceCtrlLocalBI getVersioningService(String JNDI) throws XtentisException{
    	try {
    		
    		EJBLocalHome pluginHome=null;
    		InitialContext ctx = new InitialContext();
    		
   			pluginHome = (EJBLocalHome)ctx.lookup(JNDI);

	        //find create 
	        Method[] m = pluginHome.getClass().getMethods();
	        Method create = null;
	        for (int i = 0; i < m.length; i++) {
				if ("create".equals(m[i].getName())) {
					create = m[i];
					break;
				}
			}
	        if (create == null) {
	        	String err = "Transformer: unable to find create method on versioning service \""+JNDI+"\"";
	        	org.apache.log4j.Logger.getLogger(this.getClass()).error("getVersioningService() "+err);
	    		throw new XtentisException(err);        	
	        }
	        
	        //call it
	        Object plugin = create.invoke(pluginHome,(Object[])null);
//	        Util.dumpClass(plugin.getClass());
	    	return (VersioningServiceCtrlLocalBI)plugin;
	    	
	    } catch (XtentisException e) {
	    	throw(e);
	    } catch (Exception e) {
    		String err = 
    			"Transformer. Unable to instantiate the plugin  '"+JNDI+"': ";
    		if (e.getCause()!=null) {
    			err+="caused by "+e.getCause().getClass().getName()+": "+e.getCause().getMessage();
    		} else {
				err+=e.getClass().getName()+": "+e.getMessage();
    		}
    		org.apache.log4j.Logger.getLogger(this.getClass()).error("getVersioningService() "+err);
    		throw new XtentisException(err);
	    }
    }


    
}