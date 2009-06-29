/*
 * @include  "/com.amalto.webapp.core/web/secure/ext.ux/DWRProxy.js"
 * @include  "/com.amalto.webapp.core/web/secure/js/core.js"
 */
Ext.namespace('amalto.updatereport');
amalto.updatereport.UpdateReportPanel = function(config) {
	Ext.applyIf(this, config);
	this.initUIComponents();
	amalto.updatereport.UpdateReportPanel.superclass.constructor.call(this);
};
Ext.extend(amalto.updatereport.UpdateReportPanel, Ext.Panel, {
    initPageSize:20,
	initUIComponents : function() {

		this.recordType = Ext.data.Record.create([
		
		  {name: "concept", type: "string"},
		  {name: "key", type: "string"},
		  {name: "operationType", type: "string"},
		  {name: "timeInMillis", type: "string"},
		  {name: "source", type: "string"},
		  {name: "ids", type: "string"}
		  
		 ]);
		 
		this.store1 = new Ext.data.Store({
			 proxy: new Ext.data.DWRProxy(UpdateReportInterface.getUpdateReportList, true),
	         reader: new Ext.data.ListRangeReader( 
				{id:'keys', totalProperty:'totalSize',root: 'data'}, this.recordType),
	         remoteSort: false
		});
		
		this.store1.on('beforeload', 
		            function(button, event) {
						this.onBeforeloadStore();
					}.createDelegate(this)
        );

		this.gridPanel1 = new Ext.grid.GridPanel({
			id:"updateReportGridPanel",
			store : this.store1,
			layout : "fit",
			region : "center",
			selModel : new Ext.grid.RowSelectionModel({}),
			columns : [{
				hidden : false,
				header : "Concept",
				dataIndex : "concept",
				sortable : true
			}, {
				hidden : false,
				header : "Key",
				dataIndex : "key",
				sortable : true
			}, {
				hidden : false,
				header : "Operation type",
				dataIndex : "operationType",
				sortable : true
			}, {
				hidden : false,
				header : "Operation time",
				dataIndex : "timeInMillis",
				sortable : true
			}, {
				hidden : false,
				header : "Source",
				dataIndex : "source",
				sortable : true
			}],
			listeners:
   	   	    {
   	    			'rowdblclick' : function(grid,rowIndex, e ){
   	    				
   	    				var record=grid.getStore().getAt(rowIndex);
   	    				var ids = record.data.ids;
   	    				
   	    				var tabPanel = amalto.core.getTabPanel();
   	    				var dataLogViewer=tabPanel.getItem(ids+' Viewer');
						if( dataLogViewer== undefined){
							
							dataLogViewer=new amalto.updatereport.DataLogViewer({'ids':ids});
							tabPanel.add(dataLogViewer);							
						}
				        
				        dataLogViewer.show();
						dataLogViewer.doLayout();
						amalto.core.doLayout();
   	    				
   	    				
   	    			}
   	   	    },
			bbar : new Ext.PagingToolbar({
				id:"updateReportPagingToolbar",
				displayMsg : "Displaying items {0} - {1} of {2}",
				displayInfo: true,
				store : this.store1,
				xtype : "paging",
				emptyMsg : "No data to display",
				pageSize : this.initPageSize,
				items:[ 
		        	new Ext.Toolbar.Separator(),
		        	new Ext.Toolbar.TextItem("Number of lines per page"+" : "),
		        	new Ext.form.TextField({
    					id:'lineMaxItems',
    					value:this.initPageSize,
    					width:30,
    					listeners: {
		                	'specialkey': function(a, e) {
					            if(e.getKey() == e.ENTER) {
			                		var lineMax = DWRUtil.getValue('lineMaxItems');
									if(lineMax==null || lineMax=="")lineMax=20;
									Ext.getCmp("updateReportPagingToolbar").pageSize=parseInt(lineMax);
									Ext.getCmp("updateReportGridPanel").store.reload({params:{start:0, limit:lineMax}});
					            } 
							}
		                }
		            })
		        ]
			})
		});
		
	   this.sourceStore = new Ext.data.Store({
          proxy: new Ext.data.MemoryProxy([['genericUI','genericUI'],['adminWorkbench','adminWorkbench']]),
          reader: new Ext.data.ArrayReader({}, [
              {name: 'value',mapping: 0, type: 'string'},
              {name: 'text',mapping: 1}
          ]),
          autoLoad:true
       });
       
       this.operationTypeStore = new Ext.data.Store({
          proxy: new Ext.data.MemoryProxy([['CREATE','CREATE'],['UPDATE','UPDATE'],['DELETE','DELETE']]),
          reader: new Ext.data.ArrayReader({}, [
              {name: 'value',mapping: 0, type: 'string'},
              {name: 'text',mapping: 1}
          ]),
          autoLoad:true
       });
       
		Ext.apply(this, {
			layout : "border",
			title : "Update Report Panel",
			items : [this.gridPanel1, {
				frame : false,
				height : 150,
				layout : "fit",
				title : "Search Panel",
				collapsible : true,
				items : [{
					height : 30,
					layout : "column",
					items : [{
						columnWidth : ".5",
						layout : "form",
						items : [{
							name : "concept",
							fieldLabel : "Concept",
							xtype : "textfield"
						}, {
							name : "source",
							//emptyText : "Select a source...",
							fieldLabel : "Source",
							xtype : "combo",
							store: this.sourceStore,
							displayField:'text',
					        valueField:'value',   
					        typeAhead: true,
					        triggerAction: 'all',
					        forceSelection:true
						}, {
							name : "startDate",
							fieldLabel : "Start Date",
							xtype : "datefield",
							format : "Y-m-d H:i:s",
							width: 150,
							readOnly : false
						}],
						border : false
					}, {
						columnWidth : ".5",
						layout : "form",
						items : [{
							name : "key",
							fieldLabel : "Key",
							xtype : "textfield"
						}, {
							name : "operationType",
							//emptyText : "Select a type...",
							fieldLabel : "Operation type",
							xtype : "combo",
							store: this.operationTypeStore,
							displayField:'text',
					        valueField:'value',   
					        typeAhead: true,
					        triggerAction: 'all',
					        forceSelection:true
						}, {
							name : "endDate",
							fieldLabel : "End Date",
							xtype : "datefield",
							format : "Y-m-d H:i:s",
							width: 150,
							readOnly : false
						}],
						border : false
					}],
					border : false
				}],
				region : "north",
				buttons : [{
					handler : function(button, event) {
						this.onResetBtnClick(button, event);
					}.createDelegate(this),
					text : "Reset"
				},{
					handler : function(button, event) {
						this.onSearchBtnClick(button, event);
					}.createDelegate(this),
					text : "Search"
				}]
			}],
			id : "UpdateReportPanel",
			closable:true
		});
		
	},
	
	initListData : function(){

		this.store1.load({params:{start:0, limit:this.initPageSize}});
		
    },
    
    onSearchBtnClick : function(button, event){
    	
		var pageSize=Ext.getCmp("updateReportPagingToolbar").pageSize;
		this.store1.reload({params:{start:0, limit:pageSize}});
		
    },
    
    onResetBtnClick : function(button, event){
    	
		DWRUtil.setValue('concept','');
		DWRUtil.setValue('key','');
		DWRUtil.setValue('source','');
        DWRUtil.setValue('operationType','');
        DWRUtil.setValue('startDate','');
        DWRUtil.setValue('endDate','');
        
    },
    
    getRequestParam : function(){
    	var requestParam="";

		var concept = DWRUtil.getValue('concept');
		if(concept!="")requestParam+=",concept:'"+concept+"'";
		var key = DWRUtil.getValue('key');
		if(key!="")requestParam+=",key:'"+key+"'";
		var source = DWRUtil.getValue('source');
		if(source!="")requestParam+=",source:'"+source+"'";
		var operationType = DWRUtil.getValue('operationType');
		if(operationType!="")requestParam+=",operationType:'"+operationType+"'";
		var startDate = DWRUtil.getValue('startDate');
		if(startDate!="")requestParam+=",startDate:'"+startDate+"'";
		var endDate = DWRUtil.getValue('endDate');
		if(endDate!="")requestParam+=",endDate:'"+endDate+"'";
		
		if(requestParam!=""){
		requestParam=requestParam.substring(1)
		requestParam="{"+requestParam+"}";
		}
		
		return requestParam;
    },
    
    onBeforeloadStore : function(){
    	    var criteria="";	
   	   	 	criteria=this.getRequestParam();
   	   	 	//alert(criteria);
            Ext.apply(this.store1.baseParams,{
              regex: criteria
            });
    }

});
