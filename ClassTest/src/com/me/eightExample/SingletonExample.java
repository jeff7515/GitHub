package com.me.eightExample;

public class SingletonExample {

	private static SingletonExample instance;
	
	private SingletonExample() {
	}
	
	public static SingletonExample getInstance(){
		
		if(instance == null){
			synchronized (SingletonExample.class) {
				if(instance == null){
					instance = new SingletonExample();
				}
			}
		}
		return instance;
		
		
	}
	
	
	
//	Peter's version
//	public static SingletonExample getInstance(){
//		return Inner.instance;
//	}
//	
//	
//	private static class Inner{
//		static SingletonExample instance = new SingletonExample();
//	}
	
	
}
