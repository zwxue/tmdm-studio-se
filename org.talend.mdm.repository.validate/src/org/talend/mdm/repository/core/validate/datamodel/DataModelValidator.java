// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

package org.talend.mdm.repository.core.validate.datamodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.ide.IDE;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;
import org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator;
import org.eclipse.wst.xml.core.internal.validation.core.NestedValidatorContext;
import org.eclipse.wst.xml.core.internal.validation.core.ValidationMessage;
import org.eclipse.wst.xml.core.internal.validation.core.ValidationReport;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDParser;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.talend.mdm.repository.core.validate.datamodel.model.IDataModelMarkerConst;
import org.talend.mdm.repository.core.validate.datamodel.model.MRoot;
import org.talend.mdm.repository.core.validate.datamodel.validator.AbstractDataModelValidator;
import org.talend.mdm.repository.core.validate.datamodel.validator.ElementValidator;
import org.xml.sax.helpers.LocatorImpl;

public class DataModelValidator extends AbstractNestedValidator implements IDataModelMarkerConst {

    /**
     * 
     */
    private static final String EDITOR_ID = "org.talend.mdm.repository.ui.editors.XSDEditor2"; //$NON-NLS-1$

    ModelBuilder builder = new ModelBuilder();

    public DataModelValidator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator#validate(java.lang.String,
     * java.io.InputStream, org.eclipse.wst.xml.core.internal.validation.core.NestedValidatorContext)
     */
    @Override
    public ValidationReport validate(String uri, InputStream inputstream, NestedValidatorContext context) {
        //
        String doc = loadXSDSchema(uri);
        XSDSchema schema = parseSchema(doc);
        Document document = new Document(doc);
        schema.validate();

        EList<XSDDiagnostic> diagnostics = schema.getAllDiagnostics();

        File file = getFileFromURI(uri);
        MRoot mRoot = buildValidateModel(schema, file.getName());
        DataModelValidateContext modelContext = new DataModelValidateContext(schema, mRoot, document);

        DataModelValidationReport report = new DataModelValidationReport(uri);
        List<DataModelValidationMessage> validateMessages = validator.validate(modelContext);
        report.addMessage(validateMessages);
        return report;
    }

    AbstractDataModelValidator validator = new ElementValidator();

    private static Map optionMap;

    private XSDSchema parseSchema(String doc) {
        XSDParser parse = new XSDParser(getOptions());
        parse.setDocumentLocator(new LocatorImpl());
        parse.parseString(doc);
        return parse.getSchema();
    }

    private File getFileFromURI(String uri) {
        URI fileURI = URI.createURI(uri);
        File file = new File(fileURI.devicePath());
        return file;
    }

    private String loadXSDSchema(String uri) {
        URI fileURI = URI.createURI(uri);

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.createResource(fileURI);
        FileReader reader = null;
        BufferedReader bufReader = null;
        try {

            if (resource.getContents().isEmpty()) {
                File file = new File(fileURI.devicePath());
                if (file.exists()) {
                    reader = new FileReader(file);
                    bufReader = new BufferedReader(reader);
                    StringBuffer buf = new StringBuffer();
                    String tmp;
                    do {
                        tmp = bufReader.readLine();
                        if (tmp != null) {
                            buf.append(tmp).append("\n");
                        }
                    } while (tmp != null);
                    return buf.toString();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

    private static Map getOptions() {
        if (optionMap == null) {
            optionMap = new HashMap();
            // map.put(XMLResource.OPTION_ENCODING, UTF_8);
            optionMap.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
            optionMap.put(XSDResourceImpl.XSD_TRACK_LOCATION, Boolean.TRUE);
        }
        return optionMap;
    }

    public void validateModel(DataModelValidateContext context) {

    }

    private MRoot buildValidateModel(XSDSchema schema, String fileName) {

        MRoot root = builder.buildModel(schema, fileName);
        return root;
    }

    // //////////// overwrite///////////////////
    private boolean fileIsAccessible(IFile file) {
        if (file != null && file.exists() && file.getProject().isAccessible()) {
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.wst.xml.core.internal.validation.core.AbstractNestedValidator#addInfoToMessage(org.eclipse.wst.xml
     * .core.internal.validation.core.ValidationMessage, org.eclipse.wst.validation.internal.provisional.core.IMessage)
     */
    @Override
    protected void addInfoToMessage(ValidationMessage validationmessage, IMessage message) {
        if (validationmessage instanceof DataModelValidationMessage) {
            DataModelValidationMessage msg = (DataModelValidationMessage) validationmessage;
            message.setAttribute(DATA_MODEL, msg.getDataModelName());
            message.setAttribute(ENTITY, msg.getEntityName());
            message.setAttribute(PATH, msg.getPath());
            message.setAttribute(ELEMENT_TYPE, msg.getElementType());
            message.setAttribute(MSG_GROUP, msg.getMsgGroup());
            message.setAttribute(IDE.EDITOR_ID_ATTR, EDITOR_ID);
        }
    }

}
