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
		//(1)��ͨģʽ��ѯ
		//PreparedStatement ps=conn.prepareStatement(sql_query);// sql �����ڴ˴�����
		//(2)ģ��ģʽ��ѯ
		PreparedStatement ps=conn.prepareStatement(sql_query_fuzzy);// sql �����ڴ˴�����
		System.out.println(ps);
		
		String keyWord="e";
		ps.setString(1, "%"+keyWord+"%");
		//ps.setString(2, "%"+keyWord+"%");
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		ResultSet result=ps.executeQuery();//�˴��������ڲ�����Ҫ sql ����		
		System.out.println(result);
		//==========================================================================================
		//���ֶ�����ѯ
//		while(result.next())
//		{
//			System.out.print(result.getInt("pid")+" ");
//			System.out.print(result.getString("name")+" ");
//			System.out.print(result.getInt("age")+" ");
//			System.out.print(result.getDate("birthday")+" ");
//			System.out.println(result.getFloat("salary")+" ");
//		}
		
		//�������Ų�ѯ
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
