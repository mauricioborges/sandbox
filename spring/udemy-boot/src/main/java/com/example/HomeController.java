package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${homeController.msg}")
    private String homeControllerMsg;


    @RequestMapping("/")
    public String home() {
        return homeControllerMsg;
    }

    @RequestMapping("/failplease")
    public String failPlease() throws Exception {
        if (1 == 1) {
            throw new Exception("lolololool");
        }
        return "failme please";
    }

}
