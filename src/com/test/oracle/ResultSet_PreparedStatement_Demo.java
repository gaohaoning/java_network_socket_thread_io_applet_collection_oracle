package com.test.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSet_PreparedStatement_Demo
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
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//==================================================
		String sql_query="SELECT pid,name,age,birthday,salary FROM person";
		//String sql_query_fuzzy="SELECT pid,name,age,birthday,salary FROM person WHERE name LIKE ? OR birthday LIKE ?";
		String sql_query_fuzzy="SELECT pid,name,age,birthday,salary FROM person WHERE name LIKE ?";
		//==================================================
		//(1)普通模式查询
		//PreparedStatement ps=conn.prepareStatement(sql_query);// sql 参数在此处加入
		//(2)模糊模式查询
		PreparedStatement ps=conn.prepareStatement(sql_query_fuzzy);// sql 参数在此处加入
		System.out.println(ps);
		
		String keyWord="e";
		ps.setString(1, "%"+keyWord+"%");
		//ps.setString(2, "%"+keyWord+"%");
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		ResultSet result=ps.executeQuery();//此处函数体内不再需要 sql 参数		
		System.out.println(result);
		//==========================================================================================
		//用字段名查询
//		while(result.next())
//		{
//			System.out.print(result.getInt("pid")+" ");
//			System.out.print(result.getString("name")+" ");
//			System.out.print(result.getInt("age")+" ");
//			System.out.print(result.getDate("birthday")+" ");
//			System.out.println(result.getFloat("salary")+" ");
//		}
		
		//用索引号查询
		while(result.next())
		{
			System.out.print(result.getInt(1)+" ");
			System.out.print(result.getString(2)+" ");
			System.out.print(result.getInt(3)+" ");
			System.out.print(result.getDate(4)+" ");
			System.out.println(result.getFloat(5)+" ");
		}
		
		result.close();
		ps.close();
		conn.close();
	}
}
