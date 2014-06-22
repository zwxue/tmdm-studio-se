package org.talend.mdm.repository.plugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.talend.mdm.repository.core.impl.RepositoryViewObjectResourceChangeManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class RepositoryPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.talend.mdm.repository"; //$NON-NLS-1$

    // The shared instance
    private static RepositoryPlugin plugin;

    /**
     * The constructor
     */
    public RepositoryPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        RepositoryViewObjectResourceChangeManager.startListening();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        RepositoryViewObjectResourceChangeManager.stopListening();
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static RepositoryPlugin getDefault() {
        return plugin;
    }

}
