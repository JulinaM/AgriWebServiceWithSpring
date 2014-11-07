package com.krishighar.pojo.db;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by julina on 10/9/14.
 */
@Entity
@Table(name="info")
public class InfoPojo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int infoId;
    @Column(name = "title_en")
    private  String titleEn;
    @Column(name = "title_np")
    private String titleNp;
    @Column(name = "data_en")
    private String dataEn;
    @Column(name = "data_np")
    private String dataNp;
    @Column(name = "info_from")
    private String infoFrom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp",
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "id")
    private InfoClientPojo infoClientPojo;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoFrom() {
        return infoFrom;
    }

    public void setInfoFrom(String infoFrom) {
        this.infoFrom = infoFrom;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleNp() {
        return titleNp;
    }

    public void setTitleNp(String titleNp) {
        this.titleNp = titleNp;
    }

    public String getDataEn() {
        return dataEn;
    }

    public void setDataEn(String dataEn) {
        this.dataEn = dataEn;
    }

    public String getDataNp() {
        return dataNp;
    }

    public void setDataNp(String dataNp) {
        this.dataNp = dataNp;
    }

    public InfoClientPojo getInfoClientPojo() {
        return infoClientPojo;
    }

    public void setInfoClientPojo(InfoClientPojo infoClientPojo) {
        this.infoClientPojo = infoClientPojo;
    }
}
