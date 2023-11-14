package com.example.week5day2.dao;

import com.example.week5day2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User getUserById(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, userId);
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User", User.class).list();
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            session.delete(user);
        }
    }

    public Optional<User> loadUserByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("FROM User", User.class).list();
        return users.stream().filter(user -> username.equals(user.getUsername())).findAny();
    }
}
