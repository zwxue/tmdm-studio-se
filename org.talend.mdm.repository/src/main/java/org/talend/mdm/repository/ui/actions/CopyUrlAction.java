package org.talend.mdm.repository.ui.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;

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
            
            //all picture url string
            String uripre = "http://" + serverDef.getHost() + ":" + serverDef.getPort();

            result.append(uripre);
            result.append("/imageserver/locator?imgId="+repositoryName);
            result.append("\n");
        }
        
        
        //copy url to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection text = new StringSelection(result.toString());
        clipboard.setContents(text, null);
    }

}
