package com.example.springbootthymeleaf.controller.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    /// handle specific errors (ArithmeticException)
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e) {
        System.out.println("Global Exception Handler");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.toString());
        mav.setViewName("mathError");

        return mav;
    }

    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView handlerNullPointerException(Exception e) {
        System.out.println("Global Exception Handler");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("nullPointerError");
        return modelAndView;
    }
}
