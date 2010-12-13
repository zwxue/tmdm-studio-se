package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

public class CompositeSelectionProvider implements ISelectionProvider, ISelectionChangedListener  {

	private ISelection selection;
    private List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();

    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    public ISelection getSelection() {
        return selection;
    }

    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.remove(listener);
    }

    public void setSelection(ISelection selection) {
        this.selection = selection;
        final SelectionChangedEvent e = new SelectionChangedEvent(this, selection);
       
        for(final ISelectionChangedListener eachListener : listeners.toArray(new ISelectionChangedListener[0])){
        	 SafeRunner.run(new SafeRunnable() {
                 public void run() {
                	 eachListener.selectionChanged(e);
                 }
             });
        }
    }

    public void selectionChanged(SelectionChangedEvent event) {
        setSelection(event.getSelection());
    }

}
