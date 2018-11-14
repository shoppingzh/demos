package com.littlezheng.databasemetadata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MetadataDemo {
	
	private static final String DATABASE = "test2";
	
	public static void main(String[] args) throws SQLException, IOException {
		printTableAndColumnInfo();
	}
	
	public static void printTableAndColumnInfo() throws SQLException{
		try(Connection conn = JDBCUtils.getConnection()){
			DatabaseMetaData metaData = conn.getMetaData();
			checkDatabaseExists(metaData, DATABASE);
			Set<String> tables = getTables(metaData, null);
			for (String table : tables) {
				// 读取列信息
				System.out.println("=====================" + table + "=====================");
				List<Map<String, Object>> lines = JDBCUtils.getLines(metaData
						.getColumns(DATABASE, null, table, null));
				for (Map<String, Object> map : lines) {
					System.out.println(map.get("COLUMN_NAME"));
				}
			}
		}
	}
	
	private static void checkDatabaseExists(DatabaseMetaData metaData, String database) throws SQLException {
		List<Object> lines = JDBCUtils.getLines(metaData.getCatalogs(), "TABLE_CAT");
		if(database == null || !lines.contains(database)){
			throw new RuntimeException("不存在数据库: " + database);
		}
	}

	// tableNamePattern 如: Tab_% 查询所有名称以Tab_开头的表
	public static Set<String> getTables(DatabaseMetaData metaData, String tableNamePattern)
			throws SQLException {
		List<Map<String, Object>> tableLines = JDBCUtils.getLines(metaData.getTables(
				DATABASE, null, tableNamePattern, new String[] { "TABLE" }));
		Set<String> tables = new HashSet<String>();
		for (Map<String, Object> map : tableLines) {
			tables.add((String) map.get("TABLE_NAME"));
		}
		return tables;
	}
	
}
