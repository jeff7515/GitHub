package com.me.eightExample;

public final class ImmutableClass {

	private String name;

	public ImmutableClass(String name) {
		this.name = name;
	}

	public ImmutableClass() {
	}

	public String getName() {
		return name;
	}

	public ImmutableClass addPrefix(String s) {
		return new ImmutableClass(s + name);
	}

}
