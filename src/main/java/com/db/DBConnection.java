package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/hospitalapp",
                        "root",
                        "Ankit@07");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}