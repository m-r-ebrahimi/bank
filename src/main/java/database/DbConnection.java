package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DbConfig.DRIVER);
        Connection connection= DriverManager.getConnection(DbConfig.URL,DbConfig.USERNAME,DbConfig.PASSWORD);

        System.out.println("connect");
        return connection;
    }
}
