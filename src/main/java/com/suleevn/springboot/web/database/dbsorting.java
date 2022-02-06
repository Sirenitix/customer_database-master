package com.suleevn.springboot.web.database;

import com.suleevn.springboot.web.controller.TodoController;
import com.suleevn.springboot.web.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import static com.suleevn.springboot.web.database.database.hotelResultList;
import static com.suleevn.springboot.web.service.TodoService.*;

public class dbsorting {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/clients";
        String username = "admin";
        String password = "12345678";
        String sql = null;
        Authentication authentication ;
        UserDetails userDetails ;
        authentication = SecurityContextHolder.getContext().getAuthentication();
        userDetails = (UserDetails) authentication.getPrincipal();

       if(Objects.equals(sortColumn, "fullName")) {
           sql = " select * from clients c where c.user = ? order by c.fullName ";
       }else if(Objects.equals(sortColumn, "iin")) {
           sql = " select * from clients c where c.user = ? order by c.iin";
       }else if(Objects.equals(sortColumn, "passport")){
           sql =" select * from clients c where c.user = ? order by c.passport";
       }else if(Objects.equals(sortColumn, "cr_date")){
           sql =" select * from clients c where c.user = ? order by c.cr_date";
       }else if(Objects.equals(sortColumn, "disc")){
           sql =" select * from clients c where c.user = ? order by c.disc";
       }else if(Objects.equals(sortColumn, "add_inf")){
           sql =" select * from clients c where c.user = ? order by c.add_inf";
       }else if(Objects.equals(sortColumn, "address")){
           sql =" select * from clients c where c.user = ? order by c.address";
       }else if(Objects.equals(sortColumn, "phoneNumber")){
           sql =" select * from clients c where c.user = ? order by c.phoneNumber";
       }else if(Objects.equals(sortColumn, "prop")){
           sql =" select * from clients c where c.user = ? order by c.prop";
       }

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            stmt.setString(1, userDetails.getUsername());
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