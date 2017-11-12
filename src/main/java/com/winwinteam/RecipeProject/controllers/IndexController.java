package com.winwinteam.RecipeProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        System.out.println("do somasx");
        return "index";
    }
}
