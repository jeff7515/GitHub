package com.me.main;

public class Test implements Cloneable {

	@Override
	public Test clone() {

		Test t = null;
		try {
			t = (Test) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}