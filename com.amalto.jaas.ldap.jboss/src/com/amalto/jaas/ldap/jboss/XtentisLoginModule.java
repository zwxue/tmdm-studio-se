/** 
 * This one is for MDM
 * The jar must be installed in /opt/jboss/server/default/lib
 * login-config.xml in /opt/jboss/server/default/conf/ must have the following data
 * 
    <application-policy name="xtentisSecurity">
      <authentication>
        <login-module code=" com.amalto.jaas.xtentis.jboss.XtentisJbossLoginModule"
          flag="required">
		  <module-option name="unauthenticatedIdentity">anonymous</module-option>
		  <module-option name="provisioningCluster">PROVISIONING</module-option>
		  <module-option name="userConcept">User</module-option>
		  <module-option name="passwordPath">./password</module-option>
		  <module-option name="rolesPath">./permissions/permission</module-option>
		  <module-option name="adminPassword">xtentis</module-option>
        </login-module>
      </authentication>
    </application-policy>

 */

package com.amalto.jaas.ldap.jboss;

import java.io.FileInputStream;
import java.security.acl.Group;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.xml.transform.OutputKeys;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.w3c.dom.Element;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
import org.xmldb.api.modules.XMLResource;

import sun.misc.BASE64Encoder;

import com.amalto.jaas.ldap.jboss.util.Util;


/**
 * 
 * @author bgrieder
 * 
 * In server/default/cong/login-config.xml you must add a new domain
 * 
 *   
    <application-policy name="xtentisSecurity">
      <authentication>
        <login-module code="com.amalto.jaas.xtentis.jboss.XtentisLoginModule" flag="required">
		  <module-option name="unauthenticatedIdentity">anonymous</module-option>
		  <module-option name="provisioningCluster">STAGING</module-option>
		  <module-option name="userConcept">User</module-option>
		  <module-option name="passwordPath">./password</module-option>
		  <module-option name="rolesPath">./roles/role</module-option>
		  <module-option name="enabledPath">./enabled</module-option>
		  <module-option name="adminPassword">9bd2dbdf7fbdf7c9770edd3f0383c148</module-option>
        </login-module>
       <!-- Add this line to your login-config.xml to include the ClientLoginModule propogation -->      
        <login-module code="org.jboss.security.ClientLoginModule" flag="required" />
      </authentication>
    </application-policy>
 * 
 * The Jar should go in sever/default/lib 
 * 
 *  <application-policy name = "testLdapExample1">
        <authentication>
            <login-module code="org.jboss.security.auth.spi.LdapLoginModule" flag="required">
                <module-option name="java.naming.factory.initial">com.sun.jndi.ldap.LdapCtxFactory</module-option>
                <module-option name="java.naming.provider.url">ldap://ldapserver/</module-option>
                <module-option name="java.naming.security.authentication">simple</module-option>
                <module-option name="principalDNPrefix">uid=</module-option>                    
                <module-option name="principalDNSuffix">,ou=People,dc=jboss,dc=org</module-option>
                <module-option name="rolesCtxDN">ou=Roles,dc=jboss,dc=org</module-option>
                <module-option name="uidAttributeID">member</module-option>
                <module-option name="matchOnUserDN">true</module-option>
                <module-option name="roleAttributeID">cn</module-option>
                <module-option name="roleAttributeIsDN">false</module-option>
                <module-option name="searchTimeLimit">5000</module-option>
                <module-option name="searchScope">ONELEVEL_SCOPE</module-option>
            </login-module>
        </authentication>
    </application-policy>
 * 
 * 
 * 
 */
public class XtentisLoginModule extends UsernamePasswordLoginModule {

	private String unauthenticatedIdentity = "anonymous";
	private String provisioningCluster  = "STAGING";
	private String userConcept = "User";
	private String passwordPath = "./password";
	private String permissionsPath = "./roles/role";
	private String enabledPath = "./enabled";
	private String adminPassword = "9bd2dbdf7fbdf7c9770edd3f0383c148";
	private String adminPermission = "administration";
		
	private boolean ldapLogin = false;
	
   private static final String PRINCIPAL_DN_PREFIX_OPT = "principalDNPrefix";
   private static final String PRINCIPAL_DN_SUFFIX_OPT = "principalDNSuffix";
   private static final String ROLES_CTX_DN_OPT = "rolesCtxDN";
   private static final String USE_OBJECT_CREDENTIAL_OPT = "useObjectCredential";
   private static final String USER_ROLES_CTX_DN_ATTRIBUTE_ID_OPT = "userRolesCtxDNAttributeName";
   private static final String UID_ATTRIBUTE_ID_OPT = "uidAttributeID";
   private static final String ROLE_ATTRIBUTE_ID_OPT = "roleAttributeID";
   private static final String MATCH_ON_USER_DN_OPT = "matchOnUserDN";
   private static final String ROLE_ATTRIBUTE_IS_DN_OPT = "roleAttributeIsDN";
   private static final String ROLE_NAME_ATTRIBUTE_ID_OPT = "roleNameAttributeID";
	
	
	public void initialize(Subject s, CallbackHandler cbh, Map sharedState, Map parameters) {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("initialize() "+s);
		
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("initialize() SHARED STATE:");
		Set<String> keys = sharedState.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			org.apache.log4j.Logger.getLogger(this.getClass()).debug(key+":  "+sharedState.get(key));
		}
				
		//we force our own hashing (MD5 Hex) - see validatePassword below
		HashMap<String,String> map = new HashMap<String,String>(parameters);
		//map.put("hashAlgorithm",null);
		map.put("ignorePasswordCase","false");
		
		super.initialize(s, cbh, sharedState, (Map)map);
		
		Object tmp = null;
		
		if ((tmp=map.get("ldapLogin"))!=null) ldapLogin = Boolean.parseBoolean(tmp.toString());
		
		if ((tmp=map.get("unauthenticatedIdentity"))!=null) unauthenticatedIdentity = tmp.toString();
		
		if ((tmp=map.get("provisioningCluster"))!=null) provisioningCluster = tmp.toString();
		if ((tmp=map.get("userConcept"))!=null) userConcept = tmp.toString();
		if ((tmp=map.get("passwordPath"))!=null) passwordPath = tmp.toString();
		if ((tmp=map.get("permissionsPath"))!=null) permissionsPath = tmp.toString();
		if ((tmp=map.get("enabledPath"))!=null) enabledPath = tmp.toString();
		if ((tmp=map.get("adminPassword"))!=null) adminPassword = tmp.toString();
		//if ((tmp=map.get("adminPermission"))!=null) adminPermission = tmp.toString();
		
	}
	
	private transient SimpleGroup userRoles = new SimpleGroup("Roles");
	
	protected String getUsersPassword() throws LoginException {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("getUsersPassword() "+getUsername());
		if (getUsername().equals("admin")) return adminPassword;
		if (getUsername().equals(unauthenticatedIdentity)) return Util.md5AsHexString("dummy", "utf-8");
		
		if(ldapLogin==true) {
			return "";
		}		
		try {
//			org.apache.log4j.Logger.getLogger(this.getClass()).debug("getUsersPassword() FETCHING USER "+getUsername());		
			return Util.getFirstTextNode(fetchUserDetails(), passwordPath);						
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginException("No password found for "+getUsername()+": "+e.getLocalizedMessage());
		} finally {

		}		
	}

	protected Group[] getRoleSets() throws LoginException {
		
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("getRoleSets() "+getUsername());
		
		Group permissionsGroup = new SimpleGroup("Roles");
		
		//getRoleSets is called by the InitialContext.lookup with user anonymous when internal calls are made.
		if (getUsername().equals(unauthenticatedIdentity)) {
			permissionsGroup.addMember(new SimplePrincipal(adminPermission));
			return new Group[]{permissionsGroup};
		}
		
		// the user authenticated correctly - we add the authenticated role
		permissionsGroup.addMember(new SimplePrincipal("authenticated"));
		//super admin
		if (getUsername().equals("admin")) {
			permissionsGroup.addMember(new SimplePrincipal(adminPermission));
			return new Group[]{permissionsGroup};
		}

		
//		org.apache.log4j.Logger.getLogger(this.getClass()).debug("getRoleSets() FETCHING ROLES "+getUsername());
		
		try {
			Element user = fetchUserDetails();
			
			boolean fetchRoles = true;
			String enabled = Util.getFirstTextNode(user, enabledPath);
			if (enabled!=null) {
				//previous versions do not have the enabled stuff
				if (!"yes".equals(enabled.trim().toLowerCase())) {
					permissionsGroup.addMember(new SimplePrincipal("disabled"));
					fetchRoles = false;
				}
			}
			
			if (fetchRoles) {
				String[] permissions =  Util.getTextNodes(user, permissionsPath);
				for (int i = 0; i < permissions.length; i++) {
					System.out.println(permissions[i]);
					permissionsGroup.addMember(new SimplePrincipal(permissions[i]));
				}
			} else {
				
			}
			
			//this group maintains the XtentisPortalUser in xml serialized form unless is admin (user==null)
			Group xtentisUserGroup = new SimpleGroup("XtentisUser");
			xtentisUserGroup.addMember(new SimplePrincipal(Util.nodeToString(user)));
			
			return new Group[]{permissionsGroup,xtentisUserGroup};
		} catch (Exception e) {
			throw new LoginException("No appropriate permission found for "+getUsername()+": "+e.getLocalizedMessage());
		}
	}


	protected boolean validatePassword(String inputPassword, String encodedPassword) {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("validatePassword() input "+inputPassword+" password "+encodedPassword);
		// LDAP login
		String usersPassword = "";
		try {
			usersPassword = getUsersPassword();
			System.out.println("usersPassword "+usersPassword);
		} catch (LoginException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ldapLogin==true && usersPassword.equals("")) {
		      boolean isValid = false;
		      if (inputPassword != null) {
		         // See if this is an empty password that should be disallowed
		         if (inputPassword.length() == 0) {
		            // Check for an allowEmptyPasswords option
		            boolean allowEmptyPasswords = true;
		            String flag = (String) options.get("allowEmptyPasswords");
		            if (flag != null)
		               allowEmptyPasswords = Boolean.valueOf(flag).booleanValue();
		            if (allowEmptyPasswords == false) {
		            	org.apache.log4j.Logger.getLogger(this.getClass()).debug("Rejecting empty password due to allowEmptyPasswords");
		               return false;
		            }
		         }

		         try {
		            // Validate the password by trying to create an initial context
		            String username = getUsername();
		            createLdapInitContext(username, inputPassword);
		            isValid = true;
		         }
		         catch (NamingException e) {
		        	 org.apache.log4j.Logger.getLogger(this.getClass()).debug("Failed to validate password", e);
		         }
		      }
		      return isValid;
			}
		// Xtentis login
		// encode the input password
		inputPassword = Util.md5AsHexString(inputPassword, "utf-8");
		return super.validatePassword(inputPassword,encodedPassword);
	}
	   
	//the cached user
	private Element user = null;
	
	private Element fetchUserDetails() throws LoginException{
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("fetchUserDetails() "+getUsername());
		
		try {
			//for admin we do not know so we try to ping with the one supplied on login 
			//if it works, it is good, if not we assign null and validatePassword will fail
			if (getUsername().equals("admin")) {
				throw new LoginException("Administrator information should not be fetched");
			}
			
			if (user == null) {
				
				String userString = getDocumentAsString(provisioningCluster, provisioningCluster+"."+userConcept+"."+getUsername());
				user  = (Element)Util.getNodeList(Util.parse(userString), "//"+userConcept).item(0);
				
			}
			return user;
		} catch (Exception e) {
			throw new LoginException("Failed to fetch user \"" +getUsername()+"\": "+e.getLocalizedMessage());
		}
	}
	
	
	/***********************************************************************************************************************************************************
	 * 
	 * Direct XMLDB Access Stuuf copied over from the XmldbSLWrapper
	 * 
	 ***********************************************************************************************************************************************************/
	
	
	protected static String SERVERNAME = "localhost";
	protected static String SERVERPORT = "8080";
	protected static String ADMIN_USERNAME = "admin";
	protected static String ADMIN_PASSWORD = "";
	protected static String DRIVER = "org.exist.xmldb.DatabaseImpl";
	protected static String DBID = "exist";
	protected static String DBURL = "exist/xmlrpc/db";
	protected static String ISUPURL = "exist/";
	
	private HashMap<String,org.xmldb.api.base.Collection> clusters = new HashMap<String,org.xmldb.api.base.Collection>();
	
	{
		String os = System.getProperty("os.name");
		String f ="/etc/amalto/xtentis/xtentis.conf";
		Properties properties = new Properties();
		if (os.toLowerCase().matches(".*windows.*")) {
			f = "c:\\amalto\\xtentis\\xtentis.conf";
		}
		try {
			properties.load(new FileInputStream(f));
			SERVERNAME = properties.getProperty("xmldb.server.name");
			SERVERPORT = properties.getProperty("xmldb.server.port");
			ADMIN_USERNAME = properties.getProperty("xmldb.administrator.username");
			ADMIN_PASSWORD = properties.getProperty("xmldb.administrator.password");
			DRIVER = properties.getProperty("xmldb.driver");
			DBID = properties.getProperty("xmldb.dbid");
			DBURL = properties.getProperty("xmldb.dburl");
			ISUPURL = properties.getProperty("xmldb.isupurl");
			
		} catch (Exception e) {}
				
		try {
			//register DBManager
    		org.apache.log4j.Logger.getLogger(this.getClass()).debug("registerDBManager() registering");
	        Class cl = Class.forName(DRIVER);			
	        Database database = (Database)cl.newInstance();
	        org.apache.log4j.Logger.getLogger(this.getClass()).debug("registerDBManager() Driver instantiated");
	        DatabaseManager.registerDatabase(database);
	        org.apache.log4j.Logger.getLogger(this.getClass()).debug("registerDBManager() Driver registered");			
		} catch (Exception e){}
		
	}

	public String getDocumentAsString(String clusterName, String uniqueID) throws LoginException {
		String res = getDocumentAsString(clusterName, uniqueID, "UTF-16");
		return res;
	}
	
	
	public String getDocumentAsString(String clusterName, String uniqueID, String encoding) throws LoginException {
		
		XMLResource res=null;
		try {
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("getDocumentAsString() "+clusterName+"/"+uniqueID+"/"+(new BASE64Encoder()).encode(uniqueID.getBytes("utf-8")));
			
			org.xmldb.api.base.Collection col = getCollection(clusterName);
			col.setProperty(OutputKeys.INDENT, "yes");
			col.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
					
//			encode uniqueID
			String encodedID = (new BASE64Encoder()).encode(uniqueID.getBytes("utf-8"));
			
	        res = (XMLResource)col.getResource(encodedID);
	        
	        if (res==null) return null;
	        
	        return "<?xml version=\"1.0\" encoding=\""+encoding+"\"?>\n"+res.getContent();
		} catch (Exception e) {
			String err = "Unable to get the document "+uniqueID+" on " +getFullURL(clusterName)
			   +": "+e.getLocalizedMessage()+"\n"+res;
			  org.apache.log4j.Logger.getLogger(this.getClass()).debug(err);
			return null;
		}

	}
	
	protected org.xmldb.api.base.Collection getCollection(String clusterName) throws LoginException{
		try {
			String key = (clusterName == null) ? "__ROOT__" : clusterName;

			//registerDBManager();
			org.xmldb.api.base.Collection col = clusters.get(key);
			if (col == null) {
				//org.apache.log4j.Logger.getLogger(this.getClass()).debug("getCollection() "+key);
				col = DatabaseManager.getCollection(getFullURL(clusterName),ADMIN_USERNAME,ADMIN_PASSWORD);
				if (col==null) {
					throw new LoginException("The cluster "+clusterName+" cannot be found");
				}
				clusters.put(key, col);
			} else {
				//org.apache.log4j.Logger.getLogger(this.getClass()).debug("putDocumentFromString() re-using collection");
			}
			return col;
		} catch (LoginException e) {
			throw(e);
		} catch (Exception e) {
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("getCollection() ERROR:"+e.getMessage());
			throw new LoginException(e.getLocalizedMessage());
		}
	}
	
    private String getFullURL(String cluster) {
    	cluster = ( (cluster== null) ? "" : cluster);
   	 	return "xmldb:"+DBID+"://"+SERVERNAME+":"+SERVERPORT+"/"+DBURL+("".equals(cluster)? "": "/"+cluster);
   }

    /** Validate the inputPassword by creating a ldap InitialContext with the
    SECURITY_CREDENTIALS set to the password.

    @param inputPassword the password to validate.
    @param expectedPassword ignored
    */

   
	/***********************************************************************************************************************************************************
	 * 
	 * LDAP Stuff
	 * 
	 ***********************************************************************************************************************************************************/
    
   private void createLdapInitContext(String username, Object credential) throws NamingException {
	  org.apache.log4j.Logger.getLogger(this.getClass()).debug("createLdapInitContext username : "+username);
      Properties env = new Properties();
      // Map all option into the JNDI InitialLdapContext env
      Iterator iter = options.entrySet().iterator();
      System.out.println("options "+options);
      try {
			while (iter.hasNext()) {
				Entry entry = (Entry) iter.next();
				env.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass());

		}
      // Set defaults for key values if they are missing
      String factoryName = env.getProperty(Context.INITIAL_CONTEXT_FACTORY);
      if (factoryName == null) {
			factoryName = "com.sun.jndi.ldap.LdapCtxFactory";
			env.setProperty(Context.INITIAL_CONTEXT_FACTORY, factoryName);
		}
       String authType = env.getProperty(Context.SECURITY_AUTHENTICATION);
      if (authType == null)
         env.setProperty(Context.SECURITY_AUTHENTICATION, "simple");
      String protocol = env.getProperty(Context.SECURITY_PROTOCOL);
      String providerURL = (String) options.get(Context.PROVIDER_URL);
      if (providerURL == null)
         providerURL = "ldap://localhost:" + ((protocol != null && protocol.equals("ssl")) ? "636" : "10389");
      String principalDNPrefix = (String) options.get(PRINCIPAL_DN_PREFIX_OPT);
      if (principalDNPrefix == null)
         principalDNPrefix = "";
      String principalDNSuffix = (String) options.get(PRINCIPAL_DN_SUFFIX_OPT);
      if (principalDNSuffix == null)
         principalDNSuffix = "";
      String matchType = (String) options.get(MATCH_ON_USER_DN_OPT);
      
      /***********************************************************/
      /*                  UID BIND								 */
      /**********************************************************/

   	  Hashtable<String,String> env2 = new Hashtable<String,String>();
   	  env2.put(Context.INITIAL_CONTEXT_FACTORY, (String) options.get(Context.INITIAL_CONTEXT_FACTORY));
      env2.put(Context.PROVIDER_URL, (String) options.get(Context.PROVIDER_URL));
      env2.put(Context.SECURITY_AUTHENTICATION, (String) options.get(Context.SECURITY_AUTHENTICATION));
      env2.put(Context.SECURITY_PRINCIPAL, (String) options.get("adminDN"));
      env2.put(Context.SECURITY_CREDENTIALS, (String) options.get("adminLdapPassword"));
      DirContext ctx = null;
      // Step 1: Bind anonymously            
      ctx = new InitialDirContext(env2);
      System.out.println("admin bind ok");
      // Step 2: Search the directory
      String base = "o=sevenSeas";
      String filter = "(&(objectClass=inetOrgPerson)(uid={0}))";           
      SearchControls ctls = new SearchControls();
      ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
      ctls.setReturningAttributes(new String[0]);
      ctls.setReturningObjFlag(true);
      NamingEnumeration enm = ctx.search(base, filter, new String[] { username }, ctls);
      String dn = null;
      if (enm.hasMore()) {
          SearchResult result = (SearchResult) enm.next();
          dn = result.getNameInNamespace();                
          System.out.println("dn: "+dn);
      }
      
      if (dn == null || enm.hasMore()) {
          // uid not found or not unique
          throw new NamingException("Authentication failed");
      }
      
      // Step 3: Bind with found DN and given password
      ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, dn);
      ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, credential);
      // Perform a lookup in order to force a bind operation with JNDI
      ctx.lookup(dn);

   
   }
}
