package com.suleevn.springboot.web.database;

import com.suleevn.springboot.web.controller.TodoController;
import com.suleevn.springboot.web.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

import static com.suleevn.springboot.web.database.database.hotelResultList;
import static com.suleevn.springboot.web.service.TodoService.fullNameKey;
import static com.suleevn.springboot.web.service.TodoService.todos;

public class dbsearch {
    public static ArrayList<String> hotelResultList;

    private  static  Logger logger = LoggerFactory.getLogger(dbsearch.class);

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/asia";
        String username = "root";
        String password = "12345678";
        String sql = "select * from clients where lower(fullName) like ?";



        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + fullNameKey.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            hotelResultList = new ArrayList<>(columnCount);
            todos.clear();
            while (rs.next()) {
                // Retrieve by column name
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setFullName(rs.getString("fullName"));
                todo.setIin(rs.getInt("iin"));
                todo.setPassport(rs.getString("passport"));
                todo.setDate(rs.getString("cr_date"));
                todo.setDisc(rs.getString("disc"));
                todo.setAdd_inf(rs.getString("add_inf"));
                todo.setAddress(rs.getString("address"));
                todo.setPhoneNumber(rs.getInt("phoneNumber"));
                todo.setProp(rs.getString("prop"));
                todos.add(todo);
            }
            rs.close();
            logger.info("Search result:" + hotelResultList);

            System.out.println("Record successfully searches");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
