package com.amalto.workbench.widgets;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.amalto.workbench.webservices.WSVersioningHistoryEntry;

public class VersionTagWidget {

	private Text tagText;
	private Text commentText;
	private Button tagButton;
	private TableViewer tagsViewer;
	private Composite composite;
	private Button restoreButton;

	public VersionTagWidget(Composite parent, String resourcesName){
		 composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;		
		composite.setLayout(layout);
		Group tagGroup = new Group(composite,SWT.SHADOW_NONE);
		tagGroup.setLayout(new GridLayout(2,false));
		tagGroup.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		tagGroup.setText("Tag "+resourcesName);

		Label tagLabel = new Label(tagGroup, SWT.NONE);
		tagLabel.setLayoutData(
				new GridData(SWT.LEFT,SWT.FILL,false,false,1,1)
		);
		tagLabel.setText("Tag");

		tagText = new Text(tagGroup, SWT.NONE);
		tagText.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		tagText.setText("");

		Label commentLabel = new Label(tagGroup, SWT.NONE);
		commentLabel.setLayoutData(
				new GridData(SWT.LEFT,SWT.FILL,false,false,1,1)
		);
		commentLabel.setText("Comment");

		commentText = new Text(tagGroup, SWT.NONE);
		commentText.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		commentText.setText("");
		((GridData)commentText.getLayoutData()).widthHint=250;

		
	     tagButton = new Button(tagGroup,SWT.PUSH);
		tagButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
		);
		tagButton.setText("OK");
						
		Group restoreGroup = new Group(composite,SWT.SHADOW_NONE);
		restoreGroup.setLayout(new GridLayout(1,true));
		restoreGroup.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		restoreGroup.setText("Restore "+resourcesName);
		restoreGroup.setEnabled(false);
		
		
		tagsViewer = new TableViewer(restoreGroup);
        tagsViewer.getControl().setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,4,1)
        );
        ((GridData)tagsViewer.getControl().getLayoutData()).heightHint=150;
        tagsViewer.setContentProvider(new ArrayContentProvider());
        tagsViewer.setLabelProvider(new ITableLabelProvider() {
        	public String getColumnText(Object element, int columnIndex) {
				WSVersioningHistoryEntry entry = (WSVersioningHistoryEntry) element;
				return
						entry.getTag()+" - "+
						entry.getComments()+"  ["+
						entry.getDate()+" "+
						entry.getAuthor()+"]";
        	}
        	public Image getColumnImage(Object element, int columnIndex) {
        		// TODO Auto-generated method stub
        		return null;
        	}
        	public void addListener(ILabelProviderListener listener) {}
        	public void dispose() {}
        	public boolean isLabelProperty(Object element, String property) {
        		return false;
        	}
        	public void removeListener(ILabelProviderListener listener) {}
        });


		
	    restoreButton = new Button(restoreGroup,SWT.PUSH);
		restoreButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		restoreButton.setText("Restore");
	}

	public Button getRestoreButton() {
		return restoreButton;
	}

	public void setRestoreButton(Button restoreButton) {
		this.restoreButton = restoreButton;
	}

	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}

	public Text getTagText() {
		return tagText;
	}

	public void setTagText(Text tagText) {
		this.tagText = tagText;
	}

	public Text getCommentText() {
		return commentText;
	}

	public void setCommentText(Text commentText) {
		this.commentText = commentText;
	}

	public Button getTagButton() {
		return tagButton;
	}

	public void setTagButton(Button tagButton) {
		this.tagButton = tagButton;
	}

	public TableViewer getTagsViewer() {
		return tagsViewer;
	}

	public void setTagsViewer(TableViewer tagsViewer) {
		this.tagsViewer = tagsViewer;
	}
	
	
}
