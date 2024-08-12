package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	public void getdbConnection(String url,String username,String password) throws SQLException
	{   try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url, username, password);
	}catch(Exception e)
	{}

	}
	public void getdbConnection() throws SQLException
	{   try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql//localhost:3306/Projects", "root", "root");
	}catch(Exception e)
	{}

	}
	public void closedbConnection() throws Throwable
	{
		con.close();
	}
	public ResultSet executeSelectQuery(String query) throws Throwable
	{  
		ResultSet result=null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		}catch(Exception e)
		{

		}
		return result;
	}
	public int executeNonSelectQuery(String query) throws Throwable
	{  
		int result=0;
		try {
			Statement stat = con.createStatement();
			result= stat.executeUpdate(query);
		}catch(Exception e)
		{

		}
		return result;
	}

}
