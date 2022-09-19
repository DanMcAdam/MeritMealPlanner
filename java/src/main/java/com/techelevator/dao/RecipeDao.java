package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Array;
import java.util.List;


public interface RecipeDao
{
    //TODO: connect interface to class



        public List<Recipe> getRecipeListFromUser(int creatorId) throws Exception;
        public List<Recipe> getAllRecipeByName(String namesOfRecipe) throws Exception;
        public List<Recipe> getAllRecipeList() throws Exception;
        public Recipe getRecipeById(Long recipeId) throws Exception;

        //public Recipe getRecipeByName(String namesOfRecipe) throws Exception;

        //public boolean createRecipe(Recipe recipe);
        //public boolean updateRecipe(Recipe recipe);


        //public boolean createRecipe(Long creatorId, String title, Long cookingTime, Long prepTime, Ingredient ingredient[], String instructions,
                                   // boolean isPrivate, String[] pictureLinks, String referenceLink, String subHeader);


        public boolean updateRecipe(Long recipeId, Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                    boolean isPrivate, String[] pictureLinks, String referenceLink, String subHeader);

        public boolean deleteRecipe(String title, Long creatorId);
    
    Recipe createRecipe(Recipe recipe);
}
