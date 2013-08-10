package com.me.dataStructure;

public class StrctureTest {

	public static void main(String[] args) {

		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.add(0);
		lList.add(1);
		lList.add(2, 3, 4);
		lList.add(1);
		lList.add(100, 5);
//		lList.reverse();
		

		lList.printList();
		System.out.println("");
		System.out.println(lList.findFirst(4));
	}

}
