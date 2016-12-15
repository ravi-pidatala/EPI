package com.chapter9;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptUtil {

	static String secretKey = "afbdf81cf4e5ae636d1571397be72465f1b3b6842a37fad120360b30a94eb16c"; // 64 hexadecimal chars long. i.e.64 * 4= 256 bits.
	 static char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	  public static String byteToHex(byte[] b) {
	    StringBuilder sb = new StringBuilder(b.length * 2);
	    for (int i = 0; i < b.length; i++) {
	      // get high nibble char
	      sb.append(HEX[(b[i] & 0xf0) >>> 4]);
	      // get low nibble char
	      sb.append(HEX[b[i] & 0x0f]);
	    }
	    return sb.toString();
	  }
	  
	  
	public static void main(String [] args) throws Exception {
		String eS = encrypt("how are you");
		decrypt(eS);
	}
	
	static String encrypt(String s) throws Exception {
		SecretKeySpec secretSpec = new SecretKeySpec(hexToByteArray(secretKey), "AES");
		byte [] contents = s.getBytes("UTF-8");
		byte[] encryptedBytes = encryptDecrypt(contents, secretSpec, Cipher.ENCRYPT_MODE);
		
		String encryptedString = byteToHex(encryptedBytes);
		System.out.println("encrypted string is " + encryptedString);
		return encryptedString;
	}
	
	static String decrypt(String s) throws Exception{
		SecretKeySpec secretSpec = new SecretKeySpec(hexToByteArray(secretKey), "AES");
		
		byte [] contents = hexToByteArray(s);
		byte[] decryptedBytes = encryptDecrypt(contents, secretSpec, Cipher.DECRYPT_MODE);
		
		String decryptedString = new String(decryptedBytes, "UTF-8");
		System.out.println("decrypted string is " + decryptedString);
		return decryptedString;
	}
	
	static byte[] encryptDecrypt(byte [] contents, Key key, int mode) throws Exception {
		Cipher cipher = Cipher.getInstance(key.getAlgorithm());
		cipher.init(mode, key);
		return cipher.doFinal(contents);
	}
	
	/*
	 * Hexadecimal string length is always even.
	 * because each character splits into two hexadeimal characters. 
	 */
	  public static byte[] hexToByteArray(String s) {
		    int len = s.length();
		    byte[] data = new byte[len / 2] ;
		    for (int i = 0; i < len; i += 2) {
		      data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		    }
		    return data;
	  }
}
