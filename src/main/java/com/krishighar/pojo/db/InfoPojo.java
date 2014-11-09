package com.krishighar.pojo.db;

import com.krishighar.resource.InfoClient;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToMany(targetEntity = InfoClientPojo.class,
            mappedBy = "infoPojos",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<InfoClientPojo> infoClientPojos;

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

    public List<InfoClientPojo> getInfoClientPojos() {
        return infoClientPojos;
    }

    public void setInfoClientPojos(List<InfoClientPojo> infoClientPojos) {
        this.infoClientPojos = infoClientPojos;
    }
}
