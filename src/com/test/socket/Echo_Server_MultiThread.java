package com.test.socket;
import java.io.*;
import java.net.*;

public class Echo_Server_MultiThread
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket server_scoket = new ServerSocket(1111);

		Socket incoming;
		boolean flag = true;
		while (flag)
		{
			// Echo_Server_MultiThread_Thread(server_scoket.accept()).start();
			incoming = server_scoket.accept();
			new Echo_Server_MultiThread_Thread(incoming).start();
		}

		server_scoket.close();
	}
}
