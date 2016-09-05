package io;


import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {


	private InputStream in;
	private int checkNum;
	private int count;
	public MyDecompressorInputStream(InputStream in) {

		this.in=in;
		this.checkNum=0;
		this.count=0;
	}

	@Override
	public int read() throws IOException {
		return 0;

	}

	public int read(int b) throws IOException {
		in.read();
		return -1;
	}

	public int read(byte[] arr) throws IOException {

		int index=0;
		checkNum=in.read();
		count=in.read();
		while(checkNum!=-1 && count!=-1)
		{
			for(int i = 0; i<count; i++)
			{
				arr[index] = (byte)checkNum;
				index++;

			}
			checkNum=in.read();
			count=in.read();
		}
		in.close();

		return 0;
	}



















}