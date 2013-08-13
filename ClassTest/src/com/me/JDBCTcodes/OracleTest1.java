package com.me.JDBCTcodes;

import java.sql.*;

public class OracleTest1 {

	public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static String URL = "jdbc:oracle:thin:@173.61.131.10:1521:xe";
	public static String USERNAME = "jeff";
	public static String PASSWORD = "123456";

	public static void main(String[] args){
		
		try{
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement st = conn.createStatement();
			String sql = "insert into sample values ('jeff', 25)";
			st.executeQuery(sql);
			sql = "select * from sample";
			ResultSet rs = st.executeQuery(sql); 
			while(rs.next()){
				System.out.println(rs.getString("Name") + " " + rs.getInt("Age"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
