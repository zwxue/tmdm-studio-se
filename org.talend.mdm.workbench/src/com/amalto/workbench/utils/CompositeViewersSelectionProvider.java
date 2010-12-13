package com.amalto.workbench.utils;

import java.util.Collection;

import org.eclipse.jface.viewers.Viewer;

public class CompositeViewersSelectionProvider extends
		CompositeSelectionProvider {

	public CompositeViewersSelectionProvider(Viewer[] viewers){
		for(Viewer eachViewer : viewers) {
			eachViewer.addSelectionChangedListener(this);
		}
	}
	
	public CompositeViewersSelectionProvider(Collection<Viewer> viewers){
		this(viewers.toArray(new Viewer[viewers.size()]));
	}
}
