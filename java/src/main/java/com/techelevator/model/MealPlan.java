package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MealPlan {

    private Long planId;
    private Long ownerId;
    @NotEmpty(message="Please enter a title.")
    private String title;


    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "MealPlan{" +
                "planId=" + planId +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                '}';
    }
}
