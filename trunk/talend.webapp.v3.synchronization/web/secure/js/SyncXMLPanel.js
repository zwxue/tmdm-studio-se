/*
 * Synchronization for conflict data
 */
//
// Extend the XmlTreeLoader to set some custom TreeNode attributes specific to our application:


var SyncXMLPanel= function(syncItem,store){
	var syncPlanStore=store;
	this.syncItem=syncItem;

	var remoteNames=[];
	var remoteItems=function(){
		var ret=[];
		for(var i=0; i<syncItem.remoteItemNames.length; i++){
			remoteNames.push([syncItem.remoteItemNames[i]]);
		}				
	}();
	
	var currentIndex=0;
	function setSourceNode(index){		
		//clear
		var childNodes=sourceTree.getRootNode().childNodes;
		for(var i=0; i<childNodes.length; i++){
			sourceTree.getRootNode().removeChild(childNodes[i]);
		}
		//append
		if(index >= 0 && index <syncItem.remoteNodes.length){
			sourceTree.getRootNode().appendChild(createTreeNode(syncItem.remoteNodes[index]));
			//sourceTree.title='Source [' + remoteNames[index] +']';
			currentIndex=index;
		}
	};
	function createTreeNode(node){
		var treeNode= new Ext.tree.TreeNode({'text':node.text,'leaf':node.leaf,'expanded':true});		
		if(node.childNodes){
			for(var i=0; i<node.childNodes.length; i++){
				var childNode=node.childNodes[i];
				if(childNode.leaf == true){					
					var child= new Ext.tree.TreeNode({'text':childNode.text,'leaf':childNode.leaf,'expanded':true});
					treeNode.appendChild(child);
				}else{
					treeNode.appendChild(createTreeNode(childNode));
				}
			}
		}		
		return treeNode;
	};

    var datastore = new Ext.data.SimpleStore({
        fields: ['filename'],
        data:remoteNames
    });    
    // The action
    var addAction = new Ext.Action({
        text: '<b>Add</b>',        
        handler: function(){
        	if(targetSelectNode && sourceSelectNode){
					Ext.MessageBox.confirm('Confirm', 'Are you sure you want to <b>Add</b> source tree selected item as child of target tree selected Item ?', addOne); 
			}else{
		        Ext.MessageBox.show({
		           title: 'Warning',
		           msg: 'You must select one item of <b>source</b> tree and <b>target</b> tree!',
		           buttons: Ext.MessageBox.OK,			           
		           icon: Ext.MessageBox.WARNING
		       });							
			}
        },
        tooltip:'<b>Add</b><br/>Add source tree selected item as child of target tree selected item'
        
    });
    var replaceAction = new Ext.Action({
        text: '<b>Replace</b>',
        handler: function(){
           if(targetSelectNode && sourceSelectNode){
          	var tParentNode=targetSelectNode.parentNode;
          	if(tParentNode){        	
           		Ext.MessageBox.confirm('Confirm', 'Are you sure you want to <b>Replace</b> target selected Item with source selected Item ?', replaceOne); 
           	}
          }else{
	        Ext.MessageBox.show({
	           title: 'Warning',
	           msg: 'You must select one item of source tree and target tree!',
	           buttons: Ext.MessageBox.OK,			           
	           icon: Ext.MessageBox.WARNING
	       });          	
          }
        },
        tooltip:'<b>Replace</b><br/>Replace source tree selected item with target tree selected item'
    });    
    var leftAction=new Ext.Action({
        text: '<b><--</b>',
        tooltip:'Upper level',
        handler: function(){
            if(targetSelectNode){
            	var tParentNode=targetSelectNode.parentNode;
            	if(tParentNode && tParentNode.parentNode){           		
            		targetSelectNode=tParentNode.parentNode.insertBefore(targetSelectNode,tParentNode.parentNode.item[0]);
             		tParentNode.parentNode.expand();
            		targetSelectNode.select(); 		
            	}
            }                        
        }
    }); 
    var rightAction=new Ext.Action({
        text: '<b>--></b>',
        tooltip:'Lower level',
        handler: function(){
            if(targetSelectNode){           	     
        		var sibling=targetSelectNode.previousSibling;
        		if(!sibling){
        			sibling=targetSelectNode.nextSibling;
        		}
        		if(sibling){
            		if(sibling.childNodes.length>0)
            			targetSelectNode=sibling.insertBefore(targetSelectNode,sibling.item[0]);
            		else
            			targetSelectNode=sibling.appendChild(targetSelectNode);
            		sibling.expand();
            		targetSelectNode.select(); 		
        		}
            	
            }                        
        }
    });    
    var upAction = new Ext.Action({
        text: '<b>Up</b>',
        handler: function(){
            if(targetSelectNode){
            	var tParentNode=targetSelectNode.parentNode;
            	if(tParentNode){
            		var index=tParentNode.indexOf(targetSelectNode);            		
            		index--;
            		// first then insert as it's parent's last child
            		if(index < 0){
            			//if(tParentNode.parentNode)targetSelectNode=tParentNode.parentNode.insertBefore(targetSelectNode,tParentNode);
            		}else{
            			targetSelectNode=tParentNode.insertBefore(targetSelectNode,targetSelectNode.previousSibling);
            		}           
            		targetSelectNode.select(); 		
            	}
            }                        
        }
    }); 
    var downAction = new Ext.Action({
        text: '<b>Down</b>',
        handler: function(){
            if(targetSelectNode){
            	var tParentNode=targetSelectNode.parentNode;
            	if(tParentNode){
            		var index=tParentNode.indexOf(targetSelectNode);            		
            		index++;
            		// first then insert as it's parent's last child
            		if(index == tParentNode.childNodes.length){            			
            			//targetSelectNode=tParentNode.parentNode.appendChild(targetSelectNode);           			
            		}else{
            			targetSelectNode=tParentNode.insertBefore(targetSelectNode,targetSelectNode.nextSibling.nextSibling);
            		} 
            		targetSelectNode.select(); 		           		
            	}
            }            
        }
        
    });        
    var deleteAction = new Ext.Action({
        text: '<b>Delete</b>',
        handler: function(){
        	if(targetSelectNode && targetSelectNode!= targetTree.getRootNode()){
        	 	Ext.MessageBox.confirm('Confirm', 'Are you sure you want to delete the selected item?', deleteOne);
        	}                     
        }
    });     
    function getTreeNode(node,children){
    	for(var i=0; i<node.childNodes.length; i++){
    		var child=node.childNodes[i];
    		if(child.childNodes.length==0){
    			children.push({leaf:true,text:child.text,childNodes:new Array()});
    		}else{
    			var treeNode={leaf:false,text:child.text,childNodes:new Array()};
    			children.push(treeNode);
    			getTreeNode(child,treeNode.childNodes);
    		}
    	}
    };
    
    function saveSyncPlan(){
        Ext.MessageBox.show({
           msg: 'Saving your data, please wait...',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:100}          
       });
        setTimeout(function(){
            //This simulates a long-running operation like a database save or XHR call.
            // In real code, this would be in a callback function.
    	//convert Ext.tree.TreeNode to java TreeNode
    	var root=targetTree.getRootNode().childNodes[0];
    	var children=new Array();
    	getTreeNode(root,children);
    	var saveRoot={leaf:false,text:root.text,childNodes:children};
    	//set RESOLVED to syncItem   	
    	syncItem.node=saveRoot;
    	SynchronizationPlanInterface.saveSyncItem(function(isSaveOk){
    		Ext.MessageBox.hide();
    		if(isSaveOk == true){
    			//syncItem.status='RESOLVED';   	    	
    	        Ext.MessageBox.alert('Status', 'Changes saved successfully.');   			
    			var tabPanel = amalto.core.getTabPanel();
    			tabPanel.remove(syncPanel);
    			syncPlanStore.reload();
    		}
    	},syncItem);
        }, 1000);    	
    };
    
    
    function deleteOne(btn){
    	if(btn == 'yes'){
				if(targetSelectNode)targetSelectNode.parentNode.removeChild(targetSelectNode); 
		  }     	
    };
    function replaceOne(btn){
    	if(btn == 'yes'){
           if(targetSelectNode && sourceSelectNode){
          	var tParentNode=targetSelectNode.parentNode;
          	if(tParentNode){
          		targetSelectNode=tParentNode.replaceChild(sourceSelectNode,targetSelectNode);  
          		tParentNode.expand();
          		setSourceNode(currentIndex);
          	}
          }    		
    	}
    };
    function addOne(btn){
    	if(btn == 'yes'){
        if(targetSelectNode && sourceSelectNode){
        	sourceSelectNode=targetSelectNode.appendChild(sourceSelectNode);
        	targetSelectNode.expand();
        	sourceSelectNode.select();
        	setSourceNode(currentIndex);
        }    		
    	}
    };
    var saveAction = new Ext.Action({
        text: '<b>Resolve</b>',
        handler: function(){
            saveSyncPlan();
        }
    }); 
    var targetRoot=new Ext.tree.TreeNode({text:'','expanded':true});    
    targetRoot.appendChild(createTreeNode(syncItem.node));        
    // target tree
    var targetTree = new Ext.tree.TreePanel({              
        columnWidth:.43,
        bodyStyle:'padding:5px 5px 1',
        title:'Target',
        border:true,
        height:400,
        animate:true, 
        autoScroll:true,
        rootVisible: false,
        root: targetRoot,
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        buttons:[new Ext.Button(leftAction),new Ext.Button(rightAction),new Ext.Button(upAction), new Ext.Button(downAction), new Ext.Button(deleteAction)],
        listeners: {
            'render': function(tp){
                  tp.getSelectionModel().on('selectionchange', function(tree, node){
                      targetSelectNode=node;                     
                  });
            }
        }        
    });
    
    var targetSelectNode;
    var sourceSelectNode;
    var sourceRoot=new Ext.tree.TreeNode({text:'','expanded':true});
    sourceRoot.appendChild(createTreeNode(syncItem.remoteNodes[0]));
    // source tree
    var sourceTree = new Ext.tree.TreePanel({                       
        title:'Source',
        bodyStyle:'padding:5px 5px 1',
        border:true,
        height:370,
        animate:true,
        autoScroll:true,
        rootVisible: false,
	    root: sourceRoot,
        containerScroll: true,
        enableDD:false,
        dropConfig: {appendOnly:true},
        listeners: {
            'render': function(tp){
                  tp.getSelectionModel().on('selectionchange', function(tree, node){
                      sourceSelectNode=node;
                  });
            }
        }                
    });
   
    // combo
    var combo = new Ext.form.ComboBox({       
        store: datastore,
        width:'100%',
        displayField:'filename',
        border:true,
        typeAhead: true,
        id:'combo',
        mode: 'local',
        triggerAction: 'all',
        emptyText:'Select a remote data...',
        selectOnFocus:true,
        listeners:{
        	'select': function(combo,record,index){
        		setSourceNode(index);
    		}
        }
    }); 
      
    // main panel
    var syncPanel;      
    // button panel
    var buttonPanel;
    // source panel
    var sourcePanel;
    
    //data
    var syncItem;
// -------------------------------------------------------------

   function showSync(){
    	var tabPanel = amalto.core.getTabPanel();
    	//if(tabPanel.getItem('synchronizationplan') == undefined){
	   		Ext.QuickTips.init();
			
			buttonPanel = new Ext.Panel({
			bodyStyle:'padding:5px 5px 0',
	        layout:'form',
	        columnWidth:0.14,
	        buttonAlign:'center',
	        border:false,
	        height:100,
	        items:[
	        new Ext.Button(addAction), new Ext.Button(replaceAction)],					        					        
			}); 
	
			sourcePanel = new Ext.Panel({
			columnWidth:.43,			            
	        border:false,
		    items:[sourceTree,combo],					        					        
		  }); 
		   
			syncPanel = new Ext.Panel({
			bodyStyle:'padding:5px 5px 1',
	        layout:'column',
	        //id:'synchronizationplan',
	        deferredRender: false,
	        closable: true,
	        border:false,
		        title: 'Synchronization conflict data',		        
		        items:[	targetTree, buttonPanel, sourcePanel],
		        tbar: [
		            saveAction
		        ]					        					        
		  }); 	  
    	//}
		  tabPanel.add(syncPanel);
		  syncPanel.show();
		  //syncPanel.doLayout();
		  amalto.core.doLayout();   	
    };
    return {
    	//public 
        init : function(){
    		showSync();		  
        },
    	saveSync:function(){
        	saveSyncPlan();
        },
    };
};
