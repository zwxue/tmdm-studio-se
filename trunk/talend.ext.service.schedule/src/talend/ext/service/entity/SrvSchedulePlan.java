package talend.ext.service.entity;

import java.io.Serializable;

public class SrvSchedulePlan implements Serializable{
	
	private String schedulePlanId;
	
	private String schedulePlanStatus;
	
	private String schedulePlanDesc;
	
	private String serviceName;
	
	private String methodName;
	
	private String parameters;
	
	private String mode;
	
	public SrvSchedulePlan(String schedulePlanId, String schedulePlanStatus,
			String schedulePlanDesc, String serviceName, String methodName,
			String parameters, String mode) {
		super();
		this.schedulePlanId = schedulePlanId;
		this.schedulePlanStatus = schedulePlanStatus;
		this.schedulePlanDesc = schedulePlanDesc;
		this.serviceName = serviceName;
		this.methodName = methodName;
		this.parameters = parameters;
		this.mode = mode;
	}

	public SrvSchedulePlanPK obtainSrvSchedulePlanPk() {
		
		return new SrvSchedulePlanPK(serviceName,methodName);

	}

	public String getSchedulePlanId() {
		return schedulePlanId;
	}

	public void setSchedulePlanId(String schedulePlanId) {
		this.schedulePlanId = schedulePlanId;
	}

	public String getSchedulePlanStatus() {
		return schedulePlanStatus;
	}

	public void setSchedulePlanStatus(String schedulePlanStatus) {
		this.schedulePlanStatus = schedulePlanStatus;
	}

	public String getSchedulePlanDesc() {
		return schedulePlanDesc;
	}

	public void setSchedulePlanDesc(String schedulePlanDesc) {
		this.schedulePlanDesc = schedulePlanDesc;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
