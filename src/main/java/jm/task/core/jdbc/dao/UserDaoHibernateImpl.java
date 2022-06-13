package jm.task.core.jdbc.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import jakarta.persistence.criteria.CriteriaDelete;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;


import java.util.ArrayList;
import java.util.List;

// Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
// должны быть реализованы с помощью SQL.

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = null;

    public UserDaoHibernateImpl() {
    }

    private void nativeSQL(String nativeSQL) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeMutationQuery(nativeSQL);
            session.getTransaction().commit();
            System.out.println(nativeSQL);
        }
    }

    @Override
    public void createUsersTable() {
        String sqlCreateTable = """
                CREATE TABLE IF NOT EXISTS users (
                id SERIAL PRIMARY KEY ,
                name TEXT NOT NULL ,
                last_name TEXT NOT NULL ,
                age TINYINT NOT NULL )
                """;
        nativeSQL(sqlCreateTable);
    }

    @Override
    public void dropUsersTable() {
        String sqlDropTable = "DROP TABLE IF EXISTS users";
        nativeSQL(sqlDropTable);
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(user);

        session.getTransaction().commit();
        session.close();
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }

    @Override
    public void removeUserById(long id) {

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = session.getReference(User.class, id);
        session.remove(user);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = builder.createQuery(User.class);
        userCriteriaQuery.from(User.class);
        users = session.createQuery(userCriteriaQuery).list();

        session.getTransaction().commit();
        session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        getAllUsers().forEach(user -> removeUserById(user.getId()));
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            return Util.getSessionFactory();
        }
        return sessionFactory;
    }
}
