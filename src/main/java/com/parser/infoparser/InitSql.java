package com.parser.infoparser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InitSql {
	static final String DB_URL = "jdbc:mysql://localhost:3306/avito_data?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
	static final String PASS = "root";
	
	public static InitSqlGetSet sql_select_count(String sql) throws SQLException {
		final InitSqlGetSet result = new InitSqlGetSet();
		Connection conn = null;
		Statement stmt = null;  
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);	
			while (rs.next()) {
				result.setCount(rs.getInt(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{if(stmt!=null)conn.close();}catch(SQLException se){}
			try{if(conn!=null)conn.close();}catch(SQLException se){se.printStackTrace();}
		}
		return result;
	}
	
	public static ArrayList<InitSqlGetSet> sql_select(String sql) throws SQLException {
		ArrayList<InitSqlGetSet> result = new ArrayList<InitSqlGetSet>();
		Connection conn = null;
		Statement stmt = null;  
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				InitSqlGetSet list = new InitSqlGetSet();
				list.setPrice_col(rs.getString(1));
				result.add(list);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{if(stmt!=null)conn.close();}catch(SQLException se){}
			try{if(conn!=null)conn.close();}catch(SQLException se){se.printStackTrace();}
		}
		return result;
	}
	
	public static InitSqlGetSet sql_insert(String sql) throws SQLException {
		Connection conn = null;
		Statement stmt = null;  
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{if(stmt!=null)conn.close();}catch(SQLException se){}
			try{if(conn!=null)conn.close();}catch(SQLException se){se.printStackTrace();}
		}
		return null;
	}
}
