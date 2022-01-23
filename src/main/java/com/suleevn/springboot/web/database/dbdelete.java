package com.suleevn.springboot.web.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.suleevn.springboot.web.service.TodoService.iddel;


public class dbdelete {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/asia";
        String username = "root";
        String password = "12345678";
        String sql = "delete from clients where id=?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, iddel);
            stmt.executeUpdate();

            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}