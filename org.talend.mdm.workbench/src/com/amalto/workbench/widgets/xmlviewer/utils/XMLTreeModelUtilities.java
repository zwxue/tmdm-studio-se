/*****************************************************************************
 * This file is part of Rinzo
 * 
 * Author: Claudio Cancinos WWW: https://sourceforge.net/projects/editorxml Copyright (C): 2008, Claudio Cancinos
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this program; If not, see
 * <http://www.gnu.org/licenses/>
 ****************************************************************************/
package com.amalto.workbench.widgets.xmlviewer.utils;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.TypedPosition;

import com.amalto.workbench.widgets.xmlviewer.model.XMLNode;
import com.amalto.workbench.widgets.xmlviewer.partition.IXMLPartitions;
import com.amalto.workbench.widgets.xmlviewer.partition.XMLDocumentPartitioner;


public class XMLTreeModelUtilities {

    public XMLTreeModelUtilities() {
    }

    public static XMLNode getActiveNode(IDocument document, int offset) {
        XMLDocumentPartitioner xmlPartitioner = getDocumentPartitioner(document);
        if(xmlPartitioner != null) {
            TypedPosition position = xmlPartitioner.findClosestPosition(offset);
            if (position instanceof XMLNode) {
                XMLNode node = (XMLNode) position;
                return node;
            }        
        }
        return null;
    }

    public static XMLNode getActiveXMLNode(IDocument document, int offset) {
        XMLDocumentPartitioner xmlPartitioner = getDocumentPartitioner(document);
        if(xmlPartitioner != null) {
            TypedPosition position = xmlPartitioner.findClosestPosition(offset++);
            while(position != null) {
	            if (position instanceof XMLNode && !position.getType().equals(IXMLPartitions.XML_TEXT)) {
	                XMLNode node = (XMLNode) position;
	                return node;
	            }
	            position = xmlPartitioner.findClosestPosition(offset++);
            }
        }
        return null;
    }

    public static XMLNode getParentNode(IDocument document, int offset) {
        XMLDocumentPartitioner xmlPartitioner = getDocumentPartitioner(document);
        if(xmlPartitioner != null) {
            TypedPosition position = xmlPartitioner.findPreviousNonWhiteSpacePosition(offset);
            if(position instanceof XMLNode) {
                XMLNode node = (XMLNode)position;
                return node;
            }
        }
        return null;
    }

    public static XMLNode getPreviousNode(IDocument document, int offset) {
        XMLDocumentPartitioner xmlPartitioner = getDocumentPartitioner(document);
        if(xmlPartitioner != null) {
            TypedPosition position = xmlPartitioner.findPreviousPosition(offset);
            if(position instanceof XMLNode) {
                XMLNode node = (XMLNode)position;
                return node;
            }
        }
        return null;
    }
    
    private static XMLDocumentPartitioner getDocumentPartitioner(IDocument document) {
        IDocumentPartitioner partitioner = document.getDocumentPartitioner();
        if (partitioner instanceof XMLDocumentPartitioner) {
            return (XMLDocumentPartitioner) partitioner;
        }
        return null;
    }
}
