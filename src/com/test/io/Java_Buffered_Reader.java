package com.test.io;
import java.util.*;
import java.io.*;

public class Java_Buffered_Reader
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
			String str=buf.readLine();
			System.out.println("Your Input is : "+str);
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}
}
