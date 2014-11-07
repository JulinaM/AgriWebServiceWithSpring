package com.krishighar.dao;

import com.krishighar.pojo.db.SubscriberInfoPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by subhashacharya on 11/2/14.
 */
public class GcmInfoDao {
    private SessionFactory sessionFactory;

    public List<String> getRegistrationIdsForDevices(HashSet<String> deviceId){
        Session session = this.sessionFactory.openSession();
        List<SubscriberInfoPojo> subscriberInfoPojos = (List<SubscriberInfoPojo>) session.createCriteria(SubscriberInfoPojo.class).add(Restrictions.in("deviceId", deviceId)).list();
        session.close();
        List<String> deviceIds = new ArrayList<String>();
        for(SubscriberInfoPojo subscriberInfoPojo : subscriberInfoPojos){
            deviceIds.add(subscriberInfoPojo.getRegId());
        }
        return deviceIds;
    }

    public Long getUsersCount(){
        Session session = this.sessionFactory.openSession();
        long count = (Long) session.createCriteria(SubscriberInfoPojo.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return count;
    }

    public SubscriberInfoPojo registerGCM(String deviceId, String registrationId){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SubscriberInfoPojo subscriberInfoPojo = (SubscriberInfoPojo) session.get(SubscriberInfoPojo.class,deviceId);
        if(subscriberInfoPojo != null){
            subscriberInfoPojo.setRegId(registrationId);
            session.update(subscriberInfoPojo);
        }
        tx.commit();
        session.close();
        return subscriberInfoPojo;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
