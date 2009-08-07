package talend.ext.service.schedule;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import talend.ext.service.util.CommonUtil;

import com.amalto.core.util.XtentisException;

public class SrvScheduleManager {
	
	private static Logger logger = Logger.getLogger(SrvScheduleManager.class);
	
	private static final String SERVICE_DEfAULT_GROUP = "ServiceDefaultGroup";

	public static String invoke(String serviceName, String methodName,
			String parameters) throws XtentisException {

		String rtn = CommonUtil.invokeService(serviceName, methodName, parameters);

		return rtn;

	}
	
	public static String getSrvSchedulerStatus() {
		
		return SrvScheduleLogicStatusManager.getUniqueInstance().getStatus();
	}
	
	public static boolean startDefaultScheduler() {
		try {
		  Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		  sched.start();
		  
		  //TODO schedule history jobs
		  if(SrvScheduleLogicStatusManager.isInitial()){
			  logger.debug("Load and scheduling history jobs... ");
		  }
		  
		  SrvScheduleLogicStatusManager.updateStatus(SrvScheduleLogicStatusManager.STARTED);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean standbyDefaultScheduler() {
		try {
		  Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		  sched.standby();
		  SrvScheduleLogicStatusManager.updateStatus(SrvScheduleLogicStatusManager.PAUSED);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean shutdownDefaultScheduler() {
		try {
		  Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		  //sched.shutdown(true);
		  sched.shutdown(false);
		  SrvScheduleLogicStatusManager.updateStatus(SrvScheduleLogicStatusManager.STOPPED);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean scheduleJob(String jobName,String serviceName, String methodName,String parameters, String mode) throws SrvScheduleException{
		
		try {
			
			String token =jobName.substring(4);
			String triggerName="Trigger."+token;
			
			JobDetail jd = new JobDetail(jobName, SERVICE_DEfAULT_GROUP,ServiceJob.class);
			

			jd.getJobDataMap().put("serviceName",serviceName);
			jd.getJobDataMap().put("methodName", methodName);
			jd.getJobDataMap().put("parameters", parameters);
			
			CronTrigger cronTrigger = new CronTrigger(triggerName,SERVICE_DEfAULT_GROUP);

			String cronExpr = null;
			// Get the cron Expression
			cronExpr = mode;
			cronTrigger.setCronExpression(cronExpr);
			Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
			
			//check logical status
			if(!getSrvSchedulerStatus().equals(SrvScheduleLogicStatusManager.STARTED)){
				throw new SrvScheduleException("Service Scheduler has not been started! ");
			}
			
			sched.scheduleJob(jd, cronTrigger);
		} catch (SrvScheduleException e) {
			logger.warn(e.getLocalizedMessage());
			throw e; 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean scheduleJob(String serviceName, String methodName,
			String parameters, String mode) throws SrvScheduleException{
		//gen jobName
		String jobName="Job."+serviceName+"."+methodName+"."+System.currentTimeMillis();
		return scheduleJob(jobName,serviceName,methodName,parameters,mode);

	}
	
	public static boolean removeJob(String jobName) {
		try {
		    Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		    sched.deleteJob(jobName, SERVICE_DEfAULT_GROUP);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
