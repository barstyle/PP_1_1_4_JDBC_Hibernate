package jm.task.core.jdbc;

/*
 В методе main класса Main должны происходить следующие операции:

 - Создание таблицы User(ов)
 - Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть
 вывод в консоль (User с именем – name добавлен в базу данных)
 - Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
 - Очистка таблицы User(ов)
 - Удаление таблицы
 */

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();

        // - Создание таблицы User(ов)
        userDao.createUsersTable();

        User user1 = new User("Peregrin", "Took", (byte) 18);
        User user2 = new User("Frodo", "Baggins", (byte) 17);
        User user3 = new User("Samwise", "Gamgee", (byte) 21);
        User user4 = new User("Meriadoc", "Brandybuck", (byte) 20);

        ArrayList<User> listUsers = new ArrayList<>();
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        listUsers.add(user4);

        // - Добавление 4 User(ов) в таблицу с данными на свой выбор
        listUsers.forEach(user -> userDao.saveUser(user.getName(), user.getLastName(), user.getAge()));

        // - Получение всех User из базы и вывод в консоль
        userDao.getAllUsers().forEach(System.out::println);

        // - Очистка таблицы User(ов)
        userDao.cleanUsersTable();

        // - Удаление таблицы
        userDao.dropUsersTable();
    }
}
