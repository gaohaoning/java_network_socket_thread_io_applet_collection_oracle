package com.test.oracle;
import java.sql.*;

public class ResultSet_Statement_Demo
{
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String DBUSER = "system";
	public static final String DBPASS = "java";

	public static void main(String[] args) throws Exception
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		System.out.println(conn);
		Statement stm=conn.createStatement();
		System.out.println(stm);
		ResultSet result=stm.executeQuery("SELECT pid,name,age,birthday,salary FROM person");
		System.out.println(result);
		
		//用字段名查询
		while(result.next())
		{
			System.out.print(result.getInt("pid")+" ");
			System.out.print(result.getString("name")+" ");
			System.out.print(result.getInt("age")+" ");
			System.out.print(result.getDate("birthday")+" ");
			System.out.println(result.getFloat("salary")+" ");
		}
		
		//用索引号查询
//		while(result.next())
//		{
//			System.out.print(result.getInt(1)+" ");
//			System.out.print(result.getString(2)+" ");
//			System.out.print(result.getInt(3)+" ");
//			System.out.print(result.getDate(4)+" ");
//			System.out.println(result.getFloat(5)+" ");
//		}
		
		result.close();
		stm.close();
		conn.close();
	}
}
