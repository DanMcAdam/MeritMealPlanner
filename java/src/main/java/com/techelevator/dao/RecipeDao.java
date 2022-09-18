package com.techelevator.dao;

import com.techelevator.model.Recipe;

import javax.sql.rowset.JdbcRowSet;

public interface RecipeDao
{
    Recipe getRecipeById(Long recipeId) throws Exception;
    
    Recipe mapRowToRecipe(JdbcRowSet rs) throws Exception;
    

    boolean createRecipe(Long creatorId, String title, Long cookingTime, Long prepTime, String instructions,
                         boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink);
    

    boolean updateRecipe(Long recipeId, Long creatorId, String title, Long cookingTime, Long prepTime, String instructions,
                         boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink);
    
    boolean deleteRecipe(Long recipeId, Long creatorId);
}
