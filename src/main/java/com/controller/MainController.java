package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/mentor")
    public String getMentorPage() {
        return "mainMentor";
    }
}