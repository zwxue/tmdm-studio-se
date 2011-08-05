package org.talend.mdm.webapp.synchronization2.client.widget;

import java.util.ArrayList;
import java.util.List;

import org.talend.mdm.webapp.synchronization2.client.Synchronization2;
import org.talend.mdm.webapp.synchronization2.client.Synchronization2ServiceAsync;
import org.talend.mdm.webapp.synchronization2.shared.SynBaseModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class Synchronization2Panel extends ContentPanel {

    private Synchronization2ServiceAsync service = Registry.get(Synchronization2.SYNCHRONIZATION2_SERVICE);
    private TextField<String> searchField; 
    private Grid<SynBaseModel> grid;
    private PagingToolBarEx pagingBar;
    
    public Synchronization2Panel() {
        super();
        this.setBodyBorder(false);
        this.setHeaderVisible(false);
        this.setLayout(new FitLayout());
        this.setWidth(800);
        this.setHeight(500);
        this.initComponent();
    }
    
    private void initComponent(){
        ToolBar toolBar = new ToolBar();
        
        searchField = new TextField<String>();
        searchField.setValue("*"); //$NON-NLS-1$
        toolBar.add(searchField);
        
        Button search = new Button("Search"); //$NON-NLS-1$
        toolBar.add(search);
        
        List<ColumnConfig> ccList = new ArrayList<ColumnConfig>();  
        ccList.add(new ColumnConfig("pk", "Entity PK", 100));    //$NON-NLS-1$//$NON-NLS-2$
        ccList.add(new ColumnConfig("lri", "Local Revision ID", 180));   //$NON-NLS-1$ //$NON-NLS-2$
        ccList.add(new ColumnConfig("lrsn", "Last Run Synchronization Name", 400));    //$NON-NLS-1$//$NON-NLS-2$
        ccList.add(new ColumnConfig("status", "Status", 100));   //$NON-NLS-1$ //$NON-NLS-2$
        
        RpcProxy<PagingLoadResult<SynBaseModel>> proxy = new RpcProxy<PagingLoadResult<SynBaseModel>>(){
            @Override
            protected void load(Object loadConfig, final AsyncCallback<PagingLoadResult<SynBaseModel>> callback) {
                String regex = searchField.getValue();
                regex = ".*.*";
                service.getSyncItems(regex, (PagingLoadConfig)loadConfig, new AsyncCallback<PagingLoadResult<SynBaseModel>>() {
                    
                    public void onSuccess(PagingLoadResult<SynBaseModel> result) {
                        callback.onSuccess(new BasePagingLoadResult<SynBaseModel>(result.getData(), result
                                .getOffset(), result.getTotalLength()));
                    }
                    
                    public void onFailure(Throwable result) {
                        callback.onSuccess(new BasePagingLoadResult<SynBaseModel>(new ArrayList<SynBaseModel>(), 0, 0));
                    }
                });
            }  
        };
        
        final PagingLoader<PagingLoadResult<SynBaseModel>> loader = new BasePagingLoader<PagingLoadResult<SynBaseModel>>(
                proxy);
        
        search.addSelectionListener(new SelectionListener<ButtonEvent>() {
            
            @Override
            public void componentSelected(ButtonEvent ce) {
                loader.load();
                
            }
        });
        final ListStore<SynBaseModel> store = new ListStore<SynBaseModel>(loader);
        ColumnModel cm = new ColumnModel(ccList);
        grid = new Grid<SynBaseModel>(store, cm);
        grid.setId("UpdateTableGrid"); //$NON-NLS-1$
        grid.addListener(Events.Attach, new Listener<GridEvent<SynBaseModel>>() {
            public void handleEvent(GridEvent<SynBaseModel> be) {
                PagingLoadConfig config = new BasePagingLoadConfig();
                config.setOffset(0);
                int pageSize = (Integer) pagingBar.getPageSize();
                config.setLimit(pageSize);
                loader.load(config);
            }
        });
        grid.setLoadMask(true);
        grid.setStateId("crossgrid");//$NON-NLS-1$
        pagingBar = new PagingToolBarEx(50);  
        pagingBar.bind(loader);
        
        this.setTopComponent(toolBar);
        this.add(grid);
        this.setBottomComponent(pagingBar);
    }
}
