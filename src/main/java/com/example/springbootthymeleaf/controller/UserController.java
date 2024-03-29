package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.model.User;
import com.example.springbootthymeleaf.model.websocket.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping("demo")
    public String demo(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        double grade = 90.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));
        // return to templates/demo.html page.

        return "demo";
    }

//    @RequestMapping("demo2")
//    public String demo2(Model model) {
//
//        List<User> lst = new ArrayList<>();
//        lst.add(new User(1, "Tom", 30));
//        lst.add(new User(2, "Jerry", 29));
//        lst.add(new User(3, "Nancy", 27));
//        model.addAttribute("list", lst);
//
//        return "demo2";
//    }

    @RequestMapping("demo3")
    public String demo3(HttpServletRequest request, Model model) {
        // request
        request.setAttribute("request", "request data2");

        // session
        request.getSession().setAttribute("session", "session data2");

        // application
        request.getSession().getServletContext().setAttribute("application", "application data2");

        return "demo2";
    }

    @RequestMapping("add")
    public String toAdd(User user) {
        int num = 10 / 0;
        return "add";
    }

    @RequestMapping("addUser")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }

        System.out.println("Saver user = " + user);
        return "success";
    }

//    /// handle specific errors (ArithmeticException)
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView handlerArithmeticException(Exception e) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e.toString());
//        mav.setViewName("mathError");
//
//        return mav;
//    }

    /// handle specific errors (Null pointer exception)
    @RequestMapping("/update")
    public String update() {
        String name = null;
        name = name.toLowerCase(); // this should cause null pointer exception
        return "update";
    }

//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView handlerNullPointerException(Exception e) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e.toString());
//        mav.setViewName("nullPointerError");
//
//        return mav;
//    }

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUserWebSocket(User user) {
        return new UserResponse("Hello, " + user.getName());
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
