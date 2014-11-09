package com.krishighar.dao;

import com.krishighar.pojo.db.GcmPublishPojo;
import com.krishighar.pojo.db.InfoClientPojo;
import com.krishighar.pojo.db.InfoPojo;
import com.krishighar.pojo.db.LocationsCropPojo;
import com.krishighar.resource.InfoClient;
import com.mkyong.customer.model.Info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhashacharya on 11/2/14.
 */
public class InfoDao {

    private SessionFactory sessionFactory;

    public GcmPublishPojo insertInfo(Info info){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String fromUser =  authentication.getName();
        Session session = this.sessionFactory.openSession();
        ArrayList<String> validTags = getValidTags(info,session);
        if(fromUser==null || validTags.isEmpty())return null;

        List<InfoClientPojo> infoClientPojos = new ArrayList<InfoClientPojo>(validTags.size());
        for(String tag:validTags){
            InfoClientPojo infoClientPojo= new InfoClientPojo();
            infoClientPojo.setTag(tag);
            infoClientPojos.add(infoClientPojo);
        }
        InfoPojo infoPojo = new InfoPojo();
        infoPojo.setTitleEn(info.getTitle());
        infoPojo.setDataEn(info.getBody());
        infoPojo.setInfoFrom(fromUser);
        infoPojo.setInfoClientPojos(infoClientPojos);
        Transaction tx = session.beginTransaction();
        session.persist(infoPojo);
        tx.commit();
        session.close();

        GcmPublishPojo gcmPublishPojo = new GcmPublishPojo();
        gcmPublishPojo.setInfoPojo(infoPojo);
        gcmPublishPojo.setTags(validTags);
        return gcmPublishPojo;
    }

    private ArrayList<String> getValidTags(Info info,Session session){
        ArrayList<String> tags = new ArrayList<String>();
        for(int location: info.getLocationIds()){
            for(int crop: info.getCropIds()){
                String tag = location+"-"+crop;
                LocationsCropPojo locationsCropPojo = (LocationsCropPojo) session.get(LocationsCropPojo.class,tag);
                if(locationsCropPojo!=null){
                    tags.add(locationsCropPojo.getTag());
                }
            }
        }
        return tags;
    }


    public List<InfoPojo> getInfos(String tag){
        Session session = this.sessionFactory.openSession();
        List<InfoClientPojo> infoIds = (List<InfoClientPojo>)session.createQuery("from InfoClientPojo where tag= :tag").setParameter("tag",tag).list();
        List<Integer> infoInt = new ArrayList<Integer>(infoIds.size());
        for(InfoClientPojo infoPojo:infoIds){
            //infoInt.add(new Integer(infoPojo.getInfoId()));
        }
        List<InfoPojo> infoPojos = (List<InfoPojo>) session.createCriteria(InfoPojo.class).add(Restrictions.in("id",infoInt)).list();
        session.close();
        return  infoPojos;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
