package com.test.thread;

public class Thread_Demo_4
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TestThread_4 tt=new TestThread_4();
		new Thread(tt).start();
		new Thread(tt).start();
	}

}

class TestThread_4 implements Runnable
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