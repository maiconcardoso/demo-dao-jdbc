package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/coursejdbc?useTimeZone=true&serverTimeZone=UTC";
    private static String username = "root";
    private static String password = "root";

    public static Connection connection = null;

    public static Connection Connection() {
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
