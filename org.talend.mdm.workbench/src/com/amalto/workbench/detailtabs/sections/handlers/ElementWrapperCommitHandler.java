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
package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.w3c.dom.Element;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.element.ElementWrapper;
import com.amalto.workbench.utils.Util;

public class ElementWrapperCommitHandler extends CommitHandler<ElementWrapper> {

    public ElementWrapperCommitHandler(ElementWrapper submittedObj) {
        super(submittedObj);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        validateElementNameAndReference();

        validateCardinality();

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        try {
            XSDElementDeclaration decl = getCommitedObj().getSourceXSDContent();

            XSDElementDeclaration ref = null;
            if (decl.isElementDeclarationReference()) {
                ref = decl.getResolvedElementDeclaration();
            }

            XSDElementDeclaration newRef = Util.findReference(getCommitedObj().getNewReference(), getCommitedObj().getSchema());

            XSDIdentityConstraintDefinition identify = null;
            XSDXPathDefinition keyPath = null;
            List<Object> keyInfo = Util.getKeyInfo(getCommitedObj().getSourceXSDContent());
            if (keyInfo != null && keyInfo.size() > 0) {
                identify = (XSDIdentityConstraintDefinition) keyInfo.get(0);
                keyPath = (XSDXPathDefinition) keyInfo.get(1);
                identify.getFields().remove(keyPath);
            }

            getCommitedObj().getSourceXSDContent().setName(
                    "".equals(getCommitedObj().getNewName()) ? null : getCommitedObj().getNewName());
            if (keyPath != null) {
                XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
                XSDXPathDefinition field = factory.createXSDXPathDefinition();
                field.setVariety(keyPath.getVariety());
                field.setValue(getCommitedObj().getNewName());
                identify.getFields().add(field);
            }

            if (newRef != null) {
                decl.setResolvedElementDeclaration(newRef);
                decl.setTypeDefinition(null);
                Element elem = decl.getElement();
                if (elem.getAttributes().getNamedItem("type") != null)
                    elem.getAttributes().removeNamedItem("type");
                decl.updateElement();
            } else if (ref != null) {

                getCommitedObj().getSourceXSDContent().setName(getCommitedObj().getNewName());
                getCommitedObj().getSourceXSDContent().setTypeDefinition(
                        getCommitedObj().getSchema().getSchemaForSchema()
                                .resolveSimpleTypeDefinition(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001, "string"));

                // XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
                // XSDElementDeclaration newD = (XSDElementDeclaration) factory.createXSDElementDeclaration();
                // newD.setName(getCommitedObj().getNewName());
                // newD.updateElement();
                // XSDSimpleTypeDefinition stringType = getCommitedObj().getSchema().getSchemaForSchema()
                // .resolveSimpleTypeDefinition(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001, "string");
                //
                // newD.setTypeDefinition(stringType);
                // if (getCommitedObj().getSourceElement().getContainer() instanceof XSDModelGroup) {
                // XSDModelGroup group = ((XSDModelGroup) getCommitedObj().getSourceElement().getContainer());
                // ((XSDModelGroup) getCommitedObj().getSourceElement().getContainer()).getContents().remove(
                // getCommitedObj().getSourceElement());
                // getCommitedObj().setSourceElement(factory.createXSDParticle());
                // getCommitedObj().getSourceElement().setContent(newD);
                // group.getContents().add(getCommitedObj().getSourceElement());
                // }
            }

            if (Util.changeElementTypeToSequence(decl, getCommitedObj().getNewMaxOcur()) == Status.CANCEL_STATUS) {
                return false;
            }

            getCommitedObj().getSourceElement().setMinOccurs(getCommitedObj().getNewMinOcur());
            if (getCommitedObj().getNewMaxOcur() > -1) {
                getCommitedObj().getSourceElement().setMaxOccurs(getCommitedObj().getNewMaxOcur());
            } else {
                getCommitedObj().getSourceElement().getElement().setAttribute("maxOccurs", "unbounded");
            }

            getCommitedObj().getSourceElement().updateElement();
        } catch (Exception e) {
            throw new CommitException(e.getMessage(), e);
        }

        return true;
    }

    private void validateCardinality() throws CommitValidationException {
        if (getCommitedObj().getNewMinOcur() < 0)
            throw new CommitValidationException("The Minimum Occurence must be greater or equal to Zero");

        if (getCommitedObj().getNewMaxOcur() > 0 && getCommitedObj().getNewMaxOcur() < getCommitedObj().getNewMinOcur())
            throw new CommitValidationException("The maximum Occurence should be greater or equal to the Minimum Occurence");
    }

    private void validateElementNameAndReference() throws CommitValidationException {

        if (((getCommitedObj().getNewName() == null) || ("".equals(getCommitedObj().getNewName())))
                && ((getCommitedObj().getNewReference() == null) || "".equals(getCommitedObj().getNewReference())))
            throw new CommitValidationException("The Business Element Name cannot be empty if the reference is empty");

        if (getCommitedObj().getNewName().replaceAll("\\s", "").length() != getCommitedObj().getNewName().length())
            throw new CommitValidationException("The Business Element Name cannot contain the empty characters");

        if (getCommitedObj().hasNewReference()
                && (Util.findReference(getCommitedObj().getNewReference(), getCommitedObj().getSchema()) == null))
            throw new CommitValidationException("The Referenced Element " + getCommitedObj().getNewReference()
                    + " cannot be found");

    }
}
