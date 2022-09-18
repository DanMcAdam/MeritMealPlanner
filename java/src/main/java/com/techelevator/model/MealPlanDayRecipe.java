package com.techelevator.model;

public class MealPlanDayRecipe
{
    private long mealPlanDayId;
    private long recipeId;
    private String header;
    private Recipe recipe;
    //public MealPlanDayRecipe(long mealPlanDayId, long recipeId, int header)
    {
        this.mealPlanDayId = mealPlanDayId;
        this.recipeId = recipeId;
        this.header = header;
    }
    
    public long getMealPlanDayId()
    {
        return mealPlanDayId;
    }
    
    public void setMealPlanDayId(long mealPlanDayId)
    {
        this.mealPlanDayId = mealPlanDayId;
    }
    
    public long getRecipeId()
    {
        return recipeId;
    }
    
    public void setRecipeId(long recipeId)
    {
        this.recipeId = recipeId;
    }
    
    public String getHeader()
    {
        return header;
    }
    
    public void setHeader(String header)
    {
        this.header = header;
    }
    
    
    public Recipe getRecipe()
    {
        return recipe;
    }
    
    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }
}
