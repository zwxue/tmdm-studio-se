package com.amalto.webapp.v3.synchronizationaction.dwr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.util.webservices.WSGetSynchronizationPlanPKs;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanAction;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanActionCode;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanPK;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanPKArray;
import com.amalto.webapp.util.webservices.WSSynchronizationPlanStatus;
import com.amalto.webapp.v3.synchronizationaction.bean.SyncInfo;
import com.amalto.webapp.v3.synchronizationaction.bean.SyncStatus;


public class SynchronizationActionDWR {
	
	
	public SynchronizationActionDWR() {
		super();
	}
	
	public String[] getSyncNames(SyncInfo info)throws Exception{
		try{

			WSSynchronizationPlanPKArray array
				= Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword(),Util._FORCE_WEB_SERVICE_).getSynchronizationPlanPKs(new WSGetSynchronizationPlanPKs(".*"));
			System.out.println("getSyncNames() url:"+info.getServerURL());
			WSSynchronizationPlanPK[] pks=array.getWsSynchronizationPlanPK();
			System.out.println("getSyncNames() pks:"+pks.length);
			String[] syncNames=new String[pks.length];
			for(int i=0; i<pks.length; i++){
				syncNames[i]=pks[i].getPk();
			}
			System.out.println("getSyncNames() syncNames:"+Arrays.asList(syncNames));
			return syncNames;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}
	}
	
	public void startFull(SyncInfo info)throws Exception {
		try {
			System.out.println("StartFull....");
			Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword(),Util._FORCE_WEB_SERVICE_).synchronizationPlanAction(new WSSynchronizationPlanAction(
                	new WSSynchronizationPlanPK(info.getSyncName()),
                	WSSynchronizationPlanActionCode.START_FULL
                ));
		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}
	}
	
	public void startDifferent(SyncInfo info)throws Exception {
		try {

			Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword()).synchronizationPlanAction(new WSSynchronizationPlanAction(
                	new WSSynchronizationPlanPK(info.getSyncName()),
                	WSSynchronizationPlanActionCode.START_DIFFERENTIAL
                ));
		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}
	}
	public void stop(SyncInfo info)throws Exception {
		try {

			Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword(),Util._FORCE_WEB_SERVICE_).synchronizationPlanAction(new WSSynchronizationPlanAction(
                	new WSSynchronizationPlanPK(info.getSyncName()),
                	WSSynchronizationPlanActionCode.STOP
                ));
		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}
	}
	public void reset(SyncInfo info)throws Exception {
		try {

			Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword(),Util._FORCE_WEB_SERVICE_).synchronizationPlanAction(new WSSynchronizationPlanAction(
                	new WSSynchronizationPlanPK(info.getSyncName()),
                	WSSynchronizationPlanActionCode.RESET
                ));
		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}
	}

	public SyncStatus getStatus(SyncInfo info)throws Exception {
		WSSynchronizationPlanStatus wsStatus = null;
		try {
	        wsStatus = Util.getPort(info.getServerURL(),info.getUsername(),info.getPassword(),Util._FORCE_WEB_SERVICE_).synchronizationPlanAction(new WSSynchronizationPlanAction(
	        	new WSSynchronizationPlanPK(info.getSyncName()),
	        	WSSynchronizationPlanActionCode.STATUS
	        ));
	        SyncStatus status=new SyncStatus();
	        status.setValue(wsStatus.getWsStatusCode().getValue());
	        status.setMessage(wsStatus.getStatusMessage());
	        return status;
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
        }
	}
}
