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
package org.talend.mdm.repository.core.validate.datamodel.validator.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDSchema;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.IDataModelChecker;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator;
import org.talend.mdm.repository.core.validate.datamodel.validator.IModelBuilder;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;

/**
 * created by HHB on 2013-1-28 Detailled comment
 * 
 */
public abstract class DataModelChecker implements IDataModelChecker {

    /**
     * DOC HHB DataModelChecker constructor comment.
     */
    public DataModelChecker(IModelBuilder builder) {
        setBuilder(builder);
        initValidators();
    }

    private IModelBuilder builder;

    private List<IDataModelValidator> validators = new LinkedList<IDataModelValidator>();

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#getValidators(java.lang.String
     * )
     */
    @Override
    public List<IDataModelValidator> getValidators() {
        return this.validators;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#addValidator(java.lang.String,
     * org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator)
     */
    @Override
    public void addValidator(IDataModelValidator validator) {
        if (validator == null) {
            throw new IllegalArgumentException();
        }

        validators.add(validator);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#setBuilder(org.talend.mdm.
     * repository.core.validate.datamodel.validator.IModelBuilder)
     */
    @Override
    public void setBuilder(IModelBuilder builder) {
        this.builder = builder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#shouldCheck(org.talend.mdm
     * .repository.core.validate.datamodel.DataModelValidateContext)
     */
    @Override
    public boolean shouldCheck(DataModelValidateContext context) {
        Object schemaObj = context.getSchemaObject();
        if (schemaObj != null && schemaObj instanceof XSDSchema) {
            XSDSchema schema = (XSDSchema) schemaObj;
            schema.validate();

            EList<XSDDiagnostic> diagnostics = schema.getAllDiagnostics();
            // TODO validate only no error is found
        }
        return true;

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

    private IMRoot buildValidateModel(XSDSchema schema, String fileName) {

        IMRoot root = builder.buildModel(schema, fileName);
        return root;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#toCheck(java.lang.String)
     */
    @Override
    public List<ModelValidationMessage> toCheck(String uri) {
        String doc = loadXSDSchema(uri);
        XSDSchema schema = (XSDSchema) builder.parseSchema(doc);

        Object docObj = getDocumentObj(doc);
        File file = getFileFromURI(uri);
        IMRoot mRoot = buildValidateModel(schema, file.getName());
        DataModelValidateContext modelContext = new DataModelValidateContext(schema, mRoot, docObj);
        return toCheck(modelContext);
    }

    protected Object getDocumentObj(String docStr) {
        // for eclipse
        // Document document = new Document(doc);
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#toCheck(java.io.File)
     */
    @Override
    public List<ModelValidationMessage> toCheck(File file) {
        // no implement for studio; side
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#toCheck(java.io.InputStream)
     */
    @Override
    public List<ModelValidationMessage> toCheck(InputStream inputstream) {
        // no implement for studio side
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.impl.IDataModelChecker#toCheck(org.talend.mdm.repository
     * .core.validate.datamodel.DataModelValidateContext)
     */
    @Override
    public List<ModelValidationMessage> toCheck(DataModelValidateContext context) {
        List<ModelValidationMessage> messages = new LinkedList<ModelValidationMessage>();
        if (shouldCheck(context)) {
            for (IDataModelValidator validator : validators) {
                List<ModelValidationMessage> msgs = validator.validate(context);
                if (msgs != null && msgs.size() > 0) {
                    messages.addAll(msgs);
                }
            }
        }
        return messages;
    }
}
