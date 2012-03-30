package org.talend.mdm.repository.ui.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.ResourcesUtil;
import com.amalto.workbench.utils.UserInfo;

public class CopyUrlAction extends AbstractRepositoryAction {

    private String picEntry = "redirectUri";
    
    public CopyUrlAction() {
        super("Copy Url");
        setImageDescriptor(ImageCache.getImage(EImage.COPY.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_SVN;
    }

    @Override
    protected void doRun() {
        multiCopy();
    }

    private void multiCopy() {
        StringBuilder result = new StringBuilder();
        
        List<Object> selectedObject = getSelectedObject();
        
        for(Object obj:selectedObject) {
            IRepositoryViewObject viewObject = (IRepositoryViewObject)obj;
            
            //picture file info
            Item item = viewObject.getProperty().getItem();
            String fileExtension = ((WSResourceItem) item).getResource().getFileExtension();
            String fileName = viewObject.getLabel();
            String version = viewObject.getVersion();
            
            String repositoryName = fileName+"_"+version+"."+fileExtension; 
            
            //MDMServerDef thing
            MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(viewObject);
            if(serverDef == null)
                continue;
            
            serverDef = serverDef.getDecryptedServerDef();
            
            
            // server root
            String universe = serverDef.getUniverse();
            String wsObject = ("".equals(universe) ? "" : universe + "/") + serverDef.getUser() + ":" + serverDef.getPasswd();            
            TreeParent serverRoot = new TreeParent(serverDef.getName(), null, TreeObject._SERVER_, serverDef.getUrl(), wsObject);//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

            UserInfo user = new UserInfo();
            user.setUsername(serverDef.getUser());
            user.setPassword(serverDef.getPasswd());
            user.setServerUrl(serverDef.getUrl());
            user.setUniverse(serverDef.getUniverse());
            serverRoot.setUser(user);
            
            //all picture url string
            String uripre = "http://" + serverDef.getHost() + ":" + serverDef.getPort();

            TreeParent picturesResources = new TreeParent(EXtentisObjects.PICTURESRESOURCE.getDisplayName(), serverRoot,
                    TreeObject.PICTURES_RESOURCE, null, null);
            String responseBody = ResourcesUtil.getXMLString(uripre + TreeObject.PICTURES_URI, picturesResources);
            Document document = ResourcesUtil.parsXMLString(responseBody);

            String urlLast = "";
            for (Iterator iterator = document.getRootElement().elementIterator("entry"); iterator.hasNext();) {//$NON-NLS-1$
                Element element = (Element) iterator.next();
                Element uriElement = element.element(picEntry);

                String urlString = "";
                if (uriElement != null) {
                    urlString = uriElement.getStringValue();
                    int lastIndex = urlString.lastIndexOf("=");
                    urlString = urlString.substring(lastIndex + 1);
                    if (repositoryName.equals(urlString)) {
                        urlLast = uriElement.getStringValue();
                        result.append(uripre+urlLast + "\r\n");
                        break;
                    }
                }
            }
            
        }
        
        
        //copy url to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection text = new StringSelection(result.toString());
        clipboard.setContents(text, null);
    }

}
