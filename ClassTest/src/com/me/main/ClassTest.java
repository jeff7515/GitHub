package com.me.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.me.dataStructure.LinkedList;
import com.me.eightExample.ComparableExample;

public class ClassTest {

	public static void main(String[] args) {

		Set<B> set = new TreeSet<ClassTest.B>();
		
		B a = new B("1", "1");
		B a1 = new B("1", "2");
		B a2 = new B("1", "1");
		B a3 = new B("1", "2");
		
		set.add(a);
		set.add(a1);
		set.add(a2);
		set.add(a3);
		
		System.out.println(set);
		
		
	}

	static class B implements Comparable<B> {

		String fname;
		String lname;

		public B(String fname, String lname) {
			this.fname = fname;
			this.lname = lname;
		}

		@Override
		public int compareTo(B o) {
			return (fname + lname).compareTo(o.fname + o.lname);
		}
		
		@Override
		public String toString(){
			return fname + " " + lname;
		}
	}

}