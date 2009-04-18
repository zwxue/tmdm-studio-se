amalto.namespace("amalto.SynchronizationAction");

loadResource("/SynchronizationAction/secure/js/Cookies.js", "" );

//contectid.applicaionid
amalto.SynchronizationAction.SynchronizationAction = function() {
	var SELECT_SYNCHRONIZATION='Select a Synchronization Name';
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
			serverURL:$('serverURL').value.trim(),
			username:$('username').value.trim(),
			password:$('password').value.trim(),
			syncName:$('syncName').value.trim()
		};
		return syncInfo;
	}

	function initSyncNames(){
		var syncinfo=getSyncInfo();
		if(syncinfo){
			
			SynchronizationActionInterface.getSyncNames(syncinfo,function(syncs){
				var syncnames=syncs;
				var tmp=[SELECT_SYNCHRONIZATION];
				DWRUtil.removeAllOptions("syncName");
				DWRUtil.addOptions("syncName",tmp);
				if(!syncnames)return;
				DWRUtil.addOptions("syncName",syncnames);	
			});		
		}
	};

	function updateStatus(syncStatus){
		if(syncStatus){
			synccode=syncStatus;
			Ext.getCmp('status').getEl().update('[' + syncStatus.value + '] ' + syncStatus.message);
			if('RUNNING' == syncStatus.value || 'SCHEDULED' == syncStatus.value){
	    		Ext.getCmp('startFullButton').disable();
	    		Ext.getCmp('startDifferentButton').disable();
	    		Ext.getCmp('stopButton').enable();
	    		Ext.getCmp('resetButton').disable();
			}
			else if ("STOPPING" == syncStatus.value) {
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
	function keepInCookies(){
		Cookies.set('serverURL',$('serverURL').value.trim());
		Cookies.set('username',$('username').value.trim());
	};
	var synccode;
	
	function refreshStatus(syncInfo){
		var timer=setInterval(function(){
			SynchronizationActionInterface.getStatus(syncInfo,function(syncStatus){
				if(syncStatus==null){
					clearInterval(timer);
					return;
				}
				updateStatus(syncStatus);
			});
			if(synccode){
				if(!('RUNNING' == synccode.value || 'SCHEDULED' == synccode.value)){
					clearInterval(timer);
					updateStatus(synccode);
				}
			}			
		},1000);		
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
					id : 'serverURL',
					text:Cookies.get('serverURL'),
					width : 400
				}, {
					fieldLabel : 'UserName',
					id : 'username',
					selectOnFocus:true,
					allowBlank:false,
					text:Cookies.get('username'),
					width : 400
				}, {
					fieldLabel : 'Password',
					id : 'password',
					selectOnFocus:true,
					allowBlank:false,
					inputType:'password',
					width : 400,
			        listeners:{
			        	'blur': function(){										
							initSyncNames();
			    		}
					}
				}]
			}),
			new Ext.Panel({
					width : 400,
					border:false,
					html:'<div> Synchronization Name:    '+'<select id="syncName" ><option value="Select a SyncName..."></option></select></div>' 
				}) 
			
			, {
				id : 'status',
				xtype : 'box',
				autoEl : {
					cn : ''
				}
			} ],
			buttons : [ 							
					{	
						xtype:'button',
						id:'startFullButton',
						text : '<b>Start Full</b>',
						handler : function() {
							var syncInfo=getSyncInfo();
							if(syncInfo){
								keepInCookies();
								SynchronizationActionInterface.startFull(refreshStatus(syncInfo),syncInfo);
							}
						},
						tooltip : 'Start synchronization'
					},
					{	xtype:'button',
						id:'startDifferentButton',
						text : '<b>Start Different</b>',
						handler : function() {
							var syncInfo=getSyncInfo();
							if(syncInfo){
								keepInCookies();
								SynchronizationActionInterface.startDifferent(refreshStatus(syncInfo),syncInfo);
							}
						},
						tooltip : 'Start Different synchronization'
					},
					{	xtype:'button',
						id:'stopButton',
						text : '<b>Stop</b>',
						disabled:true,
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
						disabled:true,
						handler : function() {
							var syncInfo=getSyncInfo();
							if(syncInfo)
							SynchronizationActionInterface.reset(refreshStatus(syncInfo),syncInfo);
						},
						tooltip : 'Reset synchronization'
					}
					],
			listeners:{
				'render':function(){
					Ext.getCmp('serverURL').setValue(Cookies.get('serverURL'));
					Ext.getCmp('username').setValue(Cookies.get('username'));
					
				}
			}		
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
    	 //refreshStatus();
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