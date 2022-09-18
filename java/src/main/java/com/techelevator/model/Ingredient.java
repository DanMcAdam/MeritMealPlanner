package com.techelevator.model;

public class Ingredient
{
    private long ingredientId;
    private String ingredientName;
    private long superCategory;
    private IngredientTypes ingredientTypes;
    private int amount;
    private Measurement measurement;
    private String recipeNote;
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    public Measurement getMeasurement()
    {
        return measurement;
    }
    
    public void setMeasurement(Measurement measurement)
    {
        this.measurement = measurement;
    }
    
    public long getIngredientId()
    {
        return ingredientId;
    }
    
    public void setIngredientId(long ingredientId)
    {
        this.ingredientId = ingredientId;
    }
    
    public String getIngredientName()
    {
        return ingredientName;
    }
    
    public void setIngredientName(String ingredientName)
    {
        this.ingredientName = ingredientName;
    }
    
    public long getSuperCategory()
    {
        return superCategory;
    }
    
    public void setSuperCategory(long superCategory)
    {
        this.superCategory = superCategory;
    }
    
    public IngredientTypes getIngredientTypes()
    {
        return ingredientTypes;
    }
    
    public void setIngredientTypes(IngredientTypes ingredientTypes)
    {
        this.ingredientTypes = ingredientTypes;
    }
    
    public String getRecipeNote()
    {
        return recipeNote;
    }
    
    public void setRecipeNote(String recipeNote)
    {
        this.recipeNote = recipeNote;
    }
}

