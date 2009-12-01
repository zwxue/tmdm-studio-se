package com.amalto.workbench.widgets;

import java.util.HashMap;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class ProcessList {
	int processNum;
	ProcessWidget cur;
	HashMap<String,ProcessWidget> map=new HashMap<String, ProcessWidget>();

	FormToolkit toolkit;
	private Composite parent;
	private ScrolledComposite ccrollComposite;

	public ProcessList(FormToolkit toolkit, Composite composite,ScrolledComposite ccrollComposite){
		this.toolkit= toolkit;
		this.parent=composite;
		this.ccrollComposite=ccrollComposite;
	}
	public ProcessWidget add(String name){
		if(map.get(name)!=null){
			MessageDialog.openWarning(null, "Warning", name+ " exists already!");
			return null;
		}		
		final ProcessWidget pw=new ProcessWidget(toolkit,parent,name,this);
		pw.getDelButton().addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				delete(pw);
			}
		});
		map.put(name, pw);
		parent.layout(true);
		ccrollComposite.setMinSize(400, 31* map.size());
		return pw;
	}
	public ProcessWidget delete(ProcessWidget widget ){
		ProcessWidget pw=map.remove(widget.getName());
		Composite com=widget.getComposite().getParent();
		widget.getComposite().dispose();
		com.layout(true);
		ccrollComposite.setMinSize(400, 31* map.size());
		return pw;
	}
}
