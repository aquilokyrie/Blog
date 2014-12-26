package com.aquilokyrie.blog.util;

public class StringUtil {
	
	public static boolean isBlank(String str){
		return str == null || "".equals(str) || "".equals(str.trim());
	}

}
