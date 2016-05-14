package com.test.thread;

public class Thread_Demo_3
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new TestThread_3().start();
	}
}

class TestThread_3 extends Thread
{
	private int tickets=100;
	public void run()
	{
		while(true)
		{
			if(tickets>0)
			{
				System.out.println(Thread.currentThread().getName()+" sell ticket "+tickets--);
			}
		}
	}
}
