package com.me.eightExample;

public class ComparableExample implements Comparable<ComparableExample> {

	public int x;

	public ComparableExample(int i) {
		this.x = i;
	}

	public ComparableExample() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(ComparableExample c) {
		if (x<c.x)
			return -1;
		else if (c.x == x)
			return 0;
		else
			return 1;
	}

}
