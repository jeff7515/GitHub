package com.me.multithreading;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public final class MultireadersOneWriter {
	
	/** Holds the preferences as simple name-value pairs of Strings. */
	  private final Map<String, String> fPreferences = new LinkedHashMap<String, String>();
	  private final ReentrantReadWriteLock fLock = new ReentrantReadWriteLock();
	  private final Lock fReadLock = fLock.readLock();
	  private final Lock fWriteLock = fLock.writeLock();
	  
	  /** Fetch a setting - this is the more common operation.  */
	  public String fetch(String aName){
	    String result = "";
	    fReadLock.lock();
	    try {
	      result = fPreferences.get(aName);
	    }
	    finally {
	      fReadLock.unlock();
	    }
	    return result;
	  }
	 
	  /** Change a setting - this is the less common operation. */
	  public void update(String aName, String aValue){
	    fWriteLock.lock();
	    try {
	      fPreferences.put(aName, aValue);
	    }
	    finally {
	      fWriteLock.unlock();
	    }
	  }
	 
	  //...elided
	  
	  // PRIVATE
	  
	  
	}