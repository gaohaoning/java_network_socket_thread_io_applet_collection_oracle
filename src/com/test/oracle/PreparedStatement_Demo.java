package com.test.oracle;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatement_Demo
{
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String DBUSER = "system";
	public static final String DBPASS = "java";

	public static void main(String[] args) throws Exception
	{
		//===================================================================================	
		String name="Mr'TestName";
		int age=25;	
		//Date类有2个来源 (1)java.util.Date (2)java.sql.Date
		java.sql.Date birthday=new java.sql.Date(1990, 12, 25);		
		float salary=8600;

		String sql="INSERT INTO person(pid,name,age,birthday,salary) " +
				"VALUES (perseq.nextval,?,?,?,?)";
		System.out.println(sql);
		//===================================================================================
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		System.out.println(conn);
//		Statement stm=conn.createStatement();
//		System.out.println(stm);
		PreparedStatement ps=conn.prepareStatement(sql);// sql 参数在此处加入
		System.out.println(ps);
		
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setDate(3, new java.sql.Date(birthday.getTime()));
		ps.setFloat(4, salary);		
		System.out.println(ps);
		
		ps.executeUpdate();//此处函数体内不再需要 sql 参数
		
		ps.close();
		conn.close();
	}
}
