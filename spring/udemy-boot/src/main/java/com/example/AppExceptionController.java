package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionController {

    @ExceptionHandler
    public String exceptionHandler(Exception exception, Model model, HttpServletRequest request) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error";

    }

}
