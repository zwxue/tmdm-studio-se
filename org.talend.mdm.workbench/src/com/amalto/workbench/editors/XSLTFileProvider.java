// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.editors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.wst.xsl.ui.internal.XSLUIPlugin;
import org.talend.core.model.general.Project;
import org.talend.core.repository.model.ResourceModelUtils;
import org.talend.repository.ProjectManager;

/**
 * created by liusongbo on 2013-1-6
 */
public class XSLTFileProvider {

    private static Log log = LogFactory.getLog(XSLTFileProvider.class);

    public static IFile getXSLTFile(String templateString, String fileName) {
        IFile file = null;
        if (templateString != null) {
            try {
                Project project = ProjectManager.getInstance().getCurrentProject();
                IProject prj = ResourceModelUtils.getProject(project);
                file = prj.getFile(new Path("temp/" + fileName)); //$NON-NLS-1$

                IPreferenceStore preference = XSLUIPlugin.getDefault().getPreferenceStore();
                String charSet = preference.getString("outputCodeset"); //$NON-NLS-1$
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = null;
                if ((charSet == null) || (charSet.trim().isEmpty())) {
                    outputStreamWriter = new OutputStreamWriter(outputStream);
                } else {
                    outputStreamWriter = new OutputStreamWriter(outputStream, charSet);
                }

                outputStreamWriter.write(templateString);
                outputStreamWriter.flush();
                outputStreamWriter.close();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                if (file.exists()) {
                    file.setContents(inputStream, true, false, null);
                } else {
                    file.create(inputStream, true, null);
                }

                inputStream.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        return file;
    }
}
