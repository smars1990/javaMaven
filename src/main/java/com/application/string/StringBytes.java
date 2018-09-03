package com.application.string;

import java.io.UnsupportedEncodingException;

public class StringBytes {

	
	public static void main(String[] args) throws Exception {
		String str = "";
		
		String encode = "GB2312";
		if (str.equals(new String(str.getBytes(encode), encode))) {
			String s = encode;
			System.out.println(s);
		}

		encode = "ISO-8859-1";
		if (str.equals(new String(str.getBytes(encode), encode))) {
			String s1 = encode;
			System.out.println(s1);
		}

		encode = "UTF-8";
		if (str.equals(new String(str.getBytes(encode), encode))) {
			String s2 = encode;
			System.out.println(s2);
		}

		encode = "GBK";
		if (str.equals(new String(str.getBytes(encode), encode))) {
			String s3 = encode;
			System.out.println(s3);
		}
	}
}
