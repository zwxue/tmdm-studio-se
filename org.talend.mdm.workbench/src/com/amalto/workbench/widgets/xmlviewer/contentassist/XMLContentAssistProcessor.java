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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.amalto.workbench.widgets.xmlviewer.model.XMLNode;
import com.amalto.workbench.widgets.xmlviewer.model.tags.AttributeDefinition;
import com.amalto.workbench.widgets.xmlviewer.model.tags.TagTypeDefinition;
import com.amalto.workbench.widgets.xmlviewer.utils.XMLTreeModelUtilities;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XMLContentAssistProcessor implements IContentAssistProcessor {

    private ITextViewer viewer;

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
        this.viewer = viewer;
        ICompletionProposal result[] = null;
        Collection<ICompletionProposal> resultList = new ArrayList<ICompletionProposal>();
        XMLNode currentNode = XMLTreeModelUtilities.getActiveNode(this.viewer.getDocument(), documentOffset);
        if (currentNode.offset == documentOffset) {
            currentNode = XMLTreeModelUtilities.getPreviousNode(this.viewer.getDocument(), documentOffset);
        }

        if (currentNode == null) {
            return new ICompletionProposal[0];
        }

        this.computeCompletionProposal(resultList, documentOffset, currentNode);
        // resultList.addAll(getDataModelProposals(documentOffset));
        result = (ICompletionProposal[]) resultList.toArray(new ICompletionProposal[resultList.size()]);

        Arrays.sort(result, XMLCompletionProposalComparator.getInstance());

        return result;
    }

    private String[] ENTITY_NAMES = new String[] { "A1", "Bb2", "C333", "D4444" };

    // TODO
    private List<ICompletionProposal> getDataModelProposals(int offset) {
        List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

        for (int i = 0; i < ENTITY_NAMES.length; i++) {
            String entityName = ENTITY_NAMES[i];
            String replacementString = "<" + entityName + "></" + entityName + ">"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            CompletionProposal proposal = new CompletionProposal(replacementString, offset - 1, 1, entityName.length() + 2);
            proposals.add(proposal);

        }
        return proposals;
    }

    protected void computeCompletionProposal(Collection<ICompletionProposal> resultList, int offset, XMLNode currentNode) {
        String prefix = this.getPrefix(currentNode, offset);
        if (prefix == null)
            return;
        if (this.shouldProposeInBody(currentNode, prefix, offset)) {
            this.addBodyProposals(currentNode, prefix, this.viewer, offset, resultList);
        }
        if (this.shouldProposeCloseTag(currentNode, prefix, offset)) {
            this.addCloseTagProposals(currentNode, prefix, this.viewer, offset, resultList);
        }
        if (this.shouldProposeAttributeNames(currentNode, prefix, offset)) {
            this.addAttributeProposals(currentNode, prefix, this.viewer, offset, resultList);
        }
        if (this.shouldProposeAttributeValues(currentNode, prefix, offset)) {
            this.addAttributeValuesProposals(currentNode, prefix.substring(0, prefix.indexOf("=")).trim(), prefix, this.viewer, //$NON-NLS-1$
                    offset, resultList);
        }
    }

    private String getPrefix(XMLNode currentNode, int offset) {
        int currentPosition = offset - currentNode.getOffset();
        String content = currentNode.getContent();
        if (currentPosition <= content.length()) {
            int lastSpacePosition = content.substring(0, currentPosition).lastIndexOf(" "); //$NON-NLS-1$
            if (!content.isEmpty() && lastSpacePosition >= 0) {
                return content.substring(lastSpacePosition + 1, currentPosition).trim();
            } else {
                return content.trim();
            }
        }
        return null;
    }

    private boolean shouldProposeAttributeValues(XMLNode currentNode, String prefix, int offset) {
        return !currentNode.isTextTag() && isInAttributeValue(prefix);
    }

    private boolean isInAttributeValue(String attributePrefix) {
        int firsIndex = attributePrefix.indexOf("\""); //$NON-NLS-1$
        int secondindex = 0;
        if (firsIndex != -1) {
            secondindex = attributePrefix.indexOf("\"", firsIndex + 1); //$NON-NLS-1$
        }
        return firsIndex != -1 && secondindex == -1;
    }

    private boolean shouldProposeAttributeNames(XMLNode currentNode, String prefix, int offset) {
        return !currentNode.isTextTag() && !currentNode.isEndTag() && !isInAttributeValue(prefix) && !prefix.startsWith("<") //$NON-NLS-1$
                && !prefix.trim().endsWith("="); //$NON-NLS-1$
    }

    private boolean shouldProposeCloseTag(XMLNode currentNode, String prefix, int offset) {
        return (currentNode.isIncompleteTag() && !currentNode.getTagName().isEmpty() && (prefix.isEmpty() || prefix
                .startsWith("<"))) || (currentNode.isTextTag() && currentNode.getParent().getCorrespondingNode() == null); //$NON-NLS-1$
    }

    private boolean shouldProposeInBody(XMLNode currentNode, String prefix, int offset) {
        return currentNode.isTextTag() || currentNode.getContent().trim().equals(prefix)
                || (currentNode.getParent() == null && currentNode.isEndTag());
    }

    public void addAttributeProposals(XMLNode currentNode, String prefix, ITextViewer viewer, int offset,
            Collection<ICompletionProposal> resultList) {
        Collection<String> nodeAttributes = currentNode.getAttributes().keySet();
        TagTypeDefinition typeDefinition = currentNode.getTypeDefinition();
        for (AttributeDefinition attrDef : typeDefinition.getAttributes()) {
            if (attrDef.getName().startsWith(prefix) && !nodeAttributes.contains(attrDef.getName())) {
                resultList.add(ProposalsFactory.createAttributeProposal(attrDef, offset, prefix.length()));
            }
        }
    }

    public void addAttributeValuesProposals(XMLNode currentNode, String attributeName, String prefix, ITextViewer viewer,
            int offset, Collection<ICompletionProposal> resultList) {
        AttributeDefinition attributeDefinition = currentNode.getTypeDefinition().getAttribute(prefix);
        Collection<String> acceptableValues = null;

        if (attributeDefinition != null) {
            acceptableValues = attributeDefinition.getAcceptableValues();
            if (!acceptableValues.isEmpty()) {
                for (String currentValue : acceptableValues) {
                    resultList.add(ProposalsFactory.createAttributeValueProposal(currentValue, offset));
                }
            }
        }
    }

    public void addCloseTagProposals(XMLNode currentNode, String prefix, ITextViewer viewer, int offset,
            Collection<ICompletionProposal> resultList) {
        if (currentNode.isTextTag()) {
            resultList.add(ProposalsFactory.createEndTagProposal(currentNode.getParent().getTypeDefinition(), offset,
                    (currentNode.isIncompleteTag() ? currentNode.getContent().trim().length() : 0)));
        }
        if (currentNode.isIncompleteTag()) {
            resultList.add(ProposalsFactory.createIncompleteEndTagProposal(currentNode.getTypeDefinition(), offset,
                    (currentNode.isIncompleteTag() ? currentNode.getContent().trim().length() : 0)));
            resultList.add(ProposalsFactory.createIncompleteClosingEndTagProposal(currentNode.getTypeDefinition(), offset,
                    (currentNode.isIncompleteTag() ? currentNode.getContent().trim().length() : 0)));
        }
    }

    public void addBodyProposals(XMLNode currentNode, String prefix, ITextViewer viewer, int offset,
            Collection<ICompletionProposal> resultList) {
        Collection<TagTypeDefinition> reference;
        String tagPrefix = ""; //$NON-NLS-1$
        if (currentNode.getParent() == null) {
            reference = currentNode.getCorrespondingNode().getTypeDefinition().getInnerTags();
        } else {
            if (currentNode.getOffset() + currentNode.getLength() == offset) {
                reference = currentNode.getTypeDefinition().getInnerTags();
            } else {
                reference = currentNode.getParent().getTypeDefinition().getInnerTags();
                tagPrefix = currentNode.getTagName();
            }
        }

        for (TagTypeDefinition element : reference) {
            if (element.getName().startsWith(tagPrefix)) {
                resultList.add(ProposalsFactory.createTagProposal(element, offset,
                        tagPrefix.length() + (currentNode.isIncompleteTag() ? 1 : 0)));
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text
     * .ITextViewer, int)
     */
    public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
     */
    public char[] getCompletionProposalAutoActivationCharacters() {
        return new char[] { '<' };
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
     */

    public char[] getContextInformationAutoActivationCharacters() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
     */
    public String getErrorMessage() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
     */
    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

}
