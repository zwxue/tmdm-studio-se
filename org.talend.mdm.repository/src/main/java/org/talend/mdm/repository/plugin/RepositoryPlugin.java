package org.talend.mdm.repository.plugin;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.talend.mdm.repository.core.impl.jobmodel.JobResourceListener;

/**
 * The activator class controls the plug-in life cycle
 */
public class RepositoryPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.talend.mdm.repository"; //$NON-NLS-1$

    // The shared instance
    private static RepositoryPlugin plugin;

    IResourceChangeListener jobResourceListener = new JobResourceListener();

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
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        ResourcesPlugin.getWorkspace().addResourceChangeListener(jobResourceListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(jobResourceListener);
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
