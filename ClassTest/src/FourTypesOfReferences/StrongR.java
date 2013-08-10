package FourTypesOfReferences;

public class StrongR {

	static boolean objectCollected = false;

	public static class Inner {
		@Override
		public void finalize() {
			System.out.println("I'm being collected.");
			objectCollected = true;
		}
	}

	public static void main(String args[]) throws Exception {
		Inner in = new Inner(); // Strong Reference created
		collect();
	}

	public static void collect() throws Exception {
		System.out.println("Trying to clear object.");
		System.gc();
		Thread.sleep(5000);
		System.gc();
		if (objectCollected) {
			System.out.println("Object Collected.");
			objectCollected = false;
		} else {
			System.out.println("Object not eligible for Collection.");
		}
	}

}
