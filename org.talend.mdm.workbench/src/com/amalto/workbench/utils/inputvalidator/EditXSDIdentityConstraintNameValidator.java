package com.amalto.workbench.utils.inputvalidator;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;

public class EditXSDIdentityConstraintNameValidator implements IInputValidator {

    private XSDIdentityConstraintDefinition key;

    public EditXSDIdentityConstraintNameValidator(XSDIdentityConstraintDefinition key) {
        this.key = key;
    }

    public XSDSchema getSchema() {
        return key.getSchema();
    }

    public XSDIdentityConstraintDefinition getKey() {
        return key;
    }

    // @Override
    public String isValid(String newText) {

        if ((newText == null) || "".equals(newText))
            return "The Entity Name cannot be empty";

        if (XSDIdentityConstraintCategory.UNIQUE_LITERAL.equals(key.getIdentityConstraintCategory())
                && !newText.equals(((XSDElementDeclaration) key.getContainer()).getName())) {
            return "The unique key name must be equal to the name of it's parent entity";
        }

        for (XSDIdentityConstraintDefinition eachId : getSchema().getIdentityConstraintDefinitions()) {
            if (eachId.getName().equals(newText))
                return "This Key already exists";
        }

        return null;
    }

}
