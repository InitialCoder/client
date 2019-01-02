package com.ascend.client.future;

public class FutureTest {

	public static void main(String[] args) {
		Client client=new Client();
		//会得到FutureData类型的数据，并且futureData装配RealData
		Data data=client.requestData("name");
		System.out.println("请求完毕！");
		try {
			System.out.println("异步执行下面的方法！");
			System.out.println("咖喱刚刚");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("其他方法执行结束");
		
		System.out.println("response 的数据："+data.getResult());
		System.out.println("response 的数据："+data.getResult());
		
		
	}
}
