package com.example.proyectoi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String servername = "localhost";
    private static final String username = "root";
    private static final String password = "";
    private static final String database = "android";

    public static Connection getConnection() {
        String url = "jdbc:mysql://" + servername + ":3306/" + database;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}