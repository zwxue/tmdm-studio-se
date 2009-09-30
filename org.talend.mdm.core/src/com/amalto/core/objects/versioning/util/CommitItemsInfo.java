package com.amalto.core.objects.versioning.util;

import java.io.Serializable;

import com.amalto.core.ejb.ItemPOJOPK;
import com.amalto.core.objects.versioning.ejb.VersioningSystemPOJOPK;

/**
 * Used to commit items in Background Jobs
 * @author starkey
 *
 */
public class CommitItemsInfo implements Serializable {
	private VersioningServiceCtrlLocalBI service;
	private VersioningSystemPOJOPK versioningSystemPOJOPK;
	private String comment;
	private String username;
	private ItemPOJOPK[] itemPKs;
	
	public CommitItemsInfo() {
		super();
	}

	public CommitItemsInfo(VersioningServiceCtrlLocalBI service,VersioningSystemPOJOPK versioningSystemPOJOPK, String comment, String username, ItemPOJOPK[] itemPKs) {
		super();
		this.service=service;
		this.versioningSystemPOJOPK = versioningSystemPOJOPK;
		this.comment = comment;
		this.username = username;
		this.itemPKs = itemPKs;
	}


	public VersioningServiceCtrlLocalBI getService() {
		return service;
	}


	public void setService(VersioningServiceCtrlLocalBI service) {
		this.service = service;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public VersioningSystemPOJOPK getVersioningSystemPOJOPK() {
		return versioningSystemPOJOPK;
	}

	public void setVersioningSystemPOJOPK(
			VersioningSystemPOJOPK versioningSystemPOJOPK) {
		this.versioningSystemPOJOPK = versioningSystemPOJOPK;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ItemPOJOPK[] getItemPKs() {
		return itemPKs;
	}

	public void setItemPKs(ItemPOJOPK[] itemPKs) {
		this.itemPKs = itemPKs;
	}
	
	
	
}