package com.tencent.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	
	static String url = null;
	static String name = null;
	static String password = null;
	static String driverClass = null;
	
	static{
		try {
			Properties properties = new Properties();
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
			properties.load(is);
			
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	JDBCUtils.class.
	}
	public static Connection getConnection(){
		Connection conn = null;
		getDriver();
		try {
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	} 
	private static void getDriver(){
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void release(Connection conn, Statement stmt, ResultSet rs){
		closeRs(rs);
		closeStmt(stmt);
		closeConn(conn);
	}
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	private static void closeStmt(Statement stmt){
		try {
			if(stmt != null){				
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			stmt = null;
		}
	}
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
