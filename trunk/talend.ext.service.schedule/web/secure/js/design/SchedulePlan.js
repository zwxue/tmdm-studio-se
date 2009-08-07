Ext.namespace('amalto.SrvSchedule.SchedulePlan');
amalto.SrvSchedule.SchedulePlan.SchedulePlan = function(config) {
	Ext.applyIf(this, config);
	this.initUIComponents();
	amalto.SrvSchedule.SchedulePlan.SchedulePlan.superclass.constructor
			.call(this);
};
Ext.extend(amalto.SrvSchedule.SchedulePlan.SchedulePlan, Ext.Panel, {
	initUIComponents : function() {
		// BEGIN OF CODE GENERATION PARTS, DON'T DELETE CODE BELOW
		Ext.apply(this, {
			title : "Schedule Plan",
			layout : "form",
			autoScroll : true,
			items : [{
				height : 140,
				layout : "form",
				title : "Basic Information",
				items : [{
					width : 250,
					fieldLabel : "Schedule Plan ID",
					xtype : "textfield",
					readOnly : true,
					name : "schedulePlanId",
					id : "schedulePlanId"
				}, {
					fieldLabel : "Status",
					xtype : "textfield",
					readOnly : true,
					name : "schedulePlanStatus",
					id : "schedulePlanStatus"
				}, {
					width : 350,
					height : 50,
					fieldLabel : "Description",
					xtype : "textarea",
					name : "schedulePlanDesc",
					id : "schedulePlanDesc"
				}],
				xtype : "fieldset"
			}, {
				height : 340,
				title : "Invoke Information",
				layout : "form",
				items : [{
					editable : false,
					fieldLabel : "Service Name",
					xtype : "combo",
					name : "serviceName",
					id : "serviceName"
				}, {
					editable : false,
					fieldLabel : "Method Name",
					xtype : "combo",
					name : "methodName",
					id : "methodName"
				}, {
					width : 550,
					height : 250,
					fieldLabel : "Parameters",
					xtype : "textarea",
					name : "parameters",
					id : "parameters"
				}],
				xtype : "fieldset"
			}, {
				height : 50,
				layout : "form",
				title : "Schedule Information",
				items : [{
					value : "0 0 0 * * ?",
					width : 200,
					fieldLabel : "Mode",
					xtype : "textfield",
					name : "mode",
					id : "mode"
				}],
				xtype : "fieldset"
			}],
			buttons : [{
				handler : function(button, event) {
					this.onInvokeClick(button, event);
				}.createDelegate(this),
				text : "Invoke"
			}, {
				handler : function(button, event) {
					this.onSaveClick(button, event);
				}.createDelegate(this),
				text : "Save"
			}, {
				handler : function(button, event) {
					this.onScheduleClick(button, event);
				}.createDelegate(this),
				text : "Schedule"
			}, {
				handler : function(button, event) {
					this.onUnscheduleClick(button, event);
				}.createDelegate(this),
				text : "Unschedule"
			}]
		});
		// END OF CODE GENERATION PARTS, DON'T DELETE CODE ABOVE
	}
});
