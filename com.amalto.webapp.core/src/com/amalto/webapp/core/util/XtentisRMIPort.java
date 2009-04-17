package com.amalto.webapp.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;

import org.jboss.security.Base64Encoder;
import org.w3c.dom.Element;

import sun.misc.BASE64Decoder;

import com.amalto.connector.jca.InteractionSpecImpl;
import com.amalto.connector.jca.RecordFactoryImpl;
import com.amalto.core.ejb.ItemPOJO;
import com.amalto.core.ejb.ItemPOJOPK;
import com.amalto.core.ejb.ObjectPOJO;
import com.amalto.core.ejb.TransformerCtrlBean;
import com.amalto.core.ejb.TransformerPOJO;
import com.amalto.core.ejb.TransformerPOJOPK;
import com.amalto.core.ejb.XtentisWSBean;
import com.amalto.core.ejb.local.TransformerCtrlLocal;
import com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJO;
import com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK;
import com.amalto.core.objects.backgroundjob.ejb.local.BackgroundJobCtrlUtil;
import com.amalto.core.objects.datacluster.ejb.DataClusterPOJO;
import com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK;
import com.amalto.core.objects.datamodel.ejb.DataModelPOJO;
import com.amalto.core.objects.datamodel.ejb.DataModelPOJOPK;
import com.amalto.core.objects.menu.ejb.MenuEntryPOJO;
import com.amalto.core.objects.menu.ejb.MenuPOJO;
import com.amalto.core.objects.menu.ejb.MenuPOJOPK;
import com.amalto.core.objects.menu.ejb.local.MenuCtrlLocal;
import com.amalto.core.objects.role.ejb.RolePOJO;
import com.amalto.core.objects.role.ejb.RolePOJOPK;
import com.amalto.core.objects.role.ejb.local.RoleCtrlLocal;
import com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJO;
import com.amalto.core.objects.routing.v2.ejb.AbstractRoutingOrderV2POJOPK;
import com.amalto.core.objects.routing.v2.ejb.ActiveRoutingOrderV2POJO;
import com.amalto.core.objects.routing.v2.ejb.ActiveRoutingOrderV2POJOPK;
import com.amalto.core.objects.routing.v2.ejb.CompletedRoutingOrderV2POJO;
import com.amalto.core.objects.routing.v2.ejb.CompletedRoutingOrderV2POJOPK;
import com.amalto.core.objects.routing.v2.ejb.FailedRoutingOrderV2POJO;
import com.amalto.core.objects.routing.v2.ejb.FailedRoutingOrderV2POJOPK;
import com.amalto.core.objects.routing.v2.ejb.RoutingEngineV2POJO;
import com.amalto.core.objects.routing.v2.ejb.RoutingRuleExpressionPOJO;
import com.amalto.core.objects.routing.v2.ejb.RoutingRulePOJO;
import com.amalto.core.objects.routing.v2.ejb.RoutingRulePOJOPK;
import com.amalto.core.objects.routing.v2.ejb.local.RoutingEngineV2CtrlLocal;
import com.amalto.core.objects.routing.v2.ejb.local.RoutingOrderV2CtrlLocal;
import com.amalto.core.objects.storedprocedure.ejb.StoredProcedurePOJO;
import com.amalto.core.objects.storedprocedure.ejb.StoredProcedurePOJOPK;
import com.amalto.core.objects.storedprocedure.ejb.local.StoredProcedureCtrlLocal;
import com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO;
import com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK;
import com.amalto.core.objects.synchronization.ejb.SynchronizationPlanItemLine;
import com.amalto.core.objects.synchronization.ejb.SynchronizationPlanObjectLine;
import com.amalto.core.objects.synchronization.ejb.SynchronizationPlanPOJO;
import com.amalto.core.objects.synchronization.ejb.SynchronizationPlanPOJOPK;
import com.amalto.core.objects.synchronization.ejb.SynchronizationRemoteInstance;
import com.amalto.core.objects.synchronization.ejb.local.SynchronizationItemCtrlLocal;
import com.amalto.core.objects.synchronization.ejb.local.SynchronizationPlanCtrlLocal;
import com.amalto.core.objects.synchronization.ejb.local.SynchronizationPlanCtrlUtil;
import com.amalto.core.objects.transformers.v2.ejb.TransformerV2CtrlBean;
import com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO;
import com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK;
import com.amalto.core.objects.transformers.v2.ejb.local.TransformerV2CtrlLocal;
import com.amalto.core.objects.transformers.v2.util.TransformerCallBack;
import com.amalto.core.objects.transformers.v2.util.TransformerContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TransformerProcessStep;
import com.amalto.core.objects.transformers.v2.util.TransformerVariablesMapping;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.objects.universe.ejb.UniversePOJO;
import com.amalto.core.objects.universe.ejb.UniversePOJOPK;
import com.amalto.core.objects.universe.ejb.local.UniverseCtrlLocal;
import com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK;
import com.amalto.core.objects.versioning.ejb.local.VersioningSystemCtrlLocal;
import com.amalto.core.objects.view.ejb.ViewPOJO;
import com.amalto.core.objects.view.ejb.ViewPOJOPK;
import com.amalto.core.util.ArrayListHolder;
import com.amalto.core.util.LocalUser;
import com.amalto.core.util.RoleInstance;
import com.amalto.core.util.RoleSpecification;
import com.amalto.core.util.TransformerPluginSpec;
import com.amalto.core.util.Util;
import com.amalto.core.util.Version;
import com.amalto.core.util.XSDKey;
import com.amalto.webapp.util.webservices.*;
import com.amalto.xmlserver.interfaces.IWhereItem;
import com.amalto.xmlserver.interfaces.WhereAnd;
import com.amalto.xmlserver.interfaces.WhereCondition;
import com.amalto.xmlserver.interfaces.WhereOr;

/**
 * The list of web services implemented as RMI local calls
 * 
 * @author Bruno Grieder
 *
 */
@SuppressWarnings({"deprecation", "unchecked"})
public class XtentisRMIPort implements XtentisPort {


	/**
	 *  
	 */
	public XtentisRMIPort() {
		super();
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("XtentisRMIPort() Using RMI");
	}



	/***************************************************************************
	 * 
	 * S E R V I C E S
	 *  
	 *	 **************************************************************************/

	/***************************************************************************
	 * Components Management
	 * **************************************************************************/
	
	public WSVersion getComponentVersion(WSGetComponentVersion wsGetComponentVersion) throws RemoteException {
		try {
			if (WSComponent.DataManager.equals(wsGetComponentVersion.getComponent())) {	
				Version version = Version.getVersion(XtentisWSBean.class);
				return new WSVersion(
						version.getMajor(),
						version.getMinor(),
						version.getRevision(),
						version.getBuild(),
						version.getDescription(),
						version.getDate()
				);
			}
			throw new RemoteException ("Version information is not available yet for "+wsGetComponentVersion.getComponent().getValue()+" components"); 
		} catch (RemoteException e) {
			throw(e);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}


	
	/***************************************************************************
	 * Initialize
	 * **************************************************************************/
	
	public WSInt initMDM(WSInitData initData) throws RemoteException {
		throw new RemoteException("initMDM not implemented as RMI call");
	}	
	
	/***************************************************************************
	 * Logout
	 * **************************************************************************/

	public WSString logout(WSLogout wsLogout) throws RemoteException {
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("logout() ");
		String msg = "OK";
		try {
		    LocalUser user = LocalUser.getLocalUser();
		    user.logout();
		} catch (Exception e) {
			String err = "Error trying to logout";
			org.apache.log4j.Logger.getLogger(this.getClass()).warn(err,e);
			msg = e.getMessage();
		}
		return new WSString(msg);
	}
	
	/***************************************************************************
	 * Data Model
	 * **************************************************************************/
    
    public WSDataModel getDataModel(WSGetDataModel wsDataModelget)
    throws RemoteException {
		try {
		    return VO2WS( 
					com.amalto.core.util.Util.getDataModelCtrlLocal().getDataModel(
							new DataModelPOJOPK(wsDataModelget.getWsDataModelPK().getPk())
					)
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
    
    public WSDataModelPKArray getDataModelPKs(WSRegexDataModelPKs regexp)
    throws RemoteException {
		try {
						
		    WSDataModelPKArray array = new WSDataModelPKArray();
		    Collection<DataModelPOJOPK> pks = com.amalto.core.util.Util.getDataModelCtrlLocal().getDataModelPKs(regexp.getRegex());
		    ArrayList<WSDataModelPK> list = new ArrayList<WSDataModelPK>();
		    for (Iterator iter = pks.iterator(); iter.hasNext(); ) {
				DataModelPOJOPK pk = (DataModelPOJOPK) iter.next();
				WSDataModelPK dmpk = new WSDataModelPK(pk.getUniqueId());
				list.add(dmpk);
			}
			array.setWsDataModelPKs(list.toArray(new WSDataModelPK[list.size()]));
			return array;
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
    public WSDataModelPK deleteDataModel(WSDeleteDataModel wsDeleteDataModel)
    throws RemoteException {
		try {
		    return new WSDataModelPK(
		    		com.amalto.core.util.Util.getDataModelCtrlLocal().removeDataModel(
							new DataModelPOJOPK(wsDeleteDataModel.getWsDataModelPK().getPk())
					).getUniqueId()
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }	
    
    public WSBoolean existsDataModel(WSExistsDataModel wsExistsDataModel)
    throws RemoteException {
		try {
		    return new WSBoolean( 
					(Util.getDataModelCtrlLocal().existsDataModel(
							new DataModelPOJOPK(wsExistsDataModel.getWsDataModelPK().getPk())
					) != null)
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
    public WSDataModelPK putDataModel(WSPutDataModel wsDataModel)
    throws RemoteException {
		try {
		    return new WSDataModelPK(
		    		com.amalto.core.util.Util.getDataModelCtrlLocal().putDataModel(
							WS2VO(wsDataModel.getWsDataModel())
					).getUniqueId()
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
 
    
	public WSString checkSchema(WSCheckSchema wsSchema) throws RemoteException {
		try {
		    return new WSString(
		    		com.amalto.core.util.Util.getDataModelCtrlLocal().checkSchema(wsSchema.getSchema())
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
    public WSString putBusinessConcept(WSPutBusinessConcept wsPutBusinessConcept)
    throws RemoteException {
        WSBusinessConcept bc = wsPutBusinessConcept.getBusinessConcept();
		try {
		    String s = 
		    "<xsd:element name="+bc.getName()+" type="+bc.getBusinessTemplate()+">"+
		    "	<xsd:annotation>";
		    WSI18NString[] labels = bc.getWsLabel();
		    for (int i = 0; i < labels.length; i++) {
		        s+="<xsd:appinfo source=\""+labels[i].getLanguage().getValue()+"\">"+labels[i].getLabel()+"</xsd:appinfo>";
            }
		    WSI18NString[] docs = bc.getWsDescription();
		    for (int i = 0; i < docs.length; i++) {
		        s+="<xsd:documentation xml:lang=\""+docs[i].getLanguage().getValue()+"\">"+docs[i].getLabel()+"</xsd:documentation>";
            }
		    s+=
		    "	</xsd:annotation>"+
		    "	<xsd:unique name=\""+bc.getName()+"\">"+
		    "		<xsd:selector xpath=\""+bc.getWsUniqueKey().getSelectorpath()+"\"/>";
		    for (int i = 0; i < bc.getWsUniqueKey().getFieldpath().length; i++) {
			    s+="<xsd:field xpath=\""+bc.getWsUniqueKey().getFieldpath()[i]+"\"/>";	
            }
		    s+=
		    "	</xsd:unique>"+
		    "</xsd:element>";
		    return 
		    	new WSString(
					Util.getDataModelCtrlLocal().putBusinessConceptSchema(
					        new DataModelPOJOPK(wsPutBusinessConcept.getWsDataModelPK().getPk()),
					        s
					 )
				);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
    public WSString putBusinessConceptSchema(WSPutBusinessConceptSchema wsPutBusinessConceptSchema)
    throws RemoteException {
		try {
		    return new WSString(
					Util.getDataModelCtrlLocal().putBusinessConceptSchema(
					        new DataModelPOJOPK(wsPutBusinessConceptSchema.getWsDataModelPK().getPk()),
					        wsPutBusinessConceptSchema.getBusinessConceptSchema()
					 )
				);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
    
    public WSString deleteBusinessConcept(
            WSDeleteBusinessConcept wsDeleteBusinessConcept)
            throws RemoteException {
		try {
		    return new WSString(
		    		com.amalto.core.util.Util.getDataModelCtrlLocal().deleteBusinessConcept(
							new DataModelPOJOPK(wsDeleteBusinessConcept.getWsDataModelPK().getPk()),
							wsDeleteBusinessConcept.getBusinessConceptName()
					 )
				);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
	
    public WSStringArray getBusinessConcepts(
            WSGetBusinessConcepts wsGetBusinessConcepts) throws RemoteException {
		try {
		    return new WSStringArray(
		    		com.amalto.core.util.Util.getDataModelCtrlLocal().getAllBusinessConceptsNames(
							new DataModelPOJOPK(wsGetBusinessConcepts.getWsDataModelPK().getPk())
					 )
				);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
    
	public WSConceptKey getBusinessConceptKey(WSGetBusinessConceptKey wsGetBusinessConceptKey) throws RemoteException {
		try {
			String schema = 
				Util.getDataModelCtrlLocal().getDataModel(
						new DataModelPOJOPK(wsGetBusinessConceptKey.getWsDataModelPK().getPk())
				).getSchema();

			XSDKey xsdKey = Util.getBusinessConceptKey(
					Util.parse(schema),
					wsGetBusinessConceptKey.getConcept()
			);
			return
				new WSConceptKey(
						xsdKey.getSelector(),
						xsdKey.getFields()
				);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	

	private WSDataModel VO2WS(DataModelPOJO vo) {
	    WSDataModel s = new WSDataModel();
		s.setDescription(vo.getDescription());
		s.setName(vo.getName());
		s.setXsdSchema(vo.getSchema());
		return s;
	}
	private DataModelPOJO WS2VO(WSDataModel ws) throws Exception{
	    DataModelPOJO dv = new DataModelPOJO();
	    dv.setName(ws.getName());
	    dv.setDescription(ws.getDescription());
	    dv.setSchema(ws.getXsdSchema());
		return dv;
	}
    
	
	/***************************************************************************
	 * DataCluster
	 * **************************************************************************/
    	
	   public WSDataCluster getDataCluster(WSGetDataCluster wsDataClusterGet)
	    throws RemoteException {
			try {
			    return VO2WS( 
			    		com.amalto.core.util.Util.getDataClusterCtrlLocal().getDataCluster(
								new DataClusterPOJOPK(wsDataClusterGet.getWsDataClusterPK().getPk())
						)
				);
			} catch (Exception e) {
				throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
			}
	    }
	    
	    
	   public WSBoolean existsDataCluster(WSExistsDataCluster wsExistsDataCluster)
	    throws RemoteException {
			try {
			    return new WSBoolean( 
						com.amalto.core.util.Util.getDataClusterCtrlLocal().existsDataCluster(
								new DataClusterPOJOPK(wsExistsDataCluster.getWsDataClusterPK().getPk())
						) != null
				);
			} catch (Exception e) {
				throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
			}
	    }
	   
	    public WSDataClusterPKArray getDataClusterPKs(WSRegexDataClusterPKs regexp)
	    throws RemoteException {
			try {
			    WSDataClusterPKArray array = new WSDataClusterPKArray();
			    Collection<DataClusterPOJOPK> pks = com.amalto.core.util.Util.getDataClusterCtrlLocal().getDataClusterPKs(regexp.getRegex());
			    ArrayList<WSDataClusterPK> list = new ArrayList<WSDataClusterPK>();
			    for (Iterator iter = pks.iterator(); iter.hasNext(); ) {
					DataClusterPOJOPK pk = (DataClusterPOJOPK) iter.next();
					list.add(new WSDataClusterPK(pk.getUniqueId()));
				}
				array.setWsDataClusterPKs(list.toArray(new WSDataClusterPK[list.size()]));
				return array;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
			}
	    }

	
	    public WSDataClusterPK deleteDataCluster(WSDeleteDataCluster wsDeleteDataCluster)
	    throws RemoteException {
			try {
			    return new WSDataClusterPK(
			    		com.amalto.core.util.Util.getDataClusterCtrlLocal().removeDataCluster(
								new DataClusterPOJOPK(wsDeleteDataCluster.getWsDataClusterPK().getPk())
						).getUniqueId()
				);
			} catch (Exception e) {
				throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
			}
	    }	
	    
	   
	public WSDataClusterPK putDataCluster(WSPutDataCluster wsDataCluster)
	throws RemoteException {
		try {
			return new WSDataClusterPK(
					com.amalto.core.util.Util.getDataClusterCtrlLocal().putDataCluster(
							WS2VO(wsDataCluster.getWsDataCluster())
					).getUniqueId()
			);
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSStringArray getConceptsInDataCluster(WSGetConceptsInDataCluster wsGetConceptsInDataCluster) throws RemoteException {
		try {
			Collection<String> results = 
				com.amalto.core.util.Util.getItemCtrl2Local().getConceptsInDataCluster(
					new DataClusterPOJOPK(wsGetConceptsInDataCluster.getWsDataClusterPK().getPk())
				).keySet();
							
	 		return new WSStringArray(results.toArray(new String[results.size()]));

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	    
		
	private WSDataCluster VO2WS(DataClusterPOJO pojo) {
	    WSDataCluster s = new WSDataCluster();
		s.setDescription(pojo.getDescription());
		s.setName(pojo.getName());
		s.setVocabulary(pojo.getVocabulary());
		return s;
	}
	
	private DataClusterPOJO WS2VO(WSDataCluster ws) throws Exception{
		DataClusterPOJO vo = new DataClusterPOJO();
		vo.setName(ws.getName());
		vo.setDescription(ws.getDescription());
		vo.setVocabulary(ws.getVocabulary());
		return vo;
	}

	/***************************************************************************
	 * View
	 * **************************************************************************/
		
   public WSView getView(WSGetView wsViewGet)
    throws RemoteException {
		try {
    		return VO2WS(com.amalto.core.util.Util.getViewCtrlLocalHome().create().getView(new ViewPOJOPK(wsViewGet.getWsViewPK().getPk())));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
	    
   public WSBoolean existsView(WSExistsView wsExistsView)
   throws RemoteException {
		try {
		    return new WSBoolean( 
		    		com.amalto.core.util.Util.getViewCtrlLocalHome().create().existsView(
							new ViewPOJOPK(wsExistsView.getWsViewPK().getPk())
					) != null
			);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
   }
	   

    public WSViewPKArray getViewPKs(WSGetViewPKs regexp)   throws RemoteException {
		try {
	        ArrayList l;
	        String regex = regexp.getRegex() != null && !"".equals(regexp.getRegex()) && !"*".equals(regexp.getRegex()) ? regexp.getRegex() : ".*";
	        Collection list = com.amalto.core.util.Util.getViewCtrlLocalHome().create().getViewPKs(regex);
	        l = new ArrayList();
	        ViewPOJOPK pk;
	        for(Iterator iter = list.iterator(); iter.hasNext(); l.add(new WSViewPK(pk.getIds()[0])))
	            pk = (ViewPOJOPK)iter.next();
	        return new WSViewPKArray((WSViewPK[])l.toArray(new WSViewPK[l.size()]));

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
    
	
    public WSViewPK deleteView(WSDeleteView wsDeleteView)
    throws RemoteException {
		try {
			return new WSViewPK(com.amalto.core.util.Util.getViewCtrlLocalHome().create().removeView(new ViewPOJOPK(wsDeleteView.getWsViewPK().getPk())).getIds()[0]);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }	
    
	   
    public WSViewPK putView(WSPutView wsView)
    throws RemoteException {
		try {
			return new WSViewPK(com.amalto.core.util.Util.getViewCtrlLocalHome().create().putView(WS2VO(wsView.getWsView())).getIds()[0]);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }

    
    
    private WSView VO2WS(ViewPOJO pojo) throws Exception {
		WSView s = new WSView();
		s.setDescription(pojo.getDescription());
		s.setName(pojo.getName());
		String bes[] = null;
		Collection c = pojo.getSearchableBusinessElements().getList();
		if (c != null) {
			bes = new String[c.size()];
			int i = 0;
			for (Iterator iter = c.iterator(); iter.hasNext();) {
				String be = (String) iter.next();
				bes[i++] = be;
			}

		}
		s.setSearchableBusinessElements(bes);
		c = pojo.getViewableBusinessElements().getList();
		if (c != null) {
			bes = new String[c.size()];
			int i = 0;
			for (Iterator iter = c.iterator(); iter.hasNext();) {
				String be = (String) iter.next();
				bes[i++] = be;
			}

		}
		s.setViewableBusinessElements(bes);
		c = pojo.getWhereConditions().getList();
		if (c != null) {
			WSWhereCondition wcs[] = new WSWhereCondition[c.size()];
			int i = 0;
			for (Iterator iter = c.iterator(); iter.hasNext();) {
				WhereCondition wh = (WhereCondition) iter.next();
				wcs[i++] = VO2WS(wh);
			}

			s.setWhereConditions(wcs);
		}
		return s;
	}

	private ViewPOJO WS2VO(WSView ws) throws Exception {
		ViewPOJO pojo = new ViewPOJO();
		pojo.setName(ws.getName());
		pojo.setDescription(ws.getDescription());
		ArrayList l = new ArrayList();
		String s[] = ws.getSearchableBusinessElements();
		if (s != null) {
			for (int i = 0; i < s.length; i++)
				l.add(ws.getSearchableBusinessElements()[i]);

		}
		pojo.setSearchableBusinessElements(new ArrayListHolder(l));
		l = new ArrayList();
		s = ws.getViewableBusinessElements();
		if (s != null) {
			for (int i = 0; i < s.length; i++)
				l.add(ws.getViewableBusinessElements()[i]);

		}
		pojo.setViewableBusinessElements(new ArrayListHolder(l));
		l = new ArrayList();
		WSWhereCondition whs[] = ws.getWhereConditions();
		if (whs != null) {
			for (int i = 0; i < whs.length; i++)
				l.add(WS2VO(whs[i]));

		}
		pojo.setWhereConditions(new ArrayListHolder(l));
		return pojo;
	}

	
	
    private WSWhereCondition VO2WS(WhereCondition vo) throws Exception{
    	WSWhereCondition ws = new WSWhereCondition();
    	WSWhereOperator op = WSWhereOperator.CONTAINS;
		String operator = vo.getOperator();
		if(operator.equals(WhereCondition.CONTAINS)) op=WSWhereOperator.CONTAINS; 
		else if(operator.equals(WhereCondition.STRICTCONTAINS)) op=WSWhereOperator.STRICTCONTAINS; 
		else if(operator.equals(WhereCondition.STARTSWITH)) op=WSWhereOperator.STARTSWITH;
		else if(operator.equals(WhereCondition.JOINS)) op=WSWhereOperator.JOIN;
		else if(operator.equals(WhereCondition.EQUALS)) op=WSWhereOperator.EQUALS;
		else if(operator.equals(WhereCondition.NOT_EQUALS))	op=WSWhereOperator.NOT_EQUALS;
		else if(operator.equals(WhereCondition.GREATER_THAN)) op=WSWhereOperator.GREATER_THAN;
		else if(operator.equals(WhereCondition.GREATER_THAN_OR_EQUAL)) op=WSWhereOperator.GREATER_THAN_OR_EQUAL;
		else if(operator.equals(WhereCondition.LOWER_THAN)) op=WSWhereOperator.LOWER_THAN;
		else if(operator.equals(WhereCondition.LOWER_THAN_OR_EQUAL)) op=WSWhereOperator.LOWER_THAN_OR_EQUAL;
		else if(operator.equals(WhereCondition.NO_OPERATOR)) op=WSWhereOperator.NO_OPERATOR;
		
		String predicate = vo.getStringPredicate();
		WSStringPredicate pr=WSStringPredicate.NONE;
		if ((predicate==null) || predicate.equals(WhereCondition.PRE_NONE)) pr=WSStringPredicate.NONE;
		else if (predicate.equals(WhereCondition.PRE_AND)) pr=WSStringPredicate.AND;
		else if (predicate.equals(WhereCondition.PRE_EXACTLY)) pr=WSStringPredicate.EXACTLY;
		else if (predicate.equals(WhereCondition.PRE_STRICTAND)) pr=WSStringPredicate.STRICTAND;
		else if (predicate.equals(WhereCondition.PRE_OR)) pr=WSStringPredicate.OR;
		else if (predicate.equals(WhereCondition.PRE_NOT)) pr=WSStringPredicate.NOT;

		ws.setLeftPath(vo.getLeftPath());
		ws.setOperator(op);
		ws.setRightValueOrPath(vo.getRightValueOrPath());
		ws.setStringPredicate(pr);
    	return ws;
    }
	
    
    private IWhereItem WS2VO(WSWhereItem ws) throws Exception{
    	
    	if (ws==null) return null;
    	
    	if (ws.getWhereAnd() !=  null) {
    		WhereAnd wand = new WhereAnd();
    		WSWhereItem[] children = ws.getWhereAnd().getWhereItems();
    		if (children!=null) {
    			for (int i = 0; i < children.length; i++) {
					wand.add(WS2VO(children[i]));
				}
    		}
    		return wand;
    	} else if (ws.getWhereOr() !=  null) {
    		WhereOr wor = new WhereOr();
    		WSWhereItem[] children = ws.getWhereOr().getWhereItems();
    		if (children!=null) {
    			for (int i = 0; i < children.length; i++) {
					wor.add(WS2VO(children[i]));
				}
    		}
    		return wor;
    	} else if (ws.getWhereCondition() != null) {
    		return WS2VO(ws.getWhereCondition());
    	} else {
    		throw new IllegalArgumentException("The WSWhereItem mus have at least one child");
    	}
    }
	
	private WhereCondition WS2VO(WSWhereCondition ws) throws Exception{
		
		String operator = WhereCondition.CONTAINS;
		if (ws.getOperator().equals(WSWhereOperator.CONTAINS)) {
			operator = WhereCondition.CONTAINS;
		} else	if (ws.getOperator().equals(WSWhereOperator.STRICTCONTAINS)) {
				operator = WhereCondition.STRICTCONTAINS;
		} else	if (ws.getOperator().equals(WSWhereOperator.STARTSWITH)) {
			operator = WhereCondition.STARTSWITH;
		} else	if (ws.getOperator().equals(WSWhereOperator.JOIN)) {
			operator = WhereCondition.JOINS;
		} else	if (ws.getOperator().equals(WSWhereOperator.EQUALS)) {
			operator = WhereCondition.EQUALS;
		} else	if (ws.getOperator().equals(WSWhereOperator.NOT_EQUALS)) {
				operator = WhereCondition.NOT_EQUALS;
		} else	if (ws.getOperator().equals(WSWhereOperator.GREATER_THAN)) {
			operator = WhereCondition.GREATER_THAN;
		} else	if (ws.getOperator().equals(WSWhereOperator.GREATER_THAN_OR_EQUAL)) {
			operator = WhereCondition.GREATER_THAN_OR_EQUAL;
		} else	if (ws.getOperator().equals(WSWhereOperator.LOWER_THAN)) {
			operator = WhereCondition.LOWER_THAN;
		} else	if (ws.getOperator().equals(WSWhereOperator.LOWER_THAN_OR_EQUAL)) {
			operator = WhereCondition.LOWER_THAN_OR_EQUAL;
		} else	if (ws.getOperator().equals(WSWhereOperator.NO_OPERATOR)) {
			operator = WhereCondition.NO_OPERATOR;
		}
		
		String predicate = WhereCondition.PRE_AND;
		if (ws.getStringPredicate().equals(WSStringPredicate.NONE)) {
			predicate = WhereCondition.PRE_NONE;
		} else	if (ws.getStringPredicate().equals(WSStringPredicate.AND)) {
			predicate = WhereCondition.PRE_AND;
		} else	if (ws.getStringPredicate().equals(WSStringPredicate.EXACTLY)) {
			predicate = WhereCondition.PRE_EXACTLY;
		} else	if (ws.getStringPredicate().equals(WSStringPredicate.STRICTAND)) {
			predicate = WhereCondition.PRE_STRICTAND;
		} else	if (ws.getStringPredicate().equals(WSStringPredicate.OR)) {
			predicate = WhereCondition.PRE_OR;
		} else	if (ws.getStringPredicate().equals(WSStringPredicate.NOT)) {
			predicate = WhereCondition.PRE_NOT;
		}
		
		return new WhereCondition(
			ws.getLeftPath(),
			operator,
			ws.getRightValueOrPath(),
			predicate,
			ws.isSpellCheck()
		);
	}
	
	

	/***************************************************************************
	 * Search
	 * **************************************************************************/
	
	public WSStringArray viewSearch(WSViewSearch wsViewSearch) throws RemoteException {
		try {
			
			Collection res = Util.getItemCtrl2Local().viewSearch(
				new DataClusterPOJOPK(wsViewSearch.getWsDataClusterPK().getPk()),
				new ViewPOJOPK(wsViewSearch.getWsViewPK().getPk()),
				WS2VO(wsViewSearch.getWhereItem()),
				wsViewSearch.getSpellTreshold(),
				wsViewSearch.getOrderBy(),
				wsViewSearch.getDirection(),
				wsViewSearch.getSkip(),
				wsViewSearch.getMaxItems()
    		);
    		return new WSStringArray((String[])res.toArray(new String[res.size()]));
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
		
	public WSStringArray xPathsSearch(WSXPathsSearch wsXPathsSearch) throws RemoteException {
		try {
			Collection res = com.amalto.core.util.Util.getItemCtrl2Local().xPathsSearch(
				new DataClusterPOJOPK(wsXPathsSearch.getWsDataClusterPK().getPk()),
				wsXPathsSearch.getPivotPath(),
				new ArrayList<String>(Arrays.asList(wsXPathsSearch.getViewablePaths().getStrings())),
				WS2VO(wsXPathsSearch.getWhereItem()),
				wsXPathsSearch.getSpellTreshold(),
				wsXPathsSearch.getOrderBy(),
				wsXPathsSearch.getDirection(),
				wsXPathsSearch.getSkip(),
				wsXPathsSearch.getMaxItems()
			);
			return new WSStringArray((String[])res.toArray(new String[res.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
//		} catch (com.amalto.webapp.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}



	public WSStringArray getItems(WSGetItems wsGetItems) throws RemoteException {
		try {
			Collection res = com.amalto.core.util.Util.getItemCtrl2Local().getItems(
					new DataClusterPOJOPK(wsGetItems.getWsDataClusterPK().getPk()), 
					wsGetItems.getConceptName(), 
					WS2VO(wsGetItems.getWhereItem()), 
					wsGetItems.getSpellTreshold(), 
					wsGetItems.getSkip(), 
					wsGetItems.getMaxItems()
			);
			return new WSStringArray((String[])res.toArray(new String[res.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
//		} catch (com.amalto.webapp.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	
	public WSItemPKsByCriteriaResponse getItemPKsByCriteria(WSGetItemPKsByCriteria wsGetItemPKsByCriteria) throws RemoteException {
		try {
			
			String dataClusterName = wsGetItemPKsByCriteria.getWsDataClusterPK().getPk();
			
			//Check if user is allowed to read the cluster
			LocalUser user = LocalUser.getLocalUser();			
			boolean authorized = false;
	    	if ("admin".equals(user.getUsername()) || LocalUser.UNAUTHENTICATED_USER.equals(user.getUsername())) { 
	    		authorized = true;
	    	} else if (user.userCanRead(DataClusterPOJO.class, dataClusterName)) {
	    		authorized = true;
	    	}
	    	if (! authorized) {
	    		throw new RemoteException("Unauthorized read access on data cluster '"+dataClusterName+"' by user '"+user.getUsername()+"'");
	    	}
			
			//If not all concepts are store in the same revision, 
			//force the concept to be specified by the user. 
			//It would be too demanding to get all the concepts in all revisions (?)
			//The meat of this method should be ported to ItemCtrlBean
			String revisionID = null;
			if (wsGetItemPKsByCriteria.getConceptName() == null) {
    			if (user.getUniverse().getItemsRevisionIDs().size()>0) {
    				throw new RemoteException(
    					"User "+user.getUsername()+" is using items coming from multiple revisions." +
    					" In that particular case, the concept must be specified"
    				);
    			} else {
    				revisionID = user.getUniverse().getDefaultItemRevisionID();
    			}
			} else {
				revisionID = user.getUniverse().getConceptRevisionID(wsGetItemPKsByCriteria.getConceptName());
			}
			
			//FIXME: xQuery only
	 		String query = 
					"for $ii in /ii"+
					(wsGetItemPKsByCriteria.getContentKeywords() == null ? "": "[./p &= '"+wsGetItemPKsByCriteria.getContentKeywords()+"']")+
					(wsGetItemPKsByCriteria.getFromDate().longValue()<=0 ? "" : "[./t >= "+wsGetItemPKsByCriteria.getFromDate().longValue()+"]")+
					(wsGetItemPKsByCriteria.getToDate().longValue()<=0 ? "" : "[./t <= "+wsGetItemPKsByCriteria.getToDate().longValue()+"]")+
					(wsGetItemPKsByCriteria.getKeysKeywords()==null ? "" : "[./i &= '"+wsGetItemPKsByCriteria.getKeysKeywords()+"']")+
					(wsGetItemPKsByCriteria.getConceptName()==null ? "" : "[./n &= '"+wsGetItemPKsByCriteria.getConceptName()+"']")+
					" return <r>{$ii/t}{$ii/n}<ids>{$ii/i}</ids></r>";
			
			DataClusterPOJOPK dcpk =	new DataClusterPOJOPK(wsGetItemPKsByCriteria.getWsDataClusterPK().getPk());
			Collection<String> results = 
				com.amalto.core.util.Util.getItemCtrl2Local().runQuery(
					revisionID,
					dcpk,
					query,
					null
				);
			
	 		WSItemPKsByCriteriaResponseResults[] res = new WSItemPKsByCriteriaResponseResults[results.size()];
	 		int i=0;
	 		for (Iterator iter = results.iterator(); iter.hasNext(); ) {
				String result = (String) iter.next();
	 			result = result.replaceAll("\\s*__h", "").replaceAll("h__\\s*", "");
	 			Element r = Util.parse(result).getDocumentElement();
	 			long t = new Long(Util.getFirstTextNode(r, "t")).longValue();
	 			String conceptName = Util.getFirstTextNode(r, "n");
	 			String[] ids = Util.getTextNodes(r, "ids/i");
	 			res[i++] = new WSItemPKsByCriteriaResponseResults(
	 					t,
	 					new WSItemPK(
	 							wsGetItemPKsByCriteria.getWsDataClusterPK(),
	 							conceptName,
	 							ids
	 					)
	 			);
			}
 			return new WSItemPKsByCriteriaResponse(res);

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSItem getItem(WSGetItem wsGetItem) throws RemoteException {
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("getItem() "+wsGetItem.getWsItemPK().getConceptName()+"    "+Util.joinStrings(wsGetItem.getWsItemPK().getIds(), "."));
		try {
			ItemPOJO vo = 
				com.amalto.core.util.Util.getItemCtrl2Local().getItem(
						new ItemPOJOPK(
								new DataClusterPOJOPK(wsGetItem.getWsItemPK().getWsDataClusterPK().getPk()),
								wsGetItem.getWsItemPK().getConceptName(),
								wsGetItem.getWsItemPK().getIds()
						)
				);
			return new WSItem(
					wsGetItem.getWsItemPK().getWsDataClusterPK(),
					wsGetItem.getWsItemPK().getConceptName(),
					wsGetItem.getWsItemPK().getIds(),
					vo.getInsertionTime(),
					vo.getProjectionAsString()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}	
	
	public WSBoolean existsItem(WSExistsItem wsExistsItem) throws RemoteException {
		try {
			return new WSBoolean(
					(com.amalto.core.util.Util.getItemCtrl2Local().existsItem(
						new ItemPOJOPK(
								new DataClusterPOJOPK(wsExistsItem.getWsItemPK().getWsDataClusterPK().getPk()),
								wsExistsItem.getWsItemPK().getConceptName(),
								wsExistsItem.getWsItemPK().getIds()
						)
				) != null)
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}	
	
	public WSStringArray quickSearch(WSQuickSearch wsQuickSearch) throws RemoteException {
		try {
			Collection c = com.amalto.core.util.Util.getItemCtrl2Local().quickSearch(
				new DataClusterPOJOPK(wsQuickSearch.getWsDataClusterPK().getPk()),
				new ViewPOJOPK(wsQuickSearch.getWsViewPK().getPk()),
				wsQuickSearch.getSearchedValue(),
				wsQuickSearch.isMatchAllWords(),
				wsQuickSearch.getSpellTreshold(),
				wsQuickSearch.getOrderBy(),
				wsQuickSearch.getDirection(),
				wsQuickSearch.getMaxItems(),
				wsQuickSearch.getSkip()
			);
			if (c==null) return null;
			return new WSStringArray((String[])c.toArray(new String[c.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
		
	public WSString getBusinessConceptValue(
			WSGetBusinessConceptValue wsGetBusinessConceptValue)
			throws RemoteException {
		try {
			ItemPOJO iv = com.amalto.core.util.Util.getItemCtrl2Local().getItem(
					new ItemPOJOPK(
							new DataClusterPOJOPK(wsGetBusinessConceptValue.getWsDataClusterPK().getPk()),
							wsGetBusinessConceptValue.getWsBusinessConceptPK().getConceptName(),
							wsGetBusinessConceptValue.getWsBusinessConceptPK().getIds()
							)
			);
			return new WSString(itemAsString(iv));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	public WSStringArray getFullPathValues(WSGetFullPathValues wsGetFullPathValues) throws RemoteException {
		try {
			
			Collection res = Util.getItemCtrl2Local().getFullPathValues(
				new DataClusterPOJOPK(wsGetFullPathValues.getWsDataClusterPK().getPk()),
				wsGetFullPathValues.getFullPath(),
				WS2VO(wsGetFullPathValues.getWhereItem()),
				wsGetFullPathValues.getSpellThreshold(),
				wsGetFullPathValues.getOrderBy(),
				wsGetFullPathValues.getDirection()
			);

        	if (res==null) return null;
        	
            return new WSStringArray((String[]) res.toArray(new String[res.size()]));
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
    
    private String itemAsString(ItemPOJO iv) throws Exception{
    	
    	
        String item =
            "<businessconcept>" +
            "	<cluster>"+iv.getDataClusterPOJOPK().getUniqueId()+"</cluster>";
        	String[] ids = iv.getItemIds();
        	for (int i = 0; i < ids.length; i++) {
        		item+="	<id>"+ids[i]+"</id>";
			}
            item+=
            "	<lastmodifiedtime>"+iv.getInsertionTime()+"</lastmodifiedtime>";
            item+=        
            "	<projection>"+iv.getProjection()+"</projection>" ;
            item+=
            "</businessconcept>";
            
        return item;
    }

    
    
 
    
    /***************************************************************************
	 *Put Item
	 * **************************************************************************/

	public WSItemPK putItem(WSPutItem wsPutItem) throws RemoteException {
		try {
			String projection = wsPutItem.getXmlString();
			Element root = Util.parse(projection).getDocumentElement();
			
			String concept = root.getLocalName();

			DataModelPOJO dataModel = com.amalto.core.util.Util.getDataModelCtrlLocal().getDataModel(
					new DataModelPOJOPK(wsPutItem.getWsDataModelPK().getPk())
			);
            XSDKey conceptKey = com.amalto.core.util.Util.getBusinessConceptKey(
            		Util.parse(dataModel.getSchema()),
					concept
			);
    		
			//get key values
			String[] itemKeyValues = com.amalto.core.util.Util.getKeyValuesFromItem(
       			root,
   				conceptKey
			);
			
			DataClusterPOJOPK dcpk = new DataClusterPOJOPK(wsPutItem.getWsDataClusterPK().getPk());
			
			ItemPOJOPK itemPOJOPK =  
				com.amalto.core.util.Util.getItemCtrl2Local().putItem(
						new ItemPOJO(
								dcpk,
								concept,
								itemKeyValues,
								System.currentTimeMillis(),
								projection
						),
						dataModel
				);
			if (itemPOJOPK==null) return null;
			
			//update vocabulary
			com.amalto.core.util.Util.getDataClusterCtrlLocal().addToVocabulary(dcpk, projection);
			
			return new WSItemPK(
					new WSDataClusterPK(itemPOJOPK.getDataClusterPOJOPK().getUniqueId()),
					itemPOJOPK.getConceptName(),
					itemPOJOPK.getIds()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}	
	
	private WSItemPK POJO2WS(ItemPOJOPK itemPK) throws Exception{
		return new WSItemPK(
				new WSDataClusterPK(itemPK.getDataClusterPOJOPK().getUniqueId()),
				itemPK.getConceptName(),
				itemPK.getIds()
		);
	}
	
	private ItemPOJOPK WS2POJO(WSItemPK wsItemPK) throws Exception{
		return new ItemPOJOPK(
				new DataClusterPOJOPK(wsItemPK.getWsDataClusterPK().getPk()),
				wsItemPK.getConceptName(),
				wsItemPK.getIds()
		);
	}
    
	/***************************************************************************
	 *Extract Items
	 * **************************************************************************/
	public WSPipeline extractUsingTransformer(WSExtractUsingTransformer wsExtractUsingTransformer) throws RemoteException {
		try {
			com.amalto.core.util.TransformerPluginContext context = com.amalto.core.util.Util.getItemCtrl2Local().extractUsingTransformer(
					new ItemPOJOPK(
							new DataClusterPOJOPK(wsExtractUsingTransformer.getWsItemPK().getWsDataClusterPK().getPk()),
							wsExtractUsingTransformer.getWsItemPK().getConceptName(),
							wsExtractUsingTransformer.getWsItemPK().getIds()
					),
					new TransformerPOJOPK(wsExtractUsingTransformer.getWsTransformerPK().getPk())
			);
			HashMap<String, com.amalto.core.util.TypedContent> pipeline = (HashMap<String, com.amalto.core.util.TypedContent>)context.get(TransformerCtrlBean.CTX_PIPELINE);
			return POJO2WSOLD(pipeline);				
		} catch (com.amalto.core.util.XtentisException e) {
			e.printStackTrace();
			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	public WSPipeline extractUsingTransformerThruView(WSExtractUsingTransformerThruView wsExtractUsingTransformerThruView) throws RemoteException {
		try {
			TransformerContext context = com.amalto.core.util.Util.getItemCtrl2Local().extractUsingTransformerThroughView(
				new DataClusterPOJOPK(wsExtractUsingTransformerThruView.getWsDataClusterPK().getPk()),
				new TransformerV2POJOPK(wsExtractUsingTransformerThruView.getWsTransformerPK().getPk()),
				new ViewPOJOPK(wsExtractUsingTransformerThruView.getWsViewPK().getPk()),
				WS2VO(wsExtractUsingTransformerThruView.getWhereItem()),
				wsExtractUsingTransformerThruView.getSpellTreshold(),
				wsExtractUsingTransformerThruView.getOrderBy(),
				wsExtractUsingTransformerThruView.getDirection(),
				wsExtractUsingTransformerThruView.getSkip(),
				wsExtractUsingTransformerThruView.getMaxItems()
			);
			HashMap<String, com.amalto.core.util.TypedContent> pipeline = (HashMap<String, com.amalto.core.util.TypedContent>)context.get(TransformerCtrlBean.CTX_PIPELINE);
			return POJO2WSOLD(pipeline);		
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	


	
	private WSPipeline POJO2WSOLD(HashMap<String,com.amalto.core.util.TypedContent> pipeline) throws Exception{
		ArrayList<WSPipelineTypedContentEntry> entries = new ArrayList<WSPipelineTypedContentEntry>();
		Set keys = pipeline.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String output = (String) iter.next();
			com.amalto.core.util.TypedContent content = pipeline.get(output);
			byte[] bytes = content.getBytes();
			if (bytes == null) {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int c;
				while ((c=content.getStream().read())!=-1) bos.write(c);
				bytes = bos.toByteArray();
			}
			WSExtractedContent wsContent = new WSExtractedContent(
					new WSByteArray(bytes),
					content.getContentType()
			);
			WSPipelineTypedContentEntry wsEntry = new WSPipelineTypedContentEntry(
					TransformerV2CtrlBean.DEFAULT_VARIABLE.equals(output) ? "" : output,
					wsContent
			);
			entries.add(wsEntry);
		}
		return new WSPipeline(entries.toArray(new WSPipelineTypedContentEntry[entries.size()]));
	}
	
	
	/***************************************************************************
	 * Delete Items
	 * **************************************************************************/
	public WSItemPK deleteItem(WSDeleteItem wsDeleteItem)
	throws RemoteException {
		try {
			ItemPOJOPK itemPK = new ItemPOJOPK(
					new DataClusterPOJOPK(wsDeleteItem.getWsItemPK().getWsDataClusterPK().getPk()),
					wsDeleteItem.getWsItemPK().getConceptName(),
					wsDeleteItem.getWsItemPK().getIds()
					);
			ItemPOJOPK ipk = com.amalto.core.util.Util.getItemCtrl2Local().deleteItem(itemPK);
			return ipk == null ? null : wsDeleteItem.getWsItemPK();

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}    
    
	public WSInt deleteItems(WSDeleteItems wsDeleteItems)
	throws RemoteException {
		try {
			int numItems = 
				com.amalto.core.util.Util.getItemCtrl2Local().deleteItems(
						new DataClusterPOJOPK(wsDeleteItems.getWsDataClusterPK().getPk()),
						wsDeleteItems.getConceptName(),
						WS2VO(wsDeleteItems.getWsWhereItem()),
						wsDeleteItems.getSpellTreshold()
				);
				return new WSInt(numItems);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
//		} catch (com.amalto.webapp.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));				
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}    
	
	
	/***************************************************************************
	 * DirectQuery
	 * **************************************************************************/
	
	public WSStringArray runQuery(WSRunQuery wsRunQuery) throws RemoteException {
		try {
			DataClusterPOJOPK dcpk = 
				(wsRunQuery.getWsDataClusterPK()== null) ?
						null:
						new DataClusterPOJOPK(wsRunQuery.getWsDataClusterPK().getPk());
			Collection<String> result = 
				com.amalto.core.util.Util.getItemCtrl2Local().runQuery(
					wsRunQuery.getRevisionID(),
					dcpk,
					wsRunQuery.getQuery(),
					wsRunQuery.getParameters()
				);
			return new WSStringArray(result.toArray(new String[result.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));				
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	};
	

	
	
	/***************************************************************************
	 * RoutingRule
	 * **************************************************************************/
	public WSRoutingRule getRoutingRule(WSGetRoutingRule wsRoutingRuleGet)
	throws RemoteException {
		try {
		    return VO2WS( 
		    		com.amalto.core.util.Util.getRoutingRuleCtrlLocal().getRoutingRule(
							new RoutingRulePOJOPK(wsRoutingRuleGet.getWsRoutingRulePK().getPk())
					)
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
//		} catch (com.amalto.webapp.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));		    
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
   
	  public WSBoolean existsRoutingRule(WSExistsRoutingRule wsExistsRoutingRule)
	   throws RemoteException {
			try {
			    return new WSBoolean( 
			    		com.amalto.core.util.Util.getRoutingRuleCtrlLocal().existsRoutingRule(
								new RoutingRulePOJOPK(wsExistsRoutingRule.getWsRoutingRulePK().getPk())
						) != null
				);
			} catch (com.amalto.core.util.XtentisException e) {
				throw(new RemoteException(e.getLocalizedMessage()));		    
			} catch (Exception e) {
				throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
			}
	   }	    

	    
    public WSRoutingRulePKArray getRoutingRulePKs(WSGetRoutingRulePKs regexp)
    throws RemoteException {
		try {
		    Collection<RoutingRulePOJOPK> pks = com.amalto.core.util.Util.getRoutingRuleCtrlLocal().getRoutingRulePKs(regexp.getRegex());
		    ArrayList<WSRoutingRulePK> list = new ArrayList<WSRoutingRulePK>();
		    for (Iterator iter = pks.iterator(); iter.hasNext(); ) {
				RoutingRulePOJOPK pk = (RoutingRulePOJOPK) iter.next();
				list.add(new WSRoutingRulePK(pk.getUniqueId()));
			}
			return new WSRoutingRulePKArray(list.toArray(new WSRoutingRulePK[list.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }
		    
    public WSRoutingRulePK deleteRoutingRule(WSDeleteRoutingRule wsDeleteRoutingRule)
    throws RemoteException {
		try {
		    return new WSRoutingRulePK(
		    		com.amalto.core.util.Util.getRoutingRuleCtrlLocal().removeRoutingRule(
							new RoutingRulePOJOPK(wsDeleteRoutingRule.getWsRoutingRulePK().getPk())
					).getUniqueId()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));		    
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }	
    
    public WSRoutingRulePK putRoutingRule(WSPutRoutingRule wsRoutingRule)
    throws RemoteException {
		try {
		    return new WSRoutingRulePK(
		    		com.amalto.core.util.Util.getRoutingRuleCtrlLocal().putRoutingRule(
							WS2VO(wsRoutingRule.getWsRoutingRule())
					).getUniqueId()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
//		} catch (com.amalto.webapp.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));		    
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }

    private WSRoutingRule VO2WS(RoutingRulePOJO vo) throws Exception{
	    WSRoutingRule s = new WSRoutingRule();
		s.setDescription(vo.getDescription());
		s.setName(vo.getName());
		s.setConcept(vo.getConcept());
		s.setParameters(vo.getParameters());
		s.setServiceJNDI(vo.getServiceJNDI());
		s.setSynchronous(vo.isSynchronous());

		WSRoutingRuleExpression[] routingExpressions = null;
		Collection c = vo.getRoutingExpressions();
		if (c!=null) {		
			routingExpressions = new WSRoutingRuleExpression[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				RoutingRuleExpressionPOJO rre = (RoutingRuleExpressionPOJO) iter.next();
				routingExpressions[i++] = VO2WS(rre);
			}
		}
		s.setWsRoutingRuleExpressions(routingExpressions);

		return s;
	}
	
    
	private RoutingRulePOJO WS2VO(WSRoutingRule ws) throws Exception{
		RoutingRulePOJO vo = new RoutingRulePOJO();
		vo.setName(ws.getName());
		vo.setDescription(ws.getDescription());
		vo.setConcept(ws.getConcept());
		vo.setParameters(ws.getParameters());
		vo.setServiceJNDI(ws.getServiceJNDI());
		vo.setSynchronous(ws.isSynchronous());
		
		ArrayList<RoutingRuleExpressionPOJO> l = new ArrayList<RoutingRuleExpressionPOJO>();
	    WSRoutingRuleExpression[] rre = ws.getWsRoutingRuleExpressions();
	    if (rre!=null) {
		    for (int i = 0; i < rre.length; i++) {
		    	l.add(WS2VO(rre[i]));
			}
	    }
	    vo.setRoutingExpressions(l);
	    
		return vo;
	}	

	
    private WSRoutingRuleExpression VO2WS(RoutingRuleExpressionPOJO vo) throws Exception{
    	WSRoutingRuleExpression ws = new WSRoutingRuleExpression();
    	
    	ws.setName(vo.getName());
    	ws.setXpath(vo.getXpath());
    	ws.setValue(vo.getValue());
    	switch (vo.getOperator()) {
    		case RoutingRuleExpressionPOJO.CONTAINS:
    			ws.setWsOperator(WSRoutingRuleOperator.CONTAINS);
    			break;
    		case RoutingRuleExpressionPOJO.EQUALS:
    			ws.setWsOperator(WSRoutingRuleOperator.EQUALS);
    			break;
    		case RoutingRuleExpressionPOJO.GREATER_THAN:
    			ws.setWsOperator(WSRoutingRuleOperator.GREATER_THAN);
    			break;
    		case RoutingRuleExpressionPOJO.GREATER_THAN_OR_EQUAL:
    			ws.setWsOperator(WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL);
    			break;
    		case RoutingRuleExpressionPOJO.IS_NOT_NULL:
    			ws.setWsOperator(WSRoutingRuleOperator.IS_NOT_NULL);
    			break;
    		case RoutingRuleExpressionPOJO.IS_NULL:
    			ws.setWsOperator(WSRoutingRuleOperator.IS_NULL);
    			break;
    		case RoutingRuleExpressionPOJO.LOWER_THAN:
    			ws.setWsOperator(WSRoutingRuleOperator.LOWER_THAN);
    			break;
    		case RoutingRuleExpressionPOJO.LOWER_THAN_OR_EQUAL:
    			ws.setWsOperator(WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL);
    			break;
    		case RoutingRuleExpressionPOJO.MATCHES:
    			ws.setWsOperator(WSRoutingRuleOperator.MATCHES);
    			break;
    		case RoutingRuleExpressionPOJO.NOT_EQUALS:
    			ws.setWsOperator(WSRoutingRuleOperator.NOT_EQUALS);
    			break;
    		case RoutingRuleExpressionPOJO.STARTSWITH:
    			ws.setWsOperator(WSRoutingRuleOperator.STARTSWITH);
    			break;
    	}
    	return ws;
    }
	
    
    private RoutingRuleExpressionPOJO WS2VO(WSRoutingRuleExpression ws) throws Exception{
    	
    	if (ws==null) return null;
    	
    	int operator = 1;
    	if (ws.getWsOperator().equals(WSRoutingRuleOperator.CONTAINS))
    		operator = RoutingRuleExpressionPOJO.CONTAINS;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.EQUALS))
    		operator = RoutingRuleExpressionPOJO.EQUALS;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN))
    		operator = RoutingRuleExpressionPOJO.GREATER_THAN;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL))
    		operator = RoutingRuleExpressionPOJO.GREATER_THAN_OR_EQUAL;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.IS_NOT_NULL))
    		operator = RoutingRuleExpressionPOJO.IS_NOT_NULL;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.IS_NULL))
    		operator = RoutingRuleExpressionPOJO.IS_NULL;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN))
    		operator = RoutingRuleExpressionPOJO.LOWER_THAN;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL))
    		operator = RoutingRuleExpressionPOJO.LOWER_THAN_OR_EQUAL;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.MATCHES))
    		operator = RoutingRuleExpressionPOJO.MATCHES;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.NOT_EQUALS))
    		operator = RoutingRuleExpressionPOJO.NOT_EQUALS;
    	else if (ws.getWsOperator().equals(WSRoutingRuleOperator.STARTSWITH))
    		operator = RoutingRuleExpressionPOJO.STARTSWITH;
    	
    	return new RoutingRuleExpressionPOJO(
    			ws.getName(),
    			ws.getXpath(),
    			operator,
    			ws.getValue()
    	);
    }
    

	
	/***************************************************************************
	 * SERVICES
	 * **************************************************************************/
	
	public WSString getServiceConfiguration(WSServiceGetConfiguration wsGetConfiguration) throws RemoteException {
		try {
			Object service= 
				com.amalto.core.util.Util.retrieveComponent(
					null, 
					wsGetConfiguration.getJndiName()
				);
			
			String configuration = (String)
				com.amalto.core.util.Util.getMethod(service, "getConfiguration").invoke(
					service,
					new Object[] {
							wsGetConfiguration.getOptionalParameter()
					}
				);
			return new WSString(configuration);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	public WSString putServiceConfiguration(WSServicePutConfiguration wsPutConfiguration) throws RemoteException {
		try {
			Object service= 
				com.amalto.core.util.Util.retrieveComponent(
					null, 
					wsPutConfiguration.getJndiName()
				);
			
			com.amalto.core.util.Util.getMethod(service, "putConfiguration").invoke(
				service,
				new Object[] {
						wsPutConfiguration.getConfiguration()
				}
			);
			return new WSString(wsPutConfiguration.getConfiguration());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	public WSString serviceAction(WSServiceAction wsServiceAction) throws RemoteException {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("serviceAction() "+wsServiceAction.getJndiName());
		try {
			Object service= 
				com.amalto.core.util.Util.retrieveComponent(
					null, 
					wsServiceAction.getJndiName()
				);
			String result = "";
			
			if (WSServiceActionCode.EXECUTE.equals(wsServiceAction.getWsAction())) {
				result = (String)
					com.amalto.core.util.Util.getMethod(service, wsServiceAction.getMethodName()).invoke(
							service,
							new Object[] {wsServiceAction.getMethodParameters()}
						);				
			} else {
				if (WSServiceActionCode.START.equals(wsServiceAction.getWsAction())) {
					com.amalto.core.util.Util.getMethod(service, "start").invoke(
							service,
							new Object[] {}
						);
				} else if (WSServiceActionCode.STOP.equals(wsServiceAction.getWsAction())) {
					com.amalto.core.util.Util.getMethod(service, "stop").invoke(
							service,
							new Object[] {}
						);				
				}
				result = (String)
					com.amalto.core.util.Util.getMethod(service, "getStatus").invoke(
							service,
							new Object[] {}
						);
			}
			return new WSString(result);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	public WSServicesList getServicesList(WSGetServicesList wsGetServicesList) throws RemoteException {
		try {
			ArrayList<WSServicesListItem> wsList = new ArrayList<WSServicesListItem>();
			InitialContext ctx = new InitialContext();
			NamingEnumeration<NameClassPair> list = ctx.list("amalto/local/service");
			while (list.hasMore()) {
			    NameClassPair nc = list.next();
			    WSServicesListItem item =new WSServicesListItem();
			    item.setJndiName(nc.getName());
			    wsList.add(item);
			}
			return new WSServicesList(wsList.toArray(new WSServicesListItem[wsList.size()]));
//		} catch (com.amalto.core.util.XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}



	/***************************************************************************
	 * Stored Procedures
	 * **************************************************************************/

    public WSStoredProcedurePK deleteStoredProcedure(WSDeleteStoredProcedure wsStoredProcedureDelete) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			StoredProcedurePOJOPK pk =
				ctrl.removeStoredProcedure(
					new StoredProcedurePOJOPK(
							wsStoredProcedureDelete.getWsStoredProcedurePK().getPk()
					)
				);
			return new WSStoredProcedurePK(pk.getIds()[0]);		
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    
	public WSStringArray executeStoredProcedure(WSExecuteStoredProcedure wsExecuteStoredProcedure) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			Collection c =
				ctrl.execute(
					new StoredProcedurePOJOPK(
						wsExecuteStoredProcedure.getWsStoredProcedurePK().getPk()
    				),
    				wsExecuteStoredProcedure.getRevisionID(),
    				new DataClusterPOJOPK(
    						wsExecuteStoredProcedure.getWsDataClusterPK().getPk()
    				),
    				wsExecuteStoredProcedure.getParameters()
    			);
			if (c==null) return null;
			String[] xmls  = new String[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				xmls[i++] = (String) iter.next();
			}
			return new WSStringArray(xmls);		
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSStoredProcedure getStoredProcedure(WSGetStoredProcedure wsGetStoredProcedure) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			StoredProcedurePOJO pojo =
				ctrl.getStoredProcedure(
					new StoredProcedurePOJOPK(
							wsGetStoredProcedure.getWsStoredProcedurePK().getPk()
					)
				);
			return POJO2WS(pojo);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	public WSBoolean existsStoredProcedure(WSExistsStoredProcedure wsExistsStoredProcedure) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			StoredProcedurePOJO pojo =
				ctrl.existsStoredProcedure(
					new StoredProcedurePOJOPK(
							wsExistsStoredProcedure.getWsStoredProcedurePK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSStoredProcedurePKArray getStoredProcedurePKs(WSRegexStoredProcedure regex) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			Collection c =
				ctrl.getStoredProcedurePKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSStoredProcedurePK[] pks = new WSStoredProcedurePK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSStoredProcedurePK(
						((StoredProcedurePOJOPK) iter.next()).getIds()[0]
				);
			}
			return new WSStoredProcedurePKArray(pks);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSStoredProcedurePK putStoredProcedure(WSPutStoredProcedure wsStoredProcedure) throws RemoteException {
		try {
			StoredProcedureCtrlLocal ctrl = com.amalto.core.util.Util.getStoredProcedureCtrlLocal();
			StoredProcedurePOJOPK pk =
				ctrl.putStoredProcedure(
					WS2POJO(wsStoredProcedure.getWsStoredProcedure())
				);
			return new WSStoredProcedurePK(pk.getIds()[0]);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    
	private WSStoredProcedure POJO2WS(StoredProcedurePOJO storedProcedurePOJO) throws Exception{
		WSStoredProcedure ws = new WSStoredProcedure();
		ws.setName(storedProcedurePOJO.getName());
		ws.setDescription(storedProcedurePOJO.getDescription());
		ws.setProcedure(storedProcedurePOJO.getProcedure());
		return ws;
	}

	private StoredProcedurePOJO WS2POJO(WSStoredProcedure wsStoredProcedure) throws Exception{
		StoredProcedurePOJO pojo = new StoredProcedurePOJO();
		pojo.setName(wsStoredProcedure.getName());
		pojo.setDescription(wsStoredProcedure.getDescription());
		pojo.setProcedure(wsStoredProcedure.getProcedure());
		return pojo;
	}
	   
	
	/***************************************************************************
	 * Ping - test that we can authenticate by getting a server response
	 * **************************************************************************/
	
	public WSString ping(WSPing wsPing) throws RemoteException {
		try {
			return new WSString(wsPing.getEcho());
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}    
	
    	

	/***************************************************************************
	 * Xtentis JCA Connector support
	 * **************************************************************************/

	private transient ConnectionFactory cxFactory = null;
	
	public WSConnectorInteractionResponse connectorInteraction(WSConnectorInteraction wsConnectorInteraction) throws RemoteException {
		// This one does not call an EJB
		
		WSConnectorInteractionResponse response = new WSConnectorInteractionResponse();
		Connection conx = null;
		try {

			String JNDIName = wsConnectorInteraction.getJNDIName();
			conx = getConnection(JNDIName);
			
			Interaction interaction = conx.createInteraction();
	    	InteractionSpecImpl interactionSpec = new InteractionSpecImpl();
	    	
			MappedRecord recordIn = new RecordFactoryImpl().createMappedRecord(RecordFactoryImpl.RECORD_IN);
			
			WSConnectorFunction cf = wsConnectorInteraction.getFunction();
			if ((WSConnectorFunction.GET_STATUS).equals(cf)) {
				interactionSpec.setFunctionName(InteractionSpecImpl.FUNCTION_GET_STATUS);
			} else 	if ((WSConnectorFunction.PULL).equals(cf)) {
				interactionSpec.setFunctionName(InteractionSpecImpl.FUNCTION_PULL);
			} else 	if ((WSConnectorFunction.PUSH).equals(cf)) {
				interactionSpec.setFunctionName(InteractionSpecImpl.FUNCTION_PUSH);
			} else 	if ((WSConnectorFunction.START).equals(cf)) {
				interactionSpec.setFunctionName(InteractionSpecImpl.FUNCTION_START);
			} else 	if ((WSConnectorFunction.STOP).equals(cf)) {
				interactionSpec.setFunctionName(InteractionSpecImpl.FUNCTION_STOP);
			}
			
			recordIn.put(RecordFactoryImpl.PARAMS_HASHMAP_IN, getMapFromKeyValues(wsConnectorInteraction.getParameters()));
						
			MappedRecord recordOut = (MappedRecord)interaction.execute(interactionSpec, recordIn);

			String code = (String)recordOut.get(RecordFactoryImpl.STATUS_CODE_OUT);
			HashMap map = (HashMap)recordOut.get(RecordFactoryImpl.PARAMS_HASHMAP_OUT);
			
			if ("OK".equals(code)) {
				response.setCode(WSConnectorResponseCode.OK);
			} else if ("STOPPED".equals(code)) {
				response.setCode(WSConnectorResponseCode.STOPPED);
			} else if ("ERROR".equals(code)) {
				response.setCode(WSConnectorResponseCode.ERROR);
			} else {
				throw new RemoteException("Unknown code: "+code);
			}
			response.setParameters(getKeyValuesFromMap(map));
			
		} catch (ResourceException e) {
			throw new RemoteException(e.getLocalizedMessage());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		} finally {
			try {conx.close();} catch (Exception cx) {
				org.apache.log4j.Logger.getLogger(this.getClass()).debug("connectorInteraction() Connection close exception: "+cx.getLocalizedMessage());
			}
		}
		return response;		
		
	}

    private Connection getConnection(String JNDIName) throws RemoteException {
    	try {
    		if (cxFactory == null)
    			cxFactory = (ConnectionFactory)(new InitialContext()).lookup(JNDIName);
	    	return cxFactory.getConnection();
    	} catch (Exception e) {
    		throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
    	}
    }
    
	private HashMap getMapFromKeyValues(WSBase64KeyValue[] params) throws RemoteException{
		try {
	    	HashMap<String,Object> map = new HashMap<String,Object>();
	    	if (params != null) {
				for (int i = 0; i < params.length; i++) {
					if (params[i]!=null) {
						String key = params[i].getKey();
						byte[] bytes = (new BASE64Decoder()).decodeBuffer(params[i].getBase64StringValue());
						if (bytes!=null) {
							ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
							ObjectInputStream ois = new ObjectInputStream(bais);
							map.put(key, ois.readObject());
						} else {
							map.put(key, null);
						}
					}
				}
	    	}
			return map;
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}    	
    }
    
    private WSBase64KeyValue[] getKeyValuesFromMap(HashMap params) throws RemoteException{    	
    	try {
    		if (params==null) return null;
    		WSBase64KeyValue[] keyValues = new WSBase64KeyValue[params.size()];
    		Set keys = params.keySet();
    		int i=0;
    		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				Object value = params.get(key);
				if (value!=null) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(baos);
					oos.writeObject(value);
					String base64Value = Base64Encoder.encode(baos.toByteArray());
					keyValues[i] = new WSBase64KeyValue();
					keyValues[i].setKey(key);
					keyValues[i].setBase64StringValue(base64Value);
					i++;
				}
			}
			return keyValues;
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}    	
    }

	
	
	/***************************************************************************
	 * Transformer
	 * **************************************************************************/

    public WSTransformerPK deleteTransformer(WSDeleteTransformer wsTransformerDelete) throws RemoteException {
		try {
			TransformerCtrlLocal ctrl = com.amalto.core.util.Util.getTransformerCtrlLocal();
			return
				new WSTransformerPK(
					ctrl.removeTransformer(
						new TransformerPOJOPK(
								wsTransformerDelete.getWsTransformerPK().getPk()
						)
					).getUniqueId()
				);
	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    

	public WSTransformer getTransformer(WSGetTransformer wsGetTransformer) throws RemoteException {
		try {
			TransformerCtrlLocal ctrl = com.amalto.core.util.Util.getTransformerCtrlLocal();
			TransformerPOJO pojo =
				ctrl.getTransformer(
					new TransformerPOJOPK(
							wsGetTransformer.getWsTransformerPK().getPk()
					)
				);
			return POJO2WS(pojo);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSBoolean existsTransformer(WSExistsTransformer wsExistsTransformer) throws RemoteException {
		try {
			TransformerCtrlLocal ctrl = com.amalto.core.util.Util.getTransformerCtrlLocal();
			TransformerPOJO pojo =
				ctrl.existsTransformer(
					new TransformerPOJOPK(
							wsExistsTransformer.getWsTransformerPK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	public WSTransformerPKArray getTransformerPKs(WSGetTransformerPKs regex) throws RemoteException {
		try {
			TransformerCtrlLocal ctrl = com.amalto.core.util.Util.getTransformerCtrlLocal();
			Collection c =
				ctrl.getTransformerPKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSTransformerPK[] pks = new WSTransformerPK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSTransformerPK(
						((TransformerPOJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSTransformerPKArray(pks);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSTransformerPK putTransformer(WSPutTransformer wsTransformer) throws RemoteException {
		try {
			TransformerCtrlLocal ctrl = com.amalto.core.util.Util.getTransformerCtrlLocal();
			TransformerPOJOPK pk =
				ctrl.putTransformer(
					WS2POJO(wsTransformer.getWsTransformer())
				);
			return new WSTransformerPK(pk.getUniqueId());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    
	
	
	private WSTransformer POJO2WS(TransformerPOJO transformerPOJO) throws Exception{
		WSTransformer ws = new WSTransformer();
		ws.setName(transformerPOJO.getName());
		ws.setDescription(transformerPOJO.getDescription());
		ArrayList<WSTransformerPluginSpec> wsSpecs = new ArrayList<WSTransformerPluginSpec>();
		ArrayList< TransformerPluginSpec> pluginSpecs = transformerPOJO.getPluginSpecs();
		if (pluginSpecs!=null) {
			for (Iterator iter = pluginSpecs.iterator(); iter.hasNext(); ) {
				TransformerPluginSpec pluginSpec = (TransformerPluginSpec) iter.next();
				WSTransformerPluginSpec wsSpec = new WSTransformerPluginSpec(
						pluginSpec.getPluginJNDI(),
						pluginSpec.getDescription(),
						pluginSpec.getInput(),
						pluginSpec.getOutput(),
						pluginSpec.getParameters()
				);
				wsSpecs.add(wsSpec);
			}
		}
		ws.setPluginSpecs(wsSpecs.toArray(new WSTransformerPluginSpec[wsSpecs.size()]));
		return ws;
	}

	private TransformerPOJO WS2POJO(WSTransformer wsTransformer) throws Exception{
		TransformerPOJO pojo = new TransformerPOJO();
		pojo.setName(wsTransformer.getName());
		pojo.setDescription(wsTransformer.getDescription());
		ArrayList<TransformerPluginSpec> specs = new ArrayList<TransformerPluginSpec>();
		WSTransformerPluginSpec[] wsSpecs = wsTransformer.getPluginSpecs();
		if (wsSpecs!=null) {
			for (int i = 0; i < wsSpecs.length; i++) {
				TransformerPluginSpec spec = new TransformerPluginSpec(
						wsSpecs[i].getPluginJNDI(),
						wsSpecs[i].getDescription(),
						wsSpecs[i].getInput(),
						wsSpecs[i].getOutput(),
						wsSpecs[i].getParameters()
				);
				specs.add(spec);		
			}
		}
		pojo.setPluginSpecs(specs);

		return pojo;
	}
	

	public WSPipeline processBytesUsingTransformer(WSProcessBytesUsingTransformer wsProcessBytesUsingTransformer) throws RemoteException {
		try {
			com.amalto.core.util.TransformerPluginContext context = 
				Util.getTransformerCtrlLocal().process(
						new com.amalto.core.util.TypedContent(
								null,
								wsProcessBytesUsingTransformer.getWsBytes().getBytes(),
								wsProcessBytesUsingTransformer.getContentType()
						),
						new TransformerPOJOPK(wsProcessBytesUsingTransformer.getWsTransformerPK().getPk()),
						WS2POJO(wsProcessBytesUsingTransformer.getWsOutputDecisionTable())
				);
			HashMap<String, com.amalto.core.util.TypedContent> pipeline = (HashMap<String, com.amalto.core.util.TypedContent>)context.get(TransformerCtrlBean.CTX_PIPELINE);
			//Add the Item PKs to the pipeline as comma seperated lines
			String pksAsLine = "";
			Collection<ItemPOJOPK> pks = (Collection<ItemPOJOPK>)context.get(TransformerCtrlBean.CTX_PKS);
			for (Iterator iter = pks.iterator(); iter.hasNext(); ) {
				ItemPOJOPK pk = (ItemPOJOPK) iter.next();
				if(!"".equals(pksAsLine)) pksAsLine += "\n";
				pksAsLine += pk.getConceptName()+","+Util.joinStrings(pk.getIds(), ",");
			}
			pipeline.put(
					TransformerCtrlBean.CTX_PKS, 
					new com.amalto.core.util.TypedContent(
							null,
							pksAsLine.getBytes("UTF-8"),
							"text/plain; charset=\"utf-8\""
					)
			);
			//return the pipeline
			return POJO2WSOLD(pipeline);
		} catch (com.amalto.core.util.XtentisException e) {
		throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
		throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}



	public WSBackgroundJobPK processBytesUsingTransformerAsBackgroundJob(WSProcessBytesUsingTransformerAsBackgroundJob wsProcessBytesUsingTransformerAsBackgroundJob) throws RemoteException {
		try {
			return new WSBackgroundJobPK(
					Util.getTransformerCtrlLocal().processBytesAsBackgroundJob(
							wsProcessBytesUsingTransformerAsBackgroundJob.getWsBytes().getBytes(),
							wsProcessBytesUsingTransformerAsBackgroundJob.getContentType(),
							new TransformerPOJOPK(wsProcessBytesUsingTransformerAsBackgroundJob.getWsTransformerPK().getPk()),
							WS2POJO(wsProcessBytesUsingTransformerAsBackgroundJob.getWsOutputDecisionTable())
					).getUniqueId()
				);
		} catch (com.amalto.core.util.XtentisException e) {
		throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
		throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}

	}



	public WSPipeline processFileUsingTransformer(WSProcessFileUsingTransformer wsProcessFileUsingTransformer) throws RemoteException {
		try {
  		//read the entire file into bytes
    		
			com.amalto.core.util.TransformerPluginContext context = 
				Util.getTransformerCtrlLocal().process(
						new com.amalto.core.util.TypedContent(
								new FileInputStream(new File(wsProcessFileUsingTransformer.getFileName())),
								null,
								wsProcessFileUsingTransformer.getContentType()
						),
						new TransformerPOJOPK(wsProcessFileUsingTransformer.getWsTransformerPK().getPk()),
						WS2POJO(wsProcessFileUsingTransformer.getWsOutputDecisionTable())
				);
			HashMap<String, com.amalto.core.util.TypedContent> pipeline = (HashMap<String, com.amalto.core.util.TypedContent>)context.get(TransformerCtrlBean.CTX_PIPELINE);
			//Add the Item PKs to the pipeline as comma seperated lines
			String pksAsLine = "";
			Collection<ItemPOJOPK> pks = (Collection<ItemPOJOPK>)context.get(TransformerCtrlBean.CTX_PIPELINE);
			for (Iterator iter = pks.iterator(); iter.hasNext(); ) {
				ItemPOJOPK pk = (ItemPOJOPK) iter.next();
				if(!"".equals(pksAsLine)) pksAsLine += "\n";
				pksAsLine += pk.getConceptName()+","+Util.joinStrings(pk.getIds(), ",");
			}
			pipeline.put(
					TransformerCtrlBean.CTX_PIPELINE, 
					new com.amalto.core.util.TypedContent(
							null,
							pksAsLine.getBytes("UTF-8"),
							"text/plain; charset=\"utf-8\""
					)
			);
			//return the pipeline
			return POJO2WSOLD(pipeline);
		} catch (com.amalto.core.util.XtentisException e) {
		throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
		throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}

	}


	public WSBackgroundJobPK processFileUsingTransformerAsBackgroundJob(WSProcessFileUsingTransformerAsBackgroundJob wsProcessFileUsingTransformerAsBackgroundJob) throws RemoteException {
		try {
			return new WSBackgroundJobPK(
					Util.getTransformerCtrlLocal().processFileAsBackgroundJob(
							wsProcessFileUsingTransformerAsBackgroundJob.getFileName(),
							wsProcessFileUsingTransformerAsBackgroundJob.getContentType(),
							new TransformerPOJOPK(wsProcessFileUsingTransformerAsBackgroundJob.getWsTransformerPK().getPk()),
							WS2POJO(wsProcessFileUsingTransformerAsBackgroundJob.getWsOutputDecisionTable())
					).getUniqueId()
				);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	
	private HashMap<String, String> WS2POJO(WSOutputDecisionTable table) {
		HashMap<String, String> decisions = new HashMap<String, String>();
		if ((table == null) || (table.getDecisions()==null) || (table.getDecisions().length == 0)) return decisions;
		WSProcessBytesUsingTransformerWsOutputDecisionTableDecisions[] wsDecisions = table.getDecisions();
		for (int i = 0; i < wsDecisions.length; i++) {
			decisions.put(wsDecisions[i].getOutputVariableName(), wsDecisions[i].getDecision());
		}
		return decisions;
	}



	
	/***************************************************************************
	 * TransformerV2
	 * **************************************************************************/
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
    public WSTransformerV2PK deleteTransformerV2(WSDeleteTransformerV2 wsTransformerV2Delete) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			return
				new WSTransformerV2PK(
					ctrl.removeTransformer(
						new TransformerV2POJOPK(
								wsTransformerV2Delete.getWsTransformerV2PK().getPk()
						)
					).getUniqueId()
				);
	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    


	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerV2 getTransformerV2(WSGetTransformerV2 wsGetTransformerV2) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			TransformerV2POJO pojo =
				ctrl.getTransformer(
					new TransformerV2POJOPK(
							wsGetTransformerV2.getWsTransformerV2PK().getPk()
					)
				);
			return POJO2WS(pojo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSBoolean existsTransformerV2(WSExistsTransformerV2 wsExistsTransformerV2) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			TransformerV2POJO pojo =
				ctrl.existsTransformer(
					new TransformerV2POJOPK(
							wsExistsTransformerV2.getWsTransformerV2PK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerV2PKArray getTransformerV2PKs(WSGetTransformerV2PKs regex) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			Collection c =
				ctrl.getTransformerPKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSTransformerV2PK[] pks = new WSTransformerV2PK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSTransformerV2PK(
						((TransformerV2POJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSTransformerV2PKArray(pks);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerV2PK putTransformerV2(WSPutTransformerV2 wsTransformerV2) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			TransformerV2POJOPK pk =
				ctrl.putTransformer(
					WS2POJO(wsTransformerV2.getWsTransformerV2())
				);
			return new WSTransformerV2PK(pk.getUniqueId());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerContext executeTransformerV2(WSExecuteTransformerV2 wsExecuteTransformerV2) throws RemoteException {
		try {
			final String RUNNING = "XtentisWSBean.executeTransformerV2.running";
			TransformerContext context = WS2POJO(wsExecuteTransformerV2.getWsTransformerContext());
			context.put(RUNNING, Boolean.TRUE);
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			ctrl.execute(
					context, 
					WS2POJO(wsExecuteTransformerV2.getWsTypedContent()), 
					new TransformerCallBack() {
						public void contentIsReady(TransformerContext context) throws com.amalto.core.util.XtentisException {
							org.apache.log4j.Logger.getLogger(this.getClass()).debug("XtentisWSBean.executeTransformerV2.contentIsReady() ");
						}
						public void done(TransformerContext context) throws com.amalto.core.util.XtentisException {
							org.apache.log4j.Logger.getLogger(this.getClass()).debug("XtentisWSBean.executeTransformerV2.done() ");
							context.put(RUNNING, Boolean.FALSE);
						}
					}
			);
			while (((Boolean)context.get(RUNNING)).booleanValue()) {
				Thread.sleep(100);
			}
			return POJO2WS(context);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSBackgroundJobPK executeTransformerV2AsJob(WSExecuteTransformerV2AsJob wsExecuteTransformerV2AsJob) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			BackgroundJobPOJOPK bgPK = 
				ctrl.executeAsJob(					
						WS2POJO(wsExecuteTransformerV2AsJob.getWsTransformerContext()),
						new TransformerCallBack() {
							public void contentIsReady(TransformerContext context) throws com.amalto.core.util.XtentisException {
								org.apache.log4j.Logger.getLogger(this.getClass()).debug("XtentisWSBean.executeTransformerV2AsJob.contentIsReady() ");
							}
							public void done(TransformerContext context) throws com.amalto.core.util.XtentisException {
								org.apache.log4j.Logger.getLogger(this.getClass()).debug("XtentisWSBean.executeTransformerV2AsJob.done() ");
							}
						}
				);
			return new WSBackgroundJobPK(bgPK.getUniqueId());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerContext extractThroughTransformerV2(WSExtractThroughTransformerV2 wsExtractThroughTransformerV2) throws RemoteException {
		try {
			TransformerV2CtrlLocal ctrl = Util.getTransformerV2CtrlLocal();
			return POJO2WS(
				ctrl.extractThroughTransformer(
					new TransformerV2POJOPK(wsExtractThroughTransformerV2.getWsTransformerV2PK().getPk()),
					WS2POJO(wsExtractThroughTransformerV2.getWsItemPK())
				)
			);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	
	private WSTransformerContext POJO2WS(TransformerContext context) throws Exception{
		WSTransformerContext wsContext = new WSTransformerContext();
		
		WSTransformerContextPipeline wsPipeline = new WSTransformerContextPipeline();
		ArrayList<WSTransformerContextPipelinePipelineItem> wsList = new ArrayList<WSTransformerContextPipelinePipelineItem>();
		LinkedHashMap<String, TypedContent> pipeline = context.getPipelineClone();
		Set< String> variables = pipeline.keySet();
		for (Iterator iter = variables.iterator(); iter.hasNext(); ) {
			String variable = (String) iter.next();
			WSTransformerContextPipelinePipelineItem wsItem = new WSTransformerContextPipelinePipelineItem();
			wsItem.setVariable(variable);
			wsItem.setWsTypedContent(POJO2WS(pipeline.get(variable)));
			wsList.add(wsItem);
		}
		wsPipeline.setPipelineItem(wsList.toArray(new WSTransformerContextPipelinePipelineItem[wsList.size()]));
		wsContext.setPipeline(wsPipeline);
		
		WSTransformerContextProjectedItemPKs wsProjectedItemPKs = new WSTransformerContextProjectedItemPKs();
		ArrayList<WSItemPK> wsPKList = new ArrayList<WSItemPK>();
		SortedSet<ItemPOJOPK>projectedPKs = context.getProjectedPKs();
		for (Iterator iter = projectedPKs.iterator(); iter.hasNext(); ) {
			ItemPOJOPK pk = (ItemPOJOPK) iter.next();
			wsPKList.add(POJO2WS(pk));
		}
		wsProjectedItemPKs.setWsItemPOJOPK(wsPKList.toArray(new WSItemPK[wsPKList.size()]));
		wsContext.setProjectedItemPKs(wsProjectedItemPKs);
		
		return wsContext;
	}
	
	private TransformerContext WS2POJO(WSTransformerContext wsContext) throws Exception{
		TransformerContext context = new TransformerContext(new TransformerV2POJOPK(wsContext.getWsTransformerPK().getPk()));
		
		for (int i = 0; i < wsContext.getPipeline().getPipelineItem().length; i++) {
			WSTransformerContextPipelinePipelineItem wsItem = wsContext.getPipeline().getPipelineItem()[i];
			context.putInPipeline(wsItem.getVariable(), WS2POJO(wsItem.getWsTypedContent()));
		}
		
		for (int i = 0; i < wsContext.getProjectedItemPKs().getWsItemPOJOPK().length; i++) {
			WSItemPK wsPK = wsContext.getProjectedItemPKs().getWsItemPOJOPK()[i];
			context.getProjectedPKs().add(WS2POJO(wsPK));
		}
		
		return context;
	}


	private WSTypedContent POJO2WS(TypedContent content) throws Exception{
		if (content==null) return null;
		WSTypedContent wsTypedContent = new WSTypedContent();
		if (content.getUrl() == null) {
			wsTypedContent.setWsBytes(new WSByteArray(content.getContentBytes()));
		}
		wsTypedContent.setUrl(content.getUrl());
		wsTypedContent.setContentType(content.getContentType());
		return wsTypedContent;
	}
	
	private TypedContent WS2POJO(WSTypedContent wsContent) throws Exception{
		TypedContent content =null;
		if (wsContent == null) return null;
		if (wsContent.getUrl() == null) {
			content = new TypedContent(wsContent.getWsBytes().getBytes(),wsContent.getContentType());
		} else {
			content = new TypedContent(wsContent.getUrl(),wsContent.getContentType());
		}
		return content;
	}
	
	private WSTransformerVariablesMapping POJO2WS(TransformerVariablesMapping mappings) throws Exception{
		WSTransformerVariablesMapping wsMapping = new WSTransformerVariablesMapping();
		wsMapping.setPluginVariable(mappings.getPluginVariable());
		wsMapping.setPipelineVariable(mappings.getPipelineVariable());
		wsMapping.setHardCoding(POJO2WS(mappings.getHardCoding()));
		return wsMapping;
	}
	
	private TransformerVariablesMapping WS2POJO(WSTransformerVariablesMapping wsMapping) throws Exception{
		TransformerVariablesMapping mapping = new TransformerVariablesMapping();
		mapping.setPluginVariable(wsMapping.getPluginVariable());
		mapping.setPipelineVariable(wsMapping.getPipelineVariable());
		mapping.setHardCoding(WS2POJO(wsMapping.getHardCoding()));
		return mapping;
	}
	
	private WSTransformerProcessStep POJO2WS(TransformerProcessStep processStep) throws Exception{
		WSTransformerProcessStep wsProcessStep = new WSTransformerProcessStep();
		wsProcessStep.setDescription(processStep.getDescription());
		wsProcessStep.setDisabled(processStep.isDisabled());
		wsProcessStep.setParameters(processStep.getParameters());
		wsProcessStep.setPluginJNDI(processStep.getPluginJNDI());
		
		ArrayList<WSTransformerVariablesMapping> wsMappings = new ArrayList<WSTransformerVariablesMapping>(); 
		ArrayList<TransformerVariablesMapping> list = processStep.getInputMappings();
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			TransformerVariablesMapping mapping = (TransformerVariablesMapping) iter.next();
			wsMappings.add(POJO2WS(mapping));
		}
		wsProcessStep.setInputMappings(wsMappings.toArray(new WSTransformerVariablesMapping[wsMappings.size()]));
		
		wsMappings = new ArrayList<WSTransformerVariablesMapping>(); 
		list = processStep.getOutputMappings();
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			TransformerVariablesMapping mapping = (TransformerVariablesMapping) iter.next();
			wsMappings.add(POJO2WS(mapping));
		}
		wsProcessStep.setOutputMappings(wsMappings.toArray(new WSTransformerVariablesMapping[wsMappings.size()]));
		return wsProcessStep;
	}
	
	private TransformerProcessStep WS2POJO(WSTransformerProcessStep wsProcessStep) throws Exception{
		TransformerProcessStep processStep = new TransformerProcessStep();
		processStep.setDescription(wsProcessStep.getDescription());
		processStep.setDisabled(wsProcessStep.getDisabled().booleanValue());
		processStep.setParameters(wsProcessStep.getParameters());
		processStep.setPluginJNDI(wsProcessStep.getPluginJNDI());
		ArrayList<TransformerVariablesMapping> inputMappings = new ArrayList<TransformerVariablesMapping>();
		if (wsProcessStep.getInputMappings()!=null) {
			for (int i = 0; i < wsProcessStep.getInputMappings().length; i++) {
				inputMappings.add(WS2POJO(wsProcessStep.getInputMappings()[i]));
			}
		}
		processStep.setInputMappings(inputMappings);
		ArrayList<TransformerVariablesMapping> outputMappings = new ArrayList<TransformerVariablesMapping>();
		if (wsProcessStep.getOutputMappings()!=null) {
			for (int i = 0; i < wsProcessStep.getOutputMappings().length; i++) {
				inputMappings.add(WS2POJO(wsProcessStep.getOutputMappings()[i]));
			}
		}
		processStep.setOutputMappings(outputMappings);
		return processStep;
	}
    
	private WSTransformerV2 POJO2WS(TransformerV2POJO transformerPOJO) throws Exception{
		WSTransformerV2 ws = new WSTransformerV2();
		ws.setName(transformerPOJO.getName());
		ws.setDescription(transformerPOJO.getDescription());
		ArrayList<WSTransformerProcessStep> wsSteps = new ArrayList<WSTransformerProcessStep>();
		ArrayList< TransformerProcessStep> processSteps = transformerPOJO.getProcessSteps();
		if (processSteps!=null) {
			for (Iterator iter = processSteps.iterator(); iter.hasNext(); ) {
				TransformerProcessStep processStep = (TransformerProcessStep)iter.next();
				wsSteps.add(POJO2WS(processStep));
			}
		}
		ws.setProcessSteps(wsSteps.toArray(new WSTransformerProcessStep[wsSteps.size()]));
		return ws;
	}

	private TransformerV2POJO WS2POJO(WSTransformerV2 wsTransformerV2) throws Exception{
		TransformerV2POJO pojo = new TransformerV2POJO();
		pojo.setName(wsTransformerV2.getName());
		pojo.setDescription(wsTransformerV2.getDescription());
		ArrayList<TransformerProcessStep> steps = new ArrayList<TransformerProcessStep>();
		WSTransformerProcessStep[] wsSteps = wsTransformerV2.getProcessSteps();
		if (wsSteps!=null) {
			for (int i = 0; i < wsSteps.length; i++) {
				TransformerProcessStep step = WS2POJO(wsSteps[i]);
				steps.add(step);		
			}
		}
		pojo.setProcessSteps(steps);
		return pojo;
	}
	
	
//	private WSPipeline POJO2WS(HashMap<String,TypedContent> pipeline) throws Exception{
//		if (pipeline == null) return null;
//		
//		ArrayList<WSPipelineTypedContentEntry> entries = new ArrayList<WSPipelineTypedContentEntry>();
//		Set keys = pipeline.keySet();
//		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
//			String output = (String) iter.next();
//			TypedContent content = pipeline.get(output);
//			byte[] bytes = content.getContentBytes();
//			WSExtractedContent wsContent = new WSExtractedContent(
//				new WSByteArray(bytes),
//				content.getContentType()
//			);
//			WSPipelineTypedContentEntry wsEntry = new WSPipelineTypedContentEntry(
//				output,
//				wsContent
//			);
//			entries.add(wsEntry);
//		}
//		return new WSPipeline(entries.toArray(new WSPipelineTypedContentEntry[entries.size()]));
//	}
	
	
	private HashMap<String, TypedContent> WS2POJO(WSPipeline wsPipeline) throws Exception{
		if (wsPipeline == null) return null;
		
		HashMap<String, TypedContent> pipeline = new HashMap<String, TypedContent>();
		WSPipelineTypedContentEntry[] entries = wsPipeline.getTypedContentEntry();
		if (entries == null) return pipeline;
		
		for (int i = 0; i < entries.length; i++) {
			pipeline.put(
				entries[i].getOutput(), 
				new TypedContent(
					entries[i].getWsExtractedContent().getWsByteArray().getBytes(),
					entries[i].getWsExtractedContent().getContentType()
				)
			);
		}
		return pipeline;
	}
	
	
	/***************************************************************************
	 * TRANSFORMER PLUGINS V2
	 * **************************************************************************/
	
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 	 
	 *  	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSBoolean existsTransformerPluginV2(WSExistsTransformerPluginV2 wsExistsTransformerPlugin) throws RemoteException {
		try {
			return new WSBoolean(
				Util.existsComponent(
					null, 
					wsExistsTransformerPlugin.getJndiName()
				)
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSString getTransformerPluginV2Configuration(WSTransformerPluginV2GetConfiguration wsGetConfiguration) throws RemoteException {
		try {
			Object service= 
				Util.retrieveComponent(
					null, 
					wsGetConfiguration.getJndiName()
				);
			
			String configuration = (String)
				Util.getMethod(service, "getConfiguration").invoke(
					service,
					new Object[] {
							wsGetConfiguration.getOptionalParameter()
					}
				);
			return new WSString(configuration);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 
	 * 	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSString putTransformerPluginV2Configuration(WSTransformerPluginV2PutConfiguration wsPutConfiguration) throws RemoteException {
		try {
			Object service= 
				Util.retrieveComponent(
					null, 
					wsPutConfiguration.getJndiName()
				);
			
			Util.getMethod(service, "putConfiguration").invoke(
				service,
				new Object[] {
						wsPutConfiguration.getConfiguration()
				}
			);
			return new WSString(wsPutConfiguration.getConfiguration());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 	 
	 *  	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerPluginV2Details getTransformerPluginV2Details(WSGetTransformerPluginV2Details wsGetTransformerPluginDetails) throws RemoteException {
		try {
			Object service= 
				Util.retrieveComponent(
					null, 
					wsGetTransformerPluginDetails.getJndiName()
				);
			String description = (String)Util.getMethod(service, "getDescription").invoke(
				service,
				new Object[] {
						wsGetTransformerPluginDetails.getLanguage() == null ? "" : wsGetTransformerPluginDetails.getLanguage() 
				}
			);
			String documentation = (String)Util.getMethod(service, "getDocumentation").invoke(
					service,
					new Object[] {
							wsGetTransformerPluginDetails.getLanguage() == null ? "" : wsGetTransformerPluginDetails.getLanguage() 
					}
				);
			String parametersSchema = (String)Util.getMethod(service, "getParametersSchema").invoke(
					service,
					new Object[] {}
				);
			
			ArrayList<TransformerPluginVariableDescriptor> inputVariableDescriptors = 
				(ArrayList<TransformerPluginVariableDescriptor>)Util.getMethod(service, "getInputVariableDescriptors").invoke(
						service,
						new Object[] {
								wsGetTransformerPluginDetails.getLanguage() == null ? "" : wsGetTransformerPluginDetails.getLanguage() 
						}
				);
			ArrayList<WSTransformerPluginV2VariableDescriptor> wsInputVariableDescriptors = new ArrayList<WSTransformerPluginV2VariableDescriptor>();
			if (inputVariableDescriptors != null) {
				for (Iterator iter = inputVariableDescriptors.iterator(); iter.hasNext(); ) {
					TransformerPluginVariableDescriptor descriptor = (TransformerPluginVariableDescriptor) iter.next();
					wsInputVariableDescriptors.add(POJO2WS(descriptor));
				}
			}
			
			ArrayList<TransformerPluginVariableDescriptor> outputVariableDescriptors = 
				(ArrayList<TransformerPluginVariableDescriptor>)Util.getMethod(service, "getOutputVariableDescriptors").invoke(
						service,
						new Object[] {
							wsGetTransformerPluginDetails.getLanguage() == null ? "" : wsGetTransformerPluginDetails.getLanguage() 
						}
				);
			ArrayList<WSTransformerPluginV2VariableDescriptor> wsOutputVariableDescriptors = new ArrayList<WSTransformerPluginV2VariableDescriptor>();
			if (outputVariableDescriptors != null) {
				for (Iterator iter = outputVariableDescriptors.iterator(); iter.hasNext(); ) {
					TransformerPluginVariableDescriptor descriptor = (TransformerPluginVariableDescriptor) iter.next();
					wsOutputVariableDescriptors.add(POJO2WS(descriptor));
				}
			}

			return new WSTransformerPluginV2Details(
					wsInputVariableDescriptors.toArray(new WSTransformerPluginV2VariableDescriptor[wsInputVariableDescriptors.size()]),
					wsOutputVariableDescriptors.toArray(new WSTransformerPluginV2VariableDescriptor[wsOutputVariableDescriptors.size()]),
					description,
					documentation,
					parametersSchema
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}


	/**
	 * @ejb.interface-method view-type = "service-endpoint"
	 * @ejb.permission 	 
	 *  	role-name = "authenticated"
	 * 	view-type = "service-endpoint"
	 */
	public WSTransformerPluginV2SList getTransformerPluginV2SList(WSGetTransformerPluginV2SList wsGetTransformerPluginsList) throws RemoteException {
		try {
			ArrayList<WSTransformerPluginV2SListItem> wsList = new ArrayList<WSTransformerPluginV2SListItem>();
			InitialContext ctx = new InitialContext();
			NamingEnumeration<NameClassPair> list = ctx.list("amalto/local/transformer/plugin");
			while (list.hasMore()) {
			    NameClassPair nc = list.next();
			    WSTransformerPluginV2SListItem item =new WSTransformerPluginV2SListItem();
			    item.setJndiName(nc.getName());
				Object service= 
					Util.retrieveComponent(
						null, 
						"amalto/local/transformer/plugin/"+nc.getName()
					);
				String description = (String)Util.getMethod(service, "getDescription").invoke(
					service,
					new Object[] {
							wsGetTransformerPluginsList.getLanguage() == null ? "" : wsGetTransformerPluginsList.getLanguage() 
					}
				);
				item.setDescription(description);
			    wsList.add(item);
			}
			return new WSTransformerPluginV2SList(wsList.toArray(new WSTransformerPluginV2SListItem[wsList.size()]));
//		} catch (XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}	
	
	private WSTransformerPluginV2VariableDescriptor POJO2WS(TransformerPluginVariableDescriptor descriptor) throws Exception{
		WSTransformerPluginV2VariableDescriptor wsDescriptor = new WSTransformerPluginV2VariableDescriptor();
		wsDescriptor.setVariableName(descriptor.getVariableName());
		if (descriptor.getDescriptions().size()>0)
			wsDescriptor.setDescription(descriptor.getDescriptions().values().iterator().next());
		wsDescriptor.setMandatory(descriptor.isMandatory());
		ArrayList<String> contentTypesRegex = new ArrayList<String>();
		if (descriptor.getContentTypesRegex()!=null) {
			for (Iterator iterator = descriptor.getContentTypesRegex().iterator(); iterator.hasNext(); ) {
				Pattern p = (Pattern) iterator.next();
				contentTypesRegex.add(p.toString());
			}
		}
		wsDescriptor.setContentTypesRegex(contentTypesRegex.toArray(new String[contentTypesRegex.size()]));
		ArrayList<String> possibleValuesRegex = new ArrayList<String>();
		if (descriptor.getPossibleValuesRegex()!=null) {
			for (Iterator iterator = descriptor.getPossibleValuesRegex().iterator(); iterator.hasNext(); ) {
				Pattern p = (Pattern) iterator.next();
				possibleValuesRegex.add(p.toString());
			}
		}
		wsDescriptor.setPossibleValuesRegex(possibleValuesRegex.toArray(new String[possibleValuesRegex.size()]));
		return wsDescriptor;
	}
	
	
	/***************************************************************************
	 * Role
	 * **************************************************************************/

    public WSRolePK deleteRole(WSDeleteRole wsRoleDelete) throws RemoteException {
		try {
			RoleCtrlLocal ctrl = com.amalto.core.util.Util.getRoleCtrlLocal();
			return
				new WSRolePK(
					ctrl.removeRole(
						new RolePOJOPK(
								wsRoleDelete.getWsRolePK().getPk()
						)
					).getUniqueId()
				);
	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    
	public WSRole getRole(WSGetRole wsGetRole) throws RemoteException {
		try {
			RoleCtrlLocal ctrl = com.amalto.core.util.Util.getRoleCtrlLocal();
			RolePOJO pojo =
				ctrl.getRole(
					new RolePOJOPK(
							wsGetRole.getWsRolePK().getPk()
					)
				);
			return POJO2WS(pojo);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	public WSBoolean existsRole(WSExistsRole wsExistsRole) throws RemoteException {
		try {
			RoleCtrlLocal ctrl = com.amalto.core.util.Util.getRoleCtrlLocal();
			RolePOJO pojo =
				ctrl.existsRole(
					new RolePOJOPK(
							wsExistsRole.getWsRolePK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSRolePKArray getRolePKs(WSGetRolePKs regex) throws RemoteException {
		try {
			RoleCtrlLocal ctrl = com.amalto.core.util.Util.getRoleCtrlLocal();
			Collection c =
				ctrl.getRolePKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSRolePK[] pks = new WSRolePK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSRolePK(
						((RolePOJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSRolePKArray(pks);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSRolePK putRole(WSPutRole wsRole) throws RemoteException {
		try {
			RoleCtrlLocal ctrl = com.amalto.core.util.Util.getRoleCtrlLocal();
			RolePOJOPK pk =
				ctrl.putRole(
					WS2POJO(wsRole.getWsRole())
				);
			return new WSRolePK(pk.getUniqueId());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	public WSStringArray getObjectsForRoles(WSGetObjectsForRoles wsRoleDelete) throws RemoteException {
		Set<String> names = ObjectPOJO.getObjectsNames2ClassesMap().keySet(); 
		return new WSStringArray(
				names.toArray(new String[names.size()])
		);
	}

	
	private WSRole POJO2WS(RolePOJO rolePOJO) throws Exception {
		WSRole ws = new WSRole();
		ws.setName(rolePOJO.getName());
		ws.setDescription(rolePOJO.getDescription());
		Set objectTypes = rolePOJO.getRoleSpecifications().keySet();
		ArrayList wsSpecifications = new ArrayList();
		WSRoleSpecification wsSpecification;
		for (Iterator iter = objectTypes.iterator(); iter.hasNext(); wsSpecifications.add(wsSpecification)) {
			String objectType = (String) iter.next();
			RoleSpecification specification = rolePOJO.getRoleSpecifications().get(objectType);
			ArrayList wsInstances = new ArrayList();
			Set instanceIds = specification.getInstances().keySet();
			WSRoleSpecificationInstance wsInstance;
			for (Iterator iterator = instanceIds.iterator(); iterator.hasNext(); wsInstances.add(wsInstance)) {
				String id = (String) iterator.next();
				RoleInstance instance = specification.getInstances().get(id);
				String wsParameters[] = instance.getParameters().toArray(new String[instance.getParameters().size()]);
				wsInstance = new WSRoleSpecificationInstance(id, instance.isWriteable(), wsParameters);
			}

			wsSpecification = new WSRoleSpecification(
					objectType,
					specification.isAdmin(),
					(WSRoleSpecificationInstance[]) wsInstances
							.toArray(new WSRoleSpecificationInstance[wsInstances
									.size()]));
		}

		ws.setSpecification((WSRoleSpecification[]) wsSpecifications
				.toArray(new WSRoleSpecification[wsSpecifications.size()]));
		return ws;
	}

	private RolePOJO WS2POJO(WSRole wsRole) throws Exception {
		RolePOJO pojo = new RolePOJO();
		pojo.setName(wsRole.getName());
		pojo.setDescription(wsRole.getDescription());
		HashMap specifications = new HashMap();
		if (wsRole.getSpecification() != null) {
			for (int i = 0; i < wsRole.getSpecification().length; i++) {
				WSRoleSpecification wsSpecification = wsRole.getSpecification()[i];
				RoleSpecification specification = new RoleSpecification();
				specification.setAdmin(wsSpecification.isAdmin());
				if (wsSpecification.getInstance() != null) {
					for (int j = 0; j < wsSpecification.getInstance().length; j++) {
						WSRoleSpecificationInstance wsInstance = wsSpecification.getInstance()[j];
						RoleInstance instance = new RoleInstance();
						instance.setWriteable(wsInstance.isWritable());
						instance.setParameters(new HashSet());
						if (wsInstance.getParameter() != null)
							instance.getParameters().addAll(Arrays.asList(wsInstance.getParameter()));
						specification.getInstances().put(wsInstance.getInstanceName(), instance);
					}

				}
				specifications.put(
						wsSpecification.getObjectType(),
						specification
				);
			}

		}
		pojo.setRoleSpecifications(specifications);
		return pojo;
	}


	/***************************************************************************
	 * Menu
	 * **************************************************************************/

    public WSMenuPK deleteMenu(WSDeleteMenu wsMenuDelete) throws RemoteException {
		try {
			MenuCtrlLocal ctrl = com.amalto.core.util.Util.getMenuCtrlLocal();
			return
				new WSMenuPK(
					ctrl.removeMenu(
						new MenuPOJOPK(
								wsMenuDelete.getWsMenuPK().getPk()
						)
					).getUniqueId()
				);
	
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
    
	public WSMenu getMenu(WSGetMenu wsGetMenu) throws RemoteException {
		try {
			MenuCtrlLocal ctrl = com.amalto.core.util.Util.getMenuCtrlLocal();
			MenuPOJO pojo =
				ctrl.getMenu(
					new MenuPOJOPK(
							wsGetMenu.getWsMenuPK().getPk()
					)
				);
			return POJO2WS(pojo);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSBoolean existsMenu(WSExistsMenu wsExistsMenu) throws RemoteException {
		try {
			MenuCtrlLocal ctrl = Util.getMenuCtrlLocal();
			MenuPOJO pojo =
				ctrl.existsMenu(
					new MenuPOJOPK(
							wsExistsMenu.getWsMenuPK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	public WSMenuPKArray getMenuPKs(WSGetMenuPKs regex) throws RemoteException {
		try {
			MenuCtrlLocal ctrl = com.amalto.core.util.Util.getMenuCtrlLocal();
			Collection c =
				ctrl.getMenuPKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSMenuPK[] pks = new WSMenuPK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSMenuPK(
						((MenuPOJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSMenuPKArray(pks);
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}

	public WSMenuPK putMenu(WSPutMenu wsMenu) throws RemoteException {
		try {
			MenuCtrlLocal ctrl = com.amalto.core.util.Util.getMenuCtrlLocal();
			MenuPOJOPK pk =
				ctrl.putMenu(
					WS2POJO(wsMenu.getWsMenu())
				);
			return new WSMenuPK(pk.getUniqueId());
		} catch (Exception e) {
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	

	private WSMenu POJO2WS(MenuPOJO pojo) throws Exception{
		WSMenu ws = new WSMenu();
		ws.setName(pojo.getName());
		ws.setDescription(pojo.getDescription());
		if (pojo.getMenuEntries()!=null) {
			WSMenuEntry[] wsSubMenus = new WSMenuEntry[pojo.getMenuEntries().size()];
			int i=0;
			for (Iterator iter = pojo.getMenuEntries().iterator(); iter.hasNext(); ) {
				MenuEntryPOJO menuEntry = (MenuEntryPOJO) iter.next();
				wsSubMenus[i++] = POJO2WS(menuEntry);
			}
			ws.setMenuEntries(wsSubMenus);
		}
		return ws;
	}
	
	private MenuPOJO WS2POJO(WSMenu ws) throws Exception{
		MenuPOJO pojo = new MenuPOJO();
		pojo.setName(ws.getName());
		pojo.setDescription(ws.getDescription());
		ArrayList<MenuEntryPOJO> menuEntries = new ArrayList<MenuEntryPOJO>();
		if (ws.getMenuEntries()!=null) {
			for (int i = 0; i < ws.getMenuEntries().length; i++) {
				menuEntries.add(WS2POJO(ws.getMenuEntries()[i]));
			}
		}
		pojo.setMenuEntries(menuEntries);
		return pojo;
	}	
	
	
	
	private WSMenuEntry POJO2WS(MenuEntryPOJO pojo) throws Exception{
		WSMenuEntry ws = new WSMenuEntry();
		ws.setId(pojo.getId());
		Set<String> languages = pojo.getDescriptions().keySet();
		WSMenuMenuEntriesDescriptions[] wsDescriptions = new WSMenuMenuEntriesDescriptions[languages.size()];
		int i=0;
		for (Iterator iter = languages.iterator(); iter.hasNext(); ) {
			String language = (String) iter.next();
			wsDescriptions[i] = new WSMenuMenuEntriesDescriptions();
			wsDescriptions[i].setLanguage(language);
			wsDescriptions[i].setLabel(pojo.getDescriptions().get(language));
			i++;
		}
		ws.setDescriptions(wsDescriptions);
		ws.setContext(pojo.getContext());
		ws.setApplication(pojo.getApplication());
		if (pojo.getSubMenus()!=null) {
			WSMenuEntry[] wsSubMenus = new WSMenuEntry[pojo.getSubMenus().size()];
			i=0;
			for (Iterator iter = pojo.getSubMenus().iterator(); iter.hasNext(); ) {
				MenuEntryPOJO menuEntry = (MenuEntryPOJO) iter.next();
				wsSubMenus[i++] = POJO2WS(menuEntry);
			}
			ws.setSubMenus(wsSubMenus);
		}
		return ws;
	}

	private MenuEntryPOJO WS2POJO(WSMenuEntry ws) throws Exception{
		MenuEntryPOJO pojo = new MenuEntryPOJO();
		pojo.setId(ws.getId());
		HashMap<String, String> descriptions = new HashMap<String, String>();
		if (ws.getDescriptions()!=null) {
			for (int i = 0; i < ws.getDescriptions().length; i++) {
				descriptions.put(
						ws.getDescriptions()[i].getLanguage(),
						ws.getDescriptions()[i].getLabel()
				);
			}
		}
		pojo.setDescriptions(descriptions);
		pojo.setContext(ws.getContext());
		pojo.setApplication(ws.getApplication());
		ArrayList<MenuEntryPOJO> subMenus = new ArrayList<MenuEntryPOJO>();
		if (ws.getSubMenus()!=null) {
			for (int i = 0; i < ws.getSubMenus().length; i++) {
				subMenus.add(WS2POJO(ws.getSubMenus()[i]));
			}
		}
		pojo.setSubMenus(subMenus);
		return pojo;
	}	
	
	
	/***************************************************************************
	 * BACKGROUND JOBS
	 * **************************************************************************/

	public WSBackgroundJobPKArray findBackgroundJobPKs(WSFindBackgroundJobPKs status) throws RemoteException {
		try {
			 throw new RemoteException("WSBackgroundJobPKArray is not implemented in this version of the core");
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}


	public WSBackgroundJob getBackgroundJob(WSGetBackgroundJob wsGetBackgroundJob) throws RemoteException {
		try {
		    return POJO2WS( 
					BackgroundJobCtrlUtil.getLocalHome().create().getBackgroundJob(
							new BackgroundJobPOJOPK(wsGetBackgroundJob.getPk())
					)
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	public WSBackgroundJobPK putBackgroundJob(WSPutBackgroundJob wsPutBackgroundJob) throws RemoteException {
		try {
	        return new WSBackgroundJobPK(BackgroundJobCtrlUtil.getLocalHome().create().putBackgroundJob(
    				WS2POJO(wsPutBackgroundJob.getWsBackgroundJob())
					).getUniqueId());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	private WSBackgroundJob POJO2WS(BackgroundJobPOJO pojo) throws Exception{
		try {
		    WSBackgroundJob s = new WSBackgroundJob();
		    s.setId(pojo.getId());
		    s.setDescription(pojo.getDescription());
		    switch(pojo.getStatus()) {
		    	case 0:
		    		s.setStatus(BackgroundJobStatusType.COMPLETED);
		    		break;
		    	case 1:
		    		s.setStatus(BackgroundJobStatusType.RUNNING);
		    		break;
		    	case 2:
		    		s.setStatus(BackgroundJobStatusType.SUSPENDED);
		    		break;
		    	case 3:
		    		s.setStatus(BackgroundJobStatusType.STOPPED);
		    		break;
		    	case 4:
		    		s.setStatus(BackgroundJobStatusType.CANCEL_REQUESTED);
		    		break;
		    	case 5:
		    		s.setStatus(BackgroundJobStatusType.SCHEDULED);
		    		break;
		    	default:
		    		throw new Exception("Unknow BackgroundJob Status: "+pojo.getStatus());
		    }
		    s.setMessage(pojo.getMessage());
		    s.setPercentage(pojo.getPercentage());
		    s.setTimestamp(pojo.getTimestamp());
		    
		    //concert core WSPipeline to webapp.core WSPipeline
		    WSPipeline wsPipeline = new WSPipeline();
		    WSPipelineTypedContentEntry[] wsEntries = new WSPipelineTypedContentEntry[pojo.getWsPipeline().getTypedContentEntry().length];
		    for (int i = 0; i < pojo.getWsPipeline().getTypedContentEntry().length; i++) {
		    	String output = pojo.getWsPipeline().getTypedContentEntry()[i].getOutput();
		    	String contentType = pojo.getWsPipeline().getTypedContentEntry()[i].getWsExtractedContent().getContentType();
		    	byte[] bytes = pojo.getWsPipeline().getTypedContentEntry()[i].getWsExtractedContent().getWsByteArray().getBytes();
		    	wsEntries[i] = new WSPipelineTypedContentEntry(
		    		output,
		    		new WSExtractedContent(new WSByteArray(bytes), contentType)
		    	);
			}
		    wsPipeline.setTypedContentEntry(wsEntries);
		    s.setPipeline(wsPipeline);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}
	}
		

	private BackgroundJobPOJO WS2POJO(WSBackgroundJob ws) throws Exception{
	    BackgroundJobPOJO pojo = new BackgroundJobPOJO();
	    pojo.setId(ws.getId());
	    pojo.setMessage(ws.getMessage());
	    pojo.setDescription(ws.getDescription());
	    pojo.setPercentage(ws.getPercentage());
	    pojo.setTimestamp(ws.getTimestamp());
	    if (ws.getStatus().equals(BackgroundJobStatusType.CANCEL_REQUESTED)) {
	    	pojo.setStatus(BackgroundJobPOJO._CANCEL_REQUESTED_); 
	    } else if (ws.getStatus().equals(BackgroundJobStatusType.COMPLETED)) {
	    	pojo.setStatus(BackgroundJobPOJO._COMPLETED_); 
	    } else if (ws.getStatus().equals(BackgroundJobStatusType.RUNNING)) {
	    	pojo.setStatus(BackgroundJobPOJO._RUNNING_); 
	    } else if (ws.getStatus().equals(BackgroundJobStatusType.SCHEDULED)) {
	    	pojo.setStatus(BackgroundJobPOJO._SCHEDULED_);
	    } else if (ws.getStatus().equals(BackgroundJobStatusType.STOPPED)) {
	    	pojo.setStatus(BackgroundJobPOJO._STOPPED_);
	    } else if (ws.getStatus().equals(BackgroundJobStatusType.SUSPENDED)) {
	    	pojo.setStatus(BackgroundJobPOJO._SUSPENDED_);
	    }
	    pojo.setPipeline(WS2POJO(ws.getPipeline()));
	    //we do not rewrite the pipeline
		return pojo;
	}



	public WSString count(WSCount wsCount) throws RemoteException {
		try {
			long count = Util.getItemCtrl2Local().count(
				new DataClusterPOJOPK(wsCount.getWsDataClusterPK().getPk()),
				wsCount.getCountPath(),
				WS2VO(wsCount.getWhereItem()),
				wsCount.getSpellTreshold()
			);
			return new WSString(count+"");
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }

	/***************************************************************************
	 * Routing Order V2
	 * **************************************************************************/

	public WSRoutingOrderV2PK deleteRoutingOrderV2(WSDeleteRoutingOrderV2 wsDeleteRoutingOrder) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			return POJO2WS(ctrl.removeRoutingOrder(WS2POJO(wsDeleteRoutingOrder.getWsRoutingOrderPK())));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSRoutingOrderV2PK executeRoutingOrderV2Asynchronously(WSExecuteRoutingOrderV2Asynchronously wsExecuteRoutingOrderAsynchronously) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			AbstractRoutingOrderV2POJO ro = ctrl.getRoutingOrder(WS2POJO(wsExecuteRoutingOrderAsynchronously.getRoutingOrderV2PK()));
			ctrl.executeAsynchronously(ro);
			return POJO2WS(ro.getAbstractRoutingOrderPOJOPK());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSString executeRoutingOrderV2Synchronously(WSExecuteRoutingOrderV2Synchronously wsExecuteRoutingOrderSynchronously) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			AbstractRoutingOrderV2POJO ro = ctrl.getRoutingOrder(WS2POJO(wsExecuteRoutingOrderSynchronously.getRoutingOrderV2PK()));
			return new WSString(ctrl.executeSynchronously(ro));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSRoutingOrderV2 existsRoutingOrderV2(WSExistsRoutingOrderV2 wsExistsRoutingOrder) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			return POJO2WS(ctrl.existsRoutingOrder(WS2POJO(wsExistsRoutingOrder.getWsRoutingOrderPK())));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSRoutingOrderV2 getRoutingOrderV2(WSGetRoutingOrderV2 wsGetRoutingOrderV2) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			return POJO2WS(ctrl.getRoutingOrder(WS2POJO(wsGetRoutingOrderV2.getWsRoutingOrderPK())));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSRoutingOrderV2PKArray getRoutingOrderV2PKsByCriteria(WSGetRoutingOrderV2PKsByCriteria wsGetRoutingOrderV2PKsByCriteria) throws RemoteException {
		try {
			WSRoutingOrderV2PKArray wsPKArray = new WSRoutingOrderV2PKArray();
			ArrayList<WSRoutingOrderV2PK> list = new ArrayList<WSRoutingOrderV2PK>();
			//fetch results
			Collection<AbstractRoutingOrderV2POJOPK> pks = getRoutingOrdersByCriteria(wsGetRoutingOrderV2PKsByCriteria.getWsSearchCriteria());
			for (Iterator<AbstractRoutingOrderV2POJOPK> iterator = pks.iterator(); iterator.hasNext(); ) {
				AbstractRoutingOrderV2POJOPK abstractRoutingOrderV2POJOPK = iterator.next();
				list.add(POJO2WS(abstractRoutingOrderV2POJOPK));
			}
			wsPKArray.setWsRoutingOrder(list.toArray(new WSRoutingOrderV2PK[list.size()]));
			return wsPKArray;
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSRoutingOrderV2Array getRoutingOrderV2SByCriteria(WSGetRoutingOrderV2SByCriteria wsGetRoutingOrderV2SByCriteria) throws RemoteException {
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			WSRoutingOrderV2Array wsPKArray = new WSRoutingOrderV2Array();
			ArrayList<WSRoutingOrderV2> list = new ArrayList<WSRoutingOrderV2>();
			//fetch results
			Collection<AbstractRoutingOrderV2POJOPK> pks = getRoutingOrdersByCriteria(wsGetRoutingOrderV2SByCriteria.getWsSearchCriteria());
			for (Iterator<AbstractRoutingOrderV2POJOPK> iterator = pks.iterator(); iterator.hasNext(); ) {
				AbstractRoutingOrderV2POJOPK abstractRoutingOrderV2POJOPK = iterator.next();
				list.add(POJO2WS(ctrl.getRoutingOrder(abstractRoutingOrderV2POJOPK)));
			}
			wsPKArray.setWsRoutingOrder(list.toArray(new WSRoutingOrderV2[list.size()]));
			return wsPKArray;
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }


	private Collection<AbstractRoutingOrderV2POJOPK> getRoutingOrdersByCriteria(WSRoutingOrderV2SearchCriteria criteria) throws Exception{
		try {
			RoutingOrderV2CtrlLocal ctrl = Util.getRoutingOrderV2CtrlLocal();
			Class<? extends AbstractRoutingOrderV2POJO> clazz = null;
		    if (criteria.getStatus().equals(WSRoutingOrderV2Status.ACTIVE)) {
		    	clazz = ActiveRoutingOrderV2POJO.class;
		    } else if (criteria.getStatus().equals(WSRoutingOrderV2Status.COMPLETED)) {
		    	clazz = CompletedRoutingOrderV2POJO.class;
		    } else if (criteria.getStatus().equals(WSRoutingOrderV2Status.FAILED)) {
		    	clazz = FailedRoutingOrderV2POJO.class;
		    }  
			Collection<AbstractRoutingOrderV2POJOPK> pks = ctrl.getRoutingOrderPKsByCriteria(
				clazz, 
				criteria.getAnyFieldContains(), 
				criteria.getNameContains(), 
				criteria.getTimeCreatedMin(),
				criteria.getTimeCreatedMax(), 
				criteria.getTimeScheduledMin(), 
				criteria.getTimeScheduledMax(), 
				criteria.getTimeLastRunStartedMin(), 
				criteria.getTimeLastRunStartedMax(), 
				criteria.getTimeLastRunCompletedMin(), 
				criteria.getTimeLastRunCompletedMax(),
				criteria.getItemPKConceptContains(),
				criteria.getItemPKIDFieldsContain(),
				criteria.getServiceJNDIContains(),
				criteria.getServiceParametersContain(),
				criteria.getMessageContain()
			);
			
			return pks;
		} catch (Exception e) {
			String err = "ERROR SYSTRACE: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).debug(err,e);
			throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
		}
	}
	
	
	private WSRoutingOrderV2PK POJO2WS(AbstractRoutingOrderV2POJOPK pojo) throws Exception{
		if (pojo==null) return null;
		try {
		    WSRoutingOrderV2PK ws = new WSRoutingOrderV2PK();
		    ws.setName(pojo.getName());
		    switch(pojo.getStatus()) {
		    	case AbstractRoutingOrderV2POJO.ACTIVE:
		    		ws.setStatus(WSRoutingOrderV2Status.ACTIVE);
		    		break;
		    	case AbstractRoutingOrderV2POJO.COMPLETED:
		    		ws.setStatus(WSRoutingOrderV2Status.COMPLETED);
		    		break;
		    	case AbstractRoutingOrderV2POJO.FAILED:
		    		ws.setStatus(WSRoutingOrderV2Status.FAILED);
		    		break;
		    }	
		    return ws;
		} catch (Exception e) {
			String err = "ERROR SYSTRACE: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).debug(err,e);
			throw(e);
		}
	}	    
	
	
	private AbstractRoutingOrderV2POJOPK WS2POJO(WSRoutingOrderV2PK s) throws Exception{
		if (s==null) return null;
		try {			
		    AbstractRoutingOrderV2POJOPK pojo = null;
		    if (s.getStatus().equals(WSRoutingOrderV2Status.ACTIVE)) {
		    	pojo = new ActiveRoutingOrderV2POJOPK(s.getName());
		    } else if (s.getStatus().equals(WSRoutingOrderV2Status.COMPLETED)) {
		    	pojo = new CompletedRoutingOrderV2POJOPK(s.getName());
		    } else if (s.getStatus().equals(WSRoutingOrderV2Status.FAILED)) {
		    	pojo = new FailedRoutingOrderV2POJOPK(s.getName());
		    }  
			return pojo;
		} catch (Exception e) {
			String err = "ERROR SYSTRACE: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).debug(err,e);
			throw(e);
		}
	}
	
	private WSRoutingOrderV2 POJO2WS(AbstractRoutingOrderV2POJO pojo) throws Exception{
		if (pojo==null) return null;
		try {
		    WSRoutingOrderV2 ws = new WSRoutingOrderV2();
		    ws.setMessage(pojo.getMessage());
		    ws.setName(pojo.getName());
		    ws.setServiceJNDI(pojo.getServiceJNDI());
		    ws.setServiceParameters(pojo.getServiceParameters());
		    switch(pojo.getStatus()) {
		    	case AbstractRoutingOrderV2POJO.ACTIVE:
		    		ws.setStatus(WSRoutingOrderV2Status.ACTIVE);
		    		break;
		    	case AbstractRoutingOrderV2POJO.COMPLETED:
		    		ws.setStatus(WSRoutingOrderV2Status.COMPLETED);
		    		break;
		    	case AbstractRoutingOrderV2POJO.FAILED:
		    		ws.setStatus(WSRoutingOrderV2Status.FAILED);
		    		break;
		    }		    
		    ws.setTimeCreated(pojo.getTimeCreated());
		    ws.setTimeLastRunCompleted(pojo.getTimeLastRunCompleted());
		    ws.setTimeLastRunStarted(pojo.getTimeLastRunStarted());
		    ws.setTimeScheduled(pojo.getTimeScheduled());
		    ws.setWsItemPK(POJO2WS(pojo.getItemPOJOPK()));
			return ws;
		} catch (Exception e) {
			String err = "ERROR SYSTRACE: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).debug(err,e);
			throw(e);
		}
	}
		
	
	/***************************************************************************
	 * Versioning
	 * **************************************************************************/
	
	
	
	public WSVersioningSystemConfiguration getVersioningSystemConfiguration(WSGetVersioningSystemConfiguration wsGetVersioningSystemConfiguration) throws RemoteException {
		throw new RemoteException("Not Supported Yet");
    }



	public WSString putVersioningSystemConfiguration(WSPutVersioningSystemConfiguration wsPutVersioningSystemConfiguration) throws RemoteException {
		throw new RemoteException("Not Supported Yet");
    }




	public WSVersioningInfo versioningGetInfo(WSVersioningGetInfo wsVersioningGetInfo) throws RemoteException {
		try {
			try {
				VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
				String res = 
					ctrl.getVersioningSystemAvailability(
							wsVersioningGetInfo.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningGetInfo.getVersioningSystemName())
					);
				return new WSVersioningInfo(res.startsWith("OK"),res);
			} catch (Exception e) {
				String err = "ERROR SYSTRACE: "+e.getMessage();
				org.apache.log4j.Logger.getLogger(this.getClass()).debug(err,e);
				throw new RemoteException(e.getClass().getName()+": "+e.getLocalizedMessage());
			}
//		} catch (XtentisException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSVersioningItemsHistory versioningGetItemsHistory(WSVersioningGetItemsHistory wsVersioningGetItemsHistory) throws RemoteException {
		throw new RemoteException("Not Supported Yet");
    }



	public WSVersioningObjectsHistory versioningGetObjectsHistory(WSVersioningGetObjectsHistory wsVersioningGetObjectsHistory) throws RemoteException {
		try {
			VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
			com.amalto.core.webservice.WSVersioningObjectsHistoryObjects[] objects =
				ctrl.getObjectsHistory(
					wsVersioningGetObjectsHistory.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningGetObjectsHistory.getVersioningSystemName()), 
					wsVersioningGetObjectsHistory.getType(), 
					wsVersioningGetObjectsHistory.getNames()
				).getObjects();
			if (objects == null) return null;
			
			WSVersioningObjectsHistoryObjects[] newObjects = new WSVersioningObjectsHistoryObjects[objects.length];
			for (int i = 0; i < objects.length; i++) {
				WSVersioningHistoryEntry[] newEntries = null;
				if (objects[i].getWsHistoryEntries() != null) {
					newEntries = new WSVersioningHistoryEntry[objects[i].getWsHistoryEntries().length];
					for (int j = 0; j < objects[i].getWsHistoryEntries().length; j++) {
						newEntries[j] = new WSVersioningHistoryEntry(
							objects[i].getWsHistoryEntries()[j].getTag(),
							objects[i].getWsHistoryEntries()[j].getRevision(),
							objects[i].getWsHistoryEntries()[j].getDate(),
							objects[i].getWsHistoryEntries()[j].getAuthor(),
							objects[i].getWsHistoryEntries()[j].getComments()
						);
					}
				}
				//set the new object
				newObjects[i] = new WSVersioningObjectsHistoryObjects(
					objects[i].getType(),
					objects[i].getName(),
					newEntries
				);
			}
			//set the main history
			return new WSVersioningObjectsHistory(newObjects);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSBackgroundJobPK versioningRestoreItems(WSVersioningRestoreItems wsVersioningRestoreItems) throws RemoteException {
		try {
			VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
			ArrayList<ItemPOJOPK> itemPKs = new ArrayList<ItemPOJOPK>();
			if (wsVersioningRestoreItems.getWsItemPKs()!=null) {
				for (int i = 0; i < wsVersioningRestoreItems.getWsItemPKs().length; i++) {
					itemPKs.add(WS2POJO(wsVersioningRestoreItems.getWsItemPKs()[i]));
				}
			}
			return new WSBackgroundJobPK(
				ctrl.restoreItemsAsJob(
						wsVersioningRestoreItems.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningRestoreItems.getVersioningSystemName()),
						wsVersioningRestoreItems.getTag(),
						itemPKs.toArray(new ItemPOJOPK[itemPKs.size()])
				).getUniqueId()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSBackgroundJobPK versioningRestoreObjects(WSVersioningRestoreObjects wsVersioningRestoreObjects) throws RemoteException {
		try {
			VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
			return new WSBackgroundJobPK(
				ctrl.restoreObjectsAsJob(
						wsVersioningRestoreObjects.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningRestoreObjects.getVersioningSystemName()),
						wsVersioningRestoreObjects.getTag(),
						wsVersioningRestoreObjects.getType(),
						wsVersioningRestoreObjects.getNames()
				).getUniqueId()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSBackgroundJobPK versioningTagItems(WSVersioningTagItems wsVersioningTagItems) throws RemoteException {
		try {
			VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
			ArrayList<ItemPOJOPK> itemPKs = new ArrayList<ItemPOJOPK>();
			if (wsVersioningTagItems.getWsItemPKs()!=null) {
				for (int i = 0; i < wsVersioningTagItems.getWsItemPKs().length; i++) {
					itemPKs.add(WS2POJO(wsVersioningTagItems.getWsItemPKs()[i]));
				}
			}
			return new WSBackgroundJobPK(
				ctrl.tagItemsAsJob(
						wsVersioningTagItems.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningTagItems.getVersioningSystemName()),
						wsVersioningTagItems.getTag(),
						wsVersioningTagItems.getComment(),
						itemPKs.toArray(new ItemPOJOPK[itemPKs.size()])
				).getUniqueId()
			);	
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }



	public WSBackgroundJobPK versioningTagObjects(WSVersioningTagObjects wsVersioningTagObjects) throws RemoteException {
		try {
			VersioningSystemCtrlLocal ctrl = Util.getVersioningSystemCtrlLocal();
			return new WSBackgroundJobPK(
				ctrl.tagObjectsAsJob(
						wsVersioningTagObjects.getVersioningSystemName() == null ? null : new VersioningSystemPOJOPK(wsVersioningTagObjects.getVersioningSystemName()),
						wsVersioningTagObjects.getTag(),
						wsVersioningTagObjects.getComment(),
						wsVersioningTagObjects.getType(),
						wsVersioningTagObjects.getNames()
				).getUniqueId()
			);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
    }		
	
	
	
	/***************************************************************************
	 * Routing Engine V2
	 * **************************************************************************/
	
	public WSRoutingRulePKArray routeItemV2(WSRouteItemV2 wsRouteItem) throws RemoteException {
		try {
			RoutingEngineV2CtrlLocal ctrl = Util.getRoutingEngineV2CtrlLocal();
			RoutingRulePOJOPK[] rules = ctrl.route(WS2POJO(wsRouteItem.getWsItemPK()));
			ArrayList<WSRoutingRulePK> list = new ArrayList<WSRoutingRulePK>();
			for (int i = 0; i < rules.length; i++) {
				list.add(new WSRoutingRulePK(rules[i].getUniqueId()));
			}
			return new WSRoutingRulePKArray(list.toArray(new WSRoutingRulePK[list.size()]));
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	
	public WSRoutingEngineV2Status routingEngineV2Action(WSRoutingEngineV2Action wsRoutingEngineAction) throws RemoteException {
		try {
			RoutingEngineV2CtrlLocal ctrl = Util.getRoutingEngineV2CtrlLocal();
			if (wsRoutingEngineAction.getWsAction().equals(WSRoutingEngineV2ActionCode.START)) {
				ctrl.start();
			} else if (wsRoutingEngineAction.getWsAction().equals(WSRoutingEngineV2ActionCode.STOP)) {
				ctrl.stop();
			} else if (wsRoutingEngineAction.getWsAction().equals(WSRoutingEngineV2ActionCode.SUSPEND)) {
				ctrl.suspend(true);
			} else if (wsRoutingEngineAction.getWsAction().equals(WSRoutingEngineV2ActionCode.RESUME)) {
				ctrl.suspend(false);
			} else if (wsRoutingEngineAction.getWsAction().equals(WSRoutingEngineV2ActionCode.STATUS)) {
				//done below;
			}
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
		
		try {
			RoutingEngineV2CtrlLocal ctrl = Util.getRoutingEngineV2CtrlLocal();
			int status = ctrl.getStatus();
			switch (status) {
				case RoutingEngineV2POJO.RUNNING:
					return WSRoutingEngineV2Status.RUNNING;
				case RoutingEngineV2POJO.STOPPED:
					return WSRoutingEngineV2Status.STOPPED;
				case RoutingEngineV2POJO.SUSPENDED:
					return WSRoutingEngineV2Status.SUSPENDED;
				default:
					return WSRoutingEngineV2Status.DEAD;
			}
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	/***************************************************************************
	 * Universes
	 ***************************************************************************/
	
	public WSUniversePK deleteUniverse(WSDeleteUniverse wsUniverseDelete) throws RemoteException {
		try {
			
			UniverseCtrlLocal ctrl = Util.getUniverseCtrlLocal();
			return
				new WSUniversePK(
					ctrl.removeUniverse(
						new UniversePOJOPK(
								wsUniverseDelete.getWsUniversePK().getPk()
						)
					).getUniqueId()
				);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSBoolean existsUniverse(WSExistsUniverse wsExistsUniverse) throws RemoteException {
		try {
			
			UniverseCtrlLocal ctrl = Util.getUniverseCtrlLocal();
			UniversePOJO pojo =
				ctrl.existsUniverse(
					new UniversePOJOPK(
							wsExistsUniverse.getWsUniversePK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSStringArray getObjectsForUniverses(WSGetObjectsForUniverses regex) throws RemoteException {
		try {
			
			Set<String> names = UniversePOJO.getXtentisObjectName(); 
			return new WSStringArray(
					names.toArray(new String[names.size()])
			);
			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSUniverse getUniverse(WSGetUniverse wsGetUniverse) throws RemoteException {
		try {
			
			UniverseCtrlLocal ctrl = Util.getUniverseCtrlLocal();
			UniversePOJO pojo =
				ctrl.getUniverse(
					new UniversePOJOPK(
							wsGetUniverse.getWsUniversePK().getPk()
					)
				);
			return POJO2WS(pojo);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSUniversePKArray getUniversePKs(WSGetUniversePKs regex) throws RemoteException {
		try {
			
			UniverseCtrlLocal ctrl = Util.getUniverseCtrlLocal();
			Collection c =
				ctrl.getUniversePKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSUniversePK[] pks = new WSUniversePK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSUniversePK(
						((UniversePOJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSUniversePKArray(pks);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSUniversePK putUniverse(WSPutUniverse wsUniverse) throws RemoteException {
		try {
			
			UniverseCtrlLocal ctrl = Util.getUniverseCtrlLocal();
			UniversePOJOPK pk =
				ctrl.putUniverse(
					WS2POJO(wsUniverse.getWsUniverse())
				);
			return new WSUniversePK(pk.getUniqueId());
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSUniverse getCurrentUniverse(WSGetCurrentUniverse wsGetCurrentUniverse) throws RemoteException {
		try {
			//this should force the User in the JACC context
			Util.getUniverseCtrlLocal();
			//Fetch the user
			LocalUser user = LocalUser.getLocalUser();
			return POJO2WS(user.getUniverse());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	private WSUniverse POJO2WS(UniversePOJO universePOJO) throws Exception{
		WSUniverse ws = new WSUniverse();
		ws.setName(universePOJO.getName());
		ws.setDescription(universePOJO.getDescription());
		//objects
		Set<String> objectTypes = universePOJO.getXtentisObjectsRevisionIDs().keySet();
		ArrayList<WSUniverseXtentisObjectsRevisionIDs> wsObjectsToRevisionIDs = new ArrayList<WSUniverseXtentisObjectsRevisionIDs>();
		for (Iterator<String> iter = objectTypes.iterator(); iter.hasNext(); ) {
			String objectType = iter.next();
			String revisionID = universePOJO.getXtentisObjectsRevisionIDs().get(objectType);
			wsObjectsToRevisionIDs.add(new WSUniverseXtentisObjectsRevisionIDs(objectType, revisionID));
		}
		ws.setXtentisObjectsRevisionIDs(wsObjectsToRevisionIDs.toArray(new WSUniverseXtentisObjectsRevisionIDs[wsObjectsToRevisionIDs.size()]));
		//default items
		ws.setDefaultItemsRevisionID(universePOJO.getDefaultItemRevisionID());
		//items
		Set<String> patterns = universePOJO.getItemsRevisionIDs().keySet();
		ArrayList<WSUniverseItemsRevisionIDs> wsItemsToRevisionIDs = new ArrayList<WSUniverseItemsRevisionIDs>();
		for (Iterator<String> iter = patterns.iterator(); iter.hasNext(); ) {
			String pattern = iter.next();
			String revisionID = universePOJO.getItemsRevisionIDs().get(pattern);
			wsItemsToRevisionIDs.add(new WSUniverseItemsRevisionIDs(pattern, revisionID));
		}
		ws.setItemsRevisionIDs(wsItemsToRevisionIDs.toArray(new WSUniverseItemsRevisionIDs[wsItemsToRevisionIDs.size()]));
		return ws;
	}

	
	
	private UniversePOJO WS2POJO(WSUniverse wsUniverse) throws Exception{
		UniversePOJO pojo = new UniversePOJO();
		pojo.setName(wsUniverse.getName());
		pojo.setDescription(wsUniverse.getDescription());
		//Xtentis Objects
		HashMap<String,String> xtentisObjectsRevisionIDs = new HashMap<String, String>();
		if (wsUniverse.getXtentisObjectsRevisionIDs()!=null) {
			for (int i = 0; i < wsUniverse.getXtentisObjectsRevisionIDs().length; i++) {
				xtentisObjectsRevisionIDs.put(
					wsUniverse.getXtentisObjectsRevisionIDs()[i].getXtentisObjectName(),
					wsUniverse.getXtentisObjectsRevisionIDs()[i].getRevisionID()
				);
			}//for specifications
		}
		pojo.setXtentisObjectsRevisionIDs(xtentisObjectsRevisionIDs);
		//Default Items
		pojo.setDefaultItemRevisionID(wsUniverse.getDefaultItemsRevisionID());
		//Items
		LinkedHashMap<String,String> itemRevisionIDs = new LinkedHashMap<String, String>();
		if (wsUniverse.getItemsRevisionIDs()!=null) {
			for (int i = 0; i < wsUniverse.getItemsRevisionIDs().length; i++) {
				itemRevisionIDs.put(
					wsUniverse.getItemsRevisionIDs()[i].getConceptPattern(),
					wsUniverse.getItemsRevisionIDs()[i].getRevisionID()
				);
			}//for specifications
		}
		pojo.setItemsRevisionIDs(itemRevisionIDs);
		return pojo;
	}
	
	
	/***************************************************************************
	 * Syncronization Plan
	 ***************************************************************************/
	
	public WSSynchronizationPlanPK deleteSynchronizationPlan(WSDeleteSynchronizationPlan wsSynchronizationPlanDelete) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			return
				new WSSynchronizationPlanPK(
					ctrl.removeSynchronizationPlan(
						new SynchronizationPlanPOJOPK(
								wsSynchronizationPlanDelete.getWsSynchronizationPlanPK().getPk()
						)
					).getUniqueId()
				);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSBoolean existsSynchronizationPlan(WSExistsSynchronizationPlan wsExistsSynchronizationPlan) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			SynchronizationPlanPOJO pojo =
				ctrl.existsSynchronizationPlan(
					new SynchronizationPlanPOJOPK(
							wsExistsSynchronizationPlan.getWsSynchronizationPlanPK().getPk()
					)
				);
			return new WSBoolean(pojo!=null);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	public WSStringArray getSynchronizationPlanItemsAlgorithms(WSGetSynchronizationPlanItemsAlgorithms regex) throws RemoteException {
		Set<String> names = SynchronizationPlanPOJO.getItemsAlgorithmNames(); 
		return new WSStringArray(
				names.toArray(new String[names.size()])
		);
	}
	
	public WSStringArray getSynchronizationPlanObjectsAlgorithms(WSGetSynchronizationPlanObjectsAlgorithms regex) throws RemoteException {
		Set<String> names = SynchronizationPlanPOJO.getObjectsAlgorithmNames(); 
		return new WSStringArray(
				names.toArray(new String[names.size()])
		);
	}

	
	public WSSynchronizationPlan getSynchronizationPlan(WSGetSynchronizationPlan wsGetSynchronizationPlan) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			SynchronizationPlanPOJO pojo =
				ctrl.getSynchronizationPlan(
					new SynchronizationPlanPOJOPK(
							wsGetSynchronizationPlan.getWsSynchronizationPlanPK().getPk()
					)
				);
			return POJO2WS(pojo);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSStringArray getObjectsForSynchronizationPlans(WSGetObjectsForSynchronizationPlans regex) throws RemoteException {
		try {
			
			Set<String> names = SynchronizationPlanPOJO.getXtentisObjectNames(); 
			return new WSStringArray(
					names.toArray(new String[names.size()])
			);
			
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationPlanPKArray getSynchronizationPlanPKs(WSGetSynchronizationPlanPKs regex) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			Collection c =
				ctrl.getSynchronizationPlanPKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSSynchronizationPlanPK[] pks = new WSSynchronizationPlanPK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSSynchronizationPlanPK(
						((SynchronizationPlanPOJOPK) iter.next()).getUniqueId()
				);
			}
			return new WSSynchronizationPlanPKArray(pks);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationPlanPK putSynchronizationPlan(WSPutSynchronizationPlan wsSynchronizationPlan) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			SynchronizationPlanPOJOPK pk =
				ctrl.putSynchronizationPlan(
					WS2POJO(wsSynchronizationPlan.getWsSynchronizationPlan())
				);
			return new WSSynchronizationPlanPK(pk.getUniqueId());
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (RemoteException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationPlanStatus synchronizationPlanAction(WSSynchronizationPlanAction wsSynchronizationPlanAction) throws RemoteException {
		try {
			
			int actionCode = -1;
			if (WSSynchronizationPlanActionCode.START_FULL.equals(wsSynchronizationPlanAction.getWsAction())) {
				actionCode = SynchronizationPlanPOJO.ACTION_START_FULL;
			} else if (WSSynchronizationPlanActionCode.START_DIFFERENTIAL.equals(wsSynchronizationPlanAction.getWsAction())) {
				actionCode = SynchronizationPlanPOJO.ACTION_START_DIFFERENTIAL;
			} else if (WSSynchronizationPlanActionCode.STOP.equals(wsSynchronizationPlanAction.getWsAction())) {
				actionCode = SynchronizationPlanPOJO.ACTION_STOP;
			} else if (WSSynchronizationPlanActionCode.STATUS.equals(wsSynchronizationPlanAction.getWsAction())) {
				actionCode = SynchronizationPlanPOJO.ACTION_GET_STATUS;
			} else if (WSSynchronizationPlanActionCode.RESET.equals(wsSynchronizationPlanAction.getWsAction())) {
				actionCode = SynchronizationPlanPOJO.ACTION_RESET;
			}
			
			SynchronizationPlanCtrlLocal ctrl = SynchronizationPlanCtrlUtil.getLocalHome().create();
			String[] res = ctrl.action(
				actionCode, 
				new SynchronizationPlanPOJOPK(wsSynchronizationPlanAction.getWsSynchronizationPlanPK().getPk())
			);
			String statusCode = res[0];
			String statusMsg = res[1];
			long lastRunStartedMillis = Long.parseLong(res[2]);
			long lastRunStoppedMillis = Long.parseLong(res[3]);
				
			Calendar lastRunStarted = Calendar.getInstance();
			lastRunStarted.setTimeInMillis(lastRunStartedMillis);
			
			Calendar lastRunStopped = Calendar.getInstance();
			lastRunStopped.setTimeInMillis(lastRunStoppedMillis);
			
			WSSynchronizationPlanStatusCode wsStatusCode = null;
			if (SynchronizationPlanPOJO.STATUS_COMPLETED.equals(statusCode)) {
				wsStatusCode = WSSynchronizationPlanStatusCode.COMPLETED;
			} else if (SynchronizationPlanPOJO.STATUS_FAILED.equals(statusCode)) {
				wsStatusCode = WSSynchronizationPlanStatusCode.FAILED;
			} else if (SynchronizationPlanPOJO.STATUS_RUNNING.equals(statusCode)) {
				wsStatusCode = WSSynchronizationPlanStatusCode.RUNNING;
			} else if (SynchronizationPlanPOJO.STATUS_SCHEDULED.equals(statusCode)) {
				wsStatusCode = WSSynchronizationPlanStatusCode.SCHEDULED;
			} else if (SynchronizationPlanPOJO.STATUS_STOPPING.equals(statusCode)) {
				wsStatusCode = WSSynchronizationPlanStatusCode.STOPPING;
			}
				
				
			return new WSSynchronizationPlanStatus(
				wsStatusCode, 
				statusMsg,
				lastRunStarted,
				lastRunStopped
			);
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	private WSSynchronizationPlan POJO2WS(SynchronizationPlanPOJO synchronizationPlanPOJO) throws Exception{
		WSSynchronizationPlan ws = new WSSynchronizationPlan();
		ws.setName(synchronizationPlanPOJO.getName());
		ws.setDescription(synchronizationPlanPOJO.getDescription());
		ws.setRemoteSystemName(synchronizationPlanPOJO.getRemoteSystemName());
		ws.setRemoteSystemURL(synchronizationPlanPOJO.getRemoteSystemURL());
		ws.setRemoteSystemUsername(synchronizationPlanPOJO.getRemoteSystemUsername());
		ws.setRemoteSystemPassword(synchronizationPlanPOJO.getRemoteSystemPassword());
		ws.setTisURL(synchronizationPlanPOJO.getTisURL());
		ws.setTisUsername(synchronizationPlanPOJO.getTisUsername());
		ws.setTisPassword(synchronizationPlanPOJO.getTisPassword());
		ws.setTisParameters(synchronizationPlanPOJO.getTisParameters());
		//objects
		Set<String> objectNames = synchronizationPlanPOJO.getXtentisObjectsSynchronizations().keySet();
		ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizations> wsObjectsSynchroTables = new ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizations>();
		for (Iterator<String> iter = objectNames.iterator(); iter.hasNext(); ) {
			String objectType = iter.next();
			
			ArrayListHolder<SynchronizationPlanObjectLine> linesMap = synchronizationPlanPOJO.getXtentisObjectsSynchronizations().get(objectType);
			ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations> wsLines = new ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations>();
			for (Iterator<SynchronizationPlanObjectLine> iterator2 = linesMap.getList().iterator(); iterator2.hasNext(); ) {
				SynchronizationPlanObjectLine line = iterator2.next();
				wsLines.add(new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations(
					line.getInstancePattern(), 
					line.getSourceRevisionID(), 
					line.getDestinationRevisionID(), 
					line.getAlgorithm()
				));
			}
			wsObjectsSynchroTables.add(new WSSynchronizationPlanXtentisObjectsSynchronizations(
				objectType,
				wsLines.toArray(new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations[wsLines.size()])
			));
		}
		ws.setXtentisObjectsSynchronizations(wsObjectsSynchroTables.toArray(new WSSynchronizationPlanXtentisObjectsSynchronizations[wsObjectsSynchroTables.size()]));
		
		//items
		ArrayList<WSSynchronizationPlanItemsSynchronizations> wsItemsSynchroTable = new ArrayList<WSSynchronizationPlanItemsSynchronizations>();
		for (Iterator<SynchronizationPlanItemLine> iter = synchronizationPlanPOJO.getItemsSynchronizations().iterator(); iter.hasNext(); ) {
			SynchronizationPlanItemLine line = iter.next();
			wsItemsSynchroTable.add(new WSSynchronizationPlanItemsSynchronizations(
				line.getConceptName(),
				line.getIdsPattern(),
				line.getLocalClusterPOJOPK().getUniqueId(),
				line.getLocalRevisionID(),
				line.getRemoteClusterPOJOPK().getUniqueId(),
				line.getRemoteRevisionID(),
				line.getAlgorithm()
			));
		}
		ws.setItemsSynchronizations(wsItemsSynchroTable.toArray(new WSSynchronizationPlanItemsSynchronizations[wsItemsSynchroTable.size()]));
		
		//Current statuses are obtained using action(GET_STATUS)
//		Calendar lastRunStartedCalendar = Calendar.getInstance();
//		lastRunStartedCalendar.setTimeInMillis(synchronizationPlanPOJO.getLastRunStarted());
//		ws.setLastRunStarted(lastRunStartedCalendar);
//		
//		Calendar lastRunStoppedCalendar = Calendar.getInstance();
//		lastRunStoppedCalendar.setTimeInMillis(synchronizationPlanPOJO.getLastRunStopped());
//		ws.setLastRunStopped(lastRunStoppedCalendar);
//		
//		String statusCode  = synchronizationPlanPOJO.getCurrentStatusCode();
//		WSSynchronizationPlanStatusCode wsStatusCode = null;
//		if (SynchronizationPlanPOJO.STATUS_COMPLETED.equals(statusCode)) {
//			wsStatusCode = WSSynchronizationPlanStatusCode.COMPLETED;
//		} else if (SynchronizationPlanPOJO.STATUS_FAILED.equals(statusCode)) {
//			wsStatusCode = WSSynchronizationPlanStatusCode.FAILED;
//		} else if (SynchronizationPlanPOJO.STATUS_RUNNING.equals(statusCode)) {
//			wsStatusCode = WSSynchronizationPlanStatusCode.RUNNING;
//		} else if (SynchronizationPlanPOJO.STATUS_SCHEDULED.equals(statusCode)) {
//			wsStatusCode = WSSynchronizationPlanStatusCode.SCHEDULED;
//		} else if (SynchronizationPlanPOJO.STATUS_STOPPING.equals(statusCode)) {
//			wsStatusCode = WSSynchronizationPlanStatusCode.STOPPING;
//		}
//		
//		ws.setWsCurrentStatusCode(wsStatusCode);
//		ws.setCurrentStatusMessage(synchronizationPlanPOJO.getCurrentStatusMessage());
		
		return ws;
	}

	
	
	private SynchronizationPlanPOJO WS2POJO(WSSynchronizationPlan wsSynchronizationPlan) throws Exception{
		SynchronizationPlanPOJO pojo = new SynchronizationPlanPOJO();
		pojo.setName(wsSynchronizationPlan.getName());
		pojo.setDescription(wsSynchronizationPlan.getDescription());
		pojo.setRemoteSystemName(wsSynchronizationPlan.getRemoteSystemName());
		pojo.setRemoteSystemURL(wsSynchronizationPlan.getRemoteSystemURL());
		pojo.setRemoteSystemUsername(wsSynchronizationPlan.getRemoteSystemUsername());
		pojo.setRemoteSystemPassword(wsSynchronizationPlan.getRemoteSystemPassword());
		pojo.setTisURL(wsSynchronizationPlan.getTisURL());
		pojo.setTisUsername(wsSynchronizationPlan.getTisUsername());
		pojo.setTisPassword(wsSynchronizationPlan.getTisPassword());
		pojo.setTisParameters(wsSynchronizationPlan.getTisParameters());
		
		//Xtentis Objects
		HashMap<String, ArrayListHolder<SynchronizationPlanObjectLine>> xtentisObjectsSynchronizations = new HashMap<String, ArrayListHolder<SynchronizationPlanObjectLine>>();
		WSSynchronizationPlanXtentisObjectsSynchronizations[] wsTables = wsSynchronizationPlan.getXtentisObjectsSynchronizations();
		if (wsTables != null) {
			for (int i = 0; i < wsTables.length; i++) {
				WSSynchronizationPlanXtentisObjectsSynchronizations wsTable = wsTables[i];
				ArrayListHolder<SynchronizationPlanObjectLine> objectLines = new ArrayListHolder<SynchronizationPlanObjectLine>();
				WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations[] wsSynchronizations = wsTable.getSynchronizations();
				if (wsSynchronizations != null) {
					for (int j = 0; j < wsSynchronizations.length; j++) {
						objectLines.getList().add(
							new SynchronizationPlanObjectLine(
								wsSynchronizations[j].getInstancePattern(), 
								wsSynchronizations[j].getLocalRevisionID(),
								wsSynchronizations[j].getRemoteRevisionID(),
								wsSynchronizations[j].getAlgorithm()
							)
						);
					}
				}
				xtentisObjectsSynchronizations.put(wsTable.getXtentisObjectName(), objectLines);
			}
		}
		pojo.setXtentisObjectsSynchronizations(xtentisObjectsSynchronizations);
		
		//Items
		ArrayList<SynchronizationPlanItemLine> patternsMap = new ArrayList<SynchronizationPlanItemLine>();
		WSSynchronizationPlanItemsSynchronizations[] wsSynchronizations = wsSynchronizationPlan.getItemsSynchronizations();
		if (wsSynchronizations != null) {
			for (int j = 0; j < wsSynchronizations.length; j++) {
				patternsMap.add(
					new SynchronizationPlanItemLine(
						wsSynchronizations[j].getConceptName(),
						wsSynchronizations[j].getIdsPattern(),
						new DataClusterPOJOPK(wsSynchronizations[j].getLocalCluster()),
						wsSynchronizations[j].getLocalRevisionID(),
						new DataClusterPOJOPK(wsSynchronizations[j].getRemoteCluster()),
						wsSynchronizations[j].getRemoteRevisionID(),
						wsSynchronizations[j].getAlgorithm()
					)
				);
			}
		}
		pojo.setItemsSynchronizations(patternsMap);

		
		//Current statuses and messages cannot be set from "outside"
		
//		//status code
//		if (WSSynchronizationPlanStatusCode.COMPLETED.equals(wsSynchronizationPlan.getWsCurrentStatusCode())) {
//			pojo.setCurrentStatusCode(SynchronizationPlanPOJO.STATUS_COMPLETED);
//		} else if (WSSynchronizationPlanStatusCode.FAILED.equals(wsSynchronizationPlan.getWsCurrentStatusCode())) {
//			pojo.setCurrentStatusCode(SynchronizationPlanPOJO.STATUS_FAILED);
//		} else if (WSSynchronizationPlanStatusCode.RUNNING.equals(wsSynchronizationPlan.getWsCurrentStatusCode())) {
//			pojo.setCurrentStatusCode(SynchronizationPlanPOJO.STATUS_RUNNING);
//		} else if (WSSynchronizationPlanStatusCode.SCHEDULED.equals(wsSynchronizationPlan.getWsCurrentStatusCode())) {
//			pojo.setCurrentStatusCode(SynchronizationPlanPOJO.STATUS_SCHEDULED);
//		} else if (WSSynchronizationPlanStatusCode.STOPPING.equals(wsSynchronizationPlan.getWsCurrentStatusCode())) {
//			pojo.setCurrentStatusCode(SynchronizationPlanPOJO.STATUS_STOPPING);
//		}  
//		
//		//status message
//		pojo.setCurrentStatusMessage(wsSynchronizationPlan.getCurrentStatusMessage());
//		
//		//times
//		pojo.setLastRunStarted(wsSynchronizationPlan.getLastRunStarted().getTimeInMillis());
//		pojo.setLastRunStopped(wsSynchronizationPlan.getLastRunStopped().getTimeInMillis());
		
		
		return pojo;
	}
	
	
	public WSStringArray synchronizationGetUnsynchronizedObjectsIDs(WSSynchronizationGetUnsynchronizedObjectsIDs wsSynchronizationGetUnsynchronizedObjectsIDs) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			ArrayList<String> list = ctrl.synchronizationGetAllUnsynchronizedObjectsIDs(
				wsSynchronizationGetUnsynchronizedObjectsIDs.getRevisionID(), 
				wsSynchronizationGetUnsynchronizedObjectsIDs.getObjectName(), 
				wsSynchronizationGetUnsynchronizedObjectsIDs.getInstancePattern(), 
				wsSynchronizationGetUnsynchronizedObjectsIDs.getSynchronizationPlanName()
			);
			
			return new WSStringArray(list.toArray(new String[list.size()]));
			
			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSString synchronizationGetObjectXML(WSSynchronizationGetObjectXML wsSynchronizationGetObjectXML) throws RemoteException {
		try {
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			String xml = ctrl.synchronizationGetMarshaledObject(
				wsSynchronizationGetObjectXML.getRevisionID(), 
				wsSynchronizationGetObjectXML.getObjectName(), 
				wsSynchronizationGetObjectXML.getUniqueID()
			);
			return new WSString(xml);			
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}

	
	public WSString synchronizationPutObjectXML(WSSynchronizationPutObjectXML wsSynchronizationPutObjectXML) throws RemoteException {
		try {
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			ctrl.synchronizationPutMarshaledObject(
				wsSynchronizationPutObjectXML.getRevisionID(), 
				wsSynchronizationPutObjectXML.getObjectName(), 
				wsSynchronizationPutObjectXML.getUniqueID(),
				wsSynchronizationPutObjectXML.getXml()
			);
			return new WSString(System.currentTimeMillis()+"");

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	public WSItemPKArray synchronizationGetUnsynchronizedItemPKs(WSSynchronizationGetUnsynchronizedItemPKs wsSynchronizationGetUnsynchronizedItemPKs) throws RemoteException {
		try {
			
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			ArrayList<ItemPOJOPK> list = ctrl.synchronizationGetAllUnsynchronizedItemPOJOPKs(
				wsSynchronizationGetUnsynchronizedItemPKs.getRevisionID(),
				new DataClusterPOJOPK(wsSynchronizationGetUnsynchronizedItemPKs.getWsDataClusterPOJOPK().getPk()),
				wsSynchronizationGetUnsynchronizedItemPKs.getConceptName(), 
				wsSynchronizationGetUnsynchronizedItemPKs.getInstancePattern(), 
				new SynchronizationPlanPOJOPK(wsSynchronizationGetUnsynchronizedItemPKs.getSynchronizationPlanName()),
				wsSynchronizationGetUnsynchronizedItemPKs.getStart(),
				wsSynchronizationGetUnsynchronizedItemPKs.getLimit()
			);
			
			ArrayList<WSItemPK> result = new ArrayList<WSItemPK>();
			for (Iterator<ItemPOJOPK> iterator = list.iterator(); iterator.hasNext(); ) {
				ItemPOJOPK itemPOJOPK = iterator.next();
				result.add(POJO2WS(itemPOJOPK));
			}
			
			return new WSItemPKArray(result.toArray(new WSItemPK[result.size()]));

		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSString synchronizationGetItemXML(WSSynchronizationGetItemXML wsSynchronizationGetItemXML) throws RemoteException {
		try {
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			String xml = ctrl.synchronizationGetMarshaledItem(
				wsSynchronizationGetItemXML.getRevisionID(), 
				WS2POJO(wsSynchronizationGetItemXML.getWsItemPOJOPK())
			);
			return new WSString(xml);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSItemPK synchronizationPutItemXML(WSSynchronizationPutItemXML wsSynchronizationPutItemXML) throws RemoteException {
		try {
			SynchronizationPlanCtrlLocal ctrl = Util.getSynchronizationPlanCtrlLocal();
			ItemPOJOPK pojoPK = ctrl.synchronizationPutMarshaledItem(
				wsSynchronizationPutItemXML.getRevisionID(), 
				wsSynchronizationPutItemXML.getXml()
			);
			return POJO2WS(pojoPK);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	
	/***************************************************************************
	 * Synchronization Item
	 * **************************************************************************/
	
	public WSSynchronizationItemPK deleteSynchronizationItem(WSDeleteSynchronizationItem wsSynchronizationItemDelete) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			
			SynchronizationItemPOJOPK pojoPK = ctrl.removeSynchronizationItem(
				new SynchronizationItemPOJOPK(wsSynchronizationItemDelete.getWsSynchronizationItemPK().getIds())
			);
			return new WSSynchronizationItemPK(pojoPK.getIds());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationItem getSynchronizationItem(WSGetSynchronizationItem wsGetSynchronizationItem) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			SynchronizationItemPOJO pojo =
				ctrl.getSynchronizationItem(
					new SynchronizationItemPOJOPK(wsGetSynchronizationItem.getWsSynchronizationItemPK().getIds())
				);
			return POJO2WS(pojo);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSBoolean existsSynchronizationItem(WSExistsSynchronizationItem wsExistsSynchronizationItem) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			SynchronizationItemPOJO pojo =
				ctrl.existsSynchronizationItem(
					new SynchronizationItemPOJOPK(wsExistsSynchronizationItem.getWsSynchronizationItemPK().getIds())
				);
			return new WSBoolean(pojo!=null);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationItemPKArray getSynchronizationItemPKs(WSGetSynchronizationItemPKs regex) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			Collection c =
				ctrl.getSynchronizationItemPKs(
					regex.getRegex()
				);
			if (c==null) return null;
			WSSynchronizationItemPK[] pks = new WSSynchronizationItemPK[c.size()];
			int i=0;
			for (Iterator iter = c.iterator(); iter.hasNext(); ) {
				pks[i++] = new WSSynchronizationItemPK(((SynchronizationItemPOJOPK) iter.next()).getIds());
			}
			return new WSSynchronizationItemPKArray(pks);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationItemPK putSynchronizationItem(WSPutSynchronizationItem wsSynchronizationItem) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			SynchronizationItemPOJOPK pk =
				ctrl.putSynchronizationItem(
					WS2POJO(wsSynchronizationItem.getWsSynchronizationItem())
				);
			return new WSSynchronizationItemPK(pk.getIds());
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	public WSSynchronizationItem resolveSynchronizationItem(WSResolveSynchronizationItem wsResolveSynchronizationItem) throws RemoteException {
		try {
			SynchronizationItemCtrlLocal ctrl = Util.getSynchronizationItemCtrlLocal();
			SynchronizationItemPOJO pojo =
				ctrl.resolveSynchronization(
					new SynchronizationItemPOJOPK(wsResolveSynchronizationItem.getWsSynchronizationItemPK().getIds()),
					wsResolveSynchronizationItem.getNewProjection()
				);
			return POJO2WS(pojo);
		} catch (com.amalto.core.util.XtentisException e) {
			throw(new RemoteException(e.getLocalizedMessage()));
//		} catch (RemoteException e) {
//			throw(new RemoteException(e.getLocalizedMessage()));
		} catch (Exception e) {
			throw new RemoteException((e.getCause() == null ? e.getLocalizedMessage() : e.getCause().getLocalizedMessage()));
		}
	}
	
	private WSSynchronizationItem POJO2WS(SynchronizationItemPOJO synchronizationItemPOJO) throws Exception{
		WSSynchronizationItem ws = new WSSynchronizationItem();
		ws.setLastRunPlan(synchronizationItemPOJO.getLastRunPlan());
		ws.setLocalRevisionID(synchronizationItemPOJO.getLocalRevisionID());
		ws.setResolvedProjection(synchronizationItemPOJO.getResolvedProjection());
		ws.setWsItemPK(POJO2WS(synchronizationItemPOJO.getItemPOJOPK()));

		switch (synchronizationItemPOJO.getStatus()) {
			case SynchronizationItemPOJO.STATUS_EXECUTED:
				ws.setStatus(WSSynchronizationItemStatus.EXECUTED);
				break;
			case SynchronizationItemPOJO.STATUS_MANUAL:
				ws.setStatus(WSSynchronizationItemStatus.MANUAL);
				break;
			case SynchronizationItemPOJO.STATUS_PENDING:
				ws.setStatus(WSSynchronizationItemStatus.PENDING);
				break;
			case SynchronizationItemPOJO.STATUS_RESOLVED:
				ws.setStatus(WSSynchronizationItemStatus.RESOLVED);
				break;
		}
		

		//remote instances
		ArrayList<WSSynchronizationItemRemoteInstances> wsInstances = new ArrayList<WSSynchronizationItemRemoteInstances>();
		for (SynchronizationRemoteInstance instance : synchronizationItemPOJO.getRemoteIntances().values()) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(instance.getLastLocalSynchronizationTime());
			WSSynchronizationItemRemoteInstances wsInstance = new WSSynchronizationItemRemoteInstances(
				instance.getRemoteSystemName(),
				instance.getRevisionID(),
				instance.getXml(),
				cal
			);
			wsInstances.add(wsInstance);
		}
		ws.setRemoteInstances(wsInstances.toArray(new WSSynchronizationItemRemoteInstances[wsInstances.size()]));
				
		return ws;
	}

	
	
	private SynchronizationItemPOJO WS2POJO(WSSynchronizationItem wsSynchronizationItem) throws Exception{
		SynchronizationItemPOJO pojo = new SynchronizationItemPOJO();
		pojo.setItemPOJOPK(WS2POJO(wsSynchronizationItem.getWsItemPK()));
		pojo.setLastRunPlan(wsSynchronizationItem.getLastRunPlan());
		pojo.setLocalRevisionID(wsSynchronizationItem.getLocalRevisionID());
		pojo.setResolvedProjection(wsSynchronizationItem.getResolvedProjection());
		
		if (WSSynchronizationItemStatus.EXECUTED.equals(wsSynchronizationItem.getStatus())) {
			pojo.setStatus(SynchronizationItemPOJO.STATUS_EXECUTED);
		} else if (WSSynchronizationItemStatus.MANUAL.equals(wsSynchronizationItem.getStatus())) {
			pojo.setStatus(SynchronizationItemPOJO.STATUS_MANUAL);
		} else if (WSSynchronizationItemStatus.PENDING.equals(wsSynchronizationItem.getStatus())) {
			pojo.setStatus(SynchronizationItemPOJO.STATUS_PENDING);
		} else if (WSSynchronizationItemStatus.RESOLVED.equals(wsSynchronizationItem.getStatus())) {
			pojo.setStatus(SynchronizationItemPOJO.STATUS_RESOLVED);
		} 

		HashMap<String,SynchronizationRemoteInstance> instances = new HashMap<String,SynchronizationRemoteInstance>();
		WSSynchronizationItemRemoteInstances[] wsInstances = wsSynchronizationItem.getRemoteInstances();
		if (wsInstances != null) {
			for (int i = 0; i < wsInstances.length; i++) {
				SynchronizationRemoteInstance instance = new SynchronizationRemoteInstance(
					wsInstances[i].getRemoteSystemName(),
					wsInstances[i].getRemoteRevisionID(),
					wsInstances[i].getXml(),
					wsInstances[i].getLastLocalSynchronizationTime().getTimeInMillis()
				);
				instances.put(instance.getKey(), instance);
			}
		}
		pojo.setRemoteIntances(instances);
		return pojo;
	}

	
}
