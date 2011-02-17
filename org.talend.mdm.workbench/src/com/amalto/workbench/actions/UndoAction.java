// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

/**
 * All actions need to support Undo/Redo(DataModelMainPage) must subclass this one
 */

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDSchema;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

public class UndoAction extends Action {

    private static Log log = LogFactory.getLog(UndoAction);

    protected DataModelMainPage page;

    protected XSDSchema schema = null;

    private Map<Integer, String> undoActionTrack = null;

    private Map<Integer, String> redoActionTrack = null;

    public UndoAction(DataModelMainPage page) {
        this.page = page;
        undoActionTrack = page.getUndoActionTrack();
        redoActionTrack = page.getRedoActionTrack();
    }

    public class XsdUndoableOperation extends AbstractOperation {

        public XsdUndoableOperation(String label) {
            super(label);
        }

        @Override
        public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

            return UndoAction.this.execute();
        }

        @Override
        public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
            return UndoAction.this.redo();
        }

        @Override
        public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
            return UndoAction.this.undo();
        }
    };

    public void run() {

        operation.addContext(page.getUndoContext());
        try {
            IStatus status = getOperationHistory().execute(operation, null, null);
        } catch (ExecutionException e) {
            // e.printStackTrace();
            log.error(e.getStackTrace());
        }

    }

    public void run(Object toDel) {
    }

    protected XsdUndoableOperation operation = new XsdUndoableOperation("");

    /**
     * need override by subclass
     */
    protected IStatus doAction() {
        return Status.OK_STATUS;
    }

    protected IStatus execute() {
        // System.out.println(getText() + " execute....");
        log.info(getText() + " execute...."); //$NON-NLS-1$
        String oldValue = beforeDoAction();

        if (doAction() == Status.CANCEL_STATUS) {
            cancelDoAction(oldValue);
            return Status.CANCEL_STATUS;
        }

        afterDoAction();
        return Status.OK_STATUS;
    }

    protected String beforeDoAction() {
        schema = ((ISchemaContentProvider) page.getTreeViewer().getContentProvider()).getXsdSchema();
        return commitDocumentToHistory(schema.getDocument());
    }

    protected void afterDoAction() {
        commitDocumentToCurrent(schema.getDocument());
    }

    protected void cancelDoAction(String oldValue) {
        removeDocumentFromHistory();
        if (oldValue != null) {
            undoActionTrack.put(getActionUndoPos(), oldValue);
        }
    }

    protected String commitDocumentToHistory(Document history) {
        String oldValue = null;
        try {
            String value = Util.nodeToString((Node) history);
            oldValue = undoActionTrack.get(getActionUndoPos());
            undoActionTrack.put(getActionUndoPos(), value);
        } catch (Exception e) {
            // e.printStackTrace();
            log.error(e.getStackTrace());
        }
        return oldValue;
    }

    protected void removeDocumentFromHistory() {
        undoActionTrack.remove(getActionUndoPos());
    }

    protected void commitDocumentToCurrent(Document currnt) {
        try {
            String value = Util.nodeToString((Node) currnt);
            redoActionTrack.keySet().size();
            redoActionTrack.put(getActionUndoPos(), value);
        } catch (Exception e) {
            // e.printStackTrace();
            log.error(e.getStackTrace());
        }
    }

    private int getActionUndoPos() {
        IOperationHistory history = getOperationHistory();
        return history.getUndoHistory(page.getUndoContext()).length;
    }

    private int getActionRedoPos() {
        IOperationHistory history = getOperationHistory();
        return history.getRedoHistory(page.getUndoContext()).length;
    }

    /**
     * need override by subclass
     * 
     * @return
     */
    protected IStatus undo() {
        System.out.println(getText() + " undo....");
        String doc = undoActionTrack.get(getActionUndoPos() - 1);
        refresh(doc);
        return Status.OK_STATUS;
    }

    protected IStatus redo() {
        System.out.println(getText() + " redo....");
        String doc = redoActionTrack.get(getActionUndoPos());
        refresh(doc);
        return Status.OK_STATUS;
    }

    private void refresh(String content) {
        XSDSchema xsd;
        try {
            xsd = Util.createXsdSchema(content, page.getXObject());
        } catch (Exception e) {
            // e.printStackTrace();
            log.error(e.getStackTrace());
            return;
        }
        page.setXsdSchema(xsd);
        page.refresh();
        page.markDirtyWithoutCommit();
    }

    public XsdUndoableOperation getOperation() {
        return operation;
    }

    public IOperationHistory getOperationHistory() {
        return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
    }
}
