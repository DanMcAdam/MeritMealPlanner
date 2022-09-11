package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Array;

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
}
