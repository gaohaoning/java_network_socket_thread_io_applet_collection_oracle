package com.test.thread;

public class Java_Thread_Test_1 extends Thread
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Java_Thread_Test_1 tt=new Java_Thread_Test_1();
		tt.setName("Thread Set Name");
		System.out.println("before start() tt.isAlive= "+tt.isAlive());
		tt.start();
		System.out.println("after start() tt.isAlive= "+tt.isAlive());
		
		for(int i=0;i<100;i++)
		{
			tt.printMsg();
		}		
		
		System.out.println("when Main Thread end, tt.isAlive= "+tt.isAlive());
	}
	
	public void printMsg()
	{
		Thread t=Thread.currentThread();
		System.out.println("name= "+t.getName());
	}
	
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			printMsg();
		}
	}
}


