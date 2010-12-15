package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.EntityWrapper;
import com.amalto.workbench.detailtabs.sections.model.FieldWrapper;
import com.amalto.workbench.detailtabs.sections.model.KeyWrapper;

class EntityCommitHandler extends CommitHandler {

    private static final String ERR_ENTITY_NULLENTITYNAME = "Entity name can not be empty";

    private static final String ERR_ENTITY_DULPLICATEENTITYNAME = "Entity name has been existed";

    private static final String ERR_KEY_NULLKEYNAME = "Key name can not be empty";

    private static final String ERR_KEY_DUPLICATEKEYNAME = "Key name has been existed";

    private static final String ERR_KEY_NOFIELDS = "The must be at least one field";

    private static final String ERR_KEY_MULTIUNIQUE = "The must be one unique key at most";

    private static final String ERR_SELECTOR_WRONGFORMAT = "The Key's selector is in wrong format";

    private static final String ERR_FIELD_WRONGFORMAT = "The Key's field is in wrong format";

    public EntityCommitHandler(EntityWrapper entityWrapper) {
        super(entityWrapper);
    }

    protected boolean doSubmit() throws CommitException {

        try {
            return (commitEntityName() | commitEnitityKeys());
        } catch (Exception e) {
            throw new CommitException(e.getMessage(), e);
        }

    }

    protected void validateCommit() throws CommitValidationException {

        validateEntityName();

        validateEntityKeys();
    }

    @Override
    public EntityWrapper getCommitedObj() {
        return (EntityWrapper) super.getCommitedObj();
    }

    private boolean commitEntityName() {

        if (getCommitedObj().getSourceEntity().getName().equals(getCommitedObj().getName())) {
            return false;
        }

        getCommitedObj().getSourceEntity().setName(getCommitedObj().getName());
        getCommitedObj().getSourceEntity().updateElement();

        return true;
    }

    private boolean commitEnitityKeys() {

        return commitKeyRemoval() | commitKeyUpdate() | commitKeyAddition();
    }

    private boolean commitKeyRemoval() {

        boolean hasChanges = false;

        for (XSDIdentityConstraintDefinition eachNeedRemovedKey : getNeedRemovedKeys()) {
            getCommitedObj().getSourceEntity().getIdentityConstraintDefinitions().remove(eachNeedRemovedKey);
            getCommitedObj().getSourceEntity().updateElement();

            hasChanges = true;
        }

        return hasChanges;
    }

    private boolean commitKeyUpdate() {

        boolean hasChanges = false;

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {

            if (eachKeyWrapper.isUserCreated())
                continue;

            hasChanges = hasChanges | commiKeyUpdate_Name(eachKeyWrapper) | commitKeyUpdate_Selector(eachKeyWrapper)
                    | commitKeyUpdate_Fields(eachKeyWrapper);
        }

        return hasChanges;
    }

    private boolean commitKeyAddition() {

        boolean hasChanges = false;

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {

            if (!eachKeyWrapper.isUserCreated())
                continue;

            hasChanges = true;

            XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();

            XSDIdentityConstraintDefinition newKey = factory.createXSDIdentityConstraintDefinition();
            newKey.setName(eachKeyWrapper.getName());

            XSDXPathDefinition selector = factory.createXSDXPathDefinition();
            selector.setValue(eachKeyWrapper.getSelector());
            selector.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
            newKey.setSelector(selector);

            for (FieldWrapper newFields : eachKeyWrapper.getFields()) {
                XSDXPathDefinition field = factory.createXSDXPathDefinition();
                field.setValue(newFields.getXPath());
                field.setVariety(XSDXPathVariety.FIELD_LITERAL);
                newKey.getFields().add(field);
            }

            getCommitedObj().getSourceEntity().getIdentityConstraintDefinitions().add(newKey);
            getCommitedObj().getSourceEntity().updateElement();
        }

        return hasChanges;
    }

    private boolean commitKeyUpdate_Selector(KeyWrapper keyWrapper) {

        if (keyWrapper.getSourceKey().getSelector().getValue().equals(keyWrapper.getSelector()))
            return false;

        XSDXPathDefinition newXpath = XSDSchemaBuildingTools.getXSDFactory().createXSDXPathDefinition();
        newXpath.setValue(keyWrapper.getSelector());
        newXpath.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
        keyWrapper.getSourceKey().setSelector(newXpath);
        keyWrapper.getSourceKey().updateElement();

        return true;
    }

    private boolean commiKeyUpdate_Name(KeyWrapper keyWrapper) {

        if (keyWrapper.getSourceKey().getName().equals(keyWrapper.getName()))
            return false;

        keyWrapper.getSourceKey().setName(keyWrapper.getName());
        keyWrapper.getSourceKey().updateElement();

        return true;
    }

    private boolean commitKeyUpdate_Fields(KeyWrapper keyWrapper) {

        return commitKeyUpdate_Fields_Removal(keyWrapper) | commitKeyUpdate_Fields_Update(keyWrapper)
                | commitKeyUpdate_Fields_Addition(keyWrapper);

    }

    private boolean commitKeyUpdate_Fields_Removal(KeyWrapper keyWrapper) {

        boolean hasChanges = false;

        for (XSDXPathDefinition eachNeedRemovedField : getNeedRemovedFields(keyWrapper)) {
            keyWrapper.getSourceKey().getFields().remove(eachNeedRemovedField);
            keyWrapper.getSourceKey().updateElement();

            hasChanges = true;
        }

        return hasChanges;
    }

    private boolean commitKeyUpdate_Fields_Update(KeyWrapper keyWrapper) {

        boolean hasChanges = false;

        for (FieldWrapper eachField : keyWrapper.getFields()) {

            if (eachField.isUserCreated())
                continue;

            if (eachField.getSourceField().getValue().equals(eachField.getXPath()))
                continue;

            eachField.getSourceField().setValue(eachField.getXPath());
            eachField.getSourceField().updateElement();

            hasChanges = true;
        }

        return hasChanges;
    }

    private boolean commitKeyUpdate_Fields_Addition(KeyWrapper keyWrapper) {

        boolean hasChanges = false;

        for (FieldWrapper eachField : keyWrapper.getFields()) {
            if (!eachField.isUserCreated())
                continue;

            XSDXPathDefinition newXpath = XSDSchemaBuildingTools.getXSDFactory().createXSDXPathDefinition();
            newXpath.setValue(eachField.getXPath());
            newXpath.setVariety(XSDXPathVariety.FIELD_LITERAL);

            keyWrapper.getSourceKey().getFields().add(newXpath);
            keyWrapper.getSourceKey().updateElement();

            hasChanges = true;
        }

        return hasChanges;
    }

    private XSDXPathDefinition[] getNeedRemovedFields(KeyWrapper keyWrapper) {

        List<XSDXPathDefinition> curLeftFields = new ArrayList<XSDXPathDefinition>();
        List<XSDXPathDefinition> needRemovedFields = new ArrayList<XSDXPathDefinition>();

        for (FieldWrapper eachField : keyWrapper.getFields()) {
            if (!eachField.isUserCreated()) {
                curLeftFields.add(eachField.getSourceField());
            }
        }

        for (XSDXPathDefinition eachSourceField : keyWrapper.getSourceKey().getFields()) {
            if (!curLeftFields.contains(eachSourceField)) {
                needRemovedFields.add(eachSourceField);
            }
        }

        return needRemovedFields.toArray(new XSDXPathDefinition[0]);
    }

    private XSDIdentityConstraintDefinition[] getNeedRemovedKeys() {

        List<XSDIdentityConstraintDefinition> curLeftSourceKeys = new ArrayList<XSDIdentityConstraintDefinition>();
        List<XSDIdentityConstraintDefinition> needRemovedKeys = new ArrayList<XSDIdentityConstraintDefinition>();

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {
            if (!eachKeyWrapper.isUserCreated()) {
                curLeftSourceKeys.add(eachKeyWrapper.getSourceKey());
            }
        }

        for (XSDIdentityConstraintDefinition eachSourceKey : getCommitedObj().getSourceEntity()
                .getIdentityConstraintDefinitions()) {
            if (!curLeftSourceKeys.contains(eachSourceKey)) {
                needRemovedKeys.add(eachSourceKey);
            }
        }

        return needRemovedKeys.toArray(new XSDIdentityConstraintDefinition[0]);
    }

    private void validateEntityName() throws CommitValidationException {

        if (getCommitedObj().getName() == null || "".equals(getCommitedObj().getName().trim())) {
            throw new CommitValidationException(ERR_ENTITY_NULLENTITYNAME);
        }

        for (XSDElementDeclaration eachElement : getCommitedObj().getSchema().getElementDeclarations()) {

            if (eachElement.equals(getCommitedObj().getSourceEntity()))
                continue;

            if (eachElement.getName().equals(getCommitedObj().getName())) {
                throw new CommitValidationException(ERR_ENTITY_DULPLICATEENTITYNAME + " : " + getCommitedObj().getName());
            }
        }

    }

    private void validateEntityKeys() throws CommitValidationException {

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {
            validateEachKey(eachKeyWrapper);
        }

        validateKeyUnique();

        validateDuplicateKeyNameInEntityWrapper();
    }

    private void validateKeyUnique() throws CommitValidationException {

        int uniqueKeyCount = 0;

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {
            if (eachKeyWrapper.getType() == XSDIdentityConstraintCategory.UNIQUE_LITERAL) {
                uniqueKeyCount++;
            }
        }

        if (uniqueKeyCount > 1) {
            throw new CommitValidationException(ERR_KEY_MULTIUNIQUE);
        }

    }

    private void validateDuplicateKeyNameInEntityWrapper() throws CommitValidationException {

        Set<String> keyWrapperNames = new HashSet<String>();

        for (KeyWrapper eachKeyWrapper : getCommitedObj().getKeys()) {
            keyWrapperNames.add(eachKeyWrapper.getName());
        }

        if (keyWrapperNames.size() != getCommitedObj().getKeys().length) {
            throw new CommitValidationException(ERR_KEY_DUPLICATEKEYNAME);
        }
    }

    private void validateEachKey(KeyWrapper checkedKeyWrapper) throws CommitValidationException {

        validateEachKeyName(checkedKeyWrapper);

        validateEachKeySelector(checkedKeyWrapper);

        validateEachKeyFieldsCount(checkedKeyWrapper);

        for (FieldWrapper eachFieldWrapper : checkedKeyWrapper.getFields()) {
            validateEachField(checkedKeyWrapper, eachFieldWrapper);
        }
    }

    private void validateEachKeyName(KeyWrapper checkedKeyWrapper) throws CommitValidationException {

        if (checkedKeyWrapper.getName() == null || "".equals(checkedKeyWrapper.getName().trim())) {
            throw new CommitValidationException(ERR_KEY_NULLKEYNAME);
        }

        for (XSDIdentityConstraintDefinition eachId : getCommitedObj().getSchema().getIdentityConstraintDefinitions()) {

            if (eachId.equals(checkedKeyWrapper.getSourceKey()))
                continue;

            if (eachId.getName().equals(checkedKeyWrapper.getName())) {
                throw new CommitValidationException(ERR_KEY_DUPLICATEKEYNAME + " : " + checkedKeyWrapper.getName());
            }
        }
    }

    private void validateEachKeySelector(KeyWrapper checkedKeyWrapper) throws CommitValidationException {

        if (checkedKeyWrapper.getSelector() == null || "".equals(checkedKeyWrapper.getSelector().trim())) {
            throw new CommitValidationException(ERR_SELECTOR_WRONGFORMAT + " : key " + checkedKeyWrapper.getName());
        }

    }

    private void validateEachKeyFieldsCount(KeyWrapper checkedKeyWrapper) throws CommitValidationException {

        if (checkedKeyWrapper.getFields().length == 0) {
            throw new CommitValidationException(ERR_KEY_NOFIELDS + " : key " + checkedKeyWrapper.getName());
        }
    }

    private void validateEachField(KeyWrapper checkedKeyWrapper, FieldWrapper eachFieldWrapper) throws CommitValidationException {

        if (eachFieldWrapper.getXPath() == null || "".equals(eachFieldWrapper.getXPath().trim())) {
            throw new CommitValidationException(ERR_FIELD_WRONGFORMAT + " : key " + checkedKeyWrapper.getName());
        }

    }
}
