package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IngredientDao
{
    Ingredient[] findIngredientsByRecipeId(long recipeId) throws Exception;
    
    Ingredient mapRowToIngredient(SqlRowSet rs) throws Exception;
    //TODO connect interface to class
}
