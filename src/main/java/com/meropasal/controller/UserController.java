package com.meropasal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    private ResponseEntity<?> getUserRegister(){
        return ResponseEntity.ok().body("<h1>Register User</h1>");
    }
}
