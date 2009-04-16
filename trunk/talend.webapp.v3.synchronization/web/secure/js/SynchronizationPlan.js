
loadResource("/SynchronizationPlan/secure/js/SyncXMLPanel.js", "" );

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
	    proxy: new Ext.data.DWRProxy(SynchronizationPlanInterface.getSyncItems, false),
	    reader: new Ext.data.ListRangeReader( 
				{id:'itemPK', totalProperty:'totalSize'}, recordType),
	    remoteSort: false
	  });
    
    var myColumns = [
    	//{header: "No", width: 25, sortable: true},
		{header: 'itemPK', width: 120, sortable: true,dataIndex: 'itemPK'}, 
		{header: 'localRevisionID', width: 165,  sortable: true,dataIndex: 'localRevisionID'}, 
		{header: 'lastRunPlan', width: 135,  sortable: true,dataIndex: 'lastRunPlan'},
		{header: 'status', width: 105, sortable: true,dataIndex: 'status'}
	];
   	var columnModel = new Ext.grid.ColumnModel(myColumns);
    var grid;
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
   	   	        listeners:
   	   	        {
   	    			'rowdblclick' : function(grid,rowIndex, e ){
   	    				var record=grid.getStore().getAt(rowIndex);
   	    				if(record.data.status == 'MANUAL'){
   	    					record.data.remoteIntances.key;  	    					
   	   	    				var xmlData=new SyncXMLPanel(record.data);
   	   	    				xmlData.init();  	    					
   	    				}
   	    			}
   	   	        }
   	   	    }); 
		store.load({params:{start:0, limit:22}, arg:[]});
		store.on('load', function(){
	    alert( store.getTotalCount()  )
		});  
    };
    return {
        init : function(){
	    	var tabPanel = amalto.core.getTabPanel();
	    	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	    	if(tabPanel.getItem('syncDataGrid') == undefined){
	    		show();		   		
	    	}
	      tabPanel.add(grid);
		  grid.show();
		  amalto.core.doLayout();   
        }  	
    };
}();

//Ext.onReady(SynchronizationPlan.init, SynchronizationPlan, true);