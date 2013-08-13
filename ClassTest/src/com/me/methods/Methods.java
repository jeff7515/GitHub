package com.me.methods;

public class Methods {

	static void test(String str, int s, String... vals) {
		System.out.println(str);
		System.out.println(String.valueOf(s));
		for (int i = 0; i < vals.length; i++) {
			System.out.println(vals[i]);
		}
	}
	
}
