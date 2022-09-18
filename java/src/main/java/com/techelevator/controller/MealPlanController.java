package com.techelevator.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.*;
import com.techelevator.model.*;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin

public class MealPlanController {
    @Autowired
    private MealPlanDao mealPlanDao;
    private RecipeDao recipeDao;
    private IngredientDao ingredientDao;
    
    public MealPlanController (MealPlanDao mealPlan, RecipeDao recipe, IngredientDao ingredient)
    {
        this.mealPlanDao = mealPlan;
        this.recipeDao = recipe;
        this.ingredientDao = ingredient;
    }
    
    @RequestMapping(path = "/{userId}/mealPlans", method = RequestMethod.GET)
    public MealPlan[] allMealPlans (@PathVariable Long userId)
    {
    
    }






}
