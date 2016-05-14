package com.test.socket;
import java.io.*;
import java.net.*;

public class Socket_Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server_scoket=new ServerSocket(9999);
			Socket client_socket=server_scoket.accept();
			//=======================================================================
			PrintWriter out=new PrintWriter(client_socket.getOutputStream(), true);
			out.println("Hello This is Server");
			
			out.close();
			server_scoket.close();
			client_socket.close();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}

}
