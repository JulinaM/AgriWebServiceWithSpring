package com.krishighar.dao;

import com.krishighar.pojo.db.CropPojo;
import com.krishighar.pojo.db.LocationPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by julina on 10/7/14.
 */
public class CropDao {
    private SessionFactory sessionFactory;

    public List<CropPojo> getCrops(){
        Session session = this.sessionFactory.openSession();
        List<CropPojo> cropPojos = session.createQuery("from CropPojo").list();
        session.close();
        return cropPojos;
    }

    public List<CropPojo> getCropsForLocation(int locationId){
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
