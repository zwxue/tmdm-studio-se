amalto.namespace("amalto.SynchronizationAction");

//contectid.applicaionid
amalto.SynchronizationAction.SynchronizationAction = function() {
	var SELECT_SYNCHRONIZATION='Select a SyncPlan';
	function getSyncInfo(){
		if ($('serverURL').value=='') {
			//alert ('Server URL');
			$('serverURL').focus();
			return;
		}
		if ($('username').value=='') {
			//alert ('UserName');
			$('username').focus();
			return;
		}	
		if ($('password').value=='') {
			//alert ('password');
			$('password').focus();
			return;
		}
		
		var syncInfo = {
			serverURL:$('serverURL').value,
			username:$('username').value,
			password:$('password').value,
			syncName:$('syncName').value
		};
		return syncInfo;
	}

	function initSyncNames(){
		var syncinfo=getSyncInfo();
		if(syncinfo){
			var syncnames=SynchronizationActionInterface.getSyncNames(syncinfo);
			var tmp=[SELECT_SYNCHRONIZATION];
			DWRUtil.removeAllOptions("syncName");
			DWRUtil.addOptions("syncName",tmp);
			if(!syncnames)return;
			DWRUtil.addOptions("syncName",syncnames);			
		}
	};
	
	function refreshStatus(syncInfo){
		var syncStatus=SynchronizationActionInterface.getStatus(syncInfo);
		if(syncStatus){
			Ext.getCmp('status').getEl().update('[' + syncStatus.getValue() + '] ' + syncStatus.getMessage());
			if('RUNNING' == syncStatus.getValue() || 'SCHEDULED' == syncStatus.getValue()){
	    		Ext.getCmp('startFullButton').disable();
	    		Ext.getCmp('startDifferentButton').disable();
	    		Ext.getCmp('stopButton').enable();
	    		Ext.getCmp('resetButton').disable();
			}
			else if ("STOPPING" == syncStatus.getValue()) {
	    		Ext.getCmp('startFullButton').disable();
	    		Ext.getCmp('startDifferentButton').disable();
	    		Ext.getCmp('stopButton').disable();
	    		Ext.getCmp('resetButton').enable();
	    	} else {
	    		Ext.getCmp('startFullButton').enable();
	    		Ext.getCmp('startDifferentButton').enable();
	    		Ext.getCmp('stopButton').disable();
	    		Ext.getCmp('resetButton').disable();
	    	}
		}
	};

	function show() {
		Ext.QuickTips.init();

		var topPanel = new Ext.form.FormPanel(
				{
					region : 'center',
					border : false,
					bodyStyle : "padding: 8px; background-color: transparent;",
					labelAlign : "left",
					labelWidth : 150,
					autoScroll : true,
					defaultType : "textfield",
					buttonAlign : 'left',
					items : [ new Ext.form.FieldSet( {
						title : 'Remote system information',
						autoHeight : true,
						defaultType : 'textfield',
						items : [ {
							fieldLabel : 'Server URL',							
							selectOnFocus:true,
							allowBlank:false,
							hideTrigger:true,
							id : 'serverURL',
							width : 300
						}, {
							fieldLabel : 'UserName',
							id : 'username',
							allowBlank:false,
							width : 300
						}, {
							fieldLabel : 'Password',
							id : 'password',
							allowBlank:false,
							inputType:'password',
							width : 300,
					        listeners:{
					        	'blur': function(){										
									initSyncNames();
					    		}
							}
						}]
					}),
					new Ext.Panel({
							width : 300,
							border:false,
							html:'<div> Synchronization Name:    '+'<select id="syncName" ><option value="Select a SyncPlan"></option></select></div>' 
						}) 
					
					, {
						id : 'status',
						xtype : 'box',
						autoEl : {
							cn : 'Status...'
						}
					} ],
					buttons : [ 							
							{	
								xtype:'button',
								id:'startFullButton',
								text : '<b>Start Full</b>',
								handler : function() {
									var syncInfo=getSyncInfo();
									if(syncInfo)
									SynchronizationActionInterface.startFull(refreshStatus(syncInfo),syncInfo);
								},
								tooltip : 'Start synchronization'
							},
							{	xtype:'button',
								id:'startDifferentButton',
								text : '<b>Start Different</b>',
								handler : function() {
									var syncInfo=getSyncInfo();
									if(syncInfo)
									SynchronizationActionInterface.startDifferent(refreshStatus(syncInfo),syncInfo);
								},
								tooltip : 'Start Different synchronization'
							},
							{	xtype:'button',
								id:'stopButton',
								text : '<b>Stop</b>',
								handler : function() {
									var syncInfo=getSyncInfo();
									if(syncInfo)
									SynchronizationActionInterface.stop(refreshStatus(syncInfo),syncInfo);
								},
								tooltip : 'Stop synchronization'
							},
							{	xtype:'button',
								id:'resetButton',
								text : '<b>Reset</b>',
								handler : function() {
									var syncInfo=getSyncInfo();
									if(syncInfo)
									SynchronizationActionInterface.reset(refreshStatus(syncInfo),syncInfo);
								},
								tooltip : 'Reset synchronization'
							},

							]
				});

		 mainPanel = new Ext.Panel( {
			bodyStyle : 'padding:5px 5px 1',
			id:'synchronizationaction',
			border : true,
			closable:true,
			title : 'Synchronization Action',
			collapsible : true,
			items : [ topPanel ]
		});
	};
	var mainPanel;

   function showSync(){
    	var tabPanel = amalto.core.getTabPanel();
    	if(tabPanel.getItem('synchronizationaction') == undefined){
			show();			

    	}
		  tabPanel.add(mainPanel);
		  mainPanel.show();
		  //syncPanel.doLayout();
		  amalto.core.doLayout();   	
    };
    
    return {
    	//public 
        init : function(){
    		showSync();		  
        }
    };
}();


//Ext.onReady(SynchronizationAction.init, SynchronizationAction, true);