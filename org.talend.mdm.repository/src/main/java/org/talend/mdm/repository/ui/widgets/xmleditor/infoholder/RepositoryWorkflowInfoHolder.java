// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.widgets.xmleditor.infoholder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bonitasoft.studio.model.process.Element;
import org.bonitasoft.studio.model.process.MainProcess;
import org.bonitasoft.studio.model.process.Pool;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.talend.core.model.properties.ReferenceFileItem;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.widgets.xmleditor.util.WorkflowInfo;

public class RepositoryWorkflowInfoHolder extends RepositoryExternalInfoHolder<WorkflowInfo[]> {

    static Logger log = Logger.getLogger(RepositoryWorkflowInfoHolder.class);

    public RepositoryWorkflowInfoHolder() {
    }

	@Override
	public WorkflowInfo[] getExternalInfo() {

		List<WorkflowInfo> results = new LinkedList<WorkflowInfo>();
		List<IRepositoryViewObject> viewObjs = RepositoryResourceUtil
				.findAllViewObjects(IServerObjectRepositoryType.TYPE_WORKFLOW);

		for (IRepositoryViewObject viewObj : viewObjs) {
			ReferenceFileItem item = (ReferenceFileItem) viewObj.getProperty()
					.getItem().getReferenceResources().get(0);
			XMIResource resource = new XMIResourceImpl();
			InputStream stream = new ByteArrayInputStream(item.getContent()
					.getInnerContent());
			try {
				resource.load(stream, null);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof MainProcess) {
						MainProcess mainProcess = (MainProcess) obj;
						for (Element element : mainProcess.getElements()) {
							if (element instanceof Pool) {
								Pool pool = ((Pool) element);
								WorkflowInfo workflowInfo = new WorkflowInfo(
										mainProcess.getLabel(), pool.getName(),
										mainProcess.getVersion());
								results.add(workflowInfo);
								break;
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return results.toArray(new WorkflowInfo[0]);

	}

    @Override
    public String getId() {
        return INFOID_ALLWORKFLOWINFOS;
    }

}
