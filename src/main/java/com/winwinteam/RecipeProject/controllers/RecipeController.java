package com.winwinteam.RecipeProject.controllers;


import com.winwinteam.RecipeProject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping("/recipe")
    public String getRecipePage(Model model){

        log.info("im in controller");

        model.addAttribute("recipe", recipeService.getRecipes());



        return "recipe";
    }
}
