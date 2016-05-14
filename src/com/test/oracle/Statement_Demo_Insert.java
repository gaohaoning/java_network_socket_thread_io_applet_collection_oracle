package com.test.oracle;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Statement_Demo_Insert
{
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String DBUSER = "system";
	public static final String DBPASS = "java";

	public static void main(String[] args) throws Exception
	{
		//===================================================================================
		//两种方法获取键盘输入内容并转化成SQL语句
		//String sql=getSQL_1();
		String sql=getSQL_2();
		
		System.out.println(sql);
		//===================================================================================
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		System.out.println(conn);
		Statement stm=conn.createStatement();
		System.out.println(stm);

		stm.executeUpdate(sql);		
		
		stm.close();
		conn.close();
	}
	
	public static String getSQL_1() throws Exception
	{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Input name : ");		
		String name=input.readLine();
		
		System.out.print("Input age : ");		
		int age=Integer.parseInt(input.readLine());
		
		System.out.print("Input birthday : ");		
		String birthday=input.readLine();
		
		System.out.print("Input salary : ");		
		float salary=Float.parseFloat(input.readLine());
		
		String sql_="INSERT INTO person(pid,name,age,birthday,salary) " +				
		"VALUES (perseq.nextval,'"
		+name+"',"
		+Integer.toString(age)+",TO_DATE('"+birthday+"','yyyy-mm-dd'),"
		+Float.toString(salary)+")";
		
		return sql_;		
	}
	
	public static String getSQL_2() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Input name : ");		
		String name=sc.next();
		
		System.out.print("Input age : ");		
		int age=sc.nextInt();
		
		System.out.print("Input birthday : ");		
		String birthday=sc.next();
		
		System.out.print("Input salary : ");		
		float salary=sc.nextFloat();
		
		String sql_="INSERT INTO person(pid,name,age,birthday,salary) " +				
		"VALUES (perseq.nextval,'"
		+name+"',"
		+Integer.toString(age)+",TO_DATE('"+birthday+"','yyyy-mm-dd'),"
		+Float.toString(salary)+")";
		
		return sql_;		
	}
}
