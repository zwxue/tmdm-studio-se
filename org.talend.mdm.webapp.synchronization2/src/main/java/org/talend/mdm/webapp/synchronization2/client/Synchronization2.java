package org.talend.mdm.webapp.synchronization2.client;

import org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer;
import org.talend.mdm.webapp.synchronization2.client.widget.Synchronization2Panel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class Synchronization2 implements EntryPoint {

    public static final String SYNCHRONIZATION2_SERVICE = "Synchronization2Service"; //$NON-NLS-1$

    public void onModuleLoad() {
        Window.setTitle(Window.getTitle() + " synchronization2"); //$NON-NLS-1$
        XDOM.setAutoIdPrefix(GWT.getModuleName() + "-" + XDOM.getAutoIdPrefix()); //$NON-NLS-1$
        registerPubService();
        
        Registry.register(SYNCHRONIZATION2_SERVICE, GWT.create(Synchronization2Service.class));
    }

    private native void registerPubService()/*-{
        var instance = this;
        $wnd.amalto.synchronization2 = {};
        $wnd.amalto.synchronization2.Synchronization2 = function(){

        function initUI(){
        instance.@org.talend.mdm.webapp.synchronization2.client.Synchronization2::initUI()();
        }

        return {
        init : function(){initUI();}
        }
        }();
    }-*/;

    public void initUI() {
        _initUI();
    }

    private native void _initUI()/*-{
        var tabPanel = $wnd.amalto.core.getTabPanel();
        var panel = tabPanel.getItem("synchronization2"); 
        if (panel == undefined){
        @org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer::generateContentPanel()();
        panel = this.@org.talend.mdm.webapp.synchronization2.client.Synchronization2::createPanel()();
        tabPanel.add(panel);
        }
        tabPanel.setSelection(panel.getItemId());
    }-*/;

    native JavaScriptObject createPanel()/*-{
        var instance = this;
        var panel = {
        render : function(el){
        instance.@org.talend.mdm.webapp.synchronization2.client.Synchronization2::renderContent(Ljava/lang/String;)(el.id);
        },
        setSize : function(width, height){
        var cp = @org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer::getContentPanel()();
        cp.@com.extjs.gxt.ui.client.widget.ContentPanel::setSize(II)(width, height);
        },
        getItemId : function(){
        var cp = @org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer::getContentPanel()();
        return cp.@com.extjs.gxt.ui.client.widget.ContentPanel::getItemId()();
        },
        getEl : function(){
        var cp = @org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer::getContentPanel()();
        var el = cp.@com.extjs.gxt.ui.client.widget.ContentPanel::getElement()();
        return {dom : el};
        },
        doLayout : function(){
        var cp = @org.talend.mdm.webapp.synchronization2.client.widget.GenerateContainer::getContentPanel()();
        return cp.@com.extjs.gxt.ui.client.widget.ContentPanel::doLayout()();
        }
        };
        return panel;
    }-*/;

    public void renderContent(final String contentId) {
        RootPanel panel = RootPanel.get(contentId);
        panel.add(GenerateContainer.getContentPanel());
    }

}