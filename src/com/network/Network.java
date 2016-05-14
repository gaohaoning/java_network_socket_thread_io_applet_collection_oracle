package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Network
{
	public static void main(String[] args)
	{
		try
		{
			URL url=new URL("http://www.baidu.com");
			
			InputStream input=url.openStream();
			
			BufferedReader bufReader=new BufferedReader(new InputStreamReader(input,"UTF-8"));
			
			String line=null;
			while((line=bufReader.readLine())!=null)
			{
				System.out.println(line);
			}
			
			input.close();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
