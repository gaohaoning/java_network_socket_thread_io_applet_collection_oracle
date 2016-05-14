package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Socket_Client
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			//Socket client_socket=new Socket("localhost", 9999);
			Socket client_socket=new Socket("127.0.0.1", 9999);
			BufferedReader in=new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			System.out.println(in.readLine());
			
			in.close();
			client_socket.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
