package com.keduit.utill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
public static Connection getConnection() {
		
		Connection conn = null;
		try { Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource ds =(DataSource) envContext.lookup("jdbc/myoracle"); // 이부분은 서버의 context.xml 과 일치해야함.
				
				conn = ds.getConnection();
						
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
