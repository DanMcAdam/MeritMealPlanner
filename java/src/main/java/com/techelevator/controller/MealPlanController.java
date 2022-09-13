package com.techelevator.controller;


import javax.validation.Valid;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.LoginDTO;
import com.techelevator.model.User;
import com.techelevator.model.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
@Component

public class MealPlanController {


    RecipeDao recipeDao;
    MealPlanDao mealPlanDao;
    UserDao userDao;


    public MealPlanController(UserDao userDao, MealPlanDao mealPlanDao, RecipeDao recipeDao) {
        this.userDao = userDao;
        this.mealPlanDao = mealPlanDao;
        this.recipeDao = recipeDao;
    }

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    Long printMeal(Principal principal) {
        String username = principal.getName();
        User real_username = userDao.findByUsername(username);
        return real_username.getId();



    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
        boolean print(){
            Long recipeId = Long.valueOf(1);
            Long creatorId = Long.valueOf(1);
            String title = "Lasgna";
            Long cookingTime = Long.valueOf(10);
            Long prepTime = Long.valueOf(11);
            String instructions = "various steps to follow";
            boolean isPrivate = true;
            String pictureLinks [] = {"link 1", "link 2"};
            String referenceLink = "reference link";
            String videoLink = "video Link";

            /*
             try {
           return recipeDao.updateRecipe(recipeId,creatorId,title,cookingTime,prepTime,instructions,
                   isPrivate,pictureLinks,referenceLink,videoLink);
                   }

             */

        return recipeDao.createRecipe(creatorId,title,cookingTime,prepTime,instructions,
                isPrivate,pictureLinks,referenceLink,videoLink);

/*
        Long userToDelete = Long.valueOf(1);
        Long recipeIdToDelete = Long.valueOf(9);


        return recipeDao.deleteRecipe(recipeIdToDelete,userToDelete);

 */

        }









}
