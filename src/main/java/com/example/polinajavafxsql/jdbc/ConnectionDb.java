package com.example.polinajavafxsql.jdbc;

//STEP 1. Import required packages
import java.sql.*;

public class ConnectionDb {
    //  Database credentials
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/polina";
    private static final String USER = "postgres";
    private static final String PASS = "gandonilya";

    public static Connection connectingToDatabase() {


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }


        Connection connection;
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
