package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import com.google.common.primitives.Ints;

import static com.suleevn.springboot.web.controller.TodoController.*;


public class dbupdate {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3307/clients";
        String username = "root";
        String password = "";
        String setnamesql = "update clients set fullName=?, iin=?,  passport=?, cr_date=?,  disc=?, add_inf=?, address=?, phoneNumber=?, prop=?  where id=?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(setnamesql);) {

            stmt.setString (1, fullNameUpd);
            stmt.setInt (2, iinUpd);
            stmt.setString (3, passportUpd);
            stmt.setString   (4, dateUpd);
            stmt.setString   (5, discUpd);
            stmt.setString   (6, addInfoUpd);
            stmt.setString   (7, addressUpd);
            stmt.setInt   (8, phoneNumberUpd);
            stmt.setString   (9, propUpd);

            stmt.setInt(10, idUpd);


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
