package com.mkyong.customer.controller;

import com.krishighar.pojo.db.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by subhashacharya on 10/27/14.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(ModelMap model){
        model.addAttribute("login", new User());
        return "login";
    }
}
