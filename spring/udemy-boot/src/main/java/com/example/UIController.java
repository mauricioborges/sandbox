package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIController {

    @RequestMapping("/works")
    public String works(){
        return "/";
    }
    @RequestMapping("/fails")
    public String fails() throws Exception {
        if (1 == 1) {
            throw new Exception("it failed");
        }
        return "/";
    }

@ExceptionHandler
    public String exceptionHandler(Exception exception, Model model){
        model.addAttribute("errorMessage", exception.getMessage());
        return "post/error"; //the error URL

    }
}
