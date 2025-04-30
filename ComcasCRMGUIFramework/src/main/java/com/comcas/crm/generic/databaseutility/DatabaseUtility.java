package com.comcas.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DatabaseUtility{
	Connection con;
	//to make connection with database for different database
	public void getDBConnection(String url,String username,String password) throws SQLException
	{
		try {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	 con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println("exception handle");
		}
	}
	
	
	
	
	//make connection with only mysql database
	
	public void getDBConnection() throws SQLException
	{
		try {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(Exception e)
		{
			System.out.println("exception handle");
		}
	}
	//close connection to DB
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	//Execute nonselect query
	public int ExecuteNonSelectQuery(String query) throws SQLException
	
	{
		int result=0;
		try {
		Statement stmt=con.createStatement();
		 result= stmt.executeUpdate(query);
		}
		catch(Exception e)
		{
		
		}
		return result;
	}
	//Execute select query
	public ResultSet ExecuteSelectQuery(String query) throws SQLException
	{     ResultSet resultset=null;
	try
	{
		Statement stmt=con.createStatement();
		  resultset=stmt.executeQuery(query);
		 
	}catch(Exception e) {
		
	}
		return resultset;
	}
}
