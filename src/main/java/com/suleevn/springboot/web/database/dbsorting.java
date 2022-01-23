package com.suleevn.springboot.web.database;

import com.suleevn.springboot.web.controller.TodoController;
import com.suleevn.springboot.web.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import static com.suleevn.springboot.web.database.database.hotelResultList;
import static com.suleevn.springboot.web.service.TodoService.*;

public class dbsorting {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/asia";
        String username = "root";
        String password = "12345678";
        String sql = null;

       if(Objects.equals(sortColumn, "fullName")) {
           sql = " select * from clients order by fullName";
       }else if(Objects.equals(sortColumn, "iin")) {
           sql = " select * from clients order by iin";
       }else if(Objects.equals(sortColumn, "passport")){
           sql =" select * from clients order by passport";
       }else if(Objects.equals(sortColumn, "cr_date")){
           sql =" select * from clients order by cr_date";
       }else if(Objects.equals(sortColumn, "disc")){
           sql =" select * from clients order by disc";
       }else if(Objects.equals(sortColumn, "add_inf")){
           sql =" select * from clients order by add_inf";
       }else if(Objects.equals(sortColumn, "address")){
           sql =" select * from clients order by address";
       }else if(Objects.equals(sortColumn, "phoneNumber")){
           sql =" select * from clients order by phoneNumber";
       }else if(Objects.equals(sortColumn, "prop")){
           sql =" select * from clients order by prop";
       }

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
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

            System.out.println("Records successfully sorted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}