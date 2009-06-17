/*
 * @include  "/com.amalto.webapp.core/web/secure/ext.ux/DWRProxy.js"
 * @include  "/com.amalto.webapp.core/web/secure/js/core.js"
 */
 
amalto.namespace("amalto.ItemsTrash");
//contextid.appid
amalto.ItemsTrash.ItemsTrash=function(){
	
     loadResource("/ItemsTrash/secure/css/ItemsTrash.css", "" );

    var recordType = Ext.data.Record.create([
   
	  {name:"itemPK"},
	  {name:"uniqueId"},
	  {name:"conceptName"},
	  {name:"uniqueId"},
	  {name:"ids"},
	  {name:"partPath"},
	  {name:"insertionTime"},
	  {name:"insertionUserName"},
	  {name:"projection"},
	  {name:"revisionID"},
	  {name: null, type: "string"},
	  {name: null, type: "string"}
	  ]);

     var store = new Ext.data.Store({
	    proxy: new Ext.data.DWRProxy(ItemsTrashInterface.getTrashItems, true),
	    reader: new Ext.data.ListRangeReader( 
				{id:'uniqueId', totalProperty:'totalSize',root: 'data'}, recordType),
	    remoteSort: false
	  });
    var grid;
    var pageSize =22;
    var pagingToolbar;
    
    	
		function deleteItem(){
			return "<img src='img/genericUI/delete.gif' border=\"0\" />";
		}
		function restore(){
			return "<img src='img/genericUI/restore.gif' border=\"0\" />";
		}
    
    function showTrashItems(){
		var lineMax = DWRUtil.getValue('lineMaxItems');
		var criteria = DWRUtil.getValue('trash-criteria');
		if(lineMax==null || lineMax=="")
			lineMax=50;		
		pageSize=lineMax;
		pagingToolbar.pageSize=parseInt(pageSize);		    	
		store.load({params:{start:0, limit:pageSize}});
    };

    function toDelete(pk,partPath,revisionID,conceptName,ids){
    	Ext.MessageBox.confirm("confirm","Are you sure to delete the this physically?",function de(e){
    		if(e.toLocaleString()=="yes")
    			ItemsTrashInterface.removeDroppedItem(pk,partPath,revisionID,conceptName,ids,showTrashItems);
    		else
    			showTrashItems();
    		}) ;
    }
    function toRestore(pk,partPath,revisionID,conceptName,ids){
    	
    	Ext.MessageBox.confirm("confirm","Are you sure to restore this item?",function re(en){
    		if(en=="yes")
    			ItemsTrashInterface.recoverDroppedItem(pk,partPath,revisionID,conceptName,ids,showTrashItems);
    		else
    			showTrashItems();
    		});
    }

    function show(){
    	var myColumns = [
    	//{header: "No", width: 25, sortable: true},
		{header: 'dataClusterName',  sortable: true,dataIndex: 'itemPK'}, 
		{header: 'revisionID',   sortable: true,dataIndex: 'revisionID'}, 
		{header: 'conceptName',   sortable: true,dataIndex: 'conceptName'},
		{header: 'ids',  sortable: true,dataIndex: 'ids'},
		{header: 'partPath', sortable: true,dataIndex: 'partPath'},
		{header: 'UserName', sortable: true,dataIndex: 'insertionUserName'},
		{header: 'Date',  sortable: true,dataIndex: 'insertionTime'},
		{header: 'delete', sortable: false, renderer:deleteItem},
		{header: 'restore', sortable: false, renderer:restore}
	    ];
   	    var columnModel = new Ext.grid.ColumnModel(myColumns);
   	    columnModel.defaultWidth;
   	
   		Ext.QuickTips.init();
   	    // create the Grid
   	    grid = new Ext.grid.GridPanel({
   			    store: store,
   			    cm: columnModel,
   	    		viewConfig: {
   			    	autoFill:true,
   			        forceFit: true
   			    },
   	   	        id:'trashDataGrid',
   	   	        closable:true,
   	   	        stripeRows: true,
   	   	        height:350,
   	   	        width:600,				   	   	      
   	   	        title:'itemsTrash',
	   	   	    viewConfig: {
	   	   	        forceFit: true
	   	   	    },

   	   	        listeners:
   	   	        {
		   						cellclick: function(g, rowIndex,  columnIndex, e){
		   						var record = g.getStore().getAt(rowIndex);
		   						if(columnIndex==7){
		   							
		   							toDelete(record.data.itemPK,record.data.partPath,record.data.revisionID,record.data.conceptName,record.data.ids);
		   						}
		   						else{ 
		   							if(columnIndex==8){
		   								toRestore(record.data.itemPK,record.data.partPath,record.data.revisionID,record.data.conceptName,record.data.ids);
		   							}
		   						}
		   						
		                	} 	
		   
   	   	        },
				tbar:[
						new Ext.form.TextField({
							id:'trash-criteria',
							emptyText:'*',
							hideLabel:true,
							blankText:'blankText',
							fieldLabel:'fieldLabel',
							listeners: {
			                	'specialkey': function(a, e) {
						            if(e.getKey() == e.ENTER) {
						            	showTrashItems();
						            } 
								}
			                }
			                
						}),
						new Ext.Toolbar.Button({
							text:'search',
							tooltip:'first four properties can be searched',
							handler:showTrashItems
						})
					],
				bbar:[
					       
				   pagingToolbar=new Ext.PagingToolbar({
								id:'trash-pagingtoolbar',
								pageSize: parseInt(pageSize),
						        store: store,
						        displayInfo: true,
						       // displayMsg: 'Displaying items'+' {0} - {1} '+'of'+' {2}',
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
						                	'specialkey': function(a, ee) {
//						                		alert("test "+ee.getKey());
						                		
									            if(ee.getKey() == ee.ENTER) {
									            	
													showTrashItems();													
									            } 
											}
						                }
						            })
						        ]//items
						    })
		             ]
   	   	    }); 
   	   	
	   	
   	   	store.on('beforeload', function(){
   	   	 var criteria;	
   	   	 if(Ext.get('trash-criteria')!=null){
   	   	 	criteria= DWRUtil.getValue('trash-criteria');
   	   	 }else{
   	   	 	criteria="*";
   	   	 }
   	   	  
         Ext.apply(this.baseParams,{
          regex: criteria
         });
        });
           	
		store.load({params:{start:0, limit:pageSize}});
    };
    return {
        init : function(){
        	var tabPanel = amalto.core.getTabPanel();
	    	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	    	if(tabPanel.getItem('trashDataGrid') == undefined){
	    		show();		   		
	    	}else{
	    		showTrashItems();
	    	}
	      tabPanel.add(grid);
		  grid.show();
		  amalto.core.doLayout(); 	   		
	    	 
        } 	//init
    };//return
}();//ItemStrashPlan

