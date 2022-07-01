package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping()
public class AdminController {

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String viewLoginPage(){
        return "login";
    }
//    @PathVariable("id") Long id,
    @GetMapping("/admin")
    public String viewAdminPage( Model model, User user){
        List<User> users = userService.finedAll();
        model.addAttribute("users", users);
//        User user1 = userService.findById(id);
//        model.addAttribute("user", user1);
        return "admin";
    }

//    @PostMapping("/admin")
//    public String postAdminPage(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.saveUser(user);
//        return "admin";
//    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.finedAll();
        model.addAttribute("users", users);
        return "user_list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user_create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
