package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    // Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
    public void createUsersTable() {

    }

    // Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
    public void dropUsersTable() {

    }

    // Добавление User в таблицу
    public void saveUser(String name, String lastName, byte age) {

    }

    // Удаление User из таблицы (по id)
    public void removeUserById(long id) {

    }

    // Получение всех User(ов) из таблицы
    public List<User> getAllUsers() {
        return null;
    }

    // Очистка содержания таблицы
    public void cleanUsersTable() {

    }
}
