package com.krishighar.pojo.db;

import com.krishighar.resource.InfoClient;

import javax.persistence.*;
import java.util.List;

/**
 * Created by julina on 10/9/14.
 */
@Entity
@Table(name="info_client")
public class InfoClientPojo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "tag")
    private String tag;

    @ManyToMany(mappedBy = "infoClientPojos")
    private List<InfoPojo> infoPojos;


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<InfoPojo> getInfoPojos() {
        return infoPojos;
    }

    public void setInfoPojos(List<InfoPojo> infoPojos) {
        this.infoPojos = infoPojos;
    }
}
