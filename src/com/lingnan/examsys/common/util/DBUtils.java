package com.lingnan.examsys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 */
public class DBUtils {

	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/examsys";
			String user = "root";
			String password = "666666";
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("1获取数据库连接失败！");
			e.printStackTrace();
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println("2获取数据库连接失败！");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 开启事务
	 * 
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("数据库开始Transaction失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("数据库commit失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 回滚事务
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.err.println("数据库事务回滚失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.err.println("关闭数据库连接失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 关闭statement
	 * 
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.err.println("关闭数据库连接或结果集失败！");
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		Connection conn = DBUtils.getConnection();
//		System.out.println(conn+"TestPoint1");
//		DBUtils.closeConnection(conn);
//		System.out.println("TestPoint2");
//	}
}
