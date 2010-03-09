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
                enableDD: false,
                listeners: {
                            'click': function(node, e){
                                                            this.onTreeLeafNodeClick(node, e);
                                                          }.createDelegate(this)
                            }
                
           }     
        ); 
		
		Ext.apply(this, {
            id : "derivedHierarchyDisplay",
            title : "Browse Derived Hierarchy",
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
                        '<div id="hierarchyItemsCriterias"/>',
                        border: true,
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
		
		for (var i = this.lastPivotPanelNum,j=0; i >0; i--,j++) {
			this.pivotArray[j]=$('itemsSearchPivotName' + i).value;
			this.displayArray[j]=DWRUtil.getValue('itemsSearchDisplayField'+i);
			this.fkPathArray[j]=this.parseSearchFKPath(i);
		}
       
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
		
		if(this.pivotArray.length>0){
			
			this.hierarchicalTree.getRootNode().setText(this.pivotArray[this.pivotArray.length-1]);
            
            this.treeLoader.baseParams.pk=node.attributes.pk;
            this.treeLoader.baseParams.level=node.attributes.level;
            
            var nextPivot=this.pivotArray[node.attributes.level];
            this.treeLoader.baseParams.nextPivot=nextPivot;
            
            var nextDisplay=this.displayArray[node.attributes.level];
            this.treeLoader.baseParams.nextDisplay=nextDisplay;
            
            var nextFkPath=this.fkPathArray[node.attributes.level];
            this.treeLoader.baseParams.nextFkPath=nextFkPath;
            
            var endingFlag='0';
            if(node.attributes.level+1==this.pivotArray.length)endingFlag='1';
            this.treeLoader.baseParams.endingFlag=endingFlag;
		}  

    },
    
    onTreeLeafNodeClick : function(node,e) {

                var dataObjectName=this.pivotArray[node.attributes.level-1];

                var idArray = new Array(1); 
                idArray[0]=node.attributes.pk;
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
       
       //set pivot
       DWRUtil.addOptions('itemsSearchPivotName1',[{ text:'Select a pivot', value:'-1' }],"value","text");
       DerivedHierarchyInterface.getPivotList(function (result){
                DWRUtil.addOptions('itemsSearchPivotName1',result.data,"value","text");
            },language);
            
    },
    
    initStatus : function(){
        
    	this.pivotArray={};
    	this.displayArray={};
    	this.fkPathArray={};
            
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
          this.addCriteria('hierarchyItemsCriteria'+this.lastPivotPanelNum,this.lastPivotPanelNum);          
        }else{
             Ext.MessageBox.alert('Sorry', 'There is no derived pivot exist! ');
             return;
        }
    	
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
    
    
	initData : function() {
		//this.hierarchicalTree.getRootNode().expand();
		this.initStatus();
		this.initCriteria();
	}
	
	
});
