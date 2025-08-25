package com.example.worknestapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.worknestapp.model.User;

@Repository
public class UserDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
    
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    
    /*public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username = :username");
        query.setParameter("username, username);
        return (User) query.getSingleResult();
    }*/

}
