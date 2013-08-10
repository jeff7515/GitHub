package com.me.eightExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoThroughMethods {

	public static void main(String[] arg) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");

		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map4(map);

	}

	public static void map4(Map<String, String> map) {
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(map.get(entry.getValue()));
		}
	}

	public static void map3(Map<String, String> map) {
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Map.Entry<String, String> entries : set)
			System.out.println(entries.getValue());
	}

	public static void map2(Map<String, String> map) {
		Set<String> keys = map.keySet();
		Iterator iterator = keys.iterator();
		while (iterator.hasNext())
			System.out.println(map.get(iterator.next()));
	}
	
	public static void map1(Map<String, String> map) {
		Set<String> keys = map.keySet();
		for (String k : keys)
			System.out.println(map.get(k));
	}

	public static void set2(Set<String> set) {
		Iterator iterator = set.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	public static void set1(Set<String> set) {
		for (String s : set)
			System.out.println(s);
	}

	public static void for1(ArrayList<String> inList) {
		for (int i = 0; i < inList.size(); i++)
			System.out.println(inList.get(i));
	}

	public static void for2(ArrayList<String> inList) {
		for (String s : inList)
			System.out.println(s);
	}

	public static void for3(ArrayList<String> inList) {
		Iterator<String> iterator = inList.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

}
