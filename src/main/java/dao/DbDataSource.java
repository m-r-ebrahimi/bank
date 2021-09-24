package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DbDataSource {
    public static DataSource createDataSource() {
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setURL(DbConfig.URL);
        mysqlDataSource.setUser(DbConfig.USERNAME);
        mysqlDataSource.setPassword(DbConfig.PASSWORD);
        return mysqlDataSource;
    }
}
