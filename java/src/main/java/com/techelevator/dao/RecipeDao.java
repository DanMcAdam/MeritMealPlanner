package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Array;


public interface RecipeDao
{
    //TODO: connect interface to class



        public Recipe getRecipeById(Long recipeId) throws Exception;

        //Not yet tested but here are the insertion, update, deletion statements.
        public boolean createRecipe(Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                    boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink);

        //The following has not been tested.
        public boolean updateRecipe(Long recipeId, Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                    boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink);

        public boolean deleteRecipe(String title, Long creatorId);

    }
