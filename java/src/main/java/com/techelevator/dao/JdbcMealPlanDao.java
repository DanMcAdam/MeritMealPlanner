package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.MealPlanDay;
import com.techelevator.model.MealPlanDayRecipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.MealPlan;

@Service
public class JdbcMealPlanDao implements MealPlanDao{

     private JdbcTemplate jdbcTemplate;

     public JdbcMealPlanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MealPlan> findAllMealPlan() {
        return null;
    }

    @Override
    public int getPlanIdByOwnerId(Long ownerId) {


       return jdbcTemplate.queryForObject(
                    "SELECT * FROM meal_plan WHERE meal_plan.owner_id = ?", int.class, ownerId);
       //need to get a array of all plans with the owner
    }

    @Override
    public int getOwnerId(Long ownerId) {
        return jdbcTemplate.queryForObject("SELECT owner_id FROM meal_plan WHERE owner_id = ?", int.class, ownerId);
    }
    
    @Override
    public MealPlanDayRecipe[] findAllRecipesInMealPlanDay(Long dayId) throws Exception
    
    {
        List<MealPlanDayRecipe> mealPlanDayRecipeList = new ArrayList<>();
        
        String sql = "SELECT * FROM day_recipe WHERE meal_plan_day_day_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, dayId);
        try
        {
            if (rowSet.next())
            {
                mealPlanDayRecipeList.add(mapRowToMealPlanDayRecipe(rowSet));
            }
        }
        catch (Exception e)
        {
            throw new Exception("Error querying for meal plan recipes by day");
        }
        MealPlanDayRecipe[] mealPlanDayRecipeArr = mealPlanDayRecipeList.toArray(new MealPlanDayRecipe[mealPlanDayRecipeList.size()]);
        return mealPlanDayRecipeArr;
    }
    
    @Override
    public MealPlanDay[] findAllDayInMealPlan(long planId) throws Exception
    {
        List<MealPlanDay> mealPlanDayList = new ArrayList<>();
        
        String sql = "SELECT * FROM meal_plan_day WHERE meal_plan_day = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, planId);
        try
        {
            if (rowSet.next())
            {
                mealPlanDayList.add(mapRowToMealPlanDay(rowSet));
            }
        }
        catch (Exception e)
        {
            throw new Exception("Trouble querying meal plan days");
        }
        MealPlanDay[] mealPlanDayArr = new MealPlanDay[mealPlanDayList.size()];
        return mealPlanDayList.toArray(mealPlanDayArr);
    }
    @Override
    public MealPlan mapRowToMealPlan(SqlRowSet rs) throws Exception
    {
        MealPlan mealPlan = new MealPlan();
        try
        {
            mealPlan.setPlanId(rs.getLong("plan_id"));
            mealPlan.setOwnerId(rs.getLong("owner_id"));
            mealPlan.setTitle(rs.getString("title"));
            MealPlanDay[] mealPlanDays = findAllDayInMealPlan(mealPlan.getPlanId());
            mealPlan.setMealPlanDays(mealPlanDays);
            return mealPlan;
        }
        catch (Exception e)
        {
            throw new Exception("Error mapping mealplan");
        }
    }
    
    MealPlanDay mapRowToMealPlanDay(SqlRowSet rs) throws Exception
    {
        MealPlanDay mealPlanDay = new MealPlanDay();
        
        try
        {
            mealPlanDay.setDayId(rs.getLong("day_id"));
            mealPlanDay.setPlanId(rs.getLong("plan_id"));
            mealPlanDay.setDayInSequence(rs.getInt("day_in_sequence"));
            MealPlanDayRecipe[] mealPlanDayRecipe = findAllRecipesInMealPlanDay(mealPlanDay.getDayId());
            mealPlanDay.setMealPlanDayRecipes(mealPlanDayRecipe);
            return mealPlanDay;
        }
        catch (Exception e)
        {
            throw new Exception("Error mapping meal plan days");
        }
    }
    
    //TODO: mealPlanDayRecipe needs to hold the recipe it represents, finish recipe query on RecipeDAO to finish building full mealplan
    
    MealPlanDayRecipe mapRowToMealPlanDayRecipe(SqlRowSet rs) throws Exception
    {
         MealPlanDayRecipe mealPlanDayRecipe = new MealPlanDayRecipe();
         
         try
         {
             mealPlanDayRecipe.setMealPlanDayId(rs.getLong("meal_plan_day_day_id"));
             mealPlanDayRecipe.setRecipeId(rs.getLong("recipe_recipe_id"));
             mealPlanDayRecipe.setHeader(rs.getString("header"));
             
             return mealPlanDayRecipe;
         }
         catch (Exception e)
         {
             throw new Exception("Error mapping meal plan day recipes");
         }
    }
    
    @Override
    public MealPlan findByTitle(String title) {
        return null;
    }

    @Override
    public int findPlanIdByTitle(String title) {
        return 0;
    }

    @Override
    public boolean createPlan(Long ownerId, String title) {

        String insertMealPlan = "INSERT INTO meal_plan (owner_id, title) VALUES(?, ?)";
        try{
            jdbcTemplate.update(insertMealPlan, ownerId,title);
        }catch(DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    //The following has not been tested.
    public boolean updatePlan(Long planIdToBeChanged, Long ownerId, String newTitle){

        String updateMealPlan = "UPDATE meal_plan SET title = ? WHERE plan_id = ? AND owner_id = ?";
        try{
            jdbcTemplate.update(updateMealPlan, newTitle, planIdToBeChanged,ownerId);
        }catch(DataAccessException e){
            return false;
        }
        return true;

    }
    @Override
    public boolean deletePlan(Long planId, Long ownerId){

        String deleteMealPlan = "DELETE FROM meal_plan WHERE plan_id = ? AND owner_id = ? ";
        try{
            jdbcTemplate.update(deleteMealPlan, planId,ownerId);
        }catch(DataAccessException e){
            return false;
        }
        return true;

    }









}





