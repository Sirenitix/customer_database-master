package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.suleevn.springboot.web.controller.TodoController.*;
import static com.suleevn.springboot.web.database.database.indf;



public class dbadd
{


    public static void main(String[] args)
    {

        try
        {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/clients";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "admin", "12345678");



            String query = " insert into clients (id, fullName, iin,  passport, cr_date, disc, add_inf, address, phoneNumber, prop, user)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


            PreparedStatement preparedStmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStmt.setInt (1, indf );
            preparedStmt.setString (2, fullNameAdd);
            preparedStmt.setInt (3,  iinAdd);
            preparedStmt.setString (4, passportAdd);
            preparedStmt.setString   (5, dateAdd);
            preparedStmt.setString   (6, discAdd);
            preparedStmt.setString   (7, addInfoAdd);
            preparedStmt.setString   (8, addressAdd);
            preparedStmt.setInt   (9, phoneNumberAdd);
            preparedStmt.setString   (10, propAdd);
            preparedStmt.setString   (11, userAdd);



            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
