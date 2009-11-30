package com.amalto.workbench.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
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
	public ProcessWidget(FormToolkit toolkit, final Composite composite){
		this.toolkit= toolkit;
		this.parent=toolkit.createComposite(composite,0);
		GridLayout layout=new GridLayout();
		layout.numColumns=6;
		this.parent.setLayout(layout);	
		create();
	}
	private void create(){
		Button process=toolkit.createButton(parent, "Process", SWT.PUSH);
		Label statusLabel=toolkit.createLabel(parent, "Status:");
		Label description=toolkit.createLabel(parent, "RUNNING");
		
        //start/stop/suspend/resume
        startButton = toolkit.createButton(parent, "", SWT.TOGGLE);
        startButton.setImage(ImageCache.getCreatedImage(EImage.RUN_EXC.getPath()));
        startButton.setToolTipText("Start");
        startButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        startButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
            	//startSubscriptionEngine();
        	};
        });    
        stopButton = toolkit.createButton(parent, "", SWT.TOGGLE);
        stopButton.setImage(ImageCache.getCreatedImage(EImage.STOP.getPath()));
        stopButton.setToolTipText("Stop");
        stopButton.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        stopButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
            	//stopSubscriptionEngine();
        	};
        });
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
