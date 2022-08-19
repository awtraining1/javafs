package com.ni.farm.exceptions;

import java.util.InputMismatchException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler{

    @ExceptionHandler(Exception.class)
    public String hander(Exception e, Model model){
        model.addAttribute("exceptionMessage",e.getMessage());
        return "error.html";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String hander1(Exception e, Model model){
        model.addAttribute("exceptionMessage",e.getMessage());
        return "error1.html";
    }

    @ExceptionHandler(InputMismatchException.class)
    public String hander2(Exception e, Model model){
        model.addAttribute("exceptionMessage",e.getMessage());
        return "error2.html";
    }



} 