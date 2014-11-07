package com.krishighar.pojo.db;

import javax.persistence.*;
import java.util.List;

/**
 * Created by julina on 10/8/14.
 */
@Entity
@Table(name="subscriber_info")
public class SubscriberInfoPojo {
    @Id
    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "reg_id")
    private String regId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(targetEntity = SubscriptionPojo.class,
            mappedBy = "subscriberInfoPojo",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<SubscriptionPojo> subscriptionPojos;

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getRegId() {
        return regId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SubscriptionPojo> getSubscriptionPojos() {
        return subscriptionPojos;
    }

    public void setSubscriptionPojos(List<SubscriptionPojo> subscriptionPojos) {
        this.subscriptionPojos = subscriptionPojos;
    }
}
