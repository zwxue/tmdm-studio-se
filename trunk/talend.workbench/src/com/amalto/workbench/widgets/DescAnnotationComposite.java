package com.amalto.workbench.widgets;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.AnnotationLanguageLabelsDialog;
import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.utils.Util;

/**
 * This class is meant to work out a composite populated with
 * label, button, text which stand next to each other
 * the composite will in the parent composite holder 
 * @author fliu
 *
 */

public class DescAnnotationComposite implements  SelectionListener{

	private Button annotationButton;
	private Text descriptionText;
	private Composite descAntionHolder;
    private AMainPageV2 accommodation;
    
    private LinkedHashMap<String, String> dataStore = new LinkedHashMap<String, String>();
    private static final String REGEXP_METACHARACTERS = "\\[([\\w]+):([\\w]+)\\]";  
    private static final Pattern DESC_PATTERN = Pattern.compile(REGEXP_METACHARACTERS);
    
	public DescAnnotationComposite(String labelName, String buttonName, FormToolkit toolkit, Composite parent, AMainPageV2 dialog)
	{
		descAntionHolder = toolkit.createComposite(parent);
		descAntionHolder.setLayoutData( new GridData(SWT.FILL,SWT.RIGHT,true,true,2,1));
		descAntionHolder.setLayout(new GridLayout(3,false));
		
		Label descriptionLabel = toolkit.createLabel(descAntionHolder, labelName, SWT.NULL);
        descriptionLabel.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
        
		annotationButton = toolkit.createButton(descAntionHolder, buttonName, SWT.PUSH);
		annotationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		annotationButton.addSelectionListener(this);
		
		descriptionText = toolkit.createText(descAntionHolder, "",SWT.BORDER|SWT.MULTI);
        descriptionText.setLayoutData(    
                 new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
         );
        descriptionText.setEnabled(false);
        
        accommodation = dialog;
	}
	
	public void setText(String text)
	{
		dataStore.clear();
		descriptionText.setText(text);
		
		boolean find = false;
		Matcher match = DESC_PATTERN.matcher(text);
		while (match.find())
		{	
			find = true;
			String country = match.group(1);
			String desc = match.group(2);
			dataStore.put(country.toLowerCase(), desc.trim());
		}
		
		if (!find && !text.equals(""))
		{
			dataStore.put("en", text);
		}
	}
	
	public String getText()
	{
		return descriptionText.getText();
	}
	
	public void widgetSelected(SelectionEvent e)
	{
        AnnotationLanguageLabelsDialog dlg = new AnnotationLanguageLabelsDialog(
        		dataStore,
        		new DescAnnotationListener(),
				accommodation.getPartControl().getShell(),
				"Set the Descriptions of This Element"
		);
        
        dlg.setBlockOnOpen(true);
		dlg.open();
		
		if (dlg.getReturnCode() == Window.OK)  {
			
			dlg.close();
		}
	}
	
	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
	
	public String commitChange()
	{
		return descriptionText.getText();
	}
	
	public Composite getComposite()
	{
		return descAntionHolder;
	}
	
	private class DescAnnotationListener implements SelectionListener{
		
		public DescAnnotationListener() {
			super();
		}
		public void widgetSelected(SelectionEvent e) {
			AnnotationLanguageLabelsDialog dlg = (AnnotationLanguageLabelsDialog)((Widget)e.getSource()).getData("dialog");
			if (dlg.getReturnCode() == Window.OK)  {
				String outPut = "";
				for (Map.Entry<String, String> m : dataStore.entrySet())
				{
					outPut += "[" + m.getKey().toUpperCase() + ":" + m.getValue() + "]";
				}
				
				if (!outPut.equals(descriptionText.getText()))
				{
					descriptionText.setText(outPut);
					accommodation.markDirty();
				}

	        }
			dlg.close();

		}
		public void widgetDefaultSelected(SelectionEvent e) {};
	}
}
