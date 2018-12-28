package com.tanlis.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static DataSource ds=new ComboPooledDataSource();//连接池，数据源 
	
	public static DataSource getDataSource() {
		 return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
