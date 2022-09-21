import {Link, Redirect, Route} from 'react-router-dom'
import React from 'react';
import MealPlanner from './HomeComponents/MealPlanner'
// import jwt_decode from 'jwt-decode'
import AddRecipe from '../Home/images/AddRecipe.png'
import RecipeBook from '../Home/images/RecipeBook.png'
import ShoppingList from '../Home/images/ShoppingList.png'
import WeeklyPlanner from '../Home/images/WeeklyPlanner.png'
export default function Home(props) {


    return(
        <body>
            <header>
                <h1>Merit This Homepage</h1>
            </header>
            <section>
                <div class="color"></div>
                <div class="color"></div>
                <div class="color"></div>
                <div class="box">
                    <div class="container">
                        <div class="form">
                            <form>
                                <div class="directory-box">  
                                <Link to='/addrecipe'><img src={AddRecipe} alt="add-recipe" /></Link>
                                <Link to='/recipebook'><img src={RecipeBook} alt="add-recipe" /></Link>
                                <Link to='/weekly-planner'><img src={WeeklyPlanner} alt="add-recipe" /></Link>
                                <Link to='/shopping-list'><img src={ShoppingList} alt="add-recipe" /></Link>

                                    <button id= "add-recipe" type='button' onClick={<Redirect to='/addrecipe'/>}>Add Recipe</button>
                                    <button id= "recipe-book" type='button' onClick={("/recipebook")}>Recipe Book</button>
                                    <button id= "weekly-planner" type='button' onClick={(props.MealPlanner)}>Weekly Planner</button>
                                    <button id= "shopping-list" type='button' onClick={("/shopping-list")}>Shopping List</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
             
        </body>
    )
}