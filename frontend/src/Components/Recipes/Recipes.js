import React, { useEffect, useState } from "react"
import RecipeForm from "../RecipeForm/RecipeForm"
import RecipesListView from "../RecipesListView/RecipesListView"


export default function Recipes() {

    // const [data, setData] = React.useState([])
    const [recipeCollection, setRecipeCollection] = useState([])
    // const [url, setUrl] = useState('http://localhost:3000/recipes')

    //can not directly make first async
    useEffect(() => {
        fetch('http://localhost:3000/recipes')
            .then(response => response.json())
            .then(json => setRecipeCollection(json))
    }, [])

    console.log(recipeCollection)


    const addRecipe = (recipe) => {
        setRecipeCollection((prevCollection) => {
            return [...prevCollection, recipe]

        })
    }

    const handleClick = (id) => {
        setRecipeCollection(prevEvents => {
            return prevEvents.filter(event => id !== event.id)
        })
    }

    // var query = 'italian wedding soup'
    // const url = 'https://api.api-ninjas.com/v1/recipe?query=' + query


    // const table = sampleRecipes.map((values, i) => {
    //     return (
    //         <tr key={i}>
    //             <td>{values.title}</td>
    //             <td>{values.ingredients}</td>
    //             <td>{values.servings}</td>
    //             <td>{values.instructions}</td>
    //         </tr>
    //     )
    // })

    return (
        <>
            <h1>My Recipes</h1>
            <RecipesListView events={recipeCollection} handleClick={handleClick} />
            {/* {table} */}
            <button>Pop Up For New Recipe</button>
            <RecipeForm addRecipe={addRecipe} />
            <button>Create Meal Plan</button>

        </>

    )
}