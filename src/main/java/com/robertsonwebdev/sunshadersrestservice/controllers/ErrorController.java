package com.robertsonwebdev.sunshadersrestservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping(path = "/error")
    public String errorHandler(){
        return "error";
    }
}
