package com.techelevator.controller;


import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void userRecipes(@RequestBody Recipe recipe, int value) {
        try {

            switch (value){

                case 1: {
                    //userChooseToDisplayRecipe(recipe.getRecipeId());

                }
                case 2:{
                    //userChooseToUpdateRecipe(recipe);
                }
                case 3:{
                    //userChooseToDeleteRecipe(recipe.getTitle(), recipe.getCreatorId());
                }
                default:{
                    System.out.println("Recipe not found");

                }
            }

        } catch (Exception e) {throw new RuntimeException(e);}

    }


    //Get method the Recipe the user has on the DB.
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public List<Recipe> getListOfRecipes(Principal principal) throws Exception{
        int userId = userDao.findIdByUsername(principal.getName());
        return recipeDao.getRecipeListFromUser(userId);

    }
/*
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/Form", method = RequestMethod.GET)
    public void userChooseToUpdateRecipe(@RequestBody Recipe recipe) {
        //recipeDao.updateRecipe(recipe);

    }


    @RequestMapping(value = "/Form", method = RequestMethod.GET)
    public boolean userChooseToDeleteRecipe(@RequestBody String title, Long creatorId) {
        return recipeDao.deleteRecipe(title, creatorId);

    }

*/
    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public List<Recipe> userChooseToDisplayRecipe() throws Exception {
         return recipeDao.getAllRecipeList();

    }


    //Creates recipe when the values are passed
    @RequestMapping(value = "/FormCreate", method = RequestMethod.POST)
    public boolean userSubmitRecipe(@RequestBody Recipe recipe){
        //System.out.println(principal);
        //Long creatorId = Long.valueOf(userDao.findIdByUsername(principal.getName()));
        //recipe.setCreatorId(creatorId);
        return recipeDao.createRecipe(recipe);

    }






/*
    @RequestMapping(value = "/test", method = RequestMethod.GET)
        boolean print() {
        Long recipeId = Long.valueOf(1);
        Long creatorId = Long.valueOf(1);
        String title = "Lasgna";
        Long cookingTime = Long.valueOf(10);
        Long prepTime = Long.valueOf(11);
        String instructions = "various steps to follow";
        boolean isPrivate = true;
        String pictureLinks[] = {"link 1", "link 2"};
        String referenceLink = "reference link";
        String videoLink = "video Link";


             try {
           return recipeDao.updateRecipe(recipeId,creatorId,title,cookingTime,prepTime,instructions,
                   isPrivate,pictureLinks,referenceLink,videoLink);
                   }



        //return recipeDao.createRecipe(creatorId, title, cookingTime, prepTime,ingredient[], instructions,
              //  isPrivate, pictureLinks, referenceLink, subHeader);


        Long userToDelete = Long.valueOf(1);
        Long recipeIdToDelete = Long.valueOf(9);


        return recipeDao.deleteRecipe(recipeIdToDelete,userToDelete);


    }

*/
    /*
        @RequestMapping(value = "/meal", method = RequestMethod.GET)
        boolean printMeal (@RequestBody Recipe recipe, Principal principal){

        return recipeDao.createRecipe(recipe);


        }

 */

/*
    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    boolean GetRecipeFromFrontEnd (@RequestBody Recipe recipe, Principal principal){

        return recipeDao.createRecipe(recipe);


    }


 */












}











