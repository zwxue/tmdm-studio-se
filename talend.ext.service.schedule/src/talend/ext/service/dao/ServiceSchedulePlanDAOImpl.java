package talend.ext.service.dao;

import java.io.StringWriter;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.Marshaller;

import com.amalto.core.ejb.local.XmlServerSLWrapperLocal;
import com.amalto.core.ejb.local.XmlServerSLWrapperLocalHome;

import talend.ext.service.entity.SrvSchedulePlan;

public class ServiceSchedulePlanDAOImpl implements ServiceSchedulPlanDAO{
	
	private static final String PLAN_CLUSTER_NAME = "MDMServiceSchedulePlans";
	
    private Logger logger = Logger.getLogger(this.getClass());
	
	private XmlServerSLWrapperLocal server;
	
	public ServiceSchedulePlanDAOImpl() {
		try {
			server = ((XmlServerSLWrapperLocalHome)new InitialContext().lookup(XmlServerSLWrapperLocalHome.JNDI_NAME)).create();
		} catch (Exception e) {
			String err = "Unable to access the XML Server wrapper";
			logger.error(err,e);
		}
	}

	public boolean savePlan(SrvSchedulePlan srvSchedulePlan) {

        try {
        	//Marshal
    		StringWriter sw = new StringWriter();
    		Marshaller.marshal(srvSchedulePlan, sw);
    		
			long rtnStatus=server.putDocumentFromString(sw.toString(), srvSchedulePlan.obtainSrvSchedulePlanPk().getUniqueId(), PLAN_CLUSTER_NAME, null);
			if(rtnStatus==-1){
				return false;
			}else{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
