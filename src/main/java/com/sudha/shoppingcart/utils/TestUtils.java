package com.sudha.shoppingcart.utils;

public class TestUtils {

	public static void addDelay(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
