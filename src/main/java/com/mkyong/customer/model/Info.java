package com.mkyong.customer.model;

import com.krishighar.pojo.db.CropPojo;
import com.krishighar.pojo.db.LocationPojo;

import java.util.List;

public class Info {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //textbox
	String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //textarea
	String body;

    public List<LocationPojo> getLocationPojoList() {
        return locationPojoList;
    }

    public void setLocationPojoList(List<LocationPojo> locationPojoList) {
        this.locationPojoList = locationPojoList;
    }

    private List<LocationPojo> locationPojoList;

    private List<CropPojo> cropPojos;

    public List<CropPojo> getCropPojos() {
        return cropPojos;
    }

    private int[] locationIds;

    public void setCropPojos(List<CropPojo> cropPojos) {
        this.cropPojos = cropPojos;
    }

    public int[] getLocationIds() {
        return locationIds;
    }

    private  int[] cropIds;

    public void setLocationIds(int[] locationIds) {
        this.locationIds = locationIds;
    }

    public int[] getCropIds() {
        return cropIds;
    }

    public void setCropIds(int[] cropIds) {
        this.cropIds = cropIds;
    }
}