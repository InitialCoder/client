package com.ascend.client.jdkfuture;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		StringBuffer bd=new StringBuffer();
		for(int i=0;i<10;i++){
			bd.append("aa"+i);
		}
		Thread.sleep(2000);
		return bd.toString();
	}

}
