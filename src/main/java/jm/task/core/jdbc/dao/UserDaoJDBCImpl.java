package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sqlCommandCreateTable = "CREATE TABLE IF NOT EXITS users " +
                "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), " +
                "lastname VARCHAR(30), age TINYINT)";
    }

    public void dropUsersTable() {
        String sqlCommandDropTableIfExists = "DROP TABLE IF EXISTS users";
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlCommandSaveUser = "INSERT INTO users (name, lastname, age) " +
                                    "VALUES (?, ?, ?)";
        try {
            Util.preparedStatement = Util.connection.prepareStatement(sqlCommandSaveUser);
            Util.preparedStatement.setString(2, "name");
            Util.preparedStatement.setString(3, "lastname");
            Util.preparedStatement.setByte(4, age);
//            Util.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlCommandRemoveUserById = "DELETE FROM TABLE IF EXISTS users WHERE id = ?";
        try {
            Util.preparedStatement = Util.connection.prepareStatement(sqlCommandRemoveUserById);
            Util.preparedStatement.setLong(1, id);
            Util.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sqlCommandGetAllUsers = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        User user;
        try {
            Util.preparedStatement = Util.connection.prepareStatement(sqlCommandGetAllUsers);
            ResultSet resultSet = Util.preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId((long) resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void cleanUsersTable() {

    }
}
