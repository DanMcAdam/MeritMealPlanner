package com.techelevator.model;

import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

public class Recipe
{

    private long recipeId;
    private long creatorId;

    private String title;
    private Date dateAdded;
    private int cookingTime;
    private int prepTime;
    private String instructions;
    private boolean isPrivate;
    private String[] pictureLinks;
    private String referenceLink;
    private String videoLink;
    private Ingredient[] ingredients;
    
    public long getRecipeId()
    {
        return recipeId;
    }
    
    public void setRecipeId(long recipeId)
    {
        this.recipeId = recipeId;
    }
    
    public long getCreatorId()
    {
        return creatorId;
    }
    
    public void setCreatorId(long creatorId)
    {
        this.creatorId = creatorId;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public Date getDateAdded()
    {
        return dateAdded;
    }
    
    public void setDateAdded(Date dateAdded)
    {
        this.dateAdded = dateAdded;
    }
    
    public int getCookingTime()
    {
        return cookingTime;
    }
    
    public void setCookingTime(int cookingTime)
    {
        this.cookingTime = cookingTime;
    }
    
    public int getPrepTime()
    {
        return prepTime;
    }
    
    public void setPrepTime(int prepTime)
    {
        this.prepTime = prepTime;
    }
    
    public String getInstructions()
    {
        return instructions;
    }
    
    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }
    
    public boolean isPrivate()
    {
        return isPrivate;
    }
    
    public void setPrivate(boolean aPrivate)
    {
        isPrivate = aPrivate;
    }
    
    public String[] getPictureLinks()
    {
        return pictureLinks;
    }
    
    public void setPictureLinks(String[] pictureLinks)
    {
        this.pictureLinks = pictureLinks;
    }
    
    public String getReferenceLink()
    {
        return referenceLink;
    }
    
    public void setReferenceLink(String referenceLink)
    {
        this.referenceLink = referenceLink;
    }
    
    public String getVideoLink()
    {
        return videoLink;
    }
    
    public void setVideoLink(String videoLink)
    {
        this.videoLink = videoLink;
    }
    
    public Ingredient[] getIngredients()
    {
        return ingredients;
    }
    
    public void setIngredients(Ingredient[] ingredients)
    {
        this.ingredients = ingredients;
    }
}
