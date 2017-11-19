package com.winwinteam.RecipeProject.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"categories", "ingredients", "notes"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    // It is important to initialize set, in this example by HashSet
    private Set<Category> categories = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    // It is important to initialize set, in this example by HashSet
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte [] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Recipe() {
    }


}
