package com.amazon.hackday.trms.util;

import java.util.Random;

public class Sleeper {
	private static final int MAX_PERIOD = 10000;
	private static final int MIN_PERIOD = 2000;
	private static final Random random = new Random();	
	
	public static void sleep()
	{	
		try{
			Thread.sleep(MIN_PERIOD + random.nextInt(MAX_PERIOD - MIN_PERIOD));
		}
		catch(InterruptedException ex){
			throw new RuntimeException(ex);
		}
	}
}
