package com.jdbc_dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetch_By_Id{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	
		System.out.println("*** Start ***");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id To Fetch the Data");
		int id = sc.nextInt();
		System.out.println();

//		Step-1 : Load & register the driver 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Step-2 : Establish the connection 
// 		Copy the connection path from mysql connection and give schema name , user, password 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_static", "root", "12345");
		
//		Step-3 : Create a Statement
		
		PreparedStatement pes = con.prepareStatement("SELECT * FROM demo_table WHERE id = ? ");
//		prepareStatement is used to create a dynamic statement
		
		pes.setInt(1, id);
		
//		Step-4 : Execute the statement
		
		ResultSet result = pes.executeQuery();
		
//		Step-5 : Process the result
		
		while(result.next())
		{
			System.out.println("Id = "+result.getInt(1));
			System.out.println("Name = " +result.getString(2));
			System.out.println("Contact Number = "+result.getString(3));
		}
		System.out.println();
		
//		Step-6 : Close the db connection

		pes.close();
		con.close();
		
		System.out.println("*** End ***");
		
	}
}