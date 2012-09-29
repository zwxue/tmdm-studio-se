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

import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;
import org.talend.mdm.repository.core.impl.view.IViewNodeConstDef;

import com.amalto.workbench.service.bridge.ITransformService;

/**
 * created by liusongbo on 2012-9-28 Detailled comment
 */
public class RepositoryTransformUtil implements ITransformService {

    private static final String separator = "#"; //$NON-NLS-1$

    private static final String leftBracket = "("; //$NON-NLS-1$

    private static final String rightBracket = ")"; //$NON-NLS-1$

    public static RepositoryTransformUtil instance;

    public static RepositoryTransformUtil getInstance() {
        if (instance == null) {
            instance = new RepositoryTransformUtil();
        }

        return instance;
    }

    public String transformToSilyViewName(final String internalName) {
        if (internalName == null || internalName.isEmpty()) {
            return internalName;
        }

        String prefix = IViewNodeConstDef.PREFIX_VIEW_UPPER;
        String transformedName = internalName;
        if (transformedName.startsWith(prefix)) {
            transformedName = transformedName.substring(prefix.length());
            if (transformedName.indexOf(separator) != -1) {
                transformedName = transformedName.replace(separator, leftBracket) + rightBracket;
            }
        }

        return transformedName;
    }

    public String transformToSilyProcessName(final String internalName) {
        if (internalName == null || internalName.isEmpty()) {
            return internalName;
        }

        String prefix = null;

        String sepA = separator;
        String sepB = leftBracket;
        String sepC = rightBracket;

        String transformedName = internalName;
        if (transformedName.startsWith(ITransformerV2NodeConsDef.PREFIX_BEFORESAVE_UPPER)) {
            prefix = ITransformerV2NodeConsDef.PREFIX_BEFORESAVE;
            transformedName = transformedName.substring(prefix.length());
        } else if (transformedName.startsWith(ITransformerV2NodeConsDef.PREFIX_BEFOREDEL_UPPER)) {
            prefix = ITransformerV2NodeConsDef.PREFIX_BEFOREDEL;
            transformedName = transformedName.substring(prefix.length());
        } else if (transformedName.startsWith(ITransformerV2NodeConsDef.PREFIX_RUNNABLE_UPPER)) {
            prefix = ITransformerV2NodeConsDef.PREFIX_RUNNABLE;
            transformedName = transformedName.substring(prefix.length());
            if (transformedName.indexOf(sepA) != -1) {
                transformedName = transformedName.replace(sepA, sepB) + sepC;
            }
        } else if (transformedName.startsWith(ITransformerV2NodeConsDef.PREFIX_STANDLONE_UPPER)) {
            prefix = ITransformerV2NodeConsDef.PREFIX_STANDLONE;
            transformedName = transformedName.substring(prefix.length());
            if (transformedName.indexOf(sepA) != -1) {
                transformedName = transformedName.replace(sepA, sepB) + sepC;
            }
        } else if (transformedName.startsWith(ITransformerV2NodeConsDef.PREFIX_SMARTVIEW_UPPER)) {
            prefix = ITransformerV2NodeConsDef.PREFIX_SMARTVIEW;
            transformedName = transformedName.substring(prefix.length());
            if (transformedName.indexOf(sepA) != -1) {
                transformedName = transformedName.replace(sepA, sepB) + sepC;
            }
        } else {
            prefix = "";//$NON-NLS-1$
            transformedName = transformedName.substring(prefix.length());
        }

        return transformedName;
    }
}
