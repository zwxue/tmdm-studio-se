package org.talend.rcp.branding.tom.rcp;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
    private IWorkbenchAction introAction;

    private IWorkbenchWindow window;
    ActionBarBuildHelper helper;
    private  IActionBarConfigurer actionBarConfigurer;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {    	
        super(configurer);
        this.actionBarConfigurer=configurer;
        if (helper == null) {
            helper = new ActionBarBuildHelper();
        }
    }

    @Override
    protected void makeActions(final IWorkbenchWindow myWindow) {
        this.window = myWindow;
        helper.setWindow(myWindow);
        introAction = ActionFactory.INTRO.create(myWindow);
        register(introAction);
        CloseIntroAction  action= new CloseIntroAction();
        register(action);
        registerGlobalActions();
    }

    private void registerGlobalActions() {
        actionBarConfigurer.registerGlobalAction(ActionFactory.SAVE.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.UNDO.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.REDO.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.CUT.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.COPY.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.PASTE.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.DELETE.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.SELECT_ALL.create(window));
        actionBarConfigurer.registerGlobalAction(ActionFactory.REFRESH.create(window));
    }

    private static final String[] ACTIONSETID = new String[] {
            "org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo", //$NON-NLS-1$
            "org.eclipse.ui.edit.text.actionSet.annotationNavigation", "org.eclipse.ui.NavigateActionSet", //$NON-NLS-1$ //$NON-NLS-2$
            "org.eclipse.ui.WorkingSetActionSet", "org.eclipse.ui.edit.text.actionSet.navigation", //$NON-NLS-1$ //$NON-NLS-2$
            "org.eclipse.search.searchActionSet", "org.eclipse.ui.externaltools.ExternalToolsSet", "org.talend.repository.bootTalendActionSet" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    @Override
    protected void fillMenuBar(final IMenuManager menuBar) {
        helper.fillMenuBar(menuBar);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.application.ActionBarAdvisor#fillCoolBar(org.eclipse.jface. action.ICoolBarManager)
     */
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
        helper.fillCoolBar(coolBar);
    }
    
}
