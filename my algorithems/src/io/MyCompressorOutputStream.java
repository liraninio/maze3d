package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	private int count;
	private int checkNum;

	public MyCompressorOutputStream(OutputStream out) {
		this.out=out;
		this.count=0;
		this.checkNum=0;
	}

	@Override
	public void write(int b) throws IOException {

		if(count==0){

			checkNum=b;
			count++;
		}
	
		else if(checkNum==b){

			count++;
		}
		else{
			while(count>255){
				out.write(checkNum);
				out.write(255);
				count-=255;
			}
			out.write(checkNum);
			out.write(count);
			checkNum=b;
			count=1;
		}

	}

	
	public void write(byte[] arr)throws IOException{
	
	
		for(int i=0;i<arr.length;i++)
		{
			write(arr[i]);
		}
		//need to check.
		out.write(checkNum);
		out.write(count);
		out.close();
		
		
		
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}
	
	
	
}