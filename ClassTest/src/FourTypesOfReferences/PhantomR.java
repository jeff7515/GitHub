package FourTypesOfReferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class PhantomR {
	static boolean objectCollected = false;

	public static class Inner {
	}

	public static void main(String args[]) {
		
		Inner in = new Inner(); // Strong Reference created
		Map cleanUp = new HashMap();
		ReferenceQueue dead = new ReferenceQueue();
		PhantomReference phantom = new PhantomReference(in, dead);
		cleanUp.put(phantom, "I'm finalized clean me now!");
		in = null; // removing strong reference
		collect();
		Reference ref = dead.poll();
		if (ref != null) {
			System.out.println(cleanUp.remove(ref));
		}
	}

	public static void collect() {
		System.out.println("Trying to clear object.");
		System.gc();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.gc();
	}
}
