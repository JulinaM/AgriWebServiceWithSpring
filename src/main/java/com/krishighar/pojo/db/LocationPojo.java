package com.krishighar.pojo.db;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julina on 10/6/14.
 */

@Entity
@Table(name="location")
public class LocationPojo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int locationId;
    @Column(name = "name_en")
    private String locationNameEn;
    @Column(name = "name_np")
    private String locationNameNp;

    @ManyToMany(fetch =FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinTable(name = "location_crop",
            joinColumns = { @JoinColumn(name = "location_id") },
            inverseJoinColumns = { @JoinColumn(name = "crop_id") })
    private List<CropPojo> crops = new ArrayList<CropPojo>();

    public List<CropPojo> getCrops() {
        return crops;
    }

    public void setCrops(List<CropPojo> subjects) {
        this.crops = subjects;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationNameEn() {
        return locationNameEn;
    }

    public void setLocationNameEn(String locationName) {
        this.locationNameEn = locationName;
    }

    public String getLocationNameNp() {
        return locationNameNp;
    }

    public void setLocationNameNp(String locationNameNp) {
        this.locationNameNp = locationNameNp;
    }
}
