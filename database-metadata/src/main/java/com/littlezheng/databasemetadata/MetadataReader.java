package com.littlezheng.databasemetadata;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MetadataReader {
	
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	static {
		try (InputStream in = MetadataReader.class.getClassLoader()
				.getResourceAsStream("jdbc.properties")) {
			if(in != null){
				Properties prop = new Properties();
				prop.load(in);
				URL = prop.getProperty("jdbcUrl");
				USER = prop.getProperty("user");
				PASSWORD = prop.getProperty("password");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		DatabaseMetaData metaData = conn.getMetaData();
		Set<String> tables = getTables(metaData);
		for (String table : tables) {
			System.out.println("=====================" + table + "=====================");
			List<Map<String, Object>> lines = getLines(metaData.getColumns(null, null, table, null));
			for (Map<String, Object> map : lines) {
				System.out.println(map.get("COLUMN_NAME"));
			}
		}
	}
	
	public static Set<String> getTables(DatabaseMetaData metaData)
			throws SQLException {
		List<Map<String, Object>> tableLines = getLines(metaData.getTables(
				null, null, null, new String[] { "table" }));
		Set<String> tables = new HashSet<String>();
		for (Map<String, Object> map : tableLines) {
			tables.add((String) map.get("TABLE_NAME"));
		}
		return tables;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getLines(ResultSet rs)
			throws SQLException {
		if (rs == null) {
			return Collections.EMPTY_LIST;
		}
		List<Map<String, Object>> lines = new ArrayList<Map<String, Object>>();
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (rs.next()) {
			Map<String, Object> lineMap = new HashMap<String, Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				lineMap.put(metaData.getColumnName(columnIndex),
						rs.getObject(columnIndex));
			}
			lines.add(lineMap);
		}
		return lines;
	}
	
}
