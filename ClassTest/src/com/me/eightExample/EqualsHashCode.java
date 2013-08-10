package com.me.eightExample;

public class EqualsHashCode {

	public String str;

	public EqualsHashCode(String str) {
		this.str = str;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof EqualsHashCode))
			return false;
		EqualsHashCode equalsHashCode = (EqualsHashCode) o;
		return equalsHashCode.str.equals(str);
	}

	@Override
	public int hashCode() {
		return str.hashCode();
	}

}
