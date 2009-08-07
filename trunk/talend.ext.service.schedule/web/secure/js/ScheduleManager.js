/*
 * @include  "/talend.ext.service.schedule/web/secure/js/SchedulePlan.js"
 */
 
Ext.namespace('amalto.SrvSchedule');
amalto.SrvSchedule.ScheduleManager = function(config) {
	Ext.applyIf(this, config);
	this.initUIComponents();
	amalto.SrvSchedule.ScheduleManager.superclass.constructor
			.call(this);
};
Ext.extend(amalto.SrvSchedule.ScheduleManager, Ext.Panel, {
	initUIComponents : function() {
		this.store1 = new Ext.data.Store({
			reader : new Ext.data.JsonReader({
				total : "total",
				root : "root",
				id : "id"
			}, [{
				mapping : "name",
				name : "name"
			}, {
				mapping : "age",
				type : "int",
				name : "age"
			}]),
			proxy : new Ext.data.HttpProxy({})
		});

		this.gridPanel1 = new Ext.grid.GridPanel({
			store : this.store1,
			title : "Schedule Plans",
			selModel : new Ext.grid.RowSelectionModel({}),
			columns : [{
				hidden : false,
				header : "ID",
				dataIndex : "ID",
				sortable : true
			}, {
				hidden : false,
				header : "Status",
				dataIndex : "Status",
				sortable : true
			}, {
				hidden : false,
				header : "Description",
				dataIndex : "Description",
				sortable : true
			}],
			bbar : new Ext.PagingToolbar({
				displayMsg : "Displaying {0} - {1} of {2}",
				store : this.store1,
				xtype : "paging",
				emptyMsg : "No data to display"
			})
		});

		Ext.apply(this, {
			title : "Service Schedule",
			layout : "anchor",
			items : [{
				items : [{					
					width : 150,
					fieldLabel : "Scheduler Status",
					xtype : "textfield",
					readOnly : true,
					//disabled : true,
					name : "status-srvscheduler",
					id : "status-srvscheduler"
				}],
				region : "",
				border : false,
				buttons : [{
					handler : function(button, event) {
						this.onStartClick(button, event);
					}.createDelegate(this),
					text : "Start"
				}, {
					handler : function(button, event) {
						this.onStandbyClick(button, event);
					}.createDelegate(this),
					text : "Standby"
				}, {
					handler : function(button, event) {
						this.onShutdownClick(button, event);
					}.createDelegate(this),
					text : "Shutdown"
				}, {
					handler : function(button, event) {
						this.onNewPlanClick(button, event);
					}.createDelegate(this),
					text : "New Plan"
				}],
				buttonAlign : "left",
				bodyBorder : true,
				bodyStyle:'padding:5px',
				layout : "form"
			}, this.gridPanel1],
			tbar : new Ext.Toolbar([]),
			id : "SrvScheduleManager",
			closable:true
		});
	},
	
	onNewPlanClick : function(button, event){

		var pid = "newServiceSchedulePlan";
   	    				
   	    var tabPanel = amalto.core.getTabPanel();
   	    var	srvPlan=tabPanel.getItem(pid);
		if( srvPlan== undefined){
							
			srvPlan=new amalto.SrvSchedule.SchedulePlan({'pid':pid});
			tabPanel.add(srvPlan);							
		
		}
				        
	    srvPlan.show();
		srvPlan.doLayout();
		amalto.core.doLayout();
		
		srvPlan.initData();
						
    },
    
    initData : function(){
	   this.updateStatusLabel();
    },
    
    updateStatusLabel : function(){
	   SrvScheduleInterface.getServiceSchedulerStatus(function(status){
	   	    DWRUtil.setValue('status-srvscheduler', status);
		});
    },
    
    onStartClick : function(button, event){
	   SrvScheduleInterface.startServiceScheduler(function(){
            this.updateStatusLabel()
		}.createDelegate(this));
    },
    
    onStandbyClick : function(button, event){
	   SrvScheduleInterface.standbyServiceScheduler(function(){
            this.updateStatusLabel()
		}.createDelegate(this));
    },
    
    onShutdownClick : function(button, event){
	   SrvScheduleInterface.shutdownServiceScheduler(function(){
            this.updateStatusLabel()
		}.createDelegate(this));
    }
   
});
