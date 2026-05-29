package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                String url =
                        "jdbc:mysql://nozomi.proxy.rlwy.net:53176/railway?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

                String user = "root";

                String password = "UMUCrsMaiPoehDvHWuAviVjACqbjQRtp";

                con = DriverManager.getConnection(url, user, password);

                System.out.println("Railway MySQL Connected Successfully...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}