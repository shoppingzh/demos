package com.littlezheng.jdbcbatchinsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * 批量提交以1000为单位，每1000条数据插入一次<br>
 * 
 * ============== SQL Server ================<br>
 * 1000条数据<br>
 * 批量提交：822ms、1507ms、829ms<br>
 * 非批量提交：1369ms、1140ms、1204ms<br>
 * <br>
 * 
 * 5000条数据<br>
 * 批量提交：881ms、852ms、875ms<br>
 * 非批量提交：3144ms、2900ms、3443ms<br>
 * <br>
 * 
 * 1万条数据<br>
 * 批量提交：948ms、990ms<br>
 * 非批量提交：3834ms、4380ms<br>
 * <br>
 * 
 * 10万条数据<br>
 * 批量提交：3115ms、2242ms<br>
 * 非批量提交：35004ms、49489ms<br>
 * <br>
 * 
 * 100万条数据<br>
 * 批量提交：22564ms<br>
 * 非批量提交：- <br>
 * <br>
 * 
 * @author shoppingzh
 *
 */
public class BatchInsertDemo {

    static Random ran = new Random();
    static final int CNT = 1000000;
    static final int BATCH_CNT = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择: 1.批量提交   2.非批量提交");
        String cmd = scanner.nextLine();
        if ("1".equals(cmd)) {
            batchInsert();
        } else if ("2".equals(cmd)) {
            unbatchInsert();
        } else {
            System.exit(2);
        }
        scanner.close();
    }

    public static void batchInsert() {
        long start = System.currentTimeMillis();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO T_User (name, age) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 1; i <= CNT; i++) {
                ps.setString(1, "zzz");
                ps.setInt(2, ran.nextInt(120));
                ps.addBatch();
                if (i % BATCH_CNT == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
            System.out.println("插入" + CNT + "条数据, 用时: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                } finally {
                    JDBCUtils.closeQuietly(conn);
                }
            }
        }
    }

    public static void unbatchInsert() {
        long start = System.currentTimeMillis();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO T_User (name, age) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i <= CNT; i++) {
                ps.setString(1, "zzz");
                ps.setInt(2, ran.nextInt(120));
                ps.executeUpdate();
            }
            System.out.println("插入" + CNT + "条数据, 用时: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            JDBCUtils.closeQuietly(conn);
        }

    }

}
