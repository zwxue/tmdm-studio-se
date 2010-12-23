// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package routines.system;

import java.util.regex.*;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class MDM {

    /**
     * getFKKey: Return one of the FK component by position in a mangled FK
     * (FKs are mangled in MDM to accommodate for compound keys)
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string(FKs) mangledFK: original mangled FK.
     * 
     * {param} int(0) pos: key position (starts at 0)
     * 
     * {example} getFKKey(FKs,0) # 12345
     */
    public static String getFKKey(String mangledFK, int pos) {
        if (mangledFK == null) {
            return null;
        }
        Pattern p = Pattern.compile("(\\[[^\\[\\]]*\\])");
        Matcher m = p.matcher(mangledFK.trim());        
        int i = 0;
        while (m.find()) {
            if(i == pos){
                String targetValue = m.group(0);
                return targetValue.substring(1, targetValue.length()-1);
            }
            i++;
        }
        return null;
    }
}
