package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomExceptionController {

    @RequestMapping("/404")
    public String notFound() {
        return "404";
    }
}
