package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


	public class DeleteDynamicExample {

		public static void main(String[] args) throws NumberFormatException, IOException {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			Connection conn=null;
			try 
			{
				//Driver class name
				Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8
				
				//creating a connection
				
				
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase", "root", "Prasad@123");
				
				
				if(conn!=null)
				{
					System.out.println("Connection established");
				}
				else
				{
					System.out.println("Connection failed");
				}
				
				PreparedStatement preparedStatement=conn.prepareStatement("delete from user where designation=?");
				
				System.out.println("employee designation:");
				preparedStatement.setString(1, br.readLine());
						
				
				preparedStatement.execute();
				
				System.out.println("Record updated!!");
				
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
