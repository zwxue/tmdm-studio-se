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
package com.amalto.workbench.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class PageingToolBar {

    int pagesize = 20;

    int page = 1;

    int totalsize;

    int totalpage;

    Composite parent;

    WidgetFactory toolkit = WidgetFactory.getWidgetFactory();

    private Label displayItems;

    private Text pageSizeText;

    private Button refreshBtn;

    private Label totalPage;

    private Button firstPageBtn;

    private Button prevPageBtn;

    private Text pageText;

    private Button nextPageBtn;

    private Button lastPageBtn;

    IPagingListener listener;

    public void setPageingListener(IPagingListener listener) {
        this.listener = listener;
    }

    public PageingToolBar(Composite parent) {
        this.parent = parent;
        create();
    }

    public int getStart() {
        return (page - 1) * pagesize;
    }

    public int getLimit() {
        return pagesize;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;

        totalpage = totalsize % pagesize == 0 ? totalsize / pagesize : totalsize / pagesize + 1;
    }

    public void reset() {
        pagesize = 20;
        page = 1;
        totalsize = 0;
        totalpage = 0;
        refreshUI();
    }

    public PageingToolBar(Composite parent, int pagesize, int page, int totalsize) {
        this.parent = parent;
        this.page = page;
        this.pagesize = pagesize;
        this.totalsize = totalsize;
        totalpage = totalsize % pagesize == 0 ? totalsize / pagesize : totalsize / pagesize + 1;
        create();
    }

    KeyListener keylistener = new KeyListener() {

        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.keyCode == SWT.CR) {
                page = Integer.valueOf(pageText.getText());
                pagesize = Integer.valueOf(pageSizeText.getText());
                totalpage = totalsize / pagesize + 1;
                if (listener != null) {
                    listener.doSearch();
                }
                refreshUI();
            }
        }

        public void keyPressed(KeyEvent e) {

        }
    };

    SelectionListener selListener = new SelectionListener() {

        public void widgetSelected(SelectionEvent e) {
            page = Integer.valueOf(pageText.getText());
            pagesize = Integer.valueOf(pageSizeText.getText());
            totalpage = totalsize / pagesize + 1;
            if (listener != null) {
                listener.doSearch();
            }
            refreshUI();
        }

        public void widgetDefaultSelected(SelectionEvent e) {
            // TODO Auto-generated method stub

        }
    };

    private Composite comp;

    public Composite getComposite() {
        return comp;
    }

    private void create() {
        comp = toolkit.createComposite(parent);
        GridLayout layout = new GridLayout(15, false);
        layout.marginBottom = 0;
        layout.marginTop = 0;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        comp.setLayout(layout);
        // firstpage
        GridData gd = new GridData();
        firstPageBtn = toolkit.createButton(comp, "", SWT.PUSH);//$NON-NLS-1$
        firstPageBtn.setToolTipText("First Page");
        firstPageBtn.setImage(ImageCache.getCreatedImage("icons/page-first.gif"));//$NON-NLS-1$
        firstPageBtn.setLayoutData(gd);
        // previous page
        gd = new GridData();
        prevPageBtn = toolkit.createButton(comp, "", SWT.PUSH);//$NON-NLS-1$
        prevPageBtn.setToolTipText("Previous Page");
        prevPageBtn.setImage(ImageCache.getCreatedImage("icons/page-prev.gif"));//$NON-NLS-1$
        prevPageBtn.setLayoutData(gd);
        // page
        // Button btn=toolkit.createButton(comp, "", SWT.SEPARATOR);
        // gd=new GridData();
        // btn.setLayoutData(gd);
        Label label = toolkit.createLabel(comp, "Page", SWT.NULL);
        gd = new GridData();
        label.setLayoutData(gd);
        pageText = toolkit.createText(comp, "" + page);//$NON-NLS-1$
        gd = new GridData();
        gd.widthHint = 25;
        pageText.setLayoutData(gd);
        pageText.addKeyListener(keylistener);

        totalPage = toolkit.createLabel(comp, "of " + totalpage, SWT.NULL);
        gd = new GridData();
        totalPage.setLayoutData(gd);

        // Button btn1=toolkit.createButton(comp, "", SWT.SEPARATOR);
        // gd=new GridData();
        // btn1.setLayoutData(gd);

        // nextpage
        gd = new GridData();
        nextPageBtn = toolkit.createButton(comp, "", SWT.PUSH);//$NON-NLS-1$
        nextPageBtn.setToolTipText("Next Page");
        nextPageBtn.setImage(ImageCache.getCreatedImage("icons/page-next.gif"));//$NON-NLS-1$
        nextPageBtn.setLayoutData(gd);
        // last page
        gd = new GridData();
        lastPageBtn = toolkit.createButton(comp, "", SWT.PUSH);//$NON-NLS-1$
        lastPageBtn.setToolTipText("Last Page");
        lastPageBtn.setImage(ImageCache.getCreatedImage("icons/page-last.gif"));//$NON-NLS-1$
        lastPageBtn.setLayoutData(gd);
        // refresh
        // Button btn2=toolkit.createButton(comp, "", SWT.SEPARATOR);
        // gd=new GridData();
        // btn2.setLayoutData(gd);
        refreshBtn = toolkit.createButton(comp, "", SWT.PUSH);
        gd = new GridData();
        refreshBtn.setToolTipText("Refresh");
        refreshBtn.setLayoutData(gd);
        refreshBtn.setImage(ImageCache.getCreatedImage(EImage.REFRESH.getPath()));

        // Button btn3=toolkit.createButton(comp, "", SWT.SEPARATOR);
        // gd=new GridData();
        // btn3.setLayoutData(gd);

        // page size
        Label label3 = toolkit.createLabel(comp, "Number of lines per page:", SWT.NULL);
        gd = new GridData();
        label3.setLayoutData(gd);

        pageSizeText = toolkit.createText(comp, "" + pagesize);//$NON-NLS-1$
        gd = new GridData();
        gd.widthHint = 25;
        pageSizeText.setLayoutData(gd);
        pageSizeText.addKeyListener(keylistener);

        // display items
        displayItems = toolkit.createLabel(comp, "");//$NON-NLS-1$
        gd = new GridData(SWT.RIGHT, SWT.CENTER, true, true);
        displayItems.setLayoutData(gd);

        // add sellistener
        firstPageBtn.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                page = 1;
                if (listener != null) {
                    listener.doSearch();
                }
                refreshUI();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        prevPageBtn.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                page = page - 1 <= 1 ? 1 : page - 1;
                if (listener != null) {
                    listener.doSearch();
                }
                refreshUI();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        nextPageBtn.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                page = page + 1 >= totalpage ? totalpage : page + 1;
                if (listener != null) {
                    listener.doSearch();
                }
                refreshUI();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        lastPageBtn.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                page = totalpage;
                if (listener != null) {
                    listener.doSearch();
                }
                refreshUI();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        refreshBtn.addSelectionListener(selListener);
    }

    public void refreshUI() {
        long count = page * pagesize > totalsize ? totalsize : page * pagesize;
        displayItems.setText("Display items of " + ((page - 1) * pagesize + 1) + "-" + count + " of " + totalsize);
        pageSizeText.setText("" + pagesize);//$NON-NLS-1$
        pageText.setText("" + page);//$NON-NLS-1$
        totalPage.setText("of " + totalpage);
        if (page <= 1) {
            firstPageBtn.setImage(ImageCache.getCreatedImage("icons/page-first-disabled.gif"));//$NON-NLS-1$
            prevPageBtn.setImage(ImageCache.getCreatedImage("icons/page-prev-disabled.gif"));//$NON-NLS-1$
            firstPageBtn.setEnabled(false);
            prevPageBtn.setEnabled(false);
        } else {
            firstPageBtn.setImage(ImageCache.getCreatedImage("icons/page-first.gif"));//$NON-NLS-1$
            prevPageBtn.setImage(ImageCache.getCreatedImage("icons/page-prev.gif"));//$NON-NLS-1$
            firstPageBtn.setEnabled(true);
            prevPageBtn.setEnabled(true);
        }
        if (page >= totalpage) {
            nextPageBtn.setImage(ImageCache.getCreatedImage("icons/page-next-disabled.gif"));//$NON-NLS-1$
            lastPageBtn.setImage(ImageCache.getCreatedImage("icons/page-last-disabled.gif"));//$NON-NLS-1$
            nextPageBtn.setEnabled(false);
            lastPageBtn.setEnabled(false);
        } else {
            nextPageBtn.setImage(ImageCache.getCreatedImage("icons/page-next.gif"));//$NON-NLS-1$
            lastPageBtn.setImage(ImageCache.getCreatedImage("icons/page-last.gif"));//$NON-NLS-1$
            nextPageBtn.setEnabled(true);
            lastPageBtn.setEnabled(true);
        }
    }
}
