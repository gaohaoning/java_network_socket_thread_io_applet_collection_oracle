package com.test.io;
import java.io.*;

public class Java_Serializable
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File f=new File("C:\\Documents and Settings\\GDX\\×ÀÃæ\\java_file.txt");
		try
		{
			serialize(f);
			deserialize(f);
		} catch (Exception e)
		{
			// TODO: handle exception
		}			
	}
	
	public static void serialize(File f) throws Exception
	{
		OutputStream out=new FileOutputStream(f);
		ObjectOutputStream c_out=new ObjectOutputStream(out);
		c_out.writeObject(new Person("Beckham",35));
		c_out.close();
	}
	
	public static void deserialize(File f) throws Exception
	{
		InputStream in=new FileInputStream(f);
		ObjectInputStream c_in=new ObjectInputStream(in);
		Person p=(Person)c_in.readObject();
		System.out.println(p);		
	}	
}
