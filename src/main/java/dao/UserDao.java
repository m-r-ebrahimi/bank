package dao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    private final String QUERYADD = "INSERT INTO bank.`user` (name) VALUES(?);";
    private final String QUERYDELTE = "DELETE FROM bank.`user` WHERE id=?;";
    private final String QUERYUPDATE = "UPDATE bank.`user` SET name=? WHERE id=?;";
    private final String QUERYREADBYID = "SELECT * FROM bank.`user` WHERE id=?;";
    private final String QUERYREAD = "SELECT * FROM bank.`user`;";

    private final DataSource dataSource = DbDataSource.createDataSource();
    private PreparedStatement statement;

    public void add(String name) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYADD);
        statement.setString(1, name);
        statement.executeUpdate();
    }


    public void delete(int id) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYDELTE);
        statement.setInt(1, id);
        statement.executeUpdate();
    }


    public void update(String name, int id) throws SQLException {
        statement = dataSource.getConnection().prepareStatement(QUERYUPDATE);
        statement.setString(1, name);
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
