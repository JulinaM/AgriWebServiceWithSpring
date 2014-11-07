package com.krishighar.dao;

import com.krishighar.pojo.db.CropPojo;
import com.krishighar.pojo.db.LocationPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by julina on 10/6/14.
 */
public class LocationDao {
    private SessionFactory sessionFactory;

    public void insert(LocationPojo locationPojoA){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(locationPojoA);
        tx.commit();
        session.close();
    }

    public List<LocationPojo> getLocations(){
        Session session = this.sessionFactory.openSession();
        List<LocationPojo> locationPojoAs = session.createQuery("from LocationPojo").list();
        session.close();
        return locationPojoAs;
    }

    public long getLocationCount(){
        Session session = sessionFactory.openSession();
        long count =  (Long) session.createCriteria(LocationPojo.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return count;
    }

    @Transactional
    public List<CropPojo> getCrops(int locationId){
        Session session = this.sessionFactory.openSession();
        List<CropPojo> crops =  ((LocationPojo)session.get(LocationPojo.class,locationId)).getCrops();
        session.close();
        return crops;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
