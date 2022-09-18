package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientTypes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcIngredientDao implements IngredientDao
{
    private JdbcTemplate jdbcTemplate;
    
    public JdbcIngredientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Ingredient[] findIngredientsByRecipeId(long recipeId) throws Exception
    {
        List<Ingredient> ingredientList = new ArrayList<>();
        
        String sql = "SELECT * FROM recipe_ingredient " +
                "LEFT OUTER JOIN ingredient ON recipe_ingredient.ingredient_ingredient = ingredient.ingredient_id " +
                "WHERE recipe_ingredient.recipe_recipe_id = ?;";
        
        try
        {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, recipeId);
            if (rowSet.next())
            {
                ingredientList.add(mapRowToIngredient(rowSet));
            }
        }
        catch (Exception e)
        {
            throw new Exception("Error querying for ingredient by recipe ID");
        }
    
        Ingredient[] ingredientArr = new Ingredient[ingredientList.size()];
        return ingredientList.toArray(ingredientArr);
    }
    
    @Override
    public Ingredient mapRowToIngredient(SqlRowSet rs) throws Exception
    {
        Ingredient ingredient = new Ingredient();
        try
        {
            ingredient.setIngredientId(rs.getLong("ingredient_id"));
            ingredient.setIngredientName(rs.getString("ingredient_name"));
            ingredient.setIngredientTypes(IngredientTypes.valueOf(rs.getString("ingredient_types")));
            ingredient.setSuperCategory(rs.getLong("super_category"));
            ingredient.setRecipeNote(rs.getString("note"));
            return ingredient;
        }
        catch (Exception e)
        {
            throw new Exception("Error mapping ingredient");
        }
    }
}
