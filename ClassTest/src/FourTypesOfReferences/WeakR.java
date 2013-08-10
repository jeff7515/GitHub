package FourTypesOfReferences;

import java.lang.ref.WeakReference;

public class WeakR {

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
		WeakReference<Inner> wr = new WeakReference<Inner>(in);
		collect();
		System.out.println("Removing Reference to the object");
		in = null; // but still the object is referred by a weak reference
		System.out.println("After removing Strong Reference.");
		collect();
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
