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
                    "jdbc:mysql://mysql.railway.internal:3306/railway?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

                String user = "root";
                String password = "XlXTHUwtHdnnmkVIsyWLSJIWECdGniZq";

                con = DriverManager.getConnection(url, user, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}