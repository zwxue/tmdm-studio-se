/*
 * @include  "/com.amalto.webapp.core/web/secure/ext.ux/DWRProxy.js"
 * @include  "/com.amalto.webapp.core/web/secure/js/core.js"
 * @include  "/org.talend.mdm.webapp.hierarchical/web/secure/js/DerivedHierarchyDisplay.js"
 */
 
amalto.namespace("amalto.hierarchical");

amalto.hierarchical.DerivedHierarchy = function () {
	
    loadResource("/hierarchical/secure/js/DerivedHierarchyDisplay.js", "");
    
    loadResource("/hierarchical/secure/js/MultiSelectTreePanel.js", "");
    
    loadResource("/talendmdm/secure/js/widget/FieldsWhereConditionPanel.js", "");
    
    var derivedHierarchyDisplayPanel;
    
    function initUIAndData(){
		var tabPanel = amalto.core.getTabPanel();
		derivedHierarchyDisplay = tabPanel.getItem('derivedHierarchyDisplay');
		
		if(derivedHierarchyDisplay == undefined){
			derivedHierarchyDisplayPanel=new amalto.hierarchical.DerivedHierarchyDisplay();			
			tabPanel.add(derivedHierarchyDisplayPanel);
		}
        
        derivedHierarchyDisplayPanel.show();
		derivedHierarchyDisplayPanel.doLayout();
		amalto.core.doLayout();
		
		derivedHierarchyDisplayPanel.initData();
		
    };
    
    function makeDirty(){
        var itempanel = amalto.core.getTabPanel().activeTab;
        if(itempanel){
            itempanel.isdirty=true;
        }
    };
    
    function cleanDirty(){
        var itempanel = amalto.core.getTabPanel().activeTab;
        if(itempanel){
            itempanel.isdirty=false;
        }
    };
	
 	return {
 		
		init: function() {initUIAndData();},
		makeDirty: function() {makeDirty();},
        cleanDirty: function() {cleanDirty();},
		onPivotNameChange: function(id) {derivedHierarchyDisplayPanel.doOnPivotNameChange(id);},
		fillFKStore: function(id) {derivedHierarchyDisplayPanel.doFillFKStore(id);},
		onAddPivot:function() {derivedHierarchyDisplayPanel.doOnAddPivot();},
		onRemovePivot:function() {derivedHierarchyDisplayPanel.doOnRemovePivot();}
 	}
}();
