package com.krishighar.dao;

import com.krishighar.commons.AgriException;
import com.krishighar.commons.ErrorMessages;
import com.krishighar.pojo.db.SubscriberInfoPojo;
import com.krishighar.pojo.db.SubscriptionPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by julina on 10/7/14.
 */
public class SubscriberDao {

    private SessionFactory sessionFactory;

    public void insert(String deviceId, String regId, String phoneNumber ,JSONArray tags) throws
            AgriException.NullPointerException, SQLException {
        if(deviceId == null)
            throw new AgriException.NullPointerException(ErrorMessages.NULL_USER_ID.toString());
        if(tags == null || tags.length() == 0)
            throw new AgriException.NullPointerException(ErrorMessages.NULL_USER_ID.toString());
        Session session =  this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        int length = tags.length();
        List<SubscriptionPojo> subscriptionPojos = new ArrayList<SubscriptionPojo>(length);
        for(int i=0;i<length;i++){
            SubscriptionPojo subscriptionPojo = new SubscriptionPojo();
            subscriptionPojo.setTag(tags.getString(i));
            subscriptionPojos.add(subscriptionPojo);
        }
        SubscriberInfoPojo subscriberInfoPojo = new SubscriberInfoPojo();
        subscriberInfoPojo.setDeviceId(deviceId);
        subscriberInfoPojo.setRegId(regId);
        subscriberInfoPojo.setPhoneNumber(phoneNumber);
        subscriberInfoPojo.setSubscriptionPojos(subscriptionPojos);
        session.persist(subscriberInfoPojo);
        tx.commit();
        session.close();
    }

    public Long getSubscriberCount(){
        Session session = this.sessionFactory.openSession();
        long count = (Long) session.createCriteria(SubscriptionPojo.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return count;
    }

    public HashSet<String> getSubscriberForTags(List<String> tags){
        //TODO
        Session session = this.sessionFactory.openSession();
        List<SubscriberInfoPojo> subscriberInfoPojos = (List<SubscriberInfoPojo>) session.
                createCriteria(SubscriberInfoPojo.class).add(Restrictions.in("tag", tags)).list();
        session.close();
        HashSet<String> deviceIds = new HashSet<String>();
        for(SubscriberInfoPojo subscriptionPojo : subscriberInfoPojos){
            deviceIds.add(subscriptionPojo.getDeviceId());
        }
        return deviceIds;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
