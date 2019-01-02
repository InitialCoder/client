package com.ascend.client.future;

public class RealData implements Data{

	protected String result;
	
	public RealData(String str) {
		StringBuffer bf=new StringBuffer();
		for(int i=0;i<10;i++){
			bf.append(str);
			try {
				//模拟耗时
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.result=bf.toString();
	}
	@Override
	public String getResult() {
		return result;
	}

	
}
