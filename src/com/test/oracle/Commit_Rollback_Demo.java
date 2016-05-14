package com.test.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Commit_Rollback_Demo
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
		////////////////////////////////////////////////////
		conn.setAutoCommit(false);
		//���ô˷�ʽԭ�����ڷ�ֹ�ύ��SQL����к��д�����ʹ����֮ǰ����䱻ִ�ж�����֮�����䲻��ִ��
		//��������ڿ������ǲ������
		////////////////////////////////////////////////////
		Statement stm=conn.createStatement();
		
		try
		{
			stm.addBatch("INSERT INTO person(pid,name,age,birthday,salary) " +				
			"VALUES (perseq.nextval,'����',30,TO_DATE('1980-02-15','yyyy-mm-dd'),9000)");
			stm.addBatch("INSERT INTO person(pid,name,age,birthday,salary) " +				
			"VALUES (perseq.nextval,'����',35,TO_DATE('1975-05-12','yyyy-mm-dd'),8000)");
			stm.addBatch("INSERT INTO person(pid,name,age,birthday,salary) " +				
			"VALUES (perseq.nextval,'����',39,TO_DATE('1988-03-15','yyyy-mm-dd'),8500)");
			
			int c[]=stm.executeBatch();
			System.out.println("Execute Succeed Number : "+c.length);
			
			conn.commit();
		} catch (Exception e)
		{
			conn.rollback();
		}
				
		stm.close();
		conn.close();
	}
}
