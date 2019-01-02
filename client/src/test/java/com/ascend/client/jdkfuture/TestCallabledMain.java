package com.ascend.client.jdkfuture;

import java.util.concurrent.FutureTask;

public class TestCallabledMain {
	public static void main(String[] args) {
		
		TestCallable call=new TestCallable();
		
		FutureTask<String> future=new FutureTask<String>(call);
		
		new Thread(future).start();

		try {
			String str=future.get();
			System.out.println(str);
		} catch (Exception e) {
		}
	}
}
