package com.spring.helper;

import java.sql.*;
import javax.sql.*;

import org.springframework.stereotype.Component;

@Component
public class JDBChelper 
{
	
  String driver = "com.mysql.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/movie_base";
  String user_name = 	"root";
  String password = "musicishope!!3";
  Connection con = null;
  
  public JDBChelper()
  {
	  System.out.println("in no argument constructor of jdbc helper class");
  }
  public Connection getConnection()
  {
	  System.out.println("in get connection method of jdbc helper class");
	  try 
	  {
		Class.forName(driver);
		con = DriverManager.getConnection(url,user_name,password);
		return con;
	  } 
	  catch (ClassNotFoundException | SQLException c) 
	  {
		  c.printStackTrace();
		  System.out.println("in class not found exceptions catch");
		  return null;
		// TODO: handle exception
	  }
  }
  
  public void close(Connection ps)
  {
	  try 
	  {
		if(ps!=null)
			ps.close();
	  }
	  catch (Exception e) 
	  {
		e.printStackTrace();
	  }
  }
  
  
  public void close(PreparedStatement ps)
  {
	  try 
	  {
		if(ps!=null)
			ps.close();
	  }
	  catch (Exception e) 
	  {
		  e.printStackTrace();
	  }
  }
  
}
