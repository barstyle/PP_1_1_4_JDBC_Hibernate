package jm.task.core.jdbc.dao;

import com.mysql.cj.jdbc.JdbcConnection;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    private void ddlSqlCommand(String sqlCommand) {
        try (Statement statement = Util.getMySQLConnection().createStatement()) {
            statement.execute(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dmlSqlCommand(String sqlCommand) {
        try (PreparedStatement statement = Util.getMySQLConnection().prepareStatement(sqlCommand)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
    public void createUsersTable() {
        String sqlCreateTable = """
                CREATE TABLE IF NOT EXISTS users (
                id SERIAL PRIMARY KEY ,
                name TEXT NOT NULL ,
                last_name TEXT NOT NULL ,
                age TINYINT NOT NULL )
                """;
        ddlSqlCommand(sqlCreateTable);
    }

    // Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
    public void dropUsersTable() {
        String sqlDropTable = "DROP TABLE IF EXISTS users";
        ddlSqlCommand(sqlDropTable);

    }

    // Добавление User в таблицу
    public void saveUser(String name, String lastName, byte age) {

        String sqlInsertInto = "INSERT INTO users (name, last_name, age) " +
                               "VALUES ('" + name + "', '" + lastName + "' , " + age + ");";

        dmlSqlCommand(sqlInsertInto);
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);

    }

    // Удаление User из таблицы (по id)
    public void removeUserById(long id) {
        String sqlDeleteUserFromId = "DELETE FROM users WHERE id = " + id;
        dmlSqlCommand(sqlDeleteUserFromId);

    }

    // Получение всех User(ов) из таблицы
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String sqlGetAllUsers = "SELECT  * FROM users";

        try (Statement statement = Util.getMySQLConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlGetAllUsers);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    // Очистка содержания таблицы
    public void cleanUsersTable() {
        String sqlCleanTable = "TRUNCATE users";
        ddlSqlCommand(sqlCleanTable);

    }
}
