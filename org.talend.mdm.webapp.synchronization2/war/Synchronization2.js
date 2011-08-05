talend.synchronization2 = {};
talend.synchronization2.Synchronization2 = function(){
	
	function _getUrl(language, callBack){
		var frameUrl = "/synchronization2/Synchronization2.html";
		callBack(frameUrl);
	}
	
	return {
		getUrl : function(language, callBack){_getUrl(language, callBack);}
	}
}();