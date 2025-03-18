package com.community.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class MyOracleConnection {
	private static final String DB_URL = "jdbc:oracle:thin:@222.108.36.144:11521:XE";
	private static final String DB_ID = "db_house";
	private static final String DB_PW = "1111";
	
	public DataSource myOracleDataSource() {
		OracleConnectionPoolDataSource obj = null;
		try {
			obj = new OracleConnectionPoolDataSource();
			obj.setURL(DB_URL);
			obj.setUser(DB_ID);
			obj.setPassword(DB_PW);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return obj;
	}
	
	public Connection oracleConn() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			if (conn != null) {
				System.out.println("Connect Successful");
			} else {
				System.out.println("Connect Failed");
			}
			String sql = "select * from users";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	public void oracleClose(Connection conn, PreparedStatement ps, ResultSet rs) {
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
