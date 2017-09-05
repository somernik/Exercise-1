package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    public List<User> getAllUsers() {
        Database database = Database.getInstance();

        String sql = "SELECT * FROM users";

        return getUserItems(database, sql);
    }

    private List<User> getUserItems(Database database, String sql) {
        List<User> users = new ArrayList<User>();
        Connection connection = null;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            loopOverResultSet(users, results);
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getUserItems()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getUserItems()...Exception: " + e);
        }

        return users;
    }

    private void loopOverResultSet(List<User> users, ResultSet results) throws SQLException {
        while (results.next()) {
            User employee = createUserFromResults(results);
            users.add(employee);
        }
    }

    //TODO add a method or methods to return a single user based on search criteria - DONE
    public User getSingleUser(String searchType, String searchValue, String searchOperator) {
        Database database = Database.getInstance();
        Connection connection = null;
        User employee = new User();

        String sql = buildSQLStatement(searchType, searchValue, searchOperator);

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            if (results.next()) {
                employee = createUserFromResults(results);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getSingleUser()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getSingleUser()...Exception: " + e);
        }

        return employee;
    }

    public List<User> getSpecificUsers(String searchType, String searchValue, String searchOperator) {
        Database database = Database.getInstance();

        String sql = buildSQLStatement(searchType, searchValue, searchOperator);

        return getUserItems(database, sql);
    }

    private String buildSQLStatement(String searchType, String searchValue, String searchOperator) {

        if(searchType.equals("f_name")) {
            searchType = "first_name";
        } else if (searchType.equals("l_name")) {
            searchType = "last_name";
        }

        String sql ="SELECT * FROM users WHERE " + searchType + " ";

        if (searchOperator.equals("=")) {
             sql += searchOperator + " '" + searchValue + "'";
        } else if (searchOperator.equals("LIKE")) {
            sql += searchOperator + " '%" + searchValue + "%'";
        }

        return sql;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setBirthDate(results.getDate("date_of_birth"));
        return user;
    }

}