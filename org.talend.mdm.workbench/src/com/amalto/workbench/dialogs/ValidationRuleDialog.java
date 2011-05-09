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
package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ICellEditor;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class ValidationRuleDialog extends Dialog {

    private static Log log = LogFactory.getLog(ValidationRuleDialog.class);

    String title;

    private TisTableViewer viewer;

    DataModelMainPage page;

    String pattern;

    XSDAnnotationsStructure struc;
    
    private ComplexTableViewerColumn[] columns;

    String conceptName;

    String name = "";//$NON-NLS-1$

    private Text text;

    public ValidationRuleDialog(Shell parentShell, String title, String pattern, DataModelMainPage page, String conceptName) {
        super(parentShell);
        this.pattern = pattern;
        this.page = page;
        this.title = title;
        this.conceptName = conceptName;
    }
    
    public ValidationRuleDialog(Shell parentShell, String title, String pattern, DataModelMainPage page, String conceptName,XSDAnnotationsStructure struc) {
        super(parentShell);
        this.pattern = pattern;
        this.page = page;
        this.title = title;
        this.conceptName = conceptName;
        this.struc = struc;
    }
    
    
    

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(this.title);
        Composite composite = (Composite) super.createDialogArea(parent);
        composite.setLayout(new GridLayout(2, false));
        Label label = new Label(composite, SWT.NONE);
        label.setText("Name:");
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
        text = new Text(composite, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
        columns = new ComplexTableViewerColumn[] {
                new ComplexTableViewerColumn("Type", false, "", "", "", ComplexTableViewerColumn.COMBO_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        IConstants.SCHEMATRON_TYPES, 0),
                new ComplexTableViewerColumn("Context XPath", false, "newXPath", "newXPath", "",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        ComplexTableViewerColumn.XPATH_STYLE, new String[] {}, 0),
                new ComplexTableViewerColumn("Expression", false, "", "", "", ComplexTableViewerColumn.VALIDATIONRULE_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        new String[] {}, 0),
                new ComplexTableViewerColumn("Message", false, "", "", "", ComplexTableViewerColumn.MULTIMESSAGE_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        new String[] {}, 0), };
        columns[0].setColumnWidth(70);
        columns[1].setColumnWidth(130);
        columns[2].setColumnWidth(300);
        columns[3].setColumnWidth(300);
        viewer = new TisTableViewer(Arrays.asList(columns), WidgetFactory.getWidgetFactory(), composite);
        viewer.setXpath(true);
        // viewer.setMainPage(page);
        viewer.setConceptName(conceptName);
        viewer.setContext(true);
        viewer.create();
        viewer.getViewer().setInput(parseRules());
        viewer.setHeight(110);
        viewer.setWidth(800);
        viewer.getMainComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 3));
        parent.getShell().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                XpathSelectDialog.setContext(null);
            }
        });
        return composite;
    }

    
    private boolean doCheck() {
        // TODO Auto-generated method stub
        
        if(checkNameIsDuplicated(struc,name)){
            MessageDialog.openWarning(page.getSite().getShell(),"Warning","You can not input a duplicated name"); 
            return false;
        }
        
        if(name == null || name.trim().equals("")){ //$NON-NLS-1$
            MessageDialog.openWarning(page.getSite().getShell(),"Warning","You can not input a blank name"); 
            return false;
        }
        return true;
        
        
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    private List<Line> parseRules() {
        List<Line> lines = new ArrayList<Line>();
        pattern = pattern.replaceAll("\\r\\n|\\n", "");//$NON-NLS-1$//$NON-NLS-2$
        String context = "";//$NON-NLS-1$
        String type = "";//$NON-NLS-1$
        String express = "";//$NON-NLS-1$
        String msg = "";//$NON-NLS-1$
        Element e = null;
        try {
            e = Util.parse(pattern).getDocumentElement();
        } catch (Exception e1) {

            log.error(e1.getMessage(), e1);

        }
        if (e.getAttributes().getNamedItem("name") != null)//$NON-NLS-1$
            name = e.getAttributes().getNamedItem("name").getTextContent();//$NON-NLS-1$
        text.setText("Product Type".equals(name) ? "" : name);//$NON-NLS-1$//$NON-NLS-2$
        NodeList rulelist = e.getElementsByTagName("rule");//$NON-NLS-1$
        for (int i = 0; i < rulelist.getLength(); i++) {
            Node r = rulelist.item(i);
            context = r.getAttributes().getNamedItem("context").getTextContent();//$NON-NLS-1$
            for (int j = 0; j < r.getChildNodes().getLength(); j++) {
                if (r.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
                    type = r.getChildNodes().item(j).getNodeName();
                    express = r.getChildNodes().item(j).getAttributes().getNamedItem("test").getTextContent();//$NON-NLS-1$
                    msg = r.getChildNodes().item(j).getTextContent();
                    break;
                }
            }

            Line l = new Line(columns, new String[] { type, context, express, msg });
            lines.add(l);
        }

        return lines;
    }

    @Override
    protected void okPressed() {
        name = text.getText();
        if( struc != null){
            if ( !doCheck() ){
                return;
            }
        }
        
        XpathSelectDialog.setContext(null);
        deactiveAllCellEditors();
        getValidationRules();
        super.okPressed();
    }

    private void deactiveAllCellEditors() {
        CellEditor[] editors = viewer.getViewer().getCellEditors();
        for (CellEditor editor : editors) {
            if (editor instanceof ICellEditor) {
                ((ICellEditor) editor).deactive();
            }
        }
    }

    @Override
    protected void cancelPressed() {
        super.cancelPressed();
        XpathSelectDialog.setContext(null);
    }

    private String getValidationRules() {
        TableItem[] items = viewer.getViewer().getTable().getItems();
        // List<String> rules=new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        sb = sb.append("<pattern " + "name=\"" + text.getText() + "\" >\n");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

        if (items.length > 0) {
            for (TableItem item : items) {
                Line line = (Line) item.getData();
                sb = sb.append("<rule context=\"");//$NON-NLS-1$

                String type = line.keyValues.get(0).value;
                String context = line.keyValues.get(1).value;
                String express = line.keyValues.get(2).value;
                express = express.replaceAll("<", "&lt;");//$NON-NLS-1$//$NON-NLS-2$
                express = express.replaceAll("\"", "&quot;");//$NON-NLS-1$//$NON-NLS-2$
                express = express.replaceAll("\'", "&apos;");//$NON-NLS-1$//$NON-NLS-2$
                String msg = line.keyValues.get(3).value;
                if (conceptName != null) {
                    if (context.equals(conceptName)) {
                        context = context.replaceAll(conceptName, "/");//$NON-NLS-1$
                    } else {
                        context = context.replaceAll(conceptName + "/", "");//$NON-NLS-1$//$NON-NLS-2$
                    }
                }
                sb = sb.append(context).append("\">");//$NON-NLS-1$
                sb = sb.append("<" + type.toLowerCase() + " test=\"" + express + "\">");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                sb = sb.append("<![CDATA[" + msg + "]]>");//$NON-NLS-1$//$NON-NLS-2$
                sb = sb.append("</" + type.toLowerCase() + ">");//$NON-NLS-1$//$NON-NLS-2$
                sb = sb.append("</rule>\n");//$NON-NLS-1$
            }
            // rules.add(sb.toString());
        }

        sb = sb.append("</pattern>\n");//$NON-NLS-1$

        return pattern = sb.toString();
    }

    public String getPattern() {
        return pattern;
    }

    public String getName() {
        return name;
    }
    
    
    // add by xie
    private  String  getValidationRuleName(String primary){ 
        String splitcontent ="<pattern name=\""; //$NON-NLS-1$
        if(primary.indexOf(splitcontent) != -1 ){
            String part[] = primary.split(splitcontent);
            String nameString []= part[1].split("\""); //$NON-NLS-1$
            return nameString[0];
        }
        return ""; //$NON-NLS-1$ 
    }
    
    private boolean checkNameIsDuplicated(XSDAnnotationsStructure struc, String inputName){
        for (String eachValidationRule : struc.getSchematrons().values()){
            String name = getValidationRuleName(eachValidationRule);
            if( name.equals(inputName) ) {
                // duplicated name
                return true;
            }
        }
        return false;
    } 
}
