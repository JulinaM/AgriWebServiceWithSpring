package com.krishighar.pojo.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TekTak Mob on 10/13/2014.
 */
public class GcmPublishPojo {

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    ArrayList<String> tags;

    public InfoPojo getInfoPojo() {
        return infoPojo;
    }

    public void setInfoPojo(InfoPojo infoPojo) {
        this.infoPojo = infoPojo;
    }

    InfoPojo infoPojo;

    public List<String> getRegIds() {
        return regIds;
    }

    public void setRegIds(List<String> regIds) {
        this.regIds = regIds;
    }

    List<String> regIds;
}
