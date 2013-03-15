/*
 * Copyright (C) 2006-2013 Talend Inc. - www.talend.com
 * 
 * This source code is available under agreement available at
 * %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
 * 
 * You should have received a copy of the agreement along with this program; if not, write to Talend SA 9 rue Pages
 * 92150 Suresnes, France
 */
package org.talend.mdm.repository.core.validate.datamodel.validator.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.talend.mdm.commmon.metadata.*;
import org.talend.mdm.repository.core.validate.datamodel.IChecker;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.validator.rule.IComponentValidationRule;
import org.w3c.dom.Element;

public class DataModelChecker implements IChecker<ModelValidationMessage> {

    @Override
    public List<ModelValidationMessage> toCheck(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("File '" + file + "' does not exist.");
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("File '" + file + "' exists but cannot be read.");
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            ValidationHandlerAdapter validationHandler = new ValidationHandlerAdapter(getDataModelName(file.getName()));
            MetadataRepository repository = new MetadataRepository();
            repository.load(inputStream, validationHandler);
            return validationHandler.getMessages();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not open file '" + file + "'.", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Log
            }
        }
    }

    private String getDataModelName(String fileName) {
        Pattern pattern = Pattern.compile("(\\w*?)_(\\d*?)\\.(\\d*?)\\.xsd"); //$NON-NLS-1$
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return fileName;
    }

    private static class ValidationHandlerAdapter implements ValidationHandler {

        public static final String ANONYMOUS_TYPE_NAME = "<Anonymous>";
        private final List<ModelValidationMessage> messages = new LinkedList<ModelValidationMessage>();

        private final String dataModelName;

        private int errorCount;

        public ValidationHandlerAdapter(String dataModelName) {
            this.dataModelName = dataModelName;
        }

        // Compute a string representation from a field to its containing entity type.
        private static String getPath(FieldMetadata field) {
            StringBuilder pathAsAsString = new StringBuilder();
            pathAsAsString.append(getFieldName(field));
            try {
                ComplexTypeMetadata containingType = field.getContainingType();
                while (containingType instanceof ContainedComplexTypeMetadata) {
                    pathAsAsString.insert(0, '/');
                    String name = getTypeName(containingType);
                    pathAsAsString.insert(0, name);
                    containingType = ((ContainedComplexTypeMetadata) containingType).getContainerType();
                }
                pathAsAsString.insert(0, '/');
                pathAsAsString.insert(0, containingType.getName());
            } catch (Exception e) {
                // TODO Temp solution (for building a path from a field that doesn't exist).
                // In case of exception, return an incomplete path
                pathAsAsString.insert(0, "../"); //$NON-NLS-1$
            }
            return pathAsAsString.toString();
        }

        private static String getTypeName(TypeMetadata type) {
            String name = type.getName();
            if (name.startsWith(MetadataRepository.ANONYMOUS_PREFIX)) {
                name = ANONYMOUS_TYPE_NAME;
            }
            return name;
        }

        @Override
        public void fatal(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            error(type, message, lineNumber, columnNumber);
        }

        @Override
        public void error(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            int group = type.isInstantiable() ? IComponentValidationRule.MSG_GROUP_ENTITY : IComponentValidationRule.MSG_GROUP_TYPE;
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_ERROR,
                    message,
                    "key", // TODO
                    dataModelName,
                    lineNumber,
                    columnNumber,
                    group,
                    type.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT),
                    getTypeName(type),
                    getTypeName(type),
                    getTypeName(type));
            messages.add(validationMessage);
            errorCount++;
        }

        @Override
        public void warning(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            int group = type.isInstantiable() ? IComponentValidationRule.MSG_GROUP_ENTITY : IComponentValidationRule.MSG_GROUP_TYPE;
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_WARNING, message,
                    "key", // TODO
                    dataModelName,
                    lineNumber,
                    columnNumber,
                    group,
                    type.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT),
                    getTypeName(type),
                    getTypeName(type),
                    getTypeName(type));
            messages.add(validationMessage);
        }

        @Override
        public void fatal(FieldMetadata field, String message, int lineNumber, int columnNumber) {
            error(field, message, lineNumber, columnNumber);
        }

        @Override
        public void error(FieldMetadata field, String message, int lineNumber, int columnNumber) {
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_ERROR,
                    message,
                    "key", // TODO
                    dataModelName,
                    lineNumber,
                    columnNumber,
                    IComponentValidationRule.MSG_GROUP_ELEMENT,
                    field.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT),
                    getFieldName(field),
                    null,
                    getPath(field));
            messages.add(validationMessage);
            errorCount++;
        }

        private static String getFieldName(FieldMetadata field) {
            try {
                return field.getName();
            } catch (Exception e) {
                // TODO For case where FK is defined from a type that doesn't exist (just "Root" iso. "Root/Id").
                return ""; //$NON-NLS-1$
            }
        }

        @Override
        public void warning(FieldMetadata field, String message, int lineNumber, int columnNumber) {
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_WARNING,
                    message,
                    "key", // TODO
                    dataModelName,
                    lineNumber,
                    columnNumber,
                    IComponentValidationRule.MSG_GROUP_ELEMENT,
                    field.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT),
                    getFieldName(field),
                    null,
                    getPath(field));
            messages.add(validationMessage);
        }

        public List<ModelValidationMessage> getMessages() {
            return messages;
        }

        @Override
        public void end() {
        }

        @Override
        public int getErrorCount() {
            return errorCount;
        }
    }
}