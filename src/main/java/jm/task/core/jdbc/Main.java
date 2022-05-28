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

import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь
        System.out.println(Util.getMySQLConnection().getCatalog());
    }
}
