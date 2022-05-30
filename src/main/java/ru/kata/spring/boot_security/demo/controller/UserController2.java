package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController2 {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUserPage (Principal principal, Model model) {

        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        System.out.println(principal.getName() + user);
        return "user";
    }
}
