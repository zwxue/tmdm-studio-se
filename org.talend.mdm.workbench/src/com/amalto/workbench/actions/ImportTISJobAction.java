package com.amalto.workbench.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;

import com.amalto.workbench.editors.AMainPage;
import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.JobInfo;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSMDMJobArray;
import com.amalto.workbench.webservices.WSMDMNULL;
import com.amalto.workbench.webservices.WSPUTMDMJob;
import com.amalto.workbench.webservices.XtentisPort;

public class ImportTISJobAction extends Action{

	private ServerView server = null;
	private TreeParent xobject;
				
	public ImportTISJobAction(ServerView serverView) {
		super();
		this.server = serverView;
			
		setImageDescriptor(ImageCache.getImage(EImage.WORKFLOW_PROCESS.getPath()));
		setText("Import a TIS Job Archive");
		setToolTipText("Import a TIS Job Archive");
	}
	
	public void run() {
		if (this.server != null) { //called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeParent)((IStructuredSelection)selection).getFirstElement();
		}
        
        if (xobject.getType()!=TreeObject.JOB_REGISTRY) return;
       try{ 
	//      Access to server and get port
			XtentisPort port = Util.getPort(
					new URL(xobject.getEndpointAddress()),
					xobject.getUniverse(),
					xobject.getUsername(),
					xobject.getPassword()
			);		
			FileDialog fileDialog = new FileDialog (server.getSite().getShell(), SWT.OPEN);				
			fileDialog.setFilterExtensions (new String[]{"*.war"});				
			String name=fileDialog.open();
			
	        
			if(name!=null){
				JobInfo info=getJobInfo(name);
				WSMDMJobArray array = port.getMDMJob(new WSMDMNULL());
				if(checkExist(array,info)){
					MessageDialog
					.openWarning(this.server.getSite().getShell(), "Warnning",
							"This Job already exists!");
	            	return;
			}
					
					
				String fileName = info.getJobname()+"_"+info.getJobversion()+".war";
				String endpointaddress=xobject.getEndpointAddress();
				String uploadURL = new URL(endpointaddress).getProtocol()+"://"+new URL(endpointaddress).getHost()+":"+new URL(endpointaddress).getPort()+"/datamanager/uploadFile?deployjob="+fileName;
				String remoteFile = Util.uploadFileToAppServer(uploadURL, name,"admin","talend");	
				//TODO
				//save to db
				port.putMDMJob(new WSPUTMDMJob(info.getJobname(),info.getJobversion()));
				//parse file to get jobinfo
				
				TreeObject obj = new TreeObject(
						//fileDialog.getFileName(),
						info.getJobname()+"_"+info.getJobversion(),
						xobject.getServerRoot(),
						TreeObject.JOB,
						info,
						null   //no storage to save space
				);
				xobject.addChild(obj);
				/*BrowseViewAction action=new BrowseViewAction(ServerView.show());
				action.setObject(obj);
				action.run();*/				
			
			LocalTreeObjectRepository.getInstance().mergeNewTreeObject(obj);
			 XObjectEditor editpart=(XObjectEditor)server.getSite().getWorkbenchWindow().getActivePage().openEditor(
	                    new XObjectEditorInput(obj,obj.getDisplayName()),
	                    "com.amalto.workbench.editors.XObjectEditor"
	           	);
	            
	            /*
	             * make the new page dirty
	             */
	            if(editpart.getSelectedPage() instanceof AMainPageV2){
	            	((AMainPageV2)editpart.getSelectedPage()).markDirty();
	            }
	            
	            /*
	             * make the new page dirty
	             */
	            if(editpart.getSelectedPage() instanceof AMainPage)
	            	((AMainPage)editpart.getSelectedPage()).markDirty();
	           }  
			
       }catch(Exception e){
    	   
       }
	}
	/**
	 * get the JobInfo:jobName and version
	 * @param fileName
	 * @return
	 */
	public JobInfo getJobInfo(String fileName){
		JobInfo jobInfo = new JobInfo("","");
		try {
			
			ZipInputStream in = new ZipInputStream(new FileInputStream(fileName));
			
			ZipEntry z = null;
			
			//String name = fileName.substring(fileName.lastIndexOf("\\")==-1?0:fileName.lastIndexOf("\\")+1);
			/*String tmpPath = "C:\\opt\\jboss\\server\\default\\deploy\\"+name;
			File file = new File(tmpPath);
			if(!file.exists()){
				file.mkdirs();//create temple file
			}*/
			try{
				String jobName="";
				String jobVersion="";
				while((z=in.getNextEntry())!=null){
					String dirName = z.getName();
					//get job version
					if(dirName.matches(".*?undeploy.wsdd")){
						jobName = new File(dirName).getParentFile().getName();
						if(jobName.matches(".*?_(\\d*_\\d*)")){
						Pattern p = Pattern.compile(".*?_(\\d*_\\d*)");
						Matcher m = p.matcher(jobName);
						if(m.matches()){
							jobVersion = m.group(m.groupCount());
						}
					}
					}
					//get job name
					if(dirName.matches(".*?.wsdl")){
						jobName = new File(dirName).getName();
						jobName = jobName.substring(0,jobName.lastIndexOf("."));
					}
					
					/*if(z.isDirectory()){
						dirName = dirName.substring(1,dirName.length()-1);
						File f = new File(tmpPath +"\\"+dirName);
						f.mkdirs();
					}else{
						if(dirName.indexOf("/")>0){
							if(dirName.substring(0,dirName.lastIndexOf("/")).endsWith(".item")){
								jobNmae = dirName.substring(0,dirName.lastIndexOf("/")).substring(0, dirName.substring(0,dirName.lastIndexOf("/")).lastIndexOf("."));
								return jobNmae;
							}
						}
							File folder = new File(tmpPath+"\\"+dirName.substring(0,dirName.lastIndexOf("/")));
							if(!folder.exists()){
								folder.mkdirs();
							}
							
						}
						File f = new File(tmpPath +"\\"+dirName);
						f.createNewFile();
						BufferedOutputStream out = new BufferedOutputStream(new ZipOutputStream(new FileOutputStream(f)));
						int size = 0;
						byte[] b = new byte[4096];
						while((size=in.read(b))!=-1){
							out.write(b,0,size);
						}
						out.close();
					}*/
				}
				jobInfo.setJobname(jobName);
				jobInfo.setJobversion(jobVersion.replaceAll("_", "."));
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			finally{
				in.close();
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return jobInfo;
	}
	//if the Job exist, return true,else return false
	public boolean checkExist(WSMDMJobArray array, JobInfo jobInfo){
		for(int i=0;i<array.getWsMDMJob().length;i++){
			if(array.getWsMDMJob()[i].getJobName().equals(jobInfo.getJobname())&&array.getWsMDMJob()[i].getJobVersion().equals(jobInfo.getJobversion()))
				return true;
		}
		return false;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
}
