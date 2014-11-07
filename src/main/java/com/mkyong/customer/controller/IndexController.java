package com.mkyong.customer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.krishighar.dao.GcmInfoDao;
import com.krishighar.dao.LocationDao;
import com.krishighar.dao.UserDao2;
import com.krishighar.pojo.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by subhashacharya on 10/30/14.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    GcmInfoDao gcmInfoDao;
    @Autowired
    LocationDao locationDao;
    @Autowired
    private UserDao2 userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) throws JsonProcessingException {
        model.addAttribute("login",new User());
        model.addAttribute("contentProviderCount",userDao.getUsersCount());
        model.addAttribute("subscriberCount",gcmInfoDao.getUsersCount());
        model.addAttribute("locationCount",locationDao.getLocationCount());
        return "index";
    }
}
