package com.me.eightExample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleTypes;

public class JDBCTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@173.61.131.10:1521:xe";
		Connection conn = DriverManager.getConnection(url, "jeff", "123456");

		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
		while (rset.next()) {
			System.out.println(rset.getString(1));
		}
		stmt.close();
		System.out.println("Ok.");
	}

	public void preparedStatment() throws ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the name");
		String name = scanner.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@173.61.131.10:1521:xe";
		try {
			Connection conn = DriverManager
					.getConnection(url, "jeff", "123456");
			Statement st = conn.createStatement();
			String sql = "select * from table1 where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t"
						+ rs.getInt("Age"));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void callableStatement(String[] args) throws SQLException,
			ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@173.61.131.10:1521:xe";
			Connection conn = DriverManager
					.getConnection(url, "jeff", "123456");
			String sp = "{? = call saveUser(?,?)}";
			CallableStatement cs = conn.prepareCall(sp);
			// cs.registerOutParameter(1, Types.INTEGER);
			// cs.setString(2, "David");
			// cs.setInt(3, 53);
			// cs.execute();
			// System.out.println("Returned value: " + cs.getInt(1));
			//
			sp = "{? = call queryUser()}";
			cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t"
						+ rs.getInt("Age"));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}