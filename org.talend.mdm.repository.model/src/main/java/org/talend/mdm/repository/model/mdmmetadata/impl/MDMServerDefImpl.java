/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.mdm.repository.model.mdmmetadata.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.core.model.metadata.builder.connection.impl.AbstractMetadataObjectImpl;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataPackage;

import com.amalto.workbench.utils.PasswordUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>MDM Server Def</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getTempPasswd <em>Temp Passwd</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getUniverse <em>Universe</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmmetadata.impl.MDMServerDefImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDMServerDefImpl extends AbstractMetadataObjectImpl implements MDMServerDef {

 
    private static final String PATTERN_URL = "[http|https]+://(.+):(\\d+)(/.*)";
 
    private static final String HTTP_PREFIX = "http://"; //$NON-NLS-1$

    private static final String HTTPS_PREFIX = "https://"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getHost() <em>Host</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected static final String HOST_EDEFAULT = "localhost"; //$NON-NLS-1$

    protected static final String NAME_DEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getHost() <em>Host</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected String host = HOST_EDEFAULT;

    /**
     * The default value of the '{@link #getPasswd() <em>Passwd</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPasswd()
     * @generated NOT
     * @ordered
     */
    protected static final String PASSWD_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getPasswd() <em>Passwd</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPasswd()
     * @generated
     * @ordered
     */
    protected String passwd = PASSWD_EDEFAULT;

    /**
     * The default value of the '{@link #getTempPasswd() <em>Temp Passwd</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getTempPasswd()
     * @generated
     * @ordered
     */
    protected static final String TEMP_PASSWD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTempPasswd() <em>Temp Passwd</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getTempPasswd()
     * @generated
     * @ordered
     */
    protected String tempPasswd = TEMP_PASSWD_EDEFAULT;

    /**
     * The default value of the '{@link #getPath() <em>Path</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPath()
     * @generated NOT
     * @ordered
     */
    protected static final String PATH_EDEFAULT = "/talend/TalendPort"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getPath() <em>Path</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPath()
     * @generated
     * @ordered
     */
    protected String path = PATH_EDEFAULT;

    /**
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPort()
     * @generated NOT
     * @ordered
     */
    protected static final String PORT_EDEFAULT = "8180"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected String port = PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getUniverse() <em>Universe</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getUniverse()
     * @generated NOT
     * @ordered
     */
    protected static final String UNIVERSE_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getUniverse() <em>Universe</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getUniverse()
     * @generated
     * @ordered
     */
    protected String universe = UNIVERSE_EDEFAULT;

    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

    /**
     * The default value of the '{@link #getUser() <em>User</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUser()
     * @generated NOT
     * @ordered
     */
    protected static final String USER_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getUser() <em>User</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected String user = USER_EDEFAULT;

    /**
     * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLED_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected boolean enabled = ENABLED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected MDMServerDefImpl() {
        super();
        label = NAME_DEFAULT;
        name = NAME_DEFAULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmmetadataPackage.Literals.MDM_SERVER_DEF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getHost() {
        return host;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setHost(String newHost) {
        String oldHost = host;
        host = newHost;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__HOST, oldHost, host));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPasswd() {
        return passwd;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPasswd(String newPasswd) {
        String oldPasswd = passwd;
        passwd = newPasswd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__PASSWD, oldPasswd, passwd));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTempPasswd() {
        return tempPasswd;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTempPasswd(String newTempPasswd) {
        String oldTempPasswd = tempPasswd;
        tempPasswd = newTempPasswd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__TEMP_PASSWD, oldTempPasswd, tempPasswd));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPath(String newPath) {
        String oldPath = path;
        path = newPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__PATH, oldPath, path));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPort() {
        return port;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPort(String newPort) {
        String oldPort = port;
        port = newPort;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__PORT, oldPort, port));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getUniverse() {
        return universe;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUniverse(String newUniverse) {
        String oldUniverse = universe;
        universe = newUniverse;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__UNIVERSE, oldUniverse, universe));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String getUrl() {
        if (url == null) {
            StringBuffer sb = new StringBuffer();
            sb.append(getProtocol());
            sb.append(host);
            sb.append(":");//$NON-NLS-1$
            sb.append(port);
            sb.append(path);
            url = sb.toString();
        }
        return url;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUrl(String newUrl) {
        String oldUrl = url;
        url = newUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__URL, oldUrl, url));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getUser() {
        return user;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUser(String newUser) {
        String oldUser = user;
        user = newUser;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__USER, oldUser, user));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnabled(boolean newEnabled) {
        boolean oldEnabled = enabled;
        enabled = newEnabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmmetadataPackage.MDM_SERVER_DEF__ENABLED, oldEnabled, enabled));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public boolean validate(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        String protocol = getProtocol(url);
        if (protocol == null) {
            return false;
        }
        Matcher m = Pattern.compile(PATTERN_URL).matcher(url);
        return m.find();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public MDMServerDef parse(String url) {
        String protocol = getProtocol(url);
        if (protocol == null) {
            return null;
        }
        Matcher m = Pattern.compile(PATTERN_URL).matcher(url);

        if (!m.find()) {
            return null;
        }

        setHost(m.group(1));
        setPort(m.group(2));
        setPath(m.group(3));
        return this;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public String getProtocol() {
        if (url != null) {
            return getProtocol(url);
        }
        return HTTP_PREFIX;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public boolean isEnableSSL() {
        String protocol = getProtocol();
        if (protocol != null) {
            return protocol.equalsIgnoreCase(HTTPS_PREFIX);
        }
        return false;
    }

    private String getProtocol(String input) {
        if (input != null) {
            String tmp = input.toLowerCase().trim();
            if (tmp.startsWith(HTTP_PREFIX)) {
                return HTTP_PREFIX;
            }
            if (tmp.startsWith(HTTPS_PREFIX)) {
                return HTTPS_PREFIX;
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmmetadataPackage.MDM_SERVER_DEF__HOST:
                return getHost();
            case MdmmetadataPackage.MDM_SERVER_DEF__PASSWD:
                return getPasswd();
            case MdmmetadataPackage.MDM_SERVER_DEF__TEMP_PASSWD:
                return getTempPasswd();
            case MdmmetadataPackage.MDM_SERVER_DEF__PATH:
                return getPath();
            case MdmmetadataPackage.MDM_SERVER_DEF__PORT:
                return getPort();
            case MdmmetadataPackage.MDM_SERVER_DEF__UNIVERSE:
                return getUniverse();
            case MdmmetadataPackage.MDM_SERVER_DEF__URL:
                return getUrl();
            case MdmmetadataPackage.MDM_SERVER_DEF__USER:
                return getUser();
            case MdmmetadataPackage.MDM_SERVER_DEF__ENABLED:
                return isEnabled();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmmetadataPackage.MDM_SERVER_DEF__HOST:
                setHost((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PASSWD:
                setPasswd((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__TEMP_PASSWD:
                setTempPasswd((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PATH:
                setPath((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PORT:
                setPort((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__UNIVERSE:
                setUniverse((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__URL:
                setUrl((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__USER:
                setUser((String)newValue);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__ENABLED:
                setEnabled((Boolean)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmmetadataPackage.MDM_SERVER_DEF__HOST:
                setHost(HOST_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PASSWD:
                setPasswd(PASSWD_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__TEMP_PASSWD:
                setTempPasswd(TEMP_PASSWD_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PATH:
                setPath(PATH_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__PORT:
                setPort(PORT_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__UNIVERSE:
                setUniverse(UNIVERSE_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__URL:
                setUrl(URL_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__USER:
                setUser(USER_EDEFAULT);
                return;
            case MdmmetadataPackage.MDM_SERVER_DEF__ENABLED:
                setEnabled(ENABLED_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmmetadataPackage.MDM_SERVER_DEF__HOST:
                return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
            case MdmmetadataPackage.MDM_SERVER_DEF__PASSWD:
                return PASSWD_EDEFAULT == null ? passwd != null : !PASSWD_EDEFAULT.equals(passwd);
            case MdmmetadataPackage.MDM_SERVER_DEF__TEMP_PASSWD:
                return TEMP_PASSWD_EDEFAULT == null ? tempPasswd != null : !TEMP_PASSWD_EDEFAULT.equals(tempPasswd);
            case MdmmetadataPackage.MDM_SERVER_DEF__PATH:
                return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
            case MdmmetadataPackage.MDM_SERVER_DEF__PORT:
                return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
            case MdmmetadataPackage.MDM_SERVER_DEF__UNIVERSE:
                return UNIVERSE_EDEFAULT == null ? universe != null : !UNIVERSE_EDEFAULT.equals(universe);
            case MdmmetadataPackage.MDM_SERVER_DEF__URL:
                return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
            case MdmmetadataPackage.MDM_SERVER_DEF__USER:
                return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
            case MdmmetadataPackage.MDM_SERVER_DEF__ENABLED:
                return enabled != ENABLED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setReadOnly(boolean newReadOnly) {

    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (host: ");
        result.append(host);
        result.append(", passwd: ");
        result.append(passwd);
        result.append(", tempPasswd: ");
        result.append(tempPasswd);
        result.append(", path: ");
        result.append(path);
        result.append(", port: ");
        result.append(port);
        result.append(", universe: ");
        result.append(universe);
        result.append(", url: ");
        result.append(url);
        result.append(", user: ");
        result.append(user);
        result.append(", enabled: ");
        result.append(enabled);
        result.append(')');
        return result.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.model.mdmmetadata.MDMServerDef#getDecryptedServerDef()
     */
    @Override
    public MDMServerDef getDecryptedServerDef() {
        MDMServerDef clone = EcoreUtil.copy(this);

        if (clone.getPasswd() == null || clone.getPasswd().trim().length() == 0) {
            clone.setPasswd(getTempPasswd());
        } else {
            String decryptedPassword = PasswordUtil.decryptPassword(getPasswd());
            clone.setPasswd(decryptedPassword);
        }
        return clone;
    }

    @Override
    public MDMServerDef getEncryptedServerDef() {
        MDMServerDef clone = EcoreUtil.copy(this);

        String encryptedPassword = PasswordUtil.encryptPassword(getPasswd());
        clone.setPasswd(encryptedPassword);

        return clone;
    }

} // MDMServerDefImpl
