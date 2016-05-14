package com.test.oracle;
import java.sql.*;

public class ConnectJDBC
{
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String DBUSER="system";
	public static final String DBPASS="java";
	public static void main(String[] args) throws Exception
	{
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		System.out.println(conn);
		conn.close();
	}
}
