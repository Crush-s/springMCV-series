package com.javacode2018.springmvcseries.chat06.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login() {
        return "login view";
    }

    @RequestMapping("/add")
    public String add() {
        return "add view";
    }

    @RequestMapping("/del")
    public String modify() {
        return "modify view";
    }

    @RequestMapping("/list")
    public String list() {
        return "list view";
    }
}
