package com.suleevn.springboot.web.database;


import java.sql.*;

import static com.suleevn.springboot.web.service.TodoService.iddel;


public class dbdelete {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/clients";
        String username = "admin";
        String password = "12345678";
        String sql = "delete from clients where id=?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            stmt.setInt(1, iddel);
            stmt.executeUpdate();

            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}