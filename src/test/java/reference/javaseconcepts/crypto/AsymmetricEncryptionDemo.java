package reference.javaseconcepts.crypto;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Test;

public class AsymmetricEncryptionDemo {

	@Test
	public void encryptSomeShortTextWithRsa() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair keyPair = kpGen.generateKeyPair();
		bytesToHex("private key", keyPair.getPrivate().getEncoded());
		bytesToHex("public key", keyPair.getPublic().getEncoded());

		byte[] text = "The Lord of the Rings has been read by many people".getBytes();
		bytesToString("plain text", text);
		
		// encrypt
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
		
		byte[] encryptedText = cipher.doFinal(text);
		bytesToHex("cipher text", encryptedText);
		
		// decrypt
		cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
		byte[] plainText = cipher.doFinal(encryptedText);
		bytesToString("decoded text", plainText);
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
