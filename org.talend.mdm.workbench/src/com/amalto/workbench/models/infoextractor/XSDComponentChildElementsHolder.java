package com.amalto.workbench.models.infoextractor;

import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.utils.Util;

public class XSDComponentChildElementsHolder implements IElementsOfEntityHolder {

    private XSDComponent xsdComponent;

    public XSDComponentChildElementsHolder(XSDComponent xsdComponent) {
        this.xsdComponent = xsdComponent;
    }

    public String[] getAllElements() {

        if (xsdComponent instanceof XSDElementDeclaration)
            return getElementPathsFrXSDElementDeclaration((XSDElementDeclaration) xsdComponent);

        return new String[0];

    }

    private String[] getElementPathsFrXSDElementDeclaration(XSDElementDeclaration parent) {
        try {
            return Util.getChildElementNames(parent.getName(), parent).toArray(new String[0]);
        } catch (Exception e) {
            return new String[0];
        }
    }

    public boolean hasElements() {
        return getAllElements().length > 0;
    }

    public XSDComponent getXSDComponent() {
        return xsdComponent;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof XSDComponentChildElementsHolder)
            return ((XSDComponentChildElementsHolder) obj).getXSDComponent().equals(getXSDComponent());

        return super.equals(obj);
    }
}
