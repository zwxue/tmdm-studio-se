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
package com.amalto.workbench.widgets.xmlviewer.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.amalto.workbench.widgets.xmlviewer.model.tags.AttributeDefinition;
import com.amalto.workbench.widgets.xmlviewer.model.tags.TagTypeDefinition;
import com.amalto.workbench.widgets.xmlviewer.utils.XMLViewUtils;

/**
 * Factory of completion proposals for content assist
 * 
 */
public class ProposalsFactory {
	private static final int COMMENT_RELEVANCE = 1;
	private static final int TAG_RELEVANCE = 110;
	private static final int ATTR_RELEVANCE = 110;
    private static final int ATTR_VALUE_RELEVANCE = 100;
	private static final int END_TAG_RELEVANCE = 100;
	
    private static final String COMMENT_INFO = "&lt;!-- --&gt;"; //$NON-NLS-1$
    private static XMLCompletionProposal commentProposal = null;

    private static final String TERMINATE_TAG_INFO = "Terminate the parent element."; //$NON-NLS-1$

    /**
     * Returns a proposal for creating a comment
     */
    public static XMLCompletionProposal createCommentProposal(int offset, int replacementLength) {
        if (commentProposal == null) {
            String replacement = "<!--  -->"; //$NON-NLS-1$
            
            commentProposal = new XMLCompletionProposal(replacement, offset - replacementLength, replacementLength, 5, null,
                    "Comment " + replacement, null, COMMENT_INFO); //$NON-NLS-1$
            commentProposal.setRelevance(COMMENT_RELEVANCE);
        }
        commentProposal.setReplacementOffset(offset - replacementLength);
        commentProposal.setReplacementLength(replacementLength);
        return commentProposal;
    }

    /**
     * Creates a proposal for adding an end tag
     * @param replacementLength 
     */
	public static XMLCompletionProposal createEndTagProposal(TagTypeDefinition tagTypeDefinition, int offset,
			int replacementLength) {
        String tagName = tagTypeDefinition.getName();
        String namespace = tagTypeDefinition.getNamespace();
        tagName = (XMLViewUtils.isEmpty(namespace)) ? tagName : namespace + ":" + tagName; //$NON-NLS-1$
        String replacement = "</" + tagName + ">"; //$NON-NLS-1$ //$NON-NLS-2$
        
        XMLCompletionProposal proposal = new XMLCompletionProposal(
        		replacement, 
        		offset - replacementLength, 
        		replacementLength, 
                replacement.length(), null,
 "End with " + replacement, //$NON-NLS-1$
                null, 
                TERMINATE_TAG_INFO);
        proposal.setRelevance(END_TAG_RELEVANCE);
        return proposal;
    }
    
	public static XMLCompletionProposal createIncompleteEndTagProposal(TagTypeDefinition tagTypeDefinition, int offset,
			int replacementLength) {
        String replacement = "/>"; //$NON-NLS-1$
        
        XMLCompletionProposal proposal = new XMLCompletionProposal(
        		replacement, 
        		offset, 
        		0, 
 replacement.length(), null,
                "End with " + replacement, //$NON-NLS-1$
                null, 
                TERMINATE_TAG_INFO);
        proposal.setRelevance(END_TAG_RELEVANCE);
        return proposal;
    }

	public static XMLCompletionProposal createIncompleteClosingEndTagProposal(TagTypeDefinition tagTypeDefinition,
			int offset, int replacementLength) {
        String tagName = tagTypeDefinition.getName();
        String namespace = tagTypeDefinition.getNamespace();
        tagName = (XMLViewUtils.isEmpty(namespace)) ? tagName : namespace + ":" + tagName; //$NON-NLS-1$
        String replacement = "></" + tagName + ">"; //$NON-NLS-1$ //$NON-NLS-2$
        
        XMLCompletionProposal proposal = new XMLCompletionProposal(
        		replacement, 
        		offset, 
        		0, 
        		1,
 null,
                "End with " + replacement.substring(1), //$NON-NLS-1$
                null, 
                TERMINATE_TAG_INFO);
        proposal.setRelevance(END_TAG_RELEVANCE);
        return proposal;
    }

    /**
     * Creates a proposal for adding an entire tag
     */
	public static XMLCompletionProposal createTagProposal(TagTypeDefinition tagTypeDefinition, int offset,
			int replacementLength) {
        String tagName = tagTypeDefinition.getName();
        String namespace = tagTypeDefinition.getNamespace();
        tagName = (XMLViewUtils.isEmpty(namespace)) ? tagName : namespace + ":" + tagName; //$NON-NLS-1$
        String replacement = "<" + tagName + "></" + tagName + ">"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        
        XMLCompletionProposal proposal = new XMLCompletionProposal(
        		replacement, 
        		offset - replacementLength,
                replacementLength, 
                tagName.length() + 2, 
 null,
                tagName, 
                null, 
                tagTypeDefinition.getComment());
        proposal.setRelevance(TAG_RELEVANCE);
        return proposal;
    }

    /**
     * Creates a proposal for adding an attribute into a tag
     */
	public static ICompletionProposal createAttributeProposal(AttributeDefinition attributeDefinition, int offset,
			int replacementLength) {
    	String attributeName = attributeDefinition.getName();
        String replacement = attributeName + "=\"" + attributeDefinition.getDefaultValue() + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        
        XMLCompletionProposal proposal = new XMLCompletionProposal(replacement, offset - replacementLength,
 replacementLength,
                replacement.length() - 1, null,
                attributeName, null, attributeDefinition.getComment());
        proposal.setRelevance(ATTR_RELEVANCE);
        return proposal;
    }
    
    public static ICompletionProposal createAttributeValueProposal(String replacement, int offset) {
	    XMLCompletionProposal proposal = new XMLCompletionProposal(replacement, offset, 0, replacement.length(),
 null,
                replacement, null, "Set value: <b>" + replacement + "</b>"); //$NON-NLS-1$ //$NON-NLS-2$
	    proposal.setRelevance(ATTR_VALUE_RELEVANCE);
	    return proposal;
	}

}
