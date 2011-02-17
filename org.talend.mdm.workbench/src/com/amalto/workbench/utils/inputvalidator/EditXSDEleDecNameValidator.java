package com.amalto.workbench.utils.inputvalidator;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;

public class EditXSDEleDecNameValidator implements IInputValidator {

    private XSDSchema schema;

    public EditXSDEleDecNameValidator(XSDSchema schema) {
        this.schema = schema;
    }

    // @Override
    public String isValid(String newText) {
        if (newText == null || "".equals(newText.trim()))
            return "The Entity Name cannot be empty";

        if (Pattern.compile("^\\s+\\w+\\s*").matcher(newText).matches()
                || newText.trim().replaceAll("\\s", "").length() != newText.trim().length())
            return "The name cannot contain the empty characters";

        for (XSDElementDeclaration eachElement : schema.getElementDeclarations()) {
            if (eachElement.getName().equals(newText.trim()))
                return "This Entity already exists";
        }

        return null;
    }
}
