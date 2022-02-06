package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.suleevn.springboot.web.controller.NewUserController.*;
import static com.suleevn.springboot.web.controller.TodoController.*;



public class dbAddUser
{


    public static void main(String[] args)
    {

        try
        {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/clients";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "admin", "12345678");



            String query = " insert into user (login, password, role, enabled)"
                    + " values (?, ?, ?, ?)";


            PreparedStatement preparedStmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStmt.setString (1, loginAdd );
            preparedStmt.setString (2, "{noop}"+ passwordAdd);
            preparedStmt.setString (3,  roleAdd);
            preparedStmt.setString (4,  enabledAdd);



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
