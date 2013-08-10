package com.me.eightExample;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapExample {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		SortMap sm = new SortMap(map);
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(sm);

		map.put("a", 1);
		map.put("b", 1);
		map.put("c", 2);
		map.put("d", -1);
		map.put("e", 3);

		
		sortMap.putAll(map);
		
		System.out.println(map);
		System.out.println(" ");
		System.out.println(sortMap);
	}

	public static class SortMap implements Comparator<String> {
		Map<String, Integer> map;

		public SortMap(Map<String, Integer> map) {
			this.map = map;
		}

		@Override
		public int compare(String a, String b) {
			if (map.get(a) <= map.get(b))
				return -1;
			else
				return 1;
		}

	}
}