package com.amalto.workbench.dialogs;



import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class ImportExchangeOptionsDialog extends Dialog implements  SelectionListener{

	private Button exportsBtn , dataModelBtn, executeBtn;
	private Table exchangeDwnTable;
	private FormToolkit toolkit;
	private StringBuffer zipFileRepository;
	
	private boolean export = true;
	private JSONObject[] dataContent = null;
	private static String EXCHANGE_DOWNLOAD_URL = "http://talendforge.org/exchange/mdm/api/get_revision_list.php?version=1&categories=";
	
	public ImportExchangeOptionsDialog(Shell parentShell, FormToolkit toolkit, boolean importOption, StringBuffer zipFileRepository) {
		super(parentShell);
        export = importOption;
		this.toolkit=toolkit;
		this.zipFileRepository = zipFileRepository;
	}
	
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText("Import from Talend Exchange options");
		
		Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 3;
		
		exportsBtn = new Button(composite, SWT.RADIO);
		exportsBtn.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1));
		exportsBtn.setText("exports");
		exportsBtn.setEnabled(export ? true : false);
		exportsBtn.setSelection(false);
		
		dataModelBtn = new Button(composite, SWT.RADIO);
		dataModelBtn.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1));
		dataModelBtn.setText("data-models");
		dataModelBtn.setEnabled(!export ? true : false);
		dataModelBtn.setSelection(false);

		executeBtn = new Button(composite, SWT.PUSH);
		executeBtn.setLayoutData(
				new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));
		executeBtn.addSelectionListener(this);
		executeBtn.setImage(ImageCache.getCreatedImage(EImage.REFRESH.getPath()));
		
		if(export) 
		    exchangeDwnTable = new Table(composite,SWT.VIRTUAL | SWT.FULL_SELECTION | SWT.BORDER |SWT.V_SCROLL |SWT.H_SCROLL);
		else
			exchangeDwnTable = new Table(composite,SWT.VIRTUAL | SWT.FULL_SELECTION | SWT.BORDER |SWT.V_SCROLL |SWT.H_SCROLL | SWT.MULTI);
		
		exchangeDwnTable.setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,3,1)
        );
        ((GridData)exchangeDwnTable.getLayoutData()).heightHint=300;
        exchangeDwnTable.setHeaderVisible(true);
        exchangeDwnTable.setLinesVisible(true);
    	
        final TableColumn column1 = new TableColumn(exchangeDwnTable, SWT.NONE);
        column1.setText("Name");
        final TableColumn column2 = new TableColumn(exchangeDwnTable, SWT.NONE);
        column2.setText("Revision");
        final TableColumn column3 = new TableColumn(exchangeDwnTable, SWT.NONE);
        column3.setText("Url");
        column1.setWidth(100);
        column2.setWidth(100);
        column3.setWidth(400);
        
        exchangeDwnTable.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event e) {
				TableItem item = (TableItem) e.item;
				int index = exchangeDwnTable.indexOf(item);
				try
				{
					JSONObject datum = dataContent[index];
					item.setText(new String[] {datum.get("name").toString(), datum.get("revision").toString(), datum.get("url").toString()});
				}
				catch(JSONException je)
				{
					je.printStackTrace();
				}
			}
		});
		
        exchangeDwnTable.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {}

			public void widgetSelected(SelectionEvent e) {
				getButton(IDialogConstants.OK_ID).setEnabled(exchangeDwnTable.getSelection().length >= 1 ? true : false);
			}
        	
        });
        
    	// Add sort indicator and sort data when column selected
    	Listener sortListener = new Listener() {
			@SuppressWarnings("unchecked")
			public void handleEvent(Event e) {
    			// determine new sort column and direction
    			TableColumn sortColumn = exchangeDwnTable.getSortColumn();
    			final TableColumn currentColumn = (TableColumn) e.widget;
    			int dir = exchangeDwnTable.getSortDirection();
    			if (sortColumn == currentColumn) {
    				dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
    			} else {
    				exchangeDwnTable.setSortColumn(currentColumn);
    				dir = SWT.UP;
    			}
    			// sort the data based on column and direction
    			final int direction = dir;
    			Arrays.sort(dataContent, new Comparator() {
    				public int compare(Object arg0, Object arg1) {
    					JSONObject jsonA = (JSONObject)arg0;
    					JSONObject jsonB = (JSONObject)arg1;
    					String valueA = null, valueB = null;
    					
						try {
							if (currentColumn == column1) {
								valueA = jsonA.get("name").toString();
								valueB = jsonB.get("name").toString();
							} else if (currentColumn == column2) {
								valueA = jsonA.get("revision").toString();
								valueB = jsonB.get("revision").toString();
							} else {
								valueA = jsonA.get("url").toString();
								valueB = jsonB.get("url").toString();
							}

							if (valueA.equals(valueB))
								return 0;
							if (direction == SWT.UP) {
								return valueA.compareTo(valueB) < 0 ? -1 : 1;
							}
							return valueA.compareTo(valueB) < 0 ? 1 : -1;
						} catch (JSONException je) {
							je.printStackTrace();
							return -1;
						}
    				}
    			});
    			// update data displayed in table
    			exchangeDwnTable.setSortDirection(dir);
    			exchangeDwnTable.clearAll();
    		}
    	};
        
        column1.addListener(SWT.Selection, sortListener);
        column2.addListener(SWT.Selection, sortListener);
        column3.addListener(SWT.Selection, sortListener);
        
        exchangeDwnTable.setSortColumn(column1);
        exchangeDwnTable.setSortDirection(SWT.UP);
       
        fillInTable();
        
        return composite;
	}

	private void fillInTable()
	{
		exchangeDwnTable.removeAll();
        HttpClient client = new HttpClient();
        String url = EXCHANGE_DOWNLOAD_URL + (export ?  "2" : "1");
        GetMethod get = new GetMethod(url); 
		try {
			client.executeMethod(get);
			String out = get.getResponseBodyAsString();
			JSONArray jsonArray = new JSONArray(out);
			dataContent = new JSONObject[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++)
			{
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String name = jsonObject.get("extension_name").toString();
				String revision = jsonObject.getString("revision_name");
				String download_url = jsonObject.getString("download_url").toString();
		        TableItem item = new TableItem(exchangeDwnTable, SWT.NONE);
		        item.setText(new String[] {name,  revision, download_url});
		        dataContent[i] = jsonObject;
			}
			exchangeDwnTable.setItemCount(dataContent.length);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		getButton(IDialogConstants.OK_ID).addSelectionListener(this);
	}
	
	public void widgetDefaultSelected(SelectionEvent e) {}

	public void widgetSelected(SelectionEvent e) {
		Button btn = (Button)e.getSource();
		if(btn == executeBtn)
		{
			fillInTable();
		}
	}
	@Override
	protected void okPressed() {
		//no close let Action Handler handle it
		unzipDownloadRes(export);
		super.okPressed();
	}
	    
	private void unzipDownloadRes(boolean export)
	{
        HttpClient client = new HttpClient();  
        JSONObject datum = dataContent[exchangeDwnTable.getSelectionIndex()];
        try {
	        GetMethod get = new GetMethod(datum.getString("download_url"));
			client.executeMethod(get);
			String downloadFolder = System.getProperty("user.dir") + File.separator + (export ? "temp" : "xsdTemp");
			String subFolderForTmp = downloadFolder + File.separator + "tmp" + System.currentTimeMillis();
	        File tempFile = new File(
	        		subFolderForTmp + File.separator + "tmp" + System.currentTimeMillis());

			File dir = new File(downloadFolder);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File subDir = new File(subFolderForTmp);
			if(!subDir.exists())
			{
				subDir.mkdir();
			}
			if(zipFileRepository.length() > 0)
			   zipFileRepository.delete(0, zipFileRepository.length());
            IOUtils.write(get.getResponseBody(), new FileOutputStream(tempFile));
            if(!export)
            {
			   ZipToFile.unZipFile(tempFile.getAbsolutePath(), subFolderForTmp);
		        boolean result = false;
		        int tryCount = 0;
		        while(!result && tryCount++ <10)
		        {
		            System.gc();
		            result = tempFile.delete();
		        }
		        zipFileRepository.append(subFolderForTmp);
            }
            else
            {
            	zipFileRepository.append(tempFile.getAbsolutePath());
            }
		} catch (Exception e1) {
			
			final MessageDialog dialog = new MessageDialog(this.getParentShell()
					.getShell(), "parsing error", null,  e1.getMessage(), MessageDialog.ERROR,
					new String[] { IDialogConstants.OK_LABEL }, 0);
			dialog.open();
		} 
	}

//	private void getImportedXSDList()
//	{
//		try {
//			for (int idx : exchangeDwnTable.getSelectionIndices()) {
//				JSONObject json = dataContent[idx];
//				imports.add(json.getString("url"));
//			}
//		} catch (JSONException je) {
//			je.printStackTrace();
//		}
//	}
}
