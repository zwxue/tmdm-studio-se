package org.talend.mdm.repository.plugin;

import java.beans.PropertyChangeListener;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.impl.jobmodel.JobResourceListener;

/**
 * The activator class controls the plug-in life cycle
 */
public class RepositoryPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.talend.mdm.repository"; //$NON-NLS-1$

    // The shared instance
    private static RepositoryPlugin plugin;

    PropertyChangeListener jobListener = new JobResourceListener();

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
        ProxyRepositoryFactory.getInstance().addPropertyChangeListener(jobListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        if (jobListener != null) {
            ProxyRepositoryFactory.getInstance().removePropertyChangeListener(jobListener);
        }
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
