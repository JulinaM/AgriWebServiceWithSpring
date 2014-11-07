package com.krishighar.pojo.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julina on 10/7/14.
 */

@Entity
@Table(name="crop")
public class CropPojo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cropId;
    @Column(name = "name_en")
    private String cropNameEn;
    @Column(name = "name_np")
    private String cropNameNp;

    public List<LocationPojo> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationPojo> locations) {
        this.locations = locations;
    }

    @ManyToMany(mappedBy="crops")
    private List<LocationPojo> locations = new ArrayList<LocationPojo>();

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public String getCropNameEn() {
        return cropNameEn;
    }

    public void setCropNameEn(String cropName) {
        this.cropNameEn = cropName;
    }

    public String getCropNameNp() {
        return cropNameNp;
    }

    public void setCropNameNp(String cropNameNp) {
        this.cropNameNp = cropNameNp;
    }
}
