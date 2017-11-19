package com.winwinteam.RecipeProject.repositories;

import com.winwinteam.RecipeProject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kalisiaczki on 12.11.2017.
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
