package com.winwinteam.RecipeProject.bootstrap;

import com.winwinteam.RecipeProject.domain.*;
import com.winwinteam.RecipeProject.repositories.CategoryRepository;
import com.winwinteam.RecipeProject.repositories.RecipeRepository;
import com.winwinteam.RecipeProject.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(recipeList());
        log.debug("Loading Bootstrap Data");
    }

    private List<Recipe> recipeList(){

        List<Recipe> recipeList = new ArrayList<>(2);

       UnitOfMeasure spoon = unitOfMeasureRepository.findByUom("Teaspoon").get();
       UnitOfMeasure cup = unitOfMeasureRepository.findByUom("Cup").get();
       UnitOfMeasure pinch = unitOfMeasureRepository.findByUom("Pinch").get();
       UnitOfMeasure dash = unitOfMeasureRepository.findByUom("Dash").get();



        //perfect Guacamole
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setCookTime(2);
        guacamoleRecipe.setPrepTime(1);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole");
        guacamoleRecipe.setServings(1);


        Ingredient avocado = new Ingredient("avocado", new BigDecimal(10),spoon, guacamoleRecipe );
        Ingredient sugar = new Ingredient("sugar", new BigDecimal(3),pinch,guacamoleRecipe);
        Ingredient water = new Ingredient("water", new BigDecimal(2), cup,guacamoleRecipe);

        guacamoleRecipe.getIngredients().add(avocado);
        guacamoleRecipe.getIngredients().add(sugar);
        guacamoleRecipe.getIngredients().add(water);


        Notes notes = new Notes();
        notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
        log.info("add notes");

        notes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(notes);
        log.info("add recipe");




        recipeList.add(guacamoleRecipe);



        return recipeList;
    }
}
