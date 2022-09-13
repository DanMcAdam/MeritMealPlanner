package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Array;
import java.sql.Date;
@Service
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
    
        JdbcRowSet rowSet = (JdbcRowSet) jdbcTemplate.queryForRowSet(sql, recipeId);
        
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
    

    
    Recipe mapRowToRecipe(JdbcRowSet rs) throws Exception
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
            Array a = rs.getArray("picture_links");
            recipe.setPictureLinks((String[])a.getArray());
            recipe.setReferenceLink(rs.getString("reference_link"));
            recipe.setVideoLink(rs.getString("video_link"));
        }
        catch (Exception e)
        {
            throw new Exception("Error mapping recipe");
        }
        
        return recipe;
    }

    //creates and store data on the recipe table
    public boolean createRecipe(Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink) {

        //making a query to the db in order to check title
        String titleIsFound = "SELECT title FROM recipe WHERE title = ?";
        String databaseValue = jdbcTemplate.queryForObject(titleIsFound,String.class, title);

        //checks if title is already in the db
        if(title.equals(databaseValue)){
            return false;
        }
        else {


            //gets the current date
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            //query for items to be inserted in the recipe db
            String insertMealPlan = "INSERT INTO recipe (creator_id, title, date_added, cooking_time, prep_time, instructions, private, picture_links, reference_link, video_link) VALUES(?,?,?,?,?,?,?,?,?,?)";
            try {
                jdbcTemplate.update(insertMealPlan, creatorId, title, date, cookingTime, prepTime,
                        instructions, isPrivate, pictureLinks, referenceLink, videoLink);
            } catch (DataAccessException e) {
                return false;
            }
            return true;
        }
    }


    //updates value on recipe table
    public boolean updateRecipe(Long recipeId, Long creatorId, String title, Long cookingTime, Long prepTime,String instructions,
                                boolean isPrivate, String[] pictureLinks, String referenceLink, String videoLink){

        //gets current date
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        //query to update db values on recipe table
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

    //deletes values on recipe table
    public boolean deleteRecipe(String title, Long creatorId){

        //query for deleting item
        String deleteRecipeSql = "DELETE FROM recipe WHERE title = ? AND creator_id = ? ";
        try{
            jdbcTemplate.update(deleteRecipeSql, title,creatorId);
        }catch(DataAccessException e){
            return false;
        }
        return true;

    }
}
