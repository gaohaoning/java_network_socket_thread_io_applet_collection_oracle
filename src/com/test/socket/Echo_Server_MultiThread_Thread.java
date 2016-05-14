package com.test.socket;
import java.io.*;
import java.net.*;

public class Echo_Server_MultiThread_Thread extends Thread
{
	private Socket socket;
	public Echo_Server_MultiThread_Thread(Socket socket)
	{
		this.socket=socket;
	}
	
	public void run()
	{
		try
		{
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true)
			{
				String str=in.readLine();
				System.out.println("Server Received : "+str);
				if(str==null)
				{
					break;
				}
				else
				{
					out.println("This is Server Echo : "+str);
					//out.flush();
					if(str.equals("exit"))
					{
						break;						
					}
				}
			}
			
			out.close();
			in.close();
			socket.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}
}
