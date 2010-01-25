
/********************************************************************
 * name space : {companyName}.{context}.{application}Local
 ********************************************************************/
amalto.hierarchical.HierarchicalViewLocal=function(){
	    
    
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
	    		  'Hierarchical_View_Title':'Hierarchical View Display',
	    		  'Search_Panel_Title':'Search Panel',
	    		  'Search_Field_Entity':'Entity',
	    		  'Search_Field_Pivot':'Pivot',
	    		  'Search_Field_Title':'Title Field',
	    		  'Search_Field_Filters':'Filters',
	    		  'Search_Field_Filters_Column_Field':'Field',
	    		  'Search_Field_Filters_Column_Operator':'Operator',
	    		  'Search_Field_Filters_Column_Value':'Value',
	    		  'Search_Field_Filters_Column_Delete':'Delete',
	    		  'Filter_Operation_CONTAINS':'contains the word(s)',
	    		  'Filter_Operation_EQUALS':'is equal to',
	    		  'Filter_Operation_NOT_EQUALS':'is not equal to',
	    		  'Filter_Operation_GREATER_THAN':'is greater than',
	    		  'Filter_Operation_GREATER_THAN_OR_EQUAL':'is greater or equals',
	    		  'Filter_Operation_LOWER_THAN':'is lower than',
	    		  'Filter_Operation_LOWER_THAN_OR_EQUAL':'is lower or equals',
	    		  'Filter_Operation_STARTSWITH':'contains a word starting with',
	    		  'Filter_Operation_STRICTCONTAINS':'contains the sentence',
	    		  'Button_Search':'Search',
	    		  'Button_Save_Report':'Save Report',
	    		  'Button_Load_Report':'Load Report',
	    		  'Button_Add_Filter':'Add Filter',
	    		  'Button_Save_Changes':'Save Changes',
	    		  'Button_Cancel_Changes':'Cancel Changes',
	    		  'Button_Sort_Order':'Sort Order',
	    		  'Sort_Choose_Field':'Choose Field',
	    		  'Sort_Choose_Order':'Choose Order',
	    		  'Sort_Ascending':'Ascending',
	    		  'Sort_Descending':'Descending',
	    		  'Records_MAX_SIZE':'Number of records (-1 = no limit):',
	    		  'Tree_Root_Default_Name':'Root',
	    		  'Messagebox_Info':'Info',
	    		  'Messagebox_Error':'Sorry',
	    		  'Messagebox_Status':'Status',
	    		  'Messagebox_Exception':'Exception',
	    		  'Messagebox_Prompt_Begin':'Please input ',
	    		  'Messagebox_Prompt_End':'first! ',
	    		  'Message_Record_Changes_False':'This change has not affected the actual data item! ',
	    		  'Message_Missing_Entity':'Please select a \'Entity\' First! ',
	    		  'Message_Missing_Title':'Please select a \'Title Field\' First! ',
	    		  'Messagebox_Report_Empty':'Please create a new report or load a alreay exist report first! ',
	    		  'Messagebox_Report_Name_Empty':'Report Name can not be empty! ',
	    		  'Messagebox_Report_Save_Success':'The hierarchical-report has been saved successfully! ',
	    		  'Messagebox_Report_Save_Fail':'Saved a hierarchical-report failed! ',
	    		  'Message_No_Result_Set':'Please get a \'Result Set\' First! ',
	    		  'Messagebox_Progress_Saving_Title':'Saving...',
	    		  'Messagebox_Progress_Saving_Content':'Saving your data, please wait...',
	    		  'Load_Report_Title':'Load Report',
	    		  'Reports_Title':'Reports',
	    		  'Load_Report_Button':'Load'
                 };
                 
            locale_fr= {     
            	  'Hierarchical_View_Title':'Hierarchical View Display',
  	    		  'Search_Panel_Title':'Search Panel',
  	    		  'Search_Field_Entity':'Entity',
  	    		  'Search_Field_Pivot':'Pivot',
  	    		  'Search_Field_Title':'Title Field',
  	    		  'Search_Field_Filters':'Filters',
  	    		  'Search_Field_Filters_Column_Field':'Field',
  	    		  'Search_Field_Filters_Column_Operator':'Operator',
  	    		  'Search_Field_Filters_Column_Value':'Value',
  	    		  'Search_Field_Filters_Column_Delete':'Delete',
  	    		  'Filter_Operation_CONTAINS':'contains the word(s)',
  	    		  'Filter_Operation_EQUALS':'is equal to',
  	    		  'Filter_Operation_NOT_EQUALS':'is not equal to',
  	    		  'Filter_Operation_GREATER_THAN':'is greater than',
  	    		  'Filter_Operation_GREATER_THAN_OR_EQUAL':'is greater or equals',
  	    		  'Filter_Operation_LOWER_THAN':'is lower than',
  	    		  'Filter_Operation_LOWER_THAN_OR_EQUAL':'is lower or equals',
  	    		  'Filter_Operation_STARTSWITH':'contains a word starting with',
  	    		  'Filter_Operation_STRICTCONTAINS':'contains the sentence',
  	    		  'Button_Search':'Search',
  	    		  'Button_Save_Report':'Save Report',
  	    		  'Button_Load_Report':'Load Report',
  	    		  'Button_Add_Filter':'Add Filter',
  	    		  'Button_Save_Changes':'Save Changes',
  	    		  'Button_Cancel_Changes':'Cancel Changes',
  	    		  'Button_Sort_Order':'Sort Order',
  	    		  'Sort_Choose_Field':'Choose Field',
  	    		  'Sort_Choose_Order':'Choose Order',
  	    		  'Sort_Ascending':'Ascending',
  	    		  'Sort_Descending':'Descending',
  	    		  'Records_MAX_SIZE':'Number of records (-1 = no limit):',
  	    		  'Tree_Root_Default_Name':'Root',
  	    		  'Messagebox_Info':'Info',
  	    		  'Messagebox_Error':'Sorry',
  	    		  'Messagebox_Status':'Status',
  	    		  'Messagebox_Exception':'Exception',
  	    		  'Messagebox_Prompt_Begin':'Please input ',
  	    		  'Messagebox_Prompt_End':'first! ',
  	    		  'Message_Record_Changes_False':'This change has not affected the actual data item! ',
  	    		  'Message_Missing_Entity':'Please select a \'Entity\' First! ',
  	    		  'Message_Missing_Title':'Please select a \'Title Field\' First! ',
  	    		  'Messagebox_Report_Empty':'Please create a new report or load a alreay exist report first! ',
  	    		  'Messagebox_Report_Name_Empty':'Report Name can not be empty! ',
  	    		  'Messagebox_Report_Save_Success':'The hierarchical-report has been saved successfully! ',
  	    		  'Messagebox_Report_Save_Fail':'Saved a hierarchical-report failed! ',
  	    		  'Message_No_Result_Set':'Please get a \'Result Set\' First! ',
  	    		  'Messagebox_Progress_Saving_Title':'Saving...',
  	    		  'Messagebox_Progress_Saving_Content':'Saving your data, please wait...',
  	    		  'Load_Report_Title':'Load Report',
  	    		  'Reports_Title':'Reports',
  	    		  'Load_Report_Button':'Load'
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
