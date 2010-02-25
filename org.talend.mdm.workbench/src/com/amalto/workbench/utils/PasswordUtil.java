package com.amalto.workbench.utils;

import org.apache.commons.codec.binary.Base64;
public class PasswordUtil {

public static String decryptPassword(String encodedPassword){
    Base64 base64 = new Base64();
    byte[] debytes = null;
    String decodeStr = null;
	debytes = base64.decode(encodedPassword.getBytes());
	decodeStr = new String(debytes);
	return decodeStr;
	
}
public static String encryptPassword(String plainPassword){
    Base64 base64 = new Base64();
    byte[] enbytes = null;
    String encodeStr = null;
    enbytes = base64.encode(plainPassword.getBytes());
	encodeStr = new String(enbytes);
	return encodeStr;
}
	    public static void main(String args[]) {
	        Base64 base64 = new Base64();
	        String str = "qwe";
	        byte[] enbytes = null;
	        String encodeStr = null;
	        byte[] debytes = null;
	        String decodeStr = null;
	        enbytes = base64.encode(str.getBytes());
			encodeStr = new String(enbytes);
			debytes = base64.decode(enbytes);
			decodeStr = new String(debytes);
	        System.out.println("plain password:"+str);
	        System.out.println("encrypted password:"+encodeStr);
	        System.out.println("decrypted password:"+decodeStr);
	    }
}
