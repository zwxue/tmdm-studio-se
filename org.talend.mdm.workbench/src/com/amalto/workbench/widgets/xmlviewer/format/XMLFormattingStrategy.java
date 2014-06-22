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
package com.amalto.workbench.widgets.xmlviewer.format;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

import com.amalto.workbench.widgets.xmlviewer.XMLSourceViewer;
import com.amalto.workbench.widgets.xmlviewer.model.XMLNode;



/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class XMLFormattingStrategy implements IFormattingStrategy {

    private final XMLSourceViewer sourceViewer;

    private ToStringVisitor visitor;

    /**
     * DOC hbhong XMLFormattingStrategy constructor comment.
     * 
     * @param sourceViewer
     */
    public XMLFormattingStrategy(ISourceViewer sourceViewer) {
        this.sourceViewer = (XMLSourceViewer) sourceViewer;
        visitor = new ToStringVisitor();
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.formatter.IFormattingStrategy#formatterStarts(java.lang.String)
     */
    public void formatterStarts(String initialIndentation) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.formatter.IFormattingStrategy#format(java.lang.String, boolean, java.lang.String, int[])
     */
    public String format(String content, boolean isLineStart, String indentation, int[] positions) {
        IDocument document = sourceViewer.getDocument();
        sourceViewer.getTreeModel().createTree(document);
        XMLNode rootNode = sourceViewer.getTreeModel().getTree().getRootNode();
        int initialOffset = rootNode.getOffset();
        int length = rootNode.getCorrespondingNode().getOffset() + rootNode.getCorrespondingNode().getLength();

        this.visitor.reset();
        rootNode.accept(visitor);

        sourceViewer.getTreeModel().createTree(document);
        return visitor.getString();
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.text.formatter.IFormattingStrategy#formatterStops()
     */
    public void formatterStops() {
        // TODO Auto-generated method stub

    }

}
