package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${homeController.msg}")//yaml overrides properties file
    private String homeControllerMsg;


    @RequestMapping("/")
    public String home() {
        return homeControllerMsg;
    }
}
