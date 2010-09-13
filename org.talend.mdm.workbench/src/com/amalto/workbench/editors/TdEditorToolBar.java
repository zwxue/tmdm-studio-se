package com.amalto.workbench.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;

public class TdEditorToolBar {

    private CoolBar coolBar = null;

    private CoolBarManager coolBarMgr;

    private ToolBarManager defaultToolBarMgr;


    private List<Action> actions = new ArrayList<Action>();

    public TdEditorToolBar(Composite parent,List<Action> actions) {

        // create coolbar

        coolBar = new CoolBar(parent, SWT.FLAT);
        coolBarMgr = new CoolBarManager(coolBar);

        GridData gid = new GridData();
        gid.horizontalAlignment = GridData.FILL;
        coolBar.setLayoutData(gid);

        // initialize default actions
        defaultToolBarMgr = new ToolBarManager(SWT.FLAT);
        

        for (Action action : actions) {
            defaultToolBarMgr.add(action);
        }

        // add all toolbars to parent coolbar
        coolBarMgr.add(new ToolBarContributionItem(defaultToolBarMgr));
        coolBarMgr.update(true);
    }

    public void addResizeListener(ControlListener listener) {
        coolBar.addControlListener(listener);
    }

    public CoolBar getToolbarControl() {
        return coolBar;
    }


    public void addActions(Action... actions) {
        assert actions != null;

        if (coolBarMgr != null) {
            for (Action action : actions) {
                defaultToolBarMgr.add(action);
            }

            // coolBarMgr.add(new ToolBarContributionItem(defaultToolBarMgr));
            defaultToolBarMgr.update(true);
            coolBarMgr.update(true);
        }
    }
}
