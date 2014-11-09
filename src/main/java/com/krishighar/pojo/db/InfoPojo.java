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
    private int infoId;
    private  String titleEn;
    private String titleNp;
    private String dataEn;
    private String dataNp;
    private Date timestamp;
    private String infoFrom;
    private List<InfoClientPojo> infoClientPojos;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Column(name = "info_from")
    public String getInfoFrom() {
        return infoFrom;
    }

    public void setInfoFrom(String infoFrom) {
        this.infoFrom = infoFrom;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp",
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "title_en")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Column(name = "title_np")
    public String getTitleNp() {
        return titleNp;
    }

    public void setTitleNp(String titleNp) {
        this.titleNp = titleNp;
    }

    @Column(name = "data_en")
    public String getDataEn() {
        return dataEn;
    }

    public void setDataEn(String dataEn) {
        this.dataEn = dataEn;
    }

    @Column(name = "data_np")
    public String getDataNp() {
        return dataNp;
    }

    public void setDataNp(String dataNp) {
        this.dataNp = dataNp;
    }

    @ManyToMany(targetEntity = InfoClientPojo.class,
            mappedBy = "infoPojos",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public List<InfoClientPojo> getInfoClientPojos() {
        return infoClientPojos;
    }

    public void setInfoClientPojos(List<InfoClientPojo> infoClientPojos) {
        this.infoClientPojos = infoClientPojos;
    }
}
