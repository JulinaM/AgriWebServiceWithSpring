package com.krishighar.pojo.db;

import javax.persistence.*;

/**
 * Created by julina on 10/7/14.
 */
@Entity
@Table(name="subscription")
public class SubscriptionPojo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="device_id")
    private SubscriberInfoPojo subscriberInfoPojo;

    @Column(name ="tag")
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public SubscriberInfoPojo getSubscriberInfoPojo() {
        return subscriberInfoPojo;
    }

    public void setSubscriberInfoPojo(SubscriberInfoPojo subscriberInfoPojo) {
        this.subscriberInfoPojo = subscriberInfoPojo;
    }

}
