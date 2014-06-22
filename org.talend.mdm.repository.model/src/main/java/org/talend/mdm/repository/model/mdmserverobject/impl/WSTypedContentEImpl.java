/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;
import org.talend.mdm.repository.model.mdmserverobject.WSByteArrayE;
import org.talend.mdm.repository.model.mdmserverobject.WSTypedContentE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Typed Content E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTypedContentEImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTypedContentEImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.impl.WSTypedContentEImpl#getWsBytes <em>Ws Bytes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSTypedContentEImpl extends EObjectImpl implements WSTypedContentE {
    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

    /**
     * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContentType()
     * @generated
     * @ordered
     */
    protected static final String CONTENT_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContentType()
     * @generated
     * @ordered
     */
    protected String contentType = CONTENT_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getWsBytes() <em>Ws Bytes</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWsBytes()
     * @generated
     * @ordered
     */
    protected WSByteArrayE wsBytes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WSTypedContentEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmserverobjectPackage.Literals.WS_TYPED_CONTENT_E;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUrl(String newUrl) {
        String oldUrl = url;
        url = newUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TYPED_CONTENT_E__URL, oldUrl, url));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContentType(String newContentType) {
        String oldContentType = contentType;
        contentType = newContentType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TYPED_CONTENT_E__CONTENT_TYPE, oldContentType, contentType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WSByteArrayE getWsBytes() {
        return wsBytes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWsBytes(WSByteArrayE newWsBytes, NotificationChain msgs) {
        WSByteArrayE oldWsBytes = wsBytes;
        wsBytes = newWsBytes;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES, oldWsBytes, newWsBytes);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWsBytes(WSByteArrayE newWsBytes) {
        if (newWsBytes != wsBytes) {
            NotificationChain msgs = null;
            if (wsBytes != null)
                msgs = ((InternalEObject)wsBytes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES, null, msgs);
            if (newWsBytes != null)
                msgs = ((InternalEObject)newWsBytes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES, null, msgs);
            msgs = basicSetWsBytes(newWsBytes, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES, newWsBytes, newWsBytes));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES:
                return basicSetWsBytes(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__URL:
                return getUrl();
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__CONTENT_TYPE:
                return getContentType();
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES:
                return getWsBytes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__URL:
                setUrl((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__CONTENT_TYPE:
                setContentType((String)newValue);
                return;
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES:
                setWsBytes((WSByteArrayE)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__URL:
                setUrl(URL_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__CONTENT_TYPE:
                setContentType(CONTENT_TYPE_EDEFAULT);
                return;
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES:
                setWsBytes((WSByteArrayE)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__URL:
                return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__CONTENT_TYPE:
                return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
            case MdmserverobjectPackage.WS_TYPED_CONTENT_E__WS_BYTES:
                return wsBytes != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (url: ");
        result.append(url);
        result.append(", contentType: ");
        result.append(contentType);
        result.append(')');
        return result.toString();
    }

} //WSTypedContentEImpl
