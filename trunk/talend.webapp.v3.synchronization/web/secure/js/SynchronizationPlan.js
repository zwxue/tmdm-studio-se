loadResource("/SynchronizationPlan/secure/js/SyncXMLPanel.js", "" );
loadResource("/SynchronizationPlan/secure/css/SynchronizationPlan.css", "" );

amalto.namespace("amalto.SynchronizationPlan");

amalto.SynchronizationPlan.SynchronizationPlan=function(){

    var recordType = Ext.data.Record.create([
	  //{name: "id", type: "int"},
	  {name:"itemPOJOPK"},
	  {name: "itemPK"},
	  {name: "localRevisionID", type: "string"},
	  {name: "lastRunPlan", type: "string"},
	  {name: "status", type: "string"},
	  {name:"remoteIntances"},
	  {name:"remoteItemNames"},
	  {name:"remoteNodes"},
	  {name:"node"}
	  
	  ]);

	  var store = new Ext.data.Store({
	    proxy: new Ext.data.DWRProxy(SynchronizationPlanInterface.getSyncItems, true),
	    reader: new Ext.data.ListRangeReader( 
				{id:'itemPK', totalProperty:'totalSize',root: 'data'}, recordType),
	    remoteSort: true
	  });
    
    var myColumns = [
    	//{header: "No", width: 25, sortable: true},
		{header: 'Item PK', width: 100, sortable: true,dataIndex: 'itemPK'}, 
		{header: 'Local Revision ID', width: 100,  sortable: true,dataIndex: 'localRevisionID'}, 
		{header: 'Last Run Synchronization Name', width: 120,  sortable: true,dataIndex: 'lastRunPlan'},
		{header: 'Status', width: 105, sortable: true,dataIndex: 'status'}
	];
   	var columnModel = new Ext.grid.ColumnModel(myColumns);
    var grid;
    var pageSize =22;
    var pagingToolbar;
    
    function showSyncItems(){
		var lineMax = DWRUtil.getValue('lineMaxItems');
		if(lineMax==null || lineMax=="")
			lineMax=50;		
		pageSize=lineMax;		    	
		store.load({params:{start:0, limit:pageSize}});
    };
    
    function show(){
   		Ext.QuickTips.init();
   	    // create the Grid
   	    grid = new Ext.grid.GridPanel({
   			    store: store,
   			    cm: columnModel,
   	    		viewConfig: {
   			    	autoFill:true,
   			        forceFit: true
   			    },
   	   	        id:'syncDataGrid',
   	   	        closable:true,
   	   	        stripeRows: true,
   	   	        height:350,
   	   	        width:600,				   	   	      
   	   	        title:'Synchronization Items',
	   	   	    viewConfig: {
	   	   	        forceFit: true,
	
	   	   	        //Return CSS class to apply to rows depending upon data values
	   	   	        getRowClass: function(record, index) {	   	   	        	
	   	   	            var status = record.get('status');
	   	   	            if (status == 'MANUAL') {
	   	   	                return 'conflictItem';
	   	   	            } 
	   	   	        }
	   	   	    },

   	   	        listeners:
   	   	        {
   	    			'rowdblclick' : function(grid,rowIndex, e ){
   	    				var record=grid.getStore().getAt(rowIndex);
   	    				//if(record.data.status == 'MANUAL'){
   	    					   	    					
   	   	    				var xmlData= SyncXMLPanel(record.data,store);
   	   	    				xmlData.init();  	    					
   	    				//}
   	    			}
   	   	        },
				tbar:[
						new Ext.form.TextField({
							id:'sync-criteria',
							//emptyText:LABEL_CRITERIA[language],
							emptyText:'*',
							listeners: {
			                	'specialkey': function(a, e) {
						            if(e.getKey() == e.ENTER) {
						            	showSyncItems();
						            } 
								}
			                }
						}),
						new Ext.Toolbar.Button({
							text:'Search',
							handler:showSyncItems
						})
					],
				bbar:[
					       
				   pagingToolbar=new Ext.PagingToolbar({
								id:'sync-pagingtoolbar',
								pageSize: parseInt(pageSize),
						        store: store,
						        displayInfo: true,
						        displayMsg: 'Displaying items'+' {0} - {1} '+'of'+' {2}',
						        emptyMsg: 'No result',
						        width: 800,
						        items:[ 
						        	new Ext.Toolbar.Separator(),
						        	new Ext.Toolbar.TextItem('Number of lines per page'+" : "),
						        	new Ext.form.TextField({
				    					id:'lineMaxItems',
				    					value:pageSize,
				    					width:30,
				    					//disabled:true,
				    					listeners: {
						                	'specialkey': function(a, e) {
									            if(e.getKey() == e.ENTER) {
													pagingToolbar.pageSize=parseInt(pageSize);
													showSyncItems();													
													//Ext.PagingToolbar toolbar=Ext.get('sync-pagingtoolbar');
													
									            } 
											}
						                }
						            }),
						        ]
						    })
		             ]
   	   	    }); 
   	   	
   	   	
   	   	store.on('beforeload', function(){
   	   	 var criteria;	
   	   	 if(Ext.get('sync-criteria')!=null){
   	   	 	criteria= DWRUtil.getValue('sync-criteria');
   	   	 }else{
   	   	 	criteria="*";
   	   	 }
   	   	  
         Ext.apply(this.baseParams,{
          regex: criteria
         });
        });
             
		store.load({params:{start:0, limit:pageSize}});
		store.on('load', function(){
	    
		});  
    };
    return {
        init : function(){
	    	var tabPanel = amalto.core.getTabPanel();
	    	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	    	if(tabPanel.getItem('syncDataGrid') == undefined){
	    		show();		   		
	    	}else{
	    		showSyncItems();
	    	}
	      tabPanel.add(grid);
		  grid.show();
		  amalto.core.doLayout();   
        }  	
    };
}();

//Ext.onReady(SynchronizationPlan.init, SynchronizationPlan, true);