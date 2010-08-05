package com.amalto.workbench.models;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.UserInfo;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSGetCurrentUniverse;
import com.amalto.workbench.webservices.WSPing;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.XtentisPort;

public class ObjectRetriever implements IRunnableWithProgress {

    TreeParent parentObject = null;

    private String endpointaddress;

    private String username;

    private String password;

    private String universe;

    private String objectName = "";

    /**
     * @author ymli refresh the parentObject
     * @param parentObject
     * @param endpointaddress
     * @param username
     * @param password
     * @param universe
     */
    public ObjectRetriever(TreeParent parentObject, String endpointaddress, String username, String password, String universe) {
        super();
        this.parentObject = parentObject;
        this.endpointaddress = endpointaddress;
        this.username = username;
        this.password = password;
        this.universe = universe;
    }

    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        monitor.beginTask("Loading " + IConstants.TALEND + " Server Objects", "admin".equals(username) ? 12 : 9);
        // Access to server and get port

        try {
            switch (parentObject.getType()) {
            case TreeObject.WORKFLOW:
                objectName = "WorkflowAvailableModel";
                break;
            case TreeObject.JOB_REGISTRY:
                objectName = "JobAvailableModel";
                break;
            }
            XtentisPort port = Util.getPort(new URL(endpointaddress), universe, username, password);
//            port.ping(new WSPing("Hello MDM!"));
//            monitor.worked(1);

//            WSUniverse wUuniverse = null;
//            wUuniverse = port.getCurrentUniverse(new WSGetCurrentUniverse());
//            monitor.subTask("Accessing server....");
//
//            UserInfo user = new UserInfo();
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setServerUrl(endpointaddress);
//            user.setUniverse(universe);
//            user.setWsUuniverse(wUuniverse);
//            parentObject.setUser(user);

            parentObject.getServerRoot().removeChild(parentObject);
            List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels();
            for (IAvailableModel model : availablemodels) {
                if (model.toString().indexOf(objectName) > 0) {
                    model.addTreeObjects(port, monitor, parentObject.getServerRoot());
                    // break;
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XtentisException e) {
            e.printStackTrace();
        } 

    }

}
