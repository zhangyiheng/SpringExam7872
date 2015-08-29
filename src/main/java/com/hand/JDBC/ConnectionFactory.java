package com.hand.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String username;
	private static String password;
	private static String driver;
	private static String dburl;

	private static Connection conn;

	private static final ConnectionFactory factory = new ConnectionFactory();

	static {
		Properties properties = new Properties();

		try {

			InputStream is = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("com/hand/JDBC/dbconnection.properties");
			properties.load(is);

			username = properties.getProperty("user");
			password = properties.getProperty("password");
			driver = properties.getProperty("MysqlDriver");
			dburl = properties.getProperty("dbUrl");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private ConnectionFactory() {

	}

	public static ConnectionFactory getinstance() {
		return factory;
	}

	public static Connection getConnection() {
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
