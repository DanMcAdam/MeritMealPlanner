package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Array;
import java.sql.Date;

//TODO: recipe map -> ingredient query for relational table that holds recipe ingredients to fill array of ingredients for Recipe.ingredients
public class JdbcRecipeDao implements RecipeDao
{
    private JdbcTemplate jdbcTemplate;
    
    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Recipe getRecipeById(Long recipeId) throws Exception
    {
        String sql = "SELECT * FROM recipe WHERE recipe_id = ?;";
    
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, recipeId);
        
        try
        {
            if(rowSet.next())
            {
                return mapRowToRecipe(rowSet);
            }
        }
        catch (Exception e)
        {
            throw new Exception("Error querying for recipe by ID");
        }
        return null;
    }
    
    
    //TODO: Finish mapping once I figure out how to arrays from Postgre
    Recipe mapRowToRecipe(SqlRowSet rs) throws Exception
    {
        Recipe recipe = new Recipe();
        
        try
        {
            recipe.setRecipeId(rs.getLong("recipe_id"));
            recipe.setCreatorId(rs.getLong("creator_id"));
            recipe.setTitle(rs.getString("title"));
            recipe.setDateAdded(rs.getDate("date_added"));
            recipe.setCookingTime(rs.getInt("cooking_time"));
            recipe.setPrepTime(rs.getInt("prep_time"));
            recipe.setInstructions(rs.getString("instructions"));
            recipe.setPrivate(rs.getBoolean("private"));
            //Array a = rs.getArray("picture_links");
            //recipe.setPictureLinks(new String[]);
        }
        catch (Exception e)
        {
            throw new Exception("Error mapping recipe");
        }
        
        return recipe;
    }

    //Not yet tested but here are the insertion, update, deletion statements.
    public boolean createRecipe(Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink) {


        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        String insertMealPlan = "INSERT INTO recipe (creator_id, title, date_added, cooking_time, prep_time, instructions, private, \" +\n" +
                "                \"picture_links, reference_link, video_link) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(insertMealPlan, creatorId, title, date, cookingTime, prepTime,
                    instructions, isPrivate, pictureLinks, referenceLink, videoLink);
        }catch(DataAccessException e){
            return false;
        }
        return true;
    }

    //The following has not been tested.
    public boolean updateRecipe(Long recipeId, Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink){

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        String updateRecipeSql = "UPDATE recipe SET title = ?, date_added = ?, cooking_time = ?, prep_time = ?, instructions =?, private = ?, " +
                "picture_links = ?, reference_link = ?, video_link = ? WHERE recipe_id = ? AND creator_id = ?";
        try{
            jdbcTemplate.update(updateRecipeSql, title, date, cookingTime, prepTime,
                    instructions, isPrivate, pictureLinks, referenceLink, videoLink , recipeId, creatorId);
        }catch(DataAccessException e){
            return false;
        }
        return true;

    }
    //not yet tested.

    public boolean deleteRecipe(Long recipeId, Long creatorId){

        String deleteRecipeSql = "DELETE FROM recipe WHERE recipe_id = ? AND creator_id = ? ";
        try{
            jdbcTemplate.update(deleteRecipeSql, recipeId,creatorId);
        }catch(DataAccessException e){
            return false;
        }
        return true;

    }














}
