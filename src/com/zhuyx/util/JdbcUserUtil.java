/**
 * 
 * JdbcUtil.java
 * Administrator
 * 2017年4月14日 上午11:08:18
 * QQ : 2951589923
 * 
 */
package com.zhuyx.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.zhuyx.model.User;

/**
 * @author Administrator
 *
 */
public final class JdbcUserUtil {

	private static String DRIVER;
	private static String USERNAME;
	private static String PASSWORD;
	private static String URL;
	// 定义数据库的连接
	private Connection connection;
	//
	/**
	 * 定义sql语句的执行对象 1、将sql语句与参数隔离，便于维护 2、防止sql注入
	 */
	private PreparedStatement psStatement;
	// 定义查询返回的结果集合
	private ResultSet resultSet;
	static {
		// 加载配置文件
		loadProperties();
	}

	private static void loadProperties() {
		try {
			InputStream inStream = JdbcUserUtil.class.getResourceAsStream("/jdbcUser.properties");
			Properties properties = new Properties();
			properties.load(inStream);
			DRIVER = properties.getProperty("jdbc.driver");
			USERNAME = properties.getProperty("jdbc.username");
			PASSWORD = properties.getProperty("jdbc.password");
			URL = properties.getProperty("jdbc.url");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库的连接 2017年4月14日 上午11:24:54 Administrator
	 */
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("数据库连接异常", e);
		}
		return connection;
	}

	/**
	 * 执行更新、插入操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            2017年4月14日 上午11:26:24 Administrator
	 */
	public boolean updateByPreparedStatement(String sql, String... params) throws SQLException {
		// 表示当用户执行添加删除和修改的时候所影响数据库的行数
		int result = -1;
		psStatement = connection.prepareStatement(sql);
		int index = 1;
		// 填充sql语句中的点位符
		if (null != params && params.length > 0) {
			for (Object object : params) {
				psStatement.setObject(index++, object);
			}
		}
		result = psStatement.executeUpdate();
		return result > 0;
	}
	

	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 *             2017年4月14日 上午11:37:01 Administrator
	 */
	public boolean findResult(String sql, List<?> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		int index = 1;
		psStatement = connection.prepareStatement(sql);
		if (null != params && !params.isEmpty()) {
			for (Object object : params) {
				psStatement.setObject(index++, object);
			}
		}
		resultSet = psStatement.executeQuery();
		ResultSetMetaData metaData = psStatement.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < columnCount; i++) {
				String columnName = metaData.getColumnName(i + 1);
				Object object = resultSet.getObject(columnName);
				if (null == object) {
					object = "";
				}
				map.put(columnName, object);
			}
			list.add(map);
		}
		return !list.isEmpty();
	}

	/**
	 * 释放资源
	 * 
	 * 2017年4月14日 上午11:43:29 Administrator
	 */
	public void releaseConn() {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != psStatement) {
			try {
				psStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
