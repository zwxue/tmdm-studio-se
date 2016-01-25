// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.wizards.imports.MDMImportRepositoryItemsWizard;
import org.talend.repository.ui.actions.AContextualAction;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * @author cgpiao
 * 
 */
public class ImportObjectAction {
	private static final String IMPORT_ACTIONSET_ID = "org.talend.repository.items.importexport.actionSet";
	private static final String IMPORT_ACTION_ID = "org.talend.repository.items.importexport.actions.ImportItems";
	private static AContextualAction importAction;
	private static Log log = LogFactory.getLog(ImportObjectAction.class);
	private synchronized static AContextualAction getImportAction() {
		if (null != importAction) {
			return importAction;
		}
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
								importAction = (AContextualAction) cle
										.createExecutableExtension("class");
								return importAction;
							} catch (Exception e) {
								log.error(e.getMessage(),e);
							}
						}
					}
				}
			}
		}
		return null;
	}
	public static AbstractRepositoryAction createImportAction() {
		AContextualAction action = getImportAction();
		if (null != action) {
			return new ImportActionByExtension(action);
		} else {
			return new OriginalObjectAction();
		}
	}

	

	static class OriginalObjectAction extends AbstractRepositoryAction {

		private MDMRepositoryView view = null;

		public OriginalObjectAction() {
			super(Messages.ImportObjectAction_label);
			setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
		}

		protected void doRun() {
			try {
				ISelection selection = null;
				// if (this.view != null) { // called from ServerView
				view = MDMRepositoryView.show();
				selection = view.getCommonViewer().getSelection();
				// }
				MDMImportRepositoryItemsWizard wizard = new MDMImportRepositoryItemsWizard(
						(IStructuredSelection) selection);
				WizardDialog dialog = new WizardDialog(view.getSite()
						.getShell(), wizard);
				dialog.create();
				dialog.getShell().setText(
						Messages.ImportObjectAction_importRepositoryItem);
				dialog.open();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				MessageDialog.openError(
						view.getSite().getShell(),
						Messages.ImportObjectAction_error,
						Messages.ImportObjectAction_hasError
								+ e.getLocalizedMessage());
			}
		}

		@Override
		public String getGroupName() {
			return GROUP_EXPORT;
		}

	}

	static class ImportActionByExtension extends AbstractBridgeRepositoryAction {
		private AContextualAction action;
		public ImportActionByExtension(AContextualAction action) {
			super(action);
			this.action = action;
		}

		@Override
		public String getGroupName() {
			return GROUP_EXPORT;
		}
		@Override
		protected void doRun() {
			ISelection selection = getSelectionProvider().getSelection();
			if (action instanceof IWorkbenchWindowActionDelegate) {
				IWorkbenchWindowActionDelegate actionDelegate = (IWorkbenchWindowActionDelegate) action;
				actionDelegate.selectionChanged(null, selection);
			}
			super.doRun();
			getCommonViewer().refresh();
		}
	}

}
