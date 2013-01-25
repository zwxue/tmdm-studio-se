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

import java.lang.reflect.Field;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.views.markers.ExtendedMarkersView;
import org.eclipse.ui.internal.views.markers.MarkerContentGenerator;
import org.eclipse.ui.views.markers.MarkerSupportView;
import org.eclipse.ui.views.markers.internal.ContentGeneratorDescriptor;
import org.talend.mdm.repository.ui.markers.datamodel.ModelNameMarkerGroup;

/**
 * created by HHB on 2013-1-5 Detailled comment
 * 
 */
public class MDMProblemView extends MarkerSupportView {

    static Logger log = Logger.getLogger(MDMProblemView.class);

    private static final String GENERATOR_ID = "org.talend.mdm.problemsGenerator"; //$NON-NLS-1$

    /**
     * DOC HHB MDMProblemView constructor comment.
     * 
     * @param contentGeneratorId
     */
    public MDMProblemView() {
        super(GENERATOR_ID);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.internal.views.markers.ExtendedMarkersView#init(org.eclipse.ui.IViewSite,
     * org.eclipse.ui.IMemento)
     */
    @Override
    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);
        hookModelGroup();
    }

    /**
     * DOC HHB Comment method "hookModelGroup".
     */
    private void hookModelGroup() {

        try {
            Field generatorField = ExtendedMarkersView.class.getDeclaredField("generator");
            Field descField = MarkerContentGenerator.class.getDeclaredField("generatorDescriptor");
            Field groupsField = ContentGeneratorDescriptor.class.getDeclaredField("groups");
            if (generatorField != null && descField != null && groupsField != null) {
                generatorField.setAccessible(true);
                descField.setAccessible(true);
                groupsField.setAccessible(true);
                Object object = generatorField.get(this);
                if (object != null) {
                    Object descObj = descField.get(object);
                    if (descObj != null) {
                        Object groupObj = groupsField.get(descObj);

                        Set groups = (Set) groupObj;
                        groups.add(new ModelNameMarkerGroup());
                    }
                }
            }

        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }

    }

}
