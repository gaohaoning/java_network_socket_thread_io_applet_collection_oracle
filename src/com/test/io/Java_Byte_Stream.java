package com.test.io;
import java.util.*;
import java.io.*;

public class Java_Byte_Stream
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("=====Java Test=====");
		
		File f=new File("C:\\Documents and Settings\\GDX\\桌面\\java_file.txt");
		
		try
		{
			//out =new FileOutputStream(f,true);
			OutputStream out =new FileOutputStream(f);
			String str=new String("Hello javatest 字节流 中文用以测试");			
			byte b[]=str.getBytes();
			out.write(b);
			out.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		try
		{
			InputStream in=new FileInputStream(f);
			//byte []b_=new byte[1024];
			byte b_[]=new byte[1024];
			int i=0;
			i=in.read(b_);
			in.close();
			System.out.println(new String(b_, 0, i));
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
	}
}

