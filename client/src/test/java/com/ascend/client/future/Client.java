package com.ascend.client.future;

public class Client {
	
	public Data requestData(String str){
		final FutureData future=new FutureData();
		//启动装配readData 的线程
		new Thread(){
			public void run(){
				//构造真实数据时最耗时
				RealData realData=new RealData(str);
				future.setRealData(realData);
			}
		}.start();
		//返回future
		return future;
	}
}
