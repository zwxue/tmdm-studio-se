package com.amalto.workbench.widgets;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class ProcessWidget {
	FormToolkit toolkit;
	private Composite parent;
	private Button suspendButton;
	private Button startButton;
	private Button stopButton;
	private Button delButton;
	String name;
	ProcessList plist;
	public ProcessWidget(FormToolkit toolkit, Composite composite, String name, ProcessList plist){
		this.toolkit= toolkit;
		this.parent=toolkit.createComposite(composite,0);
		this.name=name;
		this.plist=plist;
		GridLayout layout=new GridLayout();
		layout.numColumns=7;
		layout.marginBottom=0;
		layout.marginHeight=0;
	
		this.parent.setLayout(layout);	
		create();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight(){
		return parent.computeSize(SWT.DEFAULT, SWT.DEFAULT).y+5;
	}
	public Composite getComposite(){
		return parent;
	}
	public Button getDelButton() {
		return delButton;
	}
	public void setDelButton(Button delButton) {
		this.delButton = delButton;
	}
	public void setSelection(String name){
		for(Map.Entry<String, ProcessWidget> entry: plist.map.entrySet()){
			if(name.equals(entry.getKey())){
				setBackground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
			}else{
				entry.getValue().setBackground(parent.getParent().getBackground());
			}
		}

	}
	private void setBackground(Color color){
		Control[] childs=parent.getChildren();
		for(Control c:childs){
			c.setBackground(color);
		}
		parent.setBackground(color);		
	}
	SelectionAdapter listener=new SelectionAdapter(){
		@Override
		public void widgetSelected(SelectionEvent e) {
			setSelection(name);
		}
	};
	private void create(){
		Button process=toolkit.createButton(parent, name, SWT.TOGGLE);
		GridData gd=new GridData(SWT.LEFT,SWT.CENTER,false,false,1,1);
		gd.widthHint=140;
		process.setLayoutData(gd);
		process.addSelectionListener(listener);
		Label statusLabel=toolkit.createLabel(parent, "Status:");
		Label description=toolkit.createLabel(parent, "RUNNING");
		gd=new GridData(SWT.FILL,SWT.CENTER,false,true,1,1);
		gd.widthHint=300;		
		description.setLayoutData(gd);
        //start/stop/suspend/resume
        startButton = toolkit.createButton(parent, "", SWT.TOGGLE);
        startButton.setImage(ImageCache.getCreatedImage(EImage.RUN_EXC.getPath()));
        startButton.setToolTipText("Start");
        startButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        
        stopButton = toolkit.createButton(parent, "", SWT.TOGGLE);
        stopButton.setImage(ImageCache.getCreatedImage(EImage.STOP.getPath()));
        stopButton.setToolTipText("Stop");
        stopButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        suspendButton = toolkit.createButton(parent, "",  SWT.TOGGLE);
        suspendButton.setImage(ImageCache.getCreatedImage(EImage.SUSPEND.getPath()));
        suspendButton.setToolTipText("Suspend");
        suspendButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        suspendButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
            	if (suspendButton.getSelection()) {
            		//suspendSubscriptionEngine();
            		suspendButton.setText("Resume");
            		suspendButton.redraw();
            	} else {
            		//resumeSubscriptionEngine();
            		suspendButton.setText("Suspend");
            		suspendButton.redraw();
            	}
        	};
        });    		
        delButton = toolkit.createButton(parent, "",  SWT.TOGGLE);
        delButton.setImage(ImageCache.getCreatedImage(EImage.DELETE_OBJ.getPath()));
        delButton.setToolTipText("Delete");
        delButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        startButton.addSelectionListener(listener);
        stopButton.addSelectionListener(listener);	
        suspendButton.addSelectionListener(listener);
        statusLabel.addMouseListener(new MouseListener(){

			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseUp(MouseEvent e) {
				setSelection(name);
				
			}
        	
        });
        description.addMouseListener(new MouseListener(){

			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseUp(MouseEvent e) {
				setSelection(name);
				
			}        	
        });              
        parent.addMouseListener(new MouseListener(){

			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseUp(MouseEvent e) {
				setSelection(name);
				
			}        	
        });              
	}
	public Button getSuspendButton() {
		return suspendButton;
	}
	public void setSuspendButton(Button suspendButton) {
		this.suspendButton = suspendButton;
	}
	public Button getStartButton() {
		return startButton;
	}
	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}
	public Button getStopButton() {
		return stopButton;
	}
	public void setStopButton(Button stopButton) {
		this.stopButton = stopButton;
	}
	
}
