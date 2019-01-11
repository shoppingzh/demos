package com.littlezheng.jdbcbatchinsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Util {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择: 1.检索所有数据     2.删除所有数据     0.关闭");
            String cmd = scanner.nextLine();
            if ("1".equals(cmd)) {
                select();
                System.out.println("\n\n");
            } else if ("2".equals(cmd)) {
                delete();
                System.out.println("\n\n");
            } else if ("0".equals(cmd)) {
                scanner.close();
                System.exit(0);
            }
        }
    }

    public static void select() {
        try (Connection conn = JDBCUtils.getConnection()) {
            String sql = "SELECT * FROM T_User";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Map<String, Object>> lines = JDBCUtils.getLines(ps.executeQuery());
            if (lines != null) {
                System.out.println(" =============== SELECT DATA ===============");
                for (Map<String, Object> line : lines) {
                    System.out.println(line);
                }
                System.out.println("共计: " + lines.size() + "条");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        try (Connection conn = JDBCUtils.getConnection()) {
            String sql = "DELETE FROM T_User";
            PreparedStatement ps = conn.prepareStatement(sql);
            int cnt = ps.executeUpdate();
            System.out.println("删除行数: " + cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
