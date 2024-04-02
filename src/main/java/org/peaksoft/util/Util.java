package org.peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // TODO: 27.09.2023   реализуйте настройку соеденения с БД

    static String URL = "jdbc:postgresql://localhost:5432/postgres";
    static String name = "postgres";
    static String password = "sami";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return connection;
    }

}
