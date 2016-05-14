package com.test.thread;

public class Thread_Demo2
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		TestThread_2 tt=new TestThread_2();
//		new Thread(tt).start();
		new Thread(new TestThread_2()).start();
		
		for(int i=0;i<1000;i++)
		{
			System.out.println("Main Thread =====");
		}		
	}
}

class TestThread_2 implements Runnable
{
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("Test Thread **************************************************");
		}
	}
}
