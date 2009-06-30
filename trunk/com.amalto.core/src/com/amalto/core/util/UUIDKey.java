package com.amalto.core.util;

/**
 * 
 * @author achen
 * support for custom type UUID/AUTO_INCREMENT
 *	@deprecated
 */
public class UUIDKey {
	//add the following to support UUID aiming
	String keyName;
	String type; //UUID or AUTO_INCREMENT
	boolean isSequence;
	String nextNodeName;
	String uuidValue;
	String elementName;
	


	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSequence() {
		return isSequence;
	}

	public void setSequence(boolean isSequence) {
		this.isSequence = isSequence;
	}

	public String getNextNodeName() {
		return nextNodeName;
	}

	public void setNextNodeName(String nextNodeName) {
		this.nextNodeName = nextNodeName;
	}

	public String getUuidValue() {
		return uuidValue;
	}

	public void setUuidValue(String uuidValue) {
		this.uuidValue = uuidValue;
	}

}
