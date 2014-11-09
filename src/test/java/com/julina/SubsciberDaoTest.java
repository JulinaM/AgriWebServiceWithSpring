package com.julina;

import com.krishighar.commons.AgriException;
import com.krishighar.dao.SubscriberDao;
import org.json.JSONArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Created by julina on 11/9/14.
 */
public class SubsciberDaoTest {
    @Autowired
    private SubscriberDao subscriberDao;

    @Test
    public void A_insertTest() throws AgriException.NullPointerException, SQLException {
        subscriberDao.insert("julsDevice","julsRegId","9843022288", new JSONArray().put("tag1_2"));
    }
}
