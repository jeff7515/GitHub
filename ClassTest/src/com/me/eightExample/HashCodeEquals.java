package com.me.eightExample;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEquals {

	String str;

	public HashCodeEquals(String str) {
		this.str = str;
	}
	
	public static void main(String[] args){
		
		HashCodeEquals s1 = new HashCodeEquals("a");
		HashCodeEquals s2 = new HashCodeEquals("a");
		HashCodeEquals s3 = new HashCodeEquals("b");
		HashCodeEquals s4 = new HashCodeEquals("c");
		HashCodeEquals s5 = new HashCodeEquals("d");
		
		Set<HashCodeEquals> set = new HashSet<HashCodeEquals>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		set.add(s5);
		
		System.out.println("Size: " + set.size());
		System.out.println("");
		
		for(HashCodeEquals ha : set){
			System.out.println(ha.str);
		}
		
	}
	

	@Override
	public int hashCode() {
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HashCodeEquals))
			return false;
		HashCodeEquals ha = (HashCodeEquals) obj;
		return str.equals(ha.str);
	}

}
