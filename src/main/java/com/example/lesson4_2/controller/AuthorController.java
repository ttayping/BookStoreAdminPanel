package com.example.lesson4_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorController authorController;

    public AuthorController(AuthorController authorController) {
        this.authorController = authorController;
    }
}
