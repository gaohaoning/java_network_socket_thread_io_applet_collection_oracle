package com.test.io;
import java.io.*;

public class Java_Piped_Stream
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Sender sender=new Sender();
			Receiver receiver=new Receiver();
			PipedOutputStream out=sender.getOutputStream();
			PipedInputStream in=receiver.getInputStream();
			
			//in.connect(out);
			out.connect(in);			
			
			sender.start();
			receiver.start();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}
}

class Sender extends Thread
{
	private PipedOutputStream out=new PipedOutputStream();
	public PipedOutputStream getOutputStream()
	{
		return out;
	}
	public void run()
	{
		String str=new String("Hello Receiver 中文 管道流测试");
		try
		{
			out.write(str.getBytes());//////////////////////////////////////////
			out.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}

class Receiver extends Thread
{
	private PipedInputStream in=new PipedInputStream();
	public PipedInputStream getInputStream()
	{
		return in;
	}
	public void run()
	{
		byte buf[]=new byte[1024];
		try
		{
			int len=in.read(buf);//////////////////////////////////////////
			in.close();
			String str=new String(buf,0,len);
			System.out.println(str);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
}


