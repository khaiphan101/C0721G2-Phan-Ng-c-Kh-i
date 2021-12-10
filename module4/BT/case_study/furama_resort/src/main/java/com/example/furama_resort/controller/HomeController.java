package com.example.furama_resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String showHome() {
        return "/home";
    }

    @GetMapping("/403")
    public String getError() {
        return "/error.403";
    }
}