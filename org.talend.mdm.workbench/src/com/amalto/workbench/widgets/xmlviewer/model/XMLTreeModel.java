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
package com.amalto.workbench.widgets.xmlviewer.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitionerExtension2;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.widgets.Display;

import com.amalto.workbench.widgets.xmlviewer.XMLSourceViewer;
import com.amalto.workbench.widgets.xmlviewer.model.commands.CdataTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.DeclarationTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.ElementsToRelate;
import com.amalto.workbench.widgets.xmlviewer.model.commands.EmptyTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.EndTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.IncompleteTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.PiTag;
import com.amalto.workbench.widgets.xmlviewer.model.commands.RelateElementsCommand;
import com.amalto.workbench.widgets.xmlviewer.model.commands.Text;
import com.amalto.workbench.widgets.xmlviewer.model.commands.XMLTag;
import com.amalto.workbench.widgets.xmlviewer.partition.IXMLPartitions;
import com.amalto.workbench.widgets.xmlviewer.resources.DocumentStructureDeclaration;
import com.amalto.workbench.widgets.xmlviewer.utils.XMLViewUtils;

/**
 * 
 */
public class XMLTreeModel implements IDocumentListener {
	private List<IModelListener> modelListeners;
	private XMLRootNode rootNode;
	private Map<String, RelateElementsCommand> commands = new HashMap<String, RelateElementsCommand>();

    private final XMLSourceViewer sourceViewer;

	public XMLTreeModel(XMLSourceViewer sourceViewer) {
        this.sourceViewer = sourceViewer;
        this.modelListeners = new ArrayList<IModelListener>();
        this.rootNode = new XMLRootNode(0, 0, "/", null, sourceViewer); //$NON-NLS-1$


		this.commands.put(IXMLPartitions.XML_TAG, new XMLTag());
		this.commands.put(IXMLPartitions.XML_EMPTYTAG, new EmptyTag());
		this.commands.put(IXMLPartitions.XML_TEXT, new Text());
		this.commands.put(IXMLPartitions.XML_ENDTAG, new EndTag());
		this.commands.put(IXMLPartitions.XML_INCOMPLETETAG, new IncompleteTag());
		this.commands.put(IXMLPartitions.XML_PI, new PiTag());
		this.commands.put(IXMLPartitions.XML_DECLARATION, new DeclarationTag());
		this.commands.put(IXMLPartitions.XML_CDATA, new CdataTag());
		this.commands.put(IXMLPartitions.XML_COMMENT, new Text());
	}

	public void addModelListener(IModelListener listener) {
		if (!this.modelListeners.contains(listener)) {
			this.modelListeners.add(listener);
		}
	}

	public void removeModelListener(IModelListener listener) {
		this.modelListeners.remove(listener);
	}

	protected void fireDocumentAboutToBeChanged(XMLNode node) {
		if (this.modelListeners.size() > 0) {
			for (IModelListener listener : this.modelListeners) {
				listener.modelAboutToBeChanged(node);
			}
		}
	}

	protected void fireDocumentChanged(XMLNode node) {
		if (this.modelListeners.size() > 0) {
			for (IModelListener listener : this.modelListeners) {
				listener.modelChanged(node);
			}
		}
	}

	public void documentAboutToBeChanged(DocumentEvent documentevent) {
	}

	public void documentChanged(DocumentEvent event) {
		IDocument document = event.getDocument();
		this.createTree(document);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
                // sourceViewer.updateFoldingStructure();
			}
		});
	}

	public XMLRootNode getTree() {
		return this.rootNode;
	}

	public void createTree(IDocument document) {
		this.fireDocumentAboutToBeChanged(this.getTree());

		IDocumentPartitioner partitioner = document.getDocumentPartitioner();
		String categories[] = ((IDocumentPartitionerExtension2) partitioner).getManagingPositionCategories();
        this.sourceViewer.getCodeTagContainersRegistry().clear();

		for (int iCat = 0; iCat < categories.length; iCat++) {
			String category = categories[iCat];
			Position positions[] = null;
			try {
				positions = document.getPositions(category);
                this.rootNode = new XMLRootNode(0, 0, IXMLPartitions.XML_TAG, document, sourceViewer);
				ElementsToRelate.currentNode = this.rootNode;
				ElementsToRelate.parentNode = null;
				for (int j = 0; j < positions.length; j++) {
					Position pos = positions[j];
					ElementsToRelate.node = (XMLNode) pos;
					ElementsToRelate.node.getChildren().clear();
					ElementsToRelate.node.setCorrespondingNode(null);
                    ElementsToRelate.node.setSourceViewer(this.sourceViewer);
	
					if (ElementsToRelate.currentNode != null && ElementsToRelate.currentNode.isTag()) {
						String nodeType = ElementsToRelate.node.getType();
						RelateElementsCommand command = this.commands.get(nodeType);
						if (command != null) {
                            command.excecute(this.rootNode, this.sourceViewer.getCodeTagContainersRegistry());
						}
					}
				}
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
		}
		this.fireDocumentChanged(this.getTree());
	}

	public Collection<DocumentStructureDeclaration> getSchemaDefinitions() {
		Collection<DocumentStructureDeclaration> cacheEntries = new ArrayList<DocumentStructureDeclaration>();
		XMLNode root = this.getTree().getRootNode();
		if (root != null) {
			Map<String, XMLAttribute> attributes = root.getAttributes();
			for (Entry<String, XMLAttribute> entry : attributes.entrySet()) {
				if(entry.getKey().endsWith("noNamespaceSchemaLocation")) { //$NON-NLS-1$
					XMLAttribute schemaName = entry.getValue();
					DocumentStructureDeclaration structureDeclaration = new DocumentStructureDeclaration();
					structureDeclaration.setSystemId(schemaName.getValue());
					cacheEntries.add(structureDeclaration);
					structureDeclaration = new DocumentStructureDeclaration();
				}
				if (entry.getKey().endsWith("schemaLocation")) { //$NON-NLS-1$
					XMLAttribute schemaName = entry.getValue();

					StringTokenizer tagNameTokenizer = new StringTokenizer(schemaName.getValue());
					DocumentStructureDeclaration structureDeclaration = new DocumentStructureDeclaration();
					while (tagNameTokenizer.hasMoreTokens()) {
						String token = tagNameTokenizer.nextToken();
						if (token.endsWith("xsd")) { //$NON-NLS-1$
							structureDeclaration.setSystemId(token);
							cacheEntries.add(structureDeclaration);
							structureDeclaration = new DocumentStructureDeclaration();
						} else {
							structureDeclaration.setPublicId(token);
							structureDeclaration.setNamespace(this.getNamespace(token, attributes));
						}
					}
				}
			}
		}
		return cacheEntries;
	}

	private String getNamespace(String token, Map<String, XMLAttribute> attributes) {
		for (Entry<String, XMLAttribute> entry : attributes.entrySet()) {
			XMLAttribute attribute = (XMLAttribute) entry.getValue();
			if (attribute.getValue().equals(token)) {
				String key = (String) entry.getKey();
				return (key.indexOf(":") >= 0) ? key.substring(key.indexOf(":") + 1) : ""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		}
		return ""; //$NON-NLS-1$
	}

	public DocumentStructureDeclaration getDTDDefinition() {
		DocumentStructureDeclaration structureDeclaration = new DocumentStructureDeclaration();
		for (XMLNode node : this.getTree().getChildren()) {
			String content = node.getContent();
			if (content.startsWith("<!DOCTYPE")) { //$NON-NLS-1$
				StringTokenizer tokenizer = new StringTokenizer(content, "\""); //$NON-NLS-1$
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken().trim();
					if (!XMLViewUtils.isEmpty(token) && !token.startsWith("<") && !token.endsWith(">")) { //$NON-NLS-1$ //$NON-NLS-2$
						if (token.endsWith(".dtd") || token.endsWith(".DTD")) { //$NON-NLS-1$ //$NON-NLS-2$
							structureDeclaration.setSystemId(token);
						} else {
							structureDeclaration.setPublicId(token);
						}
					}
				}
				return structureDeclaration;
			}
		}
		return null;
	}

	public String getDTDRootNode() {
		for (XMLNode node : this.getTree().getChildren()) {
			String content = node.getContent();
			if (content.startsWith("<!DOCTYPE")) { //$NON-NLS-1$
				int start = content.indexOf(" "); //$NON-NLS-1$
				content = content.substring(start + 1, content.length());
				int end = content.indexOf(" "); //$NON-NLS-1$
				content = content.substring(0, end);
				return content;
			}
		}
		return null;
	}


}
