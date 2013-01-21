// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.views;

import org.eclipse.ui.views.markers.MarkerSupportView;

/**
 * created by HHB on 2013-1-5 Detailled comment
 * 
 */
public class MDMProblemView extends MarkerSupportView {

    private static final String GENERATOR_ID = "org.talend.mdm.problemsGenerator";

    /**
     * DOC HHB MDMProblemView constructor comment.
     * 
     * @param contentGeneratorId
     */
    public MDMProblemView() {
        super(GENERATOR_ID);
    }

}
