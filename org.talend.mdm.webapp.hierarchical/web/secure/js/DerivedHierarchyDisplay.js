/*
 * @include  "/org.talend.mdm.webapp.openmdm/web/secure/js/widget/FieldsWhereConditionPanel.js"
 * @include  "/com.amalto.webapp.core/web/secure/js/core.js"
 */

Ext.namespace('amalto.hierarchical');
amalto.hierarchical.DerivedHierarchyDisplay = function(config) {
	Ext.applyIf(this, config);
	this.initUIComponents();
	amalto.hierarchical.DerivedHierarchyDisplay.superclass.constructor
			.call(this);
};
Ext.extend(amalto.hierarchical.DerivedHierarchyDisplay, Ext.Panel, {

	lastPivotPanelNum:1,
	
	pivotArray:{},
	displayArray:{},
	fkPathArray:{},
	
	isViceVersa:true,
	vvPivotArray:{},
    vvDisplayArray:{},
    vvFkPathArray:{},
	
	initUIComponents : function() {
		
		this.treeLoader = new Ext.tree.TreeLoader({
                  dataUrl : "/hierarchical/secure/DerivedHierarchyTreeLoadServlet"
             });
             
        this.treeLoader.on('beforeload', 
                    function(treeLoader, node) {
                        this.onBeforeloadTree(treeLoader, node);
                    }.createDelegate(this)
        );
             
		this.hierarchicalTree = new Ext.ux.MultiSelectTreePanel(
           {
                xtype : "treepanel",
                region: 'center',
                layout:'fit',
                containerScroll : "true",
                autoScroll : true,
                animate : "true",
                loader : this.treeLoader,
                root : new Ext.tree.AsyncTreeNode({
                    expandable : true,
                    text : "Root",
                    draggable : false,
                    allowDrop : false,
                    //id : "0_-1",
                    pk : "-1",
                    level:0
                }),
                useArrows: true,
                rootVisible : true,
                enableDD: true,
                bbar : new Ext.Toolbar([{
                    handler : function(button, event) {
                        this.onSaveChangesClick(button, event);
                    }.createDelegate(this),
                    text : 'Apply Changes'
                },{
                    xtype : "tbspacer"
                },{
                    handler : function(button, event) {
                        this.onCancelChangesClick(button, event);
                    }.createDelegate(this),
                    text : 'Cancel Changes'
                }]),
                listeners: {
                            'dblclick': function(node, e){
                                                            this.onTreeLeafNodeClick(node, e);
                                                          }.createDelegate(this),
                            'nodedrop': function(dropEvent){
                            	               this.onTreeLeafNodeDrop(dropEvent);
                                            }.createDelegate(this)           
                           }
                
           }     
        ); 
		
		Ext.apply(this, {
            id : "derivedHierarchyDisplay",
            title : "Derived Hierarchy",
            layout : "border",
            closable: true,
            items : [new Ext.Panel({
                        title: "Search Panel",
                        region: 'north',
                        layout:'fit',
                        border:false,
                        bodyBorder:false,
                        autoScroll: true,   
                        collapsible: true,
                        header:true,
                        closable:true,
                        bodyStyle:'padding:5px',
                        height:200,     
                        split:true,
                        html: '' +
                        '<div id="hierarchyItemsCriterias"></div><br/><div id="derivedHierarchyWherePanel"></div><br/><div id="moreDHCriteriaPanel"></div>',
                        bodyborder: true,
                        buttonAlign : "left",
                        buttons : [{
                                handler : function(button, event) {
                                    this.onSearchClick();
                                }.createDelegate(this),
                                text : "Run Search"
                            }]
                    }),this.hierarchicalTree]
        });
               

	},
	
	onTreeLeafNodeDrop : function(dropEvent){
		var nodes=dropEvent.dropNode;
        var keysArray=new Array(nodes.length);
        var xpathArray=new Array(nodes.length);
        var newText='';
                                                 
        for (var index = 0; index < nodes.length; index++) {
              var keys=nodes[index].attributes.pk;
              var xpath='';
              if(this.fkPathArray.length>0)xpath=this.fkPathArray[this.fkPathArray.length-1];
              if(!dropEvent.target.leaf){
                       newText=dropEvent.target.attributes.pk;
              }else{
                  //leaf case
                  newText=dropEvent.target.parentNode.attributes.pk;
              }
                                                         
              keysArray[index]=keys;
              xpathArray[index]=xpath;
         }
         
         DWREngine.setAsync(false); 
         DerivedHierarchyInterface.recordChanges(keysArray,xpathArray,newText,function(status){
                                                    if(status==true){
                                                      //make dirty
                                                      amalto.hierarchical.DerivedHierarchy.makeDirty();    
                                                    }else{
                                                      Ext.MessageBox.alert('Error', 'This change has not affected the actual data item! ');
                                                    }
                                                });
         DWREngine.setAsync(true);
         
	},
	
	onSearchClick : function(){
		
		//check
		var pass=true;
		for (var i = 0; i < this.lastPivotPanelNum; i++) {
			var targetPivot=$('itemsSearchPivotName' + (i+1)).value;
			if(targetPivot=="-1"){
				pass=false;
				break;
			}
		}
		if(!pass){
			Ext.MessageBox.alert('Warnning', 'Please define a pivot! ');
			return;
		}
		//put criterias
		
		this.pivotArray=new Array(this.lastPivotPanelNum);
		this.displayArray=new Array(this.lastPivotPanelNum);
		this.fkPathArray=new Array(this.lastPivotPanelNum);
		
		this.vvPivotArray=new Array(this.lastPivotPanelNum);
        this.vvDisplayArray=new Array(this.lastPivotPanelNum);
        this.vvFkPathArray=new Array(this.lastPivotPanelNum);
		
		for (var i = this.lastPivotPanelNum,j=0; i >0; i--,j++) {
			this.pivotArray[j]=$('itemsSearchPivotName' + i).value;
			this.displayArray[j]=DWRUtil.getValue('itemsSearchDisplayField'+i);
			this.fkPathArray[j]=this.parseSearchFKPath(i);
			
			this.vvPivotArray[i-1]=$('itemsSearchPivotName' + i).value;
            this.vvDisplayArray[i-1]=DWRUtil.getValue('itemsSearchDisplayField'+i);
            this.vvFkPathArray[i-1]=this.parseSearchFKPath(i);
		}
		
		//put criterias 2 session
		var foa=this.wcEditorGridPanel.getWhereConditions();
		DWREngine.setAsync(false); 
        DerivedHierarchyInterface.updateExCriterionForDerivedHerarchy(foa,function(status){});
        DWREngine.setAsync(true);
		
		//reload tree
        this.hierarchicalTree.getRootNode().reload();
        //this.hierarchicalTree.expandAll();
		this.hierarchicalTree.getRootNode().expand();
	},
	
	parseSearchFKPath : function(id){
		
		var resultPath='';
		
		var myoptions=$("itemsSearchFKPath"+id).options;
		
		if(Ext.get('itemsSearchPivotName' + (id+1))!=null){
			var usingConcept=$('itemsSearchPivotName' + (id+1)).value;
			for (var index = 0; index < myoptions.length; index++) {
               if(myoptions[index].value==usingConcept){
                  resultPath=myoptions[index].text;
                  break;
               }
            }
		}
		
		return resultPath;
	},
	
	onBeforeloadTree : function(treeLoader,node){
		
		var usePivotArray;
        var useDisplayArray;
        var useFkPathArray;
        
        if(!this.isViceVersa){

        	usePivotArray=this.pivotArray;
            useDisplayArray=this.displayArray;
            useFkPathArray=this.fkPathArray;
            
        }else{
            
        	usePivotArray=this.vvPivotArray;
            useDisplayArray=this.vvDisplayArray;
            useFkPathArray=this.vvFkPathArray;
            
        }
		
		
		if(usePivotArray.length>0){
			
			if(!this.isViceVersa){
			this.hierarchicalTree.getRootNode().setText(usePivotArray[usePivotArray.length-1]);
			}else{
			this.hierarchicalTree.getRootNode().setText(usePivotArray[0]);	
			}
            
            this.treeLoader.baseParams.pk=node.attributes.pk;
            this.treeLoader.baseParams.level=node.attributes.level;
            
            var nextPivot=usePivotArray[node.attributes.level];
            this.treeLoader.baseParams.nextPivot=nextPivot;
            if(node.attributes.level>0){
                var prePivot=usePivotArray[node.attributes.level-1];
                this.treeLoader.baseParams.prePivot=prePivot;
            }
            
            var nextDisplay=useDisplayArray[node.attributes.level];
            this.treeLoader.baseParams.nextDisplay=nextDisplay;
            
            var nextFkPath=useFkPathArray[node.attributes.level];
            this.treeLoader.baseParams.nextFkPath=nextFkPath;
            if(node.attributes.level>0){
                var preFkPath=useFkPathArray[node.attributes.level-1];
                this.treeLoader.baseParams.preFkPath=preFkPath;
            }
            
            var beforeEndingFlag='0';
            if(node.attributes.level+2==usePivotArray.length)beforeEndingFlag='1';
            this.treeLoader.baseParams.beforeEndingFlag=beforeEndingFlag;
            
            var endingFlag='0';
            if(node.attributes.level+1==usePivotArray.length)endingFlag='1';
            this.treeLoader.baseParams.endingFlag=endingFlag;
            
            //recursion check
            if(usePivotArray.length>1){
                 if(usePivotArray[usePivotArray.length-1]==usePivotArray[usePivotArray.length-2]){
                    this.treeLoader.baseParams.recursion='1';
                 }else{
                 	this.treeLoader.baseParams.recursion='0';
                 }
            }
            
            //viceversa
            this.treeLoader.baseParams.viceVersa=this.isViceVersa;
		}  

    },
    
    onTreeLeafNodeClick : function(node,e) {

                var dataObjectName='';
                if(!this.isViceVersa)dataObjectName=this.pivotArray[node.attributes.level-1];
                else dataObjectName=this.vvPivotArray[node.attributes.level-1];

                var idArray = new Array(1); 
                idArray[0]=node.attributes.pk;
                
                //strip[]
                if(idArray[0].startWith("[")&&idArray[0].endWith("]")){
                	idArray[0]=idArray[0].replaceAll("\\[",".");
                	idArray[0]=idArray[0].replaceAll("\\]","");
                	idArray[0]=idArray[0].substring(1);
                }
                
                amalto.itemsbrowser.ItemsBrowser.editItemDetails(idArray,dataObjectName,function(){
                    this.doRefreshAfterEdit();
                }.createDelegate(this));
    },
	
    initCriteria : function(){
    	
    	
       
    	//display
    	DWRUtil.setValue('hierarchyItemsCriterias','<span id="hierarchyItemsCriteria1">' +
    	                                     '<span style="padding-left:5px">Pivot: </span>'+
    			                             '<select id="itemsSearchPivotName1" onChange="amalto.hierarchical.DerivedHierarchy.onPivotNameChange(\'1\');amalto.hierarchical.DerivedHierarchy.fillFKStore(\'1\');"></select>' +
    			                             '<span style="padding-left:5px">Display: </span>'+
                                             '<select id="itemsSearchDisplayField1"></select>' +
                                             '<select id="itemsSearchFKPath1" style="display:none"></select>' +
                                             '<span style="padding-left:5px" onClick="amalto.hierarchical.DerivedHierarchy.onAddPivot();"><img src="img/genericUI/add-element.gif" style="cursor:pointer"/></span> ' +
                                             '<span style="padding-left:5px" onClick="amalto.hierarchical.DerivedHierarchy.onRemovePivot();"><img src="img/genericUI/remove-element.gif" style="cursor:pointer"/></span> ' +
                                          '<br/></span>'
                        );
       //more panel
       if(this.vvCheckBox==undefined||this.vvCheckBox==null){
       	   this.vvCheckBox=
              new Ext.form.Checkbox  ({
                    xtype : "checkbox",
                    boxLabel : "Vice versa",
                    listeners : {
                        check : {
                            fn : function(checkbox, checked) {
                                this.onVVBoxChecked(checkbox, checked);
                            }.createDelegate(this)
                        }
                    },
                    renderTo:"moreDHCriteriaPanel"
                    
            }); 
       }else{
       	  this.vvCheckBox.setValue(false);
       }
            
       //set pivot
       DWRUtil.addOptions('itemsSearchPivotName1',[{ text:'Select a pivot', value:'-1' }],"value","text");
       DerivedHierarchyInterface.getPivotList(function (result){
                DWRUtil.addOptions('itemsSearchPivotName1',result.data,"value","text");
            },language);
        
       //where panel
       if(this.wcEditorGridPanel==undefined||this.wcEditorGridPanel==null){
       	   
           this.wcEditorGridPanel = new amalto.widget.FieldsWhereConditionPanel(
                {
                 i18n:language,
                 validateBeforeAddFilter: function() {
                    var firstPivot=DWRUtil.getValue('itemsSearchPivotName1');
                    
                    if(firstPivot=='-1'){
                            Ext.MessageBox.alert('Warnning', 'First Pivot can not be empty! ');
                            return false;
                    }
                    
                    return true;
                 },
                 getInitField: function() {
                    var firstDisplay=DWRUtil.getValue('itemsSearchDisplayField1');
                    return firstDisplay;
                 },
                 getConceptForLoadingFieldStore: function(){
                    var pivots='';
                    var currentCounter=$('hierarchyItemsCriterias').children.length;
                    for (var i = 0; i < currentCounter; i++) {
                        var thisPivot=DWRUtil.getValue('itemsSearchPivotName'+(i+1));
                        if(thisPivot!='-1'){
                        	pivots+=thisPivot;
                            if(i<currentCounter-1)pivots+=',';
                        }
                        
                    }
                              
                    return pivots; 
                }
                 
                });
                
           var wcContainer= new Ext.Panel({
                items : [this.wcEditorGridPanel],
                border:false,
                renderTo:"derivedHierarchyWherePanel"
           });
       }else{
       	  this.wcEditorGridPanel.refreshWherePanelStore();
       }
    },
    
    onVVBoxChecked : function(checkbox, checked){
    	this.isViceVersa=checked;
    },
    
    initStatus : function(){
        
    	this.pivotArray={};
    	this.displayArray={};
    	this.fkPathArray={};
    	
    	this.vvPivotArray={};
        this.vvDisplayArray={};
        this.vvFkPathArray={};
        
        this.isViceVersa=false;
            
    },
    
    doOnPivotNameChange: function(id){

    	var selectedPivot=$('itemsSearchPivotName' + id).value;

        //fill ref data
    	DWRUtil.removeAllOptions('itemsSearchDisplayField'+id);
    	//DWRUtil.addOptions('itemsSearchDisplayField'+id,[{ text:'Select a field', value:'-1' }],"value","text");
    	DerivedHierarchyInterface.getTitleList(function (result){
                DWRUtil.addOptions('itemsSearchDisplayField'+id,result.data,"value","text");
         },selectedPivot,language);
    },
    
    doFillFKStore: function(id){
    	var selectedPivot=$('itemsSearchPivotName' + id).value;
        if(selectedPivot!='-1'){
            DerivedHierarchyInterface.getFKMap(
                function(result){
                         this.getFKMapCB(result,id);
                   }.createDelegate(this),
                selectedPivot,language);
        }else{
        	DWRUtil.removeAllOptions('itemsSearchFKPath'+id);
        }
    },
    
    getFKMapCB: function(result,id){    
        DWRUtil.removeAllOptions('itemsSearchFKPath'+id);
        DWRUtil.addOptions('itemsSearchFKPath'+id,result,false);
    },
    
    doOnAddPivot: function(){
    	var selectedPivot=$('itemsSearchPivotName' + this.lastPivotPanelNum).value;
    	
    	if(selectedPivot=='-1'){
    		Ext.MessageBox.alert('Warnning', 'Please select a pivot first! ');
    		return;
    	}
    	
    	var rtnSize=$('itemsSearchFKPath'+ this.lastPivotPanelNum).length;
        if(rtnSize>0){
          //recursivity check
          if(this.isUnderRecursionMode()){
             Ext.MessageBox.alert('Sorry', 'No more pivot can be added, since you are under the recursion mode. ');
             return;
          }
          this.addCriteria('hierarchyItemsCriteria'+this.lastPivotPanelNum,this.lastPivotPanelNum);          
        }else{
             Ext.MessageBox.alert('Sorry', 'There is no eligible pivot from this entity. ');
             return;
        }
    	
    },
    
    isUnderRecursionMode: function(){
    	var supportRecursion=false;
    	if(this.lastPivotPanelNum>1){
    		var lastPivot=$('itemsSearchPivotName' + this.lastPivotPanelNum).value;
            var precedingPivot=$('itemsSearchPivotName' + (this.lastPivotPanelNum-1)).value;
            if(lastPivot==precedingPivot)supportRecursion=true;  
        }
        return supportRecursion;
    },
    
    addCriteria: function(criteriaParent, id){    

        var tpl = new Ext.DomHelper.Template(
                        '<span id="hierarchyItemsCriteria{id}">' +
                                             '<span style="padding-left:5px">Pivot: </span>'+
                                             '<select id="itemsSearchPivotName{id}" onChange="amalto.hierarchical.DerivedHierarchy.onPivotNameChange(\'{id}\');amalto.hierarchical.DerivedHierarchy.fillFKStore(\'{id}\');"></select>' +
                                             '<span style="padding-left:5px">Display: </span>'+
                                             '<select id="itemsSearchDisplayField{id}"></select>' +
                                             '<select id="itemsSearchFKPath{id}" style="display:none"></select>' +
                        '<br/></span>'
                        );
        var actulId = parseInt(id) + 1;
        
        if(Ext.get("hierarchyItemsCriteria"+actulId)!=null)return;
        
        tpl.insertAfter(criteriaParent,{id:actulId});
        this.lastPivotPanelNum=actulId;
        //alert(this.lastPivotPanelNum);
        
        var myoptions=$("itemsSearchFKPath"+id).options;
        var optionValueArray=new Array(myoptions.length);
        for (var index = 0; index < myoptions.length; index++) {
            optionValueArray[index]=myoptions[index].value;
        }
        
        //DWRUtil.addOptions('itemsSearchOperator'+actulId,OPERATORS[language]);
        //DWRUtil.addOptions('itemsSearchField'+actulId,itemsElements);
        
        DWRUtil.addOptions('itemsSearchPivotName'+actulId,[{ text:'Select a pivot', value:'-1' }],"value","text");
        DerivedHierarchyInterface.getPivotFilterList(function (result){
                DWRUtil.addOptions('itemsSearchPivotName'+actulId,result,"value","text");
          },language,optionValueArray);
        
    },
    
    doOnRemovePivot: function(){
    	if(this.lastPivotPanelNum>1){
    		var criteriaId = "hierarchyItemsCriteria"+this.lastPivotPanelNum;
            $('hierarchyItemsCriterias').removeChild($(criteriaId));
            this.lastPivotPanelNum--;
    	}
        //alert(this.lastPivotPanelNum);
    },
    
    onSaveChangesClick: function(button, event){
        Ext.MessageBox.show({
           msg: 'Saving your data, please wait...',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200}
        });
        var dataObject='';
        if(this.pivotArray.length>0)dataObject=this.pivotArray[this.pivotArray.length-1];
        DerivedHierarchyInterface.saveChanges(dataObject,{
            callback:function(data){
                   //clean dirty
                   amalto.hierarchical.DerivedHierarchy.cleanDirty();
                   
                   Ext.MessageBox.hide();
                   Ext.MessageBox.alert('Status', data);
            },
            errorHandler:function(errorString, exception) {  
                  alert('Exception:'+ errorString);
                  Ext.MessageBox.hide();
            }
        });
        
    },
    
    onCancelChangesClick: function(button, event){
        this.onSearchClick();
        //clean dirty
        amalto.hierarchical.DerivedHierarchy.cleanDirty();
    },
    
	initData : function() {
		//this.hierarchicalTree.getRootNode().expand();
		this.initStatus();
		this.initCriteria();
	}
	
	
});
