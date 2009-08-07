Ext.namespace('amalto.SrvSchedule.ScheduleManager');
amalto.SrvSchedule.ScheduleManager.ScheduleManager = function(config) {
	Ext.applyIf(this, config);
	this.initUIComponents();
	amalto.SrvSchedule.ScheduleManager.ScheduleManager.superclass.constructor
			.call(this);
};
Ext.extend(amalto.SrvSchedule.ScheduleManager.ScheduleManager, Ext.Panel, {
	initUIComponents : function() {
		// BEGIN OF CODE GENERATION PARTS, DON'T DELETE CODE BELOW
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
			layout : "anchor",
			title : "Service Schedule",
			items : [{
				items : [{
					text : "Service Scheduler Status: ",
					xtype : "label"
				}, {
					text : "STARTED",
					xtype : "label"
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
						this.onTestClick(button, event);
					}.createDelegate(this),
					text : "Test"
				}],
				bodyBorder : true,
				buttonAlign : "left"
			}, this.gridPanel1],
			tbar : new Ext.Toolbar([]),
			id : "SrvScheduleManager"
		});
		// END OF CODE GENERATION PARTS, DON'T DELETE CODE ABOVE
	}
});
