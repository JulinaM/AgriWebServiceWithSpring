package com.krishighar.pojo.db;

import javax.persistence.*;

/**
 * Created by julina on 10/7/14.
 */
@Entity
@Table(name="location_crop")
public class LocationsCropPojo {

    @Column(name = "crop_id")
    private int cropId;
    @Column(name = "location_id")
    private int locationId;
    @Id
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
