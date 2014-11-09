package com.krishighar.pojo.db;

import java.util.ArrayList;

/**
 * Created by TekTak Mob on 10/13/2014.
 */
public class GcmPushMessagePojo {

    String infoTitle;
    String infoBody;
    ArrayList<String> tags;
    long timestamp;

    public String getInfoBody() {
        return infoBody;
    }

    public void setInfoBody(String infoBody) {
        this.infoBody = infoBody;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public GcmPushMessagePojo initItems(GcmPublishPojo gcmPublishPojo){
        this.setInfoTitle(gcmPublishPojo.getInfoPojo().getTitleEn());
        this.setInfoBody(gcmPublishPojo.getInfoPojo().getDataEn());
        this.setTags(gcmPublishPojo.getTags());
        return this;
    }
}
