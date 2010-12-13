package com.amalto.workbench.utils.inputvalidator;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;

public class EditXSDIdentityConstraintNameValidator implements IInputValidator {

    private XSDSchema schema;

    public EditXSDIdentityConstraintNameValidator(XSDSchema schema) {
        this.schema = schema;
    }

    public XSDSchema getSchema() {
        return schema;
    }

//	@Override
    public String isValid(String newText) {

        if ((newText == null) || "".equals(newText))
            return "The Entity Name cannot be empty";

        for (XSDIdentityConstraintDefinition eachId : schema.getIdentityConstraintDefinitions()) {
            if (eachId.getName().equals(newText))
                return "This Key already exists";
        }

        return null;
    }

}
