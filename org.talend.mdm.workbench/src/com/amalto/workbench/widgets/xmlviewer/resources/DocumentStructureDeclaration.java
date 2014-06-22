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
package com.amalto.workbench.widgets.xmlviewer.resources;

/**
 * Defines the location for the language definition of an xml.
 */
public class DocumentStructureDeclaration {
	/**This two names corresponds to the ones defined on the xml*/
    private String publicId;
    private String systemId;
    private String namespace;
    /**This name corresponds to the cached file for this public and absolute names*/
    private String localCachedName;

    public DocumentStructureDeclaration() { }
    
    public DocumentStructureDeclaration(String publicName, String absoluteName, String localCachedName) {
        this.publicId = publicName;
        this.systemId = absoluteName;
        this.localCachedName = localCachedName;
    }

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getLocalCachedName() {
		return localCachedName;
	}

	public void setLocalCachedName(String localCachedName) {
		this.localCachedName = localCachedName;
	}
}