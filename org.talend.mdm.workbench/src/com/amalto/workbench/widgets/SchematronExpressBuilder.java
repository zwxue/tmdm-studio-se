package com.amalto.workbench.widgets;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.XPathFunc;
import com.amalto.workbench.utils.WidgetUtils;
import com.amalto.workbench.views.ServerView;

public class SchematronExpressBuilder {
	Composite parent;
	private SourceViewer sourceViewer;
	String value;
	private StyledText testResult;
	java.util.List<XPathFunc> categories;
	private List categoryList;
	XPathFunc curfc;
	private List funcList;
	private StyledText helpTxt;
	String conceptName;
	String concept;
	public SchematronExpressBuilder(Composite parent,String value,String conceptName){
		this.parent=parent;
		this.value=value;
		this.conceptName=conceptName;
		try {
			parseFunxml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		create();
	}
	private GridLayout getLayout(int num){
		GridLayout layout=new GridLayout(num,false);
		layout.marginHeight=1;
		layout.marginBottom=0;
		layout.marginLeft=0;
		layout.marginRight=0;
		return layout;
	}
	private void insertText(String text){
        Point sel = sourceViewer.getSelectedRange();
        try {
        	sourceViewer.getDocument().replace(sel.x, sel.y, text);
            sourceViewer.setSelectedRange(sel.x + text.length(), sel.y);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }		
	}
	private void parseFunxml() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document document;
		InputStream in=SchematronExpressBuilder.class.getResourceAsStream("XPathFunc.xml");
		document=builder.parse(in);
		NodeList list=document.getElementsByTagName("category");
		categories=new ArrayList<XPathFunc>();
		for(int i=0; i<list.getLength(); i++){
			XPathFunc xpathFunc=new XPathFunc();
			Node node = list.item(i);// get the number i node
			NamedNodeMap map = node.getAttributes();

			Node nameNode = map.getNamedItem("name");
			xpathFunc.setCategory(nameNode.getTextContent()) ;
			
			java.util.List<KeyValue> keylist=new ArrayList<KeyValue>();
			for( int j=0; j<node.getChildNodes().getLength(); j++){
				Node n=node.getChildNodes().item(j);
				NamedNodeMap fmap=n.getAttributes();
				if(fmap!=null && fmap.getLength()>0){
					Node n1=fmap.getNamedItem("name");
					Node n2=fmap.getNamedItem("help");
					String help=n2.getTextContent();
					help=help.replaceAll("\\n", "\n");
					KeyValue kv=new KeyValue(n1.getTextContent(),help);
					keylist.add(kv);
				}
			}
			Collections.sort(keylist, new Comparator<KeyValue>(){

				public int compare(KeyValue o1, KeyValue o2) {
					if(o1!=null && o2!=null){
						return o1.key.compareTo(o2.key);
					}
					return 0;
				}
				
			});
			xpathFunc.setFuncs(keylist);
			categories.add(xpathFunc);
		}
	}
	
	private void create(){
		Composite com=new Composite(parent,SWT.NONE);
		com.setLayout(getLayout(3));
		//expression
		Group expressG=new Group(com,SWT.NONE);
		expressG.setText("Expression");
		expressG.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,3,2));
		expressG.setLayout(getLayout(1));
		//top button group
		Composite topCom=new Composite(expressG,0);
		Button clearBtn=new Button(topCom,SWT.PUSH);
		topCom.setLayout(getLayout(4));
		clearBtn.setText("Clear");
		clearBtn.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,false,1,1));
		clearBtn.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				sourceViewer.setDocument(new Document(""));
			}
		});
		
		org.eclipse.jface.text.Document doc = new org.eclipse.jface.text.Document(value);
		sourceViewer = new SourceViewer(expressG,new VerticalRuler(5),SWT.H_SCROLL | SWT.V_SCROLL|SWT.BORDER);
		GridData gd=new GridData(SWT.FILL,SWT.FILL,true,true,1,6);
		gd.heightHint=150;
        sourceViewer.getControl().setLayoutData(gd);
        WidgetUtils.initRedoUndo(sourceViewer);
		sourceViewer.setDocument(doc);
		
		//bottom button group
		Composite bottomCom=new Composite(expressG,0);
		GridLayout ly=getLayout(4);
		bottomCom.setLayout(ly);
		
		Composite com1=new Composite(bottomCom,0);
		com1.setLayout(getLayout(4));
		String[] strs1={"+","-","*","div"};
		for(String str:strs1){
			final Button btn=new Button(com1,SWT.PUSH);
			btn.setText(str);
			btn.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {

					//getTextWidget().setText(getText() + btn.getText());
					insertText(btn.getText());
				}
			});
		}
		
		Composite com2=new Composite(bottomCom,0);
		com2.setLayout(getLayout(4));
		String[] strs2={"=","!=",">","<"};
		for(String str:strs2){
			final Button btn=new Button(com2,SWT.PUSH);
			btn.setText(str);
			btn.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					//getTextWidget().setText(getText() + btn.getText());
					insertText(btn.getText());
					
				}
			});
		}		
		
		Composite com3=new Composite(bottomCom,0);
		com3.setLayout(getLayout(4));
		String[] strs3={"and","or"};
		for(int i=0; i<strs3.length; i++){
			final Button btn=new Button(com3,SWT.PUSH);

			btn.setText(strs3[i]);
			btn.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					//getTextWidget().setText(getText() + btn.getText());
					insertText(btn.getText());
				}
			});
		}		

		Composite com4=new Composite(bottomCom,0);
		com4.setLayout(getLayout(3));
		String[] strs4={")","("};
		for(int i=0; i<strs4.length; i++){
			final Button btn=new Button(com4,SWT.PUSH);
			btn.setText(strs4[i]);
			btn.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					//getTextWidget().setText(getText() + btn.getText());
					insertText(btn.getText());
				}
			});
		}
		Button xpathButton=new Button(com4, SWT.PUSH);
		xpathButton.setText("xpath");
		xpathButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				XpathSelectDialog dlg = new XpathSelectDialog(
						parent.getShell(),
						null,"Select Xpath ...",
						ServerView.show().getSite(),
						false,
						null
				);
				dlg.setConceptName(conceptName);
//				dlg.setContext(context);
		        dlg.setBlockOnOpen(true);
				dlg.open();
				
				if (dlg.getReturnCode() == Window.OK)  {
					if(getTextWidget().getSelectionText().length()>0)
//						getTextWidget().setText(getText().replace(getTextWidget().getSelectionText(), dlg.getXpath()));
						getTextWidget().replaceTextRange(getTextWidget().getSelectionRanges()[0],getTextWidget().getSelectionRanges()[1],dlg.getXpath());
					else
						//getTextWidget().setText(getText()+dlg.getXpath());
						insertText(dlg.getXpath());
				}
			}
		});
//		//test
//		Group testG=new Group(com,SWT.NONE);
//		testG.setText("Test");
//		GridData gd2=new GridData(SWT.FILL,SWT.FILL,true,true,1,2);
//		gd2.widthHint=190;
//		testG.setLayoutData(gd2);
//		testG.setLayout(getLayout(2));
//		Button btnStartTest=new Button(testG,SWT.PUSH);
//		btnStartTest.setText("Start Test");
//		btnStartTest.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
//		
//		Button btnCleartTest=new Button(testG,SWT.PUSH);
//		btnCleartTest.setText("Clear");
//		btnCleartTest.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
//		
//		testResult=new StyledText(testG,SWT.V_SCROLL|SWT.BORDER);
//		testResult.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,2,3));
//		btnCleartTest.addSelectionListener(new SelectionAdapter(){
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				testResult.setText("");
//			}
//		});
		
		//categories
		Group categoryG=new Group(com,SWT.NONE);
		categoryG.setText("Categories");
		GridData gd1=new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		gd1.heightHint=200;
		gd1.widthHint=140;
		categoryG.setLayoutData(gd1);
		categoryG.setLayout(getLayout(1));
		categoryList=new List(categoryG,SWT.BORDER|SWT.V_SCROLL);
		categoryList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		for(XPathFunc c: categories){
			categoryList.add(c.getCategory());
		}
		categoryList.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void widgetSelected(SelectionEvent e) {		
				funcList.removeAll();
				String c=categoryList.getSelection()[0];
				for(XPathFunc func: categories){
					if(func.getCategory().equals(c)){
						curfc= func;
						for(KeyValue kv:func.getFuncs()){
							funcList.add(kv.key);
						}
						break;
					}
				}
				if(funcList.getItems().length>0){
					funcList.select(0);
					helpTxt.setText(curfc.getFuncs().get(0).value);
				}
			}
			
		});
		//funcations
		Group functionG=new Group(com,SWT.NONE);
		functionG.setText("Functions");
		functionG.setLayout(getLayout(1));
		GridData gd3=new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		gd3.widthHint=220;		
		functionG.setLayoutData(gd3);
		funcList=new List(functionG,SWT.BORDER|SWT.V_SCROLL);
		funcList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		funcList.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				getTextWidget().setText(getText()+funcList.getItem(funcList.getSelectionIndex()));
				
			}

			public void widgetSelected(SelectionEvent e) {				
				String c=funcList.getSelection()[0];
				for(KeyValue kv: curfc.getFuncs()){
					if(kv.key.equals(c)){
						helpTxt.setText(kv.value);
						break;
					}
				}				
			}			
		});		
		//help
		Group helpG=new Group(com,SWT.NONE);
		helpG.setText("Help");
		helpG.setLayout(getLayout(1));
		helpG.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		helpTxt=new StyledText(helpG,SWT.BORDER|SWT.WRAP);
		GridData gd4=new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		gd4.widthHint=210;			
		helpTxt.setLayoutData(gd4);
	}
	public StyledText getTextWidget(){
		return sourceViewer.getTextWidget();
	}
	public String getText(){
		return sourceViewer.getTextWidget().getText();
	}
}	
