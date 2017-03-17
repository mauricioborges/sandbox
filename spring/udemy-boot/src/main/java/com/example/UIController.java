package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIController {

    @RequestMapping("/works")
    public void works() {

    }

    @RequestMapping("/fails")
    public String fails() throws Exception {
        if (1 == 1) {
            throw new Exception("it failed");
        }
        return "index";
    }

}
