talend.crossreference = {};
talend.crossreference.Crossreference = function(){
	
	function _getUrl(language, callBack){
		var frameUrl = "/synchronizationAction2/synchronizationAction2.html";
		callBack(frameUrl);
	}
	
	return {
		getUrl : function(language, callBack){_getUrl(language, callBack);}
	}
}();