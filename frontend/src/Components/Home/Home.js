import {Link, Redirect, Route} from 'react-router-dom'
import React from 'react';
import Mealplans from '../Mealplans/Mealplans';
import AddRecipe from '../Home/images/AddRecipe.png'
import RecipeBook from '../Home/images/RecipeBook.png'
// import ShoppingList from '../Home/images/ShoppingList.png'
import WeeklyPlanner from '../Home/images/WeeklyPlanner.png'
import '../Home/Home.css'
import jwt_decode from "jwt-decode";

export default function Home(props) {



    let token = props.token;
    let decoded = jwt_decode(token);
    console.log(decoded)

    

    

    //let myobj = JSON.parse(decoded);
    //console.log(myobj)



    return(
        <body>
            <section>
                <div class="color"></div>
                <div class="color"></div>
                <div class="color"></div>
                
                <div class="box">
                    <div class="form">
                       <form>
                           <div class="link-container">  
                                <div class="token">
                                    {decoded.auth === 'ROLE_USER'?  
                                    <div class="token-li">
                                        <ul>
                                            <li>You are a {decoded.auth}</li>
                                            <li>Your token is</li>
                                            <li>{token}</li>
                                            <li>You are a not a admin</li>
                                        </ul>
                                    </div>
                                    :
                                    <div>
                                        
                                        Welcome {decoded.sub}
                                        You are a {decoded.auth}
                                        You are a administrator
                                    </div>

                                    }

                                </div>
                                 <div className="home-button-group" >
                                    <Link to='/create'>
                                    <img className="home-button-image" src={AddRecipe} alt="add-recipe" />
                                    </Link>
                                    <p className="home-button-title" >Add <br />Recipe</p>
                                 </div>
                                 <div className="home-button-group" >
                                    <Link to='/'>
                                    <img className="home-button-image" src={RecipeBook} alt="add-recipe" />
                                    </Link>
                                    <p className="home-button-title" >Recipe <br />Book</p>
                                </div>
                                <div className="home-button-group" >
                                    <Link to='/mealplanner'>
                                    <img className="home-button-image" src={WeeklyPlanner} alt="add-recipe" />
                                    </Link>
                                    <p className="home-button-title" >Weekly <br />Planner</p>
                                </div>
                                 {/* <div className="home-button-group" >
                                    <Link to='/shopping-list'>
                                    <img className="home-button-image" src={ShoppingList} alt="add-recipe" />
                                    </Link>
                                    <p className="home-button-title" >Shopping <br />List</p>
                                </div> */}

                                    {/* <button id= "add-recipe" type='button' onClick={<Redirect to='/addrecipe'/>}>Add Recipe</button>
                                    <button id= "recipe-book" type='button' onClick={("/recipebook")}>Recipe Book</button>
                                    <button id= "weekly-planner" type='button' onClick={(props.MealPlanner)}>Weekly Planner</button>
                                    <button id= "shopping-list" type='button' onClick={("/shopping-list")}>Shopping List</button> */}
                                </div>
                            </form>
                        </div>
                </div>
            </section>
             
        </body>
    )
}