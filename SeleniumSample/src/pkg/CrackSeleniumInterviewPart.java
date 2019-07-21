package pkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrackSeleniumInterviewPart {

public static void main(String args[]) throws SQLException, ClassNotFoundException
{
	Connection conn=null;
	ResultSet rs=null;
	Statement stmt=null;
	try {
	String connectionstring="jdbc:oracle:thin:@localhost:1521:xe";
	String username="user";
	String password="pass";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(connectionstring,username,password);
	stmt= conn.createStatement();
	rs=stmt.executeQuery("select * from emp");
	while(rs.next())
		System.out.println("Column1: "+rs.getString(0)+"Column2: "+rs.getInt(1));
	}
	catch(SQLException e)
	{
		System.out.println("SQLException exception caught");
		
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("ClassNotFoundException exception caught");
	}
	finally {
		stmt.close();
		rs.close();
		conn.close();
	}
}

}
