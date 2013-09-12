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
package org.talend.mdm.repository.ui.actions;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.repository.ui.actions.AContextualAction;

/**
 * @author changguopiao
 * 
 */
public class ImportObjectAction extends AbstractBridgeRepositoryAction {
	private static final String IMPORT_ACTIONSET_ID = "org.talend.repository.items.importexport.actionSet";
	private static final String IMPORT_ACTION_ID = "org.talend.repository.items.importexport.actions.ImportItems";

	private static AContextualAction cAction = getImportAction();
	private static AContextualAction getImportAction() {
		IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint("org.eclipse.ui.actionSets");
		if (null == point) {
			return null;
		}
		for (IExtension ext : point.getExtensions()) {
			IConfigurationElement[] configurationElements = ext
					.getConfigurationElements();
			for (IConfigurationElement ce : configurationElements) {
				String id = ce.getAttribute("id"); //$NON-NLS-1$
				if (IMPORT_ACTIONSET_ID.equals(id)) {
					IConfigurationElement[] actions = ce.getChildren("action");
					for (IConfigurationElement cle : actions) {
						if (IMPORT_ACTION_ID.equals(cle.getAttribute("id"))) {
							try {
								return (AContextualAction) cle
										.createExecutableExtension("class"); //$NON-NLS-1$
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return null;
	}

	public ImportObjectAction() {
		super(cAction);
		if (null == cAction) {
			throw new RuntimeException(
					"need (org.talend.repository.items.importexport.ui) plugin");
		}
	}

	@Override
	public String getGroupName() {
		return GROUP_EXPORT;
	}

	@Override
	protected void doRun() {
		ISelection selection = getSelectionProvider().getSelection();
		if (cAction instanceof IWorkbenchWindowActionDelegate) {
			IWorkbenchWindowActionDelegate actionDelegate = (IWorkbenchWindowActionDelegate) cAction;
			actionDelegate.selectionChanged(null, selection);
		}
		super.doRun();
		getCommonViewer().refresh();
	}

}
