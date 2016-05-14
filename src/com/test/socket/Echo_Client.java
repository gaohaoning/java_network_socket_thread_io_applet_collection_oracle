package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echo_Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket client_socket=new Socket("127.0.0.1", 1111);
			//=======================================================================
			PrintWriter out=new PrintWriter(client_socket.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			//=======================================================================
			
			BufferedReader std_in=new BufferedReader(new InputStreamReader(System.in));
			
			String user_input;
			while((user_input=std_in.readLine())!=null)
			{
				out.println(user_input);
				System.out.println(in.readLine());
			}
			
			out.close();
			in.close();
			client_socket.close();			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
