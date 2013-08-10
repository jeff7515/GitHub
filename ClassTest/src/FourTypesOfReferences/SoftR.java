package FourTypesOfReferences;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftR {

	static boolean objectCollected = false;

	public static class Inner {
		@Override
		public void finalize() {
			System.out.println("I'm being collected.");
			objectCollected = true;
		}
	}

	public static void main(String args[]) {

		Inner in = new Inner(); // Strong Reference created
		SoftReference<Inner> sr = new SoftReference<Inner>(in);
		System.out.println(in.toString());
		System.out.println(sr.get()); // get() method returns reference of object being referred
		collect();
		System.out.println("Removing Reference to the object");
		in = null; // but still the object is referred by a soft reference
		System.out.println("After removing Strong Reference.");
		collect();
		try {
			List l = new ArrayList();
			while (true)
				l.add(1);
		} catch (OutOfMemoryError e) {
			System.out.println("OutOfMemoryError");
		} finally {
			collect();
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
		if (objectCollected) {
			System.out.println("Object Collected.");
			objectCollected = false;
		} else {
			System.out.println("Object not eligible for Collection.");
		}
	}

}
