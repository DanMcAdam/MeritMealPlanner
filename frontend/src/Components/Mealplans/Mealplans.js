import React, {useState, useEffect, useMemo} from "react";
import MealPlannerService from "./MealPlannerService";
import './Mealplans.css'
import { nanoid } from 'nanoid'

export default function Mealplans({}){

    
    const PlannerApi = [
        {
            name: "planner", 
            url: "http://localhost:5000/api/planner"
        },
        {
            name: "recipe", 
            url: "http://localhost:5000/api/recipes"
          },
    ]

    const [recipesInPlannerList, setrecipesInPlannerList] = useState([]);
    const [recipeBookList, setRecipeBookList] = useState([]);
    const [plannerDBList, setPlannerDBList] = useState([]);
    const [filteredRecipeBookList, setFilteredRecipeBookList] = useState([]);
    const [wordEntered, setWordEntered] = useState("");

    useEffect(() => {
        loadAllRecipes(PlannerApi[1].url);
    },[]);

    const loadAllRecipesInPlanner = (url, allRecipes) => {
        fetch(url)
            .then(result => result.json())
            .then(response => {
                const allRecipesInPlanner = allRecipes
                    .filter(r => response.some(p => p.recipeId === r._id));
                setrecipesInPlannerList(allRecipesInPlanner);
                setPlannerDBList(response);
                setRecipeBookList(allRecipes);
                setFilteredRecipeBookList(allRecipes);
            });
    };

    const loadAllRecipes = url => {
        fetch(url)
            .then(result => result.json())
            .then(async (allRecipes) => {
                await loadAllRecipesInPlanner(PlannerApi[0].url, allRecipes);
            })
    };

	const recipesSearchList = filteredRecipeBookList?.map(recipe=>{
            const handleAdding = ()=> {
                MealPlannerService.create(recipe)
                .then(savedRecipe => setrecipesInPlannerList([...recipesInPlannerList, savedRecipe]))
            } 
            return(
                <div className="planner-recipe-group" key={recipe._id}>
                    <div className="planner-recipe">
                        <img className="image" src={recipe.image}/>
                        <p>{recipe.name}</p>
                        <button className="planner-button-add" onClick={handleAdding} width="25px"/>
                    </div>
                </div>
            )
        });    

    const handleFilter = (event) => {
        const searchWord = event.target.value;
        setWordEntered(searchWord);
        if (searchWord === "") {
            setFilteredRecipeBookList(recipeBookList);
        } else {
            setFilteredRecipeBookList(recipeBookList.filter((value) => {
                return value.name.toLowerCase().includes(searchWord.toLowerCase())
            }));
        }
    };

    const clearInput = () => {
        setWordEntered("");
        setFilteredRecipeBookList(recipeBookList);
    };
        
    const displayrecipesInPlannerList= useMemo(() => recipesInPlannerList?.map(recipe=>{

        const recipeId = recipe._id;

        const handleImageClick = ()=>{
            window.location.href = "/recipebook/" + recipe._id
        }

        return(
            <div className="button-group" key={ nanoid() }>
                <img onClick = {handleImageClick} className="button-image" src={recipe.image} width="100px"/>
                <p className="button-text">{recipe.name}</p>
                <img className="planner-button-delete"
                onClick={()=>{
                    alert({
                        title: "Are you sure?",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true,
                        buttons: ['No!', 'Yes..'],
                        className: "swal-sure"
                    })
                    .then((willDelete) => {
                        if (willDelete) {
                            const plannerId = plannerDBList.find(p => p.recipeId === recipe._id)._id;
                            MealPlannerService.delete(plannerId).then(() => {
                                var array = [...recipesInPlannerList]; 
                                var index = array.indexOf(recipe)
                                if (index !== -1) {
                                    array.splice(index, 1);
                                    setrecipesInPlannerList(array);
                                }
                                });
                          alert("Recipe deleted!", {
                            icon: "error",
                            timer: 1500,
                            buttons: false,
                            className: "swal-delete"
                          });
                      }});;
                }} 
                src="https://findicons.com/files/icons/1262/amora/256/delete.png" width="25px"/>
            </div>
    )}), [recipesInPlannerList, plannerDBList]);

    return(
        <section>
                <div class="color"></div>
                <div class="color"></div>
                <div class="color"></div>
                <div class="box">
                        <div class="form">
                                <div>
                                    <div className="planner-overall-container">
                                        <div className="search">
                                            <div className="searchInput">
                                                <input onChange = {handleFilter}
                                                    type="text" 
                                                    value={wordEntered}
                                                    placeholder="Enter a recipe to search ..." /><button id = "clear-button" onClick={clearInput}>X</button>
                                            </div>
                                        
                                            <div className="data-result">
                                            {recipesSearchList}
                                            </div>
                                        </div>

                                        <div className="planner-overall">
                                            <h1 className="planner-pagetitle">Planner</h1>
                                            <div className="planner-link-container">
                                                {displayrecipesInPlannerList}
                                            </div>
                                        </div>

                                    </div>
                                </div>
                    </div>
            </div>
        </section>
    )
};