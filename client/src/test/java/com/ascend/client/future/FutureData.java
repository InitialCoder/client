package com.ascend.client.future;

public class FutureData implements Data {

	private RealData realData=null;
	private boolean isReady=false;
	
	public synchronized void setRealData(RealData realData){
		while(isReady){
			return ;
		}
		this.realData=realData;
		this.isReady=true;
		this.notifyAll();
	}
	
	@Override
	public synchronized String getResult() {
		
		while(!isReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

}
