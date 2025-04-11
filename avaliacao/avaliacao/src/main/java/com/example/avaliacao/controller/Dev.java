package com.example.avaliacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class Dev {

    @RequestMapping("/dev")
    public String dev() {
        return "Alexandre Pitta Lopes dos Santos";
    }
}
