package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import com.techelevator.model.User;

import java.util.List;

public interface MealPlanDao {

    List<MealPlan> findAllMealPlan();

    int getPlanIdByOwnerId(Long ownerId);

    int getOwnerId(Long ownerId);

    MealPlan findByTitle(String title);

    int findPlanIdByTitle(String title);

    boolean createPlan(Long planId, Long ownerId, String title);
}
