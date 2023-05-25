package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class StudentExample {

	public static void main(String[] args) {
		Connection conn=null;
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase\", \"root\", \"Prasad@123");
			conn.setAutoCommit(false);	//setting autocommit to false
			
			if(conn!=null)
			{
				System.out.println("Connection established");
			}
			else
			{
				System.out.println("Connection failed");
			}
			
			
			
			
			PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 11);
			ps.setString(2, "Karthik");
			ps.setString(3, "high school");
			ps.setInt(4, 355);
			
			PreparedStatement ps1=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 12);
			ps.setString(2, "Jyoti");
			ps.setString(3, "high school");
			ps.setInt(4, 356);
			
			PreparedStatement ps2=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 13);
			ps.setString(2, "Jaypee");
			ps.setString(3, "high school");
			ps.setInt(4, 357);
			
			PreparedStatement ps3=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 14);
			ps.setString(2, "Abhishek");
			ps.setString(3, "high school");
			ps.setInt(4,358 );
			
			PreparedStatement ps4=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 15);
			ps.setString(2, "Priya");
			ps.setString(3, "high school");
			ps.setInt(4, 359);
			
			
			Savepoint s1=conn.setSavepoint("s1");
			ps.executeUpdate();
			PreparedStatement ps5=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 16);
			ps.setString(2, "Pooja");
			ps.setString(3, "high school");
			ps.setInt(4, 360);
			
			PreparedStatement ps6=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 17);
			ps.setString(2, "Purva");
			ps.setString(3, "high school");
			ps.setInt(4, 361);
			
			PreparedStatement ps7=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 18);
			ps.setString(2, "Vaishnavi");
			ps.setString(3, "high school");
			ps.setInt(4, 362);
			
			PreparedStatement ps8=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 19);
			ps.setString(2, "Vishal");
			ps.setString(3, "high school");
			ps.setInt(4, 363);
			
			PreparedStatement ps9=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, 20);
			ps.setString(2, "Vivek");
			ps.setString(3, "high school");
			ps.setInt(4, 364);
			
			
			Savepoint s2=conn.setSavepoint("s1");
		
			
			ps.executeUpdate();
			
			conn.rollback(s1);
			
			
			conn.commit();
			System.out.println("Transaction commited!!");
			
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			
			
			System.out.println(e.getMessage());
		}
		
		finally
		{
			//closing connection
			try
			{
				conn.close();
			} 
			catch (SQLException e) {


				System.out.println(e.getMessage());
			}

	}

	}
}