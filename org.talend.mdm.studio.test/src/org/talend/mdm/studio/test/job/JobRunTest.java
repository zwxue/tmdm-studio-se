// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

package org.talend.mdm.studio.test.job;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * @author rhou
 *
 */
public class JobRunTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem jobParentItem;

    private SWTBotTreeItem jobItem;

    @Before
    public void runBeforeEveryTest() {
        jobParentItem = serverItem.getNode("Job Repository");
        jobParentItem.expand();
        jobItem=jobParentItem.getNode("Source Jobs").getNode(0);

    }

    @After
    public void runAfterEveryTest() {

    }
    //new feature in 4.2,see bug 0018022,0018002
    @Test
    public void jobRunTest(){
    	jobItem.contextMenu("Run").click();
    }
}
