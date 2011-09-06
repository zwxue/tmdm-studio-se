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
package org.talend.mdm.webapp.synchronizationAction2.client;

import org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class SynchronizationAction2 implements EntryPoint {

    public static String SYNCHRONIZTIONACTION_SERVICE = "synchronizationActionService"; //$NON-NLS-1$

    public void onModuleLoad() {

        Window.setTitle(Window.getTitle() + " synchronizationAction2"); //$NON-NLS-1$
        XDOM.setAutoIdPrefix(GWT.getModuleName() + "-" + XDOM.getAutoIdPrefix()); //$NON-NLS-1$
        registerPubService();
        Registry.register(SYNCHRONIZTIONACTION_SERVICE, GWT.create(SynchronizationActionService.class));

    }

    private native void registerPubService()/*-{
        var instance = this;
        $wnd.amalto.synchronizationAction2 = {};
        $wnd.amalto.synchronizationAction2.SynchronizationAction2 = function(){

        function initUI(){
        instance.@org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationAction2::initUI()();
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
        var panel = tabPanel.getItem("synchronizationAction2"); 
        if (panel == undefined){
        @org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer::generateContentPanel()();
        panel = this.@org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationAction2::createPanel()();
        tabPanel.add(panel);
        }
        tabPanel.setSelection(panel.getItemId());
    }-*/;

    native JavaScriptObject createPanel()/*-{
        var instance = this;
        var panel = {
        render : function(el){
        instance.@org.talend.mdm.webapp.synchronizationAction2.client.SynchronizationAction2::renderContent(Ljava/lang/String;)(el.id);
        },
        setSize : function(width, height){
        var cp = @org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer::getContentPanel()();
        cp.@com.extjs.gxt.ui.client.widget.ContentPanel::setSize(II)(width, height);
        },
        getItemId : function(){
        var cp = @org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer::getContentPanel()();
        return cp.@com.extjs.gxt.ui.client.widget.ContentPanel::getItemId()();
        },
        getEl : function(){
        var cp = @org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer::getContentPanel()();
        var el = cp.@com.extjs.gxt.ui.client.widget.ContentPanel::getElement()();
        return {dom : el};
        },
        doLayout : function(){
        var cp = @org.talend.mdm.webapp.synchronizationAction2.client.widget.GenerateContainer::getContentPanel()();
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
