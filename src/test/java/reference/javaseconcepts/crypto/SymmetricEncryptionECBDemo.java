package reference.javaseconcepts.crypto;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.junit.jupiter.api.Test;

public class SymmetricEncryptionECBDemo {

	@Test
	public void testSymmetricEncryptionECB() throws GeneralSecurityException {
		
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		// specify we want a key length of 192 bits, allowed for AES
		generator.init(192);
		Key key = generator.generateKey();
		bytesToHex("key", key.getEncoded());
		
		byte[] input = "Devoxx!!".repeat(16).getBytes();
		bytesToString("input", input);
		
		// ECB (Electronic CopyBook Encryption)
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedOutput = cipher.doFinal(input);
		bytesToHex("ciphertext", encryptedOutput);
		
		// decryption on the other end
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedOutput = cipher.doFinal(encryptedOutput);
		bytesToString("decoded input", decryptedOutput);
	}
	
	
	private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
	public static void bytesToHex(String name, byte[] bytes) {
	    byte[] hexChars = new byte[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    System.out.println(name + ": " + new String(hexChars, StandardCharsets.UTF_8));
	    int bitLength = hexChars.length * 4;
	    int byteLength = bitLength / 8;
	    System.out.println(name + " length: " + byteLength + " bytes, " + bitLength + " bits.");
	    System.out.println();
	}
	
	public static void bytesToString(String name, byte[] bytes) {
		
		String string = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(name + ": " + string);
        int byteLength = string.length();
        int bitLength = byteLength * 8;
        System.out.println(name + " length: " + byteLength + " bytes, " + bitLength + " bits.");
        System.out.println();
	}
}
