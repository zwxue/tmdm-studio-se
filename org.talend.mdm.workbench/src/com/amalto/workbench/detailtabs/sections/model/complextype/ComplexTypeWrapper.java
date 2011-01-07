package com.amalto.workbench.detailtabs.sections.model.complextype;

import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.ComplexTypeWrapperCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public class ComplexTypeWrapper implements ISubmittable {

    private String newTypeName;

    private XSDComplexTypeDefinition newExtends;

    private XSDCompositor newGroupType;

    private XSDComplexTypeDefinition curXSDComplexType;

    public ComplexTypeWrapper(XSDComplexTypeDefinition curXSDComplexType, String newTypeName,
            XSDComplexTypeDefinition newExtends, XSDCompositor newGroupType) {

        this.curXSDComplexType = curXSDComplexType;
        this.newTypeName = newTypeName;
        this.newExtends = newExtends;
        this.newGroupType = newGroupType;
    }

    public String getNewTypeName() {
        return newTypeName;
    }

    public XSDComplexTypeDefinition getNewExtends() {
        return newExtends;
    }

    public boolean isDefaultExtends() {

        return curXSDComplexType.getSchema()
                .resolveComplexTypeDefinition(curXSDComplexType.getSchema().getSchemaForSchemaNamespace(), "anyType")
                .equals(newExtends);

    }

    public XSDCompositor getNewGroupType() {
        return newGroupType;
    }

    public XSDComplexTypeDefinition getCurComplexType() {
        return curXSDComplexType;
    }

    public CommitHandler<?> createCommitHandler() {
        return new ComplexTypeWrapperCommitHandler(this);
    }

    public boolean changeTypeName() {

        if (curXSDComplexType.getName().equals(newTypeName))
            return false;

        curXSDComplexType.setName(newTypeName);
        curXSDComplexType.updateElement();

        return true;
    }

    public boolean changeExtends() {

        if ((newExtends == null && curXSDComplexType.getBaseType() == null)
                || (newExtends != null && newExtends.equals(curXSDComplexType.getBaseType())))
            return false;

        curXSDComplexType.setDerivationMethod(isDefaultExtends() ? null : XSDDerivationMethod.EXTENSION_LITERAL);
        curXSDComplexType.setBaseTypeDefinition(newExtends);
        curXSDComplexType.updateElement();

        return true;
    }

    public boolean changeGroupType() {

        XSDParticle groupParticle = (XSDParticle) curXSDComplexType.getContent();
        XSDModelGroup group = (XSDModelGroup) groupParticle.getContent();
        if (group.getCompositor().equals(newGroupType))
            return false;

        group.setCompositor(newGroupType);
        group.updateElement();

        return true;
    }
}
