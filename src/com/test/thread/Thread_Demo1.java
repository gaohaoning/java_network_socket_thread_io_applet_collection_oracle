package com.test.thread;

public class Thread_Demo1
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new TestThread_1().start();
		for(int i=0;i<1000;i++)
		{
			System.out.println("Main Thread =====");
		}		
	}
}

class TestThread_1 extends Thread
{
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("Test Thread **************************************************");
		}
	}
}