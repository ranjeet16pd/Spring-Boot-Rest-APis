package com.Learning.Project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employes {

    @GetMapping("/employes")
    public String employes() {
        return  "this is first emp";
    }

}
