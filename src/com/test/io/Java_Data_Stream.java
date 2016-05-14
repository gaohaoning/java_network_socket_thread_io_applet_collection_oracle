package com.test.io;
import java.util.*;
import java.io.*;

public class Java_Data_Stream
{
	public static void main(String[] args)
	{
		File f=new File("C:\\Documents and Settings\\GDX\\桌面\\java_file.txt");
		
		try
		{
			DataOutputStream out=new DataOutputStream(new FileOutputStream(f));
			
			String name[]={"张三","李四","王五"};
			int age[]={25,26,27};
			char c[]={'A','B','C'};
			byte b[]={1,2,3};
			
			for(int i=0;i<name.length;i++)
			{
				//out.writeBytes(name[i]);
				out.writeChars(name[i]);
				out.writeChar('\t');
				
				out.writeInt(age[i]);
				out.writeChar('\t');
				
				out.writeChar(c[i]);
				out.writeChar('\t');
				
				out.writeByte(b[i]);
				out.writeChar('\n');				
			}
			out.close();			
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		try
		{
			DataInputStream in=new DataInputStream(new FileInputStream(f));

			StringBuffer name_;
			int age_;
			char c_;
			byte b_;
			
			//while(true)
			for(int j=0;j<3;j++)
			{
				name_=new StringBuffer();
				char chr;
				while ((chr = in.readChar()) != '\t')
				{
					name_.append(chr);
				}
				
				age_=in.readInt();
				in.readChar();
				
				c_=in.readChar();
				in.readChar();
				
				b_=in.readByte();
				in.readChar();
				
				System.out.println(name_+" "+age_+" "+c_+" "+b_);	
			}			
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("");
		}
		
	}
}
