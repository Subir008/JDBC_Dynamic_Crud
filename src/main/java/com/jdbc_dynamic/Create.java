package com.jdbc_dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Create{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		System.out.println("***Start***");
		
//		First take the data from the User with the help of Scanner Class
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter Conact Number");
		String contact = sc.next();
		System.out.println();
		
		
//		Step-1 : Load & register the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Step-2 : Establish the connection 
// 		Copy the connection path from mysql connection and give schema name , user, password 

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_static", "root", "12345");
		
//		Step-3 : Create a Statement

		PreparedStatement pes = con.prepareStatement("INSERT INTO demo_table values (?,?,?)");
//		prepareStatement is used to create a dynamic statement which return PreparedStatement Interface
		
		pes.setInt(1, id);
		pes.setString(2, name);
		pes.setString(3, contact);
		
//		Step-4 : Execute the statement
		
		boolean result = pes.execute();
		

//		Step-5 : Process the result
		
		System.out.println(result);
		
//		Step-6 : Close the db connection
		
		pes.close();
		con.close();
		
		System.out.println("***End***");
	}
}

