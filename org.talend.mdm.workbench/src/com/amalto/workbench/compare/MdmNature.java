package com.amalto.workbench.compare;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.amalto.workbench.MDMWorbenchPlugin;

public class MdmNature implements IProjectNature {
	public static final String ID=MDMWorbenchPlugin.ID +".mdmnature";

	public void configure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	public IProject getProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProject(IProject project) {

	}

}
