package talend.ext.service.handle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import talend.ext.service.dao.ServiceSchedulPlanDAO;
import talend.ext.service.dao.ServiceSchedulePlanDAOImpl;
import talend.ext.service.entity.SrvSchedulePlan;
import talend.ext.service.entity.SrvSchedulePlanStatus;
import talend.ext.service.schedule.SrvScheduleException;
import talend.ext.service.schedule.SrvScheduleManager;
import talend.ext.service.template.ITemplateHandler;
import talend.ext.service.template.TemplateFillAssistant;
import talend.ext.service.util.AvailableMethodList;
import talend.ext.service.util.CommonUtil;
import talend.ext.service.view.ComboItemBean;

import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;
import com.amalto.webapp.core.bean.ListRange;

public class SrvScheduleDWR {
	
	private static Logger logger = Logger.getLogger(SrvScheduleDWR.class);
	
	public String invokeService(String serviceName, String methodName,String parameters) throws XtentisException {

		parameters=parameters.trim();
		String rtn = SrvScheduleManager.invoke(serviceName, methodName, parameters);

		return rtn;

	}
	
	public ListRange getRuntimeServiceNames() {
		
		ListRange listRange = new ListRange();
		
		List<ComboItemBean> serviceNames=new ArrayList<ComboItemBean>();
		List<String> getServiceNames=Util.getRuntimeServiceJndiList(false);
		for (Iterator<String> iterator = getServiceNames.iterator(); iterator.hasNext();) {
			String serviceName = iterator.next();
			serviceNames.add(new ComboItemBean(serviceName,serviceName));
		}
		
		listRange.setData(serviceNames.toArray());
		listRange.setTotalSize(serviceNames.size());

		return listRange;
	}
	
    public ListRange getAvailableMethodNames() {
		
		ListRange listRange = new ListRange();
		
		List<ComboItemBean> methodNames=new ArrayList<ComboItemBean>();
		List<String> getMethodNames=AvailableMethodList.methods;
		for (Iterator<String> iterator = getMethodNames.iterator(); iterator.hasNext();) {
			String methodName = iterator.next();
			methodNames.add(new ComboItemBean(methodName,methodName));
		}
		
		listRange.setData(methodNames.toArray());
		listRange.setTotalSize(methodNames.size());

		return listRange;
	}
    
    public String loadParameterTemplate(String serviceName,String methodName) throws Exception {
		
    	ITemplateHandler iTemplateHandler = CommonUtil.getMethodTemplateHandler(methodName);
    	return iTemplateHandler.getContent(serviceName);
    	
	}
    
     public String reloadParameterTemplate(String serviceName,String methodName,String schedulePlanId) throws Exception {
		
    	ITemplateHandler iTemplateHandler = CommonUtil.getMethodTemplateHandler(methodName);
    	String lawContent=iTemplateHandler.getContent(serviceName);
    	return TemplateFillAssistant.fill(serviceName, methodName, lawContent, schedulePlanId);
	}
    
    public String getServiceSchedulerStatus() {
    	
    	return SrvScheduleManager.getSrvSchedulerStatus();

	}
    
    public void startServiceScheduler() {
		
    	SrvScheduleManager.startDefaultScheduler();

	}
    
    public void standbyServiceScheduler() {
		
    	SrvScheduleManager.standbyDefaultScheduler();

	}
    
    public void shutdownServiceScheduler() {
		
    	SrvScheduleManager.shutdownDefaultScheduler();

	}
    
    private String[] saveServiceSchedulePlan(SrvSchedulePlan srvSchedulePlan) {
    	
    	String[] rtn={"",SrvSchedulePlanStatus.UNSCHEDULE};
    	
    	ServiceSchedulPlanDAO serviceSchedulPlanDAO=new ServiceSchedulePlanDAOImpl();
    	boolean isSaveOK=serviceSchedulPlanDAO.savePlan(srvSchedulePlan);
    	if(isSaveOK){
    		String serviceSchedulePlanId=srvSchedulePlan.obtainSrvSchedulePlanPk().getUniqueId();
    		rtn[0]=serviceSchedulePlanId;
    	}
    	
    	return rtn;

	}
    
   public String[] saveServiceSchedulePlan(String schedulePlanId,String schedulePlanStatus,String schedulePlanDesc,String serviceName,String methodName,String parameters,String mode) {
	    
	    if(schedulePlanStatus!=null&&schedulePlanStatus.trim().equals(""))schedulePlanStatus=SrvSchedulePlanStatus.UNSCHEDULE;
	    SrvSchedulePlan srvSchedulePlan=new SrvSchedulePlan(schedulePlanId,schedulePlanStatus,schedulePlanDesc,serviceName,methodName,parameters,mode);
    
    	return saveServiceSchedulePlan(srvSchedulePlan);

	}
   
   public boolean scheduleServiceSchedulePlan(String serviceSchedulePlanId,String serviceName,String methodName,String parameters,String mode) throws SrvScheduleException{
	   
	   //TODO UPDATE STATUS IN DB
	   return SrvScheduleManager.scheduleJob(serviceSchedulePlanId, serviceName, methodName, parameters, mode);
   
   }
   
   public boolean unScheduleServiceSchedulePlan(String serviceSchedulePlanId) {
	   
	   //TODO UPDATE STATUS IN DB
	   return SrvScheduleManager.removeJob(serviceSchedulePlanId);
   
   }
	

}
