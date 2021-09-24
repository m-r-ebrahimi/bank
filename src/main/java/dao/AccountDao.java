package dao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private final String QUERYADD = "INSERT INTO bank.account (balance) VALUES(?);";
    private final String QUERYDELTE = "DELETE FROM bank.account WHERE id=?;";
    private final String QUERYUPDATE = "UPDATE bank.account SET balance=? WHERE id=?;";
    private final String QUERYREADBYID = "SELECT * FROM bank.account WHERE id=?;";
    private final String QUERYREAD = "SELECT * FROM bank.account;";

    private final DataSource dataSource = DbDataSource.createDataSource();
    private PreparedStatement statement;

    public void add(int balance) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYADD);
        statement.setInt(1, balance);
        statement.executeUpdate();
    }


    public void delete(int id) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYDELTE);
        statement.setInt(1, id);
        statement.executeUpdate();
    }


    public void update(int balance, int id) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYUPDATE);
        statement.setInt(1, balance);
        statement.setInt(2, id);
        statement.executeUpdate();
    }


    public ResultSet readById(int id) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYREADBYID);
        statement.setInt(1, id);
        return statement.executeQuery();
    }


    public ResultSet read() throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYREAD);
        return statement.executeQuery();
    }
}
