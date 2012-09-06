// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils;

import java.util.regex.Pattern;


public class ValidateUtil {
    public static boolean matchCommonRegex(String newText) {
        String regex = "\\w*[#|-|\\.|\\w*]+\\w+";//$NON-NLS-1$        
        
        return matches(regex, newText);
    }
    
    public static boolean matchCustomFormRegex(String newText) {
        String regex = "\\w*[#|\\.|\\w*]+\\w+";//$NON-NLS-1$
        
        return matches(regex, newText);
    }
    
    public static boolean matchViewProcessRegex(String newText) {
        String regex = "\\w*[#|\\.|\\w*]+(#|\\w+)";//$NON-NLS-1$
        
        return matches(regex, newText);
    }
    
    private static boolean matches(String regex, String newText) {
        Pattern p1 = Pattern.compile(regex);
        
        return p1.matcher(newText).matches();
    }
}
