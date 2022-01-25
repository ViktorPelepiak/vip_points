package com.vip.points.controller;

import com.vip.points.dto.UserDto;
import com.vip.points.model.User;
import com.vip.points.util.LoggedUserUtil;
import com.vip.points.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    public ViewController() {}

    @GetMapping
    public String indexPage(ModelMap modelMap) {
        putContextPathInformationToModelMap(modelMap);
        putUserInfoToModelMap(modelMap);
        return "index";
    }

    @GetMapping("login")
    public String loginPage(ModelMap modelMap) {
        putContextPathInformationToModelMap(modelMap);
        putUserInfoToModelMap(modelMap);
        return "login";
    }

    private void putUserInfoToModelMap(ModelMap modelMap) {
        User loggedUser = LoggedUserUtil.getLoggedUser().orElse(null);
        if (loggedUser != null) {
            modelMap.addAttribute("user", UserDto.toDto(loggedUser));
        }
    }

    private void putContextPathInformationToModelMap(ModelMap modelMap) {
        modelMap.addAttribute("contextPath", PropertiesUtil.getProperty("application", "url.host"));
    }
}
