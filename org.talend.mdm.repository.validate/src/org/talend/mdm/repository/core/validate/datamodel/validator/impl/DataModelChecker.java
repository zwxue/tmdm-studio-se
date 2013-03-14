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

import org.talend.mdm.commmon.metadata.MetadataRepository;
import org.talend.mdm.commmon.metadata.TypeMetadata;
import org.talend.mdm.commmon.metadata.ValidationHandler;
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

        private final List<ModelValidationMessage> messages = new LinkedList<ModelValidationMessage>();

        private final String dataModelName;

        public ValidationHandlerAdapter(String dataModelName) {
            this.dataModelName = dataModelName;
        }

        @Override
        public void error(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_ERROR, message,
                    "key", // TODO
                    dataModelName, lineNumber, columnNumber, IComponentValidationRule.MSG_GROUP_ENTITY,
                    type.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT), type.getName(), type.getName(), type.getName());
            messages.add(validationMessage);
        }

        @Override
        public void fatal(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            error(type, message, lineNumber, columnNumber);
        }

        @Override
        public void warning(TypeMetadata type, String message, int lineNumber, int columnNumber) {
            ModelValidationMessage validationMessage = new ModelValidationMessage(IComponentValidationRule.SEV_WARNING, message,
                    "key", // TODO
                    dataModelName, lineNumber, columnNumber, IComponentValidationRule.MSG_GROUP_ENTITY,
                    type.<Element> getData(MetadataRepository.XSD_DOM_ELEMENT), type.getName(), type.getName(), type.getName());
            messages.add(validationMessage);
        }

        public List<ModelValidationMessage> getMessages() {
            return messages;
        }

        @Override
        public void end() {

        }
    }
}