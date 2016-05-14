package com.test.oracle;
import java.sql.*;

public class Statement_Demo
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
		
		//Statement.executeUpdate("�˴���дSQL��� ĩβ���ӷֺ�");
		stm.executeUpdate("DROP SEQUENCE perseq");
		stm.executeUpdate("CREATE SEQUENCE perseq");
		stm.executeUpdate("DROP TABLE person");
		stm.executeUpdate("CREATE TABLE person(" +
				"pid      NUMBER          PRIMARY KEY NOT NULL," +
				"name     VARCHAR2(15)    NOT NULL," +
				"age      NUMBER          NOT NULL," +
				"birthday DATE            NOT NULL," +
				"salary   NUMBER(10,2)    NOT NULL)");
		
		//����
		//stm.executeUpdate("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'����',30,TO_DATE('1980-02-15','yyyy-mm-dd'),9000)");

		stm.executeUpdate("INSERT INTO person(pid,name,age,birthday,salary) " +				
		"VALUES (perseq.nextval,'Tom',30,TO_DATE('1980-02-15','yyyy-mm-dd'),9000)");
		stm.executeUpdate("INSERT INTO person(pid,name,age,birthday,salary) " +		
		"VALUES (perseq.nextval,'Jake',35,TO_DATE('1975-9-12','yyyy-mm-dd'),8500)");
		stm.executeUpdate("INSERT INTO person(pid,name,age,birthday,salary) " +		
		"VALUES (perseq.nextval,'Michael',39,TO_DATE('1982-03-30','yyyy-mm-dd'),9500)");
		
		//����
		//stm.executeUpdate("UPDATE person SET name='����',age=33,birthday=sysdate,salary=9500 WHERE pid=2");
		//ɾ��
		//stm.executeUpdate("DELETE FROM person WHERE pid=1");
		//stm.executeUpdate("DELETE FROM person");
		
		stm.close();
		conn.close();
	}
}
