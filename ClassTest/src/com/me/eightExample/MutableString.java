package com.me.eightExample;

import java.lang.reflect.Field;

public class MutableString {
	String s;

	MutableString(String s) {
		this.s = s;
	}

	public static void main(String[] args) throws SecurityException,
			IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		MutableString ms = new MutableString("abcd");
		System.out.println("original string: " + ms.s);
		ms.setString("ddd");
		System.out.println("altered string1: " + ms.s);
//		ms.setString("ddd");
//		System.out.println("altered string2: " + ms.s);
//		ms.setString("ddda");
//		System.out.println("altered string3: " + ms.s);
			
	}
	

	public void setString(String a) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		Field val = String.class.getDeclaredField("value"); //value
//		Field off = String.class.getDeclaredField("offset"); //initial offset
		Field count = String.class.getDeclaredField("count"); //length
		val.setAccessible(true);
//		off.setAccessible(true);
		count.setAccessible(true);
		val.set(s, a.toCharArray());
		count.set(s, a.length());
	}
}
