package com.winwinteam.RecipeProject.controllers;

import com.winwinteam.RecipeProject.domain.Category;
import com.winwinteam.RecipeProject.domain.UnitOfMeasure;
import com.winwinteam.RecipeProject.repositories.CategoryRepository;
import com.winwinteam.RecipeProject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Teaspoon");

        System.out.println("Cat id is: " +  categoryOptional.get().getId());
        System.out.println("Uom is: " + unitOfMeasure.get().getId());

        return "index";
    }
}
