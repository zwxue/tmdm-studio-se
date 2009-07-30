
/********************************************************************
 * name space : {companyName}.{context}.{application}Local
 ********************************************************************/
amalto.itemsbrowser.ItemNodeLocal=function(){
	    
    
    var locale_en;
    var locale_fr;
    var locales;
    var localeMap;
    
    return {
        init : function(){
        	
		    /********************************************************************
			 * Localization custom begin
			 ********************************************************************/
	    	locale_en= {
	    		  'MINLENGTH_MSG1':' doit comporter au minimum',
	    		  'MINLENGTH_MSG2':'caractères',   
	    		  'MAXLENGTH_MSG1':' n'accepte que ',
	    		  'MAXLENGTH_MSG2':' caractères maximum.',
	    		  'MINEXCLUSIVE_MSG1':'doit etre superieur à  ',
	    		  'MAXEXCLUSIVE_MSG1':'doit etre inférieur à  ',
	    		  'MININCLUSIVE_MSG1':'doit etre superieur ou égal à ',
	    		  'MAXINCLUSIVE_MSG1':'doit etre inférieur ou égal à',
	    		  'PATTEN_MSG1':'"\" de pattern est \""  '
	    		  
                 };
                 
            locale_fr= {     
            	  'MINLENGTH_MSG1':' doit comporter au minimum',
   	    		  'MINLENGTH_MSG2':'caractères',   
   	    		  'MAXLENGTH_MSG1':' n'accepte que ',
   	    		  'MAXLENGTH_MSG2':' caractères maximum.',
   	    		  'MINEXCLUSIVE_MSG1':'doit etre superieur à  ',
   	    		  'MAXEXCLUSIVE_MSG1':'doit etre inférieur à  ',
   	    		  'MININCLUSIVE_MSG1':'doit etre superieur ou égal à ',
   	    		  'MAXINCLUSIVE_MSG1':'doit etre inférieur ou égal à',
   	    		  'PATTEN_MSG1':'"\" de pattern est \""  '
   	    		  
                 };
                 
            /********************************************************************
			 * Localization custom end
			 ********************************************************************/     
                   
            locales={'en':locale_en,'fr':locale_fr};
           
            localeMap=initLocaleMap(language,locales);
            
        },
        
        
        get: function(keys) {
        	var expr="localeMap.get(";
        	for(var index=0; index<arguments.length; index++) {
        		if(index<arguments.length-1){
        			expr+=("'"+arguments[index]+"',");
        		}else{
        			expr+=("'"+arguments[index]+"'");
        		}
        	}
        	expr+=(")");
        	return eval(expr);
        } 
         	
    };
}();
