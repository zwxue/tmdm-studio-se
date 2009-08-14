package com.amalto.workbench.image;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.amalto.workbench.image.OverlayImage.EPosition;
import com.amalto.workbench.utils.EXObjectStatus;

public class OverlayImageProvider {
    private static final int BUTTOM_RIGHT = 0;

    private static final int BUTTOM_LEFT = 1;
    
    public static Image getImageWithStatus(Image source, EXObjectStatus status) {
        ImageDescriptor statusOverlay;
        int p = BUTTOM_RIGHT;

        switch (status) {
        case DEACTIVE:
            statusOverlay = ImageCache.getImage(EImage.WAITING_OVR.getPath());
            break;
        default:
            statusOverlay = null;
            break;
        }
        if(statusOverlay==null) return source;

        EPosition position = null;
        if (p == BUTTOM_RIGHT) {
            position = EPosition.BOTTOM_RIGHT;
        } else if (p == BUTTOM_LEFT) {
            position = EPosition.BOTTOM_LEFT;
        }
        OverlayImage overlayImage = new OverlayImage(source, statusOverlay, position);
        return ImageProvider.getImage(overlayImage);
    }

}
