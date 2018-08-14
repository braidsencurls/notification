package com.psi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

public class CmnUtil {
	
	public static String encryptSha1(String text) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA1");
			md.reset();
			md.update(text.getBytes());
			byte[] result = md.digest();	
			StringBuffer sb = new StringBuffer();
			for (byte b : result) {
	            sb.append(String.format("%02x", b));
	        }
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static long generateTransactionId(int length) {
		String concatNum = "";
		for(int ctr = 1; ctr <= length; ctr++) {
			concatNum = concatNum + ThreadLocalRandom.current().nextInt(1, 10) + "";
		}
		return Long.parseLong(concatNum);
	}

}
