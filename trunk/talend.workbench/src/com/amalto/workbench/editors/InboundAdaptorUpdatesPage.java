/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundAdaptorArrayWsInboundAdaptorsUpdates;

public class InboundAdaptorUpdatesPage extends AFormPage implements ITextListener {

	protected SectionPart editorPart;

	protected Text xpathText;

	protected Text keysText;

	protected Button addButton;

	protected ListViewer updatesViewer;

	//protected DropTarget windowTarget;

	private boolean refreshing = false;

	private boolean comitting = false;

	public InboundAdaptorUpdatesPage(FormEditor editor) {
		super(editor, InboundAdaptorUpdatesPage.class.getName(), "Partial Updates ");
	}

	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		try {

			FormToolkit toolkit = managedForm.getToolkit();

			final ScrolledForm form = managedForm.getForm();
			TableWrapLayout formLayout = new TableWrapLayout();
			form.getBody().setLayout(formLayout);

			formLayout.numColumns = 1;

			// create the FormPart
			editorPart = new SectionPart(form.getBody(), toolkit, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED);
			managedForm.addPart(editorPart);

			// Layout the components
			Section editorSection = editorPart.getSection();
			editorSection.setText("Partial Updates");
			editorSection.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			((TableWrapData) editorSection.getLayoutData()).heightHint = 500;

			editorSection.addExpansionListener(new ExpansionAdapter() {
				public void expansionStateChanged(ExpansionEvent e) {
					form.reflow(true);
				}
			});

			toolkit.createCompositeSeparator(editorSection);

			Composite charComposite = toolkit.createComposite(editorSection);
			charComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			GridLayout charLayout = new GridLayout(2, false);
			charComposite.setLayout(charLayout);

			editorSection.setClient(charComposite);

			// New Update Group
			Group newGroup = new Group(charComposite, SWT.SHADOW_NONE);
			newGroup.setText("New update");
			newGroup.setLayout(new GridLayout(2, true));
			newGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

			// xpath
			Label xpathLabel = toolkit.createLabel(newGroup, "XPath of the Data Model Business Element to update", SWT.SHADOW_NONE);
			xpathLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
			xpathText = toolkit.createText(newGroup, "", SWT.BORDER | SWT.SINGLE);
			xpathText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

			// keys
			Label keysLabel = toolkit.createLabel(newGroup, "Keys: comma separated list of Keys xpath relative to the Business Element", SWT.NULL);
			keysLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
			keysText = toolkit.createText(newGroup, "", SWT.BORDER | SWT.SINGLE);
			keysText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

			addButton = toolkit.createButton(newGroup, "Add", SWT.PUSH);
			addButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, false, 2, 1));
			addButton.addMouseListener(new MouseListener() {
				public void mouseDoubleClick(MouseEvent e) {
				}

				public void mouseDown(MouseEvent e) {
				}

				public void mouseUp(MouseEvent e) {
					if ("".equals(xpathText.getText().trim()))
						return;
					WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());
					WSInboundAdaptorArrayWsInboundAdaptorsUpdates[] updates = wsObject.getUpdates();
					ArrayList l = new ArrayList();
					if (updates != null) {
						for (int i = 0; i < updates.length; i++) {
							if (updates [i]!=null) l.add(updates[i]); //nulls shoudl not happen but they do
						}
					}
					
					/*
					for (Iterator iter = l.iterator(); iter.hasNext();) {
						WSInboundAdaptorArrayWsInboundAdaptorsUpdates upd = (WSInboundAdaptorArrayWsInboundAdaptorsUpdates) iter.next();
						System.out.println("    " + upd.getXpath());
					}
					*/

					String ks = keysText.getText().replaceAll(" ","");
					//System.out.println("KEYS:   " +ks+"   -  "+ Util.joinStrings(ks.split("\\,")," _ "));
					WSInboundAdaptorArrayWsInboundAdaptorsUpdates newUpdate = 
						new WSInboundAdaptorArrayWsInboundAdaptorsUpdates(
							xpathText.getText(), 
							ks.split("\\,")
						);
					l.add(newUpdate);
					wsObject.setUpdates((WSInboundAdaptorArrayWsInboundAdaptorsUpdates[]) l
							.toArray(new WSInboundAdaptorArrayWsInboundAdaptorsUpdates[l.size()]));
					updatesViewer.refresh();
					editorPart.markDirty();
				}
			});

			
//			 Existing updates Update Group
			Group existingGroup = new Group(charComposite, SWT.SHADOW_NONE);
			existingGroup.setText("Existing partial updates");
			existingGroup.setLayout(new GridLayout(2, true));
			existingGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
			
			// updates
			updatesViewer = new ListViewer(existingGroup, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			updatesViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
			updatesViewer.setContentProvider(new IStructuredContentProvider() {
				public Object[] getElements(Object inputElement) {
					WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());
					WSInboundAdaptorArrayWsInboundAdaptorsUpdates[] updates = wsObject.getUpdates();

					if (updates==null) return new InboundAdaptorUpdate[0];
					
					ArrayList c = new ArrayList();
					for (int i = 0; i < updates.length; i++) {
						if (updates[i]!=null) { //not sure why nulls happen
							InboundAdaptorUpdate update = new InboundAdaptorUpdate(
									updates[i].getXpath(), 
									(updates[i].getKeys() == null ? null : Arrays.asList(updates[i].getKeys()))
							);
							c.add(update);
						}
					}
					return c.toArray(new InboundAdaptorUpdate[c.size()]);			
				}

				public void dispose() {
				}

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			});
			updatesViewer.setLabelProvider(new LabelProvider());
			updatesViewer.setSorter(null);
			updatesViewer.setInput("");
			//delete key
            updatesViewer.getControl().addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					int index = ((List)updatesViewer.getControl()).getSelectionIndex();
					if ((e.stateMask==0) && (e.character == SWT.DEL) && (index>=0)) {
						WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());
						WSInboundAdaptorArrayWsInboundAdaptorsUpdates[] updates = wsObject.getUpdates();
						ArrayList c = new ArrayList();
						for (int i = 0; i < updates.length; i++) {
							if (i != index)
								c.add(updates[i]);
						}
						wsObject.setUpdates((WSInboundAdaptorArrayWsInboundAdaptorsUpdates[]) c.toArray(new WSInboundAdaptorArrayWsInboundAdaptorsUpdates[c.size()]));
						editorPart.markDirty();
						updatesViewer.refresh();
					}
				}
            });
			
			

			/*******************************************************************
			 * DND
			 ******************************************************************/

			//FIXME: problem on DND probably due to UpdateTransfer
			/*

			DragSource viewerSource = new DragSource(updatesViewer.getControl(), DND.DROP_MOVE | DND.DROP_COPY);
			viewerSource.setTransfer(new Transfer[] { new UpdateTransfer() });
			viewerSource.addDragListener(new DCDragSourceListener());
			
			// make the Eclipse window a DropTarget - we need to dispose it
			windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
			windowTarget.setTransfer(new Transfer[] { new UpdateTransfer() });
			windowTarget.addDropListener(new DCDropTargetListener());

			
			DropTarget newTarget = new DropTarget(newGroup, DND.DROP_MOVE | DND.DROP_COPY);
			newTarget.setTransfer(new Transfer[] { new UpdateTransfer() });
			newTarget.addDropListener(new DCDropTargetListener());
			*/

			refreshData();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// createCharacteristicsContent

	protected void refreshData() {
		try {

			if (this.comitting)
				return;

			this.refreshing = true;

			updatesViewer.refresh();

			this.refreshing = false;

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: " + e.getLocalizedMessage());
		}
	}

	protected void commit() {
		try {

			if (this.refreshing)
				return;

			this.comitting = true;

			// comitting is done directly by the add button

			this.comitting = false;

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: " + e.getLocalizedMessage());
		}
	}

	protected void createActions() {
	}

	public void textChanged(TextEvent event) {
		if (this.refreshing)
			return;
		editorPart.markDirty();
	}

	/*
	 * private void hookContextMenu(TreeViewer viewer) { }
	 * 
	 * private void fillContextMenu(IMenuManager manager) { }
	 */

	public void dispose() {
		super.dispose();
		//windowTarget.dispose();
	}

	/***************************************************************************
	 * DND
	 **************************************************************************/

	class DCDragSourceListener implements DragSourceListener {
		private int selected;

		public void dragFinished(DragSourceEvent event) {
			// remove the value from the list viewer
			//always remove?
				WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());
				WSInboundAdaptorArrayWsInboundAdaptorsUpdates[] updates = wsObject.getUpdates();
				ArrayList c = new ArrayList();
				for (int i = 0; i < updates.length; i++) {
					if (i != this.selected)
						c.add(updates[i]);
				}
				wsObject.setUpdates((WSInboundAdaptorArrayWsInboundAdaptorsUpdates[]) c.toArray(new WSInboundAdaptorArrayWsInboundAdaptorsUpdates[c.size()]));
				editorPart.markDirty();
				updatesViewer.refresh();
		}

		public void dragSetData(DragSourceEvent event) {
			//if ((new UpdateTransfer()).isSupportedType(event.dataType)) {
				IStructuredSelection selection = ((IStructuredSelection) updatesViewer.getSelection());
				InboundAdaptorUpdate update = (InboundAdaptorUpdate) selection.getFirstElement();
				event.data = new InboundAdaptorUpdate[] { update };
				//System.out.println("Selected: "+this.selected+" - "+update.toString()+ "  -  "+event.dataType.type);
			//}
		}

		public void dragStart(DragSourceEvent event) {
			Control control = ((DragSource) event.widget).getControl();
			//if ((control instanceof List))
				event.doit = (((List) control).getItemCount() > 0);
		}
	}

	class DCDropTargetListener implements DropTargetListener {

		public void dragEnter(DropTargetEvent event) {
			//System.out.println("dragEnter "+event.currentDataType.type);
			event.detail = DND.DROP_MOVE;
		}

		public void dragLeave(DropTargetEvent event) {
		}

		public void dragOperationChanged(DropTargetEvent event) {
		}

		public void dragOver(DropTargetEvent event) {
			//System.out.println("Drag Over "+event.currentDataType.type);
		}

		public void drop(DropTargetEvent event) {
			Control control = ((DropTarget) event.widget).getControl();
			if (control instanceof Group) {
				System.out.println("In the group "+event.currentDataType.type);
				System.out.println("Target data: "+event.data);
				InboundAdaptorUpdate update = ((InboundAdaptorUpdate[]) event.data)[0];
				xpathText.setText(update.getXpath());
				String val = "";
				if (update.getKeys().size() > 0) {
					int i = 0;
					for (Iterator iter = update.getKeys().iterator(); iter.hasNext();) {
						String key = (String) iter.next();
						val += (++i == 1) ? "" : ",";
						val += key;
					}
				}
				keysText.setText(val);
			} else {
				System.out.println("OUT of the group "+event.currentDataType.type);
			}
		}

		public void dropAccept(DropTargetEvent event) {
			//System.out.println("Drop accept "+event.currentDataType.type);
		}

	}

	class UpdateTransfer extends ByteArrayTransfer {

		private final String MYTYPENAME = "InboundAdaptorUpdate";

		private final int MYTYPEID = registerType(MYTYPENAME);

		public UpdateTransfer() {
			System.out.println("Data Type: "+MYTYPEID);
		}

		public void javaToNative(Object object, TransferData transferData) {
			if (object == null || !(object instanceof InboundAdaptorUpdate))
				return;
			
			System.out.println("javaToNative "+transferData.type);
			
			if (isSupportedType(transferData)) {
				InboundAdaptorUpdate update = (InboundAdaptorUpdate) object;
				try {
					// write data to a byte array and then ask super to convert
					// to pMedium
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					ObjectOutputStream writeOut = new ObjectOutputStream(out);
					// only the first one
					writeOut.writeObject(update);
					byte[] buffer = out.toByteArray();
					writeOut.close();

					super.javaToNative(buffer, transferData);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public Object nativeToJava(TransferData transferData) {
			
			System.out.println("nativeToJava "+transferData.type);

			if (isSupportedType(transferData)) {

				byte[] buffer = (byte[]) super.nativeToJava(transferData);
				
				if (buffer == null) return null;

				// only the first one
				try {
					ByteArrayInputStream in = new ByteArrayInputStream(buffer);
					ObjectInputStream readIn = new ObjectInputStream(in);
					InboundAdaptorUpdate update = (InboundAdaptorUpdate) readIn.readObject();
					readIn.close();
					return update;
				} catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
			}

			return null;
		}

		protected String[] getTypeNames() {
			return new String[] { MYTYPENAME };
		}

		protected int[] getTypeIds() {
			return new int[] { MYTYPEID };
		}
	}

	/***************************************************************************
	 * MODEL
	 **************************************************************************/

	class InboundAdaptorUpdate implements Serializable {
		private String xpath;
		private Collection keys;


		/**
		 * @param keys
		 * @param xpath
		 */
		public InboundAdaptorUpdate(String xpath, Collection keys) {
			super();
			setKeys(keys);
			setXpath(xpath);
		}

		public Collection getKeys() {
			return keys;
		}

		public void setKeys(Collection keys) {
			if (keys==null)
				this.keys = new ArrayList();
			else
				this.keys = keys;
		}

		public String getXpath() {
			return xpath;
		}

		public void setXpath(String xpath) {
			this.xpath = xpath;
		}

		public String toString() {
			String val = getXpath();
			if (getKeys().size() > 0) {
				val += " [";
				int i = 0;
				for (Iterator iter = getKeys().iterator(); iter.hasNext();) {
					String key = (String) iter.next();
					val += (++i == 1) ? "" : ",";
					val += key;
				}
				val += "]";
			}
			return val;
		}

	}

}
