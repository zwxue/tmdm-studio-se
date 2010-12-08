package com.amalto.workbench.editors.xsdeditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.part.FileEditorInput;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class XSDEditorInput extends FileEditorInput {

    IFile file;

    public XSDEditorInput(IFile file) {
        super(file);
        this.file = file;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (!(obj instanceof XSDEditorInput))
            return false;
        XSDEditorInput input = (XSDEditorInput) obj;
        boolean ret = input.file.getFullPath().toOSString().equals(file.getFullPath().toOSString());
        return ret;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageCache.getImage(EImage.DATA_MODEL.getPath());
    }
}
