package com.krishighar.dao;

import com.krishighar.pojo.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public User findByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, username);
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}