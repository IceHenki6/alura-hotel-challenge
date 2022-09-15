package com.federico.alurahotel.tests;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestHashing {
	public static void main(String[] args) {
		System.out.println(hashPassword("aguanteboca"));
	}
	
	public static String hashPassword(String password) {
		String hashedPassword = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			
			byte[] passwordInBytes = messageDigest.digest();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for(byte b:passwordInBytes) {
				stringBuilder.append(String.format("%02X", b));
			}
			
			hashedPassword = stringBuilder.toString();
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return hashedPassword;
	}
}
