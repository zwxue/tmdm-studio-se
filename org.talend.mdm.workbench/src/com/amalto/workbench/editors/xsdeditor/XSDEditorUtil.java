package com.amalto.workbench.editors.xsdeditor;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModel;

public class XSDEditorUtil {

    private static String getXObjectPath(TreeObject xobject) {
        String name = xobject.getDisplayName().replace(" ", "");
        if (xobject.getParent().getDisplayName().startsWith(EXtentisObjects.DataMODEL.getDisplayName())) {
            // the datamodel root
            return xobject.getParent().getDisplayName().replace(" ", "") + "/" + name;
        } else {
            return getXObjectPath(xobject.getParent()) + "/" + name;
        }
    }

    public static IFile createFile(TreeObject xobject) throws Exception {
        WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();

        String filename = xobject.getDisplayName().replace(" ", "") + ".xsd";
        String content = wsDataModel.getXsdSchema();

        IProject project = createProject(xobject);
        String path = getXObjectPath(xobject);
        int pos = path.indexOf('/');
        String folder = path.substring(0, pos);
        IFolder fold = project.getFolder(folder);
        if (!fold.exists()) {
            fold.create(true, true, null);
        }
        IFile file = fold.getFile(filename);

        if (!file.exists())
            file.create(new ByteArrayInputStream(content.getBytes()), IFile.FORCE, null);
        return file;
    }

    private static boolean isEditorOpened(TreeObject xobject) throws Exception {
        WSDataModel wsDataModel = (WSDataModel) xobject.getWsObject();

        String filename = xobject.getDisplayName().replace(" ", "") + ".xsd";
        String content = wsDataModel.getXsdSchema();

        IProject project = createProject(xobject);
        String path = getXObjectPath(xobject);
        int pos = path.indexOf('/');
        String folder = path.substring(0, pos);
        IFolder fold = project.getFolder(folder);
        if (!fold.exists()) {
            fold.create(true, true, null);
        }
        IFile file = fold.getFile(filename);

        if (!file.exists())
            return true;
        return false;
    }

    public static IProject createProject(TreeObject xobject) {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        String projectname = xobject.getServerRoot().getDisplayName().trim().replace("://", "").replace("/", "").replace(" ", "")
                .replace(":", "");
        IProject prj = root.getProject(projectname);
        if (prj.exists())
            return prj;
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription desc = workspace.newProjectDescription(projectname);
        desc.setNatureIds(new String[] { "org.talend.mdm.schema.nature" });
        desc.setComment("Talend MDM DataModel Project");
        try {
            prj.create(desc, null);
            prj.open(IResource.BACKGROUND_REFRESH, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return prj;
    }

    public static void openDataModel(TreeObject xobject, boolean markdirty) throws Exception {

        IFile pathToTempFile = XSDEditorUtil.createFile(xobject);
        final XSDEditorInput input = new XSDEditorInput(pathToTempFile);
        final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(
                "com.amalto.workbench.editors.xsdeditor.XSDEditor");
        if (activePage.findEditor(input) != null) {
            activePage.openEditor(input, desc.getId());
            return;
        }

        final XSDEditor part = (XSDEditor) activePage.openEditor(input, desc.getId());// org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor

        IEditorInput xobjectEditorinput = new XObjectEditorInput(xobject, xobject.getDisplayName());

        final DataModelMainPage dMainPage = new DataModelMainPage(xobject);
        part.addPage(2, dMainPage, xobjectEditorinput);
        // add DataModelMainPage to third page, why? if don't do like this, the
        // 'Design' page opertions don't work, don't know why, TODO

        part.setXSDInput(xobjectEditorinput);
        part.setXObject(xobject);
        part.setActiveEditor(dMainPage);

        CTabFolder folder = (CTabFolder) dMainPage.getMainControl().getParent();
        folder.getItem(2).setText(xobject.getDisplayName() + " " + Util.getRevision(xobject));
        if (markdirty)
            dMainPage.markDirty();
    }
}
