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
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.cfg.Environment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        UserDao userDao = new UserDaoHibernateImpl();
//
//        // - Создание таблицы User(ов)
//        userDao.createUsersTable();
//        userDao.createUsersTable();
//
//        User user1 = new User("Peregrin", "Took", (byte) 18);
//        User user2 = new User("Frodo", "Baggins", (byte) 17);
//        User user3 = new User("Samwise", "Gamgee", (byte) 21);
//        User user4 = new User("Meriadoc", "Brandybuck", (byte) 20);
//
//        ArrayList<User> listUsers = new ArrayList<>();
//        listUsers.add(user1);
//        listUsers.add(user2);
//        listUsers.add(user3);
//        listUsers.add(user4);
//
//        // - Добавление 4 User(ов) в таблицу с данными на свой выбор
//        listUsers.forEach(user -> userDao.saveUser(user.getName(), user.getLastName(), user.getAge()));
//
//        // - remove user
//        userDao.removeUserById(1);
//
//        // - Получение всех User из базы и вывод в консоль
//        userDao.getAllUsers().forEach(System.out::println);
//
//        // - Очистка таблицы User(ов)
//        userDao.cleanUsersTable();
//
//        // - Удаление таблицы
//        userDao.dropUsersTable();

        final UserService userService = new UserServiceImpl();

        final String testName = "Ivan";
        final String testLastName = "Ivanov";
        final byte testAge = 5;

//        userService.dropUsersTable();
//        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.saveUser(testName, testLastName, testAge);
        userService.saveUser(testName, testLastName, testAge);
        userService.saveUser(testName, testLastName, testAge);
        userService.saveUser(testName, testLastName, testAge);

        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.createUsersTable();
//        userService.createUsersTable();
//        userService.saveUser(testName, testLastName, testAge);
//        userService.removeUserById(1L);
//
//        userService.dropUsersTable();
//        userService.createUsersTable();
//        userService.saveUser(testName, testLastName, testAge);
//        List<User> userList = userService.getAllUsers();
//        System.out.println(userList);

    }
}
