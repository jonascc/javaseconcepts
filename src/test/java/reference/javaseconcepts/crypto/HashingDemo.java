package reference.javaseconcepts.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

public class HashingDemo {
	
	@Test
	public void hashingDemo() throws NoSuchAlgorithmException {
		
		// get message digest
		System.out.println("one way only!");
		hashText("The quick brown fox jumped over the lazy dog.");
		
		// hash it again, deterministic
		System.out.println("deterministic");
		hashText("The quick brown fox jumped over the lazy dog.");
		
		// pseudo random, new digest looks nothing like the old digest
		System.out.println("pseudo random");
		hashText("The quick brown fox jumped ower the lazy dog.");
		
		// hash is always fixed length
		System.out.println("fixed length");
		hashText("The quick brown fox jumped ower the lazy dog and a lot more stuff happened after.");
		
	}
	
	private void hashText(String data) throws NoSuchAlgorithmException {
		System.out.println("Input: " + data);
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] digest = messageDigest.digest(data.getBytes());
		bytesToHex("Digest", digest);
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
	    System.out.println(name + " length: " + byteLength + " bytes, " + bitLength + " bits");
	    System.out.println();
	}

}
