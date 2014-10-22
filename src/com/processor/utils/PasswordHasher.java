package com.processor.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHasher {

	public String[] hash(String password) {
		String salt = generateSalt();
		String passwordEncrypted = DigestUtils.sha256Hex(password
				+ salt);
		return new String[] { passwordEncrypted, salt };
	}

	private String generateSalt() {
		String salt = null;
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			byte[] bSalt = new byte[8];

			secureRandom.nextBytes(bSalt);

			salt = Base64.encodeBase64String(bSalt);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return salt;
	}

	public boolean isEqual(String password, String salt, String encryptedPassword) {
		//Encrypt provided password
		String encryptedCredentials = DigestUtils.sha256Hex(password + salt);
		
		return encryptedPassword.equals(encryptedCredentials);
	}
		
		public static void main (String[] args) {
			
			PasswordHasher ph = new PasswordHasher();
			String[] array = ph.hash("password");
			
			System.out.println(array[0]);
			
			boolean result = ph.isEqual("password", array[1], array[0]);
			
			System.out.println(result);
		}
	}

