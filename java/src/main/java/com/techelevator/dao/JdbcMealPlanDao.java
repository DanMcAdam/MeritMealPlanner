package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techelevator.model.MealPlan;

import java.util.List;
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


       return jdbcTemplate.queryForObject("select plan_id from meal_plan where owner_id = ?", int.class, ownerId);
       //need to get a array of all plans with the owner
    }

    @Override
    public int getOwnerId(Long ownerId) {
        return jdbcTemplate.queryForObject("select owner_id from meal_plan where owner_id = ?", int.class, ownerId);
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
    public boolean createPlan(Long planId, Long ownerId, String title) {
        return false;
    }
}
