package com.me.eightExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

	int i;

	public ComparatorExample(int i) {
		this.i = i;
	}

	public static void main(String[] args) {

		ComparatorExample c1 = new ComparatorExample(1);
		ComparatorExample c2 = new ComparatorExample(2);
		ComparatorExample c3 = new ComparatorExample(4);
		ArrayList<ComparatorExample> list = new ArrayList<ComparatorExample>();
		list.add(c1);
		list.add(c2);
		list.add(c3);

		Collections.sort(list, new Comparator<ComparatorExample>() {

			@Override
			public int compare(ComparatorExample a, ComparatorExample b) {

				if (a.i < b.i)
					return -1;
				else if (a.i == b.i)
					return 0;
				else
					return 1;

			}
		});

		for (ComparatorExample c : list) {
			System.out.println(c);
		}

	}

	@Override
	public String toString() {
		return String.valueOf(i);
	}

}
