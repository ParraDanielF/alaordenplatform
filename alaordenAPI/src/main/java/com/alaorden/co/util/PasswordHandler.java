package com.alaorden.co.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class PasswordHandler {
	private final char[] hexArray = "0123456789ABCDEF".toCharArray(); 
	
	public String generateHash(String data) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(System.getenv().get("PASS_ALGORITHM"));
		digest.reset();
		byte[] hash = digest.digest(data.getBytes());
		return bytesToStringHex(hash);
	}
	
	private String bytesToStringHex(byte[] hash) {
		char[] hexChars = new char[hash.length * 2];
		for(int j=0 ; j < hash.length ; j++){
			int v = hash[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
