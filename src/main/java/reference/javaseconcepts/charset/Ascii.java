package reference.javaseconcepts.charset;

import java.nio.charset.Charset;

public class Ascii {

	public static void main(String[] args) {
		System.out.println("DEC | HEX | CHAR");
		for (int i = 0; i < 128; i++) {
			char ch = (char) i;
			System.out.print(i + "\t");
			System.out.print(Integer.toHexString(i)  + "\t");
			System.out.println(ch);
		}
		
		char ch = 0x38;//code point
		Character c = '8';
		System.out.println(Character.codePointAt(new char[]{'9'}, 0));
		//int i = ch;
		System.out.println(ch);
		System.out.println(Charset.defaultCharset().displayName());
		
		
	}

}
