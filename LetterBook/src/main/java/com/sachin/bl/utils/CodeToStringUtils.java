package com.sachin.bl.utils;

import java.io.UnsupportedEncodingException;

public class CodeToStringUtils {

	public String codeString(String str) {
		String s = str;
		try {
			byte[] temp = s.getBytes("utf-8");
			return new String(temp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

}
