package org.talend.mdm.berkely.xmldb;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.talend.mdm.commmon.util.core.CommonUtil;
import org.talend.mdm.commmon.util.core.MDMConfiguration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.amalto.xmldb.QueryBuilder;
import com.amalto.xmldb.XmldbSLWrapper;
import com.amalto.xmlserver.interfaces.IWhereItem;
import com.amalto.xmlserver.interfaces.IXmlServerSLWrapper;
import com.amalto.xmlserver.interfaces.XmlServerException;
import com.sleepycat.db.Environment;
import com.sleepycat.db.EnvironmentConfig;
import com.sleepycat.db.LockDetectMode;
import com.sleepycat.dbxml.XmlContainer;
import com.sleepycat.dbxml.XmlContainerConfig;
import com.sleepycat.dbxml.XmlDocument;
import com.sleepycat.dbxml.XmlDocumentConfig;
import com.sleepycat.dbxml.XmlException;
import com.sleepycat.dbxml.XmlIndexLookup;
import com.sleepycat.dbxml.XmlManager;
import com.sleepycat.dbxml.XmlManagerConfig;
import com.sleepycat.dbxml.XmlQueryContext;
import com.sleepycat.dbxml.XmlQueryExpression;
import com.sleepycat.dbxml.XmlResults;
import com.sleepycat.dbxml.XmlTransaction;
import com.sleepycat.dbxml.XmlValue;


public class BerkelyXmlDBWrapper extends XmldbSLWrapper {
	static XmlManager mgr = null;
	static Environment env=null;
	public static  String Berkely_HOME_DIR="Berkely";
	/** A cache of collections to speed up search */
	//protected Hashtable<String,XmlContainer> clusters = new Hashtable<String,XmlContainer>();
	
	static {
		init();
	}
	private static void init() {
		Properties properties = MDMConfiguration.getConfiguration();
		
		Berkely_HOME_DIR=properties.getProperty("berkely.home.dir") == null ? DRIVER : properties.getProperty("berkely.home.dir");		
		try {
			File dir=new File(Berkely_HOME_DIR);
			if(!dir.exists()) {
				dir.mkdir();
			}
			env=createEnvironment(Berkely_HOME_DIR);

		    // All BDB XML programs require an XmlManager instance.
		    // Create it from the DB Environment, but do not adopt the
		    // Environment
		    XmlManagerConfig mconfig = new XmlManagerConfig();
		    mconfig.setAllowExternalAccess(true);	
		    mconfig.setAdoptEnvironment(true);
		    mconfig.setAllowAutoOpen(true);
		    
		    mgr = new XmlManager(env, mconfig);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
			    	org.apache.log4j.Logger.getLogger(this.getClass()).info("Shutdown detected. cleanup database resources!");
			    	cleanup();
				}
			});
		} catch (Throwable e) {
			org.apache.log4j.Logger.getLogger(BerkelyXmlDBWrapper.class).debug(" Init Berkely DB Xml createEnvironment Error :" + e.getLocalizedMessage());
			try {
				if(env!=null)env.close();
				if(mgr!=null)mgr.close();
			}catch(Exception e2) {}
		}
	
	}
	private static void cleanup() {
		try {
			if(env!=null)env.close();
			if(mgr!=null)mgr.close();
		}catch(Exception e2) {}
	}
	
    private static Environment createEnvironment(String home)
		throws Throwable {

		
    	EnvironmentConfig environmentConfig = new EnvironmentConfig();

    	// general environment
    	environmentConfig.setAllowCreate(true);
    	environmentConfig.setRunRecovery(true); // light recovery on startup
    	//environmentConfig.setRunFatalRecovery(true); // heavy recovery on startup
    	environmentConfig.setJoinEnvironment(true); // reuse of environment: ok
    	environmentConfig.setThreaded(true);

    	// log subsystem
    	environmentConfig.setInitializeLogging(true);
    	environmentConfig.setLogAutoRemove(true);
    	environmentConfig.setLogBufferSize(128 * 1024); // default 32KB
    	environmentConfig.setInitializeCache(true); // shared memory region
    	environmentConfig.setCacheSize(250 * 1024 * 1024); // 250MB cache

    	// transaction
    	environmentConfig.setTransactional(true);
    	environmentConfig.setTxnMaxActive(0); // live forever, no timeout
    	
    	environmentConfig.setInitializeLocking(true);
    	environmentConfig.setMutexIncrement(22);
    	environmentConfig.setMaxMutexes(200000);
    	environmentConfig.setMaxLockers(200000);
    	environmentConfig.setMaxLockObjects(200000); // default 1000
    	environmentConfig.setMaxLocks(200000);

    	// deadlock detection
    	environmentConfig.setLockDetectMode(LockDetectMode.MINWRITE);		
		environmentConfig.setErrorStream(System.err);
		File f = new File(home);
		return new Environment(f, environmentConfig);
    }
    
	public void clearCache() {
		
	}

	public long createCluster(String revisionID, String clusterName)
			throws XmlServerException {
		XmlContainer container=getCluster(revisionID,clusterName);
		if(container!=null)
			try {
				container.close();
			} catch (XmlException e) {
				throw new XmlServerException(e.getLocalizedMessage());
			}
		return 0;
	}
	protected XmlContainer getCluster(String revisionID, String clusterName) throws XmlServerException{
		String containername=getFullURL(revisionID,clusterName);
//		XmlContainer cont =clusters.get(containername);
//		if(cont==null) {
			XmlTransaction txn=null;
			XmlContainer cont=null;
			try {		    					
				XmlContainerConfig cconfig = new XmlContainerConfig();
				cconfig.setContainerType(XmlContainer.NodeContainer);
				cconfig.setIndexNodes(XmlContainerConfig.On);
				cconfig.setTransactional(true);
				txn=mgr.createTransaction();
				if(mgr.existsContainer(containername)==0) {
					cont= mgr.createContainer(txn,containername, cconfig);											
				}else {
					cont =mgr.openContainer(txn, containername, cconfig);
				}
				//clusters.put(containername, cont);
				txn.commit();

			} catch (Exception e) {
				if(txn!=null) {
					try{txn.abort();}catch(Exception e2) {}					
				}
				
			}finally {
				if(txn!=null) txn.delete();
			}
		//}
		return cont;
	}
    /**
     * Build the XML DB URL from the  revisionID and clusterName
     * @param revisionID
     * @param cluster
     * @return
     */
    protected String getFullURL(String revisionID, String cluster) {
    	return CommonUtil.getPath(revisionID, cluster);
    }
	
	public long deleteAllClusters(String revisionID) throws XmlServerException {
		
		return 0;
	}

	
	public long deleteCluster(String revisionID, String clusterName)
			throws XmlServerException {
		
		String containername=getFullURL(revisionID,clusterName);
		XmlTransaction txn=null;
		XmlContainer cont=null;
		try {
			cont=getCluster(revisionID, clusterName);
			
			if(cont!=null) {
				txn = mgr.createTransaction();		
				cont.close();
				mgr.removeContainer(txn, containername);
				//clusters.remove(containername);
				txn.commit();
			}
		} catch (XmlException e) {
			if(txn!=null) {
				try{txn.abort();}catch(Exception e2) {}					
			}
			throw new XmlServerException("Unable to delete Container " + containername+" : "+ e.getLocalizedMessage());
		}finally {
			if(txn!=null)txn.delete();
			if(cont!=null)cont.delete();
		}
		
		return 0;
	}

	
	public long deleteDocument(String revisionID, String clusterName,
			String uniqueID, String documentType) throws XmlServerException {		
			long startT = System.currentTimeMillis();
			String containername=getFullURL(revisionID, clusterName);
			XmlContainer cont=getCluster(revisionID, clusterName);
			if(cont!=null) {
				XmlTransaction txn=null;
				try {
					txn=mgr.createTransaction();					
					String encodedID = URLEncoder.encode(uniqueID,"UTF-8");
					cont.deleteDocument(txn, encodedID);
					txn.commit();					
				} catch (Exception e) {
					  String err = "Unable to delete the document "+uniqueID+"on " +containername
					   +": "+e.getLocalizedMessage();
					  org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
					  if(txn!=null) {
							try{txn.abort();}catch(Exception e2) {}				
						}
						throw new XmlServerException(err);
					}finally {
						if(txn!=null)txn.delete();
						if(cont!=null)cont.delete();
					}
			}
			long time = System.currentTimeMillis() - startT;
			return time;
	}

	
	public int deleteItems(
			LinkedHashMap<String, String> conceptPatternsToRevisionID,
			LinkedHashMap<String, String> conceptPatternsToClusterName,
			String conceptName, IWhereItem whereItem) throws XmlServerException {
		XmlContainer cont=null;
		XmlTransaction txn=null;
		try {
			LinkedHashMap<String,String> pivots = new LinkedHashMap<String,String>();
			pivots.put(conceptName,"pivot");
			
			//determine revision
			String revisionID = null;
			Set<String> patterns = conceptPatternsToRevisionID.keySet();
			for (Iterator<String> iterator = patterns.iterator(); iterator.hasNext(); ) {
				String pattern = iterator.next();
				if (conceptName.matches(pattern)) {
					revisionID = conceptPatternsToRevisionID.get(pattern);
					break;
				}
			}
			//determine cluster
			String clusterName = null;
			patterns = conceptPatternsToClusterName.keySet();
			for (Iterator<String> iterator = patterns.iterator(); iterator.hasNext(); ) {
				String pattern = iterator.next();
				if (conceptName.matches(pattern)) {
					clusterName = conceptPatternsToClusterName.get(pattern);
					break;
				}
			}
			if (clusterName == null) 
				throw new XmlServerException("Unable to find a cluster for concept '"+conceptName+"'");
			
			//Replace for QueryBuilder
			//String xquery ="for $pivot in " + getXQueryCollectionName(revisionID, clusterName)+"/ii/p"+conceptName+(whereItem !=null ? "\nwhere "+buildWhere("", pivots, whereItem,true)+"\n" : "") + "\nreturn base-uri($pivot)";
			conceptName=conceptName.startsWith("/")?conceptName:"/"+conceptName;
			String xquery = "for $pivot in " + QueryBuilder.getXQueryCollectionName(revisionID, clusterName) + "/ii/p" + conceptName + (whereItem != null ? "\nwhere " + QueryBuilder.buildWhere("", pivots, whereItem,null) + "\n" : "")+ "\nreturn base-uri($pivot)";
			
			Collection<String> res = runQuery(null, null, xquery, null);
			
			//set at head of db
			cont = getCluster(revisionID, clusterName);
			txn=mgr.createTransaction();
			for (Iterator<String> iter = res.iterator(); iter.hasNext(); ) {
				String uri = iter.next();
				cont.deleteDocument(txn, uri);
			}
			txn.commit();
			return res.size();
			
		}  catch (Exception e) {
			String err = "Unable to delete '"+conceptName+"' items.";
			org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
			if(txn!=null) {
				try{txn.abort();}catch(Exception e2) {}					
			}
			throw new XmlServerException(err);
		}finally {
			if(txn!=null)txn.delete();
			if(cont!=null)cont.delete();
		}

	}

	
	public int deleteXtentisObjects(
			HashMap<String, String> objectRootElementNameToRevisionID,
			HashMap<String, String> objectRootElementNameToClusterName,
			String objectRootElementName, IWhereItem whereItem)
			throws XmlServerException {
		XmlContainer cont=null;
		XmlTransaction txn=null;
		try {
			LinkedHashMap<String,String> pivots = new LinkedHashMap<String,String>();
			pivots.put(objectRootElementName,"pivot");
			
			//determine revision
			String revisionID = objectRootElementNameToRevisionID.get(objectRootElementName);

			//determine cluster
			String clusterName = objectRootElementNameToClusterName.get(objectRootElementName);
			if (clusterName == null) 
				throw new XmlServerException("Unable to find a cluster for Xtentis Object Root Element Name '"+objectRootElementName+"'");
			
			String xquery = "for $pivot in " + QueryBuilder.getXQueryCollectionName(revisionID, clusterName) + "/" + objectRootElementName + (whereItem != null ? "\nwhere " + QueryBuilder.buildWhere("", pivots, whereItem,null) + "\n" : "")
		    + "\nreturn base-uri($pivot)";
			
			Collection<String> res = runQuery(null, null, xquery, null);
						
			//set at head of db
			cont = getCluster(revisionID, clusterName);
			txn=mgr.createTransaction();
			for (Iterator<String> iter = res.iterator(); iter.hasNext(); ) {
				String uri = iter.next();
				cont.deleteDocument(txn, uri);
			}
			txn.commit();
			return res.size();
					
		} catch (Exception e) {
			String err = "Unable to delete Xtentis Objects of Root Element Name '"+objectRootElementName+"'.";
			org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
			if(txn!=null) {
				try{txn.abort();}catch(Exception e2) {}
				txn.delete();					
			}
			throw new XmlServerException(err);
		}finally {
			if(txn!=null)txn.delete();
			if(cont!=null)cont.delete();
		}
	}

	
	public boolean existCluster(String revision, String cluster)
			throws XmlServerException {
		if(cluster==null|| cluster.trim().length()==0)return false;
		String containername=getFullURL(revision, cluster);
		try {
			return mgr.existsContainer(containername)!=0;
		} catch (XmlException e) {
			throw new XmlServerException(e.getLocalizedMessage());
		}
	}

	
	public String[] getAllClusters(String revisionID) throws XmlServerException {
		
		return null;
	}

	private List<String> getXmlQuery(String col, String query) {
		XmlTransaction txn=null;
		try {
			// Querying requires an XmlQueryContext
		    XmlQueryContext qc = mgr.createQueryContext();
		    
		    // Add a variable to the query context, used by the query
		    //qc.setVariableValue("name", new XmlValue("mary"));
		    //qc.setDefaultCollection(col);
		    // Create a new transaction for the query
		    txn = mgr.createTransaction();
		    
		    // Note the passing of txn to both methods
		    XmlQueryExpression expr = mgr.prepare(txn, query, qc);
	
		    XmlResults res = expr.execute(txn, qc);
		    
		    // Process results -- just print them
		    XmlValue value = new XmlValue();
		    List<String> result = new ArrayList<String>();
		    value=res.next();
		    while (value != null) {
				result.add(value.asString());
				value=res.next();
		    }
		    
		    // done with the transaction
		    txn.commit();
		    
		    // explicitly delete objects to release resources
		    res.delete();
		    expr.delete();
		    return result;
		}catch(Exception e) {
			//e.printStackTrace();
		}finally {
			if(txn!=null)txn.delete();
		}		
		return null;
	}
	
	public String[] getAllDocumentsUniqueID(String revisionID,
			String clusterName) throws XmlServerException {
		XmlTransaction txn=null;
		String col=getFullURL(revisionID, clusterName);
		String queryString =
		    "collection('"+col+"')/dbxml:metadata('dbxml:name')";	
		List<String> ret=new ArrayList<String>();
		try {
		    // Querying requires an XmlQueryContext
		    XmlQueryContext qc = mgr.createQueryContext();
		    		    
		    // Create a new transaction for the query
		    txn = mgr.createTransaction();
		    
		    // Note the passing of txn to both methods
		    XmlQueryExpression expr = mgr.prepare(txn, queryString, qc);
		    XmlResults res = expr.execute(txn, qc);
		    
		    
		    // Process results -- just print them
		    XmlValue value = new XmlValue();
		    while ((value = res.next()) != null) {
		    	ret.add(URLDecoder.decode(value.asString(),"UTF-8"));
		    }
		 // done with the transaction
		    txn.commit();
		    
		    // explicitly delete objects to release resources
		    res.delete();
		    expr.delete();			    
		    return (String[])ret.toArray(new String[ret.size()]);
		    
		} catch (Exception e) {
			  String err = "Unable to get the documents on " +getFullURL(revisionID, clusterName)
			   +": "+e.getLocalizedMessage();
			  org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
			  if(txn!=null) {
					try{txn.abort();}catch(Exception e2) {}				
			   }
			  return (String[])ret.toArray(new String[ret.size()]);
			}finally {
				if(txn!=null)txn.delete();
			}
	}	
	public String getDocumentAsString(String revisionID, String clusterName,
			String uniqueID, String encoding) throws XmlServerException {
				
		//String col=getFullURL(revisionID, clusterName);
		XmlContainer cont=null;
		XmlTransaction txn=null;
		try {

		    String encodedID = URLEncoder.encode(uniqueID,"UTF-8");
		    String docContent=null;
//		    String query="collection('"+col+"')/*[dbxml:metadata('dbxml:name')='"+encodedID+"']";	
//		    List<String>ret=getXmlQuery(col, query);
		    cont=getCluster(revisionID, clusterName);
		    txn=mgr.createTransaction();
		    XmlDocument doc=cont.getDocument(txn, encodedID);
		    if(doc!=null) docContent=doc.getContentAsString();

//		    if(ret!=null && ret.size()>0) {
//		    	docContent=ret.get(0);
//		    }
		    txn.commit();
	        return   docContent!=null&& docContent.length()>0?(encoding == null ? "" : "<?xml version=\"1.0\" encoding=\""+encoding+"\"?>\n")+docContent: null;
		} catch (Exception e) {
			String err = "Unable to get the document "+uniqueID+" on " +getFullURL(revisionID, clusterName)+"\n";
			org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
			if(txn!=null) {
				try{txn.abort();}catch(Exception e2) {}					
			}
			return null;
		}finally {
			if(txn!=null)txn.delete();
			if(cont!=null)cont.delete();
		}
		
	}

	
	public byte[] getDocumentBytes(String revisionID, String clusterName,
			String uniqueID, String documentType) throws XmlServerException {
		
		XmlContainer cont=getCluster(revisionID, clusterName);
		if(cont!=null) {
			XmlTransaction txn=null;
			try {
				 // Now, get the document
			    txn = mgr.createTransaction();
			    String encodedID = URLEncoder.encode(uniqueID,"UTF-8");
			    XmlDocument doc = cont.getDocument(txn, encodedID);			 
			    
			    byte[] buf=null;
				if (IXmlServerSLWrapper.TYPE_DOCUMENT.equals(documentType)) {
					String xml =  "<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n"+doc.getContentAsString();					
					buf= xml.getBytes("UTF-16");
				}else {
					buf=doc.getContent();
				}				
			    // commit the transaction.  Note that this is done
			    // after getting the document content.  This is necessary
			    // as getting the content will touch the database.
			    // Also, given that this is a read-only operation, abort()
			    // would be just as appropriate.				
				txn.commit();
				return buf;
			} catch (Exception e) {
				String err = "Unable to get the document "+uniqueID+" on " +getFullURL(revisionID, clusterName)+"\n";
				  org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
				  if(txn!=null) {
						try{txn.abort();}catch(Exception e2) {}					
					}
					return null;
				}finally {
					if(txn!=null)txn.delete();
					if(cont!=null)cont.delete();
				}
		}
		return null;
	}

	
	
	public boolean isUpAndRunning() {		
		return true;
	}
	
	public long putDocumentFromDOM(Element root, String uniqueID,
			String clusterName, String revisionID) throws XmlServerException {
		
		String xmlString;
		try {
			xmlString = nodeToString(root, true);
			return putDocumentFromString(xmlString, uniqueID, clusterName, revisionID);
		} catch (TransformerException e) {
			throw new XmlServerException(e.getLocalizedMessage());
		}
	}
	
	public long putDocumentFromFile(String fileName, String uniqueID,
			String clusterName, String revisionID, String documentType)
			throws XmlServerException {
		
        File f = new File(fileName);
        if(!f.canRead()) {
            throw new XmlServerException("Cannot read file " + fileName);
        }
        InputStream io=null;
		try {
			io = new FileInputStream(f);
			int len=io.available();
			byte[] buf=new byte[len];
			io.read(buf);
			return putDocumentFromString(new String(buf), uniqueID, clusterName, revisionID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(io!=null)try{io.close();}catch(Exception e) {}
		}
        
		return 0;
	}

	public boolean existsDoc(String docname, XmlContainer cont
	         ) throws XmlException {
	    boolean ret = false;
	    XmlResults res = null;
	    XmlQueryContext context = null;
	    try {
	        XmlIndexLookup il = mgr.createIndexLookup(cont, XmlManager.metaDataNamespace_uri, 
							      XmlManager.metaDataName_name, 
							      "metadata-equality-string", 
							      new XmlValue(docname));
	        context = mgr.createQueryContext();
	        res = il.execute(context, new XmlDocumentConfig().setLazyDocs(true));
	        if (res.size() != 0)
	            ret = true;
	    } catch (XmlException e) {
	        if (e.getErrorCode() != XmlException.DOCUMENT_NOT_FOUND)
	            throw(e);
	    } 
	    finally {
	        if (res != null) res.delete();
	    }
	    return ret;
	}
	
	public long putDocumentFromString(String xmlString, String uniqueID,
			String clusterName, String revisionID, String documentType)
			throws XmlServerException {
		
		long startT = System.currentTimeMillis();
		XmlContainer cont=getCluster(revisionID, clusterName);
		if(cont!=null) {
			XmlTransaction txn=null;
			try {
				txn=mgr.createTransaction();
				String encodedID = URLEncoder.encode(uniqueID,"UTF-8");
			
				//remove xml declaration
				xmlString=xmlString.replaceFirst("<\\?xml.*\\?>", "");

				XmlDocument doc=null;
				
				if(existsDoc(encodedID, cont)) {
					cont.deleteDocument(txn, encodedID);						
				}
				doc=mgr.createDocument();
				doc.setName(encodedID);		
				doc.setContent(xmlString);
				cont.putDocument(txn, doc);
				
				txn.commit();

			} catch (Exception e) {
				String err = "Unable to put the document from string in cluster " + clusterName + " on " + getFullURL(revisionID, clusterName) + ": "; 
				org.apache.log4j.Logger.getLogger(this.getClass()).info(err,e);
				if(txn!=null) {
					try{txn.abort();}catch(Exception e2) {}
					txn.delete();					
				}
				return -1;
			}finally {
				if(txn!=null)txn.delete();
				if(cont!=null)cont.delete();
			}
		}
		long time = System.currentTimeMillis() - startT;		
		return time;
	}

	
	public ArrayList<String> runQuery(String revisionID, String clusterName,
			String query, String[] parameters) throws XmlServerException {
		XmlTransaction txn=null;
		XmlContainer cont=getCluster(revisionID, clusterName);
		
		try {

    		//replace parameters in the procedure
        	if (parameters!=null) {
        		for (int i = 0; i < parameters.length; i++) {
					String param = parameters[i];
					query=query.replaceAll("([^\\\\])%"+i+"([^\\d])", "$1"+param+"$2");
				}
        	}
			// Querying requires an XmlQueryContext
		    XmlQueryContext qc = mgr.createQueryContext();

		    // Add a variable to the query context, used by the query
		    //qc.setVariableValue("name", new XmlValue("mary"));
		    qc.setDefaultCollection(cont.getName());
		    // Create a new transaction for the query
		    txn = mgr.createTransaction();
		    
		    // Note the passing of txn to both methods
		    XmlQueryExpression expr = mgr.prepare(txn, query, qc);

		    XmlResults res = expr.execute(txn, qc);
		    
		    // Note use of XmlQueryExpression::getQuery() and
		    // XmlResults::size()
		    System.out.println("The query, '" + expr.getQuery() +
				       "'\n\t returned " + res.size() + " result(s)");
		    
		    // Process results -- just print them
		    XmlValue value = new XmlValue();
        	ArrayList<String> result = new ArrayList<String>();
		    while ((value = res.next()) != null) {
				result.add(value.asString());
		    }
		    
		    // done with the transaction
		    txn.commit();
		    
		    // explicitly delete objects to release resources
		    res.delete();
		    expr.delete();
        	return result;

		} catch (Exception e) {
			String err = "Unable to perform single find for query: \"" + query + "\"" + " on " +getFullURL(revisionID, clusterName) + ": " + e.getClass().getName() + ": "
					+ e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger("INFO SYSTRACE "+this.getClass()).info(err,e);
			if(txn!=null) {
				try{txn.abort();}catch(Exception e2) {}		
			}
			if(cont!=null)cont.delete();
			throw new XmlServerException(err);
		}finally {
			if(txn!=null)txn.delete();
			if(cont!=null)cont.delete();
		}

	}

	
	public void doActivate() throws XmlServerException {
		
		
	}

	
	public void doCreate() throws XmlServerException {
		
		
	}

	
	public void doPassivate() throws XmlServerException {
//		try {
//			Set<String> keys = this.clusters.keySet();
//			for (Iterator<String> iter = keys.iterator(); iter.hasNext(); ) {
//				String clusterName = iter.next();
//				XmlContainer collection = clusters.get(clusterName);
//				try {collection.close();} catch (Exception x) {}
//			}
//			clusters=new Hashtable<String, XmlContainer>();
//		} catch (Exception e) {
//			throw new XmlServerException(e);
//		}		
		
	}

	
	public void doPostCreate() throws XmlServerException {
		
		
	}

	
	public void doRemove() throws XmlServerException {
//		try {
//			Set<String> keys = this.clusters.keySet();
//			for (Iterator<String> iter = keys.iterator(); iter.hasNext(); ) {
//				String clusterName = iter.next();
//				XmlContainer collection = clusters.get(clusterName);
//				try {collection.close();} catch (Exception x) {}
//			}
//			clusters=new Hashtable<String, XmlContainer>();
//		} catch (Exception e) {
//			throw new XmlServerException(e);
//		}		
	}

	/**
	 * Generates an xml string from a node with or without the xml declaration 
	 * (not pretty formatted)
	 * @param n the node
	 * @return the xml string
	 * @throws TransformerException
	 */
	public static String nodeToString(Node n, boolean omitXMLDeclaration) throws TransformerException{
       	StringWriter sw = new StringWriter();
       	Transformer transformer = TransformerFactory.newInstance().newTransformer();       	
       	if (omitXMLDeclaration)
       		transformer.setOutputProperty("omit-xml-declaration","yes");
       	else
       		transformer.setOutputProperty("omit-xml-declaration","no");
       	transformer.setOutputProperty("indent","yes");
       	transformer.transform(
				new DOMSource(n),
				new StreamResult(sw)
				);
       	if (sw==null) return null;       	
		return sw.toString().replaceAll("\r\n", "\n");
	}
}
