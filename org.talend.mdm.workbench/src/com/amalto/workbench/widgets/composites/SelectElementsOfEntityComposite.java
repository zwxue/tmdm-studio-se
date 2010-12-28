package com.amalto.workbench.widgets.composites;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.models.infoextractor.IElementsOfEntityHolder;

public class SelectElementsOfEntityComposite extends ComboListStringContentComposite {

    private IElementsOfEntityHolder elementsHolder;

    private String colTitle = "Fields";

    public SelectElementsOfEntityComposite(Composite parent, int style, String colTitle, IElementsOfEntityHolder elementsHolder) {
        super(parent, style, new Object[] { colTitle, elementsHolder });
    }

    public IElementsOfEntityHolder getElementsHolder() {
        return elementsHolder;
    }

    public void setElementsHolder(IElementsOfEntityHolder elementsHolder) {
        this.elementsHolder = elementsHolder;
    }

    @Override
    protected String[] getAllInfosInCombo() {

        if (elementsHolder == null)
            return new String[0];

        return elementsHolder.getAllElements();
    }

    @Override
    protected String getInfoColTitle() {
        return colTitle;
    }

    @Override
    protected void createExtentUIArea(Composite parent) {
    }

    @Override
    protected void initParas(Object[] paras) {

        for (Object eachPara : paras) {

            if (eachPara instanceof IElementsOfEntityHolder)
                elementsHolder = (IElementsOfEntityHolder) eachPara;

            if (eachPara instanceof String)
                colTitle = (String) eachPara;
        }

    }

}
