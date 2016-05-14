package com.test.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class Batch_Demo
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
		//==================================================
		String sql="INSERT INTO person(pid,name,age,birthday,salary) " +
		"VALUES (perseq.nextval,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement ps=conn.prepareStatement(sql);
		
		for(int i=0;i<5;i++)
		{
			ps.setString(1, "TestName_"+i);
			ps.setInt(2, 20+i);
			ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			ps.setFloat(4, 6000+500*i);
			
			ps.addBatch();			
		}
		System.out.println(ps);
//		int[] executeBatch() 将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。 
		int c[]=ps.executeBatch();
		System.out.println("Execute Succeed Number : "+c.length);
		
		ps.close();
		conn.close();
	}
}
