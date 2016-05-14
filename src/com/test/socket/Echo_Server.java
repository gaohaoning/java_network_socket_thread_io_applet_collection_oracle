package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo_Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server_scoket=new ServerSocket(1111);
			Socket incoming=server_scoket.accept();
			//=======================================================================
			PrintWriter out=new PrintWriter(incoming.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			//=======================================================================			
			//out.flush();
			
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
			incoming.close();
			server_scoket.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
