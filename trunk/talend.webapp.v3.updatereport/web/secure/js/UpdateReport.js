/*
 * @include  "/com.amalto.webapp.core/web/secure/ext.ux/DWRProxy.js"
 * @include  "/com.amalto.webapp.core/web/secure/js/core.js"
 * @include  "/talend.webapp.v3.updatereport/web/secure/js/UpdateReportPanel.js"
 */
 
amalto.namespace("amalto.updatereport");

amalto.updatereport.UpdateReport = function () {
	loadResource("/updatereport/secure/js/UpdateReportLocal.js", "amalto.updatereport.UpdateReportLocal" );
	
    loadResource("/updatereport/secure/js/UpdateReportPanel.js", "");
    
    loadResource("/updatereport/secure/js/DataLogViewer.js", "");
    
    
    var updateReportPanel;
	
	function browseUpdateReport(){
		//init UI
		var tabPanel = amalto.core.getTabPanel();
		updateReportPanel = tabPanel.getItem('UpdateReportPanel');
		if(updateReportPanel == undefined){
			
			updateReportPanel=new amalto.updatereport.UpdateReportPanel();
			
			tabPanel.add(updateReportPanel);
			
		}
        
        updateReportPanel.show();
		updateReportPanel.doLayout();
		amalto.core.doLayout();
		// init data
		updateReportPanel.initListData();
		
	}


 	return {
 		
		init: function() {
 		amalto.updatereport.UpdateReportLocal.init();
 		browseUpdateReport();
 		}
		
 	}
}();
