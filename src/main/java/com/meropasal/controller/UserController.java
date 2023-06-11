package com.meropasal.controller;

import com.meropasal.model.dto.UserGetDto;
import com.meropasal.model.dto.UserPostDto;
import com.meropasal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String showRegisterPage() {
        return "home";
    }


    @PostMapping("/register")
    public String getUserRegister(@ModelAttribute UserPostDto userPostDto, Model model) {
        System.out.println("hello");
        if (userPostDto.getPassword().equals(userPostDto.getConfirmPass())) {
            UserGetDto user = userService.saveUser(userPostDto);
            model.addAttribute("username", user.getFirstName());
            return "index";
        } else {
            model.addAttribute("error", "password do not match");
            return "home";
        }
    }


    @PostMapping("/login")
    public String getUserLoggedIn(@ModelAttribute UserPostDto userPostDto, Model model) {
        String message = userService.doLogin(userPostDto);
        if (message != null) {
            System.out.println(message);
            model.addAttribute("username", message);
            return "index";
        } else {
            model.addAttribute("errors", "this user name and password is incorrect");
            return "home";

        }

    }

    @GetMapping("/getSingleUser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.getSingleUser(id));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserPostDto userPostDto) {
        return ResponseEntity.ok().body(userService.updateUser(userPostDto, id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @GetMapping("/home")
    public String displayLogin() {
        return "home";
    }
    @GetMapping("/index")
    public String displayindex() {
        return "index";
    }

}
