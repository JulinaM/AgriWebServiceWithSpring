package com.krishighar.dao;

import com.krishighar.pojo.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

/**
 * Created by subhashacharya on 11/1/14.
 */
public class UserDao2 {

    private SessionFactory sessionFactory;

    public long getUsersCount(){
        Session session = this.sessionFactory.openSession();
        long count = (Long) session.createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return count;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
