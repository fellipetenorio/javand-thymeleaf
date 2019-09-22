package com.example.springbootthymeleaf.controller.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        if (ex instanceof ArithmeticException) {
            mv.setViewName("mathError");
        } else if(ex instanceof NullPointerException) {
            mv.setViewName("nullPointerError");
        }

        mv.addObject("exception", ex.toString());
        return mv;
    }
}
