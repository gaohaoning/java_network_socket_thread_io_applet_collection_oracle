package com.test.io;

import java.util.*;
import java.io.*;

public class Java_Char_Stream
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("=====Java Test=====");

		File f = new File("C:\\Documents and Settings\\GDX\\桌面\\java_file.txt");

		try
		{
			//out=new FileWriter(f,true);
			Writer out=new FileWriter(f);
			String str=new String("Hello javatest 字符流 中文用以测试");
			out.write(str);
			out.close();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		try
		{
			Reader in=new FileReader(f);			
			//char b_[]=new char[1024];
			char []b_=new char[1024];
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
