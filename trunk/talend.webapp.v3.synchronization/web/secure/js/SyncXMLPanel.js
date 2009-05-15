SyncXMLPanel = function(syncItem,store){	
	var remoteNames=[];	
	for(var i=0; i<syncItem.remoteItemNames.length; i++){
		remoteNames.push([syncItem.remoteItemNames[i]]);
	}				
	
   function showConflictNode(sourceNode, targetNode){
	   if(sourceNode.text != targetNode.text){
		   setNodeConflict(targetNode);
		   setNodeConflict(sourceNode);
	   }
	   for(var i=0;i<targetNode.childNodes.length; i++){
		   if(sourceNode.childNodes[i]){
			   if(targetNode.childNodes[i].text != sourceNode.childNodes[i].text ||
					   targetNode.childNodes[i].childNodes.length != sourceNode.childNodes[i].childNodes.length){
				   setNodeConflict(targetNode.childNodes[i]);
				   setNodeConflict(sourceNode.childNodes[i]);
			   }else{
				   showConflictNode(sourceNode.childNodes[i],targetNode.childNodes[i]);
			   }
		   }
	   }
   };
   function setNodeConflict(node){
	   node.cls='conflictItem';	
	   //node.checked=true;
	   for(var i=0;i<node.childNodes.length; i++){
		   if(node.childNodes[i].leaf == true){
			   node.childNodes[i].cls='conflictItem';
			   //node.childNodes[i].checked=true;
		   }else{
			   setNodeConflict(node.childNodes[i]);
		   }
	   }
   };
	
	var currentIndex=0;
	function setSourceNode(index){		
		if(index == currentIndex) return;
		//clear
		var childNodes=sourceTree.getRootNode().childNodes;
		for(var i=0; i<childNodes.length; i++){
			sourceTree.getRootNode().removeChild(childNodes[i]);
		}
		showConflictNode(syncItem.remoteNodes[index],syncItem.node);
		//append
		if(index >= 0 && index <syncItem.remoteNodes.length){
			sourceTree.getRootNode().appendChild(createTreeNode(syncItem.remoteNodes[index]));
			//sourceTree.title='Source [' + remoteNames[index] +']';
			currentIndex=index;
		}		
	};
	function createTreeNode(node){	
		var treeNode= new Ext.tree.TreeNode({'text':node.text,'leaf':node.leaf,'expanded':true,'cls':node.cls,'checked':node.checked});				
		if(node.childNodes){
			for(var i=0; i<node.childNodes.length; i++){
				var childNode=node.childNodes[i];				
				if(childNode.leaf == true){					
					var child= new Ext.tree.TreeNode({'text':childNode.text,'leaf':childNode.leaf,'expanded':true,'cls':childNode.cls,'checked':node.checked});
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
					Ext.MessageBox.confirm('Confirm', 'Are you sure you want to <b>Add</b> remote tree selected item as child of target tree selected Item ?', addOne); 
			}else{
		        Ext.MessageBox.show({
		           title: 'Warning',
		           msg: 'You must select one item of <b>remote</b> tree and <b>local</b> tree!',
		           buttons: Ext.MessageBox.OK,			           
		           icon: Ext.MessageBox.WARNING
		       });							
			}
        },
        tooltip:'<b>Add</b><br/>Add remote tree selected item as child of local tree selected item'
        
    });
    var replaceAction = new Ext.Action({
        text: '<b>Replace</b>',
        handler: function(){
           if(targetSelectNode && sourceSelectNode){
          	var tParentNode=targetSelectNode.parentNode;
          	if(tParentNode){        	
           		Ext.MessageBox.confirm('Confirm', 'Are you sure you want to <b>Replace</b> local selected Item with remote selected Item ?', replaceOne); 
           	}
          }else{
	        Ext.MessageBox.show({
	           title: 'Warning',
	           msg: 'You must select one item of remote tree and local tree!',
	           buttons: Ext.MessageBox.OK,			           
	           icon: Ext.MessageBox.WARNING
	       });          	
          }
        },
        tooltip:'<b>Replace</b><br/>Replace remote tree selected item with local tree selected item'
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
    
    function saveSyncPlan(btn){
    	if(btn != 'yes'){
    		return;
    	}
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
    			store.reload();
    		}
    	},syncItem);
        }, 1000);    	
    };
    
    
    function deleteOne(btn){
    	if(btn == 'yes'){
				if(targetSelectNode)targetSelectNode.parentNode.removeChild(targetSelectNode); 
		  }     	
    };
    function cloneTreeNode(node){   	
    	var newNode= new Ext.tree.TreeNode({'text':node.text,'leaf':node.leaf,'expanded':true,'cls':null});
    	newNode.childNodes=[];
    	newNode.parentNode=node.parentNode;
		for(var i=0; i<node.childNodes.length; i++){
			newNode.appendChild(cloneTreeNode(node.childNodes[i]));
		}
		return newNode;    	
    };
    
    function replaceOne(btn){
    	if(btn == 'yes'){
           if(targetSelectNode && sourceSelectNode){
          	var tParentNode=targetSelectNode.parentNode;
          	if(tParentNode){          		
          		var child= cloneTreeNode(sourceSelectNode);//new Ext.tree.TreeNode({'text':sourceSelectNode.text,'leaf':sourceSelectNode.leaf,'expanded':true,'cls':null});
          		tParentNode.replaceChild(child,targetSelectNode);  
          		child.expand();
          		child.select();

          		var sourceChild=cloneTreeNode(sourceSelectNode);// new Ext.tree.TreeNode({'text':sourceSelectNode.text,'leaf':sourceSelectNode.leaf,'expanded':true,'cls':null});
          		sourceSelectNode.parentNode.replaceChild(sourceChild,sourceSelectNode);   
          		sourceChild.expand();
          		sourceChild.select();
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
    		Ext.MessageBox.confirm('Confirm', 'Are you sure you want to <b>Resolve</b> the conflict data now ?', saveSyncPlan);            
        }
    }); 
    //before create root add conflict attribute
    showConflictNode(syncItem.remoteNodes[0],syncItem.node);
    
    var targetRoot=new Ext.tree.TreeNode({text:'','expanded':true});    
    targetRoot.appendChild(createTreeNode(syncItem.node));        
    // local tree
    var targetTree = new Ext.tree.TreePanel({              
        columnWidth:.43,
        bodyStyle:'padding:5px 5px 1',
        title:'Local data',
        border:true,
        height:400,
        animate:true, 
        autoScroll:true,
        rootVisible: false,
        root: targetRoot,
        enableDD:true,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        buttons:[new Ext.Button(leftAction),new Ext.Button(rightAction),new Ext.Button(upAction), new Ext.Button(downAction), new Ext.Button(deleteAction)],
        listeners: {
            'render': function(tp){
                  tp.getSelectionModel().on('selectionchange', function(tree, node){
                      targetSelectNode=node;                     
                  });          
                  //refreshNode(targetTree, targetRoot);
            }
        }        
    });
    
    var targetSelectNode;
    var sourceSelectNode;
    var sourceRoot=new Ext.tree.TreeNode({text:'','expanded':true});
    sourceRoot.appendChild(createTreeNode(syncItem.remoteNodes[0]));
    // remote tree
    var sourceTree = new Ext.tree.TreePanel({                       
        title:'Remote data',
        bodyStyle:'padding:5px 5px 1',
        border:true,
        height:370,
        animate:true,
        autoScroll:true,
        rootVisible: false,
	    root: sourceRoot,
        containerScroll: true,
        enableDD:true,
        dropConfig: {appendOnly:true},
        listeners: {
            'render': function(tp){
                  tp.getSelectionModel().on('selectionchange', function(tree, node){
                      sourceSelectNode=node;
                  });          
                  
            }
        }                
    });
    sourceTree.getRootNode().expand(true, null, function(){
    	//refreshNode(sourceTree, sourceRoot);
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
    	if(tabPanel.getItem('synchronizationplan'+syncItem.itemPK) == undefined){
	   		Ext.QuickTips.init();
			
			buttonPanel = new Ext.Panel({
				bodyStyle:'padding:5px 5px 0',
		        layout:'form',
		        columnWidth:0.14,
		        buttonAlign:'center',
		        border:false,
		        height:100,
		        items:[
		               new Ext.Button(addAction), new Ext.Button(replaceAction)]				        					        
			}); 
	
			sourcePanel = new Ext.Panel({
				columnWidth:.43,			            
		        border:false,
			    items:[sourceTree,combo]				        					        
			}); 
		   
			syncPanel = new Ext.Panel({
			bodyStyle:'padding:5px 5px 1',
	        layout:'column',
	        id:'synchronizationplan'+syncItem.itemPK,
	        deferredRender: false,
	        closable: true,
	        border:false,
		        title: 'Synchronization conflict data',		        
		        items:[	targetTree, buttonPanel, sourcePanel],
		        tbar: [
		            saveAction
		        ]					        					        
		  }); 	  
	    	 
		  tabPanel.add(syncPanel);
		  syncPanel.show();
		  //syncPanel.doLayout();
		  amalto.core.doLayout();  
    	}	
    };
    return {
    	//public 
        init : function(){   		
    		showSync();	  		
        },
    	saveSync:function(){
        	saveSyncPlan();
        }
    };
};
