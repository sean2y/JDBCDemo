package com.tencent.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.tencent.util.JDBCUtils;
//test
//test2
public class MainTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from product";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Double price = rs.getDouble("price");
				Timestamp pdate = rs.getTimestamp("pdate");
				int cno = rs.getInt("cno");
				System.out.println("pid=="+pid+"||pname=="+pname+"||price=="+price+"||pdate=="+pdate+"||cno="+cno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, stmt, rs);
		}
	}
}
