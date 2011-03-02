// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.register.proxy;

/**
 * DOC mhirt class global comment. Detailled comment <br/>
 * 
 */
public class RegisterUserBindingStub extends org.apache.axis.client.Stub implements IRegisterUserPortType {

    private java.util.Vector cachedSerClasses = new java.util.Vector();

    private java.util.Vector cachedSerQNames = new java.util.Vector();

    private java.util.Vector cachedSerFactories = new java.util.Vector();

    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc[] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1() {
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RegisterUser");//$NON-NLS-1$
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "country"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "designerversion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RegisterUserWithProductName");//$NON-NLS-1$
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "country"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "designerversion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "productname"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RegisterUserWithAllUserInformations");//$NON-NLS-1$
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "country"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "designerversion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "productname"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", //$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectLanguage"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "osName"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "osVersion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "javaVersion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalMemory"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "memRAM"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nbProc"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RegisterUserWithAllUserInformationsAndReturnId");//$NON-NLS-1$
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "country"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "designerversion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "productname"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectLanguage"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "osName"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "osVersion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "javaVersion"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "totalMemory"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "memRAM"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nbProc"),//$NON-NLS-1$//$NON-NLS-2$
                org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",//$NON-NLS-1$
                        "string"), java.lang.String.class, false, false);//$NON-NLS-1$
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setReturnClass(java.math.BigInteger.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListUsers");//$NON-NLS-1$
        oper.setReturnType(new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "UserRegistrations"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setReturnClass(UserRegistration[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));//$NON-NLS-1$//$NON-NLS-2$
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

    }

    public RegisterUserBindingStub() throws org.apache.axis.AxisFault {
        this(null);
    }

    public RegisterUserBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public RegisterUserBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");//$NON-NLS-1$
        java.lang.Class cls;
        javax.xml.namespace.QName qName;
        javax.xml.namespace.QName qName2;
        java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
        java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
        java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
        java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
        java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
        java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
        java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
        java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
        java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
        java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        qName = new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "UserRegistration");//$NON-NLS-1$//$NON-NLS-2$
        cachedSerQNames.add(qName);
        cls = UserRegistration.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "UserRegistrations");//$NON-NLS-1$//$NON-NLS-2$
        cachedSerQNames.add(qName);
        cls = UserRegistration[].class;
        cachedSerClasses.add(cls);
        qName = new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "UserRegistration");//$NON-NLS-1$//$NON-NLS-2$
        qName2 = null;
        cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
        cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class) cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class) cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        } else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
                                    .get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
                                    .get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        } catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public boolean registerUser(java.lang.String email, java.lang.String country, java.lang.String designerversion)
            throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.talend.com/TalendRegisterWS/registerws.php/RegisterUser");//$NON-NLS-1$
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "RegisterUser"));//$NON-NLS-1$//$NON-NLS-2$

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] { email, country, designerversion });

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return ((java.lang.Boolean) _resp).booleanValue();
                } catch (java.lang.Exception _exception) {
                    return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public boolean registerUserWithProductName(java.lang.String email, java.lang.String country,
            java.lang.String designerversion, java.lang.String productname) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.talend.com/TalendRegisterWS/registerws.php/RegisterUserWithProductName");//$NON-NLS-1$
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl",//$NON-NLS-1$
                "RegisterUserWithProductName"));//$NON-NLS-1$

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] { email, country, designerversion, productname });

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return ((java.lang.Boolean) _resp).booleanValue();
                } catch (java.lang.Exception _exception) {
                    return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public boolean registerUserWithAllUserInformations(java.lang.String email, java.lang.String country,
            java.lang.String designerversion, java.lang.String productname, java.lang.String projectLanguage,
            java.lang.String osName, java.lang.String osVersion, java.lang.String javaVersion, java.lang.String totalMemory,
            java.lang.String memRAM, java.lang.String nbProc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.talend.com/TalendRegisterWS/registerws.php/RegisterUserWithAllUserInformations");//$NON-NLS-1$
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(
                "http://www.talend.com/TalendRegisterWS/wsdl", "RegisterUserWithAllUserInformations"));//$NON-NLS-1$//$NON-NLS-2$

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] { email, country, designerversion, productname,
                    projectLanguage, osName, osVersion, javaVersion, totalMemory, memRAM, nbProc });

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return ((java.lang.Boolean) _resp).booleanValue();
                } catch (java.lang.Exception _exception) {
                    return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public java.math.BigInteger registerUserWithAllUserInformationsAndReturnId(java.lang.String email, java.lang.String country,
            java.lang.String designerversion, java.lang.String productname, java.lang.String projectLanguage,
            java.lang.String osName, java.lang.String osVersion, java.lang.String javaVersion, java.lang.String totalMemory,
            java.lang.String memRAM, java.lang.String nbProc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.talend.com/TalendRegisterWS/registerws.php/RegisterUserWithAllUserInformationsAndReturnId");//$NON-NLS-1$
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(
                "http://www.talend.com/TalendRegisterWS/wsdl", "RegisterUserWithAllUserInformationsAndReturnId"));//$NON-NLS-1$//$NON-NLS-2$

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] { email, country, designerversion, productname,
                    projectLanguage, osName, osVersion, javaVersion, totalMemory, memRAM, nbProc });

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (java.math.BigInteger) _resp;
                } catch (java.lang.Exception _exception) {
                    return (java.math.BigInteger) org.apache.axis.utils.JavaUtils.convert(_resp, java.math.BigInteger.class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public UserRegistration[] listUsers() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.talend.com/TalendRegisterWS/registerws.php/ListUsers");//$NON-NLS-1$
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.talend.com/TalendRegisterWS/wsdl", "ListUsers"));//$NON-NLS-1$//$NON-NLS-2$

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (UserRegistration[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (UserRegistration[]) org.apache.axis.utils.JavaUtils.convert(_resp, UserRegistration[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

}
