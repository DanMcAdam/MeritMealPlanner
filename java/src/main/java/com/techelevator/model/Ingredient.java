package com.techelevator.model;

public class Ingredient
{
    private long ingredientId;
    private String ingredientName;
    private long superCategory;
    private IngredientTypes ingredientTypes;
    private String recipeNote;
    
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

enum IngredientTypes
{
    grain,
    dairy,
    fruit,
    herbs_spice_flavors,
    vegetable,
    pasta,
    meat,
    fish,
    oil_or_fat,
    acid,
    sweetener,
    egg,
    starch,
    liquid,
    alcohol,
    baking,
    Other
}