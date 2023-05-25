package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Callable;

public class SimpleInterest {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_app_db", "root", "Prasad@123");
			CallableStatement statement=conn.prepareCall("{?= call Simple_interest(?,?,?)}");
			
			statement.registerOutParameter(1, Types.DOUBLE);
			statement.setDouble(2, 90000);
			statement.setInt(3, 8);
			statement.setInt(4, 9);
			ResultSet result=  statement.executeQuery();
			
			while(result.next())   
				
			{
				System.out.println(result.getDouble(1));
			}  
			
			
			
			
		} catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}