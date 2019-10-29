package com.example.SmartziWeb.utils;

public class ApplicationUtils {

	public static long getTimeDiff(long startTime)
	  {
	    long endTime = System.currentTimeMillis();
	    long timeDiff = endTime - startTime;
	    
	    return timeDiff;
	  }
	
}