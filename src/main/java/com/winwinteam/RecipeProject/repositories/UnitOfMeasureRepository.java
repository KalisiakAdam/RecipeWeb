package com.winwinteam.RecipeProject.repositories;

import com.winwinteam.RecipeProject.domain.Category;
import com.winwinteam.RecipeProject.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by kalisiaczki on 12.11.2017.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String description);
}
