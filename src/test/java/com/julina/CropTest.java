package com.julina;

import com.krishighar.dao.CropDao;
import com.krishighar.pojo.db.CropPojo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by julina on 11/9/14.
 */
public class CropTest {
    @Autowired
    private CropDao cropDao;

    @Test
    public void A_getTEst(){
        ArrayList<CropPojo> cropPojos = (ArrayList<CropPojo>) cropDao.getCrops();
        for (int i = 0; i < cropPojos.size(); i++) {
            System.out.println(cropPojos.get(i).getCropNameEn());
        }

    }
}
