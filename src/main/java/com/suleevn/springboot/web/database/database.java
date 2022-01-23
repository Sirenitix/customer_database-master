package com.suleevn.springboot.web.database;

import com.suleevn.springboot.web.controller.TodoController;
import com.suleevn.springboot.web.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class database {
    public static Connection connect = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    public static String url = "jdbc:mariadb://naz.cyvhp4egbnl9.us-east-1.rds.amazonaws.com:3306/asia";
    public static String user = "root", pass = "12345678";

    public static Integer  iddb;
    public static String  fullNameDb;
    public static Integer iinDb;
    public static String  passportDb;
    public static String  dateDb;
    public static String discDb;
    public static String addInfoDb;
    public static String addressDb;
    public static Integer phoneNumberDb;
    public static String propDb;

    public static int countdb;
    public static int indf;
    public static List<Integer>  iddbl = new ArrayList<Integer>();
    public static List<Integer>  idCounter = new ArrayList<Integer>();
    public static List<String>  fullNameDbl = new ArrayList<String>();
    public static List<Integer>  iinDbl = new ArrayList<Integer>();
    public static List<String>  passportDbl = new ArrayList<String>();
    public static List<String>  dateDbl = new ArrayList<String>();
    public static List<String> discDbl = new ArrayList<String>();
    public static List<String> addInfoDbl = new ArrayList<String>();
    public static List<String> addressDbl = new ArrayList<String>();
    public static List<Integer> phoneNumberDbl = new ArrayList<Integer>();
    public static List<String> propDbl = new ArrayList<String>();
    public static Todo hotelResultList;
    public static int size;
    public static Integer maxid;
    static Logger logger = LoggerFactory.getLogger(database.class);


    public static void main(String[] args) {


        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from clients");
            size = 0;


            while(resultSet.next()){
                iddb = resultSet.getInt(1);
                iddbl.add(iddb);
                idCounter.add(iddb);
                fullNameDb = resultSet.getString(2);
                fullNameDbl.add(fullNameDb);
                iinDb = resultSet.getInt(3);
                iinDbl.add(iinDb);
                passportDb = resultSet.getString(4);
                passportDbl.add(passportDb);
                dateDb = resultSet.getString(5);
                dateDbl.add(dateDb);
                discDb = resultSet.getString(6);
                discDbl.add(discDb);
                addInfoDb = resultSet.getString(7);
                addInfoDbl.add(addInfoDb);
                addressDb = resultSet.getString(8);
                addressDbl.add(addressDb);
                phoneNumberDb = resultSet.getInt(9);
                phoneNumberDbl.add(phoneNumberDb);
                propDb = resultSet.getString(10);
                propDbl.add(propDb);
                if(iddbl.size() == 0){
                    countdb = 0;
                }else{
                    countdb = 1;
                }

            }


            if(iddbl.size() != 0){
                 maxid = Collections.max(iddbl);
            }
                else{
                maxid = 1;
            }

            if(maxid != 0){
                indf = maxid + 1;
            }
                else{
                indf = 1;
            }

            logger.info("empty?:" + countdb);
            logger.info("true checker:" + indf);

            if (resultSet != null)
            {
                resultSet.last();    // moves cursor to the last row
                size = resultSet.getRow(); // get row id
                logger.info("size:" + size);
            }
            
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

}





