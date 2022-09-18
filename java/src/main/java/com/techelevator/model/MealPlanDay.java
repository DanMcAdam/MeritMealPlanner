package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class MealPlanDay
{
    private long dayId;
    private long planId;
    @NotEmpty (message="please enter which day in the mealplan this day is supposed to represent")
    private int dayInSequence;
    
    private MealPlanDayRecipe[] mealPlanDayRecipes;
    
    public long getDayId()
    {
        return dayId;
    }
    
    public void setDayId(long dayId)
    {
        this.dayId = dayId;
    }
    
    public long getPlanId()
    {
        return planId;
    }
    
    public void setPlanId(long planId)
    {
        this.planId = planId;
    }
    
    public int getDayInSequence()
    {
        return dayInSequence;
    }
    
    public void setDayInSequence(int dayInSequence)
    {
        this.dayInSequence = dayInSequence;
    }
    
    public MealPlanDayRecipe[] getMealPlanDayRecipes()
    {
        return mealPlanDayRecipes;
    }
    
    public void setMealPlanDayRecipes(MealPlanDayRecipe[] mealPlanDayRecipes)
    {
        this.mealPlanDayRecipes = mealPlanDayRecipes;
    }
}
